package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract class BinaryFunction
  implements BivariateRealFunction
{
  public static final BinaryFunction ADD = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return x + y;
    }
  };
  public static final BinaryFunction SUBTRACT = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return x - y;
    }
  };
  public static final BinaryFunction MULTIPLY = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return x * y;
    }
  };
  public static final BinaryFunction DIVIDE = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return x / y;
    }
  };
  public static final BinaryFunction POW = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return Math.pow(x, y);
    }
  };
  public static final BinaryFunction ATAN2 = new BinaryFunction()
  {
    public double value(double x, double y)
    {
      return Math.atan2(x, y);
    }
  };
  
  public abstract double value(double paramDouble1, double paramDouble2)
    throws FunctionEvaluationException;
  
  public ComposableFunction fix1stArgument(final double fixedX)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return value(fixedX, x);
      }
    };
  }
  
  public ComposableFunction fix2ndArgument(final double fixedY)
  {
    new ComposableFunction()
    {
      public double value(double x)
        throws FunctionEvaluationException
      {
        return value(x, fixedY);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.BinaryFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */