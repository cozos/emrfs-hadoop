package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;

public class BuilderBasedDeserializer
  extends BeanDeserializerBase
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _buildMethod;
  
  public BuilderBasedDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, BeanPropertyMap properties, Map<String, SettableBeanProperty> backRefs, HashSet<String> ignorableProps, boolean ignoreAllUnknown, boolean hasViews)
  {
    super(builder, beanDesc, properties, backRefs, ignorableProps, ignoreAllUnknown, hasViews);
    
    _buildMethod = builder.getBuildMethod();
    if (_objectIdReader != null) {
      throw new IllegalArgumentException("Can not use Object Id with Builder-based deserialization (type " + beanDesc.getType() + ")");
    }
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer src)
  {
    this(src, _ignoreAllUnknown);
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer src, boolean ignoreAllUnknown)
  {
    super(src, ignoreAllUnknown);
    _buildMethod = _buildMethod;
  }
  
  protected BuilderBasedDeserializer(BuilderBasedDeserializer src, NameTransformer unwrapper)
  {
    super(src, unwrapper);
    _buildMethod = _buildMethod;
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer src, ObjectIdReader oir)
  {
    super(src, oir);
    _buildMethod = _buildMethod;
  }
  
  public BuilderBasedDeserializer(BuilderBasedDeserializer src, HashSet<String> ignorableProps)
  {
    super(src, ignorableProps);
    _buildMethod = _buildMethod;
  }
  
  public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer unwrapper)
  {
    return new BuilderBasedDeserializer(this, unwrapper);
  }
  
  public BuilderBasedDeserializer withObjectIdReader(ObjectIdReader oir)
  {
    return new BuilderBasedDeserializer(this, oir);
  }
  
  public BuilderBasedDeserializer withIgnorableProperties(HashSet<String> ignorableProps)
  {
    return new BuilderBasedDeserializer(this, ignorableProps);
  }
  
  protected BeanAsArrayBuilderDeserializer asArrayDeserializer()
  {
    SettableBeanProperty[] props = _beanProperties.getPropertiesInInsertionOrder();
    return new BeanAsArrayBuilderDeserializer(this, props, _buildMethod);
  }
  
  protected final Object finishBuild(DeserializationContext ctxt, Object builder)
    throws IOException
  {
    if (null == _buildMethod) {
      return builder;
    }
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
  
  public final Object deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_OBJECT)
    {
      t = jp.nextToken();
      if (_vanillaProcessing) {
        return finishBuild(ctxt, vanillaDeserialize(jp, ctxt, t));
      }
      Object builder = deserializeFromObject(jp, ctxt);
      return finishBuild(ctxt, builder);
    }
    switch (t)
    {
    case VALUE_STRING: 
      return finishBuild(ctxt, deserializeFromString(jp, ctxt));
    case VALUE_NUMBER_INT: 
      return finishBuild(ctxt, deserializeFromNumber(jp, ctxt));
    case VALUE_NUMBER_FLOAT: 
      return finishBuild(ctxt, deserializeFromDouble(jp, ctxt));
    case VALUE_EMBEDDED_OBJECT: 
      return jp.getEmbeddedObject();
    case VALUE_TRUE: 
    case VALUE_FALSE: 
      return finishBuild(ctxt, deserializeFromBoolean(jp, ctxt));
    case START_ARRAY: 
      return finishBuild(ctxt, deserializeFromArray(jp, ctxt));
    case FIELD_NAME: 
    case END_OBJECT: 
      return finishBuild(ctxt, deserializeFromObject(jp, ctxt));
    }
    throw ctxt.mappingException(handledType());
  }
  
  public Object deserialize(JsonParser jp, DeserializationContext ctxt, Object builder)
    throws IOException, JsonProcessingException
  {
    return finishBuild(ctxt, _deserialize(jp, ctxt, builder));
  }
  
  protected final Object _deserialize(JsonParser jp, DeserializationContext ctxt, Object builder)
    throws IOException, JsonProcessingException
  {
    if (_injectables != null) {
      injectValues(ctxt, builder);
    }
    if (_unwrappedPropertyHandler != null) {
      return deserializeWithUnwrapped(jp, ctxt, builder);
    }
    if (_externalTypeIdHandler != null) {
      return deserializeWithExternalTypeId(jp, ctxt, builder);
    }
    if (_needViewProcesing)
    {
      Class<?> view = ctxt.getActiveView();
      if (view != null) {
        return deserializeWithView(jp, ctxt, builder, view);
      }
    }
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_OBJECT) {}
    for (t = jp.nextToken(); t == JsonToken.FIELD_NAME; t = jp.nextToken())
    {
      String propName = jp.getCurrentName();
      
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null) {
        try
        {
          builder = prop.deserializeSetAndReturn(jp, ctxt, builder);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, builder, propName, ctxt);
        }
      } else {
        handleUnknownVanilla(jp, ctxt, handledType(), propName);
      }
    }
    return builder;
  }
  
  private final Object vanillaDeserialize(JsonParser jp, DeserializationContext ctxt, JsonToken t)
    throws IOException, JsonProcessingException
  {
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken())
    {
      String propName = jp.getCurrentName();
      
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null) {
        try
        {
          bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, propName, ctxt);
        }
      } else {
        handleUnknownVanilla(jp, ctxt, bean, propName);
      }
    }
    return bean;
  }
  
  public Object deserializeFromObject(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (_nonStandardCreation)
    {
      if (_unwrappedPropertyHandler != null) {
        return deserializeWithUnwrapped(jp, ctxt);
      }
      if (_externalTypeIdHandler != null) {
        return deserializeWithExternalTypeId(jp, ctxt);
      }
      return deserializeFromObjectUsingNonDefault(jp, ctxt);
    }
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    if (_needViewProcesing)
    {
      Class<?> view = ctxt.getActiveView();
      if (view != null) {
        return deserializeWithView(jp, ctxt, bean, view);
      }
    }
    for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken())
    {
      String propName = jp.getCurrentName();
      
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null) {
        try
        {
          bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
        }
        catch (Exception e)
        {
          wrapAndThrow(e, bean, propName, ctxt);
        }
      } else {
        handleUnknownVanilla(jp, ctxt, bean, propName);
      }
    }
    return bean;
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    PropertyBasedCreator creator = _propertyBasedCreator;
    PropertyValueBuffer buffer = creator.startBuilding(jp, ctxt, _objectIdReader);
    
    TokenBuffer unknown = null;
    for (JsonToken t = jp.getCurrentToken(); t == JsonToken.FIELD_NAME; t = jp.nextToken())
    {
      String propName = jp.getCurrentName();
      jp.nextToken();
      
      SettableBeanProperty creatorProp = creator.findCreatorProperty(propName);
      if (creatorProp != null)
      {
        if (buffer.assignParameter(creatorProp, creatorProp.deserialize(jp, ctxt)))
        {
          jp.nextToken();
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
          if (bean.getClass() != _beanType.getRawClass()) {
            return handlePolymorphic(jp, ctxt, bean, unknown);
          }
          if (unknown != null) {
            bean = handleUnknownProperties(ctxt, bean, unknown);
          }
          return _deserialize(jp, ctxt, bean);
        }
      }
      else if (!buffer.readIdProperty(propName))
      {
        SettableBeanProperty prop = _beanProperties.find(propName);
        if (prop != null)
        {
          buffer.bufferProperty(prop, prop.deserialize(jp, ctxt));
        }
        else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
        {
          handleIgnoredProperty(jp, ctxt, handledType(), propName);
        }
        else if (_anySetter != null)
        {
          buffer.bufferAnyProperty(_anySetter, propName, _anySetter.deserialize(jp, ctxt));
        }
        else
        {
          if (unknown == null) {
            unknown = new TokenBuffer(jp, ctxt);
          }
          unknown.writeFieldName(propName);
          unknown.copyCurrentStructure(jp);
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
    if (unknown != null)
    {
      if (bean.getClass() != _beanType.getRawClass()) {
        return handlePolymorphic(null, ctxt, bean, unknown);
      }
      return handleUnknownProperties(ctxt, bean, unknown);
    }
    return bean;
  }
  
  protected final Object deserializeWithView(JsonParser jp, DeserializationContext ctxt, Object bean, Class<?> activeView)
    throws IOException, JsonProcessingException
  {
    for (JsonToken t = jp.getCurrentToken(); t == JsonToken.FIELD_NAME; t = jp.nextToken())
    {
      String propName = jp.getCurrentName();
      
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null)
      {
        if (!prop.visibleInView(activeView)) {
          jp.skipChildren();
        } else {
          try
          {
            bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else {
        handleUnknownVanilla(jp, ctxt, bean, propName);
      }
    }
    return bean;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (_delegateDeserializer != null) {
      return _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt));
    }
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithUnwrapped(jp, ctxt);
    }
    TokenBuffer tokens = new TokenBuffer(jp, ctxt);
    tokens.writeStartObject();
    Object bean = _valueInstantiator.createUsingDefault(ctxt);
    if (_injectables != null) {
      injectValues(ctxt, bean);
    }
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken())
    {
      String propName = jp.getCurrentName();
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null)
      {
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          jp.skipChildren();
        } else {
          try
          {
            bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        handleIgnoredProperty(jp, ctxt, bean, propName);
      }
      else
      {
        tokens.writeFieldName(propName);
        tokens.copyCurrentStructure(jp);
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(jp, ctxt, bean, propName);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
    }
    tokens.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(jp, ctxt, bean, tokens);
    return bean;
  }
  
  protected Object deserializeWithUnwrapped(JsonParser jp, DeserializationContext ctxt, Object bean)
    throws IOException, JsonProcessingException
  {
    JsonToken t = jp.getCurrentToken();
    if (t == JsonToken.START_OBJECT) {
      t = jp.nextToken();
    }
    TokenBuffer tokens = new TokenBuffer(jp, ctxt);
    tokens.writeStartObject();
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    for (; t == JsonToken.FIELD_NAME; t = jp.nextToken())
    {
      String propName = jp.getCurrentName();
      SettableBeanProperty prop = _beanProperties.find(propName);
      jp.nextToken();
      if (prop != null)
      {
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          jp.skipChildren();
        } else {
          try
          {
            bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName)))
      {
        handleIgnoredProperty(jp, ctxt, bean, propName);
      }
      else
      {
        tokens.writeFieldName(propName);
        tokens.copyCurrentStructure(jp);
        if (_anySetter != null) {
          _anySetter.deserializeAndSet(jp, ctxt, bean, propName);
        }
      }
    }
    tokens.writeEndObject();
    _unwrappedPropertyHandler.processUnwrapped(jp, ctxt, bean, tokens);
    return bean;
  }
  
  protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser p, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
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
        if (buffer.assignParameter(creatorProp, creatorProp.deserialize(p, ctxt)))
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
          tokens.writeEndObject();
          if (bean.getClass() != _beanType.getRawClass()) {
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
          buffer.bufferProperty(prop, prop.deserialize(p, ctxt));
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
            buffer.bufferAnyProperty(_anySetter, propName, _anySetter.deserialize(p, ctxt));
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
  
  protected Object deserializeWithExternalTypeId(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (_propertyBasedCreator != null) {
      return deserializeUsingPropertyBasedWithExternalTypeId(jp, ctxt);
    }
    return deserializeWithExternalTypeId(jp, ctxt, _valueInstantiator.createUsingDefault(ctxt));
  }
  
  protected Object deserializeWithExternalTypeId(JsonParser jp, DeserializationContext ctxt, Object bean)
    throws IOException, JsonProcessingException
  {
    Class<?> activeView = _needViewProcesing ? ctxt.getActiveView() : null;
    ExternalTypeHandler ext = _externalTypeIdHandler.start();
    for (; jp.getCurrentToken() != JsonToken.END_OBJECT; jp.nextToken())
    {
      String propName = jp.getCurrentName();
      jp.nextToken();
      SettableBeanProperty prop = _beanProperties.find(propName);
      if (prop != null)
      {
        if ((activeView != null) && (!prop.visibleInView(activeView))) {
          jp.skipChildren();
        } else {
          try
          {
            bean = prop.deserializeSetAndReturn(jp, ctxt, bean);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        }
      }
      else if ((_ignorableProps != null) && (_ignorableProps.contains(propName))) {
        handleIgnoredProperty(jp, ctxt, bean, propName);
      } else if (!ext.handlePropertyValue(jp, ctxt, propName, bean)) {
        if (_anySetter != null) {
          try
          {
            _anySetter.deserializeAndSet(jp, ctxt, bean, propName);
          }
          catch (Exception e)
          {
            wrapAndThrow(e, bean, propName, ctxt);
          }
        } else {
          handleUnknownProperty(jp, ctxt, bean, propName);
        }
      }
    }
    return ext.complete(jp, ctxt, bean);
  }
  
  protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    throw new IllegalStateException("Deserialization with Builder, External type id, @JsonCreator not yet implemented");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */