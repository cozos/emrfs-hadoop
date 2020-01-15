package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class Constraints
{
  public static <E> Collection<E> constrainedCollection(Collection<E> collection, Constraint<? super E> constraint)
  {
    return new ConstrainedCollection(collection, constraint);
  }
  
  static class ConstrainedCollection<E>
    extends ForwardingCollection<E>
  {
    private final Collection<E> delegate;
    private final Constraint<? super E> constraint;
    
    public ConstrainedCollection(Collection<E> delegate, Constraint<? super E> constraint)
    {
      this.delegate = ((Collection)Preconditions.checkNotNull(delegate));
      this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
    }
    
    protected Collection<E> delegate()
    {
      return delegate;
    }
    
    public boolean add(E element)
    {
      constraint.checkElement(element);
      return delegate.add(element);
    }
    
    public boolean addAll(Collection<? extends E> elements)
    {
      return delegate.addAll(Constraints.checkElements(elements, constraint));
    }
  }
  
  public static <E> Set<E> constrainedSet(Set<E> set, Constraint<? super E> constraint)
  {
    return new ConstrainedSet(set, constraint);
  }
  
  static class ConstrainedSet<E>
    extends ForwardingSet<E>
  {
    private final Set<E> delegate;
    private final Constraint<? super E> constraint;
    
    public ConstrainedSet(Set<E> delegate, Constraint<? super E> constraint)
    {
      this.delegate = ((Set)Preconditions.checkNotNull(delegate));
      this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
    }
    
    protected Set<E> delegate()
    {
      return delegate;
    }
    
    public boolean add(E element)
    {
      constraint.checkElement(element);
      return delegate.add(element);
    }
    
    public boolean addAll(Collection<? extends E> elements)
    {
      return delegate.addAll(Constraints.checkElements(elements, constraint));
    }
  }
  
  public static <E> SortedSet<E> constrainedSortedSet(SortedSet<E> sortedSet, Constraint<? super E> constraint)
  {
    return new ConstrainedSortedSet(sortedSet, constraint);
  }
  
  private static class ConstrainedSortedSet<E>
    extends ForwardingSortedSet<E>
  {
    final SortedSet<E> delegate;
    final Constraint<? super E> constraint;
    
    ConstrainedSortedSet(SortedSet<E> delegate, Constraint<? super E> constraint)
    {
      this.delegate = ((SortedSet)Preconditions.checkNotNull(delegate));
      this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
    }
    
    protected SortedSet<E> delegate()
    {
      return delegate;
    }
    
    public SortedSet<E> headSet(E toElement)
    {
      return Constraints.constrainedSortedSet(delegate.headSet(toElement), constraint);
    }
    
    public SortedSet<E> subSet(E fromElement, E toElement)
    {
      return Constraints.constrainedSortedSet(delegate.subSet(fromElement, toElement), constraint);
    }
    
    public SortedSet<E> tailSet(E fromElement)
    {
      return Constraints.constrainedSortedSet(delegate.tailSet(fromElement), constraint);
    }
    
    public boolean add(E element)
    {
      constraint.checkElement(element);
      return delegate.add(element);
    }
    
    public boolean addAll(Collection<? extends E> elements)
    {
      return delegate.addAll(Constraints.checkElements(elements, constraint));
    }
  }
  
  public static <E> List<E> constrainedList(List<E> list, Constraint<? super E> constraint)
  {
    return (list instanceof RandomAccess) ? new ConstrainedRandomAccessList(list, constraint) : new ConstrainedList(list, constraint);
  }
  
  @GwtCompatible
  private static class ConstrainedList<E>
    extends ForwardingList<E>
  {
    final List<E> delegate;
    final Constraint<? super E> constraint;
    
    ConstrainedList(List<E> delegate, Constraint<? super E> constraint)
    {
      this.delegate = ((List)Preconditions.checkNotNull(delegate));
      this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
    }
    
    protected List<E> delegate()
    {
      return delegate;
    }
    
    public boolean add(E element)
    {
      constraint.checkElement(element);
      return delegate.add(element);
    }
    
    public void add(int index, E element)
    {
      constraint.checkElement(element);
      delegate.add(index, element);
    }
    
    public boolean addAll(Collection<? extends E> elements)
    {
      return delegate.addAll(Constraints.checkElements(elements, constraint));
    }
    
    public boolean addAll(int index, Collection<? extends E> elements)
    {
      return delegate.addAll(index, Constraints.checkElements(elements, constraint));
    }
    
    public ListIterator<E> listIterator()
    {
      return Constraints.constrainedListIterator(delegate.listIterator(), constraint);
    }
    
    public ListIterator<E> listIterator(int index)
    {
      return Constraints.constrainedListIterator(delegate.listIterator(index), constraint);
    }
    
    public E set(int index, E element)
    {
      constraint.checkElement(element);
      return (E)delegate.set(index, element);
    }
    
    public List<E> subList(int fromIndex, int toIndex)
    {
      return Constraints.constrainedList(delegate.subList(fromIndex, toIndex), constraint);
    }
  }
  
  static class ConstrainedRandomAccessList<E>
    extends Constraints.ConstrainedList<E>
    implements RandomAccess
  {
    ConstrainedRandomAccessList(List<E> delegate, Constraint<? super E> constraint)
    {
      super(constraint);
    }
  }
  
  private static <E> ListIterator<E> constrainedListIterator(ListIterator<E> listIterator, Constraint<? super E> constraint)
  {
    return new ConstrainedListIterator(listIterator, constraint);
  }
  
  static class ConstrainedListIterator<E>
    extends ForwardingListIterator<E>
  {
    private final ListIterator<E> delegate;
    private final Constraint<? super E> constraint;
    
    public ConstrainedListIterator(ListIterator<E> delegate, Constraint<? super E> constraint)
    {
      this.delegate = delegate;
      this.constraint = constraint;
    }
    
    protected ListIterator<E> delegate()
    {
      return delegate;
    }
    
    public void add(E element)
    {
      constraint.checkElement(element);
      delegate.add(element);
    }
    
    public void set(E element)
    {
      constraint.checkElement(element);
      delegate.set(element);
    }
  }
  
  static <E> Collection<E> constrainedTypePreservingCollection(Collection<E> collection, Constraint<E> constraint)
  {
    if ((collection instanceof SortedSet)) {
      return constrainedSortedSet((SortedSet)collection, constraint);
    }
    if ((collection instanceof Set)) {
      return constrainedSet((Set)collection, constraint);
    }
    if ((collection instanceof List)) {
      return constrainedList((List)collection, constraint);
    }
    return constrainedCollection(collection, constraint);
  }
  
  private static <E> Collection<E> checkElements(Collection<E> elements, Constraint<? super E> constraint)
  {
    Collection<E> copy = Lists.newArrayList(elements);
    for (E element : copy) {
      constraint.checkElement(element);
    }
    return copy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Constraints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */