package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.activity.MainActivity;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;
import hr.foi.air.webshopapp.adapter.ProductAdapter;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;

public class FragmentKatalog extends Fragment  {

    private ListView listView;
    private ProductAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_katalog));
        View rootView = inflater.inflate(R.layout.fragment_katalog, container, false);
        product product = new product();
        List<hr.foi.air.webshopapp.dbmodule.dbTables.product> vrijednostiLista = product.getAll();
        for (hr.foi.air.webshopapp.dbmodule.dbTables.product p : vrijednostiLista){
            Log.d("Ovo je name", p.getName());
        }
        listView = (ListView) rootView.findViewById(R.id.list2);
        adapter = new ProductAdapter(getActivity(), R.layout.list_row, vrijednostiLista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idd = (TextView) view.findViewById(R.id.nevidljivID);
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("remoteId", idd.getText().toString());
                Log.d("robi", idd.getText().toString());
                startActivity(intent);
            }
        });
        return rootView;
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