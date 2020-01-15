package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Doubles$DoubleArrayAsList
  extends AbstractList<Double>
  implements RandomAccess, Serializable
{
  final double[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Doubles$DoubleArrayAsList(double[] array)
  {
    this(array, 0, array.length);
  }
  
  Doubles$DoubleArrayAsList(double[] array, int start, int end)
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
  
  public Double get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Double.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Double)) && (Doubles.access$000(array, ((Double)target).doubleValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Double))
    {
      int i = Doubles.access$000(array, ((Double)target).doubleValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Double))
    {
      int i = Doubles.access$100(array, ((Double)target).doubleValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Double set(int index, Double element)
  {
    Preconditions.checkElementIndex(index, size());
    double oldValue = array[(start + index)];
    
    array[(start + index)] = ((Double)Preconditions.checkNotNull(element)).doubleValue();
    return Double.valueOf(oldValue);
  }
  
  public List<Double> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new DoubleArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof DoubleArrayAsList))
    {
      DoubleArrayAsList that = (DoubleArrayAsList)object;
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
      result = 31 * result + Doubles.hashCode(array[i]);
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
  
  double[] toDoubleArray()
  {
    int size = size();
    double[] result = new double[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Doubles.DoubleArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */