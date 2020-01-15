package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import java.util.Comparator;

class MultiStartDifferentiableMultivariateVectorialOptimizer$1
  implements Comparator<VectorialPointValuePair>
{
  MultiStartDifferentiableMultivariateVectorialOptimizer$1(MultiStartDifferentiableMultivariateVectorialOptimizer paramMultiStartDifferentiableMultivariateVectorialOptimizer, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2) {}
  
  public int compare(VectorialPointValuePair o1, VectorialPointValuePair o2)
  {
    if (o1 == null) {
      return o2 == null ? 0 : 1;
    }
    if (o2 == null) {
      return -1;
    }
    return Double.compare(weightedResidual(o1), weightedResidual(o2));
  }
  
  private double weightedResidual(VectorialPointValuePair pv)
  {
    double[] value = pv.getValueRef();
    double sum = 0.0D;
    for (int i = 0; i < value.length; i++)
    {
      double ri = value[i] - val$target[i];
      sum += val$weights[i] * ri * ri;
    }
    return sum;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.MultiStartDifferentiableMultivariateVectorialOptimizer.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */