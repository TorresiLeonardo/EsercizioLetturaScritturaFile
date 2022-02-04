package com.example.leggiscrivifile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class FileActivity extends AppCompatActivity {
    TextView nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        nf=(TextView) findViewById(R.id.testoFile);
        Bundle extras = getIntent().getExtras();
        String righeLette = extras.getString("righeLette");
        nf.setText(righeLette);
    }
}