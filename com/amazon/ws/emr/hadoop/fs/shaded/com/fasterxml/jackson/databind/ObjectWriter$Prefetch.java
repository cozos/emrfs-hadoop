package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import java.io.IOException;
import java.io.Serializable;

public final class ObjectWriter$Prefetch
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final Prefetch empty = new Prefetch(null, null, null);
  private final JavaType rootType;
  private final JsonSerializer<Object> valueSerializer;
  private final TypeSerializer typeSerializer;
  
  private ObjectWriter$Prefetch(JavaType rootT, JsonSerializer<Object> ser, TypeSerializer typeSer)
  {
    rootType = rootT;
    valueSerializer = ser;
    typeSerializer = typeSer;
  }
  
  public Prefetch forRootType(ObjectWriter parent, JavaType newType)
  {
    boolean noType = (newType == null) || (newType.isJavaLangObject());
    if (noType)
    {
      if ((rootType == null) || (valueSerializer == null)) {
        return this;
      }
      return new Prefetch(null, null, typeSerializer);
    }
    if (newType.equals(rootType)) {
      return this;
    }
    if (parent.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH))
    {
      DefaultSerializerProvider prov = parent._serializerProvider();
      try
      {
        JsonSerializer<Object> ser = prov.findTypedValueSerializer(newType, true, null);
        if ((ser instanceof TypeWrappedSerializer)) {
          return new Prefetch(newType, null, ((TypeWrappedSerializer)ser).typeSerializer());
        }
        return new Prefetch(newType, ser, null);
      }
      catch (JsonProcessingException e) {}
    }
    return new Prefetch(null, null, typeSerializer);
  }
  
  public final JsonSerializer<Object> getValueSerializer()
  {
    return valueSerializer;
  }
  
  public final TypeSerializer getTypeSerializer()
  {
    return typeSerializer;
  }
  
  public boolean hasSerializer()
  {
    return (valueSerializer != null) || (typeSerializer != null);
  }
  
  public void serialize(JsonGenerator gen, Object value, DefaultSerializerProvider prov)
    throws IOException
  {
    if (typeSerializer != null)
    {
      prov.serializePolymorphic(gen, value, rootType, valueSerializer, typeSerializer);
      return;
    }
    if (valueSerializer != null)
    {
      prov.serializeValue(gen, value, rootType, valueSerializer);
      return;
    }
    prov.serializeValue(gen, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter.Prefetch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */