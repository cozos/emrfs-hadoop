package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public final class StringDeserializer
  extends StdScalarDeserializer<String>
{
  private static final long serialVersionUID = 1L;
  public static final StringDeserializer instance = new StringDeserializer();
  
  public StringDeserializer()
  {
    super(String.class);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public String deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken curr = jp.getCurrentToken();
    if (curr == JsonToken.VALUE_STRING) {
      return jp.getText();
    }
    if ((curr == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      String parsed = _parseString(jp, ctxt);
      if (jp.nextToken() != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'String' value but there was more than a single value in the array");
      }
      return parsed;
    }
    if (curr == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      Object ob = jp.getEmbeddedObject();
      if (ob == null) {
        return null;
      }
      if ((ob instanceof byte[])) {
        return Base64Variants.getDefaultVariant().encode((byte[])ob, false);
      }
      return ob.toString();
    }
    String text = jp.getValueAsString();
    if (text != null) {
      return text;
    }
    throw ctxt.mappingException(_valueClass, curr);
  }
  
  public String deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return deserialize(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StringDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */