package com.example.android.iak_beginner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        int nilai = getIntent().getIntExtra("nilai3", 0);

        TextView nilaiText = findViewById(R.id.t_nilai);
        nilaiText.setText(String.valueOf(nilai));
        if (nilai >=60){
            nilaiText.setTextColor(getResources().getColor(R.color.colorBenar));
        }else{
            nilaiText.setTextColor(getResources().getColor(R.color.colorSalah));
        }
    }

    public void mainMenu(View v){
        onBackPressed();
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, MenuActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}
