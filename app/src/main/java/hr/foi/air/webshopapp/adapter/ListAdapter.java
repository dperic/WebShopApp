package hr.foi.air.webshopapp.adapter;

import android.content.Context;
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
import hr.foi.air.webshopapp.dbmodule.dbTables.product;

/**
 * Created by Dario on 27.1.2016..
 */
public class ListAdapter extends ArrayAdapter<product>{

    private Context mContext;
    private List<product> mList;
    ViewHolder holder;

    public ListAdapter(Context context, int res, List<product> productList){
        super(context, res, productList);
        this.mContext = context;
        mList = new ArrayList<product>();
        mList.addAll(productList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_row, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.cijena = (TextView) convertView.findViewById(R.id.cijena);
            holder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        product product = mList.get(position);
        holder.title.setText(product.getName());
        holder.cijena.setText(String.valueOf(product.getPrice()));
        Picasso.with(mContext).load(product.getPicture_link()).into(holder.imageView);
        return convertView;
    }

    private class ViewHolder{
        TextView title,cijena;
        ImageView imageView;
    }

}
