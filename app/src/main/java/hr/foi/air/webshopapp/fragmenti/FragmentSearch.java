package hr.foi.air.webshopapp.fragmenti;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;


import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.activity.MainActivity;

public class FragmentSearch extends Fragment implements View.OnClickListener{

    private Button searchButtonNaziv, searchButtonKategorija ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                //what to put here
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainFrame, new FragmentSearchNaziv(), "fragment_screen");
                ft.commit();
                break;
            case R.id.btnSearchKategorija:
                FragmentManager fm1 = getFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                ft1.replace(R.id.mainFrame, new FragmentSearchKategorija(), "fragment_screen");
                ft1.commit();
                break;
        }
    }
}