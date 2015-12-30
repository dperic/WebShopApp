package hr.foi.air.webshopapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import hr.foi.air.webshopapp.R;

public class UserProfileActivity extends AppCompatActivity{

        private TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile);

            textView = (TextView) findViewById(R.id.textViewUsername);

            Intent intent = getIntent();

            textView.setText("Welcome User " + intent.getStringExtra(LoginActivity.KEY_USERNAME));

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Intent intent1 = new Intent(UserProfileActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finishscreen();
                }
            };
            Timer t = new Timer();
            t.schedule(task, 2000);
        }
    private void finishscreen(){
        this.finish();
    }
}
