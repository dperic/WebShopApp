package hr.foi.air.webshopapp.dbmodule;

import android.media.Image;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by zoky4 on 05-Nov-15.
 */


@Table(name = "Products")
   public class Products  extends Model {
    @Column(name = "Naziv")
    public String Naziv;
    @Column(name = "Cijena")
    public Double Cijena;
    @Column(name = "Zaliha")
    public int Zaliha;
    @Column(name = "Slika")
    public Image Slika;
    @Column(name = "Opis")
    public String Opis;

    public Products(){super();}

    public Products(String naziv, Double cijena, int zaliha, Image slika, String opis) {
        Naziv = naziv;
        Cijena = cijena;
        Zaliha = zaliha;
        Slika = slika;
        Opis = opis;
    }
}

