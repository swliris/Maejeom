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
import java.util.List;

public class MaejeomStatusAdapter extends ArrayAdapter<Maejeom> {

    Context context;
    int layoutId;
    ArrayList<Maejeom> datas;

    public MaejeomStatusAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Maejeom> objects) {
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
            convertView = inflater.inflate(R.layout.status_list_item, null);

            // 2 객체 찾아오기 (Holder 사용)
            MaejeomStatusHolder holder = new MaejeomStatusHolder(convertView);
            convertView.setTag(holder);
        }

        final MaejeomStatusHolder holder = (MaejeomStatusHolder) convertView.getTag();

        final Maejeom maejeomStatusItem = datas.get(position);

        holder.name.setText(maejeomStatusItem.name);
        holder.cost.setText(""+maejeomStatusItem.cost);
        holder.status.setText(""+maejeomStatusItem.status);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = new DBHelper(getContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                String deleteSQL = "DELETE FROM tb_maejeom WHERE name = '" + holder.name.getText().toString() + "'";
                db.execSQL(deleteSQL);

                Intent intent = new Intent(getContext(), StatusActivity.class);
                context.startActivity(intent);
                StatusActivity.status.finish();

                db.close();
            }
        });

        return convertView;
    }
}
