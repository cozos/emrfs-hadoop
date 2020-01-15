package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

final class ExternalTypeHandler$ExtTypedProperty
{
  private final SettableBeanProperty _property;
  private final TypeDeserializer _typeDeserializer;
  private final String _typePropertyName;
  
  public ExternalTypeHandler$ExtTypedProperty(SettableBeanProperty property, TypeDeserializer typeDeser)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.ExtTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */