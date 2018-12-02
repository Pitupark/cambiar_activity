package com.example.user.cambiar_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    private WebView wbc;
    private ImageButton btn1, btn2,btn3, btnfav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        wbc = (WebView)findViewById(R.id.wbc);
        btn1 = (ImageButton)findViewById(R.id.btn1);
        btnfav = (ImageButton)findViewById(R.id.btnfav);
        btn2 = (ImageButton)findViewById(R.id.btn2);
        btn3 = (ImageButton)findViewById(R.id.btn3);
        et1 = (EditText)findViewById(R.id.et1);


        //para javascript
        WebSettings webSettings = wbc.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wbc.setWebViewClient(new WebViewClient());

        final ArrayList<String> historial = new ArrayList<>();
        //inicializar el arrayadapter


        //para elegir favorito
        final ArrayList<String> favoritos= new ArrayList<>();


        //mostrar el video y pasar url a historial
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cogemos el edittext y lo pasamos al loadurl del webview
                String texto = String.valueOf(et1.getText());
                wbc.loadUrl("https://" + texto);
                //añadimos el texto del et1
                historial.add(texto);

            }
        });

        //añadir el video a favoritos
        btnfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String favos = String.valueOf(et1.getText());
                //añadimos el texto del et1 al spinner
                favoritos.add(favos);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),SegundaActivity.class);
                i.putExtra("url", historial.toString());
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),TerceraActivity.class);
                i.putExtra("fav", favoritos.toString());
                startActivity(i);
            }
        });

    }
}
