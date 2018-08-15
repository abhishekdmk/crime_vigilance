package com.abnv.flamefreezer.crimevigilance;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.GONE;

public class CrimesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crimes);
        Toolbar tb= (Toolbar)findViewById(R.id.crimes_bar);
        setSupportActionBar(tb);
        final ActionBar ab = getSupportActionBar();
        if(ab!=null){
            ab.setDisplayShowHomeEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(CrimesActivity.this, MainActivity.class);
        if(item.getItemId()== android.R.id.home)
            startActivity(intent);
        if(item.getItemId()==R.id.menu_main_Exit)
            finishAffinity();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(CrimesActivity.this, MainActivity.class));
        finish();
    }
    public void onClick(View view){
        TextView mytext= (TextView)findViewById(R.id.textView2);
        EditText editText= (EditText)findViewById(R.id.editText5);
        ImageView img= (ImageView)findViewById(R.id.imageView2);
        mytext.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
    }
}
