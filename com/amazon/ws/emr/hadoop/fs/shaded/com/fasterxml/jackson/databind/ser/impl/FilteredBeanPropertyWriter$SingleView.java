package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

final class FilteredBeanPropertyWriter$SingleView
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final BeanPropertyWriter _delegate;
  protected final Class<?> _view;
  
  protected FilteredBeanPropertyWriter$SingleView(BeanPropertyWriter delegate, Class<?> view)
  {
    super(delegate);
    _delegate = delegate;
    _view = view;
  }
  
  public SingleView rename(NameTransformer transformer)
  {
    return new SingleView(_delegate.rename(transformer), _view);
  }
  
  public void assignSerializer(JsonSerializer<Object> ser)
  {
    _delegate.assignSerializer(ser);
  }
  
  public void assignNullSerializer(JsonSerializer<Object> nullSer)
  {
    _delegate.assignNullSerializer(nullSer);
  }
  
  public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider prov)
    throws Exception
  {
    Class<?> activeView = prov.getActiveView();
    if ((activeView == null) || (_view.isAssignableFrom(activeView))) {
      _delegate.serializeAsField(bean, jgen, prov);
    } else {
      _delegate.serializeAsOmittedField(bean, jgen, prov);
    }
  }
  
  public void serializeAsElement(Object bean, JsonGenerator jgen, SerializerProvider prov)
    throws Exception
  {
    Class<?> activeView = prov.getActiveView();
    if ((activeView == null) || (_view.isAssignableFrom(activeView))) {
      _delegate.serializeAsElement(bean, jgen, prov);
    } else {
      _delegate.serializeAsPlaceholder(bean, jgen, prov);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter.SingleView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */