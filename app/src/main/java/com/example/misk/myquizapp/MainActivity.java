package com.example.misk.myquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    *This function checks answers and displays the result
     */
    public void submitAnswers(View view) {
        //Declare & initialize a variables
        int userScore = 0;

        //Question #2 has two right answers
        boolean q2_answer1 = false;
        boolean q2_answer2 = false;

        //The app crashes when these variables are null, so here we give an initial value
        String q3_answer = "";
        String q4_answer = "";
        String q5_answer = "";


        //Get the input value the user entered for question #1
        EditText q1_answer_view = (EditText) findViewById(R.id.q1_answer_view);
        String q1_answer = q1_answer_view.getText().toString();

        //Check if answer  2, 3 (the right answers) for question #2 are checked or not
        CheckBox q2_answer1_box = (CheckBox) findViewById(R.id.q2_answer2_checkbox);
        q2_answer1 = q2_answer1_box.isChecked();
        CheckBox q2_answer2_box = (CheckBox) findViewById(R.id.q2_answer3_checkbox);
        q2_answer2 = q2_answer2_box.isChecked();

        //Get the selected radio button from q3 group
        RadioGroup q3_radio_group = (RadioGroup) findViewById(R.id.q3_radio_group);
        int q3_selectedID = q3_radio_group.getCheckedRadioButtonId();
        // The id will be -1 if none of the group is selected
        if (q3_selectedID != -1) {
            RadioButton q3_answer_view = (RadioButton) findViewById(q3_selectedID);
            q3_answer = q3_answer_view.getText().toString();
        }

        //Get the selected radio button from q4 group
        RadioGroup q4_radio_group = (RadioGroup) findViewById(R.id.q4_radio_group);
        int q4_selectedID = q4_radio_group.getCheckedRadioButtonId();
        if (q4_selectedID != -1) {
            RadioButton q4_answer_view = (RadioButton) findViewById(q4_selectedID);
            q4_answer = q4_answer_view.getText().toString();
        }
        //Get the selected radio button from q5group
        RadioGroup q5_radio_group = (RadioGroup) findViewById(R.id.q5_radio_group);
        int q5_selectedID = q5_radio_group.getCheckedRadioButtonId();
        if (q3_selectedID != -1) {
            RadioButton q5_answer_view = (RadioButton) findViewById(q5_selectedID);
            q5_answer = q5_answer_view.getText().toString();
        }
        /* Check the user's answers & update the score,
        * display a toast if the user hasn't answer a question
        */
        if (q1_answer.length() == 0)
            Toast.makeText(this, "You haven't answer question 1", Toast.LENGTH_SHORT).show();
        else if (q1_answer.matches("Pi"))
            userScore += 1;

        if (q2_answer1 && q2_answer2)
            userScore += 1;

        if (q3_answer == "")
            Toast.makeText(this, "You haven't answer question 3", Toast.LENGTH_SHORT).show();
        else if (q3_answer.matches("3216"))
            userScore += 1;

        if (q4_answer == "")
            Toast.makeText(this, "You haven't answer question 4", Toast.LENGTH_SHORT).show();
        else if (q4_answer.matches("12"))
            userScore += 1;

        if (q5_answer == "")
            Toast.makeText(this, "You haven't answer question 5", Toast.LENGTH_SHORT).show();
        else if (q5_answer.matches("Eating"))
            userScore += 1;

        //Display the score
        TextView score_view = (TextView) findViewById(R.id.score_text_view);
        score_view.setText(String.valueOf(userScore));

    }
}
