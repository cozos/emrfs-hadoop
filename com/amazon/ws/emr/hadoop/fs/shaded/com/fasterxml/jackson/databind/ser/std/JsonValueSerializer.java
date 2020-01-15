package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

@JacksonStdImpl
public class JsonValueSerializer
  extends StdSerializer<Object>
  implements ContextualSerializer, JsonFormatVisitable, SchemaAware
{
  protected final Method _accessorMethod;
  protected final JsonSerializer<Object> _valueSerializer;
  protected final BeanProperty _property;
  protected final boolean _forceTypeInformation;
  
  public JsonValueSerializer(Method valueMethod, JsonSerializer<?> ser)
  {
    super(valueMethod.getReturnType(), false);
    _accessorMethod = valueMethod;
    _valueSerializer = ser;
    _property = null;
    _forceTypeInformation = true;
  }
  
  public JsonValueSerializer(JsonValueSerializer src, BeanProperty property, JsonSerializer<?> ser, boolean forceTypeInfo)
  {
    super(_notNullClass(src.handledType()));
    _accessorMethod = _accessorMethod;
    _valueSerializer = ser;
    _property = property;
    _forceTypeInformation = forceTypeInfo;
  }
  
  private static final Class<Object> _notNullClass(Class<?> cls)
  {
    return cls == null ? Object.class : cls;
  }
  
  public JsonValueSerializer withResolved(BeanProperty property, JsonSerializer<?> ser, boolean forceTypeInfo)
  {
    if ((_property == property) && (_valueSerializer == ser) && (forceTypeInfo == _forceTypeInformation)) {
      return this;
    }
    return new JsonValueSerializer(this, property, ser, forceTypeInfo);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<?> ser = _valueSerializer;
    if (ser == null)
    {
      if ((provider.isEnabled(MapperFeature.USE_STATIC_TYPING)) || (Modifier.isFinal(_accessorMethod.getReturnType().getModifiers())))
      {
        JavaType t = provider.constructType(_accessorMethod.getGenericReturnType());
        
        ser = provider.findPrimaryPropertySerializer(t, property);
        
        boolean forceTypeInformation = isNaturalTypeWithStdHandling(t.getRawClass(), ser);
        return withResolved(property, ser, forceTypeInformation);
      }
    }
    else
    {
      ser = provider.handlePrimaryContextualization(ser, property);
      return withResolved(property, ser, _forceTypeInformation);
    }
    return this;
  }
  
  public void serialize(Object bean, JsonGenerator jgen, SerializerProvider prov)
    throws IOException
  {
    try
    {
      Object value = _accessorMethod.invoke(bean, new Object[0]);
      if (value == null)
      {
        prov.defaultSerializeNull(jgen);
        return;
      }
      JsonSerializer<Object> ser = _valueSerializer;
      if (ser == null)
      {
        Class<?> c = value.getClass();
        
        ser = prov.findTypedValueSerializer(c, true, _property);
      }
      ser.serialize(value, jgen, prov);
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      Throwable t = e;
      while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
        t = t.getCause();
      }
      if ((t instanceof Error)) {
        throw ((Error)t);
      }
      throw JsonMappingException.wrapWithPath(t, bean, _accessorMethod.getName() + "()");
    }
  }
  
  public void serializeWithType(Object bean, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer0)
    throws IOException
  {
    Object value = null;
    try
    {
      value = _accessorMethod.invoke(bean, new Object[0]);
      if (value == null)
      {
        provider.defaultSerializeNull(jgen);
        return;
      }
      JsonSerializer<Object> ser = _valueSerializer;
      if (ser == null)
      {
        ser = provider.findValueSerializer(value.getClass(), _property);
      }
      else if (_forceTypeInformation)
      {
        typeSer0.writeTypePrefixForScalar(bean, jgen);
        ser.serialize(value, jgen, provider);
        typeSer0.writeTypeSuffixForScalar(bean, jgen);
        return;
      }
      ser.serializeWithType(value, jgen, provider, typeSer0);
    }
    catch (IOException ioe)
    {
      throw ioe;
    }
    catch (Exception e)
    {
      Throwable t = e;
      while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
        t = t.getCause();
      }
      if ((t instanceof Error)) {
        throw ((Error)t);
      }
      throw JsonMappingException.wrapWithPath(t, bean, _accessorMethod.getName() + "()");
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    if ((_valueSerializer instanceof SchemaAware)) {
      return ((SchemaAware)_valueSerializer).getSchema(provider, null);
    }
    return JsonSchema.getDefaultSchemaNode();
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    Class<?> decl = typeHint == null ? null : typeHint.getRawClass();
    if (decl == null) {
      decl = _accessorMethod.getDeclaringClass();
    }
    if ((decl != null) && (decl.isEnum()) && 
      (_acceptJsonFormatVisitorForEnum(visitor, typeHint, decl))) {
      return;
    }
    JsonSerializer<Object> ser = _valueSerializer;
    if (ser == null)
    {
      if (typeHint == null)
      {
        if (_property != null) {
          typeHint = _property.getType();
        }
        if (typeHint == null) {
          typeHint = visitor.getProvider().constructType(_handledType);
        }
      }
      ser = visitor.getProvider().findTypedValueSerializer(typeHint, false, _property);
      if (ser == null)
      {
        visitor.expectAnyFormat(typeHint);
        return;
      }
    }
    ser.acceptJsonFormatVisitor(visitor, null);
  }
  
  protected boolean _acceptJsonFormatVisitorForEnum(JsonFormatVisitorWrapper visitor, JavaType typeHint, Class<?> enumType)
    throws JsonMappingException
  {
    JsonStringFormatVisitor stringVisitor = visitor.expectStringFormat(typeHint);
    if (stringVisitor != null)
    {
      Set<String> enums = new LinkedHashSet();
      for (Object en : enumType.getEnumConstants()) {
        try
        {
          enums.add(String.valueOf(_accessorMethod.invoke(en, new Object[0])));
        }
        catch (Exception e)
        {
          Throwable t = e;
          while (((t instanceof InvocationTargetException)) && (t.getCause() != null)) {
            t = t.getCause();
          }
          if ((t instanceof Error)) {
            throw ((Error)t);
          }
          throw JsonMappingException.wrapWithPath(t, en, _accessorMethod.getName() + "()");
        }
      }
      stringVisitor.enumTypes(enums);
    }
    return true;
  }
  
  protected boolean isNaturalTypeWithStdHandling(Class<?> rawType, JsonSerializer<?> ser)
  {
    if (rawType.isPrimitive())
    {
      if ((rawType != Integer.TYPE) && (rawType != Boolean.TYPE) && (rawType != Double.TYPE)) {
        return false;
      }
    }
    else if ((rawType != String.class) && (rawType != Integer.class) && (rawType != Boolean.class) && (rawType != Double.class)) {
      return false;
    }
    return isDefaultSerializer(ser);
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + _accessorMethod.getDeclaringClass() + "#" + _accessorMethod.getName() + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.JsonValueSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */