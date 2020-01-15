package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import java.util.Iterator;

public abstract interface RealVector
{
  public abstract RealVector mapToSelf(UnivariateRealFunction paramUnivariateRealFunction)
    throws FunctionEvaluationException;
  
  public abstract RealVector map(UnivariateRealFunction paramUnivariateRealFunction)
    throws FunctionEvaluationException;
  
  public abstract Iterator<Entry> iterator();
  
  public abstract Iterator<Entry> sparseIterator();
  
  public abstract RealVector copy();
  
  public abstract RealVector add(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealVector add(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract RealVector subtract(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealVector subtract(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract RealVector mapAdd(double paramDouble);
  
  public abstract RealVector mapAddToSelf(double paramDouble);
  
  public abstract RealVector mapSubtract(double paramDouble);
  
  public abstract RealVector mapSubtractToSelf(double paramDouble);
  
  public abstract RealVector mapMultiply(double paramDouble);
  
  public abstract RealVector mapMultiplyToSelf(double paramDouble);
  
  public abstract RealVector mapDivide(double paramDouble);
  
  public abstract RealVector mapDivideToSelf(double paramDouble);
  
  public abstract RealVector mapPow(double paramDouble);
  
  public abstract RealVector mapPowToSelf(double paramDouble);
  
  public abstract RealVector mapExp();
  
  public abstract RealVector mapExpToSelf();
  
  public abstract RealVector mapExpm1();
  
  public abstract RealVector mapExpm1ToSelf();
  
  public abstract RealVector mapLog();
  
  public abstract RealVector mapLogToSelf();
  
  public abstract RealVector mapLog10();
  
  public abstract RealVector mapLog10ToSelf();
  
  public abstract RealVector mapLog1p();
  
  public abstract RealVector mapLog1pToSelf();
  
  public abstract RealVector mapCosh();
  
  public abstract RealVector mapCoshToSelf();
  
  public abstract RealVector mapSinh();
  
  public abstract RealVector mapSinhToSelf();
  
  public abstract RealVector mapTanh();
  
  public abstract RealVector mapTanhToSelf();
  
  public abstract RealVector mapCos();
  
  public abstract RealVector mapCosToSelf();
  
  public abstract RealVector mapSin();
  
  public abstract RealVector mapSinToSelf();
  
  public abstract RealVector mapTan();
  
  public abstract RealVector mapTanToSelf();
  
  public abstract RealVector mapAcos();
  
  public abstract RealVector mapAcosToSelf();
  
  public abstract RealVector mapAsin();
  
  public abstract RealVector mapAsinToSelf();
  
  public abstract RealVector mapAtan();
  
  public abstract RealVector mapAtanToSelf();
  
  public abstract RealVector mapInv();
  
  public abstract RealVector mapInvToSelf();
  
  public abstract RealVector mapAbs();
  
  public abstract RealVector mapAbsToSelf();
  
  public abstract RealVector mapSqrt();
  
  public abstract RealVector mapSqrtToSelf();
  
  public abstract RealVector mapCbrt();
  
  public abstract RealVector mapCbrtToSelf();
  
  public abstract RealVector mapCeil();
  
  public abstract RealVector mapCeilToSelf();
  
  public abstract RealVector mapFloor();
  
  public abstract RealVector mapFloorToSelf();
  
  public abstract RealVector mapRint();
  
  public abstract RealVector mapRintToSelf();
  
  public abstract RealVector mapSignum();
  
  public abstract RealVector mapSignumToSelf();
  
  public abstract RealVector mapUlp();
  
  public abstract RealVector mapUlpToSelf();
  
  public abstract RealVector ebeMultiply(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealVector ebeMultiply(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract RealVector ebeDivide(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealVector ebeDivide(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double[] getData();
  
  public abstract double dotProduct(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract double dotProduct(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double getNorm();
  
  public abstract double getL1Norm();
  
  public abstract double getLInfNorm();
  
  public abstract double getDistance(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract double getDistance(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double getL1Distance(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract double getL1Distance(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double getLInfDistance(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract double getLInfDistance(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract RealVector unitVector();
  
  public abstract void unitize();
  
  public abstract RealVector projection(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealVector projection(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract RealMatrix outerProduct(RealVector paramRealVector)
    throws IllegalArgumentException;
  
  public abstract RealMatrix outerProduct(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double getEntry(int paramInt)
    throws MatrixIndexException;
  
  public abstract void setEntry(int paramInt, double paramDouble)
    throws MatrixIndexException;
  
  public abstract int getDimension();
  
  public abstract RealVector append(RealVector paramRealVector);
  
  public abstract RealVector append(double paramDouble);
  
  public abstract RealVector append(double[] paramArrayOfDouble);
  
  public abstract RealVector getSubVector(int paramInt1, int paramInt2)
    throws MatrixIndexException;
  
  public abstract void setSubVector(int paramInt, RealVector paramRealVector)
    throws MatrixIndexException;
  
  public abstract void setSubVector(int paramInt, double[] paramArrayOfDouble)
    throws MatrixIndexException;
  
  public abstract void set(double paramDouble);
  
  public abstract double[] toArray();
  
  public abstract boolean isNaN();
  
  public abstract boolean isInfinite();
  
  public static abstract class Entry
  {
    private int index;
    
    public abstract double getValue();
    
    public abstract void setValue(double paramDouble);
    
    public int getIndex()
    {
      return index;
    }
    
    public void setIndex(int index)
    {
      this.index = index;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealVector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */