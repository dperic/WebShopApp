package hr.foi.air.webshopapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.webshopapp.R;

import hr.foi.air.webshopapp.dbmodule.dbTables.productsInOrder;

/**
 * Created by Dario on 28.1.2016..
 */
public class ListAdapterKosarica extends ArrayAdapter<productsInOrder> {

    private Context mContext;
    private List<productsInOrder> mList;
    ViewHolder holder;

    public ListAdapterKosarica(Context context, int res, List<productsInOrder> productList){
        super(context, res, productList);
        this.mContext = context;
        mList = new ArrayList<productsInOrder>();
        mList.addAll(productList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_row_kosarica, null);

            holder = new ViewHolder();
            holder.nevidljivID=(TextView) convertView.findViewById(R.id.nevidljivIDkosarica);
            holder.orderID = (TextView) convertView.findViewById(R.id.OrderID);
            holder.productID = (TextView) convertView.findViewById(R.id.productID);
            holder.kolicinaKosarica = (TextView) convertView.findViewById(R.id.kolicinaKosarica);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        productsInOrder productsInOrder = mList.get(position);
        holder.nevidljivID.setText(String.valueOf(productsInOrder.getOrder_id()));
        holder.orderID.setText(String.valueOf(productsInOrder.getOrder_id()));
        holder.productID.setText(String.valueOf(productsInOrder.getProduct_id()));
        holder.kolicinaKosarica.setText(String.valueOf(productsInOrder.getQuantity()));

        return convertView;
    }

    private class ViewHolder{
        TextView orderID,productID,kolicinaKosarica, nevidljivID;

    }
}
