package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.util.Arrays;

class QRDecompositionImpl$Solver
  implements DecompositionSolver
{
  private final double[][] qrt;
  private final double[] rDiag;
  
  private QRDecompositionImpl$Solver(double[][] qrt, double[] rDiag)
  {
    this.qrt = qrt;
    this.rDiag = rDiag;
  }
  
  public boolean isNonSingular()
  {
    for (double diag : rDiag) {
      if (diag == 0.0D) {
        return false;
      }
    }
    return true;
  }
  
  public double[] solve(double[] b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int n = qrt.length;
    int m = qrt[0].length;
    if (b.length != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.length), Integer.valueOf(m) });
    }
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    double[] x = new double[n];
    double[] y = (double[])b.clone();
    for (int minor = 0; minor < Math.min(m, n); minor++)
    {
      double[] qrtMinor = qrt[minor];
      double dotProduct = 0.0D;
      for (int row = minor; row < m; row++) {
        dotProduct += y[row] * qrtMinor[row];
      }
      dotProduct /= rDiag[minor] * qrtMinor[minor];
      for (int row = minor; row < m; row++) {
        y[row] += dotProduct * qrtMinor[row];
      }
    }
    for (int row = rDiag.length - 1; row >= 0; row--)
    {
      y[row] /= rDiag[row];
      double yRow = y[row];
      double[] qrtRow = qrt[row];
      x[row] = yRow;
      for (int i = 0; i < row; i++) {
        y[i] -= yRow * qrtRow[i];
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
    catch (ClassCastException cce) {}
    return new ArrayRealVector(solve(b.getData()), false);
  }
  
  public ArrayRealVector solve(ArrayRealVector b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    return new ArrayRealVector(solve(b.getDataRef()), false);
  }
  
  public RealMatrix solve(RealMatrix b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int n = qrt.length;
    int m = qrt[0].length;
    if (b.getRowDimension() != m) {
      throw MathRuntimeException.createIllegalArgumentException("dimensions mismatch: got {0}x{1} but expected {2}x{3}", new Object[] { Integer.valueOf(b.getRowDimension()), Integer.valueOf(b.getColumnDimension()), Integer.valueOf(m), "n" });
    }
    if (!isNonSingular()) {
      throw new SingularMatrixException();
    }
    int columns = b.getColumnDimension();
    int blockSize = 52;
    int cBlocks = (columns + 52 - 1) / 52;
    double[][] xBlocks = BlockRealMatrix.createBlocksLayout(n, columns);
    double[][] y = new double[b.getRowDimension()][52];
    double[] alpha = new double[52];
    for (int kBlock = 0; kBlock < cBlocks; kBlock++)
    {
      int kStart = kBlock * 52;
      int kEnd = Math.min(kStart + 52, columns);
      int kWidth = kEnd - kStart;
      
      b.copySubMatrix(0, m - 1, kStart, kEnd - 1, y);
      for (int minor = 0; minor < Math.min(m, n); minor++)
      {
        double[] qrtMinor = qrt[minor];
        double factor = 1.0D / (rDiag[minor] * qrtMinor[minor]);
        
        Arrays.fill(alpha, 0, kWidth, 0.0D);
        for (int row = minor; row < m; row++)
        {
          double d = qrtMinor[row];
          double[] yRow = y[row];
          for (int k = 0; k < kWidth; k++) {
            alpha[k] += d * yRow[k];
          }
        }
        for (int k = 0; k < kWidth; k++) {
          alpha[k] *= factor;
        }
        for (int row = minor; row < m; row++)
        {
          double d = qrtMinor[row];
          double[] yRow = y[row];
          for (int k = 0; k < kWidth; k++) {
            yRow[k] += alpha[k] * d;
          }
        }
      }
      for (int j = rDiag.length - 1; j >= 0; j--)
      {
        int jBlock = j / 52;
        int jStart = jBlock * 52;
        double factor = 1.0D / rDiag[j];
        double[] yJ = y[j];
        double[] xBlock = xBlocks[(jBlock * cBlocks + kBlock)];
        int index = (j - jStart) * kWidth;
        for (int k = 0; k < kWidth; k++)
        {
          yJ[k] *= factor;
          xBlock[(index++)] = yJ[k];
        }
        double[] qrtJ = qrt[j];
        for (int i = 0; i < j; i++)
        {
          double rIJ = qrtJ[i];
          double[] yI = y[i];
          for (int k = 0; k < kWidth; k++) {
            yI[k] -= yJ[k] * rIJ;
          }
        }
      }
    }
    return new BlockRealMatrix(n, columns, xBlocks, false);
  }
  
  public RealMatrix getInverse()
    throws InvalidMatrixException
  {
    return solve(MatrixUtils.createRealIdentityMatrix(rDiag.length));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.QRDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */