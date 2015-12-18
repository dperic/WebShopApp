package activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.activeandroid.ActiveAndroid;

import hr.foi.air.webshopapp.R;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{



    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);

        mToolbar=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        drawerFragment=(FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.login){
            Intent intent = new Intent(this, FragmentLogin.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);

    }


    private void displayView(int position) {


        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new FragmentMain();
                title = getString(R.string.app_name);
                break;
            case 1:
                fragment = new FragmentKatalog();
                title = getString(R.string.title_katalog);
                break;
            case 2:
                fragment = new FragmentKosarica();
                title=getString(R.string.title_kosarica);
                break;
            case 3:
                fragment = new FragmentNarudzbe();
                title = getString(R.string.title_narudzbe);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

    }



}