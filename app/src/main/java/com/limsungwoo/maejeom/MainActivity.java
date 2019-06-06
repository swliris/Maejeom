package com.limsungwoo.maejeom;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIpgo, btnChulgo, btnSell, btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        } catch (Exception e) {
            Log.e("actionbar", "Action Bar Error");
        }

        btnIpgo = findViewById(R.id.btn_ipgo);
        btnChulgo = findViewById(R.id.btn_chulgo);
        btnSell = findViewById(R.id.btn_sell);
        btnStatus = findViewById(R.id.btn_status);

        btnIpgo.setOnClickListener(this);
        btnChulgo.setOnClickListener(this);
        btnSell.setOnClickListener(this);
        btnStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_ipgo:
                intent = new Intent(getBaseContext(), IpgoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_chulgo:
                intent = new Intent(getBaseContext(), ChulgoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sell:
                intent = new Intent(getBaseContext(), SellActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_status:
                intent = new Intent(getBaseContext(), StatusActivity.class);
                startActivity(intent);
                break;
        }
    }
}
