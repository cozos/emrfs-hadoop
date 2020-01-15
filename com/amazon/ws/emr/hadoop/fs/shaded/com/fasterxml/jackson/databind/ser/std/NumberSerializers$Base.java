package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;

public abstract class NumberSerializers$Base<T>
  extends StdScalarSerializer<T>
  implements ContextualSerializer
{
  protected static final Integer EMPTY_INTEGER = Integer.valueOf(0);
  protected final JsonParser.NumberType _numberType;
  protected final String _schemaType;
  protected final boolean _isInt;
  
  protected NumberSerializers$Base(Class<?> cls, JsonParser.NumberType numberType, String schemaType)
  {
    super(cls, false);
    _numberType = numberType;
    _schemaType = schemaType;
    _isInt = ((numberType == JsonParser.NumberType.INT) || (numberType == JsonParser.NumberType.LONG) || (numberType == JsonParser.NumberType.BIG_INTEGER));
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode(_schemaType, true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (_isInt)
    {
      JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
      if (v2 != null) {
        v2.numberType(_numberType);
      }
    }
    else
    {
      JsonNumberFormatVisitor v2 = visitor.expectNumberFormat(typeHint);
      if (v2 != null) {
        v2.numberType(_numberType);
      }
    }
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
    throws JsonMappingException
  {
    if (property != null)
    {
      AnnotatedMember m = property.getMember();
      if (m != null)
      {
        JsonFormat.Value format = prov.getAnnotationIntrospector().findFormat(m);
        if (format != null) {
          switch (NumberSerializers.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[format.getShape().ordinal()])
          {
          case 1: 
            return ToStringSerializer.instance;
          }
        }
      }
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */