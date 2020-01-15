package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateMatrixFunction;
import java.util.List;

class CurveFitter$TheoreticalValuesFunction
  implements DifferentiableMultivariateVectorialFunction
{
  private final ParametricRealFunction f;
  
  public CurveFitter$TheoreticalValuesFunction(CurveFitter paramCurveFitter, ParametricRealFunction f)
  {
    this.f = f;
  }
  
  public MultivariateMatrixFunction jacobian()
  {
    new MultivariateMatrixFunction()
    {
      public double[][] value(double[] point)
        throws FunctionEvaluationException, IllegalArgumentException
      {
        double[][] jacobian = new double[CurveFitter.access$000(this$0).size()][];
        
        int i = 0;
        for (WeightedObservedPoint observed : CurveFitter.access$000(this$0)) {
          jacobian[(i++)] = f.gradient(observed.getX(), point);
        }
        return jacobian;
      }
    };
  }
  
  public double[] value(double[] point)
    throws FunctionEvaluationException, IllegalArgumentException
  {
    double[] values = new double[CurveFitter.access$000(this$0).size()];
    int i = 0;
    for (WeightedObservedPoint observed : CurveFitter.access$000(this$0)) {
      values[(i++)] = f.value(observed.getX(), point);
    }
    return values;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.CurveFitter.TheoreticalValuesFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */