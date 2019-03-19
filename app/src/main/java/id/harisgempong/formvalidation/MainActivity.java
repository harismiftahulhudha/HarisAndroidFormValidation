package id.harisgempong.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import id.harisgempong.harisformvalidation.components.FormValidation;
import id.harisgempong.harisformvalidation.interfaces.OnValidateListener;
import id.harisgempong.harisformvalidation.model.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FormValidation formValidation = new FormValidation(this);
        formValidation.addRequest(new Request("math", 40, "max:30", true));
        formValidation.addRequest(new Request("english", 10, "min:15|max:30", true));
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
