package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.SearchInterface;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;
import hr.foi.air.webshopapp.adapter.ListAdapter;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;

public class FragmentSearchNaziv extends Fragment implements View.OnClickListener, SearchInterface{
    private ListView listView;
    private ListAdapter adapter;
    private Button searchButton;
    private EditText inputText;
    private hr.foi.air.webshopapp.dbmodule.dbTables.product product;
    private List<product> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_naziv, container, false);

        product = new product();
        productList = product.getAllsearch();

        searchButton = (Button) rootView.findViewById(R.id.btnSearch);
        searchButton.setOnClickListener(this);
        inputText = (EditText) rootView.findViewById(R.id.input_search);
        listView = (ListView) rootView.findViewById(R.id.list);
        adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idd = (TextView) view.findViewById(R.id.nevidljivID);
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("remoteId", idd.getText().toString());
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

    @Override
    public void onClick(View v) {
       search();
    }

    @Override
    public void search() {
        if (inputText.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Niste unijeli pojam", Toast.LENGTH_SHORT).show();
        } else {
            productList.clear();
            productList = product.searchrezultat(inputText.getText().toString());
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}