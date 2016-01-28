package hr.foi.air.webshopapp.dbmodule.dbOperations;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zoky4 on 27-Jan-16.
 */
public class CreateOrder {
    public static final String URL = "http://webshopappfoi.esy.es/volleyNewOrder.php";

//    public static final String KEY_ID = "id";
    public static final String KEY_ORDERDATE = "orderDate";
    public static final String KEY_USERID = "userId";
    public static final String KEY_STATUSID = "statusId";




    public void CreateNewOrder(final int userId,RequestQueue requestQueue){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(ProductDetailsActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(ProductDetailsActivity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                }){


            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();

                params.put(KEY_STATUSID, String.valueOf(1));
                params.put(KEY_USERID, String.valueOf(userId));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
