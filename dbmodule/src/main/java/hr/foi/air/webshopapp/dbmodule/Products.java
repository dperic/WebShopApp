package hr.foi.air.webshopapp.dbmodule;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Hlevnjak on 10.11.2015..
 */

@Table(name = "Products")
public class Products extends Model {
    @Column(name = "naziv")
    public String naziv;
    @Column(name = "cijena")
    public double cijena;
    @Column(name = "zaliha")
    public int zaliha;
    @Column(name = "slikaUrl")
    public String slikaUrl;
    @Column(name = "opis")
    public String opis;

    public Products() {
        super();
    }

    public Products(String naziv, double cijena, int zaliha, String slikaUrl, String opis) {
        super();

        this.naziv = naziv;
        this.cijena = cijena;
        this.zaliha = zaliha;
        this.slikaUrl = slikaUrl;
        this.opis = opis;
    }
    public static Products UpdateProducts(String naziv) {
        Products proizvod = new Products();
        proizvod.naziv = naziv;
        proizvod.cijena = 60;
        proizvod.zaliha = 4;
        proizvod.slikaUrl = "http";
        proizvod.opis = "opis";
        proizvod.save();
        return null;
    }



}