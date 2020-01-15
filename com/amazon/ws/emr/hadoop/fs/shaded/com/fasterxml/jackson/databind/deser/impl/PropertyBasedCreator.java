package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class PropertyBasedCreator
{
  protected final ValueInstantiator _valueInstantiator;
  protected final HashMap<String, SettableBeanProperty> _propertyLookup;
  protected final int _propertyCount;
  protected final SettableBeanProperty[] _allProperties;
  
  protected PropertyBasedCreator(ValueInstantiator valueInstantiator, SettableBeanProperty[] creatorProps)
  {
    _valueInstantiator = valueInstantiator;
    _propertyLookup = new HashMap();
    int len = creatorProps.length;
    _propertyCount = len;
    _allProperties = new SettableBeanProperty[len];
    for (int i = 0; i < len; i++)
    {
      SettableBeanProperty prop = creatorProps[i];
      _allProperties[i] = prop;
      _propertyLookup.put(prop.getName(), prop);
    }
  }
  
  public static PropertyBasedCreator construct(DeserializationContext ctxt, ValueInstantiator valueInstantiator, SettableBeanProperty[] srcProps)
    throws JsonMappingException
  {
    int len = srcProps.length;
    SettableBeanProperty[] creatorProps = new SettableBeanProperty[len];
    for (int i = 0; i < len; i++)
    {
      SettableBeanProperty prop = srcProps[i];
      if (!prop.hasValueDeserializer()) {
        prop = prop.withValueDeserializer(ctxt.findContextualValueDeserializer(prop.getType(), prop));
      }
      creatorProps[i] = prop;
    }
    return new PropertyBasedCreator(valueInstantiator, creatorProps);
  }
  
  public Collection<SettableBeanProperty> properties()
  {
    return _propertyLookup.values();
  }
  
  public SettableBeanProperty findCreatorProperty(String name)
  {
    return (SettableBeanProperty)_propertyLookup.get(name);
  }
  
  public SettableBeanProperty findCreatorProperty(int propertyIndex)
  {
    for (SettableBeanProperty prop : _propertyLookup.values()) {
      if (prop.getPropertyIndex() == propertyIndex) {
        return prop;
      }
    }
    return null;
  }
  
  public PropertyValueBuffer startBuilding(JsonParser p, DeserializationContext ctxt, ObjectIdReader oir)
  {
    return new PropertyValueBuffer(p, ctxt, _propertyCount, oir);
  }
  
  public Object build(DeserializationContext ctxt, PropertyValueBuffer buffer)
    throws IOException
  {
    Object bean = _valueInstantiator.createFromObjectWith(ctxt, buffer.getParameters(_allProperties));
    if (bean != null)
    {
      bean = buffer.handleIdValue(ctxt, bean);
      for (PropertyValue pv = buffer.buffered(); pv != null; pv = next) {
        pv.assign(bean);
      }
    }
    return bean;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */