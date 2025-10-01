package com.resources;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import androidx.core.content.res.ResourcesCompat;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.Locale;
import android.content.Intent;
import android.content.res.Configuration;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.my_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = findViewById(R.id.root);
        int itId = item.getItemId();

        if (itId == R.id.pink) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
            return true;
        } else if (itId == R.id.lilac) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lilac));
            return true;
        } else if (itId == R.id.beige) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.beige));
            return true;
        } else if (itId == R.id.frog) {
            mylayout.setBackgroundResource(R.drawable.background);;
            return true;
        } else if (itId == R.id.ru) {
            setLocale("ru");
            return true;
        } else if (itId == R.id.en) {
            setLocale("en");
            return true;
        } else if (itId == R.id.horizontal) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            return true;
        } else if (itId == R.id.vertical) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            return true;
        } else if (itId == R.id.ab) {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.andy_bold);
            textView.setTypeface(typeface);
            return true;
        } else if (itId == R.id.al) {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.alphabet_lore);
            textView.setTypeface(typeface);
            return true;
        } else if (itId == R.id.e) {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.egyptian);
            textView.setTypeface(typeface);
            return true;
        } else if (itId == R.id.ts) {
            Typeface typeface = ResourcesCompat.getFont(this, R.font.twinkle_star);
            textView.setTypeface(typeface);
            return true;
        } else if (itId == R.id.exit) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Configuration conf = getResources().getConfiguration();

        conf.setLocale(myLocale);
        createConfigurationContext(conf);

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

}
