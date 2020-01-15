package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;

public final class DefaultSerializerProvider$Impl
  extends DefaultSerializerProvider
{
  private static final long serialVersionUID = 1L;
  
  public DefaultSerializerProvider$Impl() {}
  
  public DefaultSerializerProvider$Impl(Impl src)
  {
    super(src);
  }
  
  protected DefaultSerializerProvider$Impl(SerializerProvider src, SerializationConfig config, SerializerFactory f)
  {
    super(src, config, f);
  }
  
  public DefaultSerializerProvider copy()
  {
    if (getClass() != Impl.class) {
      return super.copy();
    }
    return new Impl(this);
  }
  
  public Impl createInstance(SerializationConfig config, SerializerFactory jsf)
  {
    return new Impl(this, config, jsf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */