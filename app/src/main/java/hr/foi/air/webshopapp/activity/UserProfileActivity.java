package hr.foi.air.webshopapp.activity;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hr.foi.air.webshopapp.R;

public class UserProfileActivity extends AppCompatActivity{

    public static final String URL = "http://webshopappfoi.esy.es/dbGetUser.php?username=";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD= "password";
    public static final String KEY_NAME= "name";
    public static final String KEY_SURNAME= "surname";
    public static final String KEY_ADDRESS= "address";
    public static final String JSON_ARRAY = "result";

    private EditText edtUsername;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtName;
    private EditText edtSurname;
    private EditText edtAddress;

    private ProgressDialog loading;

    private Button btnLogout;
    SharedPreferences LoggedInUser;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile);
        edtName = (EditText) findViewById(R.id.editTextName);
        edtSurname = (EditText) findViewById(R.id.editTextSurname);
        edtAddress = (EditText) findViewById(R.id.editTextAddress);
        edtEmail = (EditText) findViewById(R.id.editTextEmail);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        edtUsername = (EditText) findViewById(R.id.editTextUsername);
        btnLogout = (Button) findViewById(R.id.buttonLogOut);
        LoggedInUser = getSharedPreferences("SessionManager", MODE_PRIVATE);
        final SharedPreferences.Editor editLogged = LoggedInUser.edit();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editLogged.clear();
                editLogged.commit();
            }
        });
        GetUserData();
        }

    public void GetUserData(){

        String userName = LoggedInUser.getString("UserName", "");

        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String url = URL+LoggedInUser.getString("userNameKey", "").toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserProfileActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    private void showJSON(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(JSON_ARRAY);
            JSONObject userData = result.getJSONObject(0);
            edtUsername.setText(userData.getString(KEY_USERNAME).toString(), TextView.BufferType.EDITABLE);
            edtPassword.setText(userData.getString(KEY_PASSWORD).toString(), TextView.BufferType.EDITABLE);
            edtEmail.setText(userData.getString(KEY_EMAIL).toString(), TextView.BufferType.EDITABLE);
            edtAddress.setText(userData.getString(KEY_ADDRESS).toString(), TextView.BufferType.EDITABLE);
            edtName.setText(userData.getString(KEY_NAME).toString(), TextView.BufferType.EDITABLE);
            edtSurname.setText(userData.getString(KEY_SURNAME).toString(), TextView.BufferType.EDITABLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //textViewResult.setText("Name:\t"+name+"\nAddress:\t" +address+ "\nVice Chancellor:\t"+ vc);
    }


}
