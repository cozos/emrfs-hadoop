package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnwrappedPropertyHandler
{
  protected final List<SettableBeanProperty> _properties;
  
  public UnwrappedPropertyHandler()
  {
    _properties = new ArrayList();
  }
  
  protected UnwrappedPropertyHandler(List<SettableBeanProperty> props)
  {
    _properties = props;
  }
  
  public void addProperty(SettableBeanProperty property)
  {
    _properties.add(property);
  }
  
  public UnwrappedPropertyHandler renameAll(NameTransformer transformer)
  {
    ArrayList<SettableBeanProperty> newProps = new ArrayList(_properties.size());
    for (SettableBeanProperty prop : _properties)
    {
      String newName = transformer.transform(prop.getName());
      prop = prop.withSimpleName(newName);
      JsonDeserializer<?> deser = prop.getValueDeserializer();
      if (deser != null)
      {
        JsonDeserializer<Object> newDeser = deser.unwrappingDeserializer(transformer);
        if (newDeser != deser) {
          prop = prop.withValueDeserializer(newDeser);
        }
      }
      newProps.add(prop);
    }
    return new UnwrappedPropertyHandler(newProps);
  }
  
  public Object processUnwrapped(JsonParser originalParser, DeserializationContext ctxt, Object bean, TokenBuffer buffered)
    throws IOException, JsonProcessingException
  {
    int i = 0;
    for (int len = _properties.size(); i < len; i++)
    {
      SettableBeanProperty prop = (SettableBeanProperty)_properties.get(i);
      JsonParser jp = buffered.asParser();
      jp.nextToken();
      prop.deserializeAndSet(jp, ctxt, bean);
    }
    return bean;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */