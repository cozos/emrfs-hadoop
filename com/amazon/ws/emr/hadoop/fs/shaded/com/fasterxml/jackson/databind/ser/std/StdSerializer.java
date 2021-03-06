package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract class StdSerializer<T>
  extends JsonSerializer<T>
  implements JsonFormatVisitable, SchemaAware, Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<T> _handledType;
  
  protected StdSerializer(Class<T> t)
  {
    _handledType = t;
  }
  
  protected StdSerializer(JavaType type)
  {
    _handledType = type.getRawClass();
  }
  
  protected StdSerializer(Class<?> t, boolean dummy)
  {
    _handledType = t;
  }
  
  protected StdSerializer(StdSerializer<?> src)
  {
    _handledType = _handledType;
  }
  
  public Class<T> handledType()
  {
    return _handledType;
  }
  
  public abstract void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    return createSchemaNode("string");
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint, boolean isOptional)
    throws JsonMappingException
  {
    ObjectNode schema = (ObjectNode)getSchema(provider, typeHint);
    if (!isOptional) {
      schema.put("required", !isOptional);
    }
    return schema;
  }
  
  protected ObjectNode createObjectNode()
  {
    return JsonNodeFactory.instance.objectNode();
  }
  
  protected ObjectNode createSchemaNode(String type)
  {
    ObjectNode schema = createObjectNode();
    schema.put("type", type);
    return schema;
  }
  
  protected ObjectNode createSchemaNode(String type, boolean isOptional)
  {
    ObjectNode schema = createSchemaNode(type);
    if (!isOptional) {
      schema.put("required", !isOptional);
    }
    return schema;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    visitor.expectAnyFormat(typeHint);
  }
  
  public void wrapAndThrow(SerializerProvider provider, Throwable t, Object bean, String fieldName)
    throws IOException
  {
    while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    boolean wrap = (provider == null) || (provider.isEnabled(SerializationFeature.WRAP_EXCEPTIONS));
    if ((t instanceof IOException))
    {
      if ((!wrap) || (!(t instanceof JsonMappingException))) {
        throw ((IOException)t);
      }
    }
    else if ((!wrap) && 
      ((t instanceof RuntimeException))) {
      throw ((RuntimeException)t);
    }
    throw JsonMappingException.wrapWithPath(t, bean, fieldName);
  }
  
  public void wrapAndThrow(SerializerProvider provider, Throwable t, Object bean, int index)
    throws IOException
  {
    while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
      t = t.getCause();
    }
    if ((t instanceof Error)) {
      throw ((Error)t);
    }
    boolean wrap = (provider == null) || (provider.isEnabled(SerializationFeature.WRAP_EXCEPTIONS));
    if ((t instanceof IOException))
    {
      if ((!wrap) || (!(t instanceof JsonMappingException))) {
        throw ((IOException)t);
      }
    }
    else if ((!wrap) && 
      ((t instanceof RuntimeException))) {
      throw ((RuntimeException)t);
    }
    throw JsonMappingException.wrapWithPath(t, bean, index);
  }
  
  protected boolean isDefaultSerializer(JsonSerializer<?> serializer)
  {
    return ClassUtil.isJacksonStdImpl(serializer);
  }
  
  protected JsonSerializer<?> findConvertingContentSerializer(SerializerProvider provider, BeanProperty prop, JsonSerializer<?> existingSerializer)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = provider.getAnnotationIntrospector();
    if ((intr != null) && (prop != null))
    {
      AnnotatedMember m = prop.getMember();
      if (m != null)
      {
        Object convDef = intr.findSerializationContentConverter(m);
        if (convDef != null)
        {
          Converter<Object, Object> conv = provider.converterInstance(prop.getMember(), convDef);
          JavaType delegateType = conv.getOutputType(provider.getTypeFactory());
          if ((existingSerializer == null) && (!delegateType.hasRawClass(Object.class))) {
            existingSerializer = provider.findValueSerializer(delegateType);
          }
          return new StdDelegatingSerializer(conv, delegateType, existingSerializer);
        }
      }
    }
    return existingSerializer;
  }
  
  protected PropertyFilter findPropertyFilter(SerializerProvider provider, Object filterId, Object valueToFilter)
    throws JsonMappingException
  {
    FilterProvider filters = provider.getFilterProvider();
    if (filters == null) {
      throw new JsonMappingException("Can not resolve PropertyFilter with id '" + filterId + "'; no FilterProvider configured");
    }
    PropertyFilter filter = filters.findPropertyFilter(filterId, valueToFilter);
    
    return filter;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */