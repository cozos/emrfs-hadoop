package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public abstract class StdDeserializer<T>
  extends JsonDeserializer<T>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final int F_MASK_INT_COERCIONS = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask();
  protected final Class<?> _valueClass;
  
  protected StdDeserializer(Class<?> vc)
  {
    _valueClass = vc;
  }
  
  protected StdDeserializer(JavaType valueType)
  {
    _valueClass = (valueType == null ? null : valueType.getRawClass());
  }
  
  protected StdDeserializer(StdDeserializer<?> src)
  {
    _valueClass = _valueClass;
  }
  
  public Class<?> handledType()
  {
    return _valueClass;
  }
  
  @Deprecated
  public final Class<?> getValueClass()
  {
    return _valueClass;
  }
  
  public JavaType getValueType()
  {
    return null;
  }
  
  protected boolean isDefaultDeserializer(JsonDeserializer<?> deserializer)
  {
    return ClassUtil.isJacksonStdImpl(deserializer);
  }
  
  protected boolean isDefaultKeyDeserializer(KeyDeserializer keyDeser)
  {
    return ClassUtil.isJacksonStdImpl(keyDeser);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromAny(jp, ctxt);
  }
  
  protected final boolean _parseBooleanPrimitive(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_TRUE) {
      return true;
    }
    if (t == JsonToken.VALUE_FALSE) {
      return false;
    }
    if (t == JsonToken.VALUE_NULL) {
      return false;
    }
    if (t == JsonToken.VALUE_NUMBER_INT)
    {
      if (jp.getNumberType() == JsonParser.NumberType.INT) {
        return jp.getIntValue() != 0;
      }
      return _parseBooleanFromNumber(jp, ctxt);
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = jp.getText().trim();
      if (("true".equals(text)) || ("True".equals(text))) {
        return true;
      }
      if (("false".equals(text)) || ("False".equals(text)) || (text.length() == 0)) {
        return false;
      }
      if (_hasTextualNull(text)) {
        return false;
      }
      throw ctxt.weirdStringException(text, _valueClass, "only \"true\" or \"false\" recognized");
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      boolean parsed = _parseBooleanPrimitive(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'boolean' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final Boolean _parseBoolean(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.VALUE_TRUE) {
      return Boolean.TRUE;
    }
    if (t == JsonToken.VALUE_FALSE) {
      return Boolean.FALSE;
    }
    if (t == JsonToken.VALUE_NUMBER_INT)
    {
      if (p.getNumberType() == JsonParser.NumberType.INT) {
        return p.getIntValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
      }
      return Boolean.valueOf(_parseBooleanFromNumber(p, ctxt));
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Boolean)getNullValue(ctxt);
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = p.getText().trim();
      if (("true".equals(text)) || ("True".equals(text))) {
        return Boolean.TRUE;
      }
      if (("false".equals(text)) || ("False".equals(text))) {
        return Boolean.FALSE;
      }
      if (text.length() == 0) {
        return (Boolean)getEmptyValue(ctxt);
      }
      if (_hasTextualNull(text)) {
        return (Boolean)getNullValue(ctxt);
      }
      throw ctxt.weirdStringException(text, _valueClass, "only \"true\" or \"false\" recognized");
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      p.nextToken();
      Boolean parsed = _parseBoolean(p, ctxt);
      t = p.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Boolean' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final boolean _parseBooleanFromNumber(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (jp.getNumberType() == JsonParser.NumberType.LONG) {
      return (jp.getLongValue() == 0L ? Boolean.FALSE : Boolean.TRUE).booleanValue();
    }
    String str = jp.getText();
    if (("0.0".equals(str)) || ("0".equals(str))) {
      return Boolean.FALSE.booleanValue();
    }
    return Boolean.TRUE.booleanValue();
  }
  
  protected Byte _parseByte(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return Byte.valueOf(p.getByteValue());
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = p.getText().trim();
      if (_hasTextualNull(text)) {
        return (Byte)getNullValue(ctxt);
      }
      int value;
      try
      {
        int len = text.length();
        if (len == 0) {
          return (Byte)getEmptyValue(ctxt);
        }
        value = NumberInput.parseInt(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Byte value");
      }
      if ((value < -128) || (value > 255)) {
        throw ctxt.weirdStringException(text, _valueClass, "overflow, value can not be represented as 8-bit value");
      }
      return Byte.valueOf((byte)value);
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT)
    {
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "Byte");
      }
      return Byte.valueOf(p.getByteValue());
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Byte)getNullValue(ctxt);
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      p.nextToken();
      Byte parsed = _parseByte(p, ctxt);
      t = p.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected Short _parseShort(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return Short.valueOf(p.getShortValue());
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = p.getText().trim();
      int value;
      try
      {
        int len = text.length();
        if (len == 0) {
          return (Short)getEmptyValue(ctxt);
        }
        if (_hasTextualNull(text)) {
          return (Short)getNullValue(ctxt);
        }
        value = NumberInput.parseInt(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Short value");
      }
      if ((value < 32768) || (value > 32767)) {
        throw ctxt.weirdStringException(text, _valueClass, "overflow, value can not be represented as 16-bit value");
      }
      return Short.valueOf((short)value);
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT)
    {
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "Short");
      }
      return Short.valueOf(p.getShortValue());
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Short)getNullValue(ctxt);
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      p.nextToken();
      Short parsed = _parseShort(p, ctxt);
      t = p.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Short' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final short _parseShortPrimitive(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    int value = _parseIntPrimitive(jp, ctxt);
    if ((value < 32768) || (value > 32767)) {
      throw ctxt.weirdStringException(String.valueOf(value), _valueClass, "overflow, value can not be represented as 16-bit value");
    }
    return (short)value;
  }
  
  protected final int _parseIntPrimitive(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return p.getIntValue();
    }
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.VALUE_STRING)
    {
      String text = p.getText().trim();
      if (_hasTextualNull(text)) {
        return 0;
      }
      try
      {
        int len = text.length();
        if (len > 9)
        {
          long l = Long.parseLong(text);
          if ((l < -2147483648L) || (l > 2147483647L)) {
            throw ctxt.weirdStringException(text, _valueClass, "Overflow: numeric value (" + text + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
          return (int)l;
        }
        if (len == 0) {
          return 0;
        }
        return NumberInput.parseInt(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid int value");
      }
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT)
    {
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "int");
      }
      return p.getValueAsInt();
    }
    if (t == JsonToken.VALUE_NULL) {
      return 0;
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      p.nextToken();
      int parsed = _parseIntPrimitive(p, ctxt);
      t = p.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'int' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final Integer _parseInteger(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      return Integer.valueOf(p.getIntValue());
    case 8: 
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "Integer");
      }
      return Integer.valueOf(p.getValueAsInt());
    case 6: 
      String text = p.getText().trim();
      try
      {
        int len = text.length();
        if (_hasTextualNull(text)) {
          return (Integer)getNullValue(ctxt);
        }
        if (len > 9)
        {
          long l = Long.parseLong(text);
          if ((l < -2147483648L) || (l > 2147483647L)) {
            throw ctxt.weirdStringException(text, _valueClass, "Overflow: numeric value (" + text + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
          return Integer.valueOf((int)l);
        }
        if (len == 0) {
          return (Integer)getEmptyValue(ctxt);
        }
        return Integer.valueOf(NumberInput.parseInt(text));
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Integer value");
      }
    case 11: 
      return (Integer)getNullValue(ctxt);
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        Integer parsed = _parseInteger(p, ctxt);
        if (p.nextToken() != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Integer' value but there was more than a single value in the array");
        }
        return parsed;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
  
  protected final Long _parseLong(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      return Long.valueOf(p.getLongValue());
    case 8: 
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "Long");
      }
      return Long.valueOf(p.getValueAsLong());
    case 6: 
      String text = p.getText().trim();
      if (text.length() == 0) {
        return (Long)getEmptyValue(ctxt);
      }
      if (_hasTextualNull(text)) {
        return (Long)getNullValue(ctxt);
      }
      try
      {
        return Long.valueOf(NumberInput.parseLong(text));
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Long value");
      }
    case 11: 
      return (Long)getNullValue(ctxt);
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        Long parsed = _parseLong(p, ctxt);
        JsonToken t = p.nextToken();
        if (t != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Long' value but there was more than a single value in the array");
        }
        return parsed;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
  
  protected final long _parseLongPrimitive(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      return p.getLongValue();
    case 8: 
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "long");
      }
      return p.getValueAsLong();
    case 6: 
      String text = p.getText().trim();
      if ((text.length() == 0) || (_hasTextualNull(text))) {
        return 0L;
      }
      try
      {
        return NumberInput.parseLong(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid long value");
      }
    case 11: 
      return 0L;
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        long parsed = _parseLongPrimitive(p, ctxt);
        JsonToken t = p.nextToken();
        if (t != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'long' value but there was more than a single value in the array");
        }
        return parsed;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
  
  protected final Float _parseFloat(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Float.valueOf(jp.getFloatValue());
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = jp.getText().trim();
      if (text.length() == 0) {
        return (Float)getEmptyValue(ctxt);
      }
      if (_hasTextualNull(text)) {
        return (Float)getNullValue(ctxt);
      }
      switch (text.charAt(0))
      {
      case 'I': 
        if (_isPosInf(text)) {
          return Float.valueOf(Float.POSITIVE_INFINITY);
        }
        break;
      case 'N': 
        if (_isNaN(text)) {
          return Float.valueOf(NaN.0F);
        }
        break;
      case '-': 
        if (_isNegInf(text)) {
          return Float.valueOf(Float.NEGATIVE_INFINITY);
        }
        break;
      }
      try
      {
        return Float.valueOf(Float.parseFloat(text));
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Float value");
      }
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Float)getNullValue(ctxt);
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      Float parsed = _parseFloat(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final float _parseFloatPrimitive(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT)) {
      return jp.getFloatValue();
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = jp.getText().trim();
      if ((text.length() == 0) || (_hasTextualNull(text))) {
        return 0.0F;
      }
      switch (text.charAt(0))
      {
      case 'I': 
        if (_isPosInf(text)) {
          return Float.POSITIVE_INFINITY;
        }
        break;
      case 'N': 
        if (_isNaN(text)) {
          return NaN.0F;
        }
        break;
      case '-': 
        if (_isNegInf(text)) {
          return Float.NEGATIVE_INFINITY;
        }
        break;
      }
      try
      {
        return Float.parseFloat(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid float value");
      }
    }
    if (t == JsonToken.VALUE_NULL) {
      return 0.0F;
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      float parsed = _parseFloatPrimitive(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'float' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final Double _parseDouble(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Double.valueOf(jp.getDoubleValue());
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = jp.getText().trim();
      if (text.length() == 0) {
        return (Double)getEmptyValue(ctxt);
      }
      if (_hasTextualNull(text)) {
        return (Double)getNullValue(ctxt);
      }
      switch (text.charAt(0))
      {
      case 'I': 
        if (_isPosInf(text)) {
          return Double.valueOf(Double.POSITIVE_INFINITY);
        }
        break;
      case 'N': 
        if (_isNaN(text)) {
          return Double.valueOf(NaN.0D);
        }
        break;
      case '-': 
        if (_isNegInf(text)) {
          return Double.valueOf(Double.NEGATIVE_INFINITY);
        }
        break;
      }
      try
      {
        return Double.valueOf(parseDouble(text));
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid Double value");
      }
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Double)getNullValue(ctxt);
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      Double parsed = _parseDouble(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Double' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected final double _parseDoublePrimitive(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT)) {
      return jp.getDoubleValue();
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String text = jp.getText().trim();
      if ((text.length() == 0) || (_hasTextualNull(text))) {
        return 0.0D;
      }
      switch (text.charAt(0))
      {
      case 'I': 
        if (_isPosInf(text)) {
          return Double.POSITIVE_INFINITY;
        }
        break;
      case 'N': 
        if (_isNaN(text)) {
          return NaN.0D;
        }
        break;
      case '-': 
        if (_isNegInf(text)) {
          return Double.NEGATIVE_INFINITY;
        }
        break;
      }
      try
      {
        return parseDouble(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid double value");
      }
    }
    if (t == JsonToken.VALUE_NULL) {
      return 0.0D;
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      double parsed = _parseDoublePrimitive(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected Date _parseDate(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return new Date(jp.getLongValue());
    }
    if (t == JsonToken.VALUE_NULL) {
      return (Date)getNullValue(ctxt);
    }
    if (t == JsonToken.VALUE_STRING)
    {
      String value = null;
      try
      {
        value = jp.getText().trim();
        if (value.length() == 0) {
          return (Date)getEmptyValue(ctxt);
        }
        if (_hasTextualNull(value)) {
          return (Date)getNullValue(ctxt);
        }
        return ctxt.parseDate(value);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(value, _valueClass, "not a valid representation (error: " + iae.getMessage() + ")");
      }
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      Date parsed = _parseDate(jp, ctxt);
      t = jp.nextToken();
      if (t != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.util.Date' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
  
  protected static final double parseDouble(String numStr)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(numStr)) {
      return Double.MIN_VALUE;
    }
    return Double.parseDouble(numStr);
  }
  
  protected final String _parseString(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_STRING) {
      return jp.getText();
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      String parsed = _parseString(jp, ctxt);
      if (jp.nextToken() != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'String' value but there was more than a single value in the array");
      }
      return parsed;
    }
    String value = jp.getValueAsString();
    if (value != null) {
      return value;
    }
    throw ctxt.mappingException(String.class, jp.getCurrentToken());
  }
  
  protected T _deserializeFromEmpty(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_ARRAY)
    {
      if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT))
      {
        t = jp.nextToken();
        if (t == JsonToken.END_ARRAY) {
          return null;
        }
        throw ctxt.mappingException(handledType(), JsonToken.START_ARRAY);
      }
    }
    else if ((t == JsonToken.VALUE_STRING) && 
      (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)))
    {
      String str = jp.getText().trim();
      if (str.isEmpty()) {
        return null;
      }
    }
    throw ctxt.mappingException(handledType());
  }
  
  protected boolean _hasTextualNull(String value)
  {
    return "null".equals(value);
  }
  
  protected final boolean _isNegInf(String text)
  {
    return ("-Infinity".equals(text)) || ("-INF".equals(text));
  }
  
  protected final boolean _isPosInf(String text)
  {
    return ("Infinity".equals(text)) || ("INF".equals(text));
  }
  
  protected final boolean _isNaN(String text)
  {
    return "NaN".equals(text);
  }
  
  protected Object _coerceIntegral(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    int feats = ctxt.getDeserializationFeatures();
    if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
      return p.getBigIntegerValue();
    }
    if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
      return Long.valueOf(p.getLongValue());
    }
    return p.getBigIntegerValue();
  }
  
  protected JsonDeserializer<Object> findDeserializer(DeserializationContext ctxt, JavaType type, BeanProperty property)
    throws JsonMappingException
  {
    return ctxt.findContextualValueDeserializer(type, property);
  }
  
  protected final boolean _isIntNumber(String text)
  {
    int len = text.length();
    if (len > 0)
    {
      char c = text.charAt(0);
      for (int i = (c == '-') || (c == '+') ? 1 : 0; i < len; i++)
      {
        int ch = text.charAt(i);
        if ((ch > 57) || (ch < 48)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected JsonDeserializer<?> findConvertingContentDeserializer(DeserializationContext ctxt, BeanProperty prop, JsonDeserializer<?> existingDeserializer)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
    if ((intr != null) && (prop != null))
    {
      AnnotatedMember member = prop.getMember();
      if (member != null)
      {
        Object convDef = intr.findDeserializationContentConverter(member);
        if (convDef != null)
        {
          Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
          JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
          if (existingDeserializer == null) {
            existingDeserializer = ctxt.findContextualValueDeserializer(delegateType, prop);
          }
          return new StdDelegatingDeserializer(conv, delegateType, existingDeserializer);
        }
      }
    }
    return existingDeserializer;
  }
  
  protected void handleUnknownProperty(JsonParser jp, DeserializationContext ctxt, Object instanceOrClass, String propName)
    throws IOException
  {
    if (instanceOrClass == null) {
      instanceOrClass = handledType();
    }
    if (ctxt.handleUnknownProperty(jp, this, instanceOrClass, propName)) {
      return;
    }
    ctxt.reportUnknownProperty(instanceOrClass, propName, this);
    
    jp.skipChildren();
  }
  
  protected void _failDoubleToIntCoercion(JsonParser jp, DeserializationContext ctxt, String type)
    throws IOException
  {
    throw ctxt.mappingException("Can not coerce a floating-point value ('%s') into %s; enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow", new Object[] { jp.getValueAsString(), type });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */