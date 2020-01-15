package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberDeserializers$NumberDeserializer
  extends StdScalarDeserializer<Object>
{
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public NumberDeserializers$NumberDeserializer()
  {
    super(Number.class);
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      if (ctxt.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
        return _coerceIntegral(p, ctxt);
      }
      return p.getNumberValue();
    case 8: 
      if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return p.getDecimalValue();
      }
      return Double.valueOf(p.getDoubleValue());
    case 6: 
      String text = p.getText().trim();
      if (text.length() == 0) {
        return getEmptyValue(ctxt);
      }
      if (_hasTextualNull(text)) {
        return getNullValue(ctxt);
      }
      if (_isPosInf(text)) {
        return Double.valueOf(Double.POSITIVE_INFINITY);
      }
      if (_isNegInf(text)) {
        return Double.valueOf(Double.NEGATIVE_INFINITY);
      }
      if (_isNaN(text)) {
        return Double.valueOf(NaN.0D);
      }
      try
      {
        if (!_isIntNumber(text))
        {
          if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            return new BigDecimal(text);
          }
          return new Double(text);
        }
        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
          return new BigInteger(text);
        }
        long value = Long.parseLong(text);
        if ((!ctxt.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS)) && 
          (value <= 2147483647L) && (value >= -2147483648L)) {
          return Integer.valueOf((int)value);
        }
        return Long.valueOf(value);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid number");
      }
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        Object value = deserialize(p, ctxt);
        if (p.nextToken() != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
        }
        return value;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    switch (jp.getCurrentTokenId())
    {
    case 6: 
    case 7: 
    case 8: 
      return deserialize(jp, ctxt);
    }
    return typeDeserializer.deserializeTypedFromScalar(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.NumberDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */