package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdSerializer;

public abstract class ContainerSerializer<T>
  extends StdSerializer<T>
{
  protected ContainerSerializer(Class<T> t)
  {
    super(t);
  }
  
  protected ContainerSerializer(JavaType fullType)
  {
    super(fullType);
  }
  
  protected ContainerSerializer(Class<?> t, boolean dummy)
  {
    super(t, dummy);
  }
  
  protected ContainerSerializer(ContainerSerializer<?> src)
  {
    super(_handledType, false);
  }
  
  public ContainerSerializer<?> withValueTypeSerializer(TypeSerializer vts)
  {
    if (vts == null) {
      return this;
    }
    return _withValueTypeSerializer(vts);
  }
  
  public abstract JavaType getContentType();
  
  public abstract JsonSerializer<?> getContentSerializer();
  
  @Deprecated
  public boolean isEmpty(T value)
  {
    return isEmpty(null, value);
  }
  
  public abstract boolean hasSingleElement(T paramT);
  
  protected abstract ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  protected boolean hasContentTypeAnnotation(SerializerProvider provider, BeanProperty property)
  {
    if (property != null)
    {
      AnnotationIntrospector intr = provider.getAnnotationIntrospector();
      AnnotatedMember m = property.getMember();
      if ((m != null) && (intr != null) && 
        (intr.findSerializationContentType(m, property.getType()) != null)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */