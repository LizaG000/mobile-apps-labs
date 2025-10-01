package com.lab4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    // Компоненты
    private ImageButton imageButton;
    private TextView textView;
    private RadioButton radioButton1, radioButton2;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private ImageView imageView;
    private ToggleButton toggleButton;
    private List<TextView> allViews;

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


        // Инициализация компонентов
        imageButton = findViewById(R.id.image);
        textView = findViewById(R.id.text);
        radioButton1 = findViewById(R.id.r1);
        radioButton2 = findViewById(R.id.r2);
        checkBox1 = findViewById(R.id.ch1);
        checkBox2 = findViewById(R.id.ch2);
        checkBox3 = findViewById(R.id.ch3);
        imageView = findViewById(R.id.lamp);
        toggleButton = findViewById(R.id.tb);

        allViews = new ArrayList<>();
        allViews.add(textView);
        allViews.add(radioButton1);
        allViews.add(radioButton2);
        allViews.add(checkBox1);
        allViews.add(checkBox2);
        allViews.add(checkBox3);
        allViews.add(toggleButton);

        // Навешиваем обработчики
        imageButton.setOnClickListener(this);
        textView.setOnClickListener(this);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        imageView.setOnClickListener(this);
        toggleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.ch1 || but == R.id.ch2 || but == R.id.ch3) {
            applyTextStyle();
        }
        else if (but == R.id.r1) {
            if (radioButton1.isChecked()){
                for (TextView tv : allViews) {
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 14);
                    String text = tv.getText().toString();
                    tv.setAllCaps(true);
                    tv.setText(text.toLowerCase());
                }

                ViewGroup.LayoutParams imageButtonLayoutParams = imageButton.getLayoutParams();
                imageButtonLayoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
                imageButtonLayoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
                ViewGroup.LayoutParams imageViewLayoutParams = imageView.getLayoutParams();
                imageViewLayoutParams.height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72, getResources().getDisplayMetrics());;

            }
        }
        else if (but == R.id.r2) {
            if (radioButton2.isChecked()){
                for (TextView tv : allViews) {
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 8);
                    tv.setAllCaps(false);
                    String text = tv.getText().toString();
                    tv.setText(text.toLowerCase());
                }

                ViewGroup.LayoutParams imageButtonLayoutParams = imageButton.getLayoutParams();
                imageButtonLayoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
                imageButtonLayoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
                ViewGroup.LayoutParams imageViewLayoutParams = imageView.getLayoutParams();
                imageViewLayoutParams.height =  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());;
            }
        }
        else if (but == R.id.image){
            textView.setText("Глупенький,\nэто же картинка");
            textView.postDelayed(() -> {
                textView.setText("ЛОПНИ ПУЗЫРЬ");
            }, 5000);
        }
        else if (but == R.id.tb){
            if (toggleButton.isChecked()){
                imageView.setImageResource(R.drawable.on);
            }
            else{
                imageView.setImageResource(R.drawable.off);
                ViewGroup.LayoutParams imageViewLayoutParams = imageView.getLayoutParams();
            }
        }
    }


    private void applyTextStyle() {
        int style = Typeface.NORMAL;

        if (checkBox1.isChecked() && checkBox2.isChecked()) {
            style = Typeface.BOLD_ITALIC;
        } else if (checkBox1.isChecked()) {
            style = Typeface.BOLD;
        } else if (checkBox2.isChecked()) {
            style = Typeface.ITALIC;
        }

        for (TextView tv : allViews) {
            tv.setTypeface(tv.getTypeface(), style);

            if (checkBox3.isChecked()) {
                tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                tv.setPaintFlags(tv.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        }
    }
}
