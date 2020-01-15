package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSetRangesByLowerBound<C extends Comparable<?>>
  extends AbstractNavigableMap<Cut<C>, Range<C>>
{
  private final Range<Cut<C>> lowerBoundWindow;
  private final Range<C> restriction;
  private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
  private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
  
  private TreeRangeSet$SubRangeSetRangesByLowerBound(Range<Cut<C>> lowerBoundWindow, Range<C> restriction, NavigableMap<Cut<C>, Range<C>> rangesByLowerBound)
  {
    this.lowerBoundWindow = ((Range)Preconditions.checkNotNull(lowerBoundWindow));
    this.restriction = ((Range)Preconditions.checkNotNull(restriction));
    this.rangesByLowerBound = ((NavigableMap)Preconditions.checkNotNull(rangesByLowerBound));
    rangesByUpperBound = new TreeRangeSet.RangesByUpperBound(rangesByLowerBound);
  }
  
  private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> window)
  {
    if (!window.isConnected(lowerBoundWindow)) {
      return ImmutableSortedMap.of();
    }
    return new SubRangeSetRangesByLowerBound(lowerBoundWindow.intersection(window), restriction, rangesByLowerBound);
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
  
  @Nullable
  public Range<C> get(@Nullable Object key)
  {
    if ((key instanceof Cut)) {
      try
      {
        Cut<C> cut = (Cut)key;
        if ((!lowerBoundWindow.contains(cut)) || (cut.compareTo(restriction.lowerBound) < 0) || (cut.compareTo(restriction.upperBound) >= 0)) {
          return null;
        }
        if (cut.equals(restriction.lowerBound))
        {
          Range<C> candidate = (Range)Maps.valueOrNull(rangesByLowerBound.floorEntry(cut));
          if ((candidate != null) && (upperBound.compareTo(restriction.lowerBound) > 0)) {
            return candidate.intersection(restriction);
          }
        }
        else
        {
          Range<C> result = (Range)rangesByLowerBound.get(cut);
          if (result != null) {
            return result.intersection(restriction);
          }
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
    if (restriction.isEmpty()) {
      return Iterators.emptyIterator();
    }
    if (lowerBoundWindow.upperBound.isLessThan(restriction.lowerBound)) {
      return Iterators.emptyIterator();
    }
    Iterator<Range<C>> completeRangeItr;
    final Iterator<Range<C>> completeRangeItr;
    if (lowerBoundWindow.lowerBound.isLessThan(restriction.lowerBound)) {
      completeRangeItr = rangesByUpperBound.tailMap(restriction.lowerBound, false).values().iterator();
    } else {
      completeRangeItr = rangesByLowerBound.tailMap(lowerBoundWindow.lowerBound.endpoint(), lowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values().iterator();
    }
    final Cut<Cut<C>> upperBoundOnLowerBounds = (Cut)Ordering.natural().min(lowerBoundWindow.upperBound, Cut.belowValue(restriction.upperBound));
    
    new AbstractIterator()
    {
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if (!completeRangeItr.hasNext()) {
          return (Map.Entry)endOfData();
        }
        Range<C> nextRange = (Range)completeRangeItr.next();
        if (upperBoundOnLowerBounds.isLessThan(lowerBound)) {
          return (Map.Entry)endOfData();
        }
        nextRange = nextRange.intersection(restriction);
        return Maps.immutableEntry(lowerBound, nextRange);
      }
    };
  }
  
  Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
  {
    if (restriction.isEmpty()) {
      return Iterators.emptyIterator();
    }
    Cut<Cut<C>> upperBoundOnLowerBounds = (Cut)Ordering.natural().min(lowerBoundWindow.upperBound, Cut.belowValue(restriction.upperBound));
    
    final Iterator<Range<C>> completeRangeItr = rangesByLowerBound.headMap(upperBoundOnLowerBounds.endpoint(), upperBoundOnLowerBounds.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator();
    
    new AbstractIterator()
    {
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if (!completeRangeItr.hasNext()) {
          return (Map.Entry)endOfData();
        }
        Range<C> nextRange = (Range)completeRangeItr.next();
        if (restriction.lowerBound.compareTo(upperBound) >= 0) {
          return (Map.Entry)endOfData();
        }
        nextRange = nextRange.intersection(restriction);
        if (lowerBoundWindow.contains(lowerBound)) {
          return Maps.immutableEntry(lowerBound, nextRange);
        }
        return (Map.Entry)endOfData();
      }
    };
  }
  
  public int size()
  {
    return Iterators.size(entryIterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */