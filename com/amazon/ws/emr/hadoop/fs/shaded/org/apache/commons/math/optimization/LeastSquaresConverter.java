package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateVectorialFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;

public class LeastSquaresConverter
  implements MultivariateRealFunction
{
  private final MultivariateVectorialFunction function;
  private final double[] observations;
  private final double[] weights;
  private final RealMatrix scale;
  
  public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations)
  {
    this.function = function;
    this.observations = ((double[])observations.clone());
    weights = null;
    scale = null;
  }
  
  public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations, double[] weights)
    throws IllegalArgumentException
  {
    if (observations.length != weights.length) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(observations.length), Integer.valueOf(weights.length) });
    }
    this.function = function;
    this.observations = ((double[])observations.clone());
    this.weights = ((double[])weights.clone());
    scale = null;
  }
  
  public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations, RealMatrix scale)
    throws IllegalArgumentException
  {
    if (observations.length != scale.getColumnDimension()) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(observations.length), Integer.valueOf(scale.getColumnDimension()) });
    }
    this.function = function;
    this.observations = ((double[])observations.clone());
    weights = null;
    this.scale = scale.copy();
  }
  
  public double value(double[] point)
    throws FunctionEvaluationException
  {
    double[] residuals = function.value(point);
    if (residuals.length != observations.length) {
      throw new FunctionEvaluationException(point, "dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(residuals.length), Integer.valueOf(observations.length) });
    }
    for (int i = 0; i < residuals.length; i++) {
      residuals[i] -= observations[i];
    }
    double sumSquares = 0.0D;
    if (weights != null) {
      for (int i = 0; i < residuals.length; i++)
      {
        double ri = residuals[i];
        sumSquares += weights[i] * ri * ri;
      }
    } else if (scale != null) {
      for (double yi : scale.operate(residuals)) {
        sumSquares += yi * yi;
      }
    } else {
      for (double ri : residuals) {
        sumSquares += ri * ri;
      }
    }
    return sumSquares;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.LeastSquaresConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */