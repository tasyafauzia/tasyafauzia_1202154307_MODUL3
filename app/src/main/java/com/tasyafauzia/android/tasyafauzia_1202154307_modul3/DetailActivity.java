package com.tasyafauzia.android.tasyafauzia_1202154307_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private Button Plus, Minus;
    private ImageView isi_air;
    private TextView status;
    private int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView drinksTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView drinksImage = (ImageView) findViewById(R.id.minumImageDetail);
        TextView drinksDetail = (TextView) findViewById(R.id.subTitleDetail);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this, getIntent().getIntExtra(mineral.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if (drawable != null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        drinksTitle.setText(getIntent().getStringExtra(mineral.TITLE_KEY));
        Toast.makeText(DetailActivity.this, "Detail merk mineral " + drinksTitle.getText(), Toast.LENGTH_LONG).show();

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(mineral.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(drinksImage);

        //Set the text from the Intent extra
        drinksDetail.setText(getIntent().getStringExtra(mineral.DETAIL_KEY));

        //deklarasi variabel
        Plus = (Button) findViewById(R.id.Plus);
        Minus = (Button) findViewById(R.id.Minus);
        isi_air = (ImageView) findViewById(R.id.imgBotol);
        status = (TextView) findViewById(R.id.status);

        //membuat onclicklistener jika untuk tombol tambah
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCapacity();
            }
        });

        //membuat onclicklistener jika untuk tombol kurang
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusCapacity();
            }
        });
    }

    //jika tombol minus maka air akan dikurangi dan jika sudah sampai level 0 muncul toast
    private void minusCapacity() {
        status();
        if(level==0){
            Toast.makeText(this,"Air Belum Terisi Penuh",Toast.LENGTH_SHORT).show();
            return;
        }
        //setImage dari capacity.xml yang berisi vector asset dari botol
        isi_air.setImageLevel(--level);
    }

    //jika tombol plus maka air akan ditambah dan jika sudah sampai level 4 muncul toast
    private void addCapacity() {
        status();
        if (level == 4) {
            Toast.makeText(this, "Air Telah Terisi Full", Toast.LENGTH_SHORT).show();
            return;
        }
        //setImage dari capacity.xml yang berisi vector asset dari botol
        isi_air.setImageLevel(++level);
    }

    private void status() {
        int i = level + 1;
        status.setText(""+ i +"L");
    }

}
