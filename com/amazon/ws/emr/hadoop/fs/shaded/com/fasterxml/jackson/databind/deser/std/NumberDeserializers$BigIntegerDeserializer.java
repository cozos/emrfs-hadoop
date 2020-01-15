package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberDeserializers$BigIntegerDeserializer
  extends StdScalarDeserializer<BigInteger>
{
  public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();
  
  public NumberDeserializers$BigIntegerDeserializer()
  {
    super(BigInteger.class);
  }
  
  public BigInteger deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      switch (NumberDeserializers.1.$SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[p.getNumberType().ordinal()])
      {
      case 1: 
      case 2: 
      case 3: 
        return p.getBigIntegerValue();
      }
      break;
    case 8: 
      if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
        _failDoubleToIntCoercion(p, ctxt, "java.math.BigInteger");
      }
      return p.getDecimalValue().toBigInteger();
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        BigInteger value = deserialize(p, ctxt);
        if (p.nextToken() != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigInteger' value but there was more than a single value in the array");
        }
        return value;
      }
      break;
    case 6: 
      String text = p.getText().trim();
      if (text.length() == 0) {
        return null;
      }
      try
      {
        return new BigInteger(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid representation");
      }
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigIntegerDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */