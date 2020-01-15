package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Booleans
{
  public static int hashCode(boolean value)
  {
    return value ? 1231 : 1237;
  }
  
  public static int compare(boolean a, boolean b)
  {
    return a ? 1 : a == b ? 0 : -1;
  }
  
  public static boolean contains(boolean[] array, boolean target)
  {
    for (boolean value : array) {
      if (value == target) {
        return true;
      }
    }
    return false;
  }
  
  public static int indexOf(boolean[] array, boolean target)
  {
    return indexOf(array, target, 0, array.length);
  }
  
  private static int indexOf(boolean[] array, boolean target, int start, int end)
  {
    for (int i = start; i < end; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }
  
  public static int indexOf(boolean[] array, boolean[] target)
  {
    Preconditions.checkNotNull(array, "array");
    Preconditions.checkNotNull(target, "target");
    if (target.length == 0) {
      return 0;
    }
    label64:
    for (int i = 0; i < array.length - target.length + 1; i++)
    {
      for (int j = 0; j < target.length; j++) {
        if (array[(i + j)] != target[j]) {
          break label64;
        }
      }
      return i;
    }
    return -1;
  }
  
  public static int lastIndexOf(boolean[] array, boolean target)
  {
    return lastIndexOf(array, target, 0, array.length);
  }
  
  private static int lastIndexOf(boolean[] array, boolean target, int start, int end)
  {
    for (int i = end - 1; i >= start; i--) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }
  
  public static boolean[] concat(boolean[]... arrays)
  {
    int length = 0;
    for (boolean[] array : arrays) {
      length += array.length;
    }
    boolean[] result = new boolean[length];
    int pos = 0;
    for (boolean[] array : arrays)
    {
      System.arraycopy(array, 0, result, pos, array.length);
      pos += array.length;
    }
    return result;
  }
  
  public static boolean[] ensureCapacity(boolean[] array, int minLength, int padding)
  {
    Preconditions.checkArgument(minLength >= 0, "Invalid minLength: %s", new Object[] { Integer.valueOf(minLength) });
    Preconditions.checkArgument(padding >= 0, "Invalid padding: %s", new Object[] { Integer.valueOf(padding) });
    return array.length < minLength ? copyOf(array, minLength + padding) : array;
  }
  
  private static boolean[] copyOf(boolean[] original, int length)
  {
    boolean[] copy = new boolean[length];
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, length));
    return copy;
  }
  
  public static String join(String separator, boolean... array)
  {
    Preconditions.checkNotNull(separator);
    if (array.length == 0) {
      return "";
    }
    StringBuilder builder = new StringBuilder(array.length * 7);
    builder.append(array[0]);
    for (int i = 1; i < array.length; i++) {
      builder.append(separator).append(array[i]);
    }
    return builder.toString();
  }
  
  public static Comparator<boolean[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  private static enum LexicographicalComparator
    implements Comparator<boolean[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(boolean[] left, boolean[] right)
    {
      int minLength = Math.min(left.length, right.length);
      for (int i = 0; i < minLength; i++)
      {
        int result = Booleans.compare(left[i], right[i]);
        if (result != 0) {
          return result;
        }
      }
      return left.length - right.length;
    }
  }
  
  public static boolean[] toArray(Collection<Boolean> collection)
  {
    if ((collection instanceof BooleanArrayAsList)) {
      return ((BooleanArrayAsList)collection).toBooleanArray();
    }
    Object[] boxedArray = collection.toArray();
    int len = boxedArray.length;
    boolean[] array = new boolean[len];
    for (int i = 0; i < len; i++) {
      array[i] = ((Boolean)Preconditions.checkNotNull(boxedArray[i])).booleanValue();
    }
    return array;
  }
  
  public static List<Boolean> asList(boolean... backingArray)
  {
    if (backingArray.length == 0) {
      return Collections.emptyList();
    }
    return new BooleanArrayAsList(backingArray);
  }
  
  @GwtCompatible
  private static class BooleanArrayAsList
    extends AbstractList<Boolean>
    implements RandomAccess, Serializable
  {
    final boolean[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0L;
    
    BooleanArrayAsList(boolean[] array)
    {
      this(array, 0, array.length);
    }
    
    BooleanArrayAsList(boolean[] array, int start, int end)
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
      return ((target instanceof Boolean)) && (Booleans.indexOf(array, ((Boolean)target).booleanValue(), start, end) != -1);
    }
    
    public int indexOf(Object target)
    {
      if ((target instanceof Boolean))
      {
        int i = Booleans.indexOf(array, ((Boolean)target).booleanValue(), start, end);
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
        int i = Booleans.lastIndexOf(array, ((Boolean)target).booleanValue(), start, end);
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
  
  @Beta
  public static int countTrue(boolean... values)
  {
    int count = 0;
    for (boolean value : values) {
      if (value) {
        count++;
      }
    }
    return count;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Booleans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */