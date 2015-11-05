package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by zoky4 on 05-Nov-15.
 */


@Table(name = "Orders")
public class Orders {
    @Column(name = "ID_User")
    public int ID_User;
    @Column(name = "Status")
    public boolean Status;
    @Column(name = "Datum")
    public Date Datum;

    public Orders(){super();}

    public Orders(int ID_User, boolean status, Date datum) {
        this.ID_User = ID_User;
        Status = status;
        Datum = datum;
    }
}
