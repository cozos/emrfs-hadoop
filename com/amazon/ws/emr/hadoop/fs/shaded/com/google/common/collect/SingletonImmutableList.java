package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class SingletonImmutableList<E>
  extends ImmutableList<E>
{
  final transient E element;
  
  SingletonImmutableList(E element)
  {
    this.element = Preconditions.checkNotNull(element);
  }
  
  public E get(int index)
  {
    Preconditions.checkElementIndex(index, 1);
    return (E)element;
  }
  
  public int indexOf(@Nullable Object object)
  {
    return element.equals(object) ? 0 : -1;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.singletonIterator(element);
  }
  
  public int lastIndexOf(@Nullable Object object)
  {
    return indexOf(object);
  }
  
  public int size()
  {
    return 1;
  }
  
  public ImmutableList<E> subList(int fromIndex, int toIndex)
  {
    Preconditions.checkPositionIndexes(fromIndex, toIndex, 1);
    return fromIndex == toIndex ? ImmutableList.of() : this;
  }
  
  public ImmutableList<E> reverse()
  {
    return this;
  }
  
  public boolean contains(@Nullable Object object)
  {
    return element.equals(object);
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof List))
    {
      List<?> that = (List)object;
      return (that.size() == 1) && (element.equals(that.get(0)));
    }
    return false;
  }
  
  public int hashCode()
  {
    return 31 + element.hashCode();
  }
  
  public String toString()
  {
    String elementToString = element.toString();
    return elementToString.length() + 2 + '[' + elementToString + ']';
  }
  
  public boolean isEmpty()
  {
    return false;
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SingletonImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */