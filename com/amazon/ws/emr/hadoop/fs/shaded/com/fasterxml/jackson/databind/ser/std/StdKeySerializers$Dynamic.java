package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;

public class StdKeySerializers$Dynamic
  extends StdSerializer<Object>
{
  protected transient PropertySerializerMap _dynamicSerializers;
  
  public StdKeySerializers$Dynamic()
  {
    super(String.class, false);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */