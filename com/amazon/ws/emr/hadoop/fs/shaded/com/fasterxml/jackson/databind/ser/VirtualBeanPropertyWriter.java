package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.io.Serializable;
import java.lang.reflect.Type;

public abstract class VirtualBeanPropertyWriter
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected VirtualBeanPropertyWriter(BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType)
  {
    this(propDef, contextAnnotations, declaredType, null, null, null, propDef.findInclusion());
  }
  
  protected VirtualBeanPropertyWriter() {}
  
  protected VirtualBeanPropertyWriter(BeanPropertyDefinition propDef, Annotations contextAnnotations, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, JavaType serType, JsonInclude.Include inclusion)
  {
    super(propDef, propDef.getPrimaryMember(), contextAnnotations, declaredType, ser, typeSer, serType, _suppressNulls(inclusion), _suppressableValue(inclusion));
  }
  
  protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter base)
  {
    super(base);
  }
  
  protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter base, PropertyName name)
  {
    super(base, name);
  }
  
  protected static boolean _suppressNulls(JsonInclude.Include inclusion)
  {
    return inclusion != JsonInclude.Include.ALWAYS;
  }
  
  protected static Object _suppressableValue(JsonInclude.Include inclusion)
  {
    if ((inclusion == JsonInclude.Include.NON_EMPTY) || (inclusion == JsonInclude.Include.NON_EMPTY)) {
      return MARKER_FOR_EMPTY;
    }
    return null;
  }
  
  public boolean isVirtual()
  {
    return true;
  }
  
  public Class<?> getPropertyType()
  {
    return _declaredType.getRawClass();
  }
  
  public Type getGenericPropertyType()
  {
    return getPropertyType();
  }
  
  protected abstract Object value(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract VirtualBeanPropertyWriter withConfig(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType);
  
  public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    Object value = value(bean, gen, prov);
    if (value == null)
    {
      if (_nullSerializer != null)
      {
        gen.writeFieldName(_name);
        _nullSerializer.serialize(null, gen, prov);
      }
      return;
    }
    JsonSerializer<Object> ser = _serializer;
    if (ser == null)
    {
      Class<?> cls = value.getClass();
      PropertySerializerMap m = _dynamicSerializers;
      ser = m.serializerFor(cls);
      if (ser == null) {
        ser = _findAndAddDynamic(m, cls, prov);
      }
    }
    if (_suppressableValue != null) {
      if (MARKER_FOR_EMPTY == _suppressableValue)
      {
        if (!ser.isEmpty(prov, value)) {}
      }
      else if (_suppressableValue.equals(value)) {
        return;
      }
    }
    if (value == bean) {
      if (_handleSelfReference(bean, gen, prov, ser)) {
        return;
      }
    }
    gen.writeFieldName(_name);
    if (_typeSerializer == null) {
      ser.serialize(value, gen, prov);
    } else {
      ser.serializeWithType(value, gen, prov, _typeSerializer);
    }
  }
  
  public void serializeAsElement(Object bean, JsonGenerator gen, SerializerProvider prov)
    throws Exception
  {
    Object value = value(bean, gen, prov);
    if (value == null)
    {
      if (_nullSerializer != null) {
        _nullSerializer.serialize(null, gen, prov);
      } else {
        gen.writeNull();
      }
      return;
    }
    JsonSerializer<Object> ser = _serializer;
    if (ser == null)
    {
      Class<?> cls = value.getClass();
      PropertySerializerMap map = _dynamicSerializers;
      ser = map.serializerFor(cls);
      if (ser == null) {
        ser = _findAndAddDynamic(map, cls, prov);
      }
    }
    if (_suppressableValue != null) {
      if (MARKER_FOR_EMPTY == _suppressableValue)
      {
        if (ser.isEmpty(prov, value)) {
          serializeAsPlaceholder(bean, gen, prov);
        }
      }
      else if (_suppressableValue.equals(value))
      {
        serializeAsPlaceholder(bean, gen, prov);
        return;
      }
    }
    if ((value == bean) && 
      (_handleSelfReference(bean, gen, prov, ser))) {
      return;
    }
    if (_typeSerializer == null) {
      ser.serialize(value, gen, prov);
    } else {
      ser.serializeWithType(value, gen, prov, _typeSerializer);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */