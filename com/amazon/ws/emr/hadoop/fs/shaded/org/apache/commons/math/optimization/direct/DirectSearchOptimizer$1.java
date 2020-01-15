package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.direct;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair;
import java.util.Comparator;

class DirectSearchOptimizer$1
  implements Comparator<RealPointValuePair>
{
  DirectSearchOptimizer$1(DirectSearchOptimizer paramDirectSearchOptimizer, GoalType paramGoalType) {}
  
  public int compare(RealPointValuePair o1, RealPointValuePair o2)
  {
    double v1 = o1.getValue();
    double v2 = o2.getValue();
    return val$goalType == GoalType.MINIMIZE ? Double.compare(v1, v2) : Double.compare(v2, v1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.direct.DirectSearchOptimizer.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */