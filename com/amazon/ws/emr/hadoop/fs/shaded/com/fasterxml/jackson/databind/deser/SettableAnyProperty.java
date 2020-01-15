package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;

public class SettableAnyProperty
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final BeanProperty _property;
  protected final AnnotatedMethod _setter;
  protected final JavaType _type;
  protected JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public SettableAnyProperty(BeanProperty property, AnnotatedMethod setter, JavaType type, JsonDeserializer<Object> valueDeser, TypeDeserializer typeDeser)
  {
    _property = property;
    _setter = setter;
    _type = type;
    _valueDeserializer = valueDeser;
    _valueTypeDeserializer = typeDeser;
  }
  
  public SettableAnyProperty withValueDeserializer(JsonDeserializer<Object> deser)
  {
    return new SettableAnyProperty(_property, _setter, _type, deser, _valueTypeDeserializer);
  }
  
  protected SettableAnyProperty(SettableAnyProperty src)
  {
    _property = _property;
    _setter = _setter;
    _type = _type;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
  }
  
  Object readResolve()
  {
    if ((_setter == null) || (_setter.getAnnotated() == null)) {
      throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }
    return this;
  }
  
  public BeanProperty getProperty()
  {
    return _property;
  }
  
  public boolean hasValueDeserializer()
  {
    return _valueDeserializer != null;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public final void deserializeAndSet(JsonParser jp, DeserializationContext ctxt, Object instance, String propName)
    throws IOException
  {
    try
    {
      set(instance, propName, deserialize(jp, ctxt));
    }
    catch (UnresolvedForwardReference reference)
    {
      if (_valueDeserializer.getObjectIdReader() == null) {
        throw JsonMappingException.from(jp, "Unresolved forward reference but no identity info.", reference);
      }
      AnySetterReferring referring = new AnySetterReferring(this, reference, _type.getRawClass(), instance, propName);
      
      reference.getRoid().appendReferring(referring);
    }
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.VALUE_NULL) {
      return _valueDeserializer.getNullValue(ctxt);
    }
    if (_valueTypeDeserializer != null) {
      return _valueDeserializer.deserializeWithType(jp, ctxt, _valueTypeDeserializer);
    }
    return _valueDeserializer.deserialize(jp, ctxt);
  }
  
  public void set(Object instance, String propName, Object value)
    throws IOException
  {
    try
    {
      _setter.getAnnotated().invoke(instance, new Object[] { propName, value });
    }
    catch (Exception e)
    {
      _throwAsIOE(e, propName, value);
    }
  }
  
  protected void _throwAsIOE(Exception e, String propName, Object value)
    throws IOException
  {
    if ((e instanceof IllegalArgumentException))
    {
      String actType = value == null ? "[NULL]" : value.getClass().getName();
      StringBuilder msg = new StringBuilder("Problem deserializing \"any\" property '").append(propName);
      msg.append("' of class " + getClassName() + " (expected type: ").append(_type);
      msg.append("; actual type: ").append(actType).append(")");
      String origMsg = e.getMessage();
      if (origMsg != null) {
        msg.append(", problem: ").append(origMsg);
      } else {
        msg.append(" (no error message provided)");
      }
      throw new JsonMappingException(msg.toString(), null, e);
    }
    if ((e instanceof IOException)) {
      throw ((IOException)e);
    }
    if ((e instanceof RuntimeException)) {
      throw ((RuntimeException)e);
    }
    Throwable t = e;
    while (t.getCause() != null) {
      t = t.getCause();
    }
    throw new JsonMappingException(t.getMessage(), null, t);
  }
  
  private String getClassName()
  {
    return _setter.getDeclaringClass().getName();
  }
  
  public String toString()
  {
    return "[any property on class " + getClassName() + "]";
  }
  
  private static class AnySetterReferring
    extends ReadableObjectId.Referring
  {
    private final SettableAnyProperty _parent;
    private final Object _pojo;
    private final String _propName;
    
    public AnySetterReferring(SettableAnyProperty parent, UnresolvedForwardReference reference, Class<?> type, Object instance, String propName)
    {
      super(type);
      _parent = parent;
      _pojo = instance;
      _propName = propName;
    }
    
    public void handleResolvedForwardReference(Object id, Object value)
      throws IOException
    {
      if (!hasId(id)) {
        throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id.toString() + "] that wasn't previously registered.");
      }
      _parent.set(_pojo, _propName, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */