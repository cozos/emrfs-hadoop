package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders.FloatBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$FloatDeser
  extends PrimitiveArrayDeserializers<float[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$FloatDeser()
  {
    super(float[].class);
  }
  
  public float[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt);
    }
    ArrayBuilders.FloatBuilder builder = ctxt.getArrayBuilders().getFloatBuilder();
    float[] chunk = (float[])builder.resetAndStart();
    int ix = 0;
    try
    {
      while (jp.nextToken() != JsonToken.END_ARRAY)
      {
        float value = _parseFloatPrimitive(jp, ctxt);
        if (ix >= chunk.length)
        {
          chunk = (float[])builder.appendCompletedChunk(chunk, ix);
          ix = 0;
        }
        chunk[(ix++)] = value;
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
    }
    return (float[])builder.completeAndClearBuffer(chunk, ix);
  }
  
  private final float[] handleNonArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if ((jp.getCurrentToken() == JsonToken.VALUE_STRING) && (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT))) {
      if (jp.getText().length() == 0) {
        return null;
      }
    }
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw ctxt.mappingException(_valueClass);
    }
    return new float[] { _parseFloatPrimitive(jp, ctxt) };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.FloatDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */