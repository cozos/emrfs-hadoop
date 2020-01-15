package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;

public class JsonObjectFormatVisitor$Base
  implements JsonObjectFormatVisitor
{
  protected SerializerProvider _provider;
  
  public JsonObjectFormatVisitor$Base() {}
  
  public JsonObjectFormatVisitor$Base(SerializerProvider p)
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
  
  public void property(BeanProperty prop)
    throws JsonMappingException
  {}
  
  public void property(String name, JsonFormatVisitable handler, JavaType propertyTypeHint)
    throws JsonMappingException
  {}
  
  public void optionalProperty(BeanProperty prop)
    throws JsonMappingException
  {}
  
  public void optionalProperty(String name, JsonFormatVisitable handler, JavaType propertyTypeHint)
    throws JsonMappingException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */