package com.service.parking.theparker.Controller.Activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.service.parking.theparker.Controller.Fragment.BookingFragment;
import com.service.parking.theparker.Controller.Fragment.PackagesFragment;
import com.service.parking.theparker.Controller.Fragment.PlacesFragment;
import com.service.parking.theparker.Controller.Fragment.OfferPlaceFragment;
import com.service.parking.theparker.Controller.Fragment.WalletFragment;
import com.service.parking.theparker.R;

public class StartActivity extends AppCompatActivity {

    FrameLayout fragmentFrame;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {

        Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.places_fragment:
                        fragment = new PlacesFragment();
                        break;

                    case R.id.packages_fragment:
                        fragment = new PackagesFragment();
                        break;

                    case R.id.bookings_fragment:
                        fragment = new BookingFragment();
                        break;

                    case R.id.wallet_fragment:
                        fragment = new WalletFragment();
                        break;

                    case R.id.offer_place_fragment:
                        fragment = new OfferPlaceFragment();
                        break;
                }
                return loadFragment(fragment);
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fragmentFrame = findViewById(R.id.framelayout);

        //TODO : Google Transition
        overridePendingTransition(0,0);

        BottomNavigationView navigation = findViewById(R.id.bottomNavView_Bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new PackagesFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framelayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}