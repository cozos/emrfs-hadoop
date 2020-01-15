package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import javax.annotation.Nullable;

class Maps$ValueDifferenceImpl<V>
  implements MapDifference.ValueDifference<V>
{
  private final V left;
  private final V right;
  
  static <V> MapDifference.ValueDifference<V> create(@Nullable V left, @Nullable V right)
  {
    return new ValueDifferenceImpl(left, right);
  }
  
  private Maps$ValueDifferenceImpl(@Nullable V left, @Nullable V right)
  {
    this.left = left;
    this.right = right;
  }
  
  public V leftValue()
  {
    return (V)left;
  }
  
  public V rightValue()
  {
    return (V)right;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof MapDifference.ValueDifference))
    {
      MapDifference.ValueDifference<?> that = (MapDifference.ValueDifference)object;
      
      return (Objects.equal(left, that.leftValue())) && (Objects.equal(right, that.rightValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { left, right });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(left));String str2 = String.valueOf(String.valueOf(right));return 4 + str1.length() + str2.length() + "(" + str1 + ", " + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.ValueDifferenceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */