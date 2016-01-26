package hr.foi.air.webshopapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;


import com.activeandroid.ActiveAndroid;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.dbmodule.product;
import hr.foi.air.webshopapp.fragmenti.FragmentDrawer;
import hr.foi.air.webshopapp.fragmenti.FragmentKatalog;
import hr.foi.air.webshopapp.fragmenti.FragmentKosarica;
import hr.foi.air.webshopapp.fragmenti.FragmentMain;
import hr.foi.air.webshopapp.fragmenti.FragmentNarudzbe;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    public static final String JSON_URL = "http://webshopappfoi.esy.es/volleyGetProducts.php";
    SharedPreferences productsLocal;
    public static final String Products = "productsKey";


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

        sendSyncRequest();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        SharedPreferences sessionMan = getBaseContext().getSharedPreferences("SessionManager", MODE_PRIVATE);
        String sessionLogged = sessionMan.getString("userNameKey", null);

        if(id==R.id.login_icon){
            if (sessionLogged == null) {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(this, UserProfileActivity.class);
                startActivity(intent);
            }
        }
        if(id==R.id.search_icon){
            Intent intent = new Intent(this, ProductDetailsActivity.class);
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

    private void sendSyncRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        product product = new product();
                        product.UpdateProducts(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}