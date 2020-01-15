package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Booleans$BooleanArrayAsList
  extends AbstractList<Boolean>
  implements RandomAccess, Serializable
{
  final boolean[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Booleans$BooleanArrayAsList(boolean[] array)
  {
    this(array, 0, array.length);
  }
  
  Booleans$BooleanArrayAsList(boolean[] array, int start, int end)
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
  
  public Boolean get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Boolean.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Boolean)) && (Booleans.access$000(array, ((Boolean)target).booleanValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Boolean))
    {
      int i = Booleans.access$000(array, ((Boolean)target).booleanValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Boolean))
    {
      int i = Booleans.access$100(array, ((Boolean)target).booleanValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Boolean set(int index, Boolean element)
  {
    Preconditions.checkElementIndex(index, size());
    boolean oldValue = array[(start + index)];
    
    array[(start + index)] = ((Boolean)Preconditions.checkNotNull(element)).booleanValue();
    return Boolean.valueOf(oldValue);
  }
  
  public List<Boolean> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new BooleanArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof BooleanArrayAsList))
    {
      BooleanArrayAsList that = (BooleanArrayAsList)object;
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
      result = 31 * result + Booleans.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 7);
    builder.append(array[start] != 0 ? "[true" : "[false");
    for (int i = start + 1; i < end; i++) {
      builder.append(array[i] != 0 ? ", true" : ", false");
    }
    return ']';
  }
  
  boolean[] toBooleanArray()
  {
    int size = size();
    boolean[] result = new boolean[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Booleans.BooleanArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */