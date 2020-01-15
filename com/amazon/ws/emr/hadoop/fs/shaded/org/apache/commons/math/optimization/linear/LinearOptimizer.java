package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair;
import java.util.Collection;

public abstract interface LinearOptimizer
{
  public abstract void setMaxIterations(int paramInt);
  
  public abstract int getMaxIterations();
  
  public abstract int getIterations();
  
  public abstract RealPointValuePair optimize(LinearObjectiveFunction paramLinearObjectiveFunction, Collection<LinearConstraint> paramCollection, GoalType paramGoalType, boolean paramBoolean)
    throws OptimizationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear.LinearOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */