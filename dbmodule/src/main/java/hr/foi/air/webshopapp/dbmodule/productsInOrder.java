package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;

import adapter.BasketParseJSON;

/**
 * Created by zoky4 on 05-Nov-15.
 */

@Table(name = "productsInOrder")
public class productsInOrder extends Model {
    @Column(name = "Order_id")
    public int order_id;
    @Column(name = "Product_id")
    public int product_id;
    @Column(name = "Quantity")
    public int quantity;
    @Column(name = "RemoteId")
    public int remoteId;

    public productsInOrder(){super();}


    public static productsInOrder UpdateBasket (String json) {
        BasketParseJSON pj = new BasketParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.remoteIds.length;i++)
        {
            productsInOrder kosarice = new productsInOrder();
            try {
                new Delete().from(productsInOrder.class).where("remoteId = ?", pj.remoteIds[i]).execute();
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