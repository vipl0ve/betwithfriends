package com.android.viplove.betwithfriends.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.viplove.betwithfriends.R;
import com.android.viplove.betwithfriends.database.UserRepo;
import com.android.viplove.betwithfriends.users.BetUser;

public class SignUpActivity extends AppCompatActivity {

    private String userAge;
    private String userGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

/*        final Spinner spinnerAge = (Spinner) findViewById(R.id.spinner_age);
        final Spinner spinnerGender = (Spinner) findViewById(R.id.spinner_gender);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterAge = ArrayAdapter.createFromResource(this, R.array.array_age,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this, R.array.array_gender, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAge.setAdapter(adapterAge);
        spinnerGender.setAdapter(adapterGender);

        spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                userAge = spinnerAge.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                userGender = spinnerGender.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });*/
    }

    public void addNewUser(View view) {
        EditText userName = (EditText) findViewById(R.id.sign_up_name);
        EditText userAge = (EditText) findViewById(R.id.sign_up_age);
        EditText userGender = (EditText) findViewById(R.id.sign_up_gender);
        EditText userPhone = (EditText) findViewById(R.id.sign_up_phone);
        EditText userEmail = (EditText) findViewById(R.id.sign_up_email);
        EditText userPwd = (EditText) findViewById(R.id.sign_up_pwd);
        TextView userMessage = (TextView) findViewById(R.id.sign_up_msg);


        BetUser newUser = new BetUser();
        newUser.addNewUser(userName.getText().toString(), Integer.valueOf(userAge.getText().toString()), this.userGender, userPhone.getText().toString(), userEmail.getText().toString(), "", userPwd.getText().toString());

        Toast.makeText(SignUpActivity.this, "User " + userName.getText().toString() + " is created successfully.", Toast.LENGTH_LONG).show();

        UserRepo dbHandler = new UserRepo(this, null, null, 1);
        dbHandler.addNewUserRow(newUser);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    public void resetUser(View view) {
        EditText userName = (EditText) findViewById(R.id.sign_up_name);
        EditText userAge = (EditText) findViewById(R.id.sign_up_age);
        EditText userGender = (EditText) findViewById(R.id.sign_up_gender);
        EditText userPhone = (EditText) findViewById(R.id.sign_up_phone);
        EditText userEmail = (EditText) findViewById(R.id.sign_up_email);
        EditText userPwd = (EditText) findViewById(R.id.sign_up_pwd);
        TextView userMessage = (TextView) findViewById(R.id.sign_up_msg);

        userName.setText("");
        userAge.setText("");
        userGender.setText("");
        userPhone.setText("");
        userEmail.setText("");
        userPwd.setText("");
        userMessage.setText("");

    }
}
