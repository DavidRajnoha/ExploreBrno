package com.example.david.explorebrno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GeofenceActivity extends AppCompatActivity {

    private int[] cisla_otazek;
    private int int_sada_otazek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geofence);
        Intent intent = getIntent();
        cisla_otazek = intent.getIntArrayExtra("cisla_otazek");
        int_sada_otazek = intent.getIntExtra("int_sada_otazek", 1);



    }


    public void ToQuestion(View view){
        cisla_otazek[int_sada_otazek]++;
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("cisla_otazek", cisla_otazek);
        intent.putExtra("int_sada_otazek", int_sada_otazek);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }



}
