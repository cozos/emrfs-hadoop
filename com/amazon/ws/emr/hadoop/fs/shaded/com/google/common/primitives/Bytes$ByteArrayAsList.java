package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Bytes$ByteArrayAsList
  extends AbstractList<Byte>
  implements RandomAccess, Serializable
{
  final byte[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Bytes$ByteArrayAsList(byte[] array)
  {
    this(array, 0, array.length);
  }
  
  Bytes$ByteArrayAsList(byte[] array, int start, int end)
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
  
  public Byte get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Byte.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Byte)) && (Bytes.access$000(array, ((Byte)target).byteValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Byte))
    {
      int i = Bytes.access$000(array, ((Byte)target).byteValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Byte))
    {
      int i = Bytes.access$100(array, ((Byte)target).byteValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Byte set(int index, Byte element)
  {
    Preconditions.checkElementIndex(index, size());
    byte oldValue = array[(start + index)];
    
    array[(start + index)] = ((Byte)Preconditions.checkNotNull(element)).byteValue();
    return Byte.valueOf(oldValue);
  }
  
  public List<Byte> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new ByteArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof ByteArrayAsList))
    {
      ByteArrayAsList that = (ByteArrayAsList)object;
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
      result = 31 * result + Bytes.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 5);
    builder.append('[').append(array[start]);
    for (int i = start + 1; i < end; i++) {
      builder.append(", ").append(array[i]);
    }
    return ']';
  }
  
  byte[] toByteArray()
  {
    int size = size();
    byte[] result = new byte[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Bytes.ByteArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */