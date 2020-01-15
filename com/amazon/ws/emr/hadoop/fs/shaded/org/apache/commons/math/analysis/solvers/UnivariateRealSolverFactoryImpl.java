package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

public class UnivariateRealSolverFactoryImpl
  extends UnivariateRealSolverFactory
{
  public UnivariateRealSolver newDefaultSolver()
  {
    return newBrentSolver();
  }
  
  public UnivariateRealSolver newBisectionSolver()
  {
    return new BisectionSolver();
  }
  
  public UnivariateRealSolver newBrentSolver()
  {
    return new BrentSolver();
  }
  
  public UnivariateRealSolver newNewtonSolver()
  {
    return new NewtonSolver();
  }
  
  public UnivariateRealSolver newSecantSolver()
  {
    return new SecantSolver();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolverFactoryImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */