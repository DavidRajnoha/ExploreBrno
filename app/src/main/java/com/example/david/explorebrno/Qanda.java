package com.example.david.explorebrno;
public class Qanda {
    //byl tady problém s kontextem,řešení z https://stackoverflow.com/questions/4253328/getstring-outside-of-a-context-or-activity jestli něco nebude úplně optimální, tak to tam prostě Hardcoduj a kašli na Resources
    public String[][][] qanda =
{
    {
        {App.getContext().getResources().getString(R.string.Set_1_Q1_Q), App.getContext().getResources().getString(R.string.Set_1_Q1_A1),App.getContext().getResources().getString(R.string.Set_1_Q1_A2),App.getContext().getResources().getString(R.string.Set_1_Q1_A3),App.getContext().getResources().getString(R.string.Set_1_Q1_A4)},
        {App.getContext().getResources().getString(R.string.Set_1_Q2_Q), App.getContext().getResources().getString(R.string.Set_1_Q2_A1),App.getContext().getResources().getString(R.string.Set_1_Q2_A2),App.getContext().getResources().getString(R.string.Set_1_Q2_A3),App.getContext().getResources().getString(R.string.Set_1_Q2_A4)},
        {App.getContext().getResources().getString(R.string.Set_1_Q3_Q), App.getContext().getResources().getString(R.string.Set_1_Q3_A1),App.getContext().getResources().getString(R.string.Set_1_Q3_A2),App.getContext().getResources().getString(R.string.Set_1_Q3_A3),App.getContext().getResources().getString(R.string.Set_1_Q3_A4)},
        {App.getContext().getResources().getString(R.string.Set_1_Q4_Q), App.getContext().getResources().getString(R.string.Set_1_Q4_A1),App.getContext().getResources().getString(R.string.Set_1_Q4_A2),App.getContext().getResources().getString(R.string.Set_1_Q4_A3),App.getContext().getResources().getString(R.string.Set_1_Q4_A4)},
    }
    ,
    {
        {App.getContext().getResources().getString(R.string.Set_2_Q1_Q), App.getContext().getResources().getString(R.string.Set_2_Q1_A1),App.getContext().getResources().getString(R.string.Set_2_Q1_A2),App.getContext().getResources().getString(R.string.Set_2_Q1_A3),App.getContext().getResources().getString(R.string.Set_2_Q1_A4)},
        {App.getContext().getResources().getString(R.string.Set_2_Q2_Q), App.getContext().getResources().getString(R.string.Set_2_Q2_A1),App.getContext().getResources().getString(R.string.Set_2_Q2_A2),App.getContext().getResources().getString(R.string.Set_2_Q2_A3),App.getContext().getResources().getString(R.string.Set_2_Q2_A4)},
        {App.getContext().getResources().getString(R.string.Set_2_Q3_Q), App.getContext().getResources().getString(R.string.Set_2_Q3_A1),App.getContext().getResources().getString(R.string.Set_2_Q3_A2),App.getContext().getResources().getString(R.string.Set_2_Q3_A3),App.getContext().getResources().getString(R.string.Set_2_Q3_A4)},
        {App.getContext().getResources().getString(R.string.Set_2_Q4_Q), App.getContext().getResources().getString(R.string.Set_2_Q4_A1),App.getContext().getResources().getString(R.string.Set_2_Q4_A2),App.getContext().getResources().getString(R.string.Set_2_Q4_A3),App.getContext().getResources().getString(R.string.Set_2_Q4_A4)},
    }
    ,
    {
        {App.getContext().getResources().getString(R.string.Set_3_Q1_Q), App.getContext().getResources().getString(R.string.Set_3_Q1_A1),App.getContext().getResources().getString(R.string.Set_3_Q1_A2),App.getContext().getResources().getString(R.string.Set_3_Q1_A3),App.getContext().getResources().getString(R.string.Set_3_Q1_A4)},
        {App.getContext().getResources().getString(R.string.Set_3_Q2_Q), App.getContext().getResources().getString(R.string.Set_3_Q2_A1),App.getContext().getResources().getString(R.string.Set_3_Q2_A2),App.getContext().getResources().getString(R.string.Set_3_Q2_A3),App.getContext().getResources().getString(R.string.Set_3_Q2_A4)},
        {App.getContext().getResources().getString(R.string.Set_3_Q3_Q), App.getContext().getResources().getString(R.string.Set_3_Q3_A1),App.getContext().getResources().getString(R.string.Set_3_Q3_A2),App.getContext().getResources().getString(R.string.Set_3_Q3_A3),App.getContext().getResources().getString(R.string.Set_3_Q3_A4)},
        {App.getContext().getResources().getString(R.string.Set_3_Q4_Q), App.getContext().getResources().getString(R.string.Set_3_Q4_A1),App.getContext().getResources().getString(R.string.Set_3_Q4_A2),App.getContext().getResources().getString(R.string.Set_3_Q4_A3),App.getContext().getResources().getString(R.string.Set_3_Q4_A4)}

    }
};


    public String[] getQuestions(int set, int otazka ){
   return qanda[set][otazka];
  }

  public int getNumberOfQuestions(int set){
       return qanda[set].length;
  }



}
