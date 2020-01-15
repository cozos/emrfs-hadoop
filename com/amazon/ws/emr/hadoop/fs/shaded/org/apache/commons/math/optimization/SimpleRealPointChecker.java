package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

public class SimpleRealPointChecker
  implements RealConvergenceChecker
{
  private static final double DEFAULT_RELATIVE_THRESHOLD = 1.1102230246251565E-14D;
  private static final double DEFAULT_ABSOLUTE_THRESHOLD = 2.2250738585072014E-306D;
  private final double relativeThreshold;
  private final double absoluteThreshold;
  
  public SimpleRealPointChecker()
  {
    relativeThreshold = 1.1102230246251565E-14D;
    absoluteThreshold = 2.2250738585072014E-306D;
  }
  
  public SimpleRealPointChecker(double relativeThreshold, double absoluteThreshold)
  {
    this.relativeThreshold = relativeThreshold;
    this.absoluteThreshold = absoluteThreshold;
  }
  
  public boolean converged(int iteration, RealPointValuePair previous, RealPointValuePair current)
  {
    double[] p = previous.getPoint();
    double[] c = current.getPoint();
    for (int i = 0; i < p.length; i++)
    {
      double difference = Math.abs(p[i] - c[i]);
      double size = Math.max(Math.abs(p[i]), Math.abs(c[i]));
      if ((difference > size * relativeThreshold) && (difference > absoluteThreshold)) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.SimpleRealPointChecker
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */