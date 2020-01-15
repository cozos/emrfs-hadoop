package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ConverterComposition<A, B, C>
  extends Converter<A, C>
  implements Serializable
{
  final Converter<A, B> first;
  final Converter<B, C> second;
  private static final long serialVersionUID = 0L;
  
  Converter$ConverterComposition(Converter<A, B> first, Converter<B, C> second)
  {
    this.first = first;
    this.second = second;
  }
  
  protected C doForward(A a)
  {
    throw new AssertionError();
  }
  
  protected A doBackward(C c)
  {
    throw new AssertionError();
  }
  
  @Nullable
  C correctedDoForward(@Nullable A a)
  {
    return (C)second.correctedDoForward(first.correctedDoForward(a));
  }
  
  @Nullable
  A correctedDoBackward(@Nullable C c)
  {
    return (A)first.correctedDoBackward(second.correctedDoBackward(c));
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof ConverterComposition))
    {
      ConverterComposition<?, ?, ?> that = (ConverterComposition)object;
      return (first.equals(first)) && (second.equals(second));
    }
    return false;
  }
  
  public int hashCode()
  {
    return 31 * first.hashCode() + second.hashCode();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(first));String str2 = String.valueOf(String.valueOf(second));return 10 + str1.length() + str2.length() + str1 + ".andThen(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.ConverterComposition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */