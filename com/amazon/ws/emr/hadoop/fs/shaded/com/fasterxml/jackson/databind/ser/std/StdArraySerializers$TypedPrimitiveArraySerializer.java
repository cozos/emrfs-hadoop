package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class StdArraySerializers$TypedPrimitiveArraySerializer<T>
  extends ArraySerializerBase<T>
{
  protected final TypeSerializer _valueTypeSerializer;
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(Class<T> cls)
  {
    super(cls);
    _valueTypeSerializer = null;
  }
  
  protected StdArraySerializers$TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
  {
    super(src, prop, unwrapSingle);
    _valueTypeSerializer = vts;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers.TypedPrimitiveArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */