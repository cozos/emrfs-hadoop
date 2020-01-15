package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.Fraction;

class MatrixUtils$FractionMatrixConverter
  extends DefaultFieldMatrixPreservingVisitor<Fraction>
{
  private double[][] data;
  
  public MatrixUtils$FractionMatrixConverter()
  {
    super(Fraction.ZERO);
  }
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    data = new double[rows][columns];
  }
  
  public void visit(int row, int column, Fraction value)
  {
    data[row][column] = value.doubleValue();
  }
  
  Array2DRowRealMatrix getConvertedMatrix()
  {
    return new Array2DRowRealMatrix(data, false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixUtils.FractionMatrixConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */