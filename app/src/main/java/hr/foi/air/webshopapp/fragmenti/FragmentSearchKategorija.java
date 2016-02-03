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
import android.widget.CheckBox;

import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import hr.foi.air.webshopapp.R;

import hr.foi.air.webshopapp.SearchInterface;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;
import hr.foi.air.webshopapp.adapter.ListAdapter;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;


public class FragmentSearchKategorija extends Fragment implements View.OnClickListener, SearchInterface {
    private ListView listView;
    private ListAdapter adapter;
    private Button searchButton;
    private CheckBox checkBoxRacunala, checkBoxGrafickeKartice, checkBoxKuciste, checkBoxProcesor, checkBoxNapajanje, checkBoxRamMemorija, checkBoxMaticnaPloca;
    private hr.foi.air.webshopapp.dbmodule.dbTables.product product;
    private List<product> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_kategorija, container, false);

        product = new product();
        productList = product.getAllsearch();

        checkBoxRacunala = (CheckBox) rootView.findViewById(R.id.checkBoxRacunala);

        checkBoxGrafickeKartice = (CheckBox) rootView.findViewById(R.id.checkBoxGrafickeKartice);
        checkBoxKuciste = (CheckBox) rootView.findViewById(R.id.checkBoxKuciste);
        checkBoxProcesor = (CheckBox) rootView.findViewById(R.id.checkBoxProcesor);
        checkBoxNapajanje = (CheckBox) rootView.findViewById(R.id.checkBoxNapajanje);
        checkBoxRamMemorija = (CheckBox) rootView.findViewById(R.id.checkBoxRamMemorija);
        checkBoxMaticnaPloca = (CheckBox) rootView.findViewById(R.id.checkBoxMaticnaPloca);


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
        searchButton = (Button) rootView.findViewById(R.id.btnCheck);
        searchButton.setOnClickListener(this);
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
        if (checkBoxRacunala.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaRacunala));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxGrafickeKartice.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaGrafickeKartice));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxKuciste.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaKuciste));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxProcesor.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaProcesor));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxNapajanje.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaNapajanje));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxRamMemorija.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaRAMmemorija));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (checkBoxMaticnaPloca.isChecked()) {
            productList.clear();
            productList = product.searchKategorijaRacunala(getResources().getString(R.string.kategorijaMaticnaPloca));
            adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}