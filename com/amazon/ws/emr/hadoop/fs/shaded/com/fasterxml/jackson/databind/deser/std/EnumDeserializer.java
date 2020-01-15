package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.IOException;
import java.lang.reflect.Method;

@JacksonStdImpl
public class EnumDeserializer
  extends StdScalarDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  protected final CompactStringObjectMap _enumLookup;
  protected Object[] _enumsByIndex;
  
  public EnumDeserializer(EnumResolver res)
  {
    super(res.getEnumClass());
    _enumLookup = res.constructLookup();
    _enumsByIndex = res.getRawEnums();
  }
  
  public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig config, Class<?> enumClass, AnnotatedMethod factory)
  {
    Class<?> paramClass = factory.getRawParameterType(0);
    if (config.canOverrideAccessModifiers()) {
      ClassUtil.checkAndFixAccess(factory.getMember());
    }
    return new FactoryBasedDeserializer(enumClass, factory, paramClass);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken curr = p.getCurrentToken();
    if ((curr == JsonToken.VALUE_STRING) || (curr == JsonToken.FIELD_NAME))
    {
      String name = p.getText();
      Object result = _enumLookup.find(name);
      if (result == null) {
        return _deserializeAltString(p, ctxt, name);
      }
      return result;
    }
    if (curr == JsonToken.VALUE_NUMBER_INT)
    {
      _checkFailOnNumber(ctxt);
      
      int index = p.getIntValue();
      if ((index >= 0) && (index <= _enumsByIndex.length)) {
        return _enumsByIndex[index];
      }
      if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
        throw ctxt.weirdNumberException(Integer.valueOf(index), _enumClass(), "index value outside legal index range [0.." + (_enumsByIndex.length - 1) + "]");
      }
      return null;
    }
    return _deserializeOther(p, ctxt);
  }
  
  private final Object _deserializeAltString(JsonParser p, DeserializationContext ctxt, String name)
    throws IOException
  {
    name = name.trim();
    if (name.length() == 0)
    {
      if (ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
        return null;
      }
    }
    else
    {
      char c = name.charAt(0);
      if ((c >= '0') && (c <= '9')) {
        try
        {
          int ix = Integer.parseInt(name);
          _checkFailOnNumber(ctxt);
          if ((ix >= 0) && (ix <= _enumsByIndex.length)) {
            return _enumsByIndex[ix];
          }
        }
        catch (NumberFormatException e) {}
      }
    }
    if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
      throw ctxt.weirdStringException(name, _enumClass(), "value not one of declared Enum instance names: " + _enumLookup.keys());
    }
    return null;
  }
  
  protected Object _deserializeOther(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken curr = p.getCurrentToken();
    if ((ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) && (p.isExpectedStartArrayToken()))
    {
      p.nextToken();
      Object parsed = deserialize(p, ctxt);
      curr = p.nextToken();
      if (curr != JsonToken.END_ARRAY) {
        throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _enumClass().getName() + "' value but there was more than a single value in the array");
      }
      return parsed;
    }
    throw ctxt.mappingException(_enumClass());
  }
  
  protected void _checkFailOnNumber(DeserializationContext ctxt)
    throws IOException
  {
    if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
      throw ctxt.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
    }
  }
  
  protected Class<?> _enumClass()
  {
    return handledType();
  }
  
  protected static class FactoryBasedDeserializer
    extends StdDeserializer<Object>
    implements ContextualDeserializer
  {
    private static final long serialVersionUID = 1L;
    protected final Class<?> _inputType;
    protected final Method _factory;
    protected final JsonDeserializer<?> _deser;
    
    public FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod f, Class<?> inputType)
    {
      super();
      _factory = f.getAnnotated();
      _inputType = inputType;
      _deser = null;
    }
    
    protected FactoryBasedDeserializer(FactoryBasedDeserializer base, JsonDeserializer<?> deser)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.EnumDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */