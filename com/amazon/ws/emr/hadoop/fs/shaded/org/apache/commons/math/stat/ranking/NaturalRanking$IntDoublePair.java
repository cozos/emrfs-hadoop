package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.ranking;

class NaturalRanking$IntDoublePair
  implements Comparable<IntDoublePair>
{
  private final double value;
  private final int position;
  
  public NaturalRanking$IntDoublePair(double value, int position)
  {
    this.value = value;
    this.position = position;
  }
  
  public int compareTo(IntDoublePair other)
  {
    return Double.compare(value, value);
  }
  
  public double getValue()
  {
    return value;
  }
  
  public int getPosition()
  {
    return position;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.ranking.NaturalRanking.IntDoublePair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */