package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DecompositionSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecompositionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealVector;

public class GLSMultipleLinearRegression
  extends AbstractMultipleLinearRegression
{
  private RealMatrix Omega;
  private RealMatrix OmegaInverse;
  
  public void newSampleData(double[] y, double[][] x, double[][] covariance)
  {
    validateSampleData(x, y);
    newYSampleData(y);
    newXSampleData(x);
    validateCovarianceData(x, covariance);
    newCovarianceData(covariance);
  }
  
  protected void newCovarianceData(double[][] omega)
  {
    Omega = new Array2DRowRealMatrix(omega);
    OmegaInverse = null;
  }
  
  protected RealMatrix getOmegaInverse()
  {
    if (OmegaInverse == null) {
      OmegaInverse = new LUDecompositionImpl(Omega).getSolver().getInverse();
    }
    return OmegaInverse;
  }
  
  protected RealVector calculateBeta()
  {
    RealMatrix OI = getOmegaInverse();
    RealMatrix XT = X.transpose();
    RealMatrix XTOIX = XT.multiply(OI).multiply(X);
    RealMatrix inverse = new LUDecompositionImpl(XTOIX).getSolver().getInverse();
    return inverse.multiply(XT).multiply(OI).operate(Y);
  }
  
  protected RealMatrix calculateBetaVariance()
  {
    RealMatrix OI = getOmegaInverse();
    RealMatrix XTOIX = X.transpose().multiply(OI).multiply(X);
    return new LUDecompositionImpl(XTOIX).getSolver().getInverse();
  }
  
  protected double calculateYVariance()
  {
    RealVector residuals = calculateResiduals();
    double t = residuals.dotProduct(getOmegaInverse().operate(residuals));
    return t / (X.getRowDimension() - X.getColumnDimension());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression.GLSMultipleLinearRegression
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */