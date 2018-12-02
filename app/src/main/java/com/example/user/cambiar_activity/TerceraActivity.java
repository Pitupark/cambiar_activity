package com.example.user.cambiar_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {
    private TextView tv2;
    private Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        tv2 = (TextView)findViewById(R.id.tv2);
        btn4= (Button)findViewById(R.id.btn4);
        Bundle bundle = getIntent().getExtras();
        String favpasada = bundle.getString("fav");
        tv2.setText(favpasada);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
