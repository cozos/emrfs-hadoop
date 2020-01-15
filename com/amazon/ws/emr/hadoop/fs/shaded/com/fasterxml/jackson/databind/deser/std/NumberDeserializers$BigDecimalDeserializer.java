package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.math.BigDecimal;

@JacksonStdImpl
public class NumberDeserializers$BigDecimalDeserializer
  extends StdScalarDeserializer<BigDecimal>
{
  public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();
  
  public NumberDeserializers$BigDecimalDeserializer()
  {
    super(BigDecimal.class);
  }
  
  public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
    case 8: 
      return p.getDecimalValue();
    case 6: 
      String text = p.getText().trim();
      if (text.length() == 0) {
        return null;
      }
      try
      {
        return new BigDecimal(text);
      }
      catch (IllegalArgumentException iae)
      {
        throw ctxt.weirdStringException(text, _valueClass, "not a valid representation");
      }
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        BigDecimal value = deserialize(p, ctxt);
        if (p.nextToken() != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigDecimal' value but there was more than a single value in the array");
        }
        return value;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */