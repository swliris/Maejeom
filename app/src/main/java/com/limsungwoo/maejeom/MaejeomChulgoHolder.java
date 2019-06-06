package com.limsungwoo.maejeom;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MaejeomChulgoHolder {

    TextView name, cost, status;
    EditText num;
    Button minus;

    MaejeomChulgoHolder(View v) {
        name = v.findViewById(R.id.text_chulgo_name);
        cost = v.findViewById(R.id.text_chulgo_cost);
        status = v.findViewById(R.id.text_chulgo_status);
        num = v.findViewById(R.id.edit_chulgo_num);
        minus = v.findViewById(R.id.btn_chulgo_minus);
    }

}
