package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;

@Deprecated
public final class NullProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Object _nullValue;
  private final boolean _isPrimitive;
  private final Class<?> _rawType;
  
  public NullProvider(JavaType type, Object nullValue)
  {
    _nullValue = nullValue;
    _isPrimitive = type.isPrimitive();
    _rawType = type.getRawClass();
  }
  
  public Object nullValue(DeserializationContext ctxt)
    throws JsonProcessingException
  {
    if ((_isPrimitive) && (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw ctxt.mappingException("Can not map JSON null into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[] { _rawType.getName() });
    }
    return _nullValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.NullProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */