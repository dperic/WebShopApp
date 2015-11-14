package hr.foi.air.webshopapp.dbmodule;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by zoky4 on 30-Oct-15.
 */

@Table(name = "User")
public class UserTable extends Model {
    @Column(name = "Username")
    public String Username;
    @Column(name = "Password")
    public String Password;
    @Column(name = "Ime")
    public String Ime;
    @Column(name = "Prezime")
    public String Prezime;
    @Column(name = "Adresa")
    public String Adresa;
    @Column(name = "Email")
    public String Email;

    public UserTable(){super();}

    public UserTable(String username, String password, String ime, String prezime, String adresa, String email) {
        Username = username;
        Password = password;
        Ime = ime;
        Prezime = prezime;
        Adresa = adresa;
        Email = email;
    }

    public static UserTable UpdateUser(){
        UserTable korisnik = new UserTable();
        // Log.d(ime.toString());
        korisnik.Username = "imedodanog";
        korisnik.Adresa = "asd";
        korisnik.Email = "mail";
        korisnik.Ime = "zj";
        korisnik.Prezime = "j";
        korisnik.Password = "123";
        korisnik.save();
        return null;
    }
}
