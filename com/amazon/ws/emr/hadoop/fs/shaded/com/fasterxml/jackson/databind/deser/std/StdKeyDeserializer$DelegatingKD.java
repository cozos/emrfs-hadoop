package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.IOException;
import java.io.Serializable;

final class StdKeyDeserializer$DelegatingKD
  extends KeyDeserializer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _keyClass;
  protected final JsonDeserializer<?> _delegate;
  
  protected StdKeyDeserializer$DelegatingKD(Class<?> cls, JsonDeserializer<?> deser)
  {
    _keyClass = cls;
    _delegate = deser;
  }
  
  public final Object deserializeKey(String key, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    if (key == null) {
      return null;
    }
    try
    {
      Object result = _delegate.deserialize(ctxt.getParser(), ctxt);
      if (result != null) {
        return result;
      }
    }
    catch (Exception re)
    {
      throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation: " + re.getMessage());
    }
    throw ctxt.weirdKeyException(_keyClass, key, "not a valid representation");
  }
  
  public Class<?> getKeyClass()
  {
    return _keyClass;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.DelegatingKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */