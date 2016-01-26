package hr.foi.air.webshopapp.dbmodule;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import adapter.ParseJSON;



/**
 * Created by Hlevnjak on 10.11.2015..
 */

@Table(name = "product")
public class product extends Model {
    @Column(name = "remoteId")
    public String remoteId;
    @Column(name = "name")
    public String name;
    @Column(name = "price")
    public Double price;
    @Column(name = "stock")
    public String stock;
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

    public product(String id, String name, Double price, String stock, String picture_link, String description, String category, String date_added) {
        this.remoteId = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.picture_link = picture_link;
        this.description = description;
        this.category = category;
        this.date_added = date_added;
    }

    public static product UpdateProducts(String json) {
        ParseJSON pj = new ParseJSON(json);
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
                proizvod.remoteId = pj.ids[i];
                proizvod.name = pj.names[i];
                proizvod.price = Double.valueOf(pj.pricess[i]);
                proizvod.stock = pj.stock[i];
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