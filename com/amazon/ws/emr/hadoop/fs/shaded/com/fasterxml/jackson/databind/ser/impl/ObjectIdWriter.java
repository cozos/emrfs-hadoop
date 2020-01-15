package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;

public final class ObjectIdWriter
{
  public final JavaType idType;
  public final SerializableString propertyName;
  public final ObjectIdGenerator<?> generator;
  public final JsonSerializer<Object> serializer;
  public final boolean alwaysAsId;
  
  protected ObjectIdWriter(JavaType t, SerializableString propName, ObjectIdGenerator<?> gen, JsonSerializer<?> ser, boolean alwaysAsId)
  {
    idType = t;
    propertyName = propName;
    generator = gen;
    serializer = ser;
    this.alwaysAsId = alwaysAsId;
  }
  
  public static ObjectIdWriter construct(JavaType idType, PropertyName propName, ObjectIdGenerator<?> generator, boolean alwaysAsId)
  {
    String simpleName = propName == null ? null : propName.getSimpleName();
    return construct(idType, simpleName, generator, alwaysAsId);
  }
  
  @Deprecated
  public static ObjectIdWriter construct(JavaType idType, String propName, ObjectIdGenerator<?> generator, boolean alwaysAsId)
  {
    SerializableString serName = propName == null ? null : new SerializedString(propName);
    return new ObjectIdWriter(idType, serName, generator, null, alwaysAsId);
  }
  
  public ObjectIdWriter withSerializer(JsonSerializer<?> ser)
  {
    return new ObjectIdWriter(idType, propertyName, generator, ser, alwaysAsId);
  }
  
  public ObjectIdWriter withAlwaysAsId(boolean newState)
  {
    if (newState == alwaysAsId) {
      return this;
    }
    return new ObjectIdWriter(idType, propertyName, generator, serializer, newState);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */