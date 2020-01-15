package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class Cut$BelowValue<C extends Comparable>
  extends Cut<C>
{
  private static final long serialVersionUID = 0L;
  
  Cut$BelowValue(C endpoint)
  {
    super((Comparable)Preconditions.checkNotNull(endpoint));
  }
  
  boolean isLessThan(C value)
  {
    return Range.compareOrThrow(endpoint, value) <= 0;
  }
  
  BoundType typeAsLowerBound()
  {
    return BoundType.CLOSED;
  }
  
  BoundType typeAsUpperBound()
  {
    return BoundType.OPEN;
  }
  
  Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> domain)
  {
    switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()])
    {
    case 1: 
      return this;
    case 2: 
      C previous = domain.previous(endpoint);
      return previous == null ? Cut.belowAll() : new Cut.AboveValue(previous);
    }
    throw new AssertionError();
  }
  
  Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> domain)
  {
    switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()])
    {
    case 1: 
      C previous = domain.previous(endpoint);
      return previous == null ? Cut.aboveAll() : new Cut.AboveValue(previous);
    case 2: 
      return this;
    }
    throw new AssertionError();
  }
  
  void describeAsLowerBound(StringBuilder sb)
  {
    sb.append('[').append(endpoint);
  }
  
  void describeAsUpperBound(StringBuilder sb)
  {
    sb.append(endpoint).append(')');
  }
  
  C leastValueAbove(DiscreteDomain<C> domain)
  {
    return endpoint;
  }
  
  C greatestValueBelow(DiscreteDomain<C> domain)
  {
    return domain.previous(endpoint);
  }
  
  public int hashCode()
  {
    return endpoint.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(endpoint));return 2 + str.length() + "\\" + str + "/";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Cut.BelowValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */