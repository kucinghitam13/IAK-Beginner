package com.example.android.iak_beginner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Pertanyaan3Activity extends AppCompatActivity {

    int nilai, jumlahCheck; // deklarasi variabel nilai untuk nyimpen skor dan jumlahCheck untuk nyimpen jumlah berapa checkbox yang di-check

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan3);

        nilai = getIntent().getIntExtra("nilai2", 0);

        CheckBox[] cbJawaban = {                // bikin array dari checkbox yang isinya kumpulan checkbox jawaban
                findViewById(R.id.cb_run),      // https://developer.android.com/reference/java/util/Arrays.html
                findViewById(R.id.cb_eat),      // https://classroom.udacity.com/courses/ud839/lessons/7709673667/concepts/78832374510923
                findViewById(R.id.cb_sleep),
                findViewById(R.id.cb_bed),
                findViewById(R.id.cb_walk),
                findViewById(R.id.cb_write),
                findViewById(R.id.cb_food),
                findViewById(R.id.cb_read),
                findViewById(R.id.cb_book),
                findViewById(R.id.cb_drive)
        };

        for (CheckBox cb : cbJawaban) {
            setCheckBoxCheckedListener(cb);
        }
    }

    private void setCheckBoxCheckedListener(final CheckBox cb){
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) { // event yang bakal jalan kalo ada perubahan check pada checkbox (mau di-check ataupun uncheck_
                if (cb.isChecked()) { // kalo misalnya perubahannya di-check
                    if (jumlahCheck < 3) {
                        jumlahCheck++; // kalo jumlah yang di-check masih kurang dari 3, tambahin jumlahCheck
                    } else {// kalo yang di-check udah 3 atau lebih
                        cb.setChecked(false); // uncheck yang habis di-check
                        Toast.makeText(getApplicationContext(), "Maksimum 3 pilihan", Toast.LENGTH_SHORT).show(); // tampilin notifikasi
                    }
                } else { // kalo perubahannya di-uncheck
                    jumlahCheck--; // kalo di-uncheck, kurangin jumlahCheck
                }
            }
        });
    }

    public void check3(View v){
        CheckBox bed = findViewById(R.id.cb_bed);
        CheckBox food = findViewById(R.id.cb_food);
        CheckBox book = findViewById(R.id.cb_book);
        Button buttonNext = findViewById(R.id.b_next3);
        if(bed.isChecked() && food.isChecked() && book.isChecked()){
            nilai += 40;
            Toast.makeText(this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }
        bed.setBackgroundResource(R.color.colorBenar);
        food.setBackgroundResource(R.color.colorBenar);
        book.setBackgroundResource(R.color.colorBenar);

        buttonNext.setEnabled(true);
        v.setEnabled(false);
    }

    public void next3(View v){
        Intent i = new Intent(this, HasilActivity.class);
        i.putExtra("nilai3", nilai);
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
