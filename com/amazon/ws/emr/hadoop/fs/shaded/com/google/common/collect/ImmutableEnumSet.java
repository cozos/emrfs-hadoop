package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible(serializable=true, emulated=true)
final class ImmutableEnumSet<E extends Enum<E>>
  extends ImmutableSet<E>
{
  private final transient EnumSet<E> delegate;
  private transient int hashCode;
  
  static <E extends Enum<E>> ImmutableSet<E> asImmutable(EnumSet<E> set)
  {
    switch (set.size())
    {
    case 0: 
      return ImmutableSet.of();
    case 1: 
      return ImmutableSet.of(Iterables.getOnlyElement(set));
    }
    return new ImmutableEnumSet(set);
  }
  
  private ImmutableEnumSet(EnumSet<E> delegate)
  {
    this.delegate = delegate;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.unmodifiableIterator(delegate.iterator());
  }
  
  public int size()
  {
    return delegate.size();
  }
  
  public boolean contains(Object object)
  {
    return delegate.contains(object);
  }
  
  public boolean containsAll(Collection<?> collection)
  {
    return delegate.containsAll(collection);
  }
  
  public boolean isEmpty()
  {
    return delegate.isEmpty();
  }
  
  public boolean equals(Object object)
  {
    return (object == this) || (delegate.equals(object));
  }
  
  public int hashCode()
  {
    int result = hashCode;
    return result == 0 ? (hashCode = delegate.hashCode()) : result;
  }
  
  public String toString()
  {
    return delegate.toString();
  }
  
  Object writeReplace()
  {
    return new EnumSerializedForm(delegate);
  }
  
  private static class EnumSerializedForm<E extends Enum<E>>
    implements Serializable
  {
    final EnumSet<E> delegate;
    private static final long serialVersionUID = 0L;
    
    EnumSerializedForm(EnumSet<E> delegate)
    {
      this.delegate = delegate;
    }
    
    Object readResolve()
    {
      return new ImmutableEnumSet(delegate.clone(), null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */