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
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SimpleBeanPropertyFilter
  implements BeanPropertyFilter, PropertyFilter
{
  public static SimpleBeanPropertyFilter serializeAll()
  {
    return SerializeExceptFilter.INCLUDE_ALL;
  }
  
  @Deprecated
  public static SimpleBeanPropertyFilter serializeAll(Set<String> properties)
  {
    return new FilterExceptFilter(properties);
  }
  
  public static SimpleBeanPropertyFilter filterOutAllExcept(Set<String> properties)
  {
    return new FilterExceptFilter(properties);
  }
  
  public static SimpleBeanPropertyFilter filterOutAllExcept(String... propertyArray)
  {
    HashSet<String> properties = new HashSet(propertyArray.length);
    Collections.addAll(properties, propertyArray);
    return new FilterExceptFilter(properties);
  }
  
  public static SimpleBeanPropertyFilter serializeAllExcept(Set<String> properties)
  {
    return new SerializeExceptFilter(properties);
  }
  
  public static SimpleBeanPropertyFilter serializeAllExcept(String... propertyArray)
  {
    HashSet<String> properties = new HashSet(propertyArray.length);
    Collections.addAll(properties, propertyArray);
    return new SerializeExceptFilter(properties);
  }
  
  public static PropertyFilter from(BeanPropertyFilter src)
  {
    new PropertyFilter()
    {
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
    };
  }
  
  protected boolean include(BeanPropertyWriter writer)
  {
    return true;
  }
  
  protected boolean include(PropertyWriter writer)
  {
    return true;
  }
  
  protected boolean includeElement(Object elementValue)
  {
    return true;
  }
  
  @Deprecated
  public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer)
    throws Exception
  {
    if (include(writer)) {
      writer.serializeAsField(bean, jgen, provider);
    } else if (!jgen.canOmitFields()) {
      writer.serializeAsOmittedField(bean, jgen, provider);
    }
  }
  
  @Deprecated
  public void depositSchemaProperty(BeanPropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider)
    throws JsonMappingException
  {
    if (include(writer)) {
      writer.depositSchemaProperty(propertiesNode, provider);
    }
  }
  
  @Deprecated
  public void depositSchemaProperty(BeanPropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider)
    throws JsonMappingException
  {
    if (include(writer)) {
      writer.depositSchemaProperty(objectVisitor);
    }
  }
  
  public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
    throws Exception
  {
    if (include(writer)) {
      writer.serializeAsField(pojo, jgen, provider);
    } else if (!jgen.canOmitFields()) {
      writer.serializeAsOmittedField(pojo, jgen, provider);
    }
  }
  
  public void serializeAsElement(Object elementValue, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
    throws Exception
  {
    if (includeElement(elementValue)) {
      writer.serializeAsElement(elementValue, jgen, provider);
    }
  }
  
  @Deprecated
  public void depositSchemaProperty(PropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider)
    throws JsonMappingException
  {
    if (include(writer)) {
      writer.depositSchemaProperty(propertiesNode, provider);
    }
  }
  
  public void depositSchemaProperty(PropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider)
    throws JsonMappingException
  {
    if (include(writer)) {
      writer.depositSchemaProperty(objectVisitor);
    }
  }
  
  public static class FilterExceptFilter
    extends SimpleBeanPropertyFilter
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final Set<String> _propertiesToInclude;
    
    public FilterExceptFilter(Set<String> properties)
    {
      _propertiesToInclude = properties;
    }
    
    protected boolean include(BeanPropertyWriter writer)
    {
      return _propertiesToInclude.contains(writer.getName());
    }
    
    protected boolean include(PropertyWriter writer)
    {
      return _propertiesToInclude.contains(writer.getName());
    }
  }
  
  public static class SerializeExceptFilter
    extends SimpleBeanPropertyFilter
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    static final SerializeExceptFilter INCLUDE_ALL = new SerializeExceptFilter();
    protected final Set<String> _propertiesToExclude;
    
    SerializeExceptFilter()
    {
      _propertiesToExclude = Collections.emptySet();
    }
    
    public SerializeExceptFilter(Set<String> properties)
    {
      _propertiesToExclude = properties;
    }
    
    protected boolean include(BeanPropertyWriter writer)
    {
      return !_propertiesToExclude.contains(writer.getName());
    }
    
    protected boolean include(PropertyWriter writer)
    {
      return !_propertiesToExclude.contains(writer.getName());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */