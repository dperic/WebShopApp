package hr.foi.air.webshopapp.dbmodule;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;

import adapter.ProductsParseJSON;



/**
 * Created by Hlevnjak on 10.11.2015..
 */

@Table(name = "product1")
public class product1 extends Model {
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


    public product1() {
        super();
    }


    public static product1 UpdateProducts(String json) {
        ProductsParseJSON pj = new ProductsParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.ids.length;i++)
        {
            product1 proizvod = new product1();
            try {
                new Delete().from(product1.class).where("remoteId = ?", pj.ids[i]).execute();
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
}