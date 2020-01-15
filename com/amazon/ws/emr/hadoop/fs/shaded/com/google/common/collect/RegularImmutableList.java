package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
class RegularImmutableList<E>
  extends ImmutableList<E>
{
  private final transient int offset;
  private final transient int size;
  private final transient Object[] array;
  
  RegularImmutableList(Object[] array, int offset, int size)
  {
    this.offset = offset;
    this.size = size;
    this.array = array;
  }
  
  RegularImmutableList(Object[] array)
  {
    this(array, 0, array.length);
  }
  
  public int size()
  {
    return size;
  }
  
  boolean isPartialView()
  {
    return size != array.length;
  }
  
  int copyIntoArray(Object[] dst, int dstOff)
  {
    System.arraycopy(array, offset, dst, dstOff, size);
    return dstOff + size;
  }
  
  public E get(int index)
  {
    Preconditions.checkElementIndex(index, size);
    return (E)array[(index + offset)];
  }
  
  public int indexOf(@Nullable Object object)
  {
    if (object == null) {
      return -1;
    }
    for (int i = 0; i < size; i++) {
      if (array[(offset + i)].equals(object)) {
        return i;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(@Nullable Object object)
  {
    if (object == null) {
      return -1;
    }
    for (int i = size - 1; i >= 0; i--) {
      if (array[(offset + i)].equals(object)) {
        return i;
      }
    }
    return -1;
  }
  
  ImmutableList<E> subListUnchecked(int fromIndex, int toIndex)
  {
    return new RegularImmutableList(array, offset + fromIndex, toIndex - fromIndex);
  }
  
  public UnmodifiableListIterator<E> listIterator(int index)
  {
    return Iterators.forArray(array, offset, size, index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */