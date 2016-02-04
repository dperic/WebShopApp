package hr.foi.air.webshopapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.activity.ProductDetailsActivity;
import hr.foi.air.webshopapp.adapter.ListAdapter;

/**
 * Created by Hlevnjak on 4.2.2016..
 */
public abstract class BaseFragment extends Fragment {

    protected View view;
    protected abstract int getLayout();
    protected abstract int getList();
    protected abstract void init();
    protected ListView listView;
    protected abstract void getAdapter();
    protected ListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        init();
        listView = (ListView) view.findViewById(getList());
        getAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.nevidljivID);
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("remoteId", textView.getText().toString());
                startActivity(intent);
            }
        });
        return view;
    }
}
