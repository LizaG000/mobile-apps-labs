package com.linearlayout;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import android.graphics.Paint;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox checkBox1 = findViewById(R.id.ch1);
        TextView textView1 = findViewById(R.id.te1);

        CheckBox checkBox2 = findViewById(R.id.ch2);
        TextView textView2 = findViewById(R.id.te2);

        CheckBox checkBox3 = findViewById(R.id.ch3);
        TextView textView3 = findViewById(R.id.te3);

        CheckBox checkBox4 = findViewById(R.id.ch4);
        TextView textView4 = findViewById(R.id.te4);

        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView1.setPaintFlags(textView1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                textView1.setPaintFlags(textView1.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView2.setPaintFlags(textView2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                textView2.setPaintFlags(textView2.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView3.setPaintFlags(textView3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                textView3.setPaintFlags(textView3.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        checkBox4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView4.setPaintFlags(textView4.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                textView4.setPaintFlags(textView4.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });
    }
}
