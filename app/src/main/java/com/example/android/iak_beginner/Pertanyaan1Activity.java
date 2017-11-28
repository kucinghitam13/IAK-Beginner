package com.example.android.iak_beginner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pertanyaan1Activity extends AppCompatActivity {

    int nilai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan1);
    }

    public void check1(View v) {
        RadioGroup rg = findViewById(R.id.rg_jawaban); //ambil view dari RadioGroup-nya (bukan RadioButton)
        int radioButtonCheckedId = rg.getCheckedRadioButtonId(); //ambil id dari RadioButton yang di-check/pilih di dalem RadioGroup, kalo gak ada yang di-check sama sekali bakal ngembaliin nilai -1

        if(radioButtonCheckedId != -1){ //apakah id yang dikembaliin bukan -1 (-1 artinya gak ada yang di-check)
            if (radioButtonCheckedId == R.id.rb_ate) { // apakah id nya sama kaya id rb_ate
                nilai += 30;
                Toast.makeText(getApplicationContext(), "Jawaban Benar!", Toast.LENGTH_SHORT).show();
                findViewById(R.id.rb_ate).setBackgroundResource(R.color.colorBenar);
            }else{ // else kalo bukan rb_ate berarti salah
                Toast.makeText(getApplicationContext(), "Jawaban salah!", Toast.LENGTH_SHORT).show();
                findViewById(radioButtonCheckedId).setBackgroundResource(R.color.colorSalah);
                findViewById(R.id.rb_ate).setBackgroundResource(R.color.colorBenar);
            }

            for (int i = 0; i < rg.getChildCount(); i++) {
                rg.getChildAt(i).setEnabled(false); // looping buat bikin semua RadioButton di dalem RadioGroup enabled nya jadi false
            }

            Button buttonNext = findViewById(R.id.b_next1); //button next
            buttonNext.setEnabled(true);
            v.setEnabled(false);
        }else{
            Toast.makeText(getApplicationContext(), "Pilih jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void next1(View v) {
        Intent i = new Intent(this, Pertanyaan2Activity.class);
        i.putExtra("nilai1", nilai);
        startActivity(i);
        finish();
    }
}
