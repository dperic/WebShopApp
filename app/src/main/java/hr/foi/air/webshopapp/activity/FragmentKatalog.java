package hr.foi.air.webshopapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.activeandroid.query.Select;

import java.util.List;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.dbmodule.Products;

public class FragmentKatalog extends Fragment implements View.OnClickListener {

    EditText nazivEditText;
    Button spremiButton;
    Button prikažiButton;
    Button osvježiButton;

    public FragmentKatalog() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_katalog, container, false);
        nazivEditText = (EditText) rootView.findViewById(R.id.nazivtext);
        spremiButton = (Button) rootView.findViewById(R.id.spremibtn);
        spremiButton.setOnClickListener(this);
        prikažiButton = (Button) rootView.findViewById(R.id.prikažibtn);
        prikažiButton.setOnClickListener(this);
        osvježiButton = (Button) rootView.findViewById(R.id.osvježibtn);
        osvježiButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spremibtn:
                Products.UpdateProducts(nazivEditText.getText().toString());
                Toast.makeText(this.getActivity(),
                    "Spremljeno", Toast.LENGTH_SHORT).show();
                break;

            case R.id.osvježibtn: {
                Select select = new Select();
                List<Products> proizvodi = select.all().from(Products.class).execute();
                for (Products products : proizvodi){
                    products.delete();
                }
                Toast.makeText(this.getActivity(),
                        "Osvježeno", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.prikažibtn:{
                Select select = new Select();
                List<Products> proizvodi = select.all().from(Products.class).execute();
                StringBuilder builder = new StringBuilder();
                for (Products products : proizvodi) {
                    builder.append("Datum: ")
                            .append(products.datum_dodavanja)
                            .append("\n");
                    Toast.makeText(this.getActivity(), builder.toString(), Toast.LENGTH_SHORT).show();
                    break;
                }}
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}