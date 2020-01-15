package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$ComplementRangesByLowerBound<C extends Comparable<?>>
  extends AbstractNavigableMap<Cut<C>, Range<C>>
{
  private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
  private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;
  private final Range<Cut<C>> complementLowerBoundWindow;
  
  TreeRangeSet$ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound)
  {
    this(positiveRangesByLowerBound, Range.all());
  }
  
  private TreeRangeSet$ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound, Range<Cut<C>> window)
  {
    this.positiveRangesByLowerBound = positiveRangesByLowerBound;
    positiveRangesByUpperBound = new TreeRangeSet.RangesByUpperBound(positiveRangesByLowerBound);
    complementLowerBoundWindow = window;
  }
  
  private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> subWindow)
  {
    if (!complementLowerBoundWindow.isConnected(subWindow)) {
      return ImmutableSortedMap.of();
    }
    subWindow = subWindow.intersection(complementLowerBoundWindow);
    return new ComplementRangesByLowerBound(positiveRangesByLowerBound, subWindow);
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
  
  Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator()
  {
    Collection<Range<C>> positiveRanges;
    Collection<Range<C>> positiveRanges;
    if (complementLowerBoundWindow.hasLowerBound()) {
      positiveRanges = positiveRangesByUpperBound.tailMap(complementLowerBoundWindow.lowerEndpoint(), complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values();
    } else {
      positiveRanges = positiveRangesByUpperBound.values();
    }
    final PeekingIterator<Range<C>> positiveItr = Iterators.peekingIterator(positiveRanges.iterator());
    Cut<C> firstComplementRangeLowerBound;
    if ((complementLowerBoundWindow.contains(Cut.belowAll())) && ((!positiveItr.hasNext()) || (peeklowerBound != Cut.belowAll())))
    {
      firstComplementRangeLowerBound = Cut.belowAll();
    }
    else
    {
      Cut<C> firstComplementRangeLowerBound;
      if (positiveItr.hasNext()) {
        firstComplementRangeLowerBound = nextupperBound;
      } else {
        return Iterators.emptyIterator();
      }
    }
    final Cut<C> firstComplementRangeLowerBound;
    new AbstractIterator()
    {
      Cut<C> nextComplementRangeLowerBound = firstComplementRangeLowerBound;
      
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if ((complementLowerBoundWindow.upperBound.isLessThan(nextComplementRangeLowerBound)) || (nextComplementRangeLowerBound == Cut.aboveAll())) {
          return (Map.Entry)endOfData();
        }
        Range<C> negativeRange;
        if (positiveItr.hasNext())
        {
          Range<C> positiveRange = (Range)positiveItr.next();
          Range<C> negativeRange = Range.create(nextComplementRangeLowerBound, lowerBound);
          nextComplementRangeLowerBound = upperBound;
        }
        else
        {
          negativeRange = Range.create(nextComplementRangeLowerBound, Cut.aboveAll());
          nextComplementRangeLowerBound = Cut.aboveAll();
        }
        return Maps.immutableEntry(lowerBound, negativeRange);
      }
    };
  }
  
  Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator()
  {
    Cut<C> startingPoint = complementLowerBoundWindow.hasUpperBound() ? (Cut)complementLowerBoundWindow.upperEndpoint() : Cut.aboveAll();
    
    boolean inclusive = (complementLowerBoundWindow.hasUpperBound()) && (complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED);
    
    final PeekingIterator<Range<C>> positiveItr = Iterators.peekingIterator(positiveRangesByUpperBound.headMap(startingPoint, inclusive).descendingMap().values().iterator());
    Cut<C> cut;
    Cut<C> cut;
    if (positiveItr.hasNext())
    {
      cut = peekupperBound == Cut.aboveAll() ? nextlowerBound : (Cut)positiveRangesByLowerBound.higherKey(peekupperBound);
    }
    else
    {
      if ((!complementLowerBoundWindow.contains(Cut.belowAll())) || (positiveRangesByLowerBound.containsKey(Cut.belowAll()))) {
        return Iterators.emptyIterator();
      }
      cut = (Cut)positiveRangesByLowerBound.higherKey(Cut.belowAll());
    }
    final Cut<C> firstComplementRangeUpperBound = (Cut)MoreObjects.firstNonNull(cut, Cut.aboveAll());
    
    new AbstractIterator()
    {
      Cut<C> nextComplementRangeUpperBound = firstComplementRangeUpperBound;
      
      protected Map.Entry<Cut<C>, Range<C>> computeNext()
      {
        if (nextComplementRangeUpperBound == Cut.belowAll()) {
          return (Map.Entry)endOfData();
        }
        if (positiveItr.hasNext())
        {
          Range<C> positiveRange = (Range)positiveItr.next();
          Range<C> negativeRange = Range.create(upperBound, nextComplementRangeUpperBound);
          
          nextComplementRangeUpperBound = lowerBound;
          if (complementLowerBoundWindow.lowerBound.isLessThan(lowerBound)) {
            return Maps.immutableEntry(lowerBound, negativeRange);
          }
        }
        else if (complementLowerBoundWindow.lowerBound.isLessThan(Cut.belowAll()))
        {
          Range<C> negativeRange = Range.create(Cut.belowAll(), nextComplementRangeUpperBound);
          
          nextComplementRangeUpperBound = Cut.belowAll();
          return Maps.immutableEntry(Cut.belowAll(), negativeRange);
        }
        return (Map.Entry)endOfData();
      }
    };
  }
  
  public int size()
  {
    return Iterators.size(entryIterator());
  }
  
  @Nullable
  public Range<C> get(Object key)
  {
    if ((key instanceof Cut)) {
      try
      {
        Cut<C> cut = (Cut)key;
        
        Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
        if ((firstEntry != null) && (((Cut)firstEntry.getKey()).equals(cut))) {
          return (Range)firstEntry.getValue();
        }
      }
      catch (ClassCastException e)
      {
        return null;
      }
    }
    return null;
  }
  
  public boolean containsKey(Object key)
  {
    return get(key) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */