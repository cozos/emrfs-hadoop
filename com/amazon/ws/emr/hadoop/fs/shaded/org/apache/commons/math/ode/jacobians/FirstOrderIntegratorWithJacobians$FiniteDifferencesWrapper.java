package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;

class FirstOrderIntegratorWithJacobians$FiniteDifferencesWrapper
  implements ODEWithJacobians
{
  private final ParameterizedODE ode;
  private final double[] p;
  private final double[] hY;
  private final double[] hP;
  private final double[] tmpDot;
  
  public FirstOrderIntegratorWithJacobians$FiniteDifferencesWrapper(FirstOrderIntegratorWithJacobians paramFirstOrderIntegratorWithJacobians, ParameterizedODE ode, double[] p, double[] hY, double[] hP)
  {
    this.ode = ode;
    this.p = ((double[])p.clone());
    this.hY = ((double[])hY.clone());
    this.hP = ((double[])hP.clone());
    tmpDot = new double[ode.getDimension()];
  }
  
  public int getDimension()
  {
    return ode.getDimension();
  }
  
  public void computeDerivatives(double t, double[] y, double[] yDot)
    throws DerivativeException
  {
    ode.computeDerivatives(t, y, yDot);
  }
  
  public int getParametersDimension()
  {
    return ode.getParametersDimension();
  }
  
  public void computeJacobians(double t, double[] y, double[] yDot, double[][] dFdY, double[][] dFdP)
    throws DerivativeException
  {
    int n = hY.length;
    int k = hP.length;
    
    FirstOrderIntegratorWithJacobians.access$112(this$0, n + k);
    if (FirstOrderIntegratorWithJacobians.access$100(this$0) > FirstOrderIntegratorWithJacobians.access$200(this$0)) {
      throw new DerivativeException(new MaxEvaluationsExceededException(FirstOrderIntegratorWithJacobians.access$200(this$0)));
    }
    for (int j = 0; j < n; j++)
    {
      double savedYj = y[j];
      y[j] += hY[j];
      ode.computeDerivatives(t, y, tmpDot);
      for (int i = 0; i < n; i++) {
        dFdY[i][j] = ((tmpDot[i] - yDot[i]) / hY[j]);
      }
      y[j] = savedYj;
    }
    for (int j = 0; j < k; j++)
    {
      ode.setParameter(j, p[j] + hP[j]);
      ode.computeDerivatives(t, y, tmpDot);
      for (int i = 0; i < n; i++) {
        dFdP[i][j] = ((tmpDot[i] - yDot[i]) / hP[j]);
      }
      ode.setParameter(j, p[j]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.jacobians.FirstOrderIntegratorWithJacobians.FiniteDifferencesWrapper
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */