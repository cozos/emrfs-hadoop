package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixVisitorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrixPreservingVisitor;
import java.util.Arrays;

class AdamsMoultonIntegrator$Corrector
  implements RealMatrixPreservingVisitor
{
  private final double[] previous;
  private final double[] scaled;
  private final double[] before;
  private final double[] after;
  
  public AdamsMoultonIntegrator$Corrector(AdamsMoultonIntegrator paramAdamsMoultonIntegrator, double[] previous, double[] scaled, double[] state)
  {
    this.previous = previous;
    this.scaled = scaled;
    after = state;
    before = ((double[])state.clone());
  }
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    Arrays.fill(after, 0.0D);
  }
  
  public void visit(int row, int column, double value)
    throws MatrixVisitorException
  {
    if ((row & 0x1) == 0) {
      after[column] -= value;
    } else {
      after[column] += value;
    }
  }
  
  public double end()
  {
    double error = 0.0D;
    for (int i = 0; i < after.length; i++)
    {
      after[i] += previous[i] + scaled[i];
      double yScale = Math.max(Math.abs(previous[i]), Math.abs(after[i]));
      double tol = this$0.vecAbsoluteTolerance == null ? this$0.scalAbsoluteTolerance + this$0.scalRelativeTolerance * yScale : this$0.vecAbsoluteTolerance[i] + this$0.vecRelativeTolerance[i] * yScale;
      
      double ratio = (after[i] - before[i]) / tol;
      error += ratio * ratio;
    }
    return Math.sqrt(error / after.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdamsMoultonIntegrator.Corrector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */