package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, businesField, primaryField, addressField, provinceField ;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    /**
     * This method is use to get the information online and put it in different text field.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        businesField = (EditText) findViewById(R.id.bnu);
        primaryField = (EditText) findViewById(R.id.pbu);
        addressField = (EditText) findViewById(R.id.addre);
        provinceField = (EditText) findViewById(R.id.ptu);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            businesField.setText(receivedPersonInfo.busines);
            primaryField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    /**
     * This method get the all the strings and update all the strings to firebase.
     *
     * @param v
     */
    public void updateContact(View v){
        //TODO: Update contact funcionality
        appState = ((MyApplicationData) getApplicationContext());

        String personID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String busines = businesField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        if (!Contact.validate(name,busines,primary,address,province)){
            return;
        }

        Contact person = new Contact(personID, name, busines,primary, address, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }

    /**
     * This method use to erase all the information from firebase.
     * @param v
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();
    }
}
