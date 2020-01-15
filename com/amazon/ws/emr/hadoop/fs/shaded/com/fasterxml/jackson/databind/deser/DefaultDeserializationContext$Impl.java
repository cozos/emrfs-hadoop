package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.InjectableValues;

public final class DefaultDeserializationContext$Impl
  extends DefaultDeserializationContext
{
  private static final long serialVersionUID = 1L;
  
  public DefaultDeserializationContext$Impl(DeserializerFactory df)
  {
    super(df, null);
  }
  
  protected DefaultDeserializationContext$Impl(Impl src, DeserializationConfig config, JsonParser jp, InjectableValues values)
  {
    super(src, config, jp, values);
  }
  
  protected DefaultDeserializationContext$Impl(Impl src)
  {
    super(src);
  }
  
  protected DefaultDeserializationContext$Impl(Impl src, DeserializerFactory factory)
  {
    super(src, factory);
  }
  
  public DefaultDeserializationContext copy()
  {
    if (getClass() != Impl.class) {
      return super.copy();
    }
    return new Impl(this);
  }
  
  public DefaultDeserializationContext createInstance(DeserializationConfig config, JsonParser jp, InjectableValues values)
  {
    return new Impl(this, config, jp, values);
  }
  
  public DefaultDeserializationContext with(DeserializerFactory factory)
  {
    return new Impl(this, factory);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */