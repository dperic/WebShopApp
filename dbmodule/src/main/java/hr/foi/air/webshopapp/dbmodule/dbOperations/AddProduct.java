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
public class AddProduct {
    public static final String URL = "http://webshopappfoi.esy.es/volleyAddProduct.php";

    public static final String KEY_QUANTITY= "quantity";
    public static final String KEY_PRODUCTID = "productId";
    public static final String KEY_ORDERID = "orderId";





    public void AddNewProduct(final int quantity, final int productId, final int orderId,RequestQueue requestQueue){

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

                params.put(KEY_QUANTITY, String.valueOf(quantity));
                params.put(KEY_PRODUCTID, String.valueOf(productId));
                params.put(KEY_ORDERID, String.valueOf(orderId));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
