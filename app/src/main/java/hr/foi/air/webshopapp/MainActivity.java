package hr.foi.air.webshopapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import hr.foi.air.webshopapp.dbmodule.UserTable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnUpdate;
    EditText imeUnos;
    Button btnrefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);
        btnUpdate = (Button) findViewById(R.id.btnDodaj);
        btnUpdate.setOnClickListener(this);
        imeUnos = (EditText) findViewById(R.id.editText);
        btnrefresh =  (Button) findViewById(R.id.btnRefresh);
        btnrefresh.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles menu item clicks by overriding extended method.
     * @param item Contains reference to the item that user clicked on.
     * @return True if event is handled correctly.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switch on item id.
        //Currently there are no actions to perform.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                break;
        }

        //Temporary shows message that click is handled.
        Toast.makeText(this, "Menu item " + item.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRefresh:
                break;

            case R.id.btnDodaj:
                UserTable.UpdateUser(imeUnos.getText().toString());
                break;
        }
    }
}