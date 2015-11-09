package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by robertkc on 09-Nov-15.
 */


@Table(name = "Products")
   public class Products  extends Model {

    @Column(name = "remoteId")
    private long remoteId;

    @Column(name = "naziv", index = true)
    private String naziv;

    @Column(name = "cijena")
    private Double cijena;

    @Column(name = "zaliha")
    private int zaliha;

    @Column(name = "slikaUrl")
    private String slikaUrl;

    @Column(name = "opis", index = true)
    private String opis;

    public Products(){super();}

    public Products(long remoteId,String naziv, Double cijena, int zaliha, String slikaUrl, String opis) {
        super();
        this.remoteId = remoteId;
        this.naziv = naziv;
        this.cijena = cijena;
        this.zaliha = zaliha;
        this.slikaUrl = slikaUrl;
        this.opis = opis;
    }

    public long getRemoteId() {
        return remoteId;
    }

    public String getNaziv() {
        return naziv;
    }

    public Double getCijena() {
        return cijena;
    }

    public int getZaliha() {
        return zaliha;
    }

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public String getOpis() {
        return opis;
    }

    public void updateProducts(Products updateProducts){
        this.naziv = updateProducts.getNaziv();
        this.cijena = updateProducts.getCijena();
        this.zaliha = updateProducts.getZaliha();
        this.slikaUrl = updateProducts.getSlikaUrl();
        this.opis = updateProducts.getOpis();
        this.save();
    }
}

