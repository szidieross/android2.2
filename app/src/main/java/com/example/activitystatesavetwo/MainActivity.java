package com.example.activitystatesavetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;
    private static final String TAG = "ActivityStateSaveTwo";
    private static final String KEY_TEXT = "textKey";
    private static final String KEY_CHECKED = "checkedKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);

        if (savedInstanceState != null) {
            String savedText = savedInstanceState.getString(KEY_TEXT);
            boolean isChecked = savedInstanceState.getBoolean(KEY_CHECKED);

            editText.setText(savedText);
            checkBox.setChecked(isChecked);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_TEXT, editText.getText().toString());
        outState.putBoolean(KEY_CHECKED, checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String savedText = savedInstanceState.getString(KEY_TEXT);
        boolean isChecked = savedInstanceState.getBoolean(KEY_CHECKED);

        editText.setText(savedText);
        checkBox.setChecked(isChecked);
    }
}