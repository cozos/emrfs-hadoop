package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

public class SimpleScalarValueChecker
  implements RealConvergenceChecker
{
  private static final double DEFAULT_RELATIVE_THRESHOLD = 1.1102230246251565E-14D;
  private static final double DEFAULT_ABSOLUTE_THRESHOLD = 2.2250738585072014E-306D;
  private final double relativeThreshold;
  private final double absoluteThreshold;
  
  public SimpleScalarValueChecker()
  {
    relativeThreshold = 1.1102230246251565E-14D;
    absoluteThreshold = 2.2250738585072014E-306D;
  }
  
  public SimpleScalarValueChecker(double relativeThreshold, double absoluteThreshold)
  {
    this.relativeThreshold = relativeThreshold;
    this.absoluteThreshold = absoluteThreshold;
  }
  
  public boolean converged(int iteration, RealPointValuePair previous, RealPointValuePair current)
  {
    double p = previous.getValue();
    double c = current.getValue();
    double difference = Math.abs(p - c);
    double size = Math.max(Math.abs(p), Math.abs(c));
    return (difference <= size * relativeThreshold) || (difference <= absoluteThreshold);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.SimpleScalarValueChecker
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */