# 1.0.0 API Reference

* number
  * [number.max(value)](#number.max)
  * [number.min(value)](#number.min)
  * [number.greater(value)](#number.greater)
  * [number.less(value](#number.less)
  * [number.positive](#number.positive)
  * [number.negative](#number.negative)
 
 
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
The number must be positive
#### Usage
```
formValidation.addRequest(new Request("math", 24).number().positive().validate());
```

## <a name="number.negative"></a>number.negative
#### Description
The number must be negative
#### Usage
```
formValidation.addRequest(new Request("math", 24).number().negative().validate());
```

