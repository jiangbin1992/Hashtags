package com.tito.megahashtagsinsta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    DrawerLayout mDrawerLayout;
//    ActionBarDrawerToggle mToggle;
//    NavigationView mNavigationView;
    public static Context mContext;






    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
//        if (mToggle.onOptionsItemSelected(item))
//        {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_Layout_Main);
//        mNavigationView=findViewById(R.id.navigation_view);
        // Ads


        mContext=getApplicationContext();
//        mNavigationView.setNavigationItemSelectedListener(this);
//        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        Window window=getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportFragmentManager().beginTransaction().add(R.id.Container_FrameLayout,new FragmentAllHashtags()).commit();





    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.dashboard_drawer_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout, new FragmentAllHashtags()).addToBackStack(null).commit();
        } else if (itemId == R.id.about_us_drawer_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout, new FragmentAboutUs()).addToBackStack(null).commit();
        } else if (itemId == R.id.contact_us_drawer_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout, new FragmentContactUs()).addToBackStack(null).commit();
        } else if (itemId == R.id.privacy_policy_drawer_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout, new FragmentPrivacyPolicy()).addToBackStack(null).commit();
        } else if (itemId == R.id.share_drawer_menu) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=" + getPackageName());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
//        mDrawerLayout.closeDrawer(GravityCompat.START);



        return true;
    }



}
