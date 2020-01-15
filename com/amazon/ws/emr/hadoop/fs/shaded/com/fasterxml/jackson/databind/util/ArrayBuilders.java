package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ArrayBuilders
{
  private BooleanBuilder _booleanBuilder = null;
  private ByteBuilder _byteBuilder = null;
  private ShortBuilder _shortBuilder = null;
  private IntBuilder _intBuilder = null;
  private LongBuilder _longBuilder = null;
  private FloatBuilder _floatBuilder = null;
  private DoubleBuilder _doubleBuilder = null;
  
  public BooleanBuilder getBooleanBuilder()
  {
    if (_booleanBuilder == null) {
      _booleanBuilder = new BooleanBuilder();
    }
    return _booleanBuilder;
  }
  
  public ByteBuilder getByteBuilder()
  {
    if (_byteBuilder == null) {
      _byteBuilder = new ByteBuilder();
    }
    return _byteBuilder;
  }
  
  public ShortBuilder getShortBuilder()
  {
    if (_shortBuilder == null) {
      _shortBuilder = new ShortBuilder();
    }
    return _shortBuilder;
  }
  
  public IntBuilder getIntBuilder()
  {
    if (_intBuilder == null) {
      _intBuilder = new IntBuilder();
    }
    return _intBuilder;
  }
  
  public LongBuilder getLongBuilder()
  {
    if (_longBuilder == null) {
      _longBuilder = new LongBuilder();
    }
    return _longBuilder;
  }
  
  public FloatBuilder getFloatBuilder()
  {
    if (_floatBuilder == null) {
      _floatBuilder = new FloatBuilder();
    }
    return _floatBuilder;
  }
  
  public DoubleBuilder getDoubleBuilder()
  {
    if (_doubleBuilder == null) {
      _doubleBuilder = new DoubleBuilder();
    }
    return _doubleBuilder;
  }
  
  public static final class BooleanBuilder
    extends PrimitiveArrayBuilder<boolean[]>
  {
    public final boolean[] _constructArray(int len)
    {
      return new boolean[len];
    }
  }
  
  public static final class ByteBuilder
    extends PrimitiveArrayBuilder<byte[]>
  {
    public final byte[] _constructArray(int len)
    {
      return new byte[len];
    }
  }
  
  public static final class ShortBuilder
    extends PrimitiveArrayBuilder<short[]>
  {
    public final short[] _constructArray(int len)
    {
      return new short[len];
    }
  }
  
  public static final class IntBuilder
    extends PrimitiveArrayBuilder<int[]>
  {
    public final int[] _constructArray(int len)
    {
      return new int[len];
    }
  }
  
  public static final class LongBuilder
    extends PrimitiveArrayBuilder<long[]>
  {
    public final long[] _constructArray(int len)
    {
      return new long[len];
    }
  }
  
  public static final class FloatBuilder
    extends PrimitiveArrayBuilder<float[]>
  {
    public final float[] _constructArray(int len)
    {
      return new float[len];
    }
  }
  
  public static final class DoubleBuilder
    extends PrimitiveArrayBuilder<double[]>
  {
    public final double[] _constructArray(int len)
    {
      return new double[len];
    }
  }
  
  public static Object getArrayComparator(final Object defaultValue)
  {
    final int length = Array.getLength(defaultValue);
    Class<?> defaultValueType = defaultValue.getClass();
    new Object()
    {
      public boolean equals(Object other)
      {
        if (other == this) {
          return true;
        }
        if ((other == null) || (other.getClass() != val$defaultValueType)) {
          return false;
        }
        if (Array.getLength(other) != length) {
          return false;
        }
        for (int i = 0; i < length; i++)
        {
          Object value1 = Array.get(defaultValue, i);
          Object value2 = Array.get(other, i);
          if ((value1 != value2) && 
            (value1 != null) && 
            (!value1.equals(value2))) {
            return false;
          }
        }
        return true;
      }
    };
  }
  
  public static <T> HashSet<T> arrayToSet(T[] elements)
  {
    HashSet<T> result = new HashSet();
    if (elements != null) {
      for (T elem : elements) {
        result.add(elem);
      }
    }
    return result;
  }
  
  public static <T> ArrayList<T> arrayToList(T[] elements)
  {
    ArrayList<T> result = new ArrayList();
    if (elements != null) {
      for (T elem : elements) {
        result.add(elem);
      }
    }
    return result;
  }
  
  public static <T> HashSet<T> setAndArray(Set<T> set, T[] elements)
  {
    HashSet<T> result = new HashSet();
    if (set != null) {
      result.addAll(set);
    }
    if (elements != null) {
      for (T value : elements) {
        result.add(value);
      }
    }
    return result;
  }
  
  public static <T> List<T> addToList(List<T> list, T element)
  {
    if (list == null) {
      list = new ArrayList();
    }
    list.add(element);
    return list;
  }
  
  public static <T> T[] insertInList(T[] array, T element)
  {
    int len = array.length;
    
    T[] result = (Object[])Array.newInstance(array.getClass().getComponentType(), len + 1);
    if (len > 0) {
      System.arraycopy(array, 0, result, 1, len);
    }
    result[0] = element;
    return result;
  }
  
  public static <T> T[] insertInListNoDup(T[] array, T element)
  {
    int len = array.length;
    for (int ix = 0; ix < len; ix++) {
      if (array[ix] == element)
      {
        if (ix == 0) {
          return array;
        }
        T[] result = (Object[])Array.newInstance(array.getClass().getComponentType(), len);
        System.arraycopy(array, 0, result, 1, ix);
        result[0] = element;
        ix++;
        int left = len - ix;
        if (left > 0) {
          System.arraycopy(array, ix, result, ix, left);
        }
        return result;
      }
    }
    T[] result = (Object[])Array.newInstance(array.getClass().getComponentType(), len + 1);
    if (len > 0) {
      System.arraycopy(array, 0, result, 1, len);
    }
    result[0] = element;
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */