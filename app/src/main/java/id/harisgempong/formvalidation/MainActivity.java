package id.harisgempong.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.OnValidateListener;
import id.harisgempong.harisformvalidation.model.NewRequest;

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
        NewFormValidation formValidation = new NewFormValidation(this);
        formValidation.addRequest(new NewRequest("math", inputMath.getText().toString()).number().max(20).validate());
        formValidation.addRequest(new NewRequest("english", inputEnglish.getText().toString()).number().min(30).validate());
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, NewFormValidation fr) {
                if (!isSuccessful) {
                    fr.showError();
                }
            }
        });
    }

    public void customText(View view) {
        NewFormValidation formValidation = new NewFormValidation(this, new CustomTextValidation()); // Initialize Class with Custom Text Rules

        // Adding request to formValidation
        // Request object has 4 parameters : name, value, rules, required
        formValidation.addRequest(new NewRequest("math", inputMath.getText().toString()).number().max(20).validate());
        formValidation.addRequest(new NewRequest("english", inputEnglish.getText().toString()).number().min(30).validate());

        // setOnValidateListener
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, NewFormValidation fr) {
                if (!isSuccessful) { // if not successful
                    fr.showError(); // show error
                } else {
                    // your code ..
                }
            }
        });
    }

    public void customDisplay(View view) {
        NewFormValidation formValidation = new NewFormValidation(this); // Initialize Class

        // you can use hexa string or integer from resource for custom color
        formValidation.setBackgroundColor("74b9ff");
        formValidation.setIconColor("0984e3");
        formValidation.setTextColor("0984e3");
        formValidation.setBackgroundRowColor(R.color.colorMintLeaf);
        formValidation.setTextRowColor(R.color.colorSoothingBreeze);

        // Adding request to formValidation
        // Request object has 4 parameters : name, value, rules, required
        formValidation.addRequest(new NewRequest("math", inputMath.getText().toString()).number().max(20).validate());
        formValidation.addRequest(new NewRequest("english", inputEnglish.getText().toString()).number().min(30).validate());

        // setOnValidateListener
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, NewFormValidation fr) {
                if (!isSuccessful) { // if not successful
                    fr.showError(); // show error
                } else {
                    // your code ..
                }
            }
        });
    }
}
