package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

public abstract class UnivariateRealSolverFactory
{
  public static UnivariateRealSolverFactory newInstance()
  {
    return new UnivariateRealSolverFactoryImpl();
  }
  
  public abstract UnivariateRealSolver newDefaultSolver();
  
  public abstract UnivariateRealSolver newBisectionSolver();
  
  public abstract UnivariateRealSolver newBrentSolver();
  
  public abstract UnivariateRealSolver newNewtonSolver();
  
  public abstract UnivariateRealSolver newSecantSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */