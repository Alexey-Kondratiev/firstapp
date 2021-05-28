package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.Question;
import com.example.myapplication.R;

public class MainActivity extends Activity {

    Button yesBtn;
    Button noBtn; 
    TextView textView;
  public Question[] questions=new Question[] {
    new Question(R.string.question0,false),
    new Question(R.string.question1,true),
    new Question(R.string.question2,true),
    new Question(R.string.question3,false),
    new Question(R.string.question4,false),
    new Question(R.string.question5,true) };
    
    public int questionIndex=0;
    
//    boolean[] results= new boolean[6];
    String results;

//    Запуск метода "onCreate"

    @Override
    public void onCreate (Bundle savedInstanceState) {    //Открытие onCreate
     
    super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_main);

// Запрос текущего индекса массива вопросов
       
        if(savedInstanceState !=null)         
        questionIndex= savedInstanceState.getInt("questionIndex");

//  Связь со ссылками в activity_main.xml

        yesBtn=findViewById(R.id.btnYes);
        noBtn=findViewById(R.id.btnNo);
        textView=findViewById(R.id.textView);
        textView.setText(questions[questionIndex].getQuestionResId());

//           Запуск теста

        yesBtn.setOnClickListener(new View.OnClickListener() {  // Открытие yesBtn
      
//        Запуск метода onClick
      
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue()) Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();     
    
    questionIndex= (questionIndex+1)%questions.length;  
     
    if(questionIndex>0) textView.setText(questions[questionIndex].getQuestionResId());      
                         
    else {
       Intent intent=new  Intent(MainActivity.this,ResultActivity.class);    
       intent.putExtra("results",results); // Здесь должен быть массив с данными
       startActivity(intent);
       finish();
     }                     
   }        // Закрытие метода onClick
 });        // Закрытие метода yesBtn
         
     noBtn.setOnClickListener(new View.OnClickListener() {   // Открытие noBtn
      
//         Запуск метода onClick

            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue()) Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                
      questionIndex= (questionIndex+1)%questions.length;
    
      if(questionIndex>0)
t     textView.setText(questions[questionIndex].getQuestionResId());
  
      else {
      Intent intent=new  Intent(MainActivity.this,ResultActivity.class);   
      intent.putExtra("results",results); // Здесь должен быть массив с данными   
      startActivity(intent);
      finish();
      }   
     }         // Закрытие метода onClick
   } );        // Закрытие метода noBtn
 } // Закрытие метода onCreate

// Сохранение индекса при перезапуске MainActivity

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
   super.onSaveInstanceState(savedInstanceState);
     savedInstanceState.putInt("questionIndex",questionIndex);   
  } 
}
