package com.limsungwoo.maejeom;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IpgoActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_name, edit_cost, edit_status;
    Button btn_cancel, btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipgo);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        } catch (Exception e) {
            Log.e("actionbar", "Action Bar Error");
        }

        edit_name = findViewById(R.id.edit_name);
        edit_cost = findViewById(R.id.edit_cost);
        edit_status = findViewById(R.id.edit_status);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_ok = findViewById(R.id.btn_ok);

        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_ok:
                DBHelper dbHelper = new DBHelper(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String name = edit_name.getText().toString();
                int cost = Integer.parseInt("" + edit_cost.getText());
                int status = Integer.parseInt("" + edit_status.getText());

                String insertSQL = "INSERT INTO tb_maejeom(name, cost, status) VALUES ('" + name + "', " + cost + ", " + status + ")";

                try {
                    db.execSQL(insertSQL);
                    Toast.makeText(this, "상품이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "상품 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                    Log.e("createTable", "insert failed");
                }

                db.close();

                break;
        }
    }
}