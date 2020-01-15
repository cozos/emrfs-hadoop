package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

@JacksonStdImpl
public final class StringCollectionDeserializer
  extends ContainerDeserializerBase<Collection<String>>
  implements ContextualDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _collectionType;
  protected final JsonDeserializer<String> _valueDeserializer;
  protected final ValueInstantiator _valueInstantiator;
  protected final JsonDeserializer<Object> _delegateDeserializer;
  
  public StringCollectionDeserializer(JavaType collectionType, JsonDeserializer<?> valueDeser, ValueInstantiator valueInstantiator)
  {
    this(collectionType, valueInstantiator, null, valueDeser);
  }
  
  protected StringCollectionDeserializer(JavaType collectionType, ValueInstantiator valueInstantiator, JsonDeserializer<?> delegateDeser, JsonDeserializer<?> valueDeser)
  {
    super(collectionType);
    _collectionType = collectionType;
    _valueDeserializer = valueDeser;
    _valueInstantiator = valueInstantiator;
    _delegateDeserializer = delegateDeser;
  }
  
  protected StringCollectionDeserializer withResolved(JsonDeserializer<?> delegateDeser, JsonDeserializer<?> valueDeser)
  {
    if ((_valueDeserializer == valueDeser) && (_delegateDeserializer == delegateDeser)) {
      return this;
    }
    return new StringCollectionDeserializer(_collectionType, _valueInstantiator, delegateDeser, valueDeser);
  }
  
  public boolean isCachable()
  {
    return (_valueDeserializer == null) && (_delegateDeserializer == null);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
    throws JsonMappingException
  {
    JsonDeserializer<Object> delegate = null;
    if (_valueInstantiator != null)
    {
      AnnotatedWithParams delegateCreator = _valueInstantiator.getDelegateCreator();
      if (delegateCreator != null)
      {
        JavaType delegateType = _valueInstantiator.getDelegateType(ctxt.getConfig());
        delegate = findDeserializer(ctxt, delegateType, property);
      }
    }
    JsonDeserializer<?> valueDeser = _valueDeserializer;
    JavaType valueType = _collectionType.getContentType();
    if (valueDeser == null)
    {
      valueDeser = findConvertingContentDeserializer(ctxt, property, valueDeser);
      if (valueDeser == null) {
        valueDeser = ctxt.findContextualValueDeserializer(valueType, property);
      }
    }
    else
    {
      valueDeser = ctxt.handleSecondaryContextualization(valueDeser, property, valueType);
    }
    if (isDefaultDeserializer(valueDeser)) {
      valueDeser = null;
    }
    return withResolved(delegate, valueDeser);
  }
  
  public JavaType getContentType()
  {
    return _collectionType.getContentType();
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    JsonDeserializer<?> deser = _valueDeserializer;
    return deser;
  }
  
  public Collection<String> deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return (Collection)_valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
    }
    Collection<String> result = (Collection)_valueInstantiator.createUsingDefault(ctxt);
    return deserialize(jp, ctxt, result);
  }
  
  public Collection<String> deserialize(JsonParser jp, DeserializationContext ctxt, Collection<String> result)
    throws IOException
  {
    if (!jp.isExpectedStartArrayToken()) {
      return handleNonArray(jp, ctxt, result);
    }
    if (_valueDeserializer != null) {
      return deserializeUsingCustom(jp, ctxt, result, _valueDeserializer);
    }
    try
    {
      for (;;)
      {
        String value = jp.nextTextValue();
        if (value != null)
        {
          result.add(value);
        }
        else
        {
          JsonToken t = jp.getCurrentToken();
          if (t == JsonToken.END_ARRAY) {
            break;
          }
          if (t != JsonToken.VALUE_NULL) {
            value = _parseString(jp, ctxt);
          }
          result.add(value);
        }
      }
    }
    catch (Exception e)
    {
      throw JsonMappingException.wrapWithPath(e, result, result.size());
    }
    return result;
  }
  
  private Collection<String> deserializeUsingCustom(JsonParser jp, DeserializationContext ctxt, Collection<String> result, JsonDeserializer<String> deser)
    throws IOException
  {
    for (;;)
    {
      String value;
      String value;
      if (jp.nextTextValue() == null)
      {
        JsonToken t = jp.getCurrentToken();
        if (t == JsonToken.END_ARRAY) {
          break;
        }
        value = t == JsonToken.VALUE_NULL ? (String)deser.getNullValue(ctxt) : (String)deser.deserialize(jp, ctxt);
      }
      else
      {
        value = (String)deser.deserialize(jp, ctxt);
      }
      result.add(value);
    }
    return result;
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromArray(jp, ctxt);
  }
  
  private final Collection<String> handleNonArray(JsonParser jp, DeserializationContext ctxt, Collection<String> result)
    throws IOException
  {
    if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw ctxt.mappingException(_collectionType.getRawClass());
    }
    JsonDeserializer<String> valueDes = _valueDeserializer;
    JsonToken t = jp.getCurrentToken();
    String value;
    String value;
    if (t == JsonToken.VALUE_NULL) {
      value = valueDes == null ? null : (String)valueDes.getNullValue(ctxt);
    } else {
      value = valueDes == null ? _parseString(jp, ctxt) : (String)valueDes.deserialize(jp, ctxt);
    }
    result.add(value);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */