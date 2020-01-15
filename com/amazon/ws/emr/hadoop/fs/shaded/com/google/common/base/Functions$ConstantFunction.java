package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$ConstantFunction<E>
  implements Function<Object, E>, Serializable
{
  private final E value;
  private static final long serialVersionUID = 0L;
  
  public Functions$ConstantFunction(@Nullable E value)
  {
    this.value = value;
  }
  
  public E apply(@Nullable Object from)
  {
    return (E)value;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof ConstantFunction))
    {
      ConstantFunction<?> that = (ConstantFunction)obj;
      return Objects.equal(value, value);
    }
    return false;
  }
  
  public int hashCode()
  {
    return value == null ? 0 : value.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(value));return 10 + str.length() + "constant(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.ConstantFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */