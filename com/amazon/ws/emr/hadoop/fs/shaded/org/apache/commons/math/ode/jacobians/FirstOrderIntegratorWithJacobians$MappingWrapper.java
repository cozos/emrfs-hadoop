package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;

class FirstOrderIntegratorWithJacobians$MappingWrapper
  implements FirstOrderDifferentialEquations
{
  private final double[] y;
  private final double[] yDot;
  private final double[][] dFdY;
  private final double[][] dFdP;
  
  public FirstOrderIntegratorWithJacobians$MappingWrapper(FirstOrderIntegratorWithJacobians arg1)
  {
    int n = FirstOrderIntegratorWithJacobians.access$000(???).getDimension();
    int k = FirstOrderIntegratorWithJacobians.access$000(???).getParametersDimension();
    y = new double[n];
    yDot = new double[n];
    dFdY = new double[n][n];
    dFdP = new double[n][k];
  }
  
  public int getDimension()
  {
    int n = y.length;
    int k = dFdP[0].length;
    return n * (1 + n + k);
  }
  
  public void computeDerivatives(double t, double[] z, double[] zDot)
    throws DerivativeException
  {
    int n = y.length;
    int k = dFdP[0].length;
    
    System.arraycopy(z, 0, y, 0, n);
    if (FirstOrderIntegratorWithJacobians.access$104(this$0) > FirstOrderIntegratorWithJacobians.access$200(this$0)) {
      throw new DerivativeException(new MaxEvaluationsExceededException(FirstOrderIntegratorWithJacobians.access$200(this$0)));
    }
    FirstOrderIntegratorWithJacobians.access$000(this$0).computeDerivatives(t, y, yDot);
    FirstOrderIntegratorWithJacobians.access$000(this$0).computeJacobians(t, y, yDot, dFdY, dFdP);
    
    System.arraycopy(yDot, 0, zDot, 0, n);
    for (int i = 0; i < n; i++)
    {
      double[] dFdYi = dFdY[i];
      for (int j = 0; j < n; j++)
      {
        double s = 0.0D;
        int startIndex = n + j;
        int zIndex = startIndex;
        for (int l = 0; l < n; l++)
        {
          s += dFdYi[l] * z[zIndex];
          zIndex += n;
        }
        zDot[(startIndex + i * n)] = s;
      }
    }
    for (int i = 0; i < n; i++)
    {
      double[] dFdYi = dFdY[i];
      double[] dFdPi = dFdP[i];
      for (int j = 0; j < k; j++)
      {
        double s = dFdPi[j];
        int startIndex = n * (n + 1) + j;
        int zIndex = startIndex;
        for (int l = 0; l < n; l++)
        {
          s += dFdYi[l] * z[zIndex];
          zIndex += k;
        }
        zDot[(startIndex + i * k)] = s;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.FirstOrderIntegratorWithJacobians.MappingWrapper
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */