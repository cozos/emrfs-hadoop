package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.HashSet;

public class BeanAsArrayDeserializer
  extends BeanDeserializerBase
{
  private static final long serialVersionUID = 1L;
  protected final BeanDeserializerBase _delegate;
  protected final SettableBeanProperty[] _orderedProperties;
  
  public BeanAsArrayDeserializer(BeanDeserializerBase delegate, SettableBeanProperty[] ordered)
  {
    super(delegate);
    _delegate = delegate;
    _orderedProperties = ordered;
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper)
  {
    return _delegate.unwrappingDeserializer(unwrapper);
  }
  
  public BeanAsArrayDeserializer withObjectIdReader(ObjectIdReader oir)
  {
    return new BeanAsArrayDeserializer(_delegate.withObjectIdReader(oir), _orderedProperties);
  }
  
  public BeanAsArrayDeserializer withIgnorableProperties(HashSet<String> ignorableProps)
  {
    return new BeanAsArrayDeserializer(_delegate.withIgnorableProperties(ignorableProps), _orderedProperties);
  }
  
  protected BeanDeserializerBase asArrayDeserializer()
  {
    return this;
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (!p.isExpectedStartArrayToken()) {
      return _deserializeFromNonArray(p, ctxt);
    }
    if (!_vanillaProcessing) {
      return _deserializeNonVanilla(p, ctxt);
    }
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    
    p.setCurrentValue(bean);
    
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return bean;
      }
      if (i == propCount) {
        break;
      }
      SettableBeanProperty prop = props[i];
      if (prop != null) {
        try
        {
          prop.deserializeAndSet(p, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, prop.getName(), ctxt);
        }
      } else {
        p.skipChildren();
      }
      i++;
    }
    if (!_ignoreAllUnknown) {
      throw ctxt.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(propCount) });
    }
    while (p.nextToken() != JsonToken.END_ARRAY) {
      p.skipChildren();
    }
    return bean;
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    p.setCurrentValue(bean);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return bean;
      }
      if (i == propCount) {
        break;
      }
      SettableBeanProperty prop = props[i];
      if (prop != null) {
        try
        {
          prop.deserializeAndSet(p, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, prop.getName(), ctxt);
        }
      } else {
        p.skipChildren();
      }
      i++;
    }
    if (!_ignoreAllUnknown) {
      throw ctxt.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(propCount) });
    }
    while (p.nextToken() != JsonToken.END_ARRAY) {
      p.skipChildren();
    }
    return bean;
  }
  
  public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    return _deserializeFromNonArray(p, ctxt);
  }
  
  protected Object _deserializeNonVanilla(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_nonStandardCreation) {
      return _deserializeWithCreator(p, ctxt);
    }
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    
    p.setCurrentValue(bean);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return bean;
      }
      if (i == propCount) {
        break;
      }
      SettableBeanProperty prop = props[i];
      i++;
      if ((prop != null) && (
        (activeView == null) || (prop.visibleInView(activeView)))) {
        try
        {
          prop.deserializeAndSet(p, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, prop.getName(), ctxt);
        }
      } else {
        p.skipChildren();
      }
    }
    if (!_ignoreAllUnknown) {
      throw ctxt.mappingException("Unexpected JSON values; expected at most %d properties (in JSON Array)", new Object[] { Integer.valueOf(propCount) });
    }
    while (p.nextToken() != JsonToken.END_ARRAY) {
      p.skipChildren();
    }
    return bean;
  }
  
  protected Object _deserializeWithCreator(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    if (_propertyBasedCreator != null) {
      return _deserializeUsingPropertyBased(p, ctxt);
    }
    if (_beanType.isAbstract()) {
      throw JsonMappingException.from(p, "Can not instantiate abstract type " + _beanType + " (need to add/enable type information?)");
    }
    throw JsonMappingException.from(p, "No suitable constructor found for type " + _beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    PropertyBasedCreator creator = _propertyBasedCreator;
    PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, _objectIdReader);
    
    SettableBeanProperty[] props = _orderedProperties;
    int propCount = props.length;
    int i = 0;
    Object bean = null;
    for (; p.nextToken() != JsonToken.END_ARRAY; i++)
    {
      SettableBeanProperty prop = i < propCount ? props[i] : null;
      if (prop == null)
      {
        p.skipChildren();
      }
      else if (bean != null)
      {
        try
        {
          prop.deserializeAndSet(p, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, prop.getName(), ctxt);
        }
      }
      else
      {
        String propName = prop.getName();
        
        SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
        if (creatorProp != null)
        {
          if (buffer.assignParameter(creatorProp, creatorProp.deserialize(p, ctxt)))
          {
            try
            {
              bean = creator.build(ctxt, buffer);
            }
            catch (Exception e)
            {
              wrapAndThrow(e, _beanType.getRawClass(), propName, ctxt);
              continue;
            }
            p.setCurrentValue(bean);
            if (bean.getClass() != _beanType.getRawClass()) {
              throw ctxt.mappingException("Can not support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[] { _beanType.getRawClass().getName(), bean.getClass().getName() });
            }
          }
        }
        else if (!buffer.readIdProperty(propName)) {
          buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
        }
      }
    }
    if (bean == null) {
      try
      {
        bean = creator.build(ctxt, buffer);
      }
      catch (Exception e)
      {
        wrapInstantiationProblem(e, ctxt);
        return null;
      }
    }
    return bean;
  }
  
  protected Object _deserializeFromNonArray(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    throw ctxt.mappingException("Can not deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", new Object[] { _beanType.getRawClass().getName(), p.getCurrentToken() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */