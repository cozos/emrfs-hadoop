package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class StdKeySerializers
{
  protected static final JsonSerializer<Object> DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
  protected static final JsonSerializer<Object> DEFAULT_STRING_SERIALIZER = new StringKeySerializer();
  
  public static JsonSerializer<Object> getStdKeySerializer(SerializationConfig config, Class<?> rawKeyType, boolean useDefault)
  {
    if ((rawKeyType == null) || (rawKeyType == Object.class)) {
      return new Dynamic();
    }
    if (rawKeyType == String.class) {
      return DEFAULT_STRING_SERIALIZER;
    }
    if ((rawKeyType.isPrimitive()) || (Number.class.isAssignableFrom(rawKeyType))) {
      return DEFAULT_KEY_SERIALIZER;
    }
    if (rawKeyType == Class.class) {
      return new Default(3, rawKeyType);
    }
    if (Date.class.isAssignableFrom(rawKeyType)) {
      return new Default(1, rawKeyType);
    }
    if (Calendar.class.isAssignableFrom(rawKeyType)) {
      return new Default(2, rawKeyType);
    }
    if (rawKeyType == UUID.class) {
      return new Default(5, rawKeyType);
    }
    return useDefault ? DEFAULT_KEY_SERIALIZER : null;
  }
  
  public static JsonSerializer<Object> getFallbackKeySerializer(SerializationConfig config, Class<?> rawKeyType)
  {
    if (rawKeyType != null)
    {
      if (rawKeyType == Enum.class) {
        return new Dynamic();
      }
      if (rawKeyType.isEnum()) {
        return new Default(4, rawKeyType);
      }
    }
    return DEFAULT_KEY_SERIALIZER;
  }
  
  @Deprecated
  public static JsonSerializer<Object> getStdKeySerializer(JavaType keyType)
  {
    return getStdKeySerializer(null, keyType.getRawClass(), true);
  }
  
  @Deprecated
  public static JsonSerializer<Object> getDefault()
  {
    return DEFAULT_KEY_SERIALIZER;
  }
  
  public static class Default
    extends StdSerializer<Object>
  {
    static final int TYPE_DATE = 1;
    static final int TYPE_CALENDAR = 2;
    static final int TYPE_CLASS = 3;
    static final int TYPE_ENUM = 4;
    static final int TYPE_TO_STRING = 5;
    protected final int _typeId;
    
    public Default(int typeId, Class<?> type)
    {
      super(false);
      _typeId = typeId;
    }
    
    public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
      throws IOException
    {
      switch (_typeId)
      {
      case 1: 
        provider.defaultSerializeDateKey((Date)value, g);
        break;
      case 2: 
        provider.defaultSerializeDateKey(((Calendar)value).getTimeInMillis(), g);
        break;
      case 3: 
        g.writeFieldName(((Class)value).getName());
        break;
      case 4: 
        String str = provider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING) ? value.toString() : ((Enum)value).name();
        
        g.writeFieldName(str);
        
        break;
      case 5: 
      default: 
        g.writeFieldName(value.toString());
      }
    }
  }
  
  public static class Dynamic
    extends StdSerializer<Object>
  {
    protected transient PropertySerializerMap _dynamicSerializers;
    
    public Dynamic()
    {
      super(false);
      _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    }
    
    Object readResolve()
    {
      _dynamicSerializers = PropertySerializerMap.emptyForProperties();
      return this;
    }
    
    public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
      throws IOException
    {
      Class<?> cls = value.getClass();
      PropertySerializerMap m = _dynamicSerializers;
      JsonSerializer<Object> ser = m.serializerFor(cls);
      if (ser == null) {
        ser = _findAndAddDynamic(m, cls, provider);
      }
      ser.serialize(value, g, provider);
    }
    
    protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap map, Class<?> type, SerializerProvider provider)
      throws JsonMappingException
    {
      PropertySerializerMap.SerializerAndMapResult result = map.findAndAddKeySerializer(type, provider, null);
      if (map != map) {
        _dynamicSerializers = map;
      }
      return serializer;
    }
  }
  
  public static class StringKeySerializer
    extends StdSerializer<Object>
  {
    public StringKeySerializer()
    {
      super(false);
    }
    
    public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
      throws IOException
    {
      g.writeFieldName((String)value);
    }
  }
  
  @Deprecated
  public static class DateKeySerializer
    extends StdSerializer<Date>
  {
    protected static final JsonSerializer<?> instance = new DateKeySerializer();
    
    public DateKeySerializer()
    {
      super();
    }
    
    public void serialize(Date value, JsonGenerator g, SerializerProvider provider)
      throws IOException
    {
      provider.defaultSerializeDateKey(value, g);
    }
  }
  
  @Deprecated
  public static class CalendarKeySerializer
    extends StdSerializer<Calendar>
  {
    protected static final JsonSerializer<?> instance = new CalendarKeySerializer();
    
    public CalendarKeySerializer()
    {
      super();
    }
    
    public void serialize(Calendar value, JsonGenerator g, SerializerProvider provider)
      throws IOException
    {
      provider.defaultSerializeDateKey(value.getTimeInMillis(), g);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */