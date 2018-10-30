package cs.dal.easymeeting;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        HostFragment.OnFragmentInteractionListener,
        AnalyticsFragment.OnFragmentInteractionListener{

    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Meeting Schedule");
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D74E09")));
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_host:
                    toolbar.setTitle("Meeting Manager");
                    loadFragment(new HostFragment());
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#424242")));
                    return true;
                case R.id.navigation_analytics:
                    toolbar.setTitle("Analytics");
                    toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D74E09")));
                    loadFragment(new AnalyticsFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Meeting Schedule");
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D74E09")));
        loadFragment(new HomeFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent intent = new Intent(this, LoginActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                return true;

            case R.id.item_a:
                return true;

            case R.id.item_b:
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
