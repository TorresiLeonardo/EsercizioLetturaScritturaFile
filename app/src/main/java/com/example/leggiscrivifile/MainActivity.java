package com.example.leggiscrivifile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //le eccezioni possono essere controllate e non controllate
    EditText txtNomeFile;
    Button btnLeggi;
    Button btnScrivi;
    Gestore gest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNomeFile = (EditText)findViewById(R.id.txtNomeFile);
        btnLeggi=(Button)findViewById(R.id.btnLeggi);
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeFile =  txtNomeFile.getText().toString();
                String righeLette= gest.leggiFile(nomeFile, getApplicationContext());

                //metodo per passare variabili trovato su internet
                Intent i = new Intent(MainActivity.this, FileActivity.class);
                i.putExtra("righeLette", righeLette);
                startActivity(i);
                startActivity(new Intent(MainActivity.this, FileActivity.class));
            }
        });
    }

    btnScrivi.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            String nomeFile =  txtNomeFile.getText().toString();
            esito= gest.scriviFile(nomeFile, getApplicationContext());
            Toast.makeText(getApplicationContext(), esito, Toast.LENGHT_LONG).show();
        }
    });
}
