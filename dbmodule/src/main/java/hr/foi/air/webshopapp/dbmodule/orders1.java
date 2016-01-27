package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;

import adapter.OrdersParseJSON;

/**
 * Created by zoky4 on 27-Jan-16.
 */
@Table(name = "orders1")
public class orders1 extends Model {
    @Column(name = "remoteId")
    public int remoteId;
    @Column(name = "orderDate")
    public String orderDate;
    @Column(name = "userId")
    public int userId;
    @Column(name = "statusId")
    public int statusId;

    public orders1(){super();}


    public static orders1 UpdateOrders (String json) {
        OrdersParseJSON pj = new OrdersParseJSON(json);
        pj.parseJSON();
        for (int i = 0; i < pj.remIds.length;i++)
        {
            orders1 narudzbe = new orders1();

            try {
                new Delete().from(orders1.class).where("remoteId = ?", pj.remIds[i]).execute();
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
}