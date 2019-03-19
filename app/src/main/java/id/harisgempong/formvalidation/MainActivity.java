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

    public void check(View view) {
        FormValidation formValidation = new FormValidation(this);
        formValidation.addRequest(new Request("math", inputMath.getText().toString(), "max:30", true));
        formValidation.addRequest(new Request("english", inputEnglish.getText().toString(), "min:15|max:30", true));
        formValidation.setOnValidateListener(new OnValidateListener() {
            @Override
            public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr) {
                if (!isSuccessful) {
                    fr.showError();
                }
            }
        });
    }
}
