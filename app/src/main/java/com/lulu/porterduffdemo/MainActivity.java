package com.lulu.porterduffdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = ((LinearLayout) findViewById(R.id.container));

        container.addView(generatePorterDuffImage("SRC", PorterDuff.Mode.SRC));
        container.addView(generatePorterDuffImage("DST", PorterDuff.Mode.DST));
        container.addView(generatePorterDuffImage("CLEAR", PorterDuff.Mode.CLEAR));
        container.addView(generatePorterDuffImage("DARKEN", PorterDuff.Mode.DARKEN));
        container.addView(generatePorterDuffImage("DST_ATOP", PorterDuff.Mode.DST_ATOP));
        container.addView(generatePorterDuffImage("DST_IN", PorterDuff.Mode.DST_IN));
        container.addView(generatePorterDuffImage("DST_OUT", PorterDuff.Mode.DST_OUT));
        container.addView(generatePorterDuffImage("DST_OVER", PorterDuff.Mode.DST_OVER));
        container.addView(generatePorterDuffImage("LIGHTEN", PorterDuff.Mode.LIGHTEN));
        container.addView(generatePorterDuffImage("MULTIPLY", PorterDuff.Mode.MULTIPLY));
        container.addView(generatePorterDuffImage("OVERLAY", PorterDuff.Mode.OVERLAY));
        container.addView(generatePorterDuffImage("SCREEN", PorterDuff.Mode.SCREEN));
        container.addView(generatePorterDuffImage("SRC_ATOP", PorterDuff.Mode.SRC_ATOP));
        container.addView(generatePorterDuffImage("SRC_IN", PorterDuff.Mode.SRC_IN));
        container.addView(generatePorterDuffImage("SRC_OUT", PorterDuff.Mode.SRC_OUT));
        container.addView(generatePorterDuffImage("SRC_OVER", PorterDuff.Mode.SRC_OVER));
        container.addView(generatePorterDuffImage("XOR", PorterDuff.Mode.XOR));

    }

    private View generatePorterDuffImage(String modeStr, PorterDuff.Mode mode) {
        View itemView = LayoutInflater.from(this).inflate(R.layout.item, null, false);
        TextView tvMode = itemView.findViewById(R.id.mode);
        PorterDuffView pdv = (PorterDuffView)itemView.findViewById(R.id.porter_duff_view);
        pdv.setPdMode(mode);
        tvMode.setText(modeStr);
        return itemView;
    }
}
