package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class SingletonImmutableSet<E>
  extends ImmutableSet<E>
{
  final transient E element;
  private transient int cachedHashCode;
  
  SingletonImmutableSet(E element)
  {
    this.element = Preconditions.checkNotNull(element);
  }
  
  SingletonImmutableSet(E element, int hashCode)
  {
    this.element = element;
    cachedHashCode = hashCode;
  }
  
  public int size()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean contains(Object target)
  {
    return element.equals(target);
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.singletonIterator(element);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  int copyIntoArray(Object[] dst, int offset)
  {
    dst[offset] = element;
    return offset + 1;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof Set))
    {
      Set<?> that = (Set)object;
      return (that.size() == 1) && (element.equals(that.iterator().next()));
    }
    return false;
  }
  
  public final int hashCode()
  {
    int code = cachedHashCode;
    if (code == 0) {
      cachedHashCode = (code = element.hashCode());
    }
    return code;
  }
  
  boolean isHashCodeFast()
  {
    return cachedHashCode != 0;
  }
  
  public String toString()
  {
    String elementToString = element.toString();
    return elementToString.length() + 2 + '[' + elementToString + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SingletonImmutableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */