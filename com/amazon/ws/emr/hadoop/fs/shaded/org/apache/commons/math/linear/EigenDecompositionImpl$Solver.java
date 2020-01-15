package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

class EigenDecompositionImpl$Solver
  implements DecompositionSolver
{
  private double[] realEigenvalues;
  private double[] imagEigenvalues;
  private final ArrayRealVector[] eigenvectors;
  
  private EigenDecompositionImpl$Solver(double[] realEigenvalues, double[] imagEigenvalues, ArrayRealVector[] eigenvectors)
  {
    this.realEigenvalues = realEigenvalues;
    this.imagEigenvalues = imagEigenvalues;
    this.eigenvectors = eigenvectors;
  }
  
  public double[] solve(double[] b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    int m = realEigenvalues.length;
    if (b.length != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.length), Integer.valueOf(m) });
    }
    double[] bp = new double[m];
    for (int i = 0; i < m; i++)
    {
      ArrayRealVector v = eigenvectors[i];
      double[] vData = v.getDataRef();
      double s = v.dotProduct(b) / realEigenvalues[i];
      for (int j = 0; j < m; j++) {
        bp[j] += s * vData[j];
      }
    }
    return bp;
  }
  
  public RealVector solve(RealVector b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    int m = realEigenvalues.length;
    if (b.getDimension() != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.getDimension()), Integer.valueOf(m) });
    }
    double[] bp = new double[m];
    for (int i = 0; i < m; i++)
    {
      ArrayRealVector v = eigenvectors[i];
      double[] vData = v.getDataRef();
      double s = v.dotProduct(b) / realEigenvalues[i];
      for (int j = 0; j < m; j++) {
        bp[j] += s * vData[j];
      }
    }
    return new ArrayRealVector(bp, false);
  }
  
  public RealMatrix solve(RealMatrix b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    int m = realEigenvalues.length;
    if (b.getRowDimension() != m) {
      throw MathRuntimeException.createIllegalArgumentException("dimensions mismatch: got {0}x{1} but expected {2}x{3}", new Object[] { Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n" });
    }
    int nColB = b.getColumnDimension();
    double[][] bp = new double[m][nColB];
    for (int k = 0; k < nColB; k++) {
      for (int i = 0; i < m; i++)
      {
        ArrayRealVector v = eigenvectors[i];
        double[] vData = v.getDataRef();
        double s = 0.0D;
        for (int j = 0; j < m; j++) {
          s += v.getEntry(j) * b.getEntry(j, k);
        }
        s /= realEigenvalues[i];
        for (int j = 0; j < m; j++) {
          bp[j][k] += s * vData[j];
        }
      }
    }
    return MatrixUtils.createRealMatrix(bp);
  }
  
  public boolean isNonSingular()
  {
    for (int i = 0; i < realEigenvalues.length; i++) {
      if ((realEigenvalues[i] == 0.0D) && (imagEigenvalues[i] == 0.0D)) {
        return false;
      }
    }
    return true;
  }
  
  public RealMatrix getInverse()
    throws InvalidMatrixException
  {
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    int m = realEigenvalues.length;
    double[][] invData = new double[m][m];
    for (int i = 0; i < m; i++)
    {
      double[] invI = invData[i];
      for (int j = 0; j < m; j++)
      {
        double invIJ = 0.0D;
        for (int k = 0; k < m; k++)
        {
          double[] vK = eigenvectors[k].getDataRef();
          invIJ += vK[i] * vK[j] / realEigenvalues[k];
        }
        invI[j] = invIJ;
      }
    }
    return MatrixUtils.createRealMatrix(invData);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.EigenDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */