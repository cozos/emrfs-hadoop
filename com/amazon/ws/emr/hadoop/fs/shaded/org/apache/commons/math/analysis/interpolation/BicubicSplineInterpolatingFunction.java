package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.DimensionMismatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.BivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;

public class BicubicSplineInterpolatingFunction
  implements BivariateRealFunction
{
  private static final double[][] AINV = { { 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { -3.0D, 3.0D, 0.0D, 0.0D, -2.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 2.0D, -2.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -3.0D, 3.0D, 0.0D, 0.0D, -2.0D, -1.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 2.0D, -2.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.0D, 0.0D }, { -3.0D, 0.0D, 3.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -2.0D, 0.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, -3.0D, 0.0D, 3.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -2.0D, 0.0D, -1.0D, 0.0D }, { 9.0D, -9.0D, -9.0D, 9.0D, 6.0D, 3.0D, -6.0D, -3.0D, 6.0D, -6.0D, 3.0D, -3.0D, 4.0D, 2.0D, 2.0D, 1.0D }, { -6.0D, 6.0D, 6.0D, -6.0D, -3.0D, -3.0D, 3.0D, 3.0D, -4.0D, 4.0D, -2.0D, 2.0D, -2.0D, -2.0D, -1.0D, -1.0D }, { 2.0D, 0.0D, -2.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D }, { 0.0D, 0.0D, 0.0D, 0.0D, 2.0D, 0.0D, -2.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 1.0D, 0.0D }, { -6.0D, 6.0D, 6.0D, -6.0D, -4.0D, -2.0D, 4.0D, 2.0D, -3.0D, 3.0D, -3.0D, 3.0D, -2.0D, -1.0D, -2.0D, -1.0D }, { 4.0D, -4.0D, -4.0D, 4.0D, 2.0D, 2.0D, -2.0D, -2.0D, 2.0D, -2.0D, 2.0D, -2.0D, 1.0D, 1.0D, 1.0D, 1.0D } };
  private final double[] xval;
  private final double[] yval;
  private final BicubicSplineFunction[][] splines;
  
  public BicubicSplineInterpolatingFunction(double[] x, double[] y, double[][] z, double[][] dZdX, double[][] dZdY, double[][] dZdXdY)
    throws DimensionMismatchException
  {
    int xLen = x.length;
    int yLen = y.length;
    if ((xLen == 0) || (yLen == 0) || (z.length == 0) || (z[0].length == 0)) {
      throw MathRuntimeException.createIllegalArgumentException("no data", new Object[0]);
    }
    if (xLen != z.length) {
      throw new DimensionMismatchException(xLen, z.length);
    }
    if (xLen != dZdX.length) {
      throw new DimensionMismatchException(xLen, dZdX.length);
    }
    if (xLen != dZdY.length) {
      throw new DimensionMismatchException(xLen, dZdY.length);
    }
    if (xLen != dZdXdY.length) {
      throw new DimensionMismatchException(xLen, dZdXdY.length);
    }
    MathUtils.checkOrder(x, 1, true);
    MathUtils.checkOrder(y, 1, true);
    
    xval = ((double[])x.clone());
    yval = ((double[])y.clone());
    
    int lastI = xLen - 1;
    int lastJ = yLen - 1;
    splines = new BicubicSplineFunction[lastI][lastJ];
    for (int i = 0; i < lastI; i++)
    {
      if (z[i].length != yLen) {
        throw new DimensionMismatchException(z[i].length, yLen);
      }
      if (dZdX[i].length != yLen) {
        throw new DimensionMismatchException(dZdX[i].length, yLen);
      }
      if (dZdY[i].length != yLen) {
        throw new DimensionMismatchException(dZdY[i].length, yLen);
      }
      if (dZdXdY[i].length != yLen) {
        throw new DimensionMismatchException(dZdXdY[i].length, yLen);
      }
      int ip1 = i + 1;
      for (int j = 0; j < lastJ; j++)
      {
        int jp1 = j + 1;
        double[] beta = { z[i][j], z[ip1][j], z[i][jp1], z[ip1][jp1], dZdX[i][j], dZdX[ip1][j], dZdX[i][jp1], dZdX[ip1][jp1], dZdY[i][j], dZdY[ip1][j], dZdY[i][jp1], dZdY[ip1][jp1], dZdXdY[i][j], dZdXdY[ip1][j], dZdXdY[i][jp1], dZdXdY[ip1][jp1] };
        
        splines[i][j] = new BicubicSplineFunction(computeSplineCoefficients(beta));
      }
    }
  }
  
  public double value(double x, double y)
  {
    int i = searchIndex(x, xval);
    if (i == -1) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(x), Double.valueOf(xval[0]), Double.valueOf(xval[(xval.length - 1)]) });
    }
    int j = searchIndex(y, yval);
    if (j == -1) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(y), Double.valueOf(yval[0]), Double.valueOf(yval[(yval.length - 1)]) });
    }
    double xN = (x - xval[i]) / (xval[(i + 1)] - xval[i]);
    double yN = (y - yval[j]) / (yval[(j + 1)] - yval[j]);
    
    return splines[i][j].value(xN, yN);
  }
  
  private int searchIndex(double c, double[] val)
  {
    if (c < val[0]) {
      return -1;
    }
    int max = val.length;
    for (int i = 1; i < max; i++) {
      if (c <= val[i]) {
        return i - 1;
      }
    }
    return -1;
  }
  
  private double[] computeSplineCoefficients(double[] beta)
  {
    double[] a = new double[16];
    for (int i = 0; i < 16; i++)
    {
      double result = 0.0D;
      double[] row = AINV[i];
      for (int j = 0; j < 16; j++) {
        result += row[j] * beta[j];
      }
      a[i] = result;
    }
    return a;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.BicubicSplineInterpolatingFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */