package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

class FastFourierTransformer$RootsOfUnity
  implements Serializable
{
  private static final long serialVersionUID = 6404784357747329667L;
  private int omegaCount;
  private double[] omegaReal;
  private double[] omegaImaginaryForward;
  private double[] omegaImaginaryInverse;
  private boolean isForward;
  
  public FastFourierTransformer$RootsOfUnity()
  {
    omegaCount = 0;
    omegaReal = null;
    omegaImaginaryForward = null;
    omegaImaginaryInverse = null;
    isForward = true;
  }
  
  public synchronized boolean isForward()
    throws IllegalStateException
  {
    if (omegaCount == 0) {
      throw MathRuntimeException.createIllegalStateException("roots of unity have not been computed yet", new Object[0]);
    }
    return isForward;
  }
  
  public synchronized void computeOmega(int n)
    throws IllegalArgumentException
  {
    if (n == 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot compute 0-th root of unity, indefinite result", new Object[0]);
    }
    isForward = (n > 0);
    
    int absN = Math.abs(n);
    if (absN == omegaCount) {
      return;
    }
    double t = 6.283185307179586D / absN;
    double cosT = Math.cos(t);
    double sinT = Math.sin(t);
    omegaReal = new double[absN];
    omegaImaginaryForward = new double[absN];
    omegaImaginaryInverse = new double[absN];
    omegaReal[0] = 1.0D;
    omegaImaginaryForward[0] = 0.0D;
    omegaImaginaryInverse[0] = 0.0D;
    for (int i = 1; i < absN; i++)
    {
      omegaReal[i] = (omegaReal[(i - 1)] * cosT + omegaImaginaryForward[(i - 1)] * sinT);
      
      omegaImaginaryForward[i] = (omegaImaginaryForward[(i - 1)] * cosT - omegaReal[(i - 1)] * sinT);
      
      omegaImaginaryInverse[i] = (-omegaImaginaryForward[i]);
    }
    omegaCount = absN;
  }
  
  public synchronized double getOmegaReal(int k)
    throws IllegalStateException, IllegalArgumentException
  {
    if (omegaCount == 0) {
      throw MathRuntimeException.createIllegalStateException("roots of unity have not been computed yet", new Object[0]);
    }
    if ((k < 0) || (k >= omegaCount)) {
      throw MathRuntimeException.createIllegalArgumentException("out of range root of unity index {0} (must be in [{1};{2}])", new Object[] { Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(omegaCount - 1) });
    }
    return omegaReal[k];
  }
  
  public synchronized double getOmegaImaginary(int k)
    throws IllegalStateException, IllegalArgumentException
  {
    if (omegaCount == 0) {
      throw MathRuntimeException.createIllegalStateException("roots of unity have not been computed yet", new Object[0]);
    }
    if ((k < 0) || (k >= omegaCount)) {
      throw MathRuntimeException.createIllegalArgumentException("out of range root of unity index {0} (must be in [{1};{2}])", new Object[] { Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(omegaCount - 1) });
    }
    return isForward ? omegaImaginaryForward[k] : omegaImaginaryInverse[k];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform.FastFourierTransformer.RootsOfUnity
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */