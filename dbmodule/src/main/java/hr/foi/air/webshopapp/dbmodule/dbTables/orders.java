package hr.foi.air.webshopapp.dbmodule.dbTables;

import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

import hr.foi.air.webshopapp.dbmodule.adapter.OrdersParseJSON;

/**
 * Created by zoky4 on 27-Jan-16.
 */
@Table(name = "orders")
public class orders extends Model {
    @Column(name = "remoteId")
    public int remoteId;
    @Column(name = "orderDate")
    public String orderDate;
    @Column(name = "userId")
    public int userId;
    @Column(name = "statusId")
    public int statusId;

    public orders(){super();}


    public static orders UpdateOrders (String json) {
        OrdersParseJSON pj = new OrdersParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.remIds.length;i++)
        {
            orders narudzbe = new orders();

            try {
                new Delete().from(orders.class).where("remoteId = ?", pj.remIds[i]).execute();
            }
            catch (Exception e){
                return null;
            }
            try {
                narudzbe.remoteId = Integer.valueOf(pj.remIds[i]);
                narudzbe.orderDate = pj.orderDates[i];
                narudzbe.userId = Integer.valueOf(pj.userIds[i]);
                narudzbe.statusId = Integer.valueOf(pj.statusIds[i]);
                narudzbe.save();
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
    public static List<orders> getAllOrders() {

        return new Select()
                .from(orders.class)
                .where("")
                .execute();
    }

    public int getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(int remoteId) {
        this.remoteId = remoteId;
    }
}