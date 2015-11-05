package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by zoky4 on 05-Nov-15.
 */

@Table(name = "ProductsInOrder")
public class ProductsInOrder extends Model {
    @Column(name = "Id_Narudzbe")
    public int Id_Narudzbe;
    @Column(name = "ID_Proizvod")
    public int ID_Proizvoda;
    @Column(name = "Kolicina")
    public int Kolicina;

    public ProductsInOrder(){super();}

    public ProductsInOrder(int id_Narudzbe, int ID_Proizvoda, int kolicina) {
        Id_Narudzbe = id_Narudzbe;
        this.ID_Proizvoda = ID_Proizvoda;
        Kolicina = kolicina;
    }
}