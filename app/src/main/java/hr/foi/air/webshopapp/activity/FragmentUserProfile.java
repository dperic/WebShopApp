package hr.foi.air.webshopapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hr.foi.air.webshopapp.R;

/**
 * Created by zoky4 on 22-Dec-15.
 */
public class FragmentUserProfile extends AppCompatActivity{
        private TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_user_profile);

            textView = (TextView) findViewById(R.id.textViewUsername);

            Intent intent = getIntent();

            textView.setText("Welcome User " + intent.getStringExtra(FragmentLogin.KEY_USERNAME));
        }
}
