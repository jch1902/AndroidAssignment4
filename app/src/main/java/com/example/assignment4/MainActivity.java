/*
CSE41246 - Android Java Fundamentals
Winter 2019
Assignment 4
Hoong, Jasper
 */
package com.example.assignment4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout1 = null;
    Button ClickMe = null;
    int buttonNumber = 1;
    ScrollView scrollView = null;
    LinearLayout layout2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.layout1 = (LinearLayout)findViewById(R.id.layout1);
        this.ClickMe = (Button)findViewById(R.id.button);
        this.scrollView = (ScrollView)findViewById(R.id.scrollView);
        this.layout2 = (LinearLayout)findViewById(R.id.layout2);
        // TO-DO:
        // 1. Create a reference to the main layout.
        // 2. Create a reference to the start button and make the callback.
        ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewButton();
            }
        });
    }
    private void generateNewButton() {
            // Generates a new Button widget dynamically.
        Button newButton = new Button(MainActivity.this);
            // 1. Set the layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        newButton.setTextColor(getRandomColor());// 2. Create the button and define the look (i.e. text, text, color, etc.)
        buttonNumber++;
        newButton.setText("Button Number: " + buttonNumber);
            // 3. Create a callback that will generate another widget.
            // 4. Disable the last button.
        layout2.addView(newButton); // 5. Add the Button to the current view.
    }
    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
