package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

class CholeskyDecompositionImpl$Solver
  implements DecompositionSolver
{
  private final double[][] lTData;
  
  private CholeskyDecompositionImpl$Solver(double[][] lTData)
  {
    this.lTData = lTData;
  }
  
  public boolean isNonSingular()
  {
    return true;
  }
  
  public double[] solve(double[] b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int m = lTData.length;
    if (b.length != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.length), Integer.valueOf(m) });
    }
    double[] x = (double[])b.clone();
    for (int j = 0; j < m; j++)
    {
      double[] lJ = lTData[j];
      x[j] /= lJ[j];
      double xJ = x[j];
      for (int i = j + 1; i < m; i++) {
        x[i] -= xJ * lJ[i];
      }
    }
    for (int j = m - 1; j >= 0; j--)
    {
      x[j] /= lTData[j][j];
      double xJ = x[j];
      for (int i = 0; i < j; i++) {
        x[i] -= xJ * lTData[i][j];
      }
    }
    return x;
  }
  
  public RealVector solve(RealVector b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    try
    {
      return solve((ArrayRealVector)b);
    }
    catch (ClassCastException cce)
    {
      int m = lTData.length;
      if (b.getDimension() != m) {
        throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.getDimension()), Integer.valueOf(m) });
      }
      double[] x = b.getData();
      for (int j = 0; j < m; j++)
      {
        double[] lJ = lTData[j];
        x[j] /= lJ[j];
        double xJ = x[j];
        for (int i = j + 1; i < m; i++) {
          x[i] -= xJ * lJ[i];
        }
      }
      for (int j = m - 1; j >= 0; j--)
      {
        x[j] /= lTData[j][j];
        double xJ = x[j];
        for (int i = 0; i < j; i++) {
          x[i] -= xJ * lTData[i][j];
        }
      }
      return new ArrayRealVector(x, false);
    }
  }
  
  public ArrayRealVector solve(ArrayRealVector b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    return new ArrayRealVector(solve(b.getDataRef()), false);
  }
  
  public RealMatrix solve(RealMatrix b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int m = lTData.length;
    if (b.getRowDimension() != m) {
      throw MathRuntimeException.createIllegalArgumentException("dimensions mismatch: got {0}x{1} but expected {2}x{3}", new Object[] { Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n" });
    }
    int nColB = b.getColumnDimension();
    double[][] x = b.getData();
    for (int j = 0; j < m; j++)
    {
      double[] lJ = lTData[j];
      double lJJ = lJ[j];
      double[] xJ = x[j];
      for (int k = 0; k < nColB; k++) {
        xJ[k] /= lJJ;
      }
      for (int i = j + 1; i < m; i++)
      {
        double[] xI = x[i];
        double lJI = lJ[i];
        for (int k = 0; k < nColB; k++) {
          xI[k] -= xJ[k] * lJI;
        }
      }
    }
    for (int j = m - 1; j >= 0; j--)
    {
      double lJJ = lTData[j][j];
      double[] xJ = x[j];
      for (int k = 0; k < nColB; k++) {
        xJ[k] /= lJJ;
      }
      for (int i = 0; i < j; i++)
      {
        double[] xI = x[i];
        double lIJ = lTData[i][j];
        for (int k = 0; k < nColB; k++) {
          xI[k] -= xJ[k] * lIJ;
        }
      }
    }
    return new Array2DRowRealMatrix(x, false);
  }
  
  public RealMatrix getInverse()
    throws InvalidMatrixException
  {
    return solve(MatrixUtils.createRealIdentityMatrix(lTData.length));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.CholeskyDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */