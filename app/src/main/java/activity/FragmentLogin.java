package activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import adapter.JSONParser;
import hr.foi.air.webshopapp.R;

/**
 * Created by zoky4 on 18-Dec-15.
 */
public class FragmentLogin extends Activity implements DialogInterface.OnClickListener, View.OnClickListener {

        private EditText user, pass;
        private Button mSubmit, mRegister;

        // Progress Dialog
        private ProgressDialog pDialog;

        // JSON parser class
        JSONParser jsonParser = new JSONParser();

        //php login script location:

        //localhost :
        //testing on your device
        //put your local ip instead,  on windows, run CMD > ipconfig
        //or in mac's terminal type ifconfig and look for the ip under en0 or en1
        // private static final String LOGIN_URL = "http://xxx.xxx.x.x:1234/webservice/login.php";

        //testing on Emulator:
        private static final String LOGIN_URL = "http://webshopappfoi.esy.es/webservice/login.php";

        //testing from a real server:
        //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

        //JSON element ids from repsonse of php script:
        private static final String TAG_SUCCESS = "success";
        private static final String TAG_MESSAGE = "message";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

            //setup input fields
            user = (EditText)findViewById(R.id.username);
            pass = (EditText)findViewById(R.id.password);

            //setup buttons
            mSubmit = (Button)findViewById(R.id.login);

            //nije jos slozeno
            //mRegister = (Button)findViewById(R.id.register);

            //register listeners
            mSubmit.setOnClickListener(this);
            mRegister.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            // determine which button was pressed:
            switch (v.getId()) {
                case R.id.login:
                    new AttemptLogin().execute();
                    break;
                /*case R.id.register:
                    Intent i = new Intent(this, Register.class);
                    startActivity(i);
                    break;
*/
                default:
                    break;
            }
        }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    //AsyncTask is a seperate thread than the thread that runs the GUI
        //Any type of networking should be done with asynctask.
        class AttemptLogin extends AsyncTask<String, String, String> {

            //three methods get called, first preExecture, then do in background, and once do
            //in back ground is completed, the onPost execture method will be called.

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected String doInBackground(String... args) {

                return null;

            }

            protected void onPostExecute(String file_url) {

            }

        }

    }