package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class Array2DRowFieldMatrix<T extends FieldElement<T>>
  extends AbstractFieldMatrix<T>
  implements Serializable
{
  private static final long serialVersionUID = 7260756672015356458L;
  private static final String AT_LEAST_ONE_ROW_MESSAGE = "matrix must have at least one row";
  private static final String AT_LEAST_ONE_COLUMN_MESSAGE = "matrix must have at least one column";
  private static final String DIFFERENT_ROWS_LENGTHS_MESSAGE = "some rows have length {0} while others have length {1}";
  private static final String NO_ENTRY_MESSAGE = "no entry at indices ({0}, {1}) in a {2}x{3} matrix";
  private static final String VECTOR_LENGTHS_MISMATCH = "vector length mismatch: got {0} but expected {1}";
  protected T[][] data;
  
  public Array2DRowFieldMatrix(Field<T> field)
  {
    super(field);
  }
  
  public Array2DRowFieldMatrix(Field<T> field, int rowDimension, int columnDimension)
    throws IllegalArgumentException
  {
    super(field, rowDimension, columnDimension);
    data = buildArray(field, rowDimension, columnDimension);
  }
  
  public Array2DRowFieldMatrix(T[][] d)
    throws IllegalArgumentException, NullPointerException
  {
    super(extractField(d));
    copyIn(d);
  }
  
  public Array2DRowFieldMatrix(T[][] d, boolean copyArray)
    throws IllegalArgumentException, NullPointerException
  {
    super(extractField(d));
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
  
  public Array2DRowFieldMatrix(T[] v)
  {
    super(extractField(v));
    int nRows = v.length;
    data = buildArray(getField(), nRows, 1);
    for (int row = 0; row < nRows; row++) {
      data[row][0] = v[row];
    }
  }
  
  public FieldMatrix<T> createMatrix(int rowDimension, int columnDimension)
    throws IllegalArgumentException
  {
    return new Array2DRowFieldMatrix(getField(), rowDimension, columnDimension);
  }
  
  public FieldMatrix<T> copy()
  {
    return new Array2DRowFieldMatrix(copyOut(), false);
  }
  
  public FieldMatrix<T> add(FieldMatrix<T> m)
    throws IllegalArgumentException
  {
    try
    {
      return add((Array2DRowFieldMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.add(m);
  }
  
  public Array2DRowFieldMatrix<T> add(Array2DRowFieldMatrix<T> m)
    throws IllegalArgumentException
  {
    checkAdditionCompatible(m);
    
    int rowCount = getRowDimension();
    int columnCount = getColumnDimension();
    T[][] outData = buildArray(getField(), rowCount, columnCount);
    for (int row = 0; row < rowCount; row++)
    {
      T[] dataRow = data[row];
      T[] mRow = data[row];
      T[] outDataRow = outData[row];
      for (int col = 0; col < columnCount; col++) {
        outDataRow[col] = ((FieldElement)dataRow[col].add(mRow[col]));
      }
    }
    return new Array2DRowFieldMatrix(outData, false);
  }
  
  public FieldMatrix<T> subtract(FieldMatrix<T> m)
    throws IllegalArgumentException
  {
    try
    {
      return subtract((Array2DRowFieldMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.subtract(m);
  }
  
  public Array2DRowFieldMatrix<T> subtract(Array2DRowFieldMatrix<T> m)
    throws IllegalArgumentException
  {
    checkSubtractionCompatible(m);
    
    int rowCount = getRowDimension();
    int columnCount = getColumnDimension();
    T[][] outData = buildArray(getField(), rowCount, columnCount);
    for (int row = 0; row < rowCount; row++)
    {
      T[] dataRow = data[row];
      T[] mRow = data[row];
      T[] outDataRow = outData[row];
      for (int col = 0; col < columnCount; col++) {
        outDataRow[col] = ((FieldElement)dataRow[col].subtract(mRow[col]));
      }
    }
    return new Array2DRowFieldMatrix(outData, false);
  }
  
  public FieldMatrix<T> multiply(FieldMatrix<T> m)
    throws IllegalArgumentException
  {
    try
    {
      return multiply((Array2DRowFieldMatrix)m);
    }
    catch (ClassCastException cce) {}
    return super.multiply(m);
  }
  
  public Array2DRowFieldMatrix<T> multiply(Array2DRowFieldMatrix<T> m)
    throws IllegalArgumentException
  {
    checkMultiplicationCompatible(m);
    
    int nRows = getRowDimension();
    int nCols = m.getColumnDimension();
    int nSum = getColumnDimension();
    T[][] outData = buildArray(getField(), nRows, nCols);
    for (int row = 0; row < nRows; row++)
    {
      T[] dataRow = data[row];
      T[] outDataRow = outData[row];
      for (int col = 0; col < nCols; col++)
      {
        T sum = (FieldElement)getField().getZero();
        for (int i = 0; i < nSum; i++) {
          sum = (FieldElement)sum.add(dataRow[i].multiply(data[i][col]));
        }
        outDataRow[col] = sum;
      }
    }
    return new Array2DRowFieldMatrix(outData, false);
  }
  
  public T[][] getData()
  {
    return copyOut();
  }
  
  public T[][] getDataRef()
  {
    return data;
  }
  
  public void setSubMatrix(T[][] subMatrix, int row, int column)
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
      data = buildArray(getField(), subMatrix.length, nCols);
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
  
  public T getEntry(int row, int column)
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
  
  public void setEntry(int row, int column, T value)
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
  
  public void addToEntry(int row, int column, T increment)
    throws MatrixIndexException
  {
    try
    {
      data[row][column] = ((FieldElement)data[row][column].add(increment));
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new MatrixIndexException("no entry at indices ({0}, {1}) in a {2}x{3} matrix", new Object[] { Integer.valueOf(row), Integer.valueOf(column), Integer.valueOf(getRowDimension()), Integer.valueOf(getColumnDimension()) });
    }
  }
  
  public void multiplyEntry(int row, int column, T factor)
    throws MatrixIndexException
  {
    try
    {
      data[row][column] = ((FieldElement)data[row][column].multiply(factor));
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
  
  public T[] operate(T[] v)
    throws IllegalArgumentException
  {
    int nRows = getRowDimension();
    int nCols = getColumnDimension();
    if (v.length != nCols) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(v.length), Integer.valueOf(nCols) });
    }
    T[] out = buildArray(getField(), nRows);
    for (int row = 0; row < nRows; row++)
    {
      T[] dataRow = data[row];
      T sum = (FieldElement)getField().getZero();
      for (int i = 0; i < nCols; i++) {
        sum = (FieldElement)sum.add(dataRow[i].multiply(v[i]));
      }
      out[row] = sum;
    }
    return out;
  }
  
  public T[] preMultiply(T[] v)
    throws IllegalArgumentException
  {
    int nRows = getRowDimension();
    int nCols = getColumnDimension();
    if (v.length != nRows) {
      throw MathRuntimeException.createIllegalArgumentException("vector length mismatch: got {0} but expected {1}", new Object[] { Integer.valueOf(v.length), Integer.valueOf(nRows) });
    }
    T[] out = buildArray(getField(), nCols);
    for (int col = 0; col < nCols; col++)
    {
      T sum = (FieldElement)getField().getZero();
      for (int i = 0; i < nRows; i++) {
        sum = (FieldElement)sum.add(data[i][col].multiply(v[i]));
      }
      out[col] = sum;
    }
    return out;
  }
  
  public T walkInRowOrder(FieldMatrixChangingVisitor<T> visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int i = 0; i < rows; i++)
    {
      T[] rowI = data[i];
      for (int j = 0; j < columns; j++) {
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInRowOrder(FieldMatrixPreservingVisitor<T> visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int i = 0; i < rows; i++)
    {
      T[] rowI = data[i];
      for (int j = 0; j < columns; j++) {
        visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInRowOrder(FieldMatrixChangingVisitor<T> visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int i = startRow; i <= endRow; i++)
    {
      T[] rowI = data[i];
      for (int j = startColumn; j <= endColumn; j++) {
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInRowOrder(FieldMatrixPreservingVisitor<T> visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int i = startRow; i <= endRow; i++)
    {
      T[] rowI = data[i];
      for (int j = startColumn; j <= endColumn; j++) {
        visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInColumnOrder(FieldMatrixChangingVisitor<T> visitor)
    throws MatrixVisitorException
  {
    int rows = getRowDimension();
    int columns = getColumnDimension();
    visitor.start(rows, columns, 0, rows - 1, 0, columns - 1);
    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows; i++)
      {
        T[] rowI = data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> visitor)
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
  
  public T walkInColumnOrder(FieldMatrixChangingVisitor<T> visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int j = startColumn; j <= endColumn; j++) {
      for (int i = startRow; i <= endRow; i++)
      {
        T[] rowI = data[i];
        rowI[j] = visitor.visit(i, j, rowI[j]);
      }
    }
    return visitor.end();
  }
  
  public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> visitor, int startRow, int endRow, int startColumn, int endColumn)
    throws MatrixIndexException, MatrixVisitorException
  {
    checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
    visitor.start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
    for (int j = startColumn; j <= endColumn; j++) {
      for (int i = startRow; i <= endRow; i++) {
        visitor.visit(i, j, data[i][j]);
      }
    }
    return visitor.end();
  }
  
  private T[][] copyOut()
  {
    int nRows = getRowDimension();
    T[][] out = buildArray(getField(), nRows, getColumnDimension());
    for (int i = 0; i < nRows; i++) {
      System.arraycopy(data[i], 0, out[i], 0, data[i].length);
    }
    return out;
  }
  
  private void copyIn(T[][] in)
  {
    setSubMatrix(in, 0, 0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowFieldMatrix
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */