package hr.foi.air.webshopapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.koushikdutta.ion.Ion;

import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.dbmodule.dbOperations.AddProduct;
import hr.foi.air.webshopapp.dbmodule.dbOperations.CreateOrder;
import hr.foi.air.webshopapp.dbmodule.dbTables.orders;
import hr.foi.air.webshopapp.dbmodule.dbTables.product;
import hr.foi.air.webshopapp.dbmodule.dbTables.productsInOrder;

public class ProductDetailsActivity extends AppCompatActivity{
    public static final String JSON_URL_get_orders = "http://webshopappfoi.esy.es/volleyGetOrders.php";
    public static final String JSON_URL_get_basket = "http://webshopappfoi.esy.es/volleyGetBasket.php";

    private Toolbar mToolbar;
    public TextView txtproductName;
    public TextView txtPrice;
    public TextView txtStock;
    public TextView txtDescription;
    public EditText edtQuantity;
    ImageView imageView;
    Button btnAddProduct;

    SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mToolbar=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtproductName = (TextView) findViewById(R.id.txtProdName);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtStock = (TextView) findViewById(R.id.txtStock);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnAddProduct = (Button) findViewById(R.id.btnOrder);
        edtQuantity = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        final product selectedProduct = getSelected(Integer.parseInt(intent.getStringExtra("remoteId")));

        sharedPrefs = getSharedPreferences("SessionManager", MODE_PRIVATE);


        txtproductName.setText(selectedProduct.name);
        txtPrice.setText(selectedProduct.price.toString());
        txtDescription.setText(selectedProduct.description);
        String stock = "" + selectedProduct.stock;
        txtStock.setText((stock));

        String imageURL = selectedProduct.picture_link;


        Ion.with(imageView)
                .placeholder(R.drawable.login_icon)
                .error(R.drawable.search_icon)
                .load(imageURL);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSyncRequestOrders();
                CreateOrder create = new CreateOrder();
                AddProduct addProduct = new AddProduct();

                String id = sharedPrefs.getString("remoteId", "");

                String kolicina = edtQuantity.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(ProductDetailsActivity.this);


                if (id != "" && kolicina!=null) {
                    int userId = Integer.valueOf(id);
                    int quantity = Integer.valueOf(kolicina);
                    int orderId = GetOrderId();
                    create.CreateNewOrder(userId, requestQueue);
                    if (quantity > selectedProduct.stock || quantity <= 0) {
                        Toast.makeText(ProductDetailsActivity.this, "Not enough products in stock! Enter different quantity", Toast.LENGTH_LONG);
                    } else {
                        addProduct.AddNewProduct(quantity, selectedProduct.remoteId, orderId, requestQueue);
                    }
                }
                else {
                    Toast.makeText(ProductDetailsActivity.this, "Please login first or enter valid quantity", Toast.LENGTH_LONG);
                }
                sendSyncRequestOrders();
                sendSyncRequestBasket();
            }
        });
    }

    public static product getSelected(int remoteId) {
        product selectedProduct;
        selectedProduct = new Select().from(product.class).where("remoteId = ?", String.valueOf(remoteId)).executeSingle();
        return selectedProduct;
    }

    public int GetOrderId(){
        orders currentOrder;
        currentOrder = new Select().from(orders.class).where("userId = ? AND statusId = ?", sharedPrefs.getString("remoteId", ""), "1").executeSingle();
        return currentOrder.remoteId;
    }


    public void sendSyncRequestOrders(){
        StringRequest stringRequestOrders = new StringRequest(JSON_URL_get_orders,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        orders order = new orders();
                        order.UpdateOrders(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ProductDetailsActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequestOrders);
    }

    public void sendSyncRequestBasket(){

        StringRequest stringRequestBasket = new StringRequest(JSON_URL_get_basket,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        productsInOrder basket = new productsInOrder();
                        basket.UpdateBasket(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ProductDetailsActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequestBasket);
    }
}
