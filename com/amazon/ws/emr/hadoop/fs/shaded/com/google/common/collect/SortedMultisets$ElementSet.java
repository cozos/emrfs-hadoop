package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

class SortedMultisets$ElementSet<E>
  extends Multisets.ElementSet<E>
  implements SortedSet<E>
{
  private final SortedMultiset<E> multiset;
  
  SortedMultisets$ElementSet(SortedMultiset<E> multiset)
  {
    this.multiset = multiset;
  }
  
  final SortedMultiset<E> multiset()
  {
    return multiset;
  }
  
  public Comparator<? super E> comparator()
  {
    return multiset().comparator();
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return multiset().subMultiset(fromElement, BoundType.CLOSED, toElement, BoundType.OPEN).elementSet();
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return multiset().headMultiset(toElement, BoundType.OPEN).elementSet();
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return multiset().tailMultiset(fromElement, BoundType.CLOSED).elementSet();
  }
  
  public E first()
  {
    return (E)SortedMultisets.access$000(multiset().firstEntry());
  }
  
  public E last()
  {
    return (E)SortedMultisets.access$000(multiset().lastEntry());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedMultisets.ElementSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */