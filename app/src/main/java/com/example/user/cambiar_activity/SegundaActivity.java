package com.example.user.cambiar_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
 private TextView tv1;
 private Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tv1 = (TextView)findViewById(R.id.tv1);
        btn5 = (Button)findViewById(R.id.btn5);
        Bundle bundle = getIntent().getExtras();
        String etpasada = bundle.getString("url");
        tv1.setText(etpasada);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
