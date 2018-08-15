package com.abnv.flamefreezer.crimevigilance;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Crimes Around You",
            "Missing Persons",
            "Login",
    };
    Integer[] ext={
            R.color.transparent,
            R.color.transparent,
            R.drawable.pic4
    };
    Integer[] imgid={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb= (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(tb);
        final ActionBar ab = getSupportActionBar();
        if(ab!=null){
            ab.setDisplayShowHomeEnabled(true);
            ab.setDisplayShowCustomEnabled(true);
        }
      //  ab.setDisplayShowTitleEnabled(false);
        //ab.setDisplayHomeAsUpEnabled(true);
        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid, ext);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                if(position==0)
                    startActivity(new Intent(MainActivity.this, CrimesActivity.class));
                else if(position==1)
                    startActivity(new Intent(MainActivity.this, MissingPersonsActivity.class));
                else
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent2 = new Intent(MainActivity.this, AboutUs_Activity.class);
        if(item.getItemId()==R.id.menu_main_about)
            startActivity(intent2);
        if(item.getItemId()==R.id.menu_main_Exit)
            finishAffinity();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
