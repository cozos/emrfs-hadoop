package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders.ByteBuilder;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$ByteDeser
  extends PrimitiveArrayDeserializers<byte[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$ByteDeser()
  {
    super(byte[].class);
  }
  
  public byte[] deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_STRING) {
      return jp.getBinaryValue(ctxt.getBase64Variant());
    }
    if (t == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      Object ob = jp.getEmbeddedObject();
      if (ob == null) {
        return null;
      }
      if ((ob instanceof byte[])) {
        return (byte[])ob;
      }
    }
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt);
    }
    ArrayBuilders.ByteBuilder builder = ctxt.getArrayBuilders().getByteBuilder();
    byte[] chunk = (byte[])builder.resetAndStart();
    int ix = 0;
    try
    {
      while ((t = jp.nextToken()) != JsonToken.END_ARRAY)
      {
        byte value;
        byte value;
        if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT))
        {
          value = jp.getByteValue();
        }
        else
        {
          if (t != JsonToken.VALUE_NULL) {
            throw ctxt.mappingException(_valueClass.getComponentType());
          }
          value = 0;
        }
        if (ix >= chunk.length)
        {
          chunk = (byte[])builder.appendCompletedChunk(chunk, ix);
          ix = 0;
        }
        chunk[(ix++)] = value;
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
    }
    return (byte[])builder.completeAndClearBuffer(chunk, ix);
  }
  
  private final byte[] handleNonArray(JsonParser jp, DeserializationContext ctxt)
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
    JsonToken t = jp.getCurrentToken();
    byte value;
    byte value;
    if ((t == JsonToken.VALUE_NUMBER_INT) || (t == JsonToken.VALUE_NUMBER_FLOAT))
    {
      value = jp.getByteValue();
    }
    else
    {
      if (t != JsonToken.VALUE_NULL) {
        throw ctxt.mappingException(_valueClass.getComponentType());
      }
      value = 0;
    }
    return new byte[] { value };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.ByteDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */