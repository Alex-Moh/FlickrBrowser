package com.ajmalm.flickrbrowser;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;

public class ViewPhotoDetailsActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_details);
        activateToolbarWithHomeEnabled();

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);

        TextView photoTitle = (TextView) findViewById(R.id.photo_title);
        photoTitle.setText("Title: " + photo.getTitle());

        TextView photoTags = (TextView) findViewById(R.id.photo_tags);
        photoTags.setText("Tags: " + photo.getTags());

        TextView photoAuthor = (TextView) findViewById(R.id.photo_author);
        photoAuthor.setText(photo.getAuthor());

        ImageView photoImage = (ImageView) findViewById(R.id.photo_image);
        Picasso.with(this).load(photo.getLink())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(photoImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photo_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}