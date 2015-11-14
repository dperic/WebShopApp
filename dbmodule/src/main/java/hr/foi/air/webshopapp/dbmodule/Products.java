package hr.foi.air.webshopapp.dbmodule;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Calendar;
import java.util.Date;

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
    @Column(name = "Datum_dodavanja")
    public Date datum_dodavanja;

    public Products() {
        super();
    }

    public Products(String naziv, double cijena, int zaliha, String slikaUrl, String opis, Date datum_dodavanja) {
        super();

        this.naziv = naziv;
        this.cijena = cijena;
        this.zaliha = zaliha;
        this.slikaUrl = slikaUrl;
        this.opis = opis;
        this.datum_dodavanja = datum_dodavanja;
    }
    public static Products UpdateProducts(String naziv) {
        Products proizvod = new Products();
        Date datum = new Date();
        proizvod.naziv = naziv;
        proizvod.cijena = 60;
        proizvod.zaliha = 4;
        proizvod.slikaUrl = "http";
        proizvod.opis = "opis";
        datum = Calendar.getInstance().getTime();
        proizvod.datum_dodavanja = datum;
        proizvod.save();
        return null;
    }



}