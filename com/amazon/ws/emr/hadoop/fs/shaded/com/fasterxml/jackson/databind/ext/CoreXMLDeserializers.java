package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLDeserializers
  extends Deserializers.Base
{
  static final DatatypeFactory _dataTypeFactory;
  protected static final int TYPE_DURATION = 1;
  protected static final int TYPE_G_CALENDAR = 2;
  protected static final int TYPE_QNAME = 3;
  
  static
  {
    try
    {
      _dataTypeFactory = DatatypeFactory.newInstance();
    }
    catch (DatatypeConfigurationException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc)
  {
    Class<?> raw = type.getRawClass();
    if (raw == QName.class) {
      return new Std(raw, 3);
    }
    if (raw == XMLGregorianCalendar.class) {
      return new Std(raw, 2);
    }
    if (raw == Duration.class) {
      return new Std(raw, 1);
    }
    return null;
  }
  
  public static class Std
    extends FromStringDeserializer<Object>
  {
    private static final long serialVersionUID = 1L;
    protected final int _kind;
    
    public Std(Class<?> raw, int kind)
    {
      super();
      _kind = kind;
    }
    
    public Object deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JsonProcessingException
    {
      if (_kind == 2)
      {
        Date d = _parseDate(jp, ctxt);
        if (d == null) {
          return null;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        TimeZone tz = ctxt.getTimeZone();
        if (tz != null) {
          calendar.setTimeZone(tz);
        }
        return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(calendar);
      }
      return super.deserialize(jp, ctxt);
    }
    
    protected Object _deserialize(String value, DeserializationContext ctxt)
      throws IllegalArgumentException
    {
      switch (_kind)
      {
      case 1: 
        return CoreXMLDeserializers._dataTypeFactory.newDuration(value);
      case 3: 
        return QName.valueOf(value);
      }
      throw new IllegalStateException();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.CoreXMLDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */