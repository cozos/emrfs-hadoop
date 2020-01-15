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
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class BeanAsArrayBuilderDeserializer
  extends BeanDeserializerBase
{
  private static final long serialVersionUID = 1L;
  protected final BeanDeserializerBase _delegate;
  protected final SettableBeanProperty[] _orderedProperties;
  protected final AnnotatedMethod _buildMethod;
  
  public BeanAsArrayBuilderDeserializer(BeanDeserializerBase delegate, SettableBeanProperty[] ordered, AnnotatedMethod buildMethod)
  {
    super(delegate);
    _delegate = delegate;
    _orderedProperties = ordered;
    _buildMethod = buildMethod;
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper)
  {
    return _delegate.unwrappingDeserializer(unwrapper);
  }
  
  public BeanAsArrayBuilderDeserializer withObjectIdReader(ObjectIdReader oir)
  {
    return new BeanAsArrayBuilderDeserializer(_delegate.withObjectIdReader(oir), _orderedProperties, _buildMethod);
  }
  
  public BeanAsArrayBuilderDeserializer withIgnorableProperties(HashSet<String> ignorableProps)
  {
    return new BeanAsArrayBuilderDeserializer(_delegate.withIgnorableProperties(ignorableProps), _orderedProperties, _buildMethod);
  }
  
  protected BeanAsArrayBuilderDeserializer asArrayDeserializer()
  {
    return this;
  }
  
  protected final Object finishBuild(DeserializationContext ctxt, Object builder)
    throws IOException
  {
    try
    {
      return _buildMethod.getMember().invoke(builder, new Object[0]);
    }
    catch (Exception e)
    {
      wrapInstantiationProblem(e, ctxt);
    }
    return null;
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (!p.isExpectedStartArrayToken()) {
      return finishBuild(ctxt, _deserializeFromNonArray(p, ctxt));
    }
    if (!_vanillaProcessing) {
      return finishBuild(ctxt, _deserializeNonVanilla(p, ctxt));
    }
    Object builder = _valueInstantiator.createUsingDefault(ctxt);
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return finishBuild(ctxt, builder);
      }
      if (i == propCount) {
        break;
      }
      SettableBeanProperty prop = props[i];
      if (prop != null) {
        try
        {
          builder = prop.deserializeSetAndReturn(p, ctxt, builder);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, builder, prop.getName(), ctxt);
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
    return finishBuild(ctxt, builder);
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt, Object builder)
    throws IOException
  {
    if (_injectables != null) {
      injectValues(ctxt, builder);
    }
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return finishBuild(ctxt, builder);
      }
      if (i == propCount) {
        break;
      }
      SettableBeanProperty prop = props[i];
      if (prop != null) {
        try
        {
          builder = prop.deserializeSetAndReturn(p, ctxt, builder);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, builder, prop.getName(), ctxt);
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
    return finishBuild(ctxt, builder);
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
    Object builder = _valueInstantiator.createUsingDefault(ctxt);
    if (_injectables != null) {
      injectValues(ctxt, builder);
    }
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    SettableBeanProperty[] props = _orderedProperties;
    int i = 0;
    int propCount = props.length;
    for (;;)
    {
      if (p.nextToken() == JsonToken.END_ARRAY) {
        return builder;
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
          prop.deserializeSetAndReturn(p, ctxt, builder);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, builder, prop.getName(), ctxt);
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
    return builder;
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
    Object builder = null;
    for (; p.nextToken() != JsonToken.END_ARRAY; i++)
    {
      SettableBeanProperty prop = i < propCount ? props[i] : null;
      if (prop == null)
      {
        p.skipChildren();
      }
      else if (builder != null)
      {
        try
        {
          builder = prop.deserializeSetAndReturn(p, ctxt, builder);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, builder, prop.getName(), ctxt);
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
              builder = creator.build(ctxt, buffer);
            }
            catch (Exception e)
            {
              wrapAndThrow(e, _beanType.getRawClass(), propName, ctxt);
              continue;
            }
            if (builder.getClass() != _beanType.getRawClass()) {
              throw ctxt.mappingException("Can not support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[] { _beanType.getRawClass().getName(), builder.getClass().getName() });
            }
          }
        }
        else if (!buffer.readIdProperty(propName)) {
          buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
        }
      }
    }
    if (builder == null) {
      try
      {
        builder = creator.build(ctxt, buffer);
      }
      catch (Exception e)
      {
        wrapInstantiationProblem(e, ctxt);
        return null;
      }
    }
    return builder;
  }
  
  protected Object _deserializeFromNonArray(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    throw ctxt.mappingException("Can not deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", new Object[] { _beanType.getRawClass().getName(), p.getCurrentToken() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */