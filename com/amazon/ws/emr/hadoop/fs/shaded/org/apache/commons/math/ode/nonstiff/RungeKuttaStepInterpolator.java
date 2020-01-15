package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.AbstractIntegrator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

abstract class RungeKuttaStepInterpolator
  extends AbstractStepInterpolator
{
  protected double[][] yDotK;
  protected AbstractIntegrator integrator;
  
  protected RungeKuttaStepInterpolator()
  {
    yDotK = ((double[][])null);
    integrator = null;
  }
  
  public RungeKuttaStepInterpolator(RungeKuttaStepInterpolator interpolator)
  {
    super(interpolator);
    if (currentState != null)
    {
      int dimension = currentState.length;
      
      yDotK = new double[yDotK.length][];
      for (int k = 0; k < yDotK.length; k++)
      {
        yDotK[k] = new double[dimension];
        System.arraycopy(yDotK[k], 0, yDotK[k], 0, dimension);
      }
    }
    else
    {
      yDotK = ((double[][])null);
    }
    integrator = null;
  }
  
  public void reinitialize(AbstractIntegrator rkIntegrator, double[] y, double[][] yDotArray, boolean forward)
  {
    reinitialize(y, forward);
    yDotK = yDotArray;
    integrator = rkIntegrator;
  }
  
  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    writeBaseExternal(out);
    
    int n = currentState == null ? -1 : currentState.length;
    int kMax = yDotK == null ? -1 : yDotK.length;
    out.writeInt(kMax);
    for (int k = 0; k < kMax; k++) {
      for (int i = 0; i < n; i++) {
        out.writeDouble(yDotK[k][i]);
      }
    }
  }
  
  public void readExternal(ObjectInput in)
    throws IOException
  {
    double t = readBaseExternal(in);
    
    int n = currentState == null ? -1 : currentState.length;
    int kMax = in.readInt();
    yDotK = (kMax < 0 ? (double[][])null : new double[kMax][]);
    for (int k = 0; k < kMax; k++)
    {
      yDotK[k] = (n < 0 ? null : new double[n]);
      for (int i = 0; i < n; i++) {
        yDotK[k][i] = in.readDouble();
      }
    }
    integrator = null;
    if (currentState != null) {
      setInterpolatedTime(t);
    } else {
      interpolatedTime = t;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.RungeKuttaStepInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */