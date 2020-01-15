package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

class AggregateSummaryStatistics$AggregatingSummaryStatistics
  extends SummaryStatistics
{
  private static final long serialVersionUID = 1L;
  private final SummaryStatistics aggregateStatistics;
  
  public AggregateSummaryStatistics$AggregatingSummaryStatistics(SummaryStatistics aggregateStatistics)
  {
    this.aggregateStatistics = aggregateStatistics;
  }
  
  public void addValue(double value)
  {
    super.addValue(value);
    synchronized (aggregateStatistics)
    {
      aggregateStatistics.addValue(value);
    }
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof AggregatingSummaryStatistics)) {
      return false;
    }
    AggregatingSummaryStatistics stat = (AggregatingSummaryStatistics)object;
    return (super.equals(stat)) && (aggregateStatistics.equals(aggregateStatistics));
  }
  
  public int hashCode()
  {
    return 123 + super.hashCode() + aggregateStatistics.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AggregateSummaryStatistics.AggregatingSummaryStatistics
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */