package com.cursoandroid.reciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.reciclerview.activity.MainActivity;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

    }
    /*Called when the user taps the Send button */
    public void sendMessage(View view){
        // Do something in response to button.
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}