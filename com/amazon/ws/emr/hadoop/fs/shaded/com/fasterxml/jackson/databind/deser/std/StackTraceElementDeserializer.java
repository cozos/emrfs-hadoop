package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class StackTraceElementDeserializer
  extends StdScalarDeserializer<StackTraceElement>
{
  private static final long serialVersionUID = 1L;
  
  public StackTraceElementDeserializer()
  {
    super(StackTraceElement.class);
  }
  
  public StackTraceElement deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_OBJECT)
    {
      String className = "";String methodName = "";String fileName = "";
      int lineNumber = -1;
      while ((t = jp.nextValue()) != JsonToken.END_OBJECT)
      {
        String propName = jp.getCurrentName();
        if ("className".equals(propName)) {
          className = jp.getText();
        } else if ("fileName".equals(propName)) {
          fileName = jp.getText();
        } else if ("lineNumber".equals(propName))
        {
          if (t.isNumeric()) {
            lineNumber = jp.getIntValue();
          } else {
            throw JsonMappingException.from(jp, "Non-numeric token (" + t + ") for property 'lineNumber'");
          }
        }
        else if ("methodName".equals(propName)) {
          methodName = jp.getText();
        } else if (!"nativeMethod".equals(propName)) {
          handleUnknownProperty(jp, ctxt, _valueClass, propName);
        }
      }
      return new StackTraceElement(className, methodName, fileName, lineNumber);
    }
    if ((t == JsonToken.START_ARRAY) && (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      jp.nextToken();
      StackTraceElement value = deserialize(jp, ctxt);
      if (jp.nextToken() != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.lang.StackTraceElement' value but there was more than a single value in the array");
      }
      return value;
    }
    throw ctxt.mappingException(_valueClass, t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */