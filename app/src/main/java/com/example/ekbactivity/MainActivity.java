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


public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener {

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
                         

                        if (id == R.id.nav_news) {
                            frag(NewsFragment.newInstance());
                        }

                        if (id == R.id.nav_map) {
                            frag(MapFragment.newInstance());
                        }

                        if (id == R.id.nav_blank) {
                            frag(BlankFragment.newInstance(Color.BLUE));
                        }

                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

    }

    @Override
    public void mapFragmentButtonClick() {

        Fragment blankFragment = BlankFragment.newInstance(Color.GREEN);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container_for_fragment, blankFragment);
        transaction.addToBackStack(null);

        transaction.commit();

    }
}
