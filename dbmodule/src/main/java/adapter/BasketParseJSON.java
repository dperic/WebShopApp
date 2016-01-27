package adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zoky4 on 26-Jan-16.
 */
public class BasketParseJSON {
    public static String[] remoteIds;
    public static String[] quantities;
    public static String[] productIds;
    public static String[] orderIds;


    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_QUANTITY = "quantity";
    public static final String KEY_PRODUCTID = "productId";
    public static final String KEY_ORDERID = "orderId";

    private JSONArray ProductinOrder = null;

    private String json;

    public BasketParseJSON(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            ProductinOrder = jsonObject.getJSONArray(JSON_ARRAY);


            quantities = new String[ProductinOrder.length()];
            remoteIds = new String[ProductinOrder.length()];
            productIds = new String[ProductinOrder.length()];
            orderIds = new String[ProductinOrder.length()];

            for(int i=0;i<ProductinOrder.length();i++){
                JSONObject jo = ProductinOrder.getJSONObject(i);
                remoteIds[i] = jo.getString(String.valueOf(KEY_ID));
                quantities[i] = jo.getString(KEY_QUANTITY);
                productIds[i] = jo.getString(KEY_PRODUCTID);
                orderIds[i] = jo.getString(KEY_ORDERID);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}