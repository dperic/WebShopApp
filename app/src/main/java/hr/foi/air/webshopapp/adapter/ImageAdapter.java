package hr.foi.air.webshopapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

import hr.foi.air.webshopapp.R;

public class ImageAdapter extends ArrayAdapter<String> {
    private String[] imageURLArray;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, int textViewResourceId,
                        String[] imageArray) {
        super(context, textViewResourceId, imageArray);
        // TODO Auto-generated constructor stub

        inflater = ((Activity) context).getLayoutInflater();
        imageURLArray = imageArray;
    }
    private static class ViewHolder {
        String imageURL;
        ImageView imageView;
        Bitmap bitmap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.image_item, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.testImage);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imageURL = imageURLArray[position];
        new DownloadAsyncTask().execute(viewHolder);
        return convertView;
    }


    private class DownloadAsyncTask extends AsyncTask<ViewHolder, Void, ViewHolder> {

        @Override
        protected ViewHolder doInBackground(ViewHolder... params) {
            // TODO Auto-generated method stub
            //load image directly
            ViewHolder viewHolder = params[0];
            try {
                URL imageURL = new URL(viewHolder.imageURL);
                viewHolder.bitmap = BitmapFactory.decodeStream(imageURL.openStream());
            } catch (IOException e) {
                // TODO: handle exception
                Log.e("error", "Downloading Image Failed");
                viewHolder.bitmap = null;
            }

            return viewHolder;
        }

        @Override
        protected void onPostExecute(ViewHolder result) {
            result.imageView.setImageBitmap(result.bitmap);
        }
    }
}
