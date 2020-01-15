package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DecompositionSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecompositionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.QRDecomposition;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.QRDecompositionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealVector;

public class OLSMultipleLinearRegression
  extends AbstractMultipleLinearRegression
{
  private QRDecomposition qr = null;
  
  public void newSampleData(double[] y, double[][] x)
  {
    validateSampleData(x, y);
    newYSampleData(y);
    newXSampleData(x);
  }
  
  public void newSampleData(double[] data, int nobs, int nvars)
  {
    super.newSampleData(data, nobs, nvars);
    qr = new QRDecompositionImpl(X);
  }
  
  public RealMatrix calculateHat()
  {
    RealMatrix Q = qr.getQ();
    int p = qr.getR().getColumnDimension();
    int n = Q.getColumnDimension();
    Array2DRowRealMatrix augI = new Array2DRowRealMatrix(n, n);
    double[][] augIData = augI.getDataRef();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == j) && (i < p)) {
          augIData[i][j] = 1.0D;
        } else {
          augIData[i][j] = 0.0D;
        }
      }
    }
    return Q.multiply(augI).multiply(Q.transpose());
  }
  
  protected void newXSampleData(double[][] x)
  {
    X = new Array2DRowRealMatrix(x);
    qr = new QRDecompositionImpl(X);
  }
  
  protected RealVector calculateBeta()
  {
    return qr.getSolver().solve(Y);
  }
  
  protected RealMatrix calculateBetaVariance()
  {
    int p = X.getColumnDimension();
    RealMatrix Raug = qr.getR().getSubMatrix(0, p - 1, 0, p - 1);
    RealMatrix Rinv = new LUDecompositionImpl(Raug).getSolver().getInverse();
    return Rinv.multiply(Rinv.transpose());
  }
  
  protected double calculateYVariance()
  {
    RealVector residuals = calculateResiduals();
    return residuals.dotProduct(residuals) / (X.getRowDimension() - X.getColumnDimension());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression.OLSMultipleLinearRegression
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */