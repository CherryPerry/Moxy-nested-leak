package ru.cherryperry.moxyleak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (savedInstanceState == null) showSimple();
    }

    public void showSimple() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ButtonFragment())
                .commit();
    }

    public void showViewPager() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new ViewPagerFragment())
                .commit();
    }

    public void switchFragment() {
        if (getSupportFragmentManager().findFragmentById(R.id.content) instanceof ViewPagerFragment)
            showSimple();
        else
            showViewPager();
    }
}
