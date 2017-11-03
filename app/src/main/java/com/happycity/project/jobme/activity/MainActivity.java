package com.happycity.project.jobme.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.happycity.project.jobme.R;
import com.happycity.project.jobme.fragment.FeedbackFragment;
import com.happycity.project.jobme.fragment.HistoryFragment;
import com.happycity.project.jobme.fragment.JobsFragment;
import com.happycity.project.jobme.fragment.MessageFragment;
import com.happycity.project.jobme.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        JobsFragment.OnFragmentInteractionListener,
        HistoryFragment.OnFragmentInteractionListener,
        FeedbackFragment.OnFragmentInteractionListener,
        MessageFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addNavigationBottomMain();
    }

    private void addNavigationBottomMain() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayoutMain, JobsFragment.newInstant());
        fragmentTransaction.commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationMain);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.job_bottom:
                        fragment = JobsFragment.newInstant();
                        break;
                    case R.id.profile_bottom:
                        fragment = ProfileFragment.newInstance();
                        break;
                    case R.id.chat_bottom:
                        fragment = MessageFragment.newInstance();
                        break;
                    case R.id.feedback_bottom:
                        fragment = FeedbackFragment.newInstance();
                        break;
                    case R.id.history_bottom:
                        fragment = HistoryFragment.newInstant();
                        break;
                }
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentLayoutMain, fragment);
                    fragmentTransaction.commit();
                }
                return true;

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.give_feedback) {
            // Handle the camera action
        }
        if(id == R.id.logout){

        }
        if(id == R.id.notification){

        }
        if(id == R.id.privacy_policy){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
