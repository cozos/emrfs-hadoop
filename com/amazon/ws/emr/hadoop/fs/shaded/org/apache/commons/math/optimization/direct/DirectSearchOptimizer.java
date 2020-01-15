package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.direct;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.MultivariateRealOptimizer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealConvergenceChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.SimpleScalarValueChecker;
import java.util.Arrays;
import java.util.Comparator;

public abstract class DirectSearchOptimizer
  implements MultivariateRealOptimizer
{
  private static final String EQUAL_VERTICES_MESSAGE = "equal vertices {0} and {1} in simplex configuration";
  private static final String DIMENSION_MISMATCH_MESSAGE = "dimension mismatch {0} != {1}";
  protected RealPointValuePair[] simplex;
  private MultivariateRealFunction f;
  private RealConvergenceChecker checker;
  private int maxIterations;
  private int iterations;
  private int maxEvaluations;
  private int evaluations;
  private double[][] startConfiguration;
  
  protected DirectSearchOptimizer()
  {
    setConvergenceChecker(new SimpleScalarValueChecker());
    setMaxIterations(Integer.MAX_VALUE);
    setMaxEvaluations(Integer.MAX_VALUE);
  }
  
  public void setStartConfiguration(double[] steps)
    throws IllegalArgumentException
  {
    int n = steps.length;
    startConfiguration = new double[n][n];
    for (int i = 0; i < n; i++)
    {
      double[] vertexI = startConfiguration[i];
      for (int j = 0; j < i + 1; j++)
      {
        if (steps[j] == 0.0D) {
          throw MathRuntimeException.createIllegalArgumentException("equal vertices {0} and {1} in simplex configuration", new Object[] { Integer.valueOf(j), Integer.valueOf(j + 1) });
        }
        System.arraycopy(steps, 0, vertexI, 0, j + 1);
      }
    }
  }
  
  public void setStartConfiguration(double[][] referenceSimplex)
    throws IllegalArgumentException
  {
    int n = referenceSimplex.length - 1;
    if (n < 0) {
      throw MathRuntimeException.createIllegalArgumentException("simplex must contain at least one point", new Object[0]);
    }
    startConfiguration = new double[n][n];
    double[] ref0 = referenceSimplex[0];
    for (int i = 0; i < n + 1; i++)
    {
      double[] refI = referenceSimplex[i];
      if (refI.length != n) {
        throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(refI.length), Integer.valueOf(n) });
      }
      for (int j = 0; j < i; j++)
      {
        double[] refJ = referenceSimplex[j];
        boolean allEquals = true;
        for (int k = 0; k < n; k++) {
          if (refI[k] != refJ[k])
          {
            allEquals = false;
            break;
          }
        }
        if (allEquals) {
          throw MathRuntimeException.createIllegalArgumentException("equal vertices {0} and {1} in simplex configuration", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        }
      }
      if (i > 0)
      {
        double[] confI = startConfiguration[(i - 1)];
        for (int k = 0; k < n; k++) {
          refI[k] -= ref0[k];
        }
      }
    }
  }
  
  public void setMaxIterations(int maxIterations)
  {
    this.maxIterations = maxIterations;
  }
  
  public int getMaxIterations()
  {
    return maxIterations;
  }
  
  public void setMaxEvaluations(int maxEvaluations)
  {
    this.maxEvaluations = maxEvaluations;
  }
  
  public int getMaxEvaluations()
  {
    return maxEvaluations;
  }
  
  public int getIterations()
  {
    return iterations;
  }
  
  public int getEvaluations()
  {
    return evaluations;
  }
  
  public void setConvergenceChecker(RealConvergenceChecker convergenceChecker)
  {
    checker = convergenceChecker;
  }
  
  public RealConvergenceChecker getConvergenceChecker()
  {
    return checker;
  }
  
  public RealPointValuePair optimize(MultivariateRealFunction function, final GoalType goalType, double[] startPoint)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException
  {
    if (startConfiguration == null)
    {
      double[] unit = new double[startPoint.length];
      Arrays.fill(unit, 1.0D);
      setStartConfiguration(unit);
    }
    f = function;
    Comparator<RealPointValuePair> comparator = new Comparator()
    {
      public int compare(RealPointValuePair o1, RealPointValuePair o2)
      {
        double v1 = o1.getValue();
        double v2 = o2.getValue();
        return goalType == GoalType.MINIMIZE ? Double.compare(v1, v2) : Double.compare(v2, v1);
      }
    };
    iterations = 0;
    evaluations = 0;
    buildSimplex(startPoint);
    evaluateSimplex(comparator);
    
    RealPointValuePair[] previous = new RealPointValuePair[simplex.length];
    for (;;)
    {
      if (iterations > 0)
      {
        boolean converged = true;
        for (int i = 0; i < simplex.length; i++) {
          converged &= checker.converged(iterations, previous[i], simplex[i]);
        }
        if (converged) {
          return simplex[0];
        }
      }
      System.arraycopy(simplex, 0, previous, 0, simplex.length);
      iterateSimplex(comparator);
    }
  }
  
  protected void incrementIterationsCounter()
    throws OptimizationException
  {
    if (++iterations > maxIterations) {
      throw new OptimizationException(new MaxIterationsExceededException(maxIterations));
    }
  }
  
  protected abstract void iterateSimplex(Comparator<RealPointValuePair> paramComparator)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;
  
  protected double evaluate(double[] x)
    throws FunctionEvaluationException, IllegalArgumentException
  {
    if (++evaluations > maxEvaluations) {
      throw new FunctionEvaluationException(new MaxEvaluationsExceededException(maxEvaluations), x);
    }
    return f.value(x);
  }
  
  private void buildSimplex(double[] startPoint)
    throws IllegalArgumentException
  {
    int n = startPoint.length;
    if (n != startConfiguration.length) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(n), Integer.valueOf(startConfiguration.length) });
    }
    simplex = new RealPointValuePair[n + 1];
    simplex[0] = new RealPointValuePair(startPoint, NaN.0D);
    for (int i = 0; i < n; i++)
    {
      double[] confI = startConfiguration[i];
      double[] vertexI = new double[n];
      for (int k = 0; k < n; k++) {
        startPoint[k] += confI[k];
      }
      simplex[(i + 1)] = new RealPointValuePair(vertexI, NaN.0D);
    }
  }
  
  protected void evaluateSimplex(Comparator<RealPointValuePair> comparator)
    throws FunctionEvaluationException, OptimizationException
  {
    for (int i = 0; i < simplex.length; i++)
    {
      RealPointValuePair vertex = simplex[i];
      double[] point = vertex.getPointRef();
      if (Double.isNaN(vertex.getValue())) {
        simplex[i] = new RealPointValuePair(point, evaluate(point), false);
      }
    }
    Arrays.sort(simplex, comparator);
  }
  
  protected void replaceWorstPoint(RealPointValuePair pointValuePair, Comparator<RealPointValuePair> comparator)
  {
    int n = simplex.length - 1;
    for (int i = 0; i < n; i++) {
      if (comparator.compare(simplex[i], pointValuePair) > 0)
      {
        RealPointValuePair tmp = simplex[i];
        simplex[i] = pointValuePair;
        pointValuePair = tmp;
      }
    }
    simplex[n] = pointValuePair;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.direct.DirectSearchOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */