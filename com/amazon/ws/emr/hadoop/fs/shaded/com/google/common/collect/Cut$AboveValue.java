package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class Cut$AboveValue<C extends Comparable>
  extends Cut<C>
{
  private static final long serialVersionUID = 0L;
  
  Cut$AboveValue(C endpoint)
  {
    super((Comparable)Preconditions.checkNotNull(endpoint));
  }
  
  boolean isLessThan(C value)
  {
    return Range.compareOrThrow(endpoint, value) < 0;
  }
  
  BoundType typeAsLowerBound()
  {
    return BoundType.OPEN;
  }
  
  BoundType typeAsUpperBound()
  {
    return BoundType.CLOSED;
  }
  
  Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> domain)
  {
    switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()])
    {
    case 2: 
      return this;
    case 1: 
      C next = domain.next(endpoint);
      return next == null ? Cut.belowAll() : belowValue(next);
    }
    throw new AssertionError();
  }
  
  Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> domain)
  {
    switch (Cut.1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()])
    {
    case 2: 
      C next = domain.next(endpoint);
      return next == null ? Cut.aboveAll() : belowValue(next);
    case 1: 
      return this;
    }
    throw new AssertionError();
  }
  
  void describeAsLowerBound(StringBuilder sb)
  {
    sb.append('(').append(endpoint);
  }
  
  void describeAsUpperBound(StringBuilder sb)
  {
    sb.append(endpoint).append(']');
  }
  
  C leastValueAbove(DiscreteDomain<C> domain)
  {
    return domain.next(endpoint);
  }
  
  C greatestValueBelow(DiscreteDomain<C> domain)
  {
    return endpoint;
  }
  
  Cut<C> canonical(DiscreteDomain<C> domain)
  {
    C next = leastValueAbove(domain);
    return next != null ? belowValue(next) : Cut.aboveAll();
  }
  
  public int hashCode()
  {
    return endpoint.hashCode() ^ 0xFFFFFFFF;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(endpoint));return 2 + str.length() + "/" + str + "\\";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Cut.AboveValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */