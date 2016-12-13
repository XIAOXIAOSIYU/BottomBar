package com.jackzc.www.bottombar;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItems(R.menu.menu_main);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                switch (menuItemId) {
                    case R.id.bottom_bar_item_one: {
                        PeopleFragment people = new PeopleFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, people).commit();
                        break;
                    }
                    case R.id.bottom_bar_item_two: {
                        BusinessFragment business = new BusinessFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, business).commit();
                        break;
                    }
                    case R.id.bottom_bar_item_three: {
                        CompanyFragment company = new CompanyFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, company).commit();
                        break;
                    }
                    case R.id.bottom_bar_item_four: {
                        LogFragment log = new LogFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, log).commit();
                        break;
                    }
                    case R.id.bottom_bar_item_five: {
                        PendingFragment pending = new PendingFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, pending).commit();
                        break;
                    }
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottom_bar_item_one) {
                    Toast.makeText(MainActivity.this, "ReSelected", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }

}
