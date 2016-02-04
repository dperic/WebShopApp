package hr.foi.air.webshopapp.fragmenti;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.List;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.SearchInterface;
import hr.foi.air.webshopapp.adapter.ListAdapter;
import hr.foi.air.webshopapp.base.BaseFragment;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;


public class FragmentSearchKategorija extends BaseFragment implements View.OnClickListener, SearchInterface {
    private Button searchButton;
    private CheckBox checkBoxRacunala, checkBoxGrafickeKartice, checkBoxKuciste, checkBoxProcesor, checkBoxNapajanje, checkBoxRamMemorija, checkBoxMaticnaPloca;
    private hr.foi.air.webshopapp.dbmodule.dbTables.product product;
    private List<product> productList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_search_kategorija;
    }

    @Override
    protected int getList() {
        return R.id.list;
    }

    @Override
    protected void init() {
        product = new product();
        productList = product.getAllsearch();

        checkBoxRacunala = (CheckBox) view.findViewById(R.id.checkBoxRacunala);

        checkBoxGrafickeKartice = (CheckBox) view.findViewById(R.id.checkBoxGrafickeKartice);
        checkBoxKuciste = (CheckBox) view.findViewById(R.id.checkBoxKuciste);
        checkBoxProcesor = (CheckBox) view.findViewById(R.id.checkBoxProcesor);
        checkBoxNapajanje = (CheckBox) view.findViewById(R.id.checkBoxNapajanje);
        checkBoxRamMemorija = (CheckBox) view.findViewById(R.id.checkBoxRamMemorija);
        checkBoxMaticnaPloca = (CheckBox) view.findViewById(R.id.checkBoxMaticnaPloca);
        searchButton = (Button) view.findViewById(R.id.btnCheck);
        searchButton.setOnClickListener(this);
    }

    @Override
    protected void getAdapter() {
        adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
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