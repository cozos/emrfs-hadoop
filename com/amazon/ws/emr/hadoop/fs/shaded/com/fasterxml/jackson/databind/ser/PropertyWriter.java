package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.annotation.Annotation;

public abstract class PropertyWriter
{
  public abstract String getName();
  
  public abstract PropertyName getFullName();
  
  public <A extends Annotation> A findAnnotation(Class<A> acls)
  {
    A ann = getAnnotation(acls);
    if (ann == null) {
      ann = getContextAnnotation(acls);
    }
    return ann;
  }
  
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public abstract <A extends Annotation> A getContextAnnotation(Class<A> paramClass);
  
  public abstract void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract void serializeAsOmittedField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract void serializeAsElement(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract void serializeAsPlaceholder(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract void depositSchemaProperty(JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    throws JsonMappingException;
  
  @Deprecated
  public abstract void depositSchemaProperty(ObjectNode paramObjectNode, SerializerProvider paramSerializerProvider)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */