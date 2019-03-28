package com.example.ekbactivity.three_color;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ekbactivity.R;

public class ColorActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener, OrangeFragment.OnFragmentInteractionListener,  GreenFragment.OnFragmentInteractionListener{


    private void startFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerff,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        startFragment(RedFragment.newInstance());

    }

    @Override
    public void clickOnRedButton() {
        startFragment(OrangeFragment.newInstance());
    }

    @Override
    public void clickOnOrangeButton() {
        startFragment(GreenFragment.newInstance());
    }

    @Override
    public void onClickGreenBtn() {
        startFragment(RedFragment.newInstance());
    }
}
