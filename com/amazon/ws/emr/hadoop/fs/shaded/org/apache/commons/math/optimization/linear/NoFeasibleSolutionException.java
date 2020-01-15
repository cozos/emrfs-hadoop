package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;

public class NoFeasibleSolutionException
  extends OptimizationException
{
  private static final long serialVersionUID = -3044253632189082760L;
  
  public NoFeasibleSolutionException()
  {
    super("no feasible solution", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear.NoFeasibleSolutionException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */