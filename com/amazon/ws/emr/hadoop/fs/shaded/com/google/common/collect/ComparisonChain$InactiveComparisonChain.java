package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$InactiveComparisonChain
  extends ComparisonChain
{
  final int result;
  
  ComparisonChain$InactiveComparisonChain(int result)
  {
    super(null);
    this.result = result;
  }
  
  public ComparisonChain compare(@Nullable Comparable left, @Nullable Comparable right)
  {
    return this;
  }
  
  public <T> ComparisonChain compare(@Nullable T left, @Nullable T right, @Nullable Comparator<T> comparator)
  {
    return this;
  }
  
  public ComparisonChain compare(int left, int right)
  {
    return this;
  }
  
  public ComparisonChain compare(long left, long right)
  {
    return this;
  }
  
  public ComparisonChain compare(float left, float right)
  {
    return this;
  }
  
  public ComparisonChain compare(double left, double right)
  {
    return this;
  }
  
  public ComparisonChain compareTrueFirst(boolean left, boolean right)
  {
    return this;
  }
  
  public ComparisonChain compareFalseFirst(boolean left, boolean right)
  {
    return this;
  }
  
  public int result()
  {
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComparisonChain.InactiveComparisonChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */