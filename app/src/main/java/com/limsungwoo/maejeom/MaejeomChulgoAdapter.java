package com.limsungwoo.maejeom;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MaejeomChulgoAdapter extends ArrayAdapter<Maejeom> {

    Context context;
    int layoutId;
    ArrayList<Maejeom> datas;

    public MaejeomChulgoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Maejeom> objects) {
        super(context, resource, objects);
        this.context = context;
        layoutId = resource;
        datas = objects;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            // 1 item.xml inflation -> 메모리에 객체화
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chulgo_list_item, null);

            // 2 객체 찾아오기 (Holder 사용)
            MaejeomChulgoHolder holder = new MaejeomChulgoHolder(convertView);
            convertView.setTag(holder);
        }

        final MaejeomChulgoHolder holder = (MaejeomChulgoHolder) convertView.getTag();

        final Maejeom maejeomChulgoItem = datas.get(position);

        holder.name.setText(maejeomChulgoItem.name);
        holder.cost.setText(""+maejeomChulgoItem.cost);
        holder.status.setText(""+maejeomChulgoItem.status);

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = new DBHelper(getContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                int currentStatus = Integer.parseInt(""+holder.status.getText());
                int minusStatus = Integer.parseInt(""+holder.num.getText().toString());

                String minusSQL = "UPDATE tb_maejeom SET status = " + (currentStatus-minusStatus) + " WHERE name = '" + holder.name.getText().toString() + "'";
                db.execSQL(minusSQL);

                if(Integer.parseInt("" + holder.status.getText().toString()) <= 0) {
                    String delSQL = "DELETE FROM tb_maejeom WHERE name = '" + holder.name.getText().toString() + "'";
                    db.execSQL(delSQL);
                }

                Intent intent = new Intent(getContext(), ChulgoActivity.class);
                context.startActivity(intent);
                ChulgoActivity.chulgo.finish();

                db.close();
            }
        });

        return convertView;
    }
}
