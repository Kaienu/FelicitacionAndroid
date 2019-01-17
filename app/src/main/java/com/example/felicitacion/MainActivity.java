package com.example.felicitacion;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, Animation.AnimationListener {

    TextView furigana1;
    TextView furigana2;
    private Button botonFurigana;
    private Animation animacionCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Typeface fuente = Typeface.createFromAsset(getAssets(),"code2000.TTF");
        TextView titulo1 = (TextView) findViewById(R.id.titulo1);
        TextView titulo2 = (TextView) findViewById(R.id.titulo2);
        furigana1 = (TextView) findViewById(R.id.furigana1);
        furigana2 = (TextView) findViewById(R.id.furigana2);
        ImageView image1 = (ImageView) findViewById(R.id.imageView3);
        botonFurigana = (Button) findViewById(R.id.button2);
        botonFurigana.setOnClickListener(this);

        furigana1.setVisibility(View.INVISIBLE);
        furigana2.setVisibility(View.INVISIBLE);
        botonFurigana.setVisibility(View.INVISIBLE);
        //titulo1.setTypeface(fuente);
        //titulo2.setTypeface(fuente);
        Animation animacionImagen = AnimationUtils.loadAnimation(this,R.anim.animacion);
        Animation animacionTexto = AnimationUtils.loadAnimation(this,R.anim.textanim);
        image1.setAnimation(animacionImagen);
        titulo1.setAnimation(animacionTexto);
        titulo2.setAnimation(animacionTexto);

        animacionTexto.setAnimationListener(this);
        animacionCargando = AnimationUtils.loadAnimation(this,R.anim.splashanim);

        MediaPlayer reproductor = MediaPlayer.create(this,R.raw.jinglebell);
        reproductor.start();

    }

    @Override
    public void onClick(View v) {
        if (furigana1.getVisibility()==View.VISIBLE) {
            furigana1.setVisibility(View.INVISIBLE);
            furigana2.setVisibility(View.INVISIBLE);
        } else {
            furigana1.setVisibility(View.VISIBLE);
            furigana2.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        botonFurigana.setAnimation(animacionCargando);
        botonFurigana.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
