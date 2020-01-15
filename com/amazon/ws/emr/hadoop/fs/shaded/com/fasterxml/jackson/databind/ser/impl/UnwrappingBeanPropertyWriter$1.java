package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

class UnwrappingBeanPropertyWriter$1
  extends JsonFormatVisitorWrapper.Base
{
  UnwrappingBeanPropertyWriter$1(UnwrappingBeanPropertyWriter paramUnwrappingBeanPropertyWriter, SerializerProvider x0, JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
  {
    super(x0);
  }
  
  public JsonObjectFormatVisitor expectObjectFormat(JavaType type)
    throws JsonMappingException
  {
    return val$visitor;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */