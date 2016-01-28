package hr.foi.air.webshopapp.dbmodule.dbTables;


import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

import hr.foi.air.webshopapp.dbmodule.adapter.ProductsParseJSON;



/**
 * Created by Hlevnjak on 10.11.2015..
 */

@Table(name = "product")
public class product extends Model {
    @Column(name = "remoteId")
    public int remoteId;
    @Column(name = "name")
    public String name;
    @Column(name = "price")
    public Double price;
    @Column(name = "stock")
    public int stock;
    @Column(name = "picture_link")
    public String picture_link;
    @Column(name = "description")
    public String description;
    @Column(name = "category")
    public String category;
    @Column(name = "date_added")
    public String date_added;


    public product() {
        super();
    }


    public static product UpdateProducts(String json) {
        ProductsParseJSON pj = new ProductsParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.ids.length;i++)
        {
            product proizvod = new product();
            try {
                new Delete().from(product.class).where("remoteId = ?", pj.ids[i]).execute();
            }
            catch (Exception e){
                return null;
            }
            try {
                proizvod.remoteId = Integer.valueOf(pj.ids[i]);
                proizvod.name = pj.names[i];
                proizvod.price = Double.valueOf(pj.pricess[i]);
                proizvod.stock = Integer.valueOf(pj.stock[i]);
                proizvod.picture_link = pj.picture_link[i];
                proizvod.description = pj.descriptions[i];
                proizvod.category = pj.categories[i];
                proizvod.date_added = pj.dates[i];
                proizvod.save();
            }

            catch (Exception e){
                return null;
            }
        }
        return null;
    }

    public static List<product> getAll() {
        Log.d("Izvrsio", "izvrsio");
        return new Select()
                .from(product.class)
                .execute();
    }

    public int getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(int remoteId) {
        this.remoteId = remoteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPicture_link() {
        return picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }
}