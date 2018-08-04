package com.example.david.explorebrno;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;


        import java.util.Random;


public class QuestionActivity extends AppCompatActivity {

   // private int number_of_rows;
    private int int_sada_otazek;
    private int[] cisla_otazek;
    private int number_of_rows;
    private TextView textview_question;
    private Button button_answer_1;
    private Button button_answer_2;
    private Button button_answer_3;
    private Button button_answer_4;
    private String rightanswer;
    Qanda qanda = (new Qanda());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (savedInstanceState != null) {
            cisla_otazek = savedInstanceState.getIntArray("cisla_otazek");
            int_sada_otazek = savedInstanceState.getInt("int_sada_otazek");
        }
        else {
            Intent intent = getIntent();
            int_sada_otazek = intent.getIntExtra("int_sada_otazek",1); //získá se sada, kterou si uživatel vybral
            cisla_otazek = intent.getIntArrayExtra("cisla_otazek");
        }


        textview_question = findViewById(R.id.textview_question);
        button_answer_1 = findViewById(R.id.button_answer_1);
        button_answer_2 = findViewById(R.id.button_answer_2);
        button_answer_3 = findViewById(R.id.button_answer_3);
        button_answer_4 = findViewById(R.id.button_answer_4);

        GetQuestions();  //zavolání funkce pro načtení otázek
    }


    public void onSaveInstanceState(Bundle outState) {
        outState.putIntArray("cisla_otazek",cisla_otazek);
        outState.putInt("int_sada_otazek", int_sada_otazek);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }


    public void OnClick(View view) { //při stistknutí tlačítká má tato funkce vzít text z tlačítka, a porovnat ho se správnou odpovědí

        Button Button_Answer = (Button) view;
        String answer = Button_Answer.getText().toString();
        Boolean WasItRight = Boolean.FALSE;

        if (rightanswer.equals(answer)) {
            WasItRight = Boolean.TRUE;
        }

        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("boolean", WasItRight);
        intent.putExtra("cisla_otazek", cisla_otazek);
        intent.putExtra("int_sada_otazek", int_sada_otazek);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



    public void GetQuestions(){
        String[] AnswerArray = qanda.getQuestions(int_sada_otazek,cisla_otazek[int_sada_otazek]/2); //získají se otázky z databáze

        rightanswer = AnswerArray[0]; //zapsání správné odpovědi
        textview_question.setText(AnswerArray[4]);

        shuffleArray(AnswerArray); //zamíchání otázek

        button_answer_1.setText(AnswerArray[0]);
        button_answer_2.setText(AnswerArray[1]);
        button_answer_3.setText(AnswerArray[2]);
        button_answer_4.setText(AnswerArray[3]);
    }



//míchání otázek
        static void shuffleArray(String[] ar) { //zamíchání pole
            Random r = new Random();
            for (int i = ar.length - 1 - 1; i > 0; i--) {
                int index = r.nextInt(i + 1);
                // Simple swap
                String a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }





}
