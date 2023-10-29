package com.aryan.javaminiproject.datathon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.aryan.javaminiproject.datathon.R;
import com.aryan.javaminiproject.datathon.fragments.ChatFragment;
import com.aryan.javaminiproject.datathon.fragments.HomePageFragment;
import com.aryan.javaminiproject.datathon.fragments.NetworkFragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class HomeScreen extends AppCompatActivity {
    private static final String ROOT_FRAGMENT_TAG = "root";
    private MeowBottomNavigation bottomNav;
    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Intent intent = getIntent();
        container = findViewById(R.id.container);

        bottomNav= findViewById(R.id.bottomNav);

        loadFragment(new HomePageFragment(),1);
        bottomNav.add(new MeowBottomNavigation.Model(1,R.drawable.coming_soon));
        bottomNav.add(new MeowBottomNavigation.Model(2,R.drawable.nav_home_icon));
        bottomNav.add(new MeowBottomNavigation.Model(3,R.drawable.nav_chat_icon));

        bottomNav.setOnClickMenuListener(model -> {
            switch (model.getId()){
                case 1:
                    loadFragment(new NetworkFragment(),0);
                    break;
                case 2:
                    loadFragment(new HomePageFragment(),0);
                    break;
                case 3:
                    loadFragment(new ChatFragment(),0);
                    break;

            }
            return null;
        });

    }

    public void  loadFragment(Fragment f , int value){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (value==1){
            ft.add(R.id.container,f);
            fm.popBackStack(ROOT_FRAGMENT_TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else{
            ft.replace(R.id.container,f);
            ft.addToBackStack(null);
        }
        ft.commit();
        int selectedItem = 0;
        if (f instanceof HomePageFragment) {
            selectedItem = 2; // Set to the second item (e.g., HomePageFragment)
        } else if (f instanceof ChatFragment) {
            selectedItem = 3; // Set to the third item (e.g., ChatFragment)
        } else if ( f instanceof NetworkFragment) {
            selectedItem = 1;
        }
        bottomNav.show(selectedItem, true);
    }
    public void switchToChatFragment(Bundle b) {
        ChatFragment chatFragment = new ChatFragment();
        chatFragment.setArguments(b);
        loadFragment(chatFragment, 0);
    }

    @Override
    public void onBackPressed() {
        // Handle the back button press
        FragmentManager fm = getSupportFragmentManager();
        int backStackCount = fm.getBackStackEntryCount();

        if (backStackCount > 0) {
            FragmentManager.BackStackEntry entry = fm.getBackStackEntryAt(backStackCount - 1);
            String fragmentTag = entry.getName();

            if (fragmentTag != null) {
                switch (fragmentTag) {
                    case "NetworkFragment":
                        bottomNav.show(1, true); // Show the first item
                        break;
                    case "HomePageFragment":
                        bottomNav.show(2, true); // Show the second item
                        break;
                    case "ChatFragment":
                        bottomNav.show(3, true); // Show the third item
                        break;
                    default:
                        break;
                }
            }
        }

        super.onBackPressed();
    }
}