package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$CharDeser
  extends PrimitiveArrayDeserializers<char[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$CharDeser()
  {
    super(char[].class);
  }
  
  public char[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_STRING)
    {
      char[] buffer = jp.getTextCharacters();
      int offset = jp.getTextOffset();
      int len = jp.getTextLength();
      
      char[] result = new char[len];
      System.arraycopy(buffer, offset, result, 0, len);
      return result;
    }
    if (jp.isExpectedStartArrayToken())
    {
      StringBuilder sb = new StringBuilder(64);
      while ((t = jp.nextToken()) != JsonToken.END_ARRAY)
      {
        if (t != JsonToken.VALUE_STRING) {
          throw ctxt.mappingException(Character.TYPE);
        }
        String str = jp.getText();
        if (str.length() != 1) {
          throw JsonMappingException.from(jp, "Can not convert a JSON String of length " + str.length() + " into a char element of char array");
        }
        sb.append(str.charAt(0));
      }
      return sb.toString().toCharArray();
    }
    if (t == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      Object ob = jp.getEmbeddedObject();
      if (ob == null) {
        return null;
      }
      if ((ob instanceof char[])) {
        return (char[])ob;
      }
      if ((ob instanceof String)) {
        return ((String)ob).toCharArray();
      }
      if ((ob instanceof byte[])) {
        return Base64Variants.getDefaultVariant().encode((byte[])ob, false).toCharArray();
      }
    }
    throw ctxt.mappingException(_valueClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.CharDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */