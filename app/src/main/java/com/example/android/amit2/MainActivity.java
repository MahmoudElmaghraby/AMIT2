package com.example.android.amit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private ImageView myImage ;
    private TextView firstTV;
    private EditText passcodeET;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnCLR;
    private Button btnDEL;

    private String lastText;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // to not popup the keyboard when the app begin
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        myImage = findViewById(R.id.image);
        firstTV = findViewById(R.id.first_text_view);
        passcodeET = findViewById(R.id.passcode_edit_text);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCLR = findViewById(R.id.btn_clr);
        btnDEL = findViewById(R.id.btn_del);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "0"));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "1"));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "2"));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "3"));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "4"));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "5"));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "6"));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "7"));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "8"));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().insert(passcodeET.getText().length(), "9"));
            }
        });

        btnCLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText("");
            }
        });


        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passcodeET.setText(passcodeET.getText().delete(passcodeET.getText().length() - 1, passcodeET.getText().length()));
            }
        });

        passcodeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                lastText = passcodeET.getText().toString().trim();
                btnDEL.setEnabled(!lastText.isEmpty());

                if (passcodeET.getText().length() == 4) {
                    if (counter == 3 || counter == 2 || counter == 1 || counter == 0) {
                        if (lastText.equals("2332")) {
                            firstTV.setText("Correct passcode");
                            myImage.setImageResource(R.drawable.ic_lock_open);
                            disableButtons();
                        } else {
                            firstTV.setText("Wrong passcode");
                            passcodeET.setText("");
                            counter--;
                        }
                    } else {
                        firstTV.setText("you entered wrong 3 times ! ");
                        disableButtons();
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void disableButtons() {

        btn0.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btnDEL.setEnabled(false);
        btnCLR.setEnabled(false);

    }

}
