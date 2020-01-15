package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class BeanDeserializer
  extends BeanDeserializerBase
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public BeanDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews)
  {
    super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
  }
  
  protected BeanDeserializer(BeanDeserializerBase src)
  {
    super(src, _ignoreAllUnknown);
  }
  
  protected BeanDeserializer(BeanDeserializerBase src, boolean ignoreAllUnknown)
  {
    super(src, ignoreAllUnknown);
  }
  
  protected BeanDeserializer(BeanDeserializerBase src, NameTransformer unwrapper)
  {
    super(src, unwrapper);
  }
  
  public BeanDeserializer(BeanDeserializerBase src, ObjectIdReader oir)
  {
    super(src, oir);
  }
  
  public BeanDeserializer(BeanDeserializerBase src, HashSet<String> ignorableProps)
  {
    super(src, ignorableProps);
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper)
  {
    if (getClass() != BeanDeserializer.class) {
      return this;
    }
    return new BeanDeserializer(this, unwrapper);
  }
  
  public BeanDeserializer withObjectIdReader(ObjectIdReader oir)
  {
    return new BeanDeserializer(this, oir);
  }
  
  public BeanDeserializer withIgnorableProperties(HashSet<String> ignorableProps)
  {
    return new BeanDeserializer(this, ignorableProps);
  }
  
  protected BeanDeserializerBase asArrayDeserializer()
  {
    SettableBeanProperty[] props = _beanProperties.getPropertiesInInsertionOrder();
    return new BeanAsArrayDeserializer(this, props);
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.isExpectedStartObjectToken())
    {
      if (_vanillaProcessing) {
        return vanillaDeserialize(p, ctxt, p.nextToken());
      }
      p.nextToken();
      if (_objectIdReader != null) {
        return deserializeWithObjectId(p, ctxt);
      }
      return deserializeFromObject(p, ctxt);
    }
    JsonToken t = p.getCurrentToken();
    return _deserializeOther(p, ctxt, t);
  }
  
  protected final Object _deserializeOther(JsonParser p, DeserializationContext ctxt, JsonToken t)
    throws IOException
  {
    switch (t)
    {
    case VALUE_STRING: 
      return deserializeFromString(p, ctxt);
    case VALUE_NUMBER_INT: 
      return deserializeFromNumber(p, ctxt);
    case VALUE_NUMBER_FLOAT: 
      return deserializeFromDouble(p, ctxt);
    case VALUE_EMBEDDED_OBJECT: 
      return deserializeFromEmbedded(p, ctxt);
    case VALUE_TRUE: 
    case VALUE_FALSE: 
      return deserializeFromBoolean(p, ctxt);
    case START_ARRAY: 
      return deserializeFromArray(p, ctxt);
    case FIELD_NAME: 
    case END_OBJECT: 
      if (_vanillaProcessing) {
        return vanillaDeserialize(p, ctxt, t);
      }
      if (_objectIdReader != null) {
        return deserializeWithObjectId(p, ctxt);
      }
      return deserializeFromObject(p, ctxt);
    }
    throw ctxt.mappingException(handledType());
  }
  
  protected Object _missingToken(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    throw ctxt.endOfInputException(handledType());
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    p.setCurrentValue(bean);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    if (_unwrappedPropertyHandler != null) {
      return deserializeWithUnwrapped(p, ctxt, bean);
    }
    if (_externalTypeIdHandler != null) {
      return deserializeWithExternalTypeId(p, ctxt, bean);
    }
    if (p.isExpectedStartObjectToken())
    {
      String propName = p.nextFieldName();
      if (propName == null) {
        return bean;
      }
    }
    else
    {
      String propName;
      if (p.hasTokenId(5)) {
        propName = p.getCurrentName();
      } else {
        return bean;
      }
    }
    String propName;
    if (_needViewProcesing)
    {
      Class<?> view = ctxt.getActiveView();
      if (view != null) {
        return deserializeWithView(p, ctxt, bean, view);
      }
    }
    do
    {
      p.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null) {
        try
        {
          prop.deserializeAndSet(p, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, propName, ctxt);
        }
      } else {
        handleUnknownVanilla(p, ctxt, bean, propName);
      }
    } while ((propName = p.nextFieldName()) != null);
    return bean;
  }
  
  private final Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t)
    throws IOException
  {
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    
    p.setCurrentValue(bean);
    if (p.hasTokenId(5))
    {
      String propName = p.getCurrentName();
      do
      {
        p.nextToken();
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null) {
          try
          {
            prop.deserializeAndSet(p, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        } else {
          handleUnknownVanilla(p, ctxt, bean, propName);
        }
      } while ((propName = p.nextFieldName()) != null);
    }
    return bean;
  }
  
  public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if ((_objectIdReader != null) && (_objectIdReader.maySerializeAsObject()) && 
      (p.hasTokenId(5)) && (_objectIdReader.isValidReferencePropertyName(p.getCurrentName(), p))) {
      return deserializeFromObjectId(p, ctxt);
    }
    if (_nonStandardCreation)
    {
      if (_unwrappedPropertyHandler != null) {
        return deserializeWithUnwrapped(p, ctxt);
      }
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(p, ctxt);
      }
      Object bean = deserializeFromObjectUsingNonDefault(p, ctxt);
      if (_injectables != null) {
        injectValues(ctxt, bean);
      }
      return bean;
    }
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    
    p.setCurrentValue(bean);
    if (p.canReadObjectId())
    {
      Object id = p.getObjectId();
      if (id != null) {
        _handleTypedObjectId(p, ctxt, bean, id);
      }
    }
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    if (_needViewProcesing)
    {
      Class<?> view = ctxt.getActiveView();
      if (view != null) {
        return deserializeWithView(p, ctxt, bean, view);
      }
    }
    if (p.hasTokenId(5))
    {
      String propName = p.getCurrentName();
      do
      {
        p.nextToken();
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null) {
          try
          {
            prop.deserializeAndSet(p, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        } else {
          handleUnknownVanilla(p, ctxt, bean, propName);
        }
      } while ((propName = p.nextFieldName()) != null);
    }
    return bean;
  }
  
  protected Object _deserializeUsingPropertyBased(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    PropertyBasedCreator creator = _propertyBasedCreator;
    PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, _objectIdReader);
    
    TokenBuffer unknown = null;
    for (JsonToken t = p.getCurrentToken(); t == JsonToken.FIELD_NAME; t = p.nextToken())
    {
      String propName = p.getCurrentName();
      p.nextToken();
      
      SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
      if (creatorProp != null)
      {
        if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp)))
        {
          p.nextToken();
          Object bean;
          try
          {
            bean = creator.build(ctxt, buffer);
          }
          catch (Exception e)
          {
            wrapInstantiationProblem(e, ctxt);
            bean = null;
          }
          if (bean == null) {
            throw ctxt.instantiationException(_beanType.getRawClass(), "JSON Creator returned null");
          }
          p.setCurrentValue(bean);
          if (bean.getClass() != _beanType.getRawClass()) {
            return handlePolymorphic(p, ctxt, bean, unknown);
          }
          if (unknown != null) {
            bean = handleUnknownProperties(ctxt, bean, unknown);
          }
          return deserialize(p, ctxt, bean);
        }
      }
      else if (!buffer.readIdProperty(propName))
      {
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null)
        {
          buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
        {
          handleIgnoredProperty(p, ctxt, handledType(), propName);
        }
        else if (_anySetter != null)
        {
          try
          {
            buffer.bufferAnyProperty(_anySetter, propName, _anySetter.deserialize(p, ctxt));
          }
          catch (Exception e)
          {
            wrapAndThrow(e, _beanType.getRawClass(), propName, ctxt);
          }
        }
        else
        {
          if (unknown == null) {
            unknown = new TokenBuffer(p, ctxt);
          }
          unknown.writeFieldName(propName);
          unknown.copyCurrentStructure(p);
        }
      }
    }
    Object bean;
    try
    {
      bean = creator.build(ctxt, buffer);
    }
    catch (Exception e)
    {
      wrapInstantiationProblem(e, ctxt);
      bean = null;
    }
    if (unknown != null)
    {
      if (bean.getClass() != _beanType.getRawClass()) {
        return handlePolymorphic(null, ctxt, bean, unknown);
      }
      return handleUnknownProperties(ctxt, bean, unknown);
    }
    return bean;
  }
  
  protected final Object _deserializeWithErrorWrapping(JsonParser p, DeserializationContext ctxt, SettableBeanProperty prop)
    throws IOException
  {
    try
    {
      return prop.deserialize(p, ctxt);
    }
    catch (Exception e)
    {
      wrapAndThrow(e, _beanType.getRawClass(), prop.getName(), ctxt);
    }
    return null;
  }
  
  protected final Object deserializeWithView(JsonParser p, DeserializationContext ctxt, Object bean, Class<?> activeView)
    throws IOException
  {
    if (p.hasTokenId(5))
    {
      String propName = p.getCurrentName();
      do
      {
        p.nextToken();
        
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null)
        {
          if (!prop.visibleInView(activeView)) {
            p.skipChildren();
          } else {
            try
            {
              prop.deserializeAndSet(p, ctxt, bean);
            }
            catch (Exception e)
            {
              wrapAndThrow(e, bean, propName, ctxt);
            }
          }
        }
        else {
          handleUnknownVanilla(p, ctxt, bean, propName);
        }
      } while ((propName = p.nextFieldName()) != null);
    }
    return bean;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(p, ctxt);
    }
    TokenBuffer tokens = new TokenBuffer(p, ctxt);
    tokens.writeStartObject();
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    
    p.setCurrentValue(bean);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    for (String propName = p.hasTokenId(5) ? p.getCurrentName() : null; propName != null; propName = p.nextFieldName())
    {
      p.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null)
      {
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          p.skipChildren();
        } else {
          try
          {
            prop.deserializeAndSet(p, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        handleIgnoredProperty(p, ctxt, bean, propName);
      }
      else
      {
        tokens.writeFieldName(propName);
        tokens.copyCurrentStructure(p);
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(p, ctxt, bean, propName);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
    }
    tokens.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
    return bean;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser p, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.START_OBJECT) {
      t = p.nextToken();
    }
    TokenBuffer tokens = new TokenBuffer(p, ctxt);
    tokens.writeStartObject();
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    for (; t == JsonToken.FIELD_NAME; t = p.nextToken())
    {
      String propName = p.getCurrentName();
      SettableBeanProperty prop = _beanProperties.find(propName);
      p.nextToken();
      if (prop != null)
      {
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          p.skipChildren();
        } else {
          try
          {
            prop.deserializeAndSet(p, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        handleIgnoredProperty(p, ctxt, bean, propName);
      }
      else
      {
        tokens.writeFieldName(propName);
        tokens.copyCurrentStructure(p);
        if (_anySetter != null) {
          _anySetter.deserializeAndSet(p, ctxt, bean, propName);
        }
      }
    }
    tokens.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
    return bean;
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    PropertyBasedCreator creator = _propertyBasedCreator;
    PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, _objectIdReader);
    
    TokenBuffer tokens = new TokenBuffer(p, ctxt);
    tokens.writeStartObject();
    for (JsonToken t = p.getCurrentToken(); t == JsonToken.FIELD_NAME; t = p.nextToken())
    {
      String propName = p.getCurrentName();
      p.nextToken();
      
      SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
      if (creatorProp != null)
      {
        if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp)))
        {
          t = p.nextToken();
          Object bean;
          try
          {
            bean = creator.build(ctxt, buffer);
          }
          catch (Exception e)
          {
            wrapInstantiationProblem(e, ctxt);
            continue;
          }
          p.setCurrentValue(bean);
          while (t == JsonToken.FIELD_NAME)
          {
            p.nextToken();
            tokens.copyCurrentStructure(p);
            t = p.nextToken();
          }
          tokens.writeEndObject();
          if (bean.getClass() != _beanType.getRawClass())
          {
            tokens.close();
            throw ctxt.mappingException("Can not create polymorphic instances with unwrapped values");
          }
          return _unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
        }
      }
      else if (!buffer.readIdProperty(propName))
      {
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null)
        {
          buffer.bufferProperty(prop, _deserializeWithErrorWrapping(p, ctxt, prop));
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
        {
          handleIgnoredProperty(p, ctxt, handledType(), propName);
        }
        else
        {
          tokens.writeFieldName(propName);
          tokens.copyCurrentStructure(p);
          if (_anySetter != null) {
            try
            {
              buffer.bufferAnyProperty(_anySetter, propName, _anySetter.deserialize(p, ctxt));
            }
            catch (Exception e)
            {
              wrapAndThrow(e, _beanType.getRawClass(), propName, ctxt);
            }
          }
        }
      }
    }
    Object bean;
    try
    {
      bean = creator.build(ctxt, buffer);
    }
    catch (Exception e)
    {
      wrapInstantiationProblem(e, ctxt);
      return null;
    }
    return _unwrappedPropertyHandler.processUnwrapped(p, ctxt, bean, tokens);
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(p, ctxt);
    }
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(p, ctxt));
    }
    return deserializeWithExternalTypeId(p, ctxt, _valueInstantiator.createUsingDefault(ctxt));
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser p, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    ExternalTypeHandler ext = _externalTypeIdHandler.start();
    for (JsonToken t = p.getCurrentToken(); t == JsonToken.FIELD_NAME; t = p.nextToken())
    {
      String propName = p.getCurrentName();
      t = p.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null)
      {
        if (t.isScalarValue()) {
          ext.handleTypePropertyValue(p, ctxt, propName, bean);
        }
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          p.skipChildren();
        } else {
          try
          {
            prop.deserializeAndSet(p, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        handleIgnoredProperty(p, ctxt, bean, propName);
      }
      else if (!ext.handlePropertyValue(p, ctxt, propName, bean))
      {
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(p, ctxt, bean, propName);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        } else {
          handleUnknownProperty(p, ctxt, bean, propName);
        }
      }
    }
    return ext.complete(p, ctxt, bean);
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    ExternalTypeHandler ext = _externalTypeIdHandler.start();
    PropertyBasedCreator creator = _propertyBasedCreator;
    PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, _objectIdReader);
    
    TokenBuffer tokens = new TokenBuffer(p, ctxt);
    tokens.writeStartObject();
    for (JsonToken t = p.getCurrentToken(); t == JsonToken.FIELD_NAME; t = p.nextToken())
    {
      String propName = p.getCurrentName();
      p.nextToken();
      
      SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
      if (creatorProp != null)
      {
        if (!ext.handlePropertyValue(p, ctxt, propName, null)) {
          if (buffer.assignParameter(creatorProp, _deserializeWithErrorWrapping(p, ctxt, creatorProp)))
          {
            t = p.nextToken();
            Object bean;
            try
            {
              bean = creator.build(ctxt, buffer);
            }
            catch (Exception e)
            {
              wrapAndThrow(e, _beanType.getRawClass(), propName, ctxt);
              continue;
            }
            while (t == JsonToken.FIELD_NAME)
            {
              p.nextToken();
              tokens.copyCurrentStructure(p);
              t = p.nextToken();
            }
            if (bean.getClass() != _beanType.getRawClass()) {
              throw ctxt.mappingException("Can not create polymorphic instances with unwrapped values");
            }
            return ext.complete(p, ctxt, bean);
          }
        }
      }
      else if (!buffer.readIdProperty(propName))
      {
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null) {
          buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
        } else if (!ext.handlePropertyValue(p, ctxt, propName, null)) {
          if ((_ignorableProps != null) && (_ignorableProps.contains(propName))) {
            handleIgnoredProperty(p, ctxt, handledType(), propName);
          } else if (_anySetter != null) {
            buffer.bufferAnyProperty(_anySetter, propName, _anySetter.deserialize(p, ctxt));
          }
        }
      }
    }
    try
    {
      return ext.complete(p, ctxt, buffer, creator);
    }
    catch (Exception e)
    {
      wrapInstantiationProblem(e, ctxt);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BeanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */