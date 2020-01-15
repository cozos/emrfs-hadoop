package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$FunctionBasedConverter<A, B>
  extends Converter<A, B>
  implements Serializable
{
  private final Function<? super A, ? extends B> forwardFunction;
  private final Function<? super B, ? extends A> backwardFunction;
  
  private Converter$FunctionBasedConverter(Function<? super A, ? extends B> forwardFunction, Function<? super B, ? extends A> backwardFunction)
  {
    this.forwardFunction = ((Function)Preconditions.checkNotNull(forwardFunction));
    this.backwardFunction = ((Function)Preconditions.checkNotNull(backwardFunction));
  }
  
  protected B doForward(A a)
  {
    return (B)forwardFunction.apply(a);
  }
  
  protected A doBackward(B b)
  {
    return (A)backwardFunction.apply(b);
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof FunctionBasedConverter))
    {
      FunctionBasedConverter<?, ?> that = (FunctionBasedConverter)object;
      return (forwardFunction.equals(forwardFunction)) && (backwardFunction.equals(backwardFunction));
    }
    return false;
  }
  
  public int hashCode()
  {
    return forwardFunction.hashCode() * 31 + backwardFunction.hashCode();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(forwardFunction));String str2 = String.valueOf(String.valueOf(backwardFunction));return 18 + str1.length() + str2.length() + "Converter.from(" + str1 + ", " + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.FunctionBasedConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */