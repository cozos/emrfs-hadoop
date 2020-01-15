package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableUnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import java.io.Serializable;
import java.util.Arrays;

public class PolynomialFunction
  implements DifferentiableUnivariateRealFunction, Serializable
{
  private static final String EMPTY_ARRAY_MESSAGE = "empty polynomials coefficients array";
  private static final long serialVersionUID = -7726511984200295583L;
  private final double[] coefficients;
  
  public PolynomialFunction(double[] c)
  {
    if (c.length < 1) {
      throw MathRuntimeException.createIllegalArgumentException("empty polynomials coefficients array", new Object[0]);
    }
    int l = c.length;
    while ((l > 1) && (c[(l - 1)] == 0.0D)) {
      l--;
    }
    coefficients = new double[l];
    System.arraycopy(c, 0, coefficients, 0, l);
  }
  
  public double value(double x)
  {
    return evaluate(coefficients, x);
  }
  
  public int degree()
  {
    return coefficients.length - 1;
  }
  
  public double[] getCoefficients()
  {
    return (double[])coefficients.clone();
  }
  
  protected static double evaluate(double[] coefficients, double argument)
  {
    int n = coefficients.length;
    if (n < 1) {
      throw MathRuntimeException.createIllegalArgumentException("empty polynomials coefficients array", new Object[0]);
    }
    double result = coefficients[(n - 1)];
    for (int j = n - 2; j >= 0; j--) {
      result = argument * result + coefficients[j];
    }
    return result;
  }
  
  public PolynomialFunction add(PolynomialFunction p)
  {
    int lowLength = Math.min(coefficients.length, coefficients.length);
    int highLength = Math.max(coefficients.length, coefficients.length);
    
    double[] newCoefficients = new double[highLength];
    for (int i = 0; i < lowLength; i++) {
      newCoefficients[i] = (coefficients[i] + coefficients[i]);
    }
    System.arraycopy(coefficients.length < coefficients.length ? coefficients : coefficients, lowLength, newCoefficients, lowLength, highLength - lowLength);
    
    return new PolynomialFunction(newCoefficients);
  }
  
  public PolynomialFunction subtract(PolynomialFunction p)
  {
    int lowLength = Math.min(coefficients.length, coefficients.length);
    int highLength = Math.max(coefficients.length, coefficients.length);
    
    double[] newCoefficients = new double[highLength];
    for (int i = 0; i < lowLength; i++) {
      newCoefficients[i] = (coefficients[i] - coefficients[i]);
    }
    if (coefficients.length < coefficients.length) {
      for (int i = lowLength; i < highLength; i++) {
        newCoefficients[i] = (-coefficients[i]);
      }
    } else {
      System.arraycopy(coefficients, lowLength, newCoefficients, lowLength, highLength - lowLength);
    }
    return new PolynomialFunction(newCoefficients);
  }
  
  public PolynomialFunction negate()
  {
    double[] newCoefficients = new double[coefficients.length];
    for (int i = 0; i < coefficients.length; i++) {
      newCoefficients[i] = (-coefficients[i]);
    }
    return new PolynomialFunction(newCoefficients);
  }
  
  public PolynomialFunction multiply(PolynomialFunction p)
  {
    double[] newCoefficients = new double[coefficients.length + coefficients.length - 1];
    for (int i = 0; i < newCoefficients.length; i++)
    {
      newCoefficients[i] = 0.0D;
      for (int j = Math.max(0, i + 1 - coefficients.length); j < Math.min(coefficients.length, i + 1); j++) {
        newCoefficients[i] += coefficients[j] * coefficients[(i - j)];
      }
    }
    return new PolynomialFunction(newCoefficients);
  }
  
  protected static double[] differentiate(double[] coefficients)
  {
    int n = coefficients.length;
    if (n < 1) {
      throw MathRuntimeException.createIllegalArgumentException("empty polynomials coefficients array", new Object[0]);
    }
    if (n == 1) {
      return new double[] { 0.0D };
    }
    double[] result = new double[n - 1];
    for (int i = n - 1; i > 0; i--) {
      result[(i - 1)] = (i * coefficients[i]);
    }
    return result;
  }
  
  public PolynomialFunction polynomialDerivative()
  {
    return new PolynomialFunction(differentiate(coefficients));
  }
  
  public UnivariateRealFunction derivative()
  {
    return polynomialDerivative();
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer();
    if (coefficients[0] == 0.0D)
    {
      if (coefficients.length == 1) {
        return "0";
      }
    }
    else {
      s.append(Double.toString(coefficients[0]));
    }
    for (int i = 1; i < coefficients.length; i++) {
      if (coefficients[i] != 0.0D)
      {
        if (s.length() > 0)
        {
          if (coefficients[i] < 0.0D) {
            s.append(" - ");
          } else {
            s.append(" + ");
          }
        }
        else if (coefficients[i] < 0.0D) {
          s.append("-");
        }
        double absAi = Math.abs(coefficients[i]);
        if (absAi - 1.0D != 0.0D)
        {
          s.append(Double.toString(absAi));
          s.append(' ');
        }
        s.append("x");
        if (i > 1)
        {
          s.append('^');
          s.append(Integer.toString(i));
        }
      }
    }
    return s.toString();
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + Arrays.hashCode(coefficients);
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PolynomialFunction)) {
      return false;
    }
    PolynomialFunction other = (PolynomialFunction)obj;
    if (!Arrays.equals(coefficients, coefficients)) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */