package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class RawValue
  implements JsonSerializable
{
  protected Object _value;
  
  public RawValue(String v)
  {
    _value = v;
  }
  
  public RawValue(SerializableString v)
  {
    _value = v;
  }
  
  public RawValue(JsonSerializable v)
  {
    _value = v;
  }
  
  protected RawValue(Object value, boolean bogus)
  {
    _value = value;
  }
  
  public Object rawValue()
  {
    return _value;
  }
  
  public void serialize(JsonGenerator gen, SerializerProvider serializers)
    throws IOException
  {
    if ((_value instanceof JsonSerializable)) {
      ((JsonSerializable)_value).serialize(gen, serializers);
    } else {
      _serialize(gen);
    }
  }
  
  public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer)
    throws IOException
  {
    if ((_value instanceof JsonSerializable)) {
      ((JsonSerializable)_value).serializeWithType(gen, serializers, typeSer);
    } else if ((_value instanceof SerializableString)) {
      serialize(gen, serializers);
    }
  }
  
  public void serialize(JsonGenerator gen)
    throws IOException
  {
    if ((_value instanceof JsonSerializable)) {
      gen.writeObject(_value);
    } else {
      _serialize(gen);
    }
  }
  
  protected void _serialize(JsonGenerator gen)
    throws IOException
  {
    if ((_value instanceof SerializableString)) {
      gen.writeRawValue((SerializableString)_value);
    } else {
      gen.writeRawValue(String.valueOf(_value));
    }
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof RawValue)) {
      return false;
    }
    RawValue other = (RawValue)o;
    if (_value == _value) {
      return true;
    }
    return (_value != null) && (_value.equals(_value));
  }
  
  public int hashCode()
  {
    return _value == null ? 0 : _value.hashCode();
  }
  
  public String toString()
  {
    return String.format("[RawValue of type %s]", new Object[] { _value == null ? "NULL" : _value.getClass().getName() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.RawValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */