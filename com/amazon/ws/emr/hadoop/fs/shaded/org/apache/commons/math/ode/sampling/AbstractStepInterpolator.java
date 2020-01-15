package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class AbstractStepInterpolator
  implements StepInterpolator
{
  protected double previousTime;
  protected double currentTime;
  protected double h;
  protected double[] currentState;
  protected double interpolatedTime;
  protected double[] interpolatedState;
  protected double[] interpolatedDerivatives;
  private boolean finalized;
  private boolean forward;
  private boolean dirtyState;
  
  protected AbstractStepInterpolator()
  {
    previousTime = NaN.0D;
    currentTime = NaN.0D;
    h = NaN.0D;
    interpolatedTime = NaN.0D;
    currentState = null;
    interpolatedState = null;
    interpolatedDerivatives = null;
    finalized = false;
    forward = true;
    dirtyState = true;
  }
  
  protected AbstractStepInterpolator(double[] y, boolean forward)
  {
    previousTime = NaN.0D;
    currentTime = NaN.0D;
    h = NaN.0D;
    interpolatedTime = NaN.0D;
    
    currentState = y;
    interpolatedState = new double[y.length];
    interpolatedDerivatives = new double[y.length];
    
    finalized = false;
    this.forward = forward;
    dirtyState = true;
  }
  
  protected AbstractStepInterpolator(AbstractStepInterpolator interpolator)
  {
    previousTime = previousTime;
    currentTime = currentTime;
    h = h;
    interpolatedTime = interpolatedTime;
    if (currentState != null)
    {
      currentState = ((double[])currentState.clone());
      interpolatedState = ((double[])interpolatedState.clone());
      interpolatedDerivatives = ((double[])interpolatedDerivatives.clone());
    }
    else
    {
      currentState = null;
      interpolatedState = null;
      interpolatedDerivatives = null;
    }
    finalized = finalized;
    forward = forward;
    dirtyState = dirtyState;
  }
  
  protected void reinitialize(double[] y, boolean isForward)
  {
    previousTime = NaN.0D;
    currentTime = NaN.0D;
    h = NaN.0D;
    interpolatedTime = NaN.0D;
    
    currentState = y;
    interpolatedState = new double[y.length];
    interpolatedDerivatives = new double[y.length];
    
    finalized = false;
    forward = isForward;
    dirtyState = true;
  }
  
  public StepInterpolator copy()
    throws DerivativeException
  {
    finalizeStep();
    
    return doCopy();
  }
  
  protected abstract StepInterpolator doCopy();
  
  public void shift()
  {
    previousTime = currentTime;
  }
  
  public void storeTime(double t)
  {
    currentTime = t;
    h = (currentTime - previousTime);
    setInterpolatedTime(t);
    
    finalized = false;
  }
  
  public double getPreviousTime()
  {
    return previousTime;
  }
  
  public double getCurrentTime()
  {
    return currentTime;
  }
  
  public double getInterpolatedTime()
  {
    return interpolatedTime;
  }
  
  public void setInterpolatedTime(double time)
  {
    interpolatedTime = time;
    dirtyState = true;
  }
  
  public boolean isForward()
  {
    return forward;
  }
  
  protected abstract void computeInterpolatedStateAndDerivatives(double paramDouble1, double paramDouble2)
    throws DerivativeException;
  
  public double[] getInterpolatedState()
    throws DerivativeException
  {
    if (dirtyState)
    {
      double oneMinusThetaH = currentTime - interpolatedTime;
      double theta = h == 0.0D ? 0.0D : (h - oneMinusThetaH) / h;
      computeInterpolatedStateAndDerivatives(theta, oneMinusThetaH);
      dirtyState = false;
    }
    return interpolatedState;
  }
  
  public double[] getInterpolatedDerivatives()
    throws DerivativeException
  {
    if (dirtyState)
    {
      double oneMinusThetaH = currentTime - interpolatedTime;
      double theta = h == 0.0D ? 0.0D : (h - oneMinusThetaH) / h;
      computeInterpolatedStateAndDerivatives(theta, oneMinusThetaH);
      dirtyState = false;
    }
    return interpolatedDerivatives;
  }
  
  public final void finalizeStep()
    throws DerivativeException
  {
    if (!finalized)
    {
      doFinalize();
      finalized = true;
    }
  }
  
  protected void doFinalize()
    throws DerivativeException
  {}
  
  public abstract void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException;
  
  public abstract void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException;
  
  protected void writeBaseExternal(ObjectOutput out)
    throws IOException
  {
    if (currentState == null) {
      out.writeInt(-1);
    } else {
      out.writeInt(currentState.length);
    }
    out.writeDouble(previousTime);
    out.writeDouble(currentTime);
    out.writeDouble(h);
    out.writeBoolean(forward);
    if (currentState != null) {
      for (int i = 0; i < currentState.length; i++) {
        out.writeDouble(currentState[i]);
      }
    }
    out.writeDouble(interpolatedTime);
    try
    {
      finalizeStep();
    }
    catch (DerivativeException e)
    {
      throw MathRuntimeException.createIOException(e);
    }
  }
  
  protected double readBaseExternal(ObjectInput in)
    throws IOException
  {
    int dimension = in.readInt();
    previousTime = in.readDouble();
    currentTime = in.readDouble();
    h = in.readDouble();
    forward = in.readBoolean();
    dirtyState = true;
    if (dimension < 0)
    {
      currentState = null;
    }
    else
    {
      currentState = new double[dimension];
      for (int i = 0; i < currentState.length; i++) {
        currentState[i] = in.readDouble();
      }
    }
    interpolatedTime = NaN.0D;
    interpolatedState = (dimension < 0 ? null : new double[dimension]);
    interpolatedDerivatives = (dimension < 0 ? null : new double[dimension]);
    
    finalized = true;
    
    return in.readDouble();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.AbstractStepInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */