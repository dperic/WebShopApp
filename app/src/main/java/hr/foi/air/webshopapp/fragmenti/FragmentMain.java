package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.adapter.ListAdapter;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;


public class FragmentMain extends Fragment {

    private ListView listView;
    private ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        product product = new product();
        List<hr.foi.air.webshopapp.dbmodule.dbTables.product> productList = product.getAll();
        for (hr.foi.air.webshopapp.dbmodule.dbTables.product p : productList){
            Log.d("Ovo je name", p.getName());
        }
        listView = (ListView) rootView.findViewById(R.id.list);
        adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
        listView.setAdapter(adapter);
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


