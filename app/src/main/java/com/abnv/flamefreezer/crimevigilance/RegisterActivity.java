package com.abnv.flamefreezer.crimevigilance;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar tb= (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(tb);
        final ActionBar ab = getSupportActionBar();
        if(ab!=null){
            ab.setDisplayShowHomeEnabled(true);
            ab.setDisplayShowCustomEnabled(true);
        }
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
    public void onClickTextView(View view){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
    public void onClickButton(View view){
        Toast.makeText(RegisterActivity.this,"Account Successfully Created",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        if(item.getItemId()==R.id.menu_main_Exit)
            finishAffinity();
        return super.onOptionsItemSelected(item);

    }
}
