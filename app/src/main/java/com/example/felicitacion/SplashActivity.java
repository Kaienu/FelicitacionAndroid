package com.example.felicitacion;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    private TextView cargando;
    private TextView empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        cargando = (TextView) findViewById(R.id.cargando);
        empresa = (TextView) findViewById(R.id.empresa);

        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation animacionCargando = AnimationUtils.loadAnimation(this,R.anim.splashanim);
        empresa.setAnimation(animacion);
        cargando.setAnimation(animacionCargando);

        animacionCargando.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        new CountDownTimer(5500, 500) {
            int count = 1;
            @Override
            public void onTick(long millisUntilFinished) {
                if (count==0) cargando.setText("Cargando");
                else if (count==1) cargando.setText("Cargando.");
                else if (count==2) cargando.setText("Cargando..");
                else if (count==3){
                    cargando.setText("Cargando...");
                    count = 0;
                    return;
                }
                count++;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
