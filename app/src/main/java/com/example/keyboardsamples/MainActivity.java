package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button show;
    EditText nameE, numberE, emailE;
    Spinner spinner;
    TextView name, number, email, type;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameE = findViewById(R.id.editTextNmae);
        numberE = findViewById(R.id.editTextNumber);
        emailE = findViewById(R.id.editTextEmail);

        name = findViewById(R.id.infoName);
        number = findViewById(R.id.infoNumber);
        email = findViewById(R.id.infoEmail);
        type = findViewById(R.id.infoType);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        nameE.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(MainActivity.this, nameE.getText() , Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        show = findViewById(R.id.bShow);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("Name: "+nameE.getText());
                number.setText("Number: "+numberE.getText());
                email.setText("Email: "+emailE.getText());
                type.setText("Type: "+spinner.getSelectedItem().toString());

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}