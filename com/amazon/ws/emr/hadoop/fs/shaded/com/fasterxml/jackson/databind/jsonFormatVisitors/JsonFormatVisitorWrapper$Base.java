package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;

public class JsonFormatVisitorWrapper$Base
  implements JsonFormatVisitorWrapper
{
  protected SerializerProvider _provider;
  
  public JsonFormatVisitorWrapper$Base() {}
  
  public JsonFormatVisitorWrapper$Base(SerializerProvider p)
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
  
  public JsonObjectFormatVisitor expectObjectFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonArrayFormatVisitor expectArrayFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonStringFormatVisitor expectStringFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonNumberFormatVisitor expectNumberFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonIntegerFormatVisitor expectIntegerFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonBooleanFormatVisitor expectBooleanFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonNullFormatVisitor expectNullFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonAnyFormatVisitor expectAnyFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
  
  public JsonMapFormatVisitor expectMapFormat(JavaType type)
    throws JsonMappingException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */