package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;

public class UnboundedSolutionException
  extends OptimizationException
{
  private static final long serialVersionUID = 940539497277290619L;
  
  public UnboundedSolutionException()
  {
    super("unbounded solution", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear.UnboundedSolutionException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */