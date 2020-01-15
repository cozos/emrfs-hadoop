package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class FirstOrderIntegratorWithJacobians$StepInterpolatorWrapper
  implements StepInterpolatorWithJacobians
{
  private StepInterpolator interpolator;
  private double[] y;
  private double[][] dydy0;
  private double[][] dydp;
  private double[] yDot;
  private double[][] dydy0Dot;
  private double[][] dydpDot;
  
  public FirstOrderIntegratorWithJacobians$StepInterpolatorWrapper() {}
  
  public FirstOrderIntegratorWithJacobians$StepInterpolatorWrapper(StepInterpolator interpolator, int n, int k)
  {
    this.interpolator = interpolator;
    y = new double[n];
    dydy0 = new double[n][n];
    dydp = new double[n][k];
    yDot = new double[n];
    dydy0Dot = new double[n][n];
    dydpDot = new double[n][k];
  }
  
  public void setInterpolatedTime(double time)
  {
    interpolator.setInterpolatedTime(time);
  }
  
  public boolean isForward()
  {
    return interpolator.isForward();
  }
  
  public double getPreviousTime()
  {
    return interpolator.getPreviousTime();
  }
  
  public double getInterpolatedTime()
  {
    return interpolator.getInterpolatedTime();
  }
  
  public double[] getInterpolatedY()
    throws DerivativeException
  {
    double[] extendedState = interpolator.getInterpolatedState();
    System.arraycopy(extendedState, 0, y, 0, y.length);
    return y;
  }
  
  public double[][] getInterpolatedDyDy0()
    throws DerivativeException
  {
    double[] extendedState = interpolator.getInterpolatedState();
    int n = y.length;
    int start = n;
    for (int i = 0; i < n; i++)
    {
      System.arraycopy(extendedState, start, dydy0[i], 0, n);
      start += n;
    }
    return dydy0;
  }
  
  public double[][] getInterpolatedDyDp()
    throws DerivativeException
  {
    double[] extendedState = interpolator.getInterpolatedState();
    int n = y.length;
    int k = dydp[0].length;
    int start = n * (n + 1);
    for (int i = 0; i < n; i++)
    {
      System.arraycopy(extendedState, start, dydp[i], 0, k);
      start += k;
    }
    return dydp;
  }
  
  public double[] getInterpolatedYDot()
    throws DerivativeException
  {
    double[] extendedDerivatives = interpolator.getInterpolatedDerivatives();
    System.arraycopy(extendedDerivatives, 0, yDot, 0, yDot.length);
    return yDot;
  }
  
  public double[][] getInterpolatedDyDy0Dot()
    throws DerivativeException
  {
    double[] extendedDerivatives = interpolator.getInterpolatedDerivatives();
    int n = y.length;
    int start = n;
    for (int i = 0; i < n; i++)
    {
      System.arraycopy(extendedDerivatives, start, dydy0Dot[i], 0, n);
      start += n;
    }
    return dydy0Dot;
  }
  
  public double[][] getInterpolatedDyDpDot()
    throws DerivativeException
  {
    double[] extendedDerivatives = interpolator.getInterpolatedDerivatives();
    int n = y.length;
    int k = dydpDot[0].length;
    int start = n * (n + 1);
    for (int i = 0; i < n; i++)
    {
      System.arraycopy(extendedDerivatives, start, dydpDot[i], 0, k);
      start += k;
    }
    return dydpDot;
  }
  
  public double getCurrentTime()
  {
    return interpolator.getCurrentTime();
  }
  
  public StepInterpolatorWithJacobians copy()
    throws DerivativeException
  {
    int n = y.length;
    int k = dydp[0].length;
    StepInterpolatorWrapper copied = new StepInterpolatorWrapper(interpolator.copy(), n, k);
    
    copyArray(y, y);
    copyArray(dydy0, dydy0);
    copyArray(dydp, dydp);
    copyArray(yDot, yDot);
    copyArray(dydy0Dot, dydy0Dot);
    copyArray(dydpDot, dydpDot);
    return copied;
  }
  
  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(interpolator);
    out.writeInt(y.length);
    out.writeInt(dydp[0].length);
    writeArray(out, y);
    writeArray(out, dydy0);
    writeArray(out, dydp);
    writeArray(out, yDot);
    writeArray(out, dydy0Dot);
    writeArray(out, dydpDot);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    interpolator = ((StepInterpolator)in.readObject());
    int n = in.readInt();
    int k = in.readInt();
    y = new double[n];
    dydy0 = new double[n][n];
    dydp = new double[n][k];
    yDot = new double[n];
    dydy0Dot = new double[n][n];
    dydpDot = new double[n][k];
    readArray(in, y);
    readArray(in, dydy0);
    readArray(in, dydp);
    readArray(in, yDot);
    readArray(in, dydy0Dot);
    readArray(in, dydpDot);
  }
  
  private static void copyArray(double[] src, double[] dest)
  {
    System.arraycopy(src, 0, dest, 0, src.length);
  }
  
  private static void copyArray(double[][] src, double[][] dest)
  {
    for (int i = 0; i < src.length; i++) {
      copyArray(src[i], dest[i]);
    }
  }
  
  private static void writeArray(ObjectOutput out, double[] array)
    throws IOException
  {
    for (int i = 0; i < array.length; i++) {
      out.writeDouble(array[i]);
    }
  }
  
  private static void writeArray(ObjectOutput out, double[][] array)
    throws IOException
  {
    for (int i = 0; i < array.length; i++) {
      writeArray(out, array[i]);
    }
  }
  
  private static void readArray(ObjectInput in, double[] array)
    throws IOException
  {
    for (int i = 0; i < array.length; i++) {
      array[i] = in.readDouble();
    }
  }
  
  private static void readArray(ObjectInput in, double[][] array)
    throws IOException
  {
    for (int i = 0; i < array.length; i++) {
      readArray(in, array[i]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.FirstOrderIntegratorWithJacobians.StepInterpolatorWrapper
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */