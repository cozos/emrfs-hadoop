package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class Array2DRowRealMatrix
  extends AbstractRealMatrix
  implements Serializable
{
  private static final long serialVersionUID = -1067294169172445528L;
  private static final String AT_LEAST_ONE_ROW_MESSAGE = "matrix must have at least one row";
  private static final String AT_LEAST_ONE_COLUMN_MESSAGE = "matrix must have at least one column";
  private static final String DIFFERENT_ROWS_LENGTHS_MESSAGE = "some rows have length {0} while others have length {1}";
  private static final String NO_ENTRY_MESSAGE = "no entry at indices ({0}, {1}) in a {2}x{3} matrix";
  private static final String VECTOR_LENGTHS_MISMATCH = "vector length mismatch: got {0} but expected {1}";
  protected double[][] data;
  
  public Array2DRowRealMatrix() {}
  
  public Array2DRowRealMatrix(int rowDimension, int columnDimension)
    throws IllegalArgumentException
  {
    super(rowDimension, columnDimension);
    data = new double[rowDimension][columnDimension];
  }
  
  public Array2DRowRealMatrix(double[][] d)
    throws IllegalArgumentException, NullPointerException
  {
    copyIn(d);
  }
  
  public Array2DRowRealMatrix(double[][] d, boolean copyArray)
    throws IllegalArgumentException, NullPointerException
  {
    if (copyArray)
    {
      copyIn(d);
    }
    else
    {
      if (d == null) {
        throw new NullPointerException();
      }
      int nRows = d.length;
      if (nRows == 0) {
        throw MathRuntimeException.createIllegalArgumentException("matrix must have at least one row", new Object[0]);
      }
      int nCols = d[0].length;
      if (nCols == 0) {
        throw MathRuntimeException.createIllegalArgumentException("matrix must have at least one column", new Object[0]);
      }
      for (int r = 1; r < nRows; r++) {
        if (d[r].length != nCols) {
          throw MathRuntimeException.createIllegalArgumentException("some rows have length {0} while others have length {1}", new Object[] { Integer.valueOf(nCols), Integer.valueOf(d[r].length) });
        }
      }
      data = d;
    }
  }
  
  public Array2DRowRealMatrix(double[] v)
  {
    int nRows = v.length;
    data = new double[nRows][1];
    for (int row = 0; row < nRows; row++) {
      data[row][0] = v[row];
    }
  }
  
  public RealMatrix createMatrix(int rowDimension, int columnDimension)
    throws IllegalArgumentException
  {
    return new Array2DRowRealMatrix(rowDimension, columnDimension);
  }
  
  public RealMatrix copy()
  {
    return new Array2DRowRealMatrix(copyOut(), false);
  }
  
  public RealMatrix add(RealMatrix m)
    throws IllegalArgumentException
  {
    try
    {
      return add((Array2DRowRealMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.add(m);
  }
  
  public Array2DRowRealMatrix add(Array2DRowRealMatrix m)
    throws IllegalArgumentException
  {
    MatrixUtils.checkAdditionCompatible(this, m);
    
    int rowCount = getRowDimension();
    int columnCount = getColumnDimension();
    double[][] outData = new double[rowCount][columnCount];
    for (int row = 0; row < rowCount; row++)
    {
      double[] dataRow = data[row];
      double[] mRow = data[row];
      double[] outDataRow = outData[row];
      for (int col = 0; col < columnCount; col++) {
        dataRow[col] += mRow[col];
      }
    }
    return new Array2DRowRealMatrix(outData, false);
  }
  
  public RealMatrix subtract(RealMatrix m)
    throws IllegalArgumentException
  {
    try
    {
      return subtract((Array2DRowRealMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.subtract(m);
  }
  
  public Array2DRowRealMatrix subtract(Array2DRowRealMatrix m)
    throws IllegalArgumentException
  {
    MatrixUtils.checkSubtractionCompatible(this, m);
    
    int rowCount = getRowDimension();
    int columnCount = getColumnDimension();
    double[][] outData = new double[rowCount][columnCount];
    for (int row = 0; row < rowCount; row++)
    {
      double[] dataRow = data[row];
      double[] mRow = data[row];
      double[] outDataRow = outData[row];
      for (int col = 0; col < columnCount; col++) {
        dataRow[col] -= mRow[col];
      }
    }
    return new Array2DRowRealMatrix(outData, false);
  }
  
  public RealMatrix multiply(RealMatrix m)
    throws IllegalArgumentException
  {
    try
    {
      return multiply((Array2DRowRealMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.multiply(m);
  }
  
  public Array2DRowRealMatrix multiply(Array2DRowRealMatrix m)
    throws IllegalArgumentException
  {
    MatrixUtils.checkMultiplicationCompatible(this, m);
    
    int nRows = getRowDimension();
    int nCols = m.getColumnDimension();
    int nSum = getColumnDimension();
    double[][] outData = new double[nRows][nCols];
    for (int row = 0; row < nRows; row++)
    {
      double[] dataRow = data[row];
      double[] outDataRow = outData[row];
      for (int col = 0; col < nCols; col++)
      {
        double sum = 0.0D;
        for (int i = 0; i < nSum; i++) {
          sum += dataRow[i] * data[i][col];
        }
        outDataRow[col] = sum;
      }
    }
    return new Array2DRowRealMatrix(outData, false);
  }
  
  public double[][] getData()
  {
    return copyOut();
  }
  
  public double[][] getDataRef()
  {
    return data;
  }
  
  public void setSubMatrix(double[][] subMatrix, int row, int column)
    throws MatrixIndexException
  {
    if (data == null)
    {
      if (row > 0) {
        throw MathRuntimeException.createIllegalStateException("first {0} rows are not initialized yet", new Object[] { Integer.valueOf(row) });
      }
      if (column > 0) {
        throw MathRuntimeException.createIllegalStateException("first {0} columns are not initialized yet", new Object[] { Integer.valueOf(column) });
      }
      int nRows = subMatrix.length;
      if (nRows == 0) {
        throw MathRuntimeException.createIllegalArgumentException("matrix must have at least one row", new Object[0]);
      }
      int nCols = subMatrix[0].length;
      if (nCols == 0) {
        throw MathRuntimeException.createIllegalArgumentException("matrix must have at least one column", new Object[0]);
      }
      data = new double[subMatrix.length][nCols];
      for (int i = 0; i < data.length; i++)
      {
        if (subMatrix[i].length != nCols) {
          throw MathRuntimeException.createIllegalArgumentException("some rows have length {0} while others have length {1}", new Object[] { Integer.valueOf(nCols), Integer.valueOf(subMatrix[i].length) });
        }
        System.arraycopy(subMatrix[i], 0, data[(i + row)], column, nCols);
      }
    }
    else
    {
      super.setSubMatrix(subMatrix, row, column);
    }
  }
  
  public double getEntry(int row, int column)
    throws MatrixIndexException
  {
    try
    {
      return data[row][column];
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new MatrixIndexException("no entry at indices ({0}, {1}) in a {2}x{3} matrix", new Object[] { Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()) });
    }
  }
  
  public void setEntry(int row, int column, double value)
    throws MatrixIndexException
  {
    try
    {
      data[row][column] = value;
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new MatrixIndexException("no entry at indices ({0}, {1}) in a {2}x{3} matrix", new Object[] { Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()) });
    }
  }
  
  public void addToEntry(int row, int column, double increment)
    throws MatrixIndexException
  {
    try
    {
      data[row][column] += increment;
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new MatrixIndexException("no entry at indices ({0}, {1}) in a {2}x{3} matrix", new Object[] { Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()) });
    }
  }
  
  public void multiplyEntry(int row, int column, double factor)
    throws MatrixIndexException
  {
    try
    {
      data[row][column] *= factor;
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new MatrixIndexException("no entry at indices ({0}, {1}) in a {2}x{3} matrix", new Object[] { Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()) });
    }
  }
  
  public int getRowDimension()
  {
    return data == null ? 0 : data.length;
  }
  
  public int getColumnDimension()
  {
    return (data == null) || (data[0] == null) ? 0 : data[0].length;
  }
  
  public double[] operate(double[] v)
    throws IllegalArgumentException
  {
    int nRows = getRowDimension();
    int nCols = getColumnDimension();
    if (v.length != nCols) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(v.length), Integer.valueOf(nCols) });
    }
    double[] out = new double[nRows];
    for (int row = 0; row < nRows; row++)
    {
      double[] dataRow = data[row];
      double sum = 0.0D;
      for (int i = 0; i < nCols; i++) {
        sum += dataRow[i] * v[i];
      }
      out[row] = sum;
    }
    return out;
  }
  
  public double[] preMultiply(double[] v)
    throws IllegalArgumentException
  {
    int nRows = getRowDimension();
    int nCols = getColumnDimension();
    if (v.length != nRows) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(v.length), Integer.valueOf(nRows) });
    }
    double[] out = new double[nCols];
    for (int col = 0; col < nCols; col++)
    {
      double sum = 0.0D;
      for (int i = 0; i < nRows; i++) {
        sum += data[i][col] * v[i];
      }
      out[col] = sum;
    }
    return out;
  }
  
  public double walkInRowOrder(RealMatrixChangingVisitor visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int i = 0; i < rows; i++)
    {
      double[] rowI = data[i];
      for (int j = 0; j < columns; j++) {
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInRowOrder(RealMatrixPreservingVisitor visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int i = 0; i < rows; i++)
    {
      double[] rowI = data[i];
      for (int j = 0; j < columns; j++) {
        visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInRowOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int i = startRow; i <= endRow; i++)
    {
      double[] rowI = data[i];
      for (int j = startColumn; j <= endColumn; j++) {
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInRowOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int i = startRow; i <= endRow; i++)
    {
      double[] rowI = data[i];
      for (int j = startColumn; j <= endColumn; j++) {
        visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInColumnOrder(RealMatrixChangingVisitor visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows; i++)
      {
        double[] rowI = data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInColumnOrder(RealMatrixPreservingVisitor visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows; i++) {
        visitor.visit(i, j, data[i][j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInColumnOrder(RealMatrixChangingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int j = startColumn; j <= endColumn; j++) {
      for (int i = startRow; i <= endRow; i++)
      {
        double[] rowI = data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public double walkInColumnOrder(RealMatrixPreservingVisitor visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int j = startColumn; j <= endColumn; j++) {
      for (int i = startRow; i <= endRow; i++) {
        visitor.visit(i, j, data[i][j]);
      }
    }
    return visitor.end();
  }
  
  private double[][] copyOut()
  {
    int nRows = getRowDimension();
    double[][] out = new double[nRows][getColumnDimension()];
    for (int i = 0; i < nRows; i++) {
      System.arraycopy(data[i], 0, out[i], 0, data[i].length);
    }
    return out;
  }
  
  private void copyIn(double[][] in)
  {
    setSubMatrix(in, 0, 0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */