package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class FailingDeserializer
  extends StdDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  protected final String _message;
  
  public FailingDeserializer(String m)
  {
    super(Object.class);
    _message = m;
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws JsonMappingException
  {
    throw ctxt.mappingException(_message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.FailingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */