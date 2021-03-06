package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
abstract class Cut<C extends Comparable>
  implements Comparable<Cut<C>>, Serializable
{
  final C endpoint;
  private static final long serialVersionUID = 0L;
  
  Cut(@Nullable C endpoint)
  {
    this.endpoint = endpoint;
  }
  
  abstract boolean isLessThan(C paramC);
  
  abstract BoundType typeAsLowerBound();
  
  abstract BoundType typeAsUpperBound();
  
  abstract Cut<C> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract Cut<C> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract void describeAsLowerBound(StringBuilder paramStringBuilder);
  
  abstract void describeAsUpperBound(StringBuilder paramStringBuilder);
  
  abstract C leastValueAbove(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract C greatestValueBelow(DiscreteDomain<C> paramDiscreteDomain);
  
  Cut<C> canonical(DiscreteDomain<C> domain)
  {
    return this;
  }
  
  public int compareTo(Cut<C> that)
  {
    if (that == belowAll()) {
      return 1;
    }
    if (that == aboveAll()) {
      return -1;
    }
    int result = Range.compareOrThrow(endpoint, endpoint);
    if (result != 0) {
      return result;
    }
    return Booleans.compare(this instanceof AboveValue, that instanceof AboveValue);
  }
  
  C endpoint()
  {
    return endpoint;
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof Cut))
    {
      Cut<C> that = (Cut)obj;
      try
      {
        int compareResult = compareTo(that);
        return compareResult == 0;
      }
      catch (ClassCastException ignored) {}
    }
    return false;
  }
  
  static <C extends Comparable> Cut<C> belowAll()
  {
    return BelowAll.INSTANCE;
  }
  
  private static final class BelowAll
    extends Cut<Comparable<?>>
  {
    private static final BelowAll INSTANCE = new BelowAll();
    private static final long serialVersionUID = 0L;
    
    private BelowAll()
    {
      super();
    }
    
    Comparable<?> endpoint()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    boolean isLessThan(Comparable<?> value)
    {
      return true;
    }
    
    BoundType typeAsLowerBound()
    {
      throw new IllegalStateException();
    }
    
    BoundType typeAsUpperBound()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
    {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    void describeAsLowerBound(StringBuilder sb)
    {
      sb.append("(-∞");
    }
    
    void describeAsUpperBound(StringBuilder sb)
    {
      throw new AssertionError();
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain)
    {
      return domain.minValue();
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain)
    {
      throw new AssertionError();
    }
    
    Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> domain)
    {
      try
      {
        return Cut.belowValue(domain.minValue());
      }
      catch (NoSuchElementException e) {}
      return this;
    }
    
    public int compareTo(Cut<Comparable<?>> o)
    {
      return o == this ? 0 : -1;
    }
    
    public String toString()
    {
      return "-∞";
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
  }
  
  static <C extends Comparable> Cut<C> aboveAll()
  {
    return AboveAll.INSTANCE;
  }
  
  private static final class AboveAll
    extends Cut<Comparable<?>>
  {
    private static final AboveAll INSTANCE = new AboveAll();
    private static final long serialVersionUID = 0L;
    
    private AboveAll()
    {
      super();
    }
    
    Comparable<?> endpoint()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    boolean isLessThan(Comparable<?> value)
    {
      return false;
    }
    
    BoundType typeAsLowerBound()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    BoundType typeAsUpperBound()
    {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
    {
      throw new IllegalStateException();
    }
    
    void describeAsLowerBound(StringBuilder sb)
    {
      throw new AssertionError();
    }
    
    void describeAsUpperBound(StringBuilder sb)
    {
      sb.append("+∞)");
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain)
    {
      throw new AssertionError();
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain)
    {
      return domain.maxValue();
    }
    
    public int compareTo(Cut<Comparable<?>> o)
    {
      return o == this ? 0 : 1;
    }
    
    public String toString()
    {
      return "+∞";
    }
    
    private Object readResolve()
    {
      return INSTANCE;
    }
  }
  
  static <C extends Comparable> Cut<C> belowValue(C endpoint)
  {
    return new BelowValue(endpoint);
  }
  
  private static final class BelowValue<C extends Comparable>
    extends Cut<C>
  {
    private static final long serialVersionUID = 0L;
    
    BelowValue(C endpoint)
    {
      super();
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
  
  static <C extends Comparable> Cut<C> aboveValue(C endpoint)
  {
    return new AboveValue(endpoint);
  }
  
  private static final class AboveValue<C extends Comparable>
    extends Cut<C>
  {
    private static final long serialVersionUID = 0L;
    
    AboveValue(C endpoint)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Cut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */