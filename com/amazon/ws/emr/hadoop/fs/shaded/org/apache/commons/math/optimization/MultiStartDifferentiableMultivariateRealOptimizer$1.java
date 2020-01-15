package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import java.util.Comparator;

class MultiStartDifferentiableMultivariateRealOptimizer$1
  implements Comparator<RealPointValuePair>
{
  MultiStartDifferentiableMultivariateRealOptimizer$1(MultiStartDifferentiableMultivariateRealOptimizer paramMultiStartDifferentiableMultivariateRealOptimizer, GoalType paramGoalType) {}
  
  public int compare(RealPointValuePair o1, RealPointValuePair o2)
  {
    if (o1 == null) {
      return o2 == null ? 0 : 1;
    }
    if (o2 == null) {
      return -1;
    }
    double v1 = o1.getValue();
    double v2 = o2.getValue();
    return val$goalType == GoalType.MINIMIZE ? Double.compare(v1, v2) : Double.compare(v2, v1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.MultiStartDifferentiableMultivariateRealOptimizer.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */