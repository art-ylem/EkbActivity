package com.example.ekbactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener,
        NewsFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener,
        AccountFragment.OnFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;

    private void frag(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_for_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        int id = menuItem.getItemId();
                        switch (menuItem.getItemId()){
                            case R.id.nav_news:
                                frag(NewsFragment.newInstance());
                                break;
                            case R.id.nav_map:
                                frag(MapFragment.newInstance());
                                break;
                            case R.id.nav_blank:
                                frag(BlankFragment.newInstance(Color.BLUE));
                                break;
                            case R.id.nav_tools:
                                frag(ToolsFragment.newInstance());
                                break;
                            case R.id.nav_settings:
                                frag(SettingsFragment.newInstance());
                                break;
                            case R.id.nav_account:
                                frag(AccountFragment.newInstance());
                                break;
                        }

                        drawerLayout.closeDrawers();


                        return true;
                    }
                });

    }

    @Override
    public void onMapFragmentInteraction() {
        frag(BlankFragment.newInstance(Color.GREEN));
    }

    @Override
    public void onToolsFragmentInteraction() {
    }

    @Override
    public void onBlankFragmentInteraction() {
    }

    @Override
    public void onNewsFragmentInteraction() {
    }

    @Override
    public void onSettingsFragmentInteraction() {
    }

    @Override
    public void onAccountFragmentInteraction() {
    }
}
