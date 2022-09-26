package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.*;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 0, currentPos;
    HashSet<Integer> h=new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        h.add(currentPos);
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                int a=random.nextInt(quizModalArrayList.size());
                while(h.contains(a))
                {
                    a=random.nextInt(quizModalArrayList.size());
                }
                h.add(a);
                currentPos = a;
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                int a=random.nextInt(quizModalArrayList.size());
                while(h.contains(a))
                {
                    a=random.nextInt(quizModalArrayList.size());
                }
                h.add(a);
                currentPos = a;
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                int a=random.nextInt(quizModalArrayList.size());
                while(h.contains(a))
                {
                    a=random.nextInt(quizModalArrayList.size());
                }
                h.add(a);
                currentPos = a;
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                int a=random.nextInt(quizModalArrayList.size());
                while(h.contains(a))
                {
                    a=random.nextInt(quizModalArrayList.size());
                }
                h.add(a);
                currentPos = a;
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_result,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTv = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTv.setText("Your Score is \n"+ currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAttempted = 0;
                h.clear();
                currentPos = random.nextInt(quizModalArrayList.size());
                h.add(currentPos);
                setDataToViews(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private  void setDataToViews(int currentPos) {
        questionNumberTV.setText("Questions Attempted : "+questionAttempted + "/10");
        if(questionAttempted == 10) {
            showBottomSheet();
        } else{
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }

    }
    private void getQuizQuestion(ArrayList<QuizModal> quizModelArrayList) {
        quizModelArrayList.add(new QuizModal("Banker's Algorithm is used for","Prevent Deadlock","Recover Deadlock","Solve Deadlock","None","Prevent Deadlock"));
        quizModelArrayList.add(new QuizModal("Virtual Machine used by Android OS","Dalvik","JVM","Simple VM","None","Dalvik"));
        quizModelArrayList.add(new QuizModal("What is ADB in Android","Android Debug Bridge","Android Destination Bridge","Android Debug Barrier","None","Android Debug Bridge"));
        quizModelArrayList.add(new QuizModal("Layout in android aligns all children either vertically or horizontally","Relative","Table","Linear","Frame","Linear"));
        quizModelArrayList.add(new QuizModal("Command to remove a relation in SQL","Delete","Drop","Remove","Rollback","Drop"));
        quizModelArrayList.add(new QuizModal("FullForm of DDL","Data Duplicate Language","Data Definition Language","Data Derivation Language","None","Data Definition Language"));
        quizModelArrayList.add(new QuizModal("Android Version 8 is ","KitKat","Oreo","JellyBean","Lollipop","Oreo"));
        quizModelArrayList.add(new QuizModal("Which of the following is not an OS","Windows","Oracle","Linux","DOS","Oracle"));
        quizModelArrayList.add(new QuizModal("FullForm of AVD","Android Virtual Device","Actual Virtual Design","Accurate Virtual Device ","None","Android Virtual Device"));
        quizModelArrayList.add(new QuizModal("First Callback method invoked by system","onCreate","onClick","onStart","onRestart","onCreate"));
        quizModelArrayList.add(new QuizModal("What are the CPU scheduling algorithm","RoundRobin","Shortest Job First","First Come First  Serve","All of the above","All of the above"));
        quizModelArrayList.add(new QuizModal("Language on which Android is based ","C++","Python","C#","Java","Java"));
    }
}