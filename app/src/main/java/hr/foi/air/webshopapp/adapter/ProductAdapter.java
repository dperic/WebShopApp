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
import hr.foi.air.webshopapp.dbmodule.dbTables.product;


public class ProductAdapter extends ArrayAdapter<product> {
    public Context c;
    private List<product> vrijednosti;
    ViewHolder holder;

    public ProductAdapter(Context c, int resource, List<product> vrijednostiLista)
    {
        super(c, resource, vrijednostiLista);
        this.c = c;
        vrijednosti = new ArrayList<product>();
        vrijednosti.addAll(vrijednostiLista);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);

            holder = new ViewHolder();
            holder.id=(TextView) convertView.findViewById(R.id.nevidljivID);
            holder.naziv = (TextView) convertView.findViewById(R.id.title);
            holder.cijena = (TextView) convertView.findViewById(R.id.cijena);
            holder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        product product = vrijednosti.get(position);
        holder.id.setText(String.valueOf(product.getRemoteId()));
        Log.d("remoteID", String.valueOf(product.getRemoteId()));
        holder.naziv.setText(product.getName());
        holder.cijena.setText(String.valueOf(product.getPrice()));
        Picasso.with(c).load(product.getPicture_link()).into(holder.imageView);
        return convertView;
    }

    private class ViewHolder {
        TextView naziv;
        TextView cijena;
        TextView id;
        ImageView imageView;
    }

}