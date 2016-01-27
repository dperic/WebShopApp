package adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zoky4 on 26-Jan-16.
 */
public class OrdersParseJSON {
    public static String[] remIds;
    public static String[] orderDates;
    public static String[] userIds;
    public static String[] statusIds;


    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_ORDERDATE = "orderDate";
    public static final String KEY_USERID = "userId";
    public static final String KEY_STATUSID = "statusId";

    private JSONArray orders = null;

    private String json;

    public OrdersParseJSON (String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            orders = jsonObject.getJSONArray(JSON_ARRAY);

            remIds = new String[orders.length()];
            orderDates = new String[orders.length()];
            userIds = new String[orders.length()];
            statusIds = new String[orders.length()];

            for(int i=0;i< orders.length();i++){
                JSONObject jo = orders.getJSONObject(i);
                remIds[i] = jo.getString(KEY_ID);
                orderDates[i] = jo.getString(KEY_ORDERDATE);
                userIds[i] = jo.getString(KEY_USERID);
                statusIds[i] = jo.getString(KEY_STATUSID);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}