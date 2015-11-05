package hr.foi.air.webshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd;
    EditText txtBox;

    int majkemi;

    int dodajemnestostanecupulat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnDodaj);
        txtBox = (EditText) findViewById(R.id.editText);
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
