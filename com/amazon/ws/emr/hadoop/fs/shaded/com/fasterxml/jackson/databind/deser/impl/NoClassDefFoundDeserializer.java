package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class NoClassDefFoundDeserializer<T>
  extends JsonDeserializer<T>
{
  private final NoClassDefFoundError _cause;
  
  public NoClassDefFoundDeserializer(NoClassDefFoundError cause)
  {
    _cause = cause;
  }
  
  public T deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    throw _cause;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.NoClassDefFoundDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */