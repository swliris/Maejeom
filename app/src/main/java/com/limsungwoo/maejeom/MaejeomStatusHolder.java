package com.limsungwoo.maejeom;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MaejeomStatusHolder {

    TextView name, cost, status;
    Button delete;

    MaejeomStatusHolder(View v) {
        name = v.findViewById(R.id.text_status_name);
        cost = v.findViewById(R.id.text_status_cost);
        status = v.findViewById(R.id.text_status_status);
        delete = v.findViewById(R.id.btn_status_delete);
    }
}
