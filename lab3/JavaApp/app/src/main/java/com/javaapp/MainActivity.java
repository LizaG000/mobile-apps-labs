package com.javaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatButton;
import java.util.Locale;
import android.util.Log;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private float mTextSize = 8;
    private EditText mEdit;
    private TextView tSize;
    private ImageButton buttonSans;
    private ImageButton buttonSer;
    private ImageButton buttonMn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = findViewById(R.id.edit_text);
        tSize = findViewById(R.id.size);

        ToggleButton buttonB = findViewById(R.id.button_b);
        ToggleButton buttonI = findViewById(R.id.button_i);
        buttonSer = findViewById(R.id.ser);
        buttonSans = findViewById(R.id.sana);
        buttonMn = findViewById(R.id.mn);
        AppCompatButton buttonMinus = findViewById(R.id.button_minus);
        AppCompatButton buttonPlus = findViewById(R.id.button_plus);

        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonSer.setOnClickListener(this);
        buttonSans.setOnClickListener(this);
        buttonMn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.button_b) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                        Typeface.NORMAL));
            else mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);

        } else if (but == R.id.button_i) {
            if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
            else if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                        Typeface.NORMAL));
            else mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);

        } else if (but == R.id.button_plus) {
            if (mTextSize <= 72)
                mTextSize += 2;
            mEdit.setTextSize(TypedValue.COMPLEX_UNIT_PT, mTextSize);
            tSize.setText(String.valueOf((int) mTextSize));

        } else if (but == R.id.button_minus) {
            if (mTextSize > 2)
                mTextSize -= 2;
            mEdit.setTextSize(TypedValue.COMPLEX_UNIT_PT, mTextSize);
            tSize.setText(String.valueOf((int) mTextSize));
        }
        else if (but == R.id.ser){
            buttonSans.setImageResource(R.drawable.radio_button_off);
            buttonMn.setImageResource(R.drawable.radio_button_off);
            buttonSer.setImageResource(R.drawable.radio_button_on);
            mEdit.setTypeface(Typeface.SERIF);

        }
        else if (but == R.id.sana){
            buttonSans.setImageResource(R.drawable.radio_button_on);
            buttonMn.setImageResource(R.drawable.radio_button_off);
            buttonSer.setImageResource(R.drawable.radio_button_off);
            mEdit.setTypeface(Typeface.SANS_SERIF);
        }
        else if (but == R.id.mn){
            buttonSans.setImageResource(R.drawable.radio_button_off);
            buttonMn.setImageResource(R.drawable.radio_button_on);
            buttonSer.setImageResource(R.drawable.radio_button_off);
            mEdit.setTypeface(Typeface.MONOSPACE);
        }
    }
}
