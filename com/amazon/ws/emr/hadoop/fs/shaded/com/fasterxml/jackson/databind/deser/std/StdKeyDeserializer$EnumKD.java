package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EnumResolver;

@JacksonStdImpl
final class StdKeyDeserializer$EnumKD
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final EnumResolver _resolver;
  protected final AnnotatedMethod _factory;
  
  protected StdKeyDeserializer$EnumKD(EnumResolver er, AnnotatedMethod factory)
  {
    super(-1, er.getEnumClass());
    _resolver = er;
    _factory = factory;
  }
  
  public Object _parse(String key, DeserializationContext ctxt)
    throws JsonMappingException
  {
    if (_factory != null) {
      try
      {
        return _factory.call1(key);
      }
      catch (Exception e)
      {
        ClassUtil.unwrapAndThrowAsIAE(e);
      }
    }
    Enum<?> e = _resolver.findEnum(key);
    if ((e == null) && (!ctxt.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL))) {
      throw ctxt.weirdKeyException(_keyClass, key, "not one of values for Enum class");
    }
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.EnumKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */