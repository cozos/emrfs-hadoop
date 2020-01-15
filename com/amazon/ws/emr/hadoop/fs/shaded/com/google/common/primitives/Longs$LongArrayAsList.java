package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Longs$LongArrayAsList
  extends AbstractList<Long>
  implements RandomAccess, Serializable
{
  final long[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Longs$LongArrayAsList(long[] array)
  {
    this(array, 0, array.length);
  }
  
  Longs$LongArrayAsList(long[] array, int start, int end)
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
  
  public Long get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Long.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Long)) && (Longs.access$000(array, ((Long)target).longValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Long))
    {
      int i = Longs.access$000(array, ((Long)target).longValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Long))
    {
      int i = Longs.access$100(array, ((Long)target).longValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Long set(int index, Long element)
  {
    Preconditions.checkElementIndex(index, size());
    long oldValue = array[(start + index)];
    
    array[(start + index)] = ((Long)Preconditions.checkNotNull(element)).longValue();
    return Long.valueOf(oldValue);
  }
  
  public List<Long> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new LongArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof LongArrayAsList))
    {
      LongArrayAsList that = (LongArrayAsList)object;
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
      result = 31 * result + Longs.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 10);
    builder.append('[').append(array[start]);
    for (int i = start + 1; i < end; i++) {
      builder.append(", ").append(array[i]);
    }
    return ']';
  }
  
  long[] toLongArray()
  {
    int size = size();
    long[] result = new long[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Longs.LongArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */