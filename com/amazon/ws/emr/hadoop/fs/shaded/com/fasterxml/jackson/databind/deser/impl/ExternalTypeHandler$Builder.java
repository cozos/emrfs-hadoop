package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler$Builder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */