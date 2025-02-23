package com.haotsang.neteasecloudmusic.ui;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.haotsang.neteasecloudmusic.R;
import com.haotsang.neteasecloudmusic.ui.banner.BannerFragment;
import com.haotsang.neteasecloudmusic.ui.login.LoginWithQrcodeFragment;
import com.haotsang.neteasecloudmusic.ui.radio.RecommendRadioFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<Integer, Fragment> fragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fragments.put(R.id.item1, new LoginWithQrcodeFragment());
        fragments.put(R.id.item2, new RecommendRadioFragment());
        fragments.put(R.id.item3, new BannerFragment());

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            switchFragment(item.getItemId());
            return true;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        actionBarDrawerToggle.syncState();
    }




    private Fragment createFragment(Class<Fragment> clazz) {
        return null;
    }

    private void switchFragment(Integer menuItemId) {
        switchFragment(fragments.get(menuItemId));
    }

    private void switchFragment(Fragment targetFragment) {
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment != null && currentFragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().hide(currentFragment).commitAllowingStateLoss();
        }

        if (targetFragment != null) {
            if (targetFragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().show(targetFragment).commitAllowingStateLoss();
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.content_frame, targetFragment).commitAllowingStateLoss();
            }
        }
    }

    private Fragment getCurrentFragment() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null && fragment.isVisible()) {
                return fragment;
            }
        }

        return null;
    }
}
