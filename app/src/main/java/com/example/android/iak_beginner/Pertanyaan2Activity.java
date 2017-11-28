package com.example.android.iak_beginner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pertanyaan2Activity extends AppCompatActivity {

    int nilai;
    private static final String TAG = "Pertanyaan2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan2);

        nilai = getIntent().getIntExtra("nilai1",0);
    }

    public void check2(View v){
        EditText editAnswer = findViewById(R.id.e_answer);
        String answer = editAnswer.getText().toString();
        if(!answer.isEmpty()){
            if(answer.equalsIgnoreCase("under")){
                nilai += 30;
                Toast.makeText(getApplicationContext(), "Jawaban Benar!", Toast.LENGTH_SHORT).show();
                editAnswer.setBackgroundResource(R.color.colorBenar);
            }else{
                Toast.makeText(getApplicationContext(), "Jawaban salah!", Toast.LENGTH_SHORT).show();
                editAnswer.setBackgroundResource(R.color.colorSalah);
            }
            Button buttonNext = findViewById(R.id.b_next2);
            editAnswer.setEnabled(false);
            buttonNext.setEnabled(true);
            v.setEnabled(false);
        }else{
            Toast.makeText(this, "Isi jawaban terlebih dahulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void next2(View v){
        Intent i = new Intent(this, Pertanyaan3Activity.class);
        i.putExtra("nilai2", nilai);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, MenuActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}
