package com.limsungwoo.maejeom;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MaejeomSellHolder {

    TextView name, cost, status;
    Button minus, plus;

    MaejeomSellHolder(View v) {
        name = v.findViewById(R.id.text_sell_name);
        cost = v.findViewById(R.id.text_sell_cost);
        status = v.findViewById(R.id.text_sell_status);
        minus = v.findViewById(R.id.btn_sell_minus);
        plus = v. findViewById(R.id.btn_sell_plus);
    }

}
