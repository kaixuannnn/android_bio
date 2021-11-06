package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHobbies(v);
            }
        });
    }

    public void addHobbies(View view) {
        binding.hobbiesText.setText(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));
        binding.hobbiesText.setVisibility(View.VISIBLE);

        //hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}