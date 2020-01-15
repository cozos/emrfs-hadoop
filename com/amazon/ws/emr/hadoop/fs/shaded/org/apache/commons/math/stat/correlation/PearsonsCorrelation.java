package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.correlation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.TDistribution;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.TDistributionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.BlockRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.regression.SimpleRegression;

public class PearsonsCorrelation
{
  private final RealMatrix correlationMatrix;
  private final int nObs;
  
  public PearsonsCorrelation()
  {
    correlationMatrix = null;
    nObs = 0;
  }
  
  public PearsonsCorrelation(double[][] data)
  {
    this(new BlockRealMatrix(data));
  }
  
  public PearsonsCorrelation(RealMatrix matrix)
  {
    checkSufficientData(matrix);
    nObs = matrix.getRowDimension();
    correlationMatrix = computeCorrelationMatrix(matrix);
  }
  
  public PearsonsCorrelation(Covariance covariance)
  {
    RealMatrix covarianceMatrix = covariance.getCovarianceMatrix();
    if (covarianceMatrix == null) {
      throw MathRuntimeException.createIllegalArgumentException("covariance matrix is null", new Object[0]);
    }
    nObs = covariance.getN();
    correlationMatrix = covarianceToCorrelation(covarianceMatrix);
  }
  
  public PearsonsCorrelation(RealMatrix covarianceMatrix, int numberOfObservations)
  {
    nObs = numberOfObservations;
    correlationMatrix = covarianceToCorrelation(covarianceMatrix);
  }
  
  public RealMatrix getCorrelationMatrix()
  {
    return correlationMatrix;
  }
  
  public RealMatrix getCorrelationStandardErrors()
  {
    int nVars = correlationMatrix.getColumnDimension();
    double[][] out = new double[nVars][nVars];
    for (int i = 0; i < nVars; i++) {
      for (int j = 0; j < nVars; j++)
      {
        double r = correlationMatrix.getEntry(i, j);
        out[i][j] = Math.sqrt((1.0D - r * r) / (nObs - 2));
      }
    }
    return new BlockRealMatrix(out);
  }
  
  public RealMatrix getCorrelationPValues()
    throws MathException
  {
    TDistribution tDistribution = new TDistributionImpl(nObs - 2);
    int nVars = correlationMatrix.getColumnDimension();
    double[][] out = new double[nVars][nVars];
    for (int i = 0; i < nVars; i++) {
      for (int j = 0; j < nVars; j++) {
        if (i == j)
        {
          out[i][j] = 0.0D;
        }
        else
        {
          double r = correlationMatrix.getEntry(i, j);
          double t = Math.abs(r * Math.sqrt((nObs - 2) / (1.0D - r * r)));
          out[i][j] = (2.0D * (1.0D - tDistribution.cumulativeProbability(t)));
        }
      }
    }
    return new BlockRealMatrix(out);
  }
  
  public RealMatrix computeCorrelationMatrix(RealMatrix matrix)
  {
    int nVars = matrix.getColumnDimension();
    RealMatrix outMatrix = new BlockRealMatrix(nVars, nVars);
    for (int i = 0; i < nVars; i++)
    {
      for (int j = 0; j < i; j++)
      {
        double corr = correlation(matrix.getColumn(i), matrix.getColumn(j));
        outMatrix.setEntry(i, j, corr);
        outMatrix.setEntry(j, i, corr);
      }
      outMatrix.setEntry(i, i, 1.0D);
    }
    return outMatrix;
  }
  
  public RealMatrix computeCorrelationMatrix(double[][] data)
  {
    return computeCorrelationMatrix(new BlockRealMatrix(data));
  }
  
  public double correlation(double[] xArray, double[] yArray)
    throws IllegalArgumentException
  {
    SimpleRegression regression = new SimpleRegression();
    if ((xArray.length == yArray.length) && (xArray.length > 1))
    {
      for (int i = 0; i < xArray.length; i++) {
        regression.addData(xArray[i], yArray[i]);
      }
      return regression.getR();
    }
    throw MathRuntimeException.createIllegalArgumentException("invalid array dimensions. xArray has size {0}; yArray has {1} elements", new Object[] { Integer.valueOf(xArray.length), Integer.valueOf(yArray.length) });
  }
  
  public RealMatrix covarianceToCorrelation(RealMatrix covarianceMatrix)
  {
    int nVars = covarianceMatrix.getColumnDimension();
    RealMatrix outMatrix = new BlockRealMatrix(nVars, nVars);
    for (int i = 0; i < nVars; i++)
    {
      double sigma = Math.sqrt(covarianceMatrix.getEntry(i, i));
      outMatrix.setEntry(i, i, 1.0D);
      for (int j = 0; j < i; j++)
      {
        double entry = covarianceMatrix.getEntry(i, j) / (sigma * Math.sqrt(covarianceMatrix.getEntry(j, j)));
        
        outMatrix.setEntry(i, j, entry);
        outMatrix.setEntry(j, i, entry);
      }
    }
    return outMatrix;
  }
  
  private void checkSufficientData(RealMatrix matrix)
  {
    int nRows = matrix.getRowDimension();
    int nCols = matrix.getColumnDimension();
    if ((nRows < 2) || (nCols < 2)) {
      throw MathRuntimeException.createIllegalArgumentException("insufficient data: only {0} rows and {1} columns.", new Object[] { Integer.valueOf(nRows), Integer.valueOf(nCols) });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.correlation.PearsonsCorrelation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */