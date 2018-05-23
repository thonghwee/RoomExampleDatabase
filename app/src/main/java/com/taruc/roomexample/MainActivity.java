package com.taruc.roomexample;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextGender;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all the view
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        editTextName= (EditText) findViewById(R.id.editTextName);
        editTextGender= (EditText) findViewById(R.id.editTextGender);

        buttonSave= (Button) findViewById(R.id.buttonSave);
        //set Listener

        buttonSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        //grab input from user
       String email= editTextEmail.getText().toString();
        String name= editTextName.getText().toString();
        String gender= editTextGender.getText().toString();

        User user= new User(email,name, gender);

        //Save into database
        MyAppDatabase db= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"users").allowMainThreadQueries().build();
        db.myDao().addUser(user);

    }
}
