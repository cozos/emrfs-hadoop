package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

class LUDecompositionImpl$Solver
  implements DecompositionSolver
{
  private final double[][] lu;
  private final int[] pivot;
  private final boolean singular;
  
  private LUDecompositionImpl$Solver(double[][] lu, int[] pivot, boolean singular)
  {
    this.lu = lu;
    this.pivot = pivot;
    this.singular = singular;
  }
  
  public boolean isNonSingular()
  {
    return !singular;
  }
  
  public double[] solve(double[] b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int m = pivot.length;
    if (b.length != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.length), Integer.valueOf(m) });
    }
    if (singular) {
      throw new SingularMatrixException();
    }
    double[] bp = new double[m];
    for (int row = 0; row < m; row++) {
      bp[row] = b[pivot[row]];
    }
    for (int col = 0; col < m; col++)
    {
      double bpCol = bp[col];
      for (int i = col + 1; i < m; i++) {
        bp[i] -= bpCol * lu[i][col];
      }
    }
    for (int col = m - 1; col >= 0; col--)
    {
      bp[col] /= lu[col][col];
      double bpCol = bp[col];
      for (int i = 0; i < col; i++) {
        bp[i] -= bpCol * lu[i][col];
      }
    }
    return bp;
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
      int m = pivot.length;
      if (b.getDimension() != m) {
        throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.getDimension()), Integer.valueOf(m) });
      }
      if (singular) {
        throw new SingularMatrixException();
      }
      double[] bp = new double[m];
      for (int row = 0; row < m; row++) {
        bp[row] = b.getEntry(pivot[row]);
      }
      for (int col = 0; col < m; col++)
      {
        double bpCol = bp[col];
        for (int i = col + 1; i < m; i++) {
          bp[i] -= bpCol * lu[i][col];
        }
      }
      for (int col = m - 1; col >= 0; col--)
      {
        bp[col] /= lu[col][col];
        double bpCol = bp[col];
        for (int i = 0; i < col; i++) {
          bp[i] -= bpCol * lu[i][col];
        }
      }
      return new ArrayRealVector(bp, false);
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
    int m = pivot.length;
    if (b.getRowDimension() != m) {
      throw MathRuntimeException.createIllegalArgumentException("dimensions mismatch: got {0}x{1} but expected {2}x{3}", new Object[] { Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n" });
    }
    if (singular) {
      throw new SingularMatrixException();
    }
    int nColB = b.getColumnDimension();
    
    double[][] bp = new double[m][nColB];
    for (int row = 0; row < m; row++)
    {
      double[] bpRow = bp[row];
      int pRow = pivot[row];
      for (int col = 0; col < nColB; col++) {
        bpRow[col] = b.getEntry(pRow, col);
      }
    }
    for (int col = 0; col < m; col++)
    {
      double[] bpCol = bp[col];
      for (int i = col + 1; i < m; i++)
      {
        double[] bpI = bp[i];
        double luICol = lu[i][col];
        for (int j = 0; j < nColB; j++) {
          bpI[j] -= bpCol[j] * luICol;
        }
      }
    }
    for (int col = m - 1; col >= 0; col--)
    {
      double[] bpCol = bp[col];
      double luDiag = lu[col][col];
      for (int j = 0; j < nColB; j++) {
        bpCol[j] /= luDiag;
      }
      for (int i = 0; i < col; i++)
      {
        double[] bpI = bp[i];
        double luICol = lu[i][col];
        for (int j = 0; j < nColB; j++) {
          bpI[j] -= bpCol[j] * luICol;
        }
      }
    }
    return new Array2DRowRealMatrix(bp, false);
  }
  
  public RealMatrix getInverse()
    throws InvalidMatrixException
  {
    return solve(MatrixUtils.createRealIdentityMatrix(pivot.length));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */