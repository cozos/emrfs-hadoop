package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation;

@Deprecated
public abstract interface Estimator
{
  public abstract void estimate(EstimationProblem paramEstimationProblem)
    throws EstimationException;
  
  public abstract double getRMS(EstimationProblem paramEstimationProblem);
  
  public abstract double[][] getCovariances(EstimationProblem paramEstimationProblem)
    throws EstimationException;
  
  public abstract double[] guessParametersErrors(EstimationProblem paramEstimationProblem)
    throws EstimationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation.Estimator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */