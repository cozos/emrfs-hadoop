package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Floats$FloatArrayAsList
  extends AbstractList<Float>
  implements RandomAccess, Serializable
{
  final float[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Floats$FloatArrayAsList(float[] array)
  {
    this(array, 0, array.length);
  }
  
  Floats$FloatArrayAsList(float[] array, int start, int end)
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
  
  public Float get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Float.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Float)) && (Floats.access$000(array, ((Float)target).floatValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Float))
    {
      int i = Floats.access$000(array, ((Float)target).floatValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Float))
    {
      int i = Floats.access$100(array, ((Float)target).floatValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Float set(int index, Float element)
  {
    Preconditions.checkElementIndex(index, size());
    float oldValue = array[(start + index)];
    
    array[(start + index)] = ((Float)Preconditions.checkNotNull(element)).floatValue();
    return Float.valueOf(oldValue);
  }
  
  public List<Float> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new FloatArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof FloatArrayAsList))
    {
      FloatArrayAsList that = (FloatArrayAsList)object;
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
      result = 31 * result + Floats.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 12);
    builder.append('[').append(array[start]);
    for (int i = start + 1; i < end; i++) {
      builder.append(", ").append(array[i]);
    }
    return ']';
  }
  
  float[] toFloatArray()
  {
    int size = size();
    float[] result = new float[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Floats.FloatArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */