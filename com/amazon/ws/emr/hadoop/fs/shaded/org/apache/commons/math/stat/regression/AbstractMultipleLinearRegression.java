package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.ArrayRealVector;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealVector;

public abstract class AbstractMultipleLinearRegression
  implements MultipleLinearRegression
{
  protected RealMatrix X;
  protected RealVector Y;
  
  public void newSampleData(double[] data, int nobs, int nvars)
  {
    double[] y = new double[nobs];
    double[][] x = new double[nobs][nvars + 1];
    int pointer = 0;
    for (int i = 0; i < nobs; i++)
    {
      y[i] = data[(pointer++)];
      x[i][0] = 1.0D;
      for (int j = 1; j < nvars + 1; j++) {
        x[i][j] = data[(pointer++)];
      }
    }
    X = new Array2DRowRealMatrix(x);
    Y = new ArrayRealVector(y);
  }
  
  protected void newYSampleData(double[] y)
  {
    Y = new ArrayRealVector(y);
  }
  
  protected void newXSampleData(double[][] x)
  {
    X = new Array2DRowRealMatrix(x);
  }
  
  protected void validateSampleData(double[][] x, double[] y)
  {
    if ((x == null) || (y == null) || (x.length != y.length)) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(x == null ? 0 : x.length), Integer.valueOf(y == null ? 0 : y.length) });
    }
    if ((x.length > 0) && (x[0].length > x.length)) {
      throw MathRuntimeException.createIllegalArgumentException("not enough data ({0} rows) for this many predictors ({1} predictors)", new Object[] { Integer.valueOf(x.length), Integer.valueOf(x[0].length) });
    }
  }
  
  protected void validateCovarianceData(double[][] x, double[][] covariance)
  {
    if (x.length != covariance.length) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(x.length), Integer.valueOf(covariance.length) });
    }
    if ((covariance.length > 0) && (covariance.length != covariance[0].length)) {
      throw MathRuntimeException.createIllegalArgumentException("a {0}x{1} matrix was provided instead of a square matrix", new Object[] { Integer.valueOf(covariance.length), Integer.valueOf(covariance[0].length) });
    }
  }
  
  public double[] estimateRegressionParameters()
  {
    RealVector b = calculateBeta();
    return b.getData();
  }
  
  public double[] estimateResiduals()
  {
    RealVector b = calculateBeta();
    RealVector e = Y.subtract(X.operate(b));
    return e.getData();
  }
  
  public double[][] estimateRegressionParametersVariance()
  {
    return calculateBetaVariance().getData();
  }
  
  public double[] estimateRegressionParametersStandardErrors()
  {
    double[][] betaVariance = estimateRegressionParametersVariance();
    double sigma = calculateYVariance();
    int length = betaVariance[0].length;
    double[] result = new double[length];
    for (int i = 0; i < length; i++) {
      result[i] = Math.sqrt(sigma * betaVariance[i][i]);
    }
    return result;
  }
  
  public double estimateRegressandVariance()
  {
    return calculateYVariance();
  }
  
  protected abstract RealVector calculateBeta();
  
  protected abstract RealMatrix calculateBetaVariance();
  
  protected abstract double calculateYVariance();
  
  protected RealVector calculateResiduals()
  {
    RealVector b = calculateBeta();
    return Y.subtract(X.operate(b));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression.AbstractMultipleLinearRegression
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */