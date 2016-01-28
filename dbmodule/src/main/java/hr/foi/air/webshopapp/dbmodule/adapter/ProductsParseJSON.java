package hr.foi.air.webshopapp.dbmodule.adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zoky4 on 21-Jan-16.
 */
public class ProductsParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] pricess;
    public static String[] stock;
    public static String[] picture_link;
    public static String[] descriptions;
    public static String[] categories;
    public static String[] dates;



    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_STOCK = "stock";
    public static final String KEY_PICTURE_LINK = "picture_link";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CATEGORY  = "category";
    public static final String KEY_DATE_ADDED  = "date_added";

    private JSONArray products = null;

    private String json;

    public ProductsParseJSON(String json){
        this.json = json;
    }

    public void parseJSON(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            products = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[products.length()];
            names = new String[products.length()];
            pricess = new String[products.length()];
            stock = new String[products.length()];
            picture_link = new String[products.length()];
            descriptions = new String[products.length()];
            categories = new String[products.length()];
            dates = new String[products.length()];

            for(int i=0;i<products.length();i++){
                JSONObject jo = products.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                pricess[i] = jo.getString(String.valueOf(KEY_PRICE));
                stock[i] = jo.getString(KEY_STOCK);
                picture_link[i] = jo.getString(KEY_PICTURE_LINK);
                descriptions[i] = jo.getString(KEY_DESCRIPTION);
                categories[i] = jo.getString(KEY_CATEGORY);
                dates[i] = jo.getString(KEY_DATE_ADDED);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}