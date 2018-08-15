package com.abnv.flamefreezer.crimevigilance;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.abnv.flamefreezer.crimevigilance.R.id.container;
import static com.abnv.flamefreezer.crimevigilance.R.id.item;
import static com.abnv.flamefreezer.crimevigilance.R.menu.navigation_menu;

public class LoggedInActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG= "LoggedInActivity";
    private SelectionPageAdapter mSelectionPageAdapter;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        mDrawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
      //  Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.navdrawer,this.getTheme());
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        setNavigationViewListner();
        Toolbar tb= (Toolbar) findViewById(R.id.appbar_loggedin);
        setSupportActionBar(tb);
        final ActionBar actionBar= getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME );
            ImageView imageButton = (ImageView) tb.findViewById(R.id.img_nav);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            });
        }

        mSelectionPageAdapter= new SelectionPageAdapter(getSupportFragmentManager());
        mViewPager= (ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout= (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId()==R.id.menu_main_Exit)
            finishAffinity();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_profile) {
            Intent profileIntent = new Intent(LoggedInActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
        } else if (id == R.id.menu_addcrime) {
            Intent addcrimeIntent = new Intent(LoggedInActivity.this, AddCrimeActivity.class);
            startActivity(addcrimeIntent);

        } else if (id == R.id.menu_addmssingperson) {
            Intent addmissingIntent = new Intent(LoggedInActivity.this, AddMissingPersonActivity.class);
            startActivity(addmissingIntent);

        } else if (id == R.id.menu_logout) {
            Intent logoutIntent= new Intent(LoggedInActivity.this,MainActivity.class);
            startActivity(logoutIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(Gravity.START);
        return true;
    }

    private void setupViewPager(ViewPager viewPager){
        SelectionPageAdapter adapter= new SelectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CrimesTab(),"Crimes");
        adapter.addFragment(new MissingPersonTab(),"Missing\nPersons");
        adapter.addFragment(new RecordsTab(),"Records");
        viewPager.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exit_menu, menu);
        return true;
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finishAffinity();
    }
}