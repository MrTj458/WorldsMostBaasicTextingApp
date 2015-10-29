package com.example.thod0127.worldsmostbaasictextingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class TextingActivity extends AppCompatActivity
{
    private EditText smsMessageField;
    private EditText smsNumberField;
    private Button sendSMSButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texting);

        sendSMSButton = (Button) findViewById(R.id.sendButton);
        smsMessageField = (EditText) findViewById(R.id.messageBox);
        smsNumberField = (EditText) findViewById(R.id.numberBox);

        setupListeners();
    }

    private void setupListeners()
    {
        sendSMSButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                try
                {
                    String contact = smsNumberField.getText().toString();
                    String message = smsMessageField.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "Message was sent", Toast.LENGTH_LONG).show();
                }
                catch (Exception currentException)
                {
                    Toast.makeText(currentView.getContext(), "Message not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void sendSMS(String messageAdress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAdress, null, messageContent, null, null);
    }
}
