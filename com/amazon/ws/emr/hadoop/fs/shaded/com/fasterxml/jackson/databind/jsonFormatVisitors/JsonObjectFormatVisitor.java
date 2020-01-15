package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface JsonObjectFormatVisitor
  extends JsonFormatVisitorWithSerializerProvider
{
  public abstract void property(BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract void property(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException;
  
  public abstract void optionalProperty(BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract void optionalProperty(String paramString, JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException;
  
  public static class Base
    implements JsonObjectFormatVisitor
  {
    protected SerializerProvider _provider;
    
    public Base() {}
    
    public Base(SerializerProvider p)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */