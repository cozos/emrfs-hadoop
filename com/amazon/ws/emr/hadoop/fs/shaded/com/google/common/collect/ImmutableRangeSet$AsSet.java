package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import java.util.Iterator;
import javax.annotation.Nullable;

final class ImmutableRangeSet$AsSet
  extends ImmutableSortedSet<C>
{
  private final DiscreteDomain<C> domain;
  private transient Integer size;
  
  ImmutableRangeSet$AsSet(DiscreteDomain<C> arg1)
  {
    super(Ordering.natural());
    this.domain = domain;
  }
  
  public int size()
  {
    Integer result = size;
    if (result == null)
    {
      long total = 0L;
      for (Range<C> range : ImmutableRangeSet.access$000(this$0))
      {
        total += ContiguousSet.create(range, domain).size();
        if (total >= 2147483647L) {
          break;
        }
      }
      result = size = Integer.valueOf(Ints.saturatedCast(total));
    }
    return result.intValue();
  }
  
  public UnmodifiableIterator<C> iterator()
  {
    new AbstractIterator()
    {
      final Iterator<Range<C>> rangeItr = ImmutableRangeSet.access$000(this$0).iterator();
      Iterator<C> elemItr = Iterators.emptyIterator();
      
      protected C computeNext()
      {
        while (!elemItr.hasNext()) {
          if (rangeItr.hasNext()) {
            elemItr = ContiguousSet.create((Range)rangeItr.next(), domain).iterator();
          } else {
            return (Comparable)endOfData();
          }
        }
        return (Comparable)elemItr.next();
      }
    };
  }
  
  @GwtIncompatible("NavigableSet")
  public UnmodifiableIterator<C> descendingIterator()
  {
    new AbstractIterator()
    {
      final Iterator<Range<C>> rangeItr = ImmutableRangeSet.access$000(this$0).reverse().iterator();
      Iterator<C> elemItr = Iterators.emptyIterator();
      
      protected C computeNext()
      {
        while (!elemItr.hasNext()) {
          if (rangeItr.hasNext()) {
            elemItr = ContiguousSet.create((Range)rangeItr.next(), domain).descendingIterator();
          } else {
            return (Comparable)endOfData();
          }
        }
        return (Comparable)elemItr.next();
      }
    };
  }
  
  ImmutableSortedSet<C> subSet(Range<C> range)
  {
    return this$0.subRangeSet(range).asSet(domain);
  }
  
  ImmutableSortedSet<C> headSetImpl(C toElement, boolean inclusive)
  {
    return subSet(Range.upTo(toElement, BoundType.forBoolean(inclusive)));
  }
  
  ImmutableSortedSet<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive)
  {
    if ((!fromInclusive) && (!toInclusive) && (Range.compareOrThrow(fromElement, toElement) == 0)) {
      return ImmutableSortedSet.of();
    }
    return subSet(Range.range(fromElement, BoundType.forBoolean(fromInclusive), toElement, BoundType.forBoolean(toInclusive)));
  }
  
  ImmutableSortedSet<C> tailSetImpl(C fromElement, boolean inclusive)
  {
    return subSet(Range.downTo(fromElement, BoundType.forBoolean(inclusive)));
  }
  
  public boolean contains(@Nullable Object o)
  {
    if (o == null) {
      return false;
    }
    try
    {
      C c = (Comparable)o;
      return this$0.contains(c);
    }
    catch (ClassCastException e) {}
    return false;
  }
  
  int indexOf(Object target)
  {
    if (contains(target))
    {
      C c = (Comparable)target;
      long total = 0L;
      for (Range<C> range : ImmutableRangeSet.access$000(this$0))
      {
        if (range.contains(c)) {
          return Ints.saturatedCast(total + ContiguousSet.create(range, domain).indexOf(c));
        }
        total += ContiguousSet.create(range, domain).size();
      }
      throw new AssertionError("impossible");
    }
    return -1;
  }
  
  boolean isPartialView()
  {
    return ImmutableRangeSet.access$000(this$0).isPartialView();
  }
  
  public String toString()
  {
    return ImmutableRangeSet.access$000(this$0).toString();
  }
  
  Object writeReplace()
  {
    return new ImmutableRangeSet.AsSetSerializedForm(ImmutableRangeSet.access$000(this$0), domain);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.AsSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */