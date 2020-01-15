package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;

public class JsonMapFormatVisitor$Base
  implements JsonMapFormatVisitor
{
  protected SerializerProvider _provider;
  
  public JsonMapFormatVisitor$Base() {}
  
  public JsonMapFormatVisitor$Base(SerializerProvider p)
  {
    _provider = p;
  }
  
  public SerializerProvider getProvider()
  {
    return _provider;
  }
  
  public void setProvider(SerializerProvider p)
  {
    _provider = p;
  }
  
  public void keyFormat(JsonFormatVisitable handler, JavaType keyType)
    throws JsonMappingException
  {}
  
  public void valueFormat(JsonFormatVisitable handler, JavaType valueType)
    throws JsonMappingException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */