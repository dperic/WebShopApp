package hr.foi.air.webshopapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.koushikdutta.ion.Ion;
import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.dbmodule.product;

public class ProductDetailsActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    public TextView txtproductName;
    public TextView txtPrice;
    public TextView txtStock;
    public TextView txtDescription;
    ImageView imageView;

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

        Intent intent = getIntent();
        product selectedProduct = getSelected(Integer.parseInt(intent.getStringExtra("remoteId")));

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
    }

    public static product getSelected(int remoteId) {
        product selectedProduct;
        selectedProduct = new Select().from(product.class).where("remoteId = ?", String.valueOf(remoteId)).executeSingle();
        return selectedProduct;
    }

}
