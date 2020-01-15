package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateMatrixFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DecompositionSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.InvalidMatrixException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecompositionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.SimpleVectorialValueChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.VectorialConvergenceChecker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.VectorialPointValuePair;

public abstract class AbstractLeastSquaresOptimizer
  implements DifferentiableMultivariateVectorialOptimizer
{
  public static final int DEFAULT_MAX_ITERATIONS = 100;
  protected VectorialConvergenceChecker checker;
  protected double[][] jacobian;
  protected int cols;
  protected int rows;
  protected double[] targetValues;
  protected double[] residualsWeights;
  protected double[] point;
  protected double[] objective;
  protected double[] residuals;
  protected double cost;
  private int maxIterations;
  private int iterations;
  private int maxEvaluations;
  private int objectiveEvaluations;
  private int jacobianEvaluations;
  private DifferentiableMultivariateVectorialFunction function;
  private MultivariateMatrixFunction jF;
  
  protected AbstractLeastSquaresOptimizer()
  {
    setConvergenceChecker(new SimpleVectorialValueChecker());
    setMaxIterations(100);
    setMaxEvaluations(Integer.MAX_VALUE);
  }
  
  public void setMaxIterations(int maxIterations)
  {
    this.maxIterations = maxIterations;
  }
  
  public int getMaxIterations()
  {
    return maxIterations;
  }
  
  public int getIterations()
  {
    return iterations;
  }
  
  public void setMaxEvaluations(int maxEvaluations)
  {
    this.maxEvaluations = maxEvaluations;
  }
  
  public int getMaxEvaluations()
  {
    return maxEvaluations;
  }
  
  public int getEvaluations()
  {
    return objectiveEvaluations;
  }
  
  public int getJacobianEvaluations()
  {
    return jacobianEvaluations;
  }
  
  public void setConvergenceChecker(VectorialConvergenceChecker convergenceChecker)
  {
    checker = convergenceChecker;
  }
  
  public VectorialConvergenceChecker getConvergenceChecker()
  {
    return checker;
  }
  
  protected void incrementIterationsCounter()
    throws OptimizationException
  {
    if (++iterations > maxIterations) {
      throw new OptimizationException(new MaxIterationsExceededException(maxIterations));
    }
  }
  
  protected void updateJacobian()
    throws FunctionEvaluationException
  {
    jacobianEvaluations += 1;
    jacobian = jF.value(point);
    if (jacobian.length != rows) {
      throw new FunctionEvaluationException(point, "dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(jacobian.length), Integer.valueOf(rows) });
    }
    for (int i = 0; i < rows; i++)
    {
      double[] ji = jacobian[i];
      double factor = -Math.sqrt(residualsWeights[i]);
      for (int j = 0; j < cols; j++) {
        ji[j] *= factor;
      }
    }
  }
  
  protected void updateResidualsAndCost()
    throws FunctionEvaluationException
  {
    if (++objectiveEvaluations > maxEvaluations) {
      throw new FunctionEvaluationException(new MaxEvaluationsExceededException(maxEvaluations), point);
    }
    objective = function.value(point);
    if (objective.length != rows) {
      throw new FunctionEvaluationException(point, "dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(objective.length), Integer.valueOf(rows) });
    }
    cost = 0.0D;
    int index = 0;
    for (int i = 0; i < rows; i++)
    {
      double residual = targetValues[i] - objective[i];
      residuals[i] = residual;
      cost += residualsWeights[i] * residual * residual;
      index += cols;
    }
    cost = Math.sqrt(cost);
  }
  
  public double getRMS()
  {
    double criterion = 0.0D;
    for (int i = 0; i < rows; i++)
    {
      double residual = residuals[i];
      criterion += residualsWeights[i] * residual * residual;
    }
    return Math.sqrt(criterion / rows);
  }
  
  public double getChiSquare()
  {
    double chiSquare = 0.0D;
    for (int i = 0; i < rows; i++)
    {
      double residual = residuals[i];
      chiSquare += residual * residual / residualsWeights[i];
    }
    return chiSquare;
  }
  
  public double[][] getCovariances()
    throws FunctionEvaluationException, OptimizationException
  {
    updateJacobian();
    
    double[][] jTj = new double[cols][cols];
    for (int i = 0; i < cols; i++) {
      for (int j = i; j < cols; j++)
      {
        double sum = 0.0D;
        for (int k = 0; k < rows; k++) {
          sum += jacobian[k][i] * jacobian[k][j];
        }
        jTj[i][j] = sum;
        jTj[j][i] = sum;
      }
    }
    try
    {
      RealMatrix inverse = new LUDecompositionImpl(MatrixUtils.createRealMatrix(jTj)).getSolver().getInverse();
      
      return inverse.getData();
    }
    catch (InvalidMatrixException ime)
    {
      throw new OptimizationException("unable to compute covariances: singular problem", new Object[0]);
    }
  }
  
  public double[] guessParametersErrors()
    throws FunctionEvaluationException, OptimizationException
  {
    if (rows <= cols) {
      throw new OptimizationException("no degrees of freedom ({0} measurements, {1} parameters)", new Object[] { Integer.valueOf(rows), Integer.valueOf(cols) });
    }
    double[] errors = new double[cols];
    double c = Math.sqrt(getChiSquare() / (rows - cols));
    double[][] covar = getCovariances();
    for (int i = 0; i < errors.length; i++) {
      errors[i] = (Math.sqrt(covar[i][i]) * c);
    }
    return errors;
  }
  
  public VectorialPointValuePair optimize(DifferentiableMultivariateVectorialFunction f, double[] target, double[] weights, double[] startPoint)
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException
  {
    if (target.length != weights.length) {
      throw new OptimizationException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(target.length), Integer.valueOf(weights.length) });
    }
    iterations = 0;
    objectiveEvaluations = 0;
    jacobianEvaluations = 0;
    
    function = f;
    jF = f.jacobian();
    targetValues = ((double[])target.clone());
    residualsWeights = ((double[])weights.clone());
    point = ((double[])startPoint.clone());
    residuals = new double[target.length];
    
    rows = target.length;
    cols = point.length;
    jacobian = new double[rows][cols];
    
    cost = Double.POSITIVE_INFINITY;
    
    return doOptimize();
  }
  
  protected abstract VectorialPointValuePair doOptimize()
    throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.AbstractLeastSquaresOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */