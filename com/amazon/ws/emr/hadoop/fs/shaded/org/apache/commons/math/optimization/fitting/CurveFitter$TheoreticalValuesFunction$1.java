package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateMatrixFunction;
import java.util.List;

class CurveFitter$TheoreticalValuesFunction$1
  implements MultivariateMatrixFunction
{
  CurveFitter$TheoreticalValuesFunction$1(CurveFitter.TheoreticalValuesFunction paramTheoreticalValuesFunction) {}
  
  public double[][] value(double[] point)
    throws FunctionEvaluationException, IllegalArgumentException
  {
    double[][] jacobian = new double[CurveFitter.access$000(this$1.this$0).size()][];
    
    int i = 0;
    for (WeightedObservedPoint observed : CurveFitter.access$000(this$1.this$0)) {
      jacobian[(i++)] = CurveFitter.TheoreticalValuesFunction.access$100(this$1).gradient(observed.getX(), point);
    }
    return jacobian;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.CurveFitter.TheoreticalValuesFunction.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */