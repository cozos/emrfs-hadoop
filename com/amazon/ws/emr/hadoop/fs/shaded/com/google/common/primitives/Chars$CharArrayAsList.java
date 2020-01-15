package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Chars$CharArrayAsList
  extends AbstractList<Character>
  implements RandomAccess, Serializable
{
  final char[] array;
  final int start;
  final int end;
  private static final long serialVersionUID = 0L;
  
  Chars$CharArrayAsList(char[] array)
  {
    this(array, 0, array.length);
  }
  
  Chars$CharArrayAsList(char[] array, int start, int end)
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
  
  public Character get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return Character.valueOf(array[(start + index)]);
  }
  
  public boolean contains(Object target)
  {
    return ((target instanceof Character)) && (Chars.access$000(array, ((Character)target).charValue(), start, end) != -1);
  }
  
  public int indexOf(Object target)
  {
    if ((target instanceof Character))
    {
      int i = Chars.access$000(array, ((Character)target).charValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if ((target instanceof Character))
    {
      int i = Chars.access$100(array, ((Character)target).charValue(), start, end);
      if (i >= 0) {
        return i - start;
      }
    }
    return -1;
  }
  
  public Character set(int index, Character element)
  {
    Preconditions.checkElementIndex(index, size());
    char oldValue = array[(start + index)];
    
    array[(start + index)] = ((Character)Preconditions.checkNotNull(element)).charValue();
    return Character.valueOf(oldValue);
  }
  
  public List<Character> subList(int fromIndex, int toIndex)
  {
    int size = size();
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    if (fromIndex == toIndex) {
      return Collections.emptyList();
    }
    return new CharArrayAsList(array, start + fromIndex, start + toIndex);
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof CharArrayAsList))
    {
      CharArrayAsList that = (CharArrayAsList)object;
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
      result = 31 * result + Chars.hashCode(array[i]);
    }
    return result;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(size() * 3);
    builder.append('[').append(array[start]);
    for (int i = start + 1; i < end; i++) {
      builder.append(", ").append(array[i]);
    }
    return ']';
  }
  
  char[] toCharArray()
  {
    int size = size();
    char[] result = new char[size];
    System.arraycopy(array, start, result, 0, size);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Chars.CharArrayAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */