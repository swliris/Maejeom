package com.limsungwoo.maejeom;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {

    ListView listView;
    public static Activity status;

    Button ipgo, chulgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        status = this;

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom_actionbar_status);
        } catch (Exception e) {
            Log.e("actionbar", "Action Bar Error");
        }

        listView = findViewById(R.id.status_list);
        ipgo = findViewById(R.id.btn_status_ipgo);
        chulgo = findViewById(R.id.btn_status_chulgo);

        ArrayList<Maejeom> datas = new ArrayList<>();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String selectSQL = "select * from tb_maejeom";
        Cursor cursor = db.rawQuery(selectSQL, null);

        while (cursor.moveToNext()) {
            Maejeom maejeom = new Maejeom();
            maejeom.name = cursor.getString(0);
            maejeom.cost = cursor.getInt(1);
            maejeom.status = cursor.getInt(2);
            datas.add(maejeom);
        }

        db.close();

        MaejeomStatusAdapter adapter = new MaejeomStatusAdapter(this, R.layout.status_list_item, datas);

        listView.setAdapter(adapter);

        ipgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), IpgoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        chulgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ChulgoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
