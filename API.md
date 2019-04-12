# 1.0.0 API Reference

* number
  * [number.max(value)](#number.max)
  * [number.min(value)](#number.min)
  * [number.greater(value)](#number.greater)
  * [number.less(value](#number.less)
  * [number.positive](#number.positive)
  * [number.negative](#number.negative)
 
### <a name="number.max"></a>number.max
#### Description
The number is higher than equal the value that you set
#### Usage
```
formValidation.addRequest(new Request("math", 18).number().max(20).validate());
```

