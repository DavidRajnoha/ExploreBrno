package com.example.david.explorebrno;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import java.io.FileNotFoundException;


public class MainActivity extends AppCompatActivity implements ContinueDialogFragment.ContinueDialogListener {

    private int[] cisla_otazek;
    int int_sada_otazek;

    public TextView textview_question;
    private Button button_answer_1;
    private Button button_answer_2;
    private Button button_answer_3;
    private Button button_answer_4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_question = findViewById(R.id.textview_question);
        button_answer_1 = findViewById(R.id.button_answer_1);
        button_answer_2 = findViewById(R.id.button_answer_2);
        button_answer_3 = findViewById(R.id.button_answer_3);
        button_answer_4 = findViewById(R.id.button_answer_4);
        Hawk.init(this).build();




//        cisla_otazek = new int[] {0,0,0,0,0,0};


    }

    @Override
    protected void onStart(){
        super.onStart();

        if (Hawk.contains("cisla_otazek")) {
            cisla_otazek = Hawk.get("cisla_otazek");
            Toast.makeText(this, "HawkEmployed",
                    Toast.LENGTH_LONG).show();
        } else {
            cisla_otazek = new int[] {0,0,0};
        }

    }



    public void OnClickSet_1(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        Button b = (Button) view;
        String sada_otazek = b.getText().toString();

        if (getString(R.string.Sada_1).equals(sada_otazek)) {
            int_sada_otazek = 0;
        } else if (getString(R.string.Sada_2).equals(sada_otazek)) {
            int_sada_otazek = 1;
        } else if (getString(R.string.Sada_3).equals(sada_otazek)) {
            int_sada_otazek = 2;
        }

        if (cisla_otazek[int_sada_otazek] != 0) {

            doContinue();


        }else {

            intent.putExtra("cisla_otazek", cisla_otazek);
            intent.putExtra("int_sada_otazek", int_sada_otazek);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }



        }


    public void doContinue(){
        DialogFragment continueFragment = new ContinueDialogFragment();
        continueFragment.show(getFragmentManager(), "doContinue");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if (cisla_otazek[int_sada_otazek]%2==0){
            Intent intent = new Intent(this, QuestionActivity.class);
            intent.putExtra("cisla_otazek", cisla_otazek);
            intent.putExtra("int_sada_otazek", int_sada_otazek);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);


        }else{
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("cisla_otazek", cisla_otazek);
        intent.putExtra("int_sada_otazek", int_sada_otazek);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);}
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        cisla_otazek[int_sada_otazek] = 0;
        Hawk.put("cisla_otazek", cisla_otazek);
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("cisla_otazek", cisla_otazek);
        intent.putExtra("int_sada_otazek", int_sada_otazek);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog) {

    }
}

