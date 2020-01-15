package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex.Complex;
import java.lang.reflect.Array;

class FastFourierTransformer$MultiDimensionalComplexMatrix
  implements Cloneable
{
  protected int[] dimensionSize;
  protected Object multiDimensionalComplexArray;
  
  public FastFourierTransformer$MultiDimensionalComplexMatrix(Object multiDimensionalComplexArray)
  {
    this.multiDimensionalComplexArray = multiDimensionalComplexArray;
    
    int numOfDimensions = 0;
    Object lastDimension = multiDimensionalComplexArray;
    while ((lastDimension instanceof Object[]))
    {
      Object[] array = (Object[])lastDimension;
      numOfDimensions++;
      lastDimension = array[0];
    }
    dimensionSize = new int[numOfDimensions];
    
    numOfDimensions = 0;
    Object lastDimension = multiDimensionalComplexArray;
    while ((lastDimension instanceof Object[]))
    {
      Object[] array = (Object[])lastDimension;
      dimensionSize[(numOfDimensions++)] = array.length;
      lastDimension = array[0];
    }
  }
  
  public Complex get(int... vector)
    throws IllegalArgumentException
  {
    if (vector == null)
    {
      if (dimensionSize.length > 0) {
        throw MathRuntimeException.createIllegalArgumentException("some dimensions don't match: {0} != {1}", new Object[] { Integer.valueOf(0), Integer.valueOf(dimensionSize.length) });
      }
      return null;
    }
    if (vector.length != dimensionSize.length) {
      throw MathRuntimeException.createIllegalArgumentException("some dimensions don't match: {0} != {1}", new Object[] { Integer.valueOf(vector.length), Integer.valueOf(dimensionSize.length) });
    }
    Object lastDimension = multiDimensionalComplexArray;
    for (int i = 0; i < dimensionSize.length; i++) {
      lastDimension = ((Object[])(Object[])lastDimension)[vector[i]];
    }
    return (Complex)lastDimension;
  }
  
  public Complex set(Complex magnitude, int... vector)
    throws IllegalArgumentException
  {
    if (vector == null)
    {
      if (dimensionSize.length > 0) {
        throw MathRuntimeException.createIllegalArgumentException("some dimensions don't match: {0} != {1}", new Object[] { Integer.valueOf(0), Integer.valueOf(dimensionSize.length) });
      }
      return null;
    }
    if (vector.length != dimensionSize.length) {
      throw MathRuntimeException.createIllegalArgumentException("some dimensions don't match: {0} != {1}", new Object[] { Integer.valueOf(vector.length), Integer.valueOf(dimensionSize.length) });
    }
    Object[] lastDimension = (Object[])multiDimensionalComplexArray;
    for (int i = 0; i < dimensionSize.length - 1; i++) {
      lastDimension = (Object[])lastDimension[vector[i]];
    }
    Complex lastValue = (Complex)lastDimension[vector[(dimensionSize.length - 1)]];
    lastDimension[vector[(dimensionSize.length - 1)]] = magnitude;
    
    return lastValue;
  }
  
  public int[] getDimensionSizes()
  {
    return (int[])dimensionSize.clone();
  }
  
  public Object getArray()
  {
    return multiDimensionalComplexArray;
  }
  
  public Object clone()
  {
    MultiDimensionalComplexMatrix mdcm = new MultiDimensionalComplexMatrix(Array.newInstance(Complex.class, dimensionSize));
    
    clone(mdcm);
    return mdcm;
  }
  
  private void clone(MultiDimensionalComplexMatrix mdcm)
  {
    int[] vector = new int[dimensionSize.length];
    int size = 1;
    for (int i = 0; i < dimensionSize.length; i++) {
      size *= dimensionSize[i];
    }
    int[][] vectorList = new int[size][dimensionSize.length];
    for (int[] nextVector : vectorList)
    {
      System.arraycopy(vector, 0, nextVector, 0, dimensionSize.length);
      for (int i = 0; i < dimensionSize.length; i++)
      {
        vector[i] += 1;
        if (vector[i] < dimensionSize[i]) {
          break;
        }
        vector[i] = 0;
      }
    }
    for (int[] nextVector : vectorList) {
      mdcm.set(get(nextVector), nextVector);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform.FastFourierTransformer.MultiDimensionalComplexMatrix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */