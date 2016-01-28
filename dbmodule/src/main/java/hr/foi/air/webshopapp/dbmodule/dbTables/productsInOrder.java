package hr.foi.air.webshopapp.dbmodule.dbTables;

import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

import hr.foi.air.webshopapp.dbmodule.adapter.BasketParseJSON;

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

    public static List<productsInOrder> getAllproductsInOrder() {
        Log.d("Izvrsio", "izvrsio");
        return new Select()
                .from(productsInOrder.class)
                .execute();
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(int remoteId) {
        this.remoteId = remoteId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}