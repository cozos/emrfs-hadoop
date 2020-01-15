package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

public abstract interface DoubleArray
{
  public abstract int getNumElements();
  
  public abstract double getElement(int paramInt);
  
  public abstract void setElement(int paramInt, double paramDouble);
  
  public abstract void addElement(double paramDouble);
  
  public abstract double addElementRolling(double paramDouble);
  
  public abstract double[] getElements();
  
  public abstract void clear();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.DoubleArray
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */