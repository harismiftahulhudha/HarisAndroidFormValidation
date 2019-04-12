# 1.0.0 API Reference

* number
  * [number.max(value)](#number.max)
  * [number.min(value)](#number.min)
  * [number.greater(value)](#number.greater)
  * [number.less(value](#number.less)
  * [number.positive](#number.positive)
  * [number.negative](#number.negative)
* string
  * [string.maxlength(value)](#string.maxlength)
  * [string.minlength(value)](#string.minlength)
  * [string.email](#string.email)
  * [string.alpha](#string.alpha)
  * [string.alphanum](#string.alphanum)
  * [string.token](#string.token)
  * [string.url](#string.url)
  * [string.hex](#string.hex)
  * [string.uppercase](#string.uppercase)
  * [string.lowercase](#string.lowercase)
* bool
  * [bool.troo](#bool.troo)
  * [bool.fols](#bool.fols)
* date
  * [date.max](#date.max)
  * [date.min](#date.min)
  * [date.greater](#date.greater)
  * [date.less](#date.less)
  * [date.between](#date.between)
 
 
## <a name="number.max"></a>number.max
#### Description
The number is lower or equal to the value that you set.
#### Usage
```
formValidation.addRequest(new Request("math", 18).number().max(20).validate());
```


## <a name="number.min"></a>number.min
#### Description
The number is higher or equal to the value that you set.
#### Usage
```
formValidation.addRequest(new Request("math", 43).number().min(20).validate());
```


## <a name="number.greater"></a>number.greater
#### Description
The number is lower than the value that you set.
#### Usage
```
formValidation.addRequest(new Request("math", 18).number().greater(20).validate());
```


## <a name="number.less"></a>number.less
#### Description
The number is higher than the value that you set.
#### Usage
```
formValidation.addRequest(new Request("math", 24).number().less(20).validate());
```


## <a name="number.positive"></a>number.positive
#### Description
The number must be positive.
#### Usage
```
formValidation.addRequest(new Request("math", 24).number().positive().validate());
```


## <a name="number.negative"></a>number.negative
#### Description
The number must be negative.
#### Usage
```
formValidation.addRequest(new Request("math", 24).number().negative().validate());
```


## <a name="string.maxlength"></a>string.maxlength
#### Description
The number of string characters is lower or equal to the value that you set.
#### Usage
```
formValidation.addRequest(new Request("name", "Haris Miftahul Hudha").string().maxlength(30).validate());
```


## <a name="string.minlength"></a>string.minlength
#### Description
The number of string characters is higher or equal to the value that you set.
#### Usage
```
formValidation.addRequest(new Request("name", "Haris Miftahul Hudha").string().maxlength(15).validate());
```


## <a name="string.email"></a>string.email
#### Description
The string is must be a valid e-mail.
#### Usage
```
formValidation.addRequest(new Request("email", "harismiftahulhudha@gmail.com").string().email().validate());
```


## <a name="string.alpha"></a>string.alpha
#### Description
Requires the string value to only contain a-z and A-Z.
#### Usage
```
formValidation.addRequest(new Request("name", "harismiftahulhudha").string().alpha().validate());
```


## <a name="string.alphanum"></a>string.alphanum
#### Description
Requires the string value to only contain a-z, A-Z and 0-9.
#### Usage
```
formValidation.addRequest(new Request("name", "harismiftahulhudha12").string().alphanum().validate());
```


## <a name="string.token"></a>string.token
#### Description
Requires the string value to only contain a-z, A-Z, 0-9, and underscore _.
#### Usage
```
formValidation.addRequest(new Request("token", "harismif1234_4412").string().token().validate());
```


## <a name="string.url"></a>string.url
#### Description
The string is must be a valid url (This validation does not check whether the url is active or not).
#### Usage
```
formValidation.addRequest(new Request("url", "https://github.com/harismiftahulhudha/HarisAndroidFormValidation").string().url().validate());
```


## <a name="string.hex"></a>string.hex
#### Description
Requires the string value to be a valid hexadecimal string.
#### Usage
```
formValidation.addRequest(new Request("color", "#000000").string().hex().validate());
```


## <a name="string.uppercase"></a>string.uppercase
#### Description
Requires the string value to be all uppercase.
#### Usage
```
formValidation.addRequest(new Request("name", "HARIS MIFTAHUL HUDHA").string().uppercase().validate());
```


## <a name="string.lowercase"></a>string.lowercase
#### Description
Requires the string value to be all lowercase.
#### Usage
```
formValidation.addRequest(new Request("name", "haris miftahul hudha").string().uppercase().validate());
```


## <a name="bool.troo"></a>bool.troo
#### Description
Requires the boolean value to be true.
#### Usage
```
formValidation.addRequest(new Request("gender", true).bool().troo().validate());
```


## <a name="bool.fols"></a>bool.fols
#### Description
Requires the boolean value to be false.
#### Usage
```
formValidation.addRequest(new Request("gender", false).bool().fols().validate());
```


## <a name="date.max"></a>date.max
#### Description
The date is lower or equal to the value that you set.
#### Usage
```
// the date format is yyyy-MM-dd
formValidation.addRequest(new Request("birthday", "2018-10-10").date().max("2018-12-10").validate());
```


## <a name="date.min"></a>date.min
#### Description
The date is higher or equal to the value that you set.
#### Usage
```
// the date format is yyyy-MM-dd
formValidation.addRequest(new Request("birthday", "2018-12-10").date().min("2018-10-10").validate());
```


## <a name="date.greater"></a>date.greater
#### Description
The date is lower than the value that you set.
#### Usage
```
// the date format is yyyy-MM-dd
formValidation.addRequest(new Request("birthday", "2018-10-10").date().greater("2018-12-10").validate());
```


## <a name="date.less"></a>date.less
#### Description
The date is higher than the value that you set.
#### Usage
```
// the date format is yyyy-MM-dd
formValidation.addRequest(new Request("birthday", "2018-12-10").date().min("2018-10-10").validate());
```


## <a name="date.between"></a>date.between
#### Description
The date is between the value1 and the value2 that you set.
#### Usage
```
// the date format is yyyy-MM-dd
formValidation.addRequest(new Request("work", "2018-11-10").date().between("2018-10-10", "2018-12-10").validate());
```
