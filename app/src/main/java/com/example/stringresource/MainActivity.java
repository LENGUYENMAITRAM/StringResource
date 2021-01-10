package com.example.stringresource;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_language_vn:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                setLocale("vn");
                break;
            case R.id.menu_language_en:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                setLocale("en");
                break;
            case R.id.menu_theme_default:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case R.id.menu_theme_night:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale( String language){
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        this.finish();
        this.startActivity(this.getIntent());
    }


}