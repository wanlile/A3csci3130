package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, businesField, primaryField, addressField, provinceField ;
    private MyApplicationData appState;

    /**
     * This method use to initialize all the fields.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        businesField = (EditText) findViewById(R.id.bn);
        primaryField = (EditText) findViewById(R.id.pb);
        addressField = (EditText) findViewById(R.id.addr);
        provinceField = (EditText) findViewById(R.id.pt);
    }

    /**
     * This method use to submit the information to the firebase.
     * @param v
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
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
}
