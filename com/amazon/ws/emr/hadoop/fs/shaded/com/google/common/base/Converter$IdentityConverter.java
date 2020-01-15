package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;

final class Converter$IdentityConverter<T>
  extends Converter<T, T>
  implements Serializable
{
  static final IdentityConverter INSTANCE = new IdentityConverter();
  private static final long serialVersionUID = 0L;
  
  protected T doForward(T t)
  {
    return t;
  }
  
  protected T doBackward(T t)
  {
    return t;
  }
  
  public IdentityConverter<T> reverse()
  {
    return this;
  }
  
  <S> Converter<T, S> doAndThen(Converter<T, S> otherConverter)
  {
    return (Converter)Preconditions.checkNotNull(otherConverter, "otherConverter");
  }
  
  public String toString()
  {
    return "Converter.identity()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.IdentityConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */