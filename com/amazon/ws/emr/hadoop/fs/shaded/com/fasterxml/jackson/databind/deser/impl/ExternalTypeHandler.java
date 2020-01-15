package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler
{
  private final ExtTypedProperty[] _properties;
  private final HashMap<String, Integer> _nameToPropertyIndex;
  private final String[] _typeIds;
  private final TokenBuffer[] _tokens;
  
  protected ExternalTypeHandler(ExtTypedProperty[] properties, HashMap<String, Integer> nameToPropertyIndex, String[] typeIds, TokenBuffer[] tokens)
  {
    _properties = properties;
    _nameToPropertyIndex = nameToPropertyIndex;
    _typeIds = typeIds;
    _tokens = tokens;
  }
  
  protected ExternalTypeHandler(ExternalTypeHandler h)
  {
    _properties = _properties;
    _nameToPropertyIndex = _nameToPropertyIndex;
    int len = _properties.length;
    _typeIds = new String[len];
    _tokens = new TokenBuffer[len];
  }
  
  public ExternalTypeHandler start()
  {
    return new ExternalTypeHandler(this);
  }
  
  public boolean handleTypePropertyValue(JsonParser jp, DeserializationContext ctxt, String propName, Object bean)
    throws IOException
  {
    Integer I = (Integer)_nameToPropertyIndex.get(propName);
    if (I == null) {
      return false;
    }
    int index = I.intValue();
    ExtTypedProperty prop = _properties[index];
    if (!prop.hasTypePropertyName(propName)) {
      return false;
    }
    String typeId = jp.getText();
    
    boolean canDeserialize = (bean != null) && (_tokens[index] != null);
    if (canDeserialize)
    {
      _deserializeAndSet(jp, ctxt, bean, index, typeId);
      
      _tokens[index] = null;
    }
    else
    {
      _typeIds[index] = typeId;
    }
    return true;
  }
  
  public boolean handlePropertyValue(JsonParser p, DeserializationContext ctxt, String propName, Object bean)
    throws IOException
  {
    Integer I = (Integer)_nameToPropertyIndex.get(propName);
    if (I == null) {
      return false;
    }
    int index = I.intValue();
    ExtTypedProperty prop = _properties[index];
    boolean canDeserialize;
    boolean canDeserialize;
    if (prop.hasTypePropertyName(propName))
    {
      _typeIds[index] = p.getText();
      p.skipChildren();
      canDeserialize = (bean != null) && (_tokens[index] != null);
    }
    else
    {
      TokenBuffer tokens = new TokenBuffer(p, ctxt);
      tokens.copyCurrentStructure(p);
      _tokens[index] = tokens;
      canDeserialize = (bean != null) && (_typeIds[index] != null);
    }
    if (canDeserialize)
    {
      String typeId = _typeIds[index];
      
      _typeIds[index] = null;
      _deserializeAndSet(p, ctxt, bean, index, typeId);
      _tokens[index] = null;
    }
    return true;
  }
  
  public Object complete(JsonParser p, DeserializationContext ctxt, Object bean)
    throws IOException
  {
    int i = 0;
    for (int len = _properties.length; i < len; i++)
    {
      String typeId = _typeIds[i];
      if (typeId == null)
      {
        TokenBuffer tokens = _tokens[i];
        if (tokens == null) {
          continue;
        }
        JsonToken t = tokens.firstToken();
        if ((t != null) && (t.isScalarValue()))
        {
          JsonParser buffered = tokens.asParser(p);
          buffered.nextToken();
          SettableBeanProperty extProp = _properties[i].getProperty();
          Object result = TypeDeserializer.deserializeIfNatural(buffered, ctxt, extProp.getType());
          if (result != null)
          {
            extProp.set(bean, result);
            continue;
          }
          if (!_properties[i].hasDefaultType()) {
            throw ctxt.mappingException("Missing external type id property '%s'", new Object[] { _properties[i].getTypePropertyName() });
          }
          typeId = _properties[i].getDefaultTypeId();
        }
      }
      else if (_tokens[i] == null)
      {
        SettableBeanProperty prop = _properties[i].getProperty();
        throw ctxt.mappingException("Missing property '%s' for external type id '%s'", new Object[] { prop.getName(), _properties[i].getTypePropertyName() });
      }
      _deserializeAndSet(p, ctxt, bean, i, typeId);
    }
    return bean;
  }
  
  public Object complete(JsonParser jp, DeserializationContext ctxt, PropertyValueBuffer buffer, PropertyBasedCreator creator)
    throws IOException
  {
    int len = _properties.length;
    Object[] values = new Object[len];
    for (int i = 0; i < len; i++)
    {
      String typeId = _typeIds[i];
      if (typeId == null)
      {
        if (_tokens[i] == null) {
          continue;
        }
        if (!_properties[i].hasDefaultType()) {
          throw ctxt.mappingException("Missing external type id property '%s'", new Object[] { _properties[i].getTypePropertyName() });
        }
        typeId = _properties[i].getDefaultTypeId();
      }
      else if (_tokens[i] == null)
      {
        SettableBeanProperty prop = _properties[i].getProperty();
        throw ctxt.mappingException("Missing property '%s' for external type id '%s'", new Object[] { prop.getName(), _properties[i].getTypePropertyName() });
      }
      values[i] = _deserialize(jp, ctxt, i, typeId);
    }
    for (int i = 0; i < len; i++)
    {
      SettableBeanProperty prop = _properties[i].getProperty();
      if (creator.findCreatorProperty(prop.getName()) != null) {
        buffer.assignParameter(prop, values[i]);
      }
    }
    Object bean = creator.build(ctxt, buffer);
    for (int i = 0; i < len; i++)
    {
      SettableBeanProperty prop = _properties[i].getProperty();
      if (creator.findCreatorProperty(prop.getName()) == null) {
        prop.set(bean, values[i]);
      }
    }
    return bean;
  }
  
  protected final Object _deserialize(JsonParser p, DeserializationContext ctxt, int index, String typeId)
    throws IOException
  {
    JsonParser p2 = _tokens[index].asParser(p);
    JsonToken t = p2.nextToken();
    if (t == JsonToken.VALUE_NULL) {
      return null;
    }
    TokenBuffer merged = new TokenBuffer(p, ctxt);
    merged.writeStartArray();
    merged.writeString(typeId);
    merged.copyCurrentStructure(p2);
    merged.writeEndArray();
    
    JsonParser mp = merged.asParser(p);
    mp.nextToken();
    return _properties[index].getProperty().deserialize(mp, ctxt);
  }
  
  protected final void _deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object bean, int index, String typeId)
    throws IOException
  {
    JsonParser p2 = _tokens[index].asParser(p);
    JsonToken t = p2.nextToken();
    if (t == JsonToken.VALUE_NULL)
    {
      _properties[index].getProperty().set(bean, null);
      return;
    }
    TokenBuffer merged = new TokenBuffer(p, ctxt);
    merged.writeStartArray();
    merged.writeString(typeId);
    
    merged.copyCurrentStructure(p2);
    merged.writeEndArray();
    
    JsonParser mp = merged.asParser(p);
    mp.nextToken();
    _properties[index].getProperty().deserializeAndSet(mp, ctxt, bean);
  }
  
  public static class Builder
  {
    private final ArrayList<ExternalTypeHandler.ExtTypedProperty> _properties = new ArrayList();
    private final HashMap<String, Integer> _nameToPropertyIndex = new HashMap();
    
    public void addExternal(SettableBeanProperty property, TypeDeserializer typeDeser)
    {
      Integer index = Integer.valueOf(_properties.size());
      _properties.add(new ExternalTypeHandler.ExtTypedProperty(property, typeDeser));
      _nameToPropertyIndex.put(property.getName(), index);
      _nameToPropertyIndex.put(typeDeser.getPropertyName(), index);
    }
    
    public ExternalTypeHandler build()
    {
      return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])_properties.toArray(new ExternalTypeHandler.ExtTypedProperty[_properties.size()]), _nameToPropertyIndex, null, null);
    }
  }
  
  private static final class ExtTypedProperty
  {
    private final SettableBeanProperty _property;
    private final TypeDeserializer _typeDeserializer;
    private final String _typePropertyName;
    
    public ExtTypedProperty(SettableBeanProperty property, TypeDeserializer typeDeser)
    {
      _property = property;
      _typeDeserializer = typeDeser;
      _typePropertyName = typeDeser.getPropertyName();
    }
    
    public boolean hasTypePropertyName(String n)
    {
      return n.equals(_typePropertyName);
    }
    
    public boolean hasDefaultType()
    {
      return _typeDeserializer.getDefaultImpl() != null;
    }
    
    public String getDefaultTypeId()
    {
      Class<?> defaultType = _typeDeserializer.getDefaultImpl();
      if (defaultType == null) {
        return null;
      }
      return _typeDeserializer.getTypeIdResolver().idFromValueAndType(null, defaultType);
    }
    
    public String getTypePropertyName()
    {
      return _typePropertyName;
    }
    
    public SettableBeanProperty getProperty()
    {
      return _property;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */