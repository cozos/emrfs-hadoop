package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.correlation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.BlockRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.ranking.NaturalRanking;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.ranking.RankingAlgorithm;

public class SpearmansCorrelation
{
  private final RealMatrix data;
  private final RankingAlgorithm rankingAlgorithm;
  private final PearsonsCorrelation rankCorrelation;
  
  public SpearmansCorrelation(RealMatrix dataMatrix, RankingAlgorithm rankingAlgorithm)
  {
    data = dataMatrix.copy();
    this.rankingAlgorithm = rankingAlgorithm;
    rankTransform(data);
    rankCorrelation = new PearsonsCorrelation(data);
  }
  
  public SpearmansCorrelation(RealMatrix dataMatrix)
  {
    this(dataMatrix, new NaturalRanking());
  }
  
  public SpearmansCorrelation()
  {
    data = null;
    rankingAlgorithm = new NaturalRanking();
    rankCorrelation = null;
  }
  
  public RealMatrix getCorrelationMatrix()
  {
    return rankCorrelation.getCorrelationMatrix();
  }
  
  public PearsonsCorrelation getRankCorrelation()
  {
    return rankCorrelation;
  }
  
  public RealMatrix computeCorrelationMatrix(RealMatrix matrix)
  {
    RealMatrix matrixCopy = matrix.copy();
    rankTransform(matrixCopy);
    return new PearsonsCorrelation().computeCorrelationMatrix(matrixCopy);
  }
  
  public RealMatrix computeCorrelationMatrix(double[][] matrix)
  {
    return computeCorrelationMatrix(new BlockRealMatrix(matrix));
  }
  
  public double correlation(double[] xArray, double[] yArray)
    throws IllegalArgumentException
  {
    if ((xArray.length == yArray.length) && (xArray.length > 1)) {
      return new PearsonsCorrelation().correlation(rankingAlgorithm.rank(xArray), rankingAlgorithm.rank(yArray));
    }
    throw MathRuntimeException.createIllegalArgumentException("invalid array dimensions. xArray has size {0}; yArray has {1} elements", new Object[] { Integer.valueOf(xArray.length), Integer.valueOf(yArray.length) });
  }
  
  private void rankTransform(RealMatrix matrix)
  {
    for (int i = 0; i < matrix.getColumnDimension(); i++) {
      matrix.setColumn(i, rankingAlgorithm.rank(matrix.getColumn(i)));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.correlation.SpearmansCorrelation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */