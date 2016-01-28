package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.activity.MainActivity;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;
import hr.foi.air.webshopapp.adapter.ListAdapter;

import hr.foi.air.webshopapp.adapter.ListAdapterKosarica;
import hr.foi.air.webshopapp.dbmodule.dbOperations.OrderProducts;
import hr.foi.air.webshopapp.dbmodule.dbTables.productsInOrder;


public class FragmentKosarica extends Fragment implements View.OnClickListener{
    private Button btnOrder;
    SharedPreferences sharedPreferences;
    private ListView listView;
    private ListAdapterKosarica adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_kosarica));

        View rootView = inflater.inflate(R.layout.fragment_kosarica, container, false);
        productsInOrder productsInOrder = new productsInOrder();
        List<productsInOrder> productsInOrderList = productsInOrder.getAllproductsInOrder();

        listView = (ListView) rootView.findViewById(R.id.listKosarica);
        adapter = new ListAdapterKosarica(getActivity(), R.layout.list_row_kosarica, productsInOrderList);
        listView.setAdapter(adapter);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idd = (TextView) view.findViewById(R.id.nevidljivID);
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("remoteId", idd.getText().toString());
                startActivity(intent);
            }
        });*/
/*
        btnOrder = (Button) rootView.findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(this);
*/
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
        sharedPreferences = getActivity().getSharedPreferences("SessionManager", 0);
        final String userName = sharedPreferences.getString("userNameKey", "").toString().trim();
        if (userName != null) {
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            OrderProducts orderProducts = new OrderProducts();
            orderProducts.saveOrder(userName, requestQueue);
        }
        else {
            Toast.makeText(getActivity(), "Please login first!", Toast.LENGTH_LONG).show();
        }
    }
}
