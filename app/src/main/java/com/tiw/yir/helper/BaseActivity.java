package com.tiw.yir.helper;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.tiw.yir.R;


public abstract class BaseActivity extends AppCompatActivity {

//    public Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
//        }
    }

    protected abstract int getLayoutResource();

    protected void setActionBarIcon(int iconRes) {
//        toolbar.setNavigationIcon(iconRes);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}