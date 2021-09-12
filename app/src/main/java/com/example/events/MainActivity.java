package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements CommunicationListner {
FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
      LaunchEventDetailsFragment();
    }

    private void LaunchEventDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.container,eventDetailsFragment,"EventDetailsFragment").commit();
    }


    @Override
    public void dataFromTimeDetails(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment fragment = new TimeAndDateFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.container,fragment,"TimeAndDateFragment").commit();
    }

    @Override
    public void dataFromPricePage(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment fragment = new PriceDetailsFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.container,fragment,"PriceDetailsFragment");
    }
}