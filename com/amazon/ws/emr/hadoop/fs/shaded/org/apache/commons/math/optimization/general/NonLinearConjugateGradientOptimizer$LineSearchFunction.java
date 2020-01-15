package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

class NonLinearConjugateGradientOptimizer$LineSearchFunction
  implements UnivariateRealFunction
{
  private final double[] searchDirection;
  
  public NonLinearConjugateGradientOptimizer$LineSearchFunction(NonLinearConjugateGradientOptimizer paramNonLinearConjugateGradientOptimizer, double[] searchDirection)
  {
    this.searchDirection = searchDirection;
  }
  
  public double value(double x)
    throws FunctionEvaluationException
  {
    double[] shiftedPoint = (double[])this$0.point.clone();
    for (int i = 0; i < shiftedPoint.length; i++) {
      shiftedPoint[i] += x * searchDirection[i];
    }
    double[] gradient = this$0.computeObjectiveGradient(shiftedPoint);
    
    double dotProduct = 0.0D;
    for (int i = 0; i < gradient.length; i++) {
      dotProduct += gradient[i] * searchDirection[i];
    }
    return dotProduct;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.NonLinearConjugateGradientOptimizer.LineSearchFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */