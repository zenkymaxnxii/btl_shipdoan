package com.hhqit.shipdoan;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private String KEY_DOMAIN = "http://shipdoan.tk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = this.getIntent();
        final int id = it.getIntExtra("id",-1);
        String name = it.getStringExtra("name");
        String des = it.getStringExtra("des");
        String img = KEY_DOMAIN + it.getStringExtra("img");
        String price = it.getStringExtra("price");
        ImageView imageView = findViewById(R.id.ivImagesDetail);
        TextView tvName = findViewById(R.id.tvNameDetail);
        TextView tvMoTa = findViewById(R.id.tvMoTaDetail);
        TextView tvPrice = findViewById(R.id.tvPriceDetail);
        tvName.setText(name);
        tvMoTa.setText(des);
        tvPrice.setText(price);
        Picasso.with(this).load(img).resize(1000,620).into(imageView);
        findViewById(R.id.btnMua).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DetailActivity.this,MuaActivity.class);
                it.putExtra("id",id);
                startActivity(it);
            }
        });
    }
}
