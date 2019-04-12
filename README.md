# HarisAndroidFormValidation

Library for validating android form. This library is under development to enrich the validation feature.

### Installing

Add this to your project's `build.gradle`

```
allprojects {
      repositories {
            ...
            maven { url 'https://jitpack.io' }
      }
}
```

And add this to your module's `build.gradle`

```
dependencies {
      implementation 'com.github.harismiftahulhudha:HarisAndroidFormValidation:x.y.z'
}
```

change `x.y.z` to version in the [release page](https://github.com/harismiftahulhudha/HarisAndroidFormValidation/releases)

## Usage

For full example, please refer to the `app`

### Standart Usage

The standard way to start Take me to [pookie](#pookie)
```
FormValidation formValidation = new FormValidation(this); // Initialize Class

// Adding request to formValidation
// Request object has 2 parameters : name, value
formValidation.addRequest(new Request("math", inputMath.getText().toString()).number().max(20).validate());
formValidation.addRequest(new Request("english", inputEnglish.getText().toString()).number().min(30).validate());

// setOnValidateListener
formValidation.setOnValidateListener(new OnValidateListener() {
      @Override
      public void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr) {
            if (!isSuccessful) { // if not successful
                  fr.showError(); // show error
                  // you can also create your own view and using validationMessages object for data output
            } else {
                  // your code ..
            }
      }
});
```
You can also create custom text rules by creating your own custom class and implementing `TextValidation` interface. <enter>
then enter the custom class into formValidation initialization.
```
// Initialize Class with Custom Text Rules
FormValidation formValidation = new FormValidation(this, new CustomTextValidation());
```

### Custom Color View
```
// you can use hexa string or integer from resource for custom color
formValidation.setBackgroundColor("74b9ff");
formValidation.setIconColor("0984e3");
formValidation.setTextColor("0984e3");
formValidation.setBackgroundRowColor(getResources().getColor(R.color.colorMintLeaf));
formValidation.setTextRowColor(getResources().getColor(R.color.colorSoothingBreeze));
```

### Table Rules
| Rules           | Description   |
| :-------------: | ------------- |
| max             | The field under validation must be less than or equal to a maximum value. Strings, numerics, arrays, and files are evaluated in the same fashion as the `size` rule.  |
| min             | The field under validation must have a minimum value. Strings, numerics, arrays, and files are evaluated in the same fashion as the `size` rule.                      |
| email           | The field under validation must be formatted as an e-mail address.                                                                                                    |
| maxlength       | The field under validation must be less than or equal to a maximum value. Strings are evaluated in the same fashion as the `length` of the characters                 |
| minlength       | The field under validation must have a minimum value. Strings are evaluated in the same fashion as the `length` of the characters                                     |
| alpha           | The field under validation must be entirely alphabetic characters.                                                                                                    |
| numeric         | The field under validation must be numeric.                                                                                                                           |
| alpha_num       | The field under validation must be entirely alpha-numeric characters.                                                                                                 |
| boolean         | The field under validation must be able to be cast as a boolean. Accepted input are `true`                                                                            |

## Contact

if you are interested in collaborating to develop this library. please contact me at `harismiftahulhudha@gmail.com`

### <a name="pookie"></a>Some heading

