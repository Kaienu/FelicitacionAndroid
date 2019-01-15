package com.example.felicitacion;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Typeface fuente = Typeface.createFromAsset(getAssets(),"code2000.TTF");
        TextView titulo1 = (TextView) findViewById(R.id.titulo1);
        TextView titulo2 = (TextView) findViewById(R.id.titulo2);
        titulo1.setTypeface(fuente);
        titulo2.setTypeface(fuente);*/

        MediaPlayer reproductor = MediaPlayer.create(this,R.raw.jinglebell);
        reproductor.start();

    }
}
