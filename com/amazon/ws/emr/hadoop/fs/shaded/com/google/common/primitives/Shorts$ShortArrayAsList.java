package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Shorts$ShortArrayAsList
  extends AbstractList<Short>
  implements RandomAccess, Serializable
{
  final short[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Shorts$ShortArrayAsList(short[] array)
  {
    this(array, 0, array.length);
  }
  
  Shorts$ShortArrayAsList(short[] array, int start, int end)
  {
    this.array = array;
    this.start = start;
    this.end = end;
  }
  
  public int size()
  {
    return end - start;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Short get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Short.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Short)) && (Shorts.access$000(array, ((Short)target).shortValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Short))
    {
      int i = Shorts.access$000(array, ((Short)target).shortValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Short))
    {
      int i = Shorts.access$100(array, ((Short)target).shortValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Short set(int index, Short element)
  {
    Preconditions.checkElementIndex(index, size());
    short oldValue = array[(start + index)];
    
    array[(start + index)] = ((Short)Preconditions.checkNotNull(element)).shortValue();
    return Short.valueOf(oldValue);
  }
  
  public List<Short> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new ShortArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof ShortArrayAsList))
    {
      ShortArrayAsList that = (ShortArrayAsList)object;
      int size = size();
      if (that.size() != size) {
        return false;
      }
      for (int i = 0; i < size; i++) {
        if (array[(start + i)] != array[(start + i)]) {
          return false;
        }
      }
      return true;
    }
    return super.equals(object);
  }
  
  public int hashCode()
  {
    int result = 1;
    for (int i = start; i < end; i++) {
      result = 31 * result + Shorts.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 6);
    builder.append('[').append(array[start]);
    for (int i = start + 1; i < end; i++) {
      builder.append(", ").append(array[i]);
    }
    return ']';
  }
  
  short[] toShortArray()
  {
    int size = size();
    short[] result = new short[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Shorts.ShortArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */