package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class OpenIntToDoubleHashMap$Iterator
{
  private final int referenceCount;
  private int current;
  private int next;
  
  private OpenIntToDoubleHashMap$Iterator(OpenIntToDoubleHashMap arg1)
  {
    referenceCount = OpenIntToDoubleHashMap.access$100(???);
    
    next = -1;
    try
    {
      advance();
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    ???;
  }
  
  public boolean hasNext()
  {
    return next >= 0;
  }
  
  public int key()
    throws ConcurrentModificationException, NoSuchElementException
  {
    if (referenceCount != OpenIntToDoubleHashMap.access$100(this$0)) {
      throw MathRuntimeException.createConcurrentModificationException("map has been modified while iterating", new Object[0]);
    }
    if (current < 0) {
      throw MathRuntimeException.createNoSuchElementException("iterator exhausted", new Object[0]);
    }
    return OpenIntToDoubleHashMap.access$200(this$0)[current];
  }
  
  public double value()
    throws ConcurrentModificationException, NoSuchElementException
  {
    if (referenceCount != OpenIntToDoubleHashMap.access$100(this$0)) {
      throw MathRuntimeException.createConcurrentModificationException("map has been modified while iterating", new Object[0]);
    }
    if (current < 0) {
      throw MathRuntimeException.createNoSuchElementException("iterator exhausted", new Object[0]);
    }
    return OpenIntToDoubleHashMap.access$300(this$0)[current];
  }
  
  public void advance()
    throws ConcurrentModificationException, NoSuchElementException
  {
    if (referenceCount != OpenIntToDoubleHashMap.access$100(this$0)) {
      throw MathRuntimeException.createConcurrentModificationException("map has been modified while iterating", new Object[0]);
    }
    current = next;
    try
    {
      while (OpenIntToDoubleHashMap.access$400(this$0)[(++next)] != 1) {}
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      next = -2;
      if (current < 0) {
        throw MathRuntimeException.createNoSuchElementException("iterator exhausted", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.OpenIntToDoubleHashMap.Iterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */