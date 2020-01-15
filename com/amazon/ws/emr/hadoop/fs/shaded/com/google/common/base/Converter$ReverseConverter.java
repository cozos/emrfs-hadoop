package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ReverseConverter<A, B>
  extends Converter<B, A>
  implements Serializable
{
  final Converter<A, B> original;
  private static final long serialVersionUID = 0L;
  
  Converter$ReverseConverter(Converter<A, B> original)
  {
    this.original = original;
  }
  
  protected A doForward(B b)
  {
    throw new AssertionError();
  }
  
  protected B doBackward(A a)
  {
    throw new AssertionError();
  }
  
  @Nullable
  A correctedDoForward(@Nullable B b)
  {
    return (A)original.correctedDoBackward(b);
  }
  
  @Nullable
  B correctedDoBackward(@Nullable A a)
  {
    return (B)original.correctedDoForward(a);
  }
  
  public Converter<A, B> reverse()
  {
    return original;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof ReverseConverter))
    {
      ReverseConverter<?, ?> that = (ReverseConverter)object;
      return original.equals(original);
    }
    return false;
  }
  
  public int hashCode()
  {
    return original.hashCode() ^ 0xFFFFFFFF;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(original));return 10 + str.length() + str + ".reverse()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.ReverseConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */