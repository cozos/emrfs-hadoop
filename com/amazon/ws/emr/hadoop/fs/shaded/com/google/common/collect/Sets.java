package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Sets
{
  static abstract class ImprovedAbstractSet<E>
    extends AbstractSet<E>
  {
    public boolean removeAll(Collection<?> c)
    {
      return Sets.removeAllImpl(this, c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return super.retainAll((Collection)Preconditions.checkNotNull(c));
    }
  }
  
  @GwtCompatible(serializable=true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E anElement, E... otherElements)
  {
    return ImmutableEnumSet.asImmutable(EnumSet.of(anElement, otherElements));
  }
  
  @GwtCompatible(serializable=true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> elements)
  {
    if ((elements instanceof ImmutableEnumSet)) {
      return (ImmutableEnumSet)elements;
    }
    if ((elements instanceof Collection))
    {
      Collection<E> collection = (Collection)elements;
      if (collection.isEmpty()) {
        return ImmutableSet.of();
      }
      return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
    }
    Iterator<E> itr = elements.iterator();
    if (itr.hasNext())
    {
      EnumSet<E> enumSet = EnumSet.of((Enum)itr.next());
      Iterators.addAll(enumSet, itr);
      return ImmutableEnumSet.asImmutable(enumSet);
    }
    return ImmutableSet.of();
  }
  
  public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> elementType)
  {
    EnumSet<E> set = EnumSet.noneOf(elementType);
    Iterables.addAll(set, iterable);
    return set;
  }
  
  public static <E> HashSet<E> newHashSet()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> newHashSet(E... elements)
  {
    HashSet<E> set = newHashSetWithExpectedSize(elements.length);
    Collections.addAll(set, elements);
    return set;
  }
  
  public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize)
  {
    return new HashSet(Maps.capacity(expectedSize));
  }
  
  public static <E> HashSet<E> newHashSet(Iterable<? extends E> elements)
  {
    return (elements instanceof Collection) ? new HashSet(Collections2.cast(elements)) : newHashSet(elements.iterator());
  }
  
  public static <E> HashSet<E> newHashSet(Iterator<? extends E> elements)
  {
    HashSet<E> set = newHashSet();
    Iterators.addAll(set, elements);
    return set;
  }
  
  public static <E> Set<E> newConcurrentHashSet()
  {
    return newSetFromMap(new ConcurrentHashMap());
  }
  
  public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> elements)
  {
    Set<E> set = newConcurrentHashSet();
    Iterables.addAll(set, elements);
    return set;
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet()
  {
    return new LinkedHashSet();
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize)
  {
    return new LinkedHashSet(Maps.capacity(expectedSize));
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> elements)
  {
    if ((elements instanceof Collection)) {
      return new LinkedHashSet(Collections2.cast(elements));
    }
    LinkedHashSet<E> set = newLinkedHashSet();
    Iterables.addAll(set, elements);
    return set;
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet()
  {
    return new TreeSet();
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> elements)
  {
    TreeSet<E> set = newTreeSet();
    Iterables.addAll(set, elements);
    return set;
  }
  
  public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator)
  {
    return new TreeSet((Comparator)Preconditions.checkNotNull(comparator));
  }
  
  public static <E> Set<E> newIdentityHashSet()
  {
    return newSetFromMap(Maps.newIdentityHashMap());
  }
  
  @GwtIncompatible("CopyOnWriteArraySet")
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet()
  {
    return new CopyOnWriteArraySet();
  }
  
  @GwtIncompatible("CopyOnWriteArraySet")
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> elements)
  {
    Collection<? extends E> elementsCollection = (elements instanceof Collection) ? Collections2.cast(elements) : Lists.newArrayList(elements);
    
    return new CopyOnWriteArraySet(elementsCollection);
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection)
  {
    if ((collection instanceof EnumSet)) {
      return EnumSet.complementOf((EnumSet)collection);
    }
    Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
    
    Class<E> type = ((Enum)collection.iterator().next()).getDeclaringClass();
    return makeComplementByHand(collection, type);
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> type)
  {
    Preconditions.checkNotNull(collection);
    return (collection instanceof EnumSet) ? EnumSet.complementOf((EnumSet)collection) : makeComplementByHand(collection, type);
  }
  
  private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> type)
  {
    EnumSet<E> result = EnumSet.allOf(type);
    result.removeAll(collection);
    return result;
  }
  
  public static <E> Set<E> newSetFromMap(Map<E, Boolean> map)
  {
    return Platform.newSetFromMap(map);
  }
  
  public static abstract class SetView<E>
    extends AbstractSet<E>
  {
    public ImmutableSet<E> immutableCopy()
    {
      return ImmutableSet.copyOf(this);
    }
    
    public <S extends Set<E>> S copyInto(S set)
    {
      set.addAll(this);
      return set;
    }
  }
  
  public static <E> SetView<E> union(Set<? extends E> set1, final Set<? extends E> set2)
  {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    
    final Set<? extends E> set2minus1 = difference(set2, set1);
    
    new SetView(set1)
    {
      public int size()
      {
        return val$set1.size() + set2minus1.size();
      }
      
      public boolean isEmpty()
      {
        return (val$set1.isEmpty()) && (set2.isEmpty());
      }
      
      public Iterator<E> iterator()
      {
        return Iterators.unmodifiableIterator(Iterators.concat(val$set1.iterator(), set2minus1.iterator()));
      }
      
      public boolean contains(Object object)
      {
        return (val$set1.contains(object)) || (set2.contains(object));
      }
      
      public <S extends Set<E>> S copyInto(S set)
      {
        set.addAll(val$set1);
        set.addAll(set2);
        return set;
      }
      
      public ImmutableSet<E> immutableCopy()
      {
        return new ImmutableSet.Builder().addAll(val$set1).addAll(set2).build();
      }
    };
  }
  
  public static <E> SetView<E> intersection(Set<E> set1, final Set<?> set2)
  {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    
    final Predicate<Object> inSet2 = Predicates.in(set2);
    new SetView(set1)
    {
      public Iterator<E> iterator()
      {
        return Iterators.filter(val$set1.iterator(), inSet2);
      }
      
      public int size()
      {
        return Iterators.size(iterator());
      }
      
      public boolean isEmpty()
      {
        return !iterator().hasNext();
      }
      
      public boolean contains(Object object)
      {
        return (val$set1.contains(object)) && (set2.contains(object));
      }
      
      public boolean containsAll(Collection<?> collection)
      {
        return (val$set1.containsAll(collection)) && (set2.containsAll(collection));
      }
    };
  }
  
  public static <E> SetView<E> difference(Set<E> set1, final Set<?> set2)
  {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    
    final Predicate<Object> notInSet2 = Predicates.not(Predicates.in(set2));
    new SetView(set1)
    {
      public Iterator<E> iterator()
      {
        return Iterators.filter(val$set1.iterator(), notInSet2);
      }
      
      public int size()
      {
        return Iterators.size(iterator());
      }
      
      public boolean isEmpty()
      {
        return set2.containsAll(val$set1);
      }
      
      public boolean contains(Object element)
      {
        return (val$set1.contains(element)) && (!set2.contains(element));
      }
    };
  }
  
  public static <E> SetView<E> symmetricDifference(Set<? extends E> set1, Set<? extends E> set2)
  {
    Preconditions.checkNotNull(set1, "set1");
    Preconditions.checkNotNull(set2, "set2");
    
    return difference(union(set1, set2), intersection(set1, set2));
  }
  
  public static <E> Set<E> filter(Set<E> unfiltered, Predicate<? super E> predicate)
  {
    if ((unfiltered instanceof SortedSet)) {
      return filter((SortedSet)unfiltered, predicate);
    }
    if ((unfiltered instanceof FilteredSet))
    {
      FilteredSet<E> filtered = (FilteredSet)unfiltered;
      Predicate<E> combinedPredicate = Predicates.and(predicate, predicate);
      
      return new FilteredSet((Set)unfiltered, combinedPredicate);
    }
    return new FilteredSet((Set)Preconditions.checkNotNull(unfiltered), (Predicate)Preconditions.checkNotNull(predicate));
  }
  
  private static class FilteredSet<E>
    extends Collections2.FilteredCollection<E>
    implements Set<E>
  {
    FilteredSet(Set<E> unfiltered, Predicate<? super E> predicate)
    {
      super(predicate);
    }
    
    public boolean equals(@Nullable Object object)
    {
      return Sets.equalsImpl(this, object);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
  
  public static <E> SortedSet<E> filter(SortedSet<E> unfiltered, Predicate<? super E> predicate)
  {
    return Platform.setsFilterSortedSet(unfiltered, predicate);
  }
  
  static <E> SortedSet<E> filterSortedIgnoreNavigable(SortedSet<E> unfiltered, Predicate<? super E> predicate)
  {
    if ((unfiltered instanceof FilteredSet))
    {
      FilteredSet<E> filtered = (FilteredSet)unfiltered;
      Predicate<E> combinedPredicate = Predicates.and(predicate, predicate);
      
      return new FilteredSortedSet((SortedSet)unfiltered, combinedPredicate);
    }
    return new FilteredSortedSet((SortedSet)Preconditions.checkNotNull(unfiltered), (Predicate)Preconditions.checkNotNull(predicate));
  }
  
  private static class FilteredSortedSet<E>
    extends Sets.FilteredSet<E>
    implements SortedSet<E>
  {
    FilteredSortedSet(SortedSet<E> unfiltered, Predicate<? super E> predicate)
    {
      super(predicate);
    }
    
    public Comparator<? super E> comparator()
    {
      return ((SortedSet)unfiltered).comparator();
    }
    
    public SortedSet<E> subSet(E fromElement, E toElement)
    {
      return new FilteredSortedSet(((SortedSet)unfiltered).subSet(fromElement, toElement), predicate);
    }
    
    public SortedSet<E> headSet(E toElement)
    {
      return new FilteredSortedSet(((SortedSet)unfiltered).headSet(toElement), predicate);
    }
    
    public SortedSet<E> tailSet(E fromElement)
    {
      return new FilteredSortedSet(((SortedSet)unfiltered).tailSet(fromElement), predicate);
    }
    
    public E first()
    {
      return (E)iterator().next();
    }
    
    public E last()
    {
      SortedSet<E> sortedUnfiltered = (SortedSet)unfiltered;
      for (;;)
      {
        E element = sortedUnfiltered.last();
        if (predicate.apply(element)) {
          return element;
        }
        sortedUnfiltered = sortedUnfiltered.headSet(element);
      }
    }
  }
  
  @GwtIncompatible("NavigableSet")
  public static <E> NavigableSet<E> filter(NavigableSet<E> unfiltered, Predicate<? super E> predicate)
  {
    if ((unfiltered instanceof FilteredSet))
    {
      FilteredSet<E> filtered = (FilteredSet)unfiltered;
      Predicate<E> combinedPredicate = Predicates.and(predicate, predicate);
      
      return new FilteredNavigableSet((NavigableSet)unfiltered, combinedPredicate);
    }
    return new FilteredNavigableSet((NavigableSet)Preconditions.checkNotNull(unfiltered), (Predicate)Preconditions.checkNotNull(predicate));
  }
  
  @GwtIncompatible("NavigableSet")
  private static class FilteredNavigableSet<E>
    extends Sets.FilteredSortedSet<E>
    implements NavigableSet<E>
  {
    FilteredNavigableSet(NavigableSet<E> unfiltered, Predicate<? super E> predicate)
    {
      super(predicate);
    }
    
    NavigableSet<E> unfiltered()
    {
      return (NavigableSet)unfiltered;
    }
    
    @Nullable
    public E lower(E e)
    {
      return (E)Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }
    
    @Nullable
    public E floor(E e)
    {
      return (E)Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }
    
    public E ceiling(E e)
    {
      return (E)Iterables.getFirst(tailSet(e, true), null);
    }
    
    public E higher(E e)
    {
      return (E)Iterables.getFirst(tailSet(e, false), null);
    }
    
    public E pollFirst()
    {
      return (E)Iterables.removeFirstMatching(unfiltered(), predicate);
    }
    
    public E pollLast()
    {
      return (E)Iterables.removeFirstMatching(unfiltered().descendingSet(), predicate);
    }
    
    public NavigableSet<E> descendingSet()
    {
      return Sets.filter(unfiltered().descendingSet(), predicate);
    }
    
    public Iterator<E> descendingIterator()
    {
      return Iterators.filter(unfiltered().descendingIterator(), predicate);
    }
    
    public E last()
    {
      return (E)descendingIterator().next();
    }
    
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
    {
      return Sets.filter(unfiltered().subSet(fromElement, fromInclusive, toElement, toInclusive), predicate);
    }
    
    public NavigableSet<E> headSet(E toElement, boolean inclusive)
    {
      return Sets.filter(unfiltered().headSet(toElement, inclusive), predicate);
    }
    
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
    {
      return Sets.filter(unfiltered().tailSet(fromElement, inclusive), predicate);
    }
  }
  
  public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> sets)
  {
    return CartesianSet.create(sets);
  }
  
  public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... sets)
  {
    return cartesianProduct(Arrays.asList(sets));
  }
  
  private static final class CartesianSet<E>
    extends ForwardingCollection<List<E>>
    implements Set<List<E>>
  {
    private final transient ImmutableList<ImmutableSet<E>> axes;
    private final transient CartesianList<E> delegate;
    
    static <E> Set<List<E>> create(List<? extends Set<? extends E>> sets)
    {
      ImmutableList.Builder<ImmutableSet<E>> axesBuilder = new ImmutableList.Builder(sets.size());
      for (Set<? extends E> set : sets)
      {
        ImmutableSet<E> copy = ImmutableSet.copyOf(set);
        if (copy.isEmpty()) {
          return ImmutableSet.of();
        }
        axesBuilder.add(copy);
      }
      ImmutableList<ImmutableSet<E>> axes = axesBuilder.build();
      ImmutableList<List<E>> listAxes = new ImmutableList()
      {
        public int size()
        {
          return val$axes.size();
        }
        
        public List<E> get(int index)
        {
          return ((ImmutableSet)val$axes.get(index)).asList();
        }
        
        boolean isPartialView()
        {
          return true;
        }
      };
      return new CartesianSet(axes, new CartesianList(listAxes));
    }
    
    private CartesianSet(ImmutableList<ImmutableSet<E>> axes, CartesianList<E> delegate)
    {
      this.axes = axes;
      this.delegate = delegate;
    }
    
    protected Collection<List<E>> delegate()
    {
      return delegate;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof CartesianSet))
      {
        CartesianSet<?> that = (CartesianSet)object;
        return axes.equals(axes);
      }
      return super.equals(object);
    }
    
    public int hashCode()
    {
      int adjust = size() - 1;
      for (int i = 0; i < axes.size(); i++)
      {
        adjust *= 31;
        adjust = adjust ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
      }
      int hash = 1;
      for (Set<E> axis : axes)
      {
        hash = 31 * hash + size() / axis.size() * axis.hashCode();
        
        hash = hash ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
      }
      hash += adjust;
      return hash ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
  }
  
  @GwtCompatible(serializable=false)
  public static <E> Set<Set<E>> powerSet(Set<E> set)
  {
    return new PowerSet(set);
  }
  
  private static final class SubSet<E>
    extends AbstractSet<E>
  {
    private final ImmutableMap<E, Integer> inputSet;
    private final int mask;
    
    SubSet(ImmutableMap<E, Integer> inputSet, int mask)
    {
      this.inputSet = inputSet;
      this.mask = mask;
    }
    
    public Iterator<E> iterator()
    {
      new UnmodifiableIterator()
      {
        final ImmutableList<E> elements = inputSet.keySet().asList();
        int remainingSetBits = mask;
        
        public boolean hasNext()
        {
          return remainingSetBits != 0;
        }
        
        public E next()
        {
          int index = Integer.numberOfTrailingZeros(remainingSetBits);
          if (index == 32) {
            throw new NoSuchElementException();
          }
          remainingSetBits &= (1 << index ^ 0xFFFFFFFF);
          return (E)elements.get(index);
        }
      };
    }
    
    public int size()
    {
      return Integer.bitCount(mask);
    }
    
    public boolean contains(@Nullable Object o)
    {
      Integer index = (Integer)inputSet.get(o);
      return (index != null) && ((mask & 1 << index.intValue()) != 0);
    }
  }
  
  private static final class PowerSet<E>
    extends AbstractSet<Set<E>>
  {
    final ImmutableMap<E, Integer> inputSet;
    
    PowerSet(Set<E> input)
    {
      ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
      int i = 0;
      for (E e : (Set)Preconditions.checkNotNull(input)) {
        builder.put(e, Integer.valueOf(i++));
      }
      inputSet = builder.build();
      Preconditions.checkArgument(inputSet.size() <= 30, "Too many elements to create power set: %s > 30", new Object[] { Integer.valueOf(inputSet.size()) });
    }
    
    public int size()
    {
      return 1 << inputSet.size();
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<Set<E>> iterator()
    {
      new AbstractIndexedListIterator(size())
      {
        protected Set<E> get(int setBits)
        {
          return new Sets.SubSet(inputSet, setBits);
        }
      };
    }
    
    public boolean contains(@Nullable Object obj)
    {
      if ((obj instanceof Set))
      {
        Set<?> set = (Set)obj;
        return inputSet.keySet().containsAll(set);
      }
      return false;
    }
    
    public boolean equals(@Nullable Object obj)
    {
      if ((obj instanceof PowerSet))
      {
        PowerSet<?> that = (PowerSet)obj;
        return inputSet.equals(inputSet);
      }
      return super.equals(obj);
    }
    
    public int hashCode()
    {
      return inputSet.keySet().hashCode() << inputSet.size() - 1;
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(inputSet));return 10 + str.length() + "powerSet(" + str + ")";
    }
  }
  
  static int hashCodeImpl(Set<?> s)
  {
    int hashCode = 0;
    for (Object o : s)
    {
      hashCode += (o != null ? o.hashCode() : 0);
      
      hashCode = hashCode ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    return hashCode;
  }
  
  static boolean equalsImpl(Set<?> s, @Nullable Object object)
  {
    if (s == object) {
      return true;
    }
    if ((object instanceof Set))
    {
      Set<?> o = (Set)object;
      try
      {
        return (s.size() == o.size()) && (s.containsAll(o));
      }
      catch (NullPointerException ignored)
      {
        return false;
      }
      catch (ClassCastException ignored)
      {
        return false;
      }
    }
    return false;
  }
  
  @GwtIncompatible("NavigableSet")
  public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> set)
  {
    if (((set instanceof ImmutableSortedSet)) || ((set instanceof UnmodifiableNavigableSet))) {
      return set;
    }
    return new UnmodifiableNavigableSet(set);
  }
  
  @GwtIncompatible("NavigableSet")
  static final class UnmodifiableNavigableSet<E>
    extends ForwardingSortedSet<E>
    implements NavigableSet<E>, Serializable
  {
    private final NavigableSet<E> delegate;
    private transient UnmodifiableNavigableSet<E> descendingSet;
    private static final long serialVersionUID = 0L;
    
    UnmodifiableNavigableSet(NavigableSet<E> delegate)
    {
      this.delegate = ((NavigableSet)Preconditions.checkNotNull(delegate));
    }
    
    protected SortedSet<E> delegate()
    {
      return Collections.unmodifiableSortedSet(delegate);
    }
    
    public E lower(E e)
    {
      return (E)delegate.lower(e);
    }
    
    public E floor(E e)
    {
      return (E)delegate.floor(e);
    }
    
    public E ceiling(E e)
    {
      return (E)delegate.ceiling(e);
    }
    
    public E higher(E e)
    {
      return (E)delegate.higher(e);
    }
    
    public E pollFirst()
    {
      throw new UnsupportedOperationException();
    }
    
    public E pollLast()
    {
      throw new UnsupportedOperationException();
    }
    
    public NavigableSet<E> descendingSet()
    {
      UnmodifiableNavigableSet<E> result = descendingSet;
      if (result == null)
      {
        result = descendingSet = new UnmodifiableNavigableSet(delegate.descendingSet());
        
        descendingSet = this;
      }
      return result;
    }
    
    public Iterator<E> descendingIterator()
    {
      return Iterators.unmodifiableIterator(delegate.descendingIterator());
    }
    
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
    {
      return Sets.unmodifiableNavigableSet(delegate.subSet(fromElement, fromInclusive, toElement, toInclusive));
    }
    
    public NavigableSet<E> headSet(E toElement, boolean inclusive)
    {
      return Sets.unmodifiableNavigableSet(delegate.headSet(toElement, inclusive));
    }
    
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
    {
      return Sets.unmodifiableNavigableSet(delegate.tailSet(fromElement, inclusive));
    }
  }
  
  @GwtIncompatible("NavigableSet")
  public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> navigableSet)
  {
    return Synchronized.navigableSet(navigableSet);
  }
  
  static boolean removeAllImpl(Set<?> set, Iterator<?> iterator)
  {
    boolean changed = false;
    while (iterator.hasNext()) {
      changed |= set.remove(iterator.next());
    }
    return changed;
  }
  
  static boolean removeAllImpl(Set<?> set, Collection<?> collection)
  {
    Preconditions.checkNotNull(collection);
    if ((collection instanceof Multiset)) {
      collection = ((Multiset)collection).elementSet();
    }
    if (((collection instanceof Set)) && (collection.size() > set.size())) {
      return Iterators.removeAll(set.iterator(), collection);
    }
    return removeAllImpl(set, collection.iterator());
  }
  
  @GwtIncompatible("NavigableSet")
  static class DescendingSet<E>
    extends ForwardingNavigableSet<E>
  {
    private final NavigableSet<E> forward;
    
    DescendingSet(NavigableSet<E> forward)
    {
      this.forward = forward;
    }
    
    protected NavigableSet<E> delegate()
    {
      return forward;
    }
    
    public E lower(E e)
    {
      return (E)forward.higher(e);
    }
    
    public E floor(E e)
    {
      return (E)forward.ceiling(e);
    }
    
    public E ceiling(E e)
    {
      return (E)forward.floor(e);
    }
    
    public E higher(E e)
    {
      return (E)forward.lower(e);
    }
    
    public E pollFirst()
    {
      return (E)forward.pollLast();
    }
    
    public E pollLast()
    {
      return (E)forward.pollFirst();
    }
    
    public NavigableSet<E> descendingSet()
    {
      return forward;
    }
    
    public Iterator<E> descendingIterator()
    {
      return forward.iterator();
    }
    
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
    {
      return forward.subSet(toElement, toInclusive, fromElement, fromInclusive).descendingSet();
    }
    
    public NavigableSet<E> headSet(E toElement, boolean inclusive)
    {
      return forward.tailSet(toElement, inclusive).descendingSet();
    }
    
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
    {
      return forward.headSet(fromElement, inclusive).descendingSet();
    }
    
    public Comparator<? super E> comparator()
    {
      Comparator<? super E> forwardComparator = forward.comparator();
      if (forwardComparator == null) {
        return Ordering.natural().reverse();
      }
      return reverse(forwardComparator);
    }
    
    private static <T> Ordering<T> reverse(Comparator<T> forward)
    {
      return Ordering.from(forward).reverse();
    }
    
    public E first()
    {
      return (E)forward.last();
    }
    
    public SortedSet<E> headSet(E toElement)
    {
      return standardHeadSet(toElement);
    }
    
    public E last()
    {
      return (E)forward.first();
    }
    
    public SortedSet<E> subSet(E fromElement, E toElement)
    {
      return standardSubSet(fromElement, toElement);
    }
    
    public SortedSet<E> tailSet(E fromElement)
    {
      return standardTailSet(fromElement);
    }
    
    public Iterator<E> iterator()
    {
      return forward.descendingIterator();
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */