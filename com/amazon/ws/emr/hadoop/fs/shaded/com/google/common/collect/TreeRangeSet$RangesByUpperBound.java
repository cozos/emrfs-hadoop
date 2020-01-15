package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import javax.annotation.Nullable;

@VisibleForTesting
final class TreeRangeSet$RangesByUpperBound<C extends Comparable<?>>
  extends AbstractNavigableMap<Cut<C>, Range<C>>
{
  private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
  private final Range<Cut<C>> upperBoundWindow;
  
  TreeRangeSet$RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> rangesByLowerBound)
  {
    this.rangesByLowerBound = rangesByLowerBound;
    upperBoundWindow = Range.all();
  }
  
  private TreeRangeSet$RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> rangesByLowerBound, Range<Cut<C>> upperBoundWindow)
  {
    this.rangesByLowerBound = rangesByLowerBound;
    this.upperBoundWindow = upperBoundWindow;
  }
  
  private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> window)
  {
    if (window.isConnected(upperBoundWindow)) {
      return new RangesByUpperBound(rangesByLowerBound, window.intersection(upperBoundWindow));
    }
    return ImmutableSortedMap.of();
  }
  
  public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> fromKey, boolean fromInclusive, Cut<C> toKey, boolean toInclusive)
  {
    return subMap(Range.range(fromKey, BoundType.forBoolean(fromInclusive), toKey, BoundType.forBoolean(toInclusive)));
  }
  
  public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> toKey, boolean inclusive)
  {
    return subMap(Range.upTo(toKey, BoundType.forBoolean(inclusive)));
  }
  
  public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> fromKey, boolean inclusive)
  {
    return subMap(Range.downTo(fromKey, BoundType.forBoolean(inclusive)));
  }
  
  public Comparator<? super Cut<C>> comparator()
  {
    return Ordering.natural();
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return get(key) != null;
  }
  
  public Range<C> get(@Nullable Object key)
  {
    if ((key instanceof Cut)) {
      try
      {
        Cut<C> cut = (Cut)key;
        if (!upperBoundWindow.contains(cut)) {
          return null;
        }
        Map.Entry<Cut<C>, Range<C>> candidate = rangesByLowerBound.lowerEntry(cut);
        if ((candidate != null) && (getValueupperBound.equals(cut))) {
          return (Range)candidate.getValue();
        }
      }
      catch (ClassCastException e)
      {
        return null;
      }
    }
    return null;
  }
  
  Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator()
  {
    Iterator<Range<C>> backingItr;
    final Iterator<Range<C>> backingItr;
    if (!upperBoundWindow.hasLowerBound())
    {
      backingItr = rangesByLowerBound.values().iterator();
    }
    else
    {
      Map.Entry<Cut<C>, Range<C>> lowerEntry = rangesByLowerBound.lowerEntry(upperBoundWindow.lowerEndpoint());
      Iterator<Range<C>> backingItr;
      if (lowerEntry == null)
      {
        backingItr = rangesByLowerBound.values().iterator();
      }
      else
      {
        Iterator<Range<C>> backingItr;
        if (upperBoundWindow.lowerBound.isLessThan(getValueupperBound)) {
          backingItr = rangesByLowerBound.tailMap(lowerEntry.getKey(), true).values().iterator();
        } else {
          backingItr = rangesByLowerBound.tailMap(upperBoundWindow.lowerEndpoint(), true).values().iterator();
        }
      }
    }
    new AbstractIterator()
    {
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if (!backingItr.hasNext()) {
          return (Map.Entry)endOfData();
        }
        Range<C> range = (Range)backingItr.next();
        if (upperBoundWindow.upperBound.isLessThan(upperBound)) {
          return (Map.Entry)endOfData();
        }
        return Maps.immutableEntry(upperBound, range);
      }
    };
  }
  
  Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
  {
    Collection<Range<C>> candidates;
    Collection<Range<C>> candidates;
    if (upperBoundWindow.hasUpperBound()) {
      candidates = rangesByLowerBound.headMap(upperBoundWindow.upperEndpoint(), false).descendingMap().values();
    } else {
      candidates = rangesByLowerBound.descendingMap().values();
    }
    final PeekingIterator<Range<C>> backingItr = Iterators.peekingIterator(candidates.iterator());
    if ((backingItr.hasNext()) && (upperBoundWindow.upperBound.isLessThan(peekupperBound))) {
      backingItr.next();
    }
    new AbstractIterator()
    {
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if (!backingItr.hasNext()) {
          return (Map.Entry)endOfData();
        }
        Range<C> range = (Range)backingItr.next();
        return upperBoundWindow.lowerBound.isLessThan(upperBound) ? Maps.immutableEntry(upperBound, range) : (Map.Entry)endOfData();
      }
    };
  }
  
  public int size()
  {
    if (upperBoundWindow.equals(Range.all())) {
      return rangesByLowerBound.size();
    }
    return Iterators.size(entryIterator());
  }
  
  public boolean isEmpty()
  {
    return !entryIterator().hasNext() ? true : upperBoundWindow.equals(Range.all()) ? rangesByLowerBound.isEmpty() : false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.RangesByUpperBound
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */