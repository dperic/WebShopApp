package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;

import adapter.BasketParseJSON;

/**
 * Created by zoky4 on 05-Nov-15.
 */

@Table(name = "productsInOrder1")
public class productsInOrder1 extends Model {
    @Column(name = "Order_id")
    public int order_id;
    @Column(name = "Product_id")
    public int product_id;
    @Column(name = "Quantity")
    public int quantity;
    @Column(name = "RemoteId")
    public int remoteId;

    public productsInOrder1(){super();}


    public static productsInOrder1 UpdateBasket (String json) {
        BasketParseJSON pj = new BasketParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.remoteIds.length;i++)
        {
            productsInOrder1 kosarice = new productsInOrder1();
            try {
                new Delete().from(productsInOrder1.class).where("remoteId = ?", pj.remoteIds[i]).execute();
            }
            catch (Exception e){
                return null;
            }
            try {
                kosarice.remoteId = Integer.valueOf(pj.remoteIds[i]);
                kosarice.order_id = Integer.valueOf(pj.orderIds[i]);
                kosarice.product_id = Integer.valueOf(pj.productIds[i]);
                kosarice.quantity = Integer.valueOf(pj.quantities[i]);
                kosarice.save();
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
}