package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Maps$BiMapConverter<A, B>
  extends Converter<A, B>
  implements Serializable
{
  private final BiMap<A, B> bimap;
  private static final long serialVersionUID = 0L;
  
  Maps$BiMapConverter(BiMap<A, B> bimap)
  {
    this.bimap = ((BiMap)Preconditions.checkNotNull(bimap));
  }
  
  protected B doForward(A a)
  {
    return (B)convert(bimap, a);
  }
  
  protected A doBackward(B b)
  {
    return (A)convert(bimap.inverse(), b);
  }
  
  private static <X, Y> Y convert(BiMap<X, Y> bimap, X input)
  {
    Y output = bimap.get(input);
    Preconditions.checkArgument(output != null, "No non-null mapping present for input: %s", new Object[] { input });
    return output;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof BiMapConverter))
    {
      BiMapConverter<?, ?> that = (BiMapConverter)object;
      return bimap.equals(bimap);
    }
    return false;
  }
  
  public int hashCode()
  {
    return bimap.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(bimap));return 18 + str.length() + "Maps.asConverter(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.BiMapConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */