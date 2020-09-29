package com.example.challenge7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.challenge7.models.Biodata;

import java.text.SimpleDateFormat;

public class Hasil extends AppCompatActivity {

    //intent key
    public static final String Key_HasilActivity = "Key_HasilActivity";
    MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SimpleDateFormat dateFormatter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        Intent intent = getIntent();
        Biodata biodata = intent.getParcelableExtra(Key_HasilActivity);

        TextView nama = (TextView) findViewById(R.id.txtNama);
        TextView nim = (TextView) findViewById(R.id.txtNim);
        TextView tgllahir = (TextView) findViewById(R.id.txtLahir);
        TextView jur = (TextView) findViewById(R.id.txtJurusan);
        TextView jk = (TextView) findViewById(R.id.txtJk);

        if (biodata != null){
            nama.setText(biodata.getNama());
            nim.setText(biodata.getNim());
            tgllahir.setText(biodata.getTglLahir());
            jk.setText(biodata.getJk());
            jur.setText(biodata.getJurusan());

        } else if (getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            nama.setText(bundle.getString("nama"));
            nim.setText(bundle.getString("nim"));
            tgllahir.setText(bundle.getString("lahir"));
            jk.setText(bundle.getString("jk"));
            jur.setText(bundle.getString("jurusan"));
        }
    }
}