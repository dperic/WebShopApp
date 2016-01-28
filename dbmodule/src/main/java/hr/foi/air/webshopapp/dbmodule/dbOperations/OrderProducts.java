package hr.foi.air.webshopapp.dbmodule.dbOperations;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zoky4 on 28-Jan-16.
 */
public class OrderProducts {
    public static final String SAVE_URL = "http://webshopappfoi.esy.es/volleyOrderProductsFromBasket.php";
    public static final String KEY_USERNAME = "username";

    public void saveOrder(final String username, RequestQueue requestQueue) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, SAVE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(UserProfileActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(UserProfileActivity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
