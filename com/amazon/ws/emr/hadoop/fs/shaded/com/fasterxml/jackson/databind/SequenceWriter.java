package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;

public class SequenceWriter
  implements Versioned, Closeable, Flushable
{
  protected final DefaultSerializerProvider _provider;
  protected final SerializationConfig _config;
  protected final JsonGenerator _generator;
  protected final JsonSerializer<Object> _rootSerializer;
  protected final TypeSerializer _typeSerializer;
  protected final boolean _closeGenerator;
  protected final boolean _cfgFlush;
  protected final boolean _cfgCloseCloseable;
  protected PropertySerializerMap _dynamicSerializers;
  protected boolean _openArray;
  protected boolean _closed;
  
  public SequenceWriter(DefaultSerializerProvider prov, JsonGenerator gen, boolean closeGenerator, ObjectWriter.Prefetch prefetch)
    throws IOException
  {
    _provider = prov;
    _generator = gen;
    _closeGenerator = closeGenerator;
    _rootSerializer = prefetch.getValueSerializer();
    _typeSerializer = prefetch.getTypeSerializer();
    
    _config = prov.getConfig();
    _cfgFlush = _config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
    _cfgCloseCloseable = _config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE);
    
    _dynamicSerializers = PropertySerializerMap.emptyForRootValues();
  }
  
  public SequenceWriter init(boolean wrapInArray)
    throws IOException
  {
    if (wrapInArray)
    {
      _generator.writeStartArray();
      _openArray = true;
    }
    return this;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public SequenceWriter write(Object value)
    throws IOException
  {
    if (value == null)
    {
      _provider.serializeValue(_generator, null);
      return this;
    }
    if ((_cfgCloseCloseable) && ((value instanceof Closeable))) {
      return _writeCloseableValue(value);
    }
    JsonSerializer<Object> ser = _rootSerializer;
    if (ser == null)
    {
      Class<?> type = value.getClass();
      ser = _dynamicSerializers.serializerFor(type);
      if (ser == null) {
        ser = _findAndAddDynamic(type);
      }
    }
    _provider.serializeValue(_generator, value, null, ser);
    if (_cfgFlush) {
      _generator.flush();
    }
    return this;
  }
  
  public SequenceWriter write(Object value, JavaType type)
    throws IOException
  {
    if (value == null)
    {
      _provider.serializeValue(_generator, null);
      return this;
    }
    if ((_cfgCloseCloseable) && ((value instanceof Closeable))) {
      return _writeCloseableValue(value, type);
    }
    JsonSerializer<Object> ser = _dynamicSerializers.serializerFor(type.getRawClass());
    if (ser == null) {
      ser = _findAndAddDynamic(type);
    }
    _provider.serializeValue(_generator, value, type, ser);
    if (_cfgFlush) {
      _generator.flush();
    }
    return this;
  }
  
  public SequenceWriter writeAll(Object[] value)
    throws IOException
  {
    int i = 0;
    for (int len = value.length; i < len; i++) {
      write(value[i]);
    }
    return this;
  }
  
  public <C extends Collection<?>> SequenceWriter writeAll(C container)
    throws IOException
  {
    for (Object value : container) {
      write(value);
    }
    return this;
  }
  
  public void flush()
    throws IOException
  {
    if (!_closed) {
      _generator.flush();
    }
  }
  
  public void close()
    throws IOException
  {
    if (!_closed)
    {
      _closed = true;
      if (_openArray)
      {
        _openArray = false;
        _generator.writeEndArray();
      }
      if (_closeGenerator) {
        _generator.close();
      }
    }
  }
  
  protected SequenceWriter _writeCloseableValue(Object value)
    throws IOException
  {
    Closeable toClose = (Closeable)value;
    try
    {
      JsonSerializer<Object> ser = _rootSerializer;
      if (ser == null)
      {
        Class<?> type = value.getClass();
        ser = _dynamicSerializers.serializerFor(type);
        if (ser == null) {
          ser = _findAndAddDynamic(type);
        }
      }
      _provider.serializeValue(_generator, value, null, ser);
      if (_cfgFlush) {
        _generator.flush();
      }
      Closeable tmpToClose = toClose;
      toClose = null;
      tmpToClose.close();
      
      return this;
    }
    finally
    {
      if (toClose != null) {
        try
        {
          toClose.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  protected SequenceWriter _writeCloseableValue(Object value, JavaType type)
    throws IOException
  {
    Closeable toClose = (Closeable)value;
    try
    {
      JsonSerializer<Object> ser = _dynamicSerializers.serializerFor(type.getRawClass());
      if (ser == null) {
        ser = _findAndAddDynamic(type);
      }
      _provider.serializeValue(_generator, value, type, ser);
      if (_cfgFlush) {
        _generator.flush();
      }
      Closeable tmpToClose = toClose;
      toClose = null;
      tmpToClose.close();
      
      return this;
    }
    finally
    {
      if (toClose != null) {
        try
        {
          toClose.close();
        }
        catch (IOException ioe) {}
      }
    }
  }
  
  private final JsonSerializer<Object> _findAndAddDynamic(Class<?> type)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result;
    PropertySerializerMap.SerializerAndMapResult result;
    if (_typeSerializer == null) {
      result = _dynamicSerializers.findAndAddRootValueSerializer(type, _provider);
    } else {
      result = _dynamicSerializers.addSerializer(type, new TypeWrappedSerializer(_typeSerializer, _provider.findValueSerializer(type, null)));
    }
    _dynamicSerializers = map;
    return serializer;
  }
  
  private final JsonSerializer<Object> _findAndAddDynamic(JavaType type)
    throws JsonMappingException
  {
    PropertySerializerMap.SerializerAndMapResult result;
    PropertySerializerMap.SerializerAndMapResult result;
    if (_typeSerializer == null) {
      result = _dynamicSerializers.findAndAddRootValueSerializer(type, _provider);
    } else {
      result = _dynamicSerializers.addSerializer(type, new TypeWrappedSerializer(_typeSerializer, _provider.findValueSerializer(type, null)));
    }
    _dynamicSerializers = map;
    return serializer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SequenceWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */