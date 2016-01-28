package hr.foi.air.webshopapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.webshopapp.R;

import hr.foi.air.webshopapp.dbmodule.dbTables.orders;


/**
 * Created by Dario on 28.1.2016..
 */
public class ListAdapterNarudzbe extends ArrayAdapter<orders> {

    private Context mContext;
    private List<orders> mList;
    ViewHolder holder;

    public ListAdapterNarudzbe(Context context, int res, List<orders> productList){
        super(context, res, productList);
        this.mContext = context;
        mList = new ArrayList<orders>();
        mList.addAll(productList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_row, null);

            holder = new ViewHolder();
            holder.id=(TextView) convertView.findViewById(R.id.nevidljivIDnarudzbe);
            holder.title = (TextView) convertView.findViewById(R.id.titleNarudzbe);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        orders orders = mList.get(position);
        holder.id.setText(String.valueOf(orders.getRemoteId()));
        Log.d("kurt", String.valueOf(orders.getRemoteId()));
        holder.title.setText(orders.getRemoteId());


        return convertView;
    }

    private class ViewHolder{
        TextView title,id;

    }
}
