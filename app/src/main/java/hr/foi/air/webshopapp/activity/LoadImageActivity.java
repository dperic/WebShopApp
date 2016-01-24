package hr.foi.air.webshopapp.activity;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


import hr.foi.air.webshopapp.R;
import hr.foi.air.webshopapp.adapter.ImageAdapter;


public class LoadImageActivity extends Activity {

    private String[] imageURLArray = new String[]{
            "http://farm8.staticflickr.com/7315/9046944633_881f24c4fa_s.jpg",
            "http://farm4.staticflickr.com/3777/9049174610_bf51be8a07_s.jpg",
            "http://farm8.staticflickr.com/7324/9046946887_d96a28376c_s.jpg",
            "http://farm3.staticflickr.com/2828/9046946983_923887b17d_s.jpg",
            "http://farm4.staticflickr.com/3810/9046947167_3a51fffa0b_s.jpg",
            "http://farm4.staticflickr.com/3773/9049175264_b0ea30fa75_s.jpg",
            "https://z-1-scontent-fra3-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/" +
                    "12249763_10208301005585772_4441425751759241085_n.jpg?oh=a0186b143e170f27d00a9fb99017f05f&oe=5705AF2B"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        ListView listView = (ListView)this.findViewById(R.id.listView);
        ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.image_item, imageURLArray);
        listView.setAdapter(imageAdapter);
    }
}