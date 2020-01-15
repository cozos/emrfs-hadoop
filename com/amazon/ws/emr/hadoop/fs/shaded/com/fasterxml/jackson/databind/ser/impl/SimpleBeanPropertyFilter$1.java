package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter;

final class SimpleBeanPropertyFilter$1
  implements PropertyFilter
{
  SimpleBeanPropertyFilter$1(BeanPropertyFilter paramBeanPropertyFilter) {}
  
  public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider prov, PropertyWriter writer)
    throws Exception
  {
    val$src.serializeAsField(pojo, jgen, prov, (BeanPropertyWriter)writer);
  }
  
  public void depositSchemaProperty(PropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider)
    throws JsonMappingException
  {
    val$src.depositSchemaProperty((BeanPropertyWriter)writer, propertiesNode, provider);
  }
  
  public void depositSchemaProperty(PropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider)
    throws JsonMappingException
  {
    val$src.depositSchemaProperty((BeanPropertyWriter)writer, objectVisitor, provider);
  }
  
  public void serializeAsElement(Object elementValue, JsonGenerator jgen, SerializerProvider prov, PropertyWriter writer)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */