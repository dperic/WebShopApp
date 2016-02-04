package hr.foi.air.webshopapp.fragmenti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.SearchInterface;
import hr.foi.air.webshopapp.activity.MainActivity;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;

public class FragmentSearch extends Fragment implements View.OnClickListener{

    private Button searchButtonNaziv, searchButtonKategorija ;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.title_search));
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        searchButtonNaziv = (Button) rootView.findViewById(R.id.btnSearch);
        searchButtonNaziv.setOnClickListener(this);

        searchButtonKategorija = (Button) rootView.findViewById(R.id.btnSearchKategorija);
        searchButtonKategorija.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        SearchInterface searchInterface;
        switch (v.getId()) {
            case R.id.btnSearch:
                searchInterface= new FragmentSearchNaziv();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFrame, (Fragment)searchInterface, "fragment_screen");
                ft.commit();
                break;
            case R.id.btnSearchKategorija:
                searchInterface= new FragmentSearchKategorija();
                FragmentManager fm1 = getFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.mainFrame, (Fragment)searchInterface, "fragment_screen");
                ft1.commit();
                break;
        }
    }


    public void listItem(int idd){
        //listView = (ListView) rootView.findViewById(R.id.list);
        //adapter = new ListAdapter(getActivity(), R.layout.list_row, productList);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idd = (TextView) view.findViewById(R.id.nevidljivID);
                MainActivity main = new MainActivity();
                //main.Show(idd.getText().toString());

                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("remoteId", idd.getText().toString());
                startActivity(intent);

            }

        });
    }

}