package com.example.david.explorebrno;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.orhanobut.hawk.Hawk;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AnswerActivity extends AppCompatActivity {

private int int_sada_otazek;
private int[] cisla_otazek;
private int number_of_rows;
private LinearLayout layout;
private Button button_continue;
private boolean WasItRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        layout = findViewById(R.id.layout);
        button_continue = findViewById(R.id.Continue);
        Hawk.init(this).build();


        Intent intent = getIntent();
        WasItRight = intent.getBooleanExtra("boolean", FALSE);
        cisla_otazek = intent.getIntArrayExtra("cisla_otazek");
        int_sada_otazek = intent.getIntExtra("int_sada_otazek", 1);

        Qanda qanda = new Qanda();
        number_of_rows = qanda.getNumberOfQuestions(int_sada_otazek);

        if(WasItRight == TRUE){
        cisla_otazek[int_sada_otazek]++;
        Hawk.put("cisla_otazek",cisla_otazek);
        }


        if (cisla_otazek[int_sada_otazek]%2 != number_of_rows){
            layout.setBackgroundColor(16777215);
        }

    }




    public void OnContinue (View view){

        if ((cisla_otazek[int_sada_otazek]+1)/2 +1  > number_of_rows){
            cisla_otazek[int_sada_otazek] = 0;
            Hawk.put("cisla_otazek",cisla_otazek);
            Intent intent_tomain = new Intent(this, MainActivity.class);
            intent_tomain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent_tomain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent_tomain);
        }

        else if (cisla_otazek[int_sada_otazek]%2==0){
            Intent intent_toquestion = new Intent(this, QuestionActivity.class);
            intent_toquestion.putExtra("cisla_otazek", cisla_otazek);
            intent_toquestion.putExtra("int_sada_otazek", int_sada_otazek);
            intent_toquestion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent_toquestion.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent_toquestion);


        }

        else{
            Intent intent_togeofence = new Intent(this, GeofenceActivity.class);
            intent_togeofence.putExtra("cisla_otazek", cisla_otazek);
            intent_togeofence.putExtra("int_sada_otazek", int_sada_otazek);

                intent_togeofence.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            intent_togeofence.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent_togeofence);

        }
    }


}




