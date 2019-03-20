package id.harisgempong.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import id.harisgempong.harisformvalidation.components.FormValidation;
import id.harisgempong.harisformvalidation.interfaces.OnValidateListener;
import id.harisgempong.harisformvalidation.model.Request;

public class MainActivity extends AppCompatActivity {

    private EditText inputMath, inputEnglish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMath = findViewById(R.id.inputMath);
        inputEnglish = findViewById(R.id.inputEnglish);
    }

    public void simple(View view) {
        FormValidation formValidation = new FormValidation(this); // Initialize Class

        // Adding request to formValidation
        // Request object has 4 parameters : name, value, rules, required
        formValidation.addRequest(new Request("math", inputMath.getText().toString(), "max:30", true));
        formValidation.addRequest(new Request("english", inputEnglish.getText().toString(), "min:15|max:30", true));

        // setOnValidateListener
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr) {
                if (!isSuccessful) { // if not successful
                    fr.showError(); // show error
                } else {
                    // your code ..
                }
            }
        });
    }

    public void customText(View view) {
        FormValidation formValidation = new FormValidation(this, new CustomTextValidation()); // Initialize Class with Custom Text Rules

        // Adding request to formValidation
        // Request object has 4 parameters : name, value, rules, required
        formValidation.addRequest(new Request("math", inputMath.getText().toString(), "max:30", true));
        formValidation.addRequest(new Request("english", inputEnglish.getText().toString(), "min:15|max:30", true));

        // setOnValidateListener
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr) {
                if (!isSuccessful) { // if not successful
                    fr.showError(); // show error
                } else {
                    // your code ..
                }
            }
        });
    }

    public void customDisplay(View view) {
        FormValidation formValidation = new FormValidation(this); // Initialize Class

        // you can use hexa string or integer from resource for custom color
        formValidation.setBackgroundColor("74b9ff");
        formValidation.setIconColor("0984e3");
        formValidation.setTextColor("0984e3");
        formValidation.setBackgroundRowColor(getResources().getColor(R.color.colorMintLeaf));
        formValidation.setTextRowColor(getResources().getColor(R.color.colorSoothingBreeze));

        // Adding request to formValidation
        // Request object has 4 parameters : name, value, rules, required
        formValidation.addRequest(new Request("math", inputMath.getText().toString(), "max:30", true));
        formValidation.addRequest(new Request("english", inputEnglish.getText().toString(), "min:15|max:30", true));

        // setOnValidateListener
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr) {
                if (!isSuccessful) { // if not successful
                    fr.showError(); // show error
                } else {
                    // your code ..
                }
            }
        });
    }
}
