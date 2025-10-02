package com.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import android.content.pm.ActivityInfo;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private LinearLayout mylayout;
    private String background_previous = "background";
    private String currentLanguage = "default";


    private static final Map<Integer, Integer> menuMap = new HashMap<>();
    static {
        menuMap.put(R.id.color, R.string.color);
        menuMap.put(R.id.lilac, R.string.lilac);
        menuMap.put(R.id.pink, R.string.pink);
        menuMap.put(R.id.beige, R.string.beige);
        menuMap.put(R.id.frog, R.string.frog);
        menuMap.put(R.id.font, R.string.font);
        menuMap.put(R.id.al, R.string.al);
        menuMap.put(R.id.ab, R.string.ab);
        menuMap.put(R.id.e, R.string.e);
        menuMap.put(R.id.ts, R.string.ts);
        menuMap.put(R.id.language, R.string.language);
        menuMap.put(R.id.ru, R.string.ru);
        menuMap.put(R.id.en, R.string.en);
        menuMap.put(R.id.orientation, R.string.orientation);
        menuMap.put(R.id.vertical, R.string.vertical);
        menuMap.put(R.id.horizontal, R.string.horizontal);
        menuMap.put(R.id.exit, R.string.exit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.my_text);
        mylayout = findViewById(R.id.root);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);


        Context context = LocaleHelper.setLocale(this, currentLanguage);
        updateMenuTitles(menu, context);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itId = item.getItemId();


        if (itId == R.id.pink) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
            background_previous = "pink";
            return true;
        } else if (itId == R.id.lilac) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lilac));
            background_previous = "lilac";
            return true;
        } else if (itId == R.id.beige) {
            mylayout.setBackgroundColor(ContextCompat.getColor(this, R.color.beige));
            background_previous = "beige";
            return true;
        } else if (itId == R.id.frog) {
            if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
                background_previous = "background_h";
                mylayout.setBackgroundResource(R.drawable.background_h);
            } else {
                background_previous = "background";
                mylayout.setBackgroundResource(R.drawable.background);
            }
            return true;
        }


        else if (itId == R.id.ru) {
            currentLanguage = "ru";
            applyLanguage();
            return true;
        } else if (itId == R.id.en) {
            currentLanguage = "en";
            applyLanguage();
            return true;
        }


        else if (itId == R.id.horizontal) {
            if (background_previous.equals("background")) {
                mylayout.setBackgroundResource(R.drawable.background_h);
                background_previous = "background_h";
            }
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            return true;
        } else if (itId == R.id.vertical) {
            if (background_previous.equals("background_h")) {
                mylayout.setBackgroundResource(R.drawable.background);
                background_previous = "background";
            }
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            return true;
        }


        else if (itId == R.id.ab) {
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
        }

        else if (itId == R.id.exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void applyLanguage() {
        Context context = LocaleHelper.setLocale(this, currentLanguage);
        Resources res = context.getResources();

        // TextView
        textView.setText(res.getString(R.string.text));

        // Меню
        invalidateOptionsMenu(); // вызовет onCreateOptionsMenu → обновятся заголовки
    }

    private void updateMenuTitles(Menu menu, Context context) {
        Resources res = context.getResources();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (menuMap.containsKey(item.getItemId())) {
                item.setTitle(res.getString(menuMap.get(item.getItemId())));
            }
            if (item.hasSubMenu()) {
                updateMenuTitles(item.getSubMenu(), context);
            }
        }
    }
}
