package com.example.thod0127.worldsmostbaasictextingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * @author Cody Henrichsen - Extra class assignment.
 */
public class TextingActivity extends AppCompatActivity
{
    private TextView sentText;
    private EditText smsMessageField;
    private EditText smsNumberField;
    private Button sendSMSButton;
    private Button number1;
    private Button number2;
    private Button randomMessage;
    private String trevorNumber;
    private String emilyNumber;
    private ArrayList<String> randomText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texting);

        sendSMSButton = (Button) findViewById(R.id.sendButton);
        smsMessageField = (EditText) findViewById(R.id.messageBox);
        smsNumberField = (EditText) findViewById(R.id.numberBox);
        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        randomMessage = (Button) findViewById(R.id.niceStuff);
        sentText = (TextView) findViewById(R.id.sentText);
        trevorNumber = "8016188606";
        emilyNumber = "8012050112";
        randomText = new ArrayList<>();

        setupList();
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

        number1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                smsNumberField.setText(trevorNumber);
            }
        });

        number2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                smsNumberField.setText(emilyNumber);
            }
        });

        randomMessage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                int messageSlot = (int)(Math.random() * randomText.size());
                String message = randomText.get(messageSlot);
                smsMessageField.setText(message);
            }
        });
    }

    private void sendSMS(String messageAddress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
        sentText.setText(messageContent);
    }

    private void setupList()
    {
        randomText.add("Hello!");
        randomText.add("Have a good day!");
        randomText.add("Have a great Summer / Winter / Spring / Fall!");
        randomText.add("Merry Holidays!");
        randomText.add("C u l8r!");
    }
}
