package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.lang.reflect.Array;

class FieldLUDecompositionImpl$Solver<T extends FieldElement<T>>
  implements FieldDecompositionSolver<T>
{
  private static final long serialVersionUID = -6353105415121373022L;
  private final Field<T> field;
  private final T[][] lu;
  private final int[] pivot;
  private final boolean singular;
  
  private FieldLUDecompositionImpl$Solver(Field<T> field, T[][] lu, int[] pivot, boolean singular)
  {
    this.field = field;
    this.lu = lu;
    this.pivot = pivot;
    this.singular = singular;
  }
  
  public boolean isNonSingular()
  {
    return !singular;
  }
  
  public T[] solve(T[] b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    int m = pivot.length;
    if (b.length != m) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(b.length), Integer.valueOf(m) });
    }
    if (singular) {
      throw new SingularMatrixException();
    }
    T[] bp = (FieldElement[])Array.newInstance(((FieldElement)field.getZero()).getClass(), m);
    for (int row = 0; row < m; row++) {
      bp[row] = b[pivot[row]];
    }
    for (int col = 0; col < m; col++)
    {
      T bpCol = bp[col];
      for (int i = col + 1; i < m; i++) {
        bp[i] = ((FieldElement)bp[i].subtract(bpCol.multiply(lu[i][col])));
      }
    }
    for (int col = m - 1; col >= 0; col--)
    {
      bp[col] = ((FieldElement)bp[col].divide(lu[col][col]));
      T bpCol = bp[col];
      for (int i = 0; i < col; i++) {
        bp[i] = ((FieldElement)bp[i].subtract(bpCol.multiply(lu[i][col])));
      }
    }
    return bp;
  }
  
  public FieldVector<T> solve(FieldVector<T> b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    try
    {
      return solve((ArrayFieldVector)b);
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
      T[] bp = (FieldElement[])Array.newInstance(((FieldElement)field.getZero()).getClass(), m);
      for (int row = 0; row < m; row++) {
        bp[row] = b.getEntry(pivot[row]);
      }
      for (int col = 0; col < m; col++)
      {
        T bpCol = bp[col];
        for (int i = col + 1; i < m; i++) {
          bp[i] = ((FieldElement)bp[i].subtract(bpCol.multiply(lu[i][col])));
        }
      }
      for (int col = m - 1; col >= 0; col--)
      {
        bp[col] = ((FieldElement)bp[col].divide(lu[col][col]));
        T bpCol = bp[col];
        for (int i = 0; i < col; i++) {
          bp[i] = ((FieldElement)bp[i].subtract(bpCol.multiply(lu[i][col])));
        }
      }
      return new ArrayFieldVector(bp, false);
    }
  }
  
  public ArrayFieldVector<T> solve(ArrayFieldVector<T> b)
    throws IllegalArgumentException, InvalidMatrixException
  {
    return new ArrayFieldVector(solve(b.getDataRef()), false);
  }
  
  public FieldMatrix<T> solve(FieldMatrix<T> b)
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
    
    T[][] bp = (FieldElement[][])Array.newInstance(((FieldElement)field.getZero()).getClass(), new int[] { m, nColB });
    for (int row = 0; row < m; row++)
    {
      T[] bpRow = bp[row];
      int pRow = pivot[row];
      for (int col = 0; col < nColB; col++) {
        bpRow[col] = b.getEntry(pRow, col);
      }
    }
    for (int col = 0; col < m; col++)
    {
      T[] bpCol = bp[col];
      for (int i = col + 1; i < m; i++)
      {
        T[] bpI = bp[i];
        T luICol = lu[i][col];
        for (int j = 0; j < nColB; j++) {
          bpI[j] = ((FieldElement)bpI[j].subtract(bpCol[j].multiply(luICol)));
        }
      }
    }
    for (int col = m - 1; col >= 0; col--)
    {
      T[] bpCol = bp[col];
      T luDiag = lu[col][col];
      for (int j = 0; j < nColB; j++) {
        bpCol[j] = ((FieldElement)bpCol[j].divide(luDiag));
      }
      for (int i = 0; i < col; i++)
      {
        T[] bpI = bp[i];
        T luICol = lu[i][col];
        for (int j = 0; j < nColB; j++) {
          bpI[j] = ((FieldElement)bpI[j].subtract(bpCol[j].multiply(luICol)));
        }
      }
    }
    return new Array2DRowFieldMatrix(bp, false);
  }
  
  public FieldMatrix<T> getInverse()
    throws InvalidMatrixException
  {
    int m = pivot.length;
    T one = (FieldElement)field.getOne();
    FieldMatrix<T> identity = new Array2DRowFieldMatrix(field, m, m);
    for (int i = 0; i < m; i++) {
      identity.setEntry(i, i, one);
    }
    return solve(identity);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.FieldLUDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */