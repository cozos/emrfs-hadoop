package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;

public abstract class NumberDeserializers$PrimitiveOrWrapperDeserializer<T>
  extends StdScalarDeserializer<T>
{
  private static final long serialVersionUID = 1L;
  protected final T _nullValue;
  protected final boolean _primitive;
  
  protected NumberDeserializers$PrimitiveOrWrapperDeserializer(Class<T> vc, T nvl)
  {
    super(vc);
    _nullValue = nvl;
    _primitive = vc.isPrimitive();
  }
  
  public final T getNullValue(DeserializationContext ctxt)
    throws JsonMappingException
  {
    if ((_primitive) && (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw ctxt.mappingException("Can not map JSON null into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[] { handledType().toString() });
    }
    return (T)_nullValue;
  }
  
  @Deprecated
  public final T getNullValue()
  {
    return (T)_nullValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */