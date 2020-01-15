package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Method;

public class EnumDeserializer$FactoryBasedDeserializer
  extends StdDeserializer<Object>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _inputType;
  protected final Method _factory;
  protected final JsonDeserializer<?> _deser;
  
  public EnumDeserializer$FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod f, Class<?> inputType)
  {
    super(cls);
    _factory = f.getAnnotated();
    _inputType = inputType;
    _deser = null;
  }
  
  protected EnumDeserializer$FactoryBasedDeserializer(FactoryBasedDeserializer base, JsonDeserializer<?> deser)
  {
    super(_valueClass);
    _inputType = _inputType;
    _factory = _factory;
    _deser = deser;
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    if ((_deser == null) && (_inputType != String.class)) {
      return new FactoryBasedDeserializer(this, ctxt.findContextualValueDeserializer(ctxt.constructType(_inputType), property));
    }
    return this;
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    Object value;
    Object value;
    if (_deser != null)
    {
      value = _deser.deserialize(p, ctxt);
    }
    else
    {
      JsonToken curr = p.getCurrentToken();
      Object value;
      if ((curr == JsonToken.VALUE_STRING) || (curr == JsonToken.FIELD_NAME)) {
        value = p.getText();
      } else {
        value = p.getValueAsString();
      }
    }
    try
    {
      return _factory.invoke(_valueClass, new Object[] { value });
    }
    catch (Exception e)
    {
      Throwable t = ClassUtil.getRootCause(e);
      if ((t instanceof IOException)) {
        throw ((IOException)t);
      }
      throw ctxt.instantiationException(_valueClass, t);
    }
  }
  
  public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    if (_deser == null) {
      return deserialize(p, ctxt);
    }
    return typeDeserializer.deserializeTypedFromAny(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.EnumDeserializer.FactoryBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */