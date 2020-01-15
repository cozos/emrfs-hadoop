package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders.DoubleBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$DoubleDeser
  extends PrimitiveArrayDeserializers<double[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$DoubleDeser()
  {
    super(double[].class);
  }
  
  public double[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt);
    }
    ArrayBuilders.DoubleBuilder builder = ctxt.getArrayBuilders().getDoubleBuilder();
    double[] chunk = (double[])builder.resetAndStart();
    int ix = 0;
    try
    {
      while (jp.nextToken() != JsonToken.END_ARRAY)
      {
        double value = _parseDoublePrimitive(jp, ctxt);
        if (ix >= chunk.length)
        {
          chunk = (double[])builder.appendCompletedChunk(chunk, ix);
          ix = 0;
        }
        chunk[(ix++)] = value;
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
    }
    return (double[])builder.completeAndClearBuffer(chunk, ix);
  }
  
  private final double[] handleNonArray(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if ((jp.getCurrentToken() == JsonToken.VALUE_STRING) && (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT))) {
      if (jp.getText().length() == 0) {
        return null;
      }
    }
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw ctxt.mappingException(_valueClass);
    }
    return new double[] { _parseDoublePrimitive(jp, ctxt) };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.DoubleDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */