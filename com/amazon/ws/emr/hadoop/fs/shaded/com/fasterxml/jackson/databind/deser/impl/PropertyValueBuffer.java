package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.BitSet;

public class PropertyValueBuffer
{
  protected final JsonParser _parser;
  protected final DeserializationContext _context;
  protected final ObjectIdReader _objectIdReader;
  protected final Object[] _creatorParameters;
  protected int _paramsNeeded;
  protected int _paramsSeen;
  protected final BitSet _paramsSeenBig;
  protected PropertyValue _buffered;
  protected Object _idValue;
  
  public PropertyValueBuffer(JsonParser jp, DeserializationContext ctxt, int paramCount, ObjectIdReader oir)
  {
    _parser = jp;
    _context = ctxt;
    _paramsNeeded = paramCount;
    _objectIdReader = oir;
    _creatorParameters = new Object[paramCount];
    if (paramCount < 32) {
      _paramsSeenBig = null;
    } else {
      _paramsSeenBig = new BitSet();
    }
  }
  
  protected Object[] getParameters(SettableBeanProperty[] props)
    throws JsonMappingException
  {
    if (_paramsNeeded > 0) {
      if (_paramsSeenBig == null)
      {
        int mask = _paramsSeen;
        
        int ix = 0;
        for (int len = _creatorParameters.length; ix < len; mask >>= 1)
        {
          if ((mask & 0x1) == 0) {
            _creatorParameters[ix] = _findMissing(props[ix]);
          }
          ix++;
        }
      }
      else
      {
        int len = _creatorParameters.length;
        for (int ix = 0; (ix = _paramsSeenBig.nextClearBit(ix)) < len; ix++) {
          _creatorParameters[ix] = _findMissing(props[ix]);
        }
      }
    }
    return _creatorParameters;
  }
  
  protected Object _findMissing(SettableBeanProperty prop)
    throws JsonMappingException
  {
    Object injectableValueId = prop.getInjectableValueId();
    if (injectableValueId != null) {
      return _context.findInjectableValue(prop.getInjectableValueId(), prop, null);
    }
    if (prop.isRequired()) {
      throw _context.mappingException("Missing required creator property '%s' (index %d)", new Object[] { prop.getName(), Integer.valueOf(prop.getCreatorIndex()) });
    }
    if (_context.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
      throw _context.mappingException("Missing creator property '%s' (index %d); DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES enabled", new Object[] { prop.getName(), Integer.valueOf(prop.getCreatorIndex()) });
    }
    JsonDeserializer<Object> deser = prop.getValueDeserializer();
    return deser.getNullValue(_context);
  }
  
  public boolean readIdProperty(String propName)
    throws IOException
  {
    if ((_objectIdReader != null) && (propName.equals(_objectIdReader.propertyName.getSimpleName())))
    {
      _idValue = _objectIdReader.readObjectReference(_parser, _context);
      return true;
    }
    return false;
  }
  
  public Object handleIdValue(DeserializationContext ctxt, Object bean)
    throws IOException
  {
    if (_objectIdReader != null) {
      if (_idValue != null)
      {
        ReadableObjectId roid = ctxt.findObjectId(_idValue, _objectIdReader.generator, _objectIdReader.resolver);
        roid.bindItem(bean);
        
        SettableBeanProperty idProp = _objectIdReader.idProperty;
        if (idProp != null) {
          return idProp.setAndReturn(bean, _idValue);
        }
      }
      else
      {
        throw ctxt.mappingException("No _idValue when handleIdValue called, on instance of %s", new Object[] { bean.getClass().getName() });
      }
    }
    return bean;
  }
  
  protected PropertyValue buffered()
  {
    return _buffered;
  }
  
  public boolean isComplete()
  {
    return _paramsNeeded <= 0;
  }
  
  public boolean assignParameter(SettableBeanProperty prop, Object value)
  {
    int ix = prop.getCreatorIndex();
    _creatorParameters[ix] = value;
    if (_paramsSeenBig == null)
    {
      int old = _paramsSeen;
      int newValue = old | 1 << ix;
      if (old != newValue)
      {
        _paramsSeen = newValue;
        if (--_paramsNeeded <= 0) {
          return true;
        }
      }
    }
    else if (!_paramsSeenBig.get(ix))
    {
      if (--_paramsNeeded <= 0) {
        return true;
      }
      _paramsSeenBig.set(ix);
    }
    return false;
  }
  
  @Deprecated
  public boolean assignParameter(int index, Object value)
  {
    _creatorParameters[index] = value;
    return false;
  }
  
  public void bufferProperty(SettableBeanProperty prop, Object value)
  {
    _buffered = new PropertyValue.Regular(_buffered, value, prop);
  }
  
  public void bufferAnyProperty(SettableAnyProperty prop, String propName, Object value)
  {
    _buffered = new PropertyValue.Any(_buffered, value, prop, propName);
  }
  
  public void bufferMapProperty(Object key, Object value)
  {
    _buffered = new PropertyValue.Map(_buffered, value, key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */