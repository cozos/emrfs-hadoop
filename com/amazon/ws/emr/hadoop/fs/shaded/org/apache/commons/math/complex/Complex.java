package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.MathUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Complex
  implements FieldElement<Complex>, Serializable
{
  public static final Complex I = new Complex(0.0D, 1.0D);
  public static final Complex NaN = new Complex(NaN.0D, NaN.0D);
  public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
  public static final Complex ONE = new Complex(1.0D, 0.0D);
  public static final Complex ZERO = new Complex(0.0D, 0.0D);
  private static final long serialVersionUID = -6195664516687396620L;
  private final double imaginary;
  private final double real;
  private final transient boolean isNaN;
  private final transient boolean isInfinite;
  
  public Complex(double real, double imaginary)
  {
    this.real = real;
    this.imaginary = imaginary;
    
    isNaN = ((Double.isNaN(real)) || (Double.isNaN(imaginary)));
    isInfinite = ((!isNaN) && ((Double.isInfinite(real)) || (Double.isInfinite(imaginary))));
  }
  
  public double abs()
  {
    if (isNaN()) {
      return NaN.0D;
    }
    if (isInfinite()) {
      return Double.POSITIVE_INFINITY;
    }
    if (Math.abs(real) < Math.abs(imaginary))
    {
      if (imaginary == 0.0D) {
        return Math.abs(real);
      }
      double q = real / imaginary;
      return Math.abs(imaginary) * Math.sqrt(1.0D + q * q);
    }
    if (real == 0.0D) {
      return Math.abs(imaginary);
    }
    double q = imaginary / real;
    return Math.abs(real) * Math.sqrt(1.0D + q * q);
  }
  
  public Complex add(Complex rhs)
  {
    return createComplex(real + rhs.getReal(), imaginary + rhs.getImaginary());
  }
  
  public Complex conjugate()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(real, -imaginary);
  }
  
  public Complex divide(Complex rhs)
  {
    if ((isNaN()) || (rhs.isNaN())) {
      return NaN;
    }
    double c = rhs.getReal();
    double d = rhs.getImaginary();
    if ((c == 0.0D) && (d == 0.0D)) {
      return NaN;
    }
    if ((rhs.isInfinite()) && (!isInfinite())) {
      return ZERO;
    }
    if (Math.abs(c) < Math.abs(d))
    {
      double q = c / d;
      double denominator = c * q + d;
      return createComplex((real * q + imaginary) / denominator, (imaginary * q - real) / denominator);
    }
    double q = d / c;
    double denominator = d * q + c;
    return createComplex((imaginary * q + real) / denominator, (imaginary - real * q) / denominator);
  }
  
  public boolean equals(Object other)
  {
    if (this == other) {
      return true;
    }
    if ((other instanceof Complex))
    {
      Complex rhs = (Complex)other;
      if (rhs.isNaN()) {
        return isNaN();
      }
      return (real == real) && (imaginary == imaginary);
    }
    return false;
  }
  
  public int hashCode()
  {
    if (isNaN()) {
      return 7;
    }
    return 37 * (17 * MathUtils.hash(imaginary) + MathUtils.hash(real));
  }
  
  public double getImaginary()
  {
    return imaginary;
  }
  
  public double getReal()
  {
    return real;
  }
  
  public boolean isNaN()
  {
    return isNaN;
  }
  
  public boolean isInfinite()
  {
    return isInfinite;
  }
  
  public Complex multiply(Complex rhs)
  {
    if ((isNaN()) || (rhs.isNaN())) {
      return NaN;
    }
    if ((Double.isInfinite(real)) || (Double.isInfinite(imaginary)) || (Double.isInfinite(real)) || (Double.isInfinite(imaginary))) {
      return INF;
    }
    return createComplex(real * real - imaginary * imaginary, real * imaginary + imaginary * real);
  }
  
  public Complex multiply(double rhs)
  {
    if ((isNaN()) || (Double.isNaN(rhs))) {
      return NaN;
    }
    if ((Double.isInfinite(real)) || (Double.isInfinite(imaginary)) || (Double.isInfinite(rhs))) {
      return INF;
    }
    return createComplex(real * rhs, imaginary * rhs);
  }
  
  public Complex negate()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(-real, -imaginary);
  }
  
  public Complex subtract(Complex rhs)
  {
    if ((isNaN()) || (rhs.isNaN())) {
      return NaN;
    }
    return createComplex(real - rhs.getReal(), imaginary - rhs.getImaginary());
  }
  
  public Complex acos()
  {
    if (isNaN()) {
      return NaN;
    }
    return add(sqrt1z().multiply(I)).log().multiply(I.negate());
  }
  
  public Complex asin()
  {
    if (isNaN()) {
      return NaN;
    }
    return sqrt1z().add(multiply(I)).log().multiply(I.negate());
  }
  
  public Complex atan()
  {
    if (isNaN()) {
      return NaN;
    }
    return add(I).divide(I.subtract(this)).log().multiply(I.divide(createComplex(2.0D, 0.0D)));
  }
  
  public Complex cos()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(Math.cos(real) * MathUtils.cosh(imaginary), -Math.sin(real) * MathUtils.sinh(imaginary));
  }
  
  public Complex cosh()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(MathUtils.cosh(real) * Math.cos(imaginary), MathUtils.sinh(real) * Math.sin(imaginary));
  }
  
  public Complex exp()
  {
    if (isNaN()) {
      return NaN;
    }
    double expReal = Math.exp(real);
    return createComplex(expReal * Math.cos(imaginary), expReal * Math.sin(imaginary));
  }
  
  public Complex log()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(Math.log(abs()), Math.atan2(imaginary, real));
  }
  
  public Complex pow(Complex x)
  {
    if (x == null) {
      throw new NullPointerException();
    }
    return log().multiply(x).exp();
  }
  
  public Complex sin()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(Math.sin(real) * MathUtils.cosh(imaginary), Math.cos(real) * MathUtils.sinh(imaginary));
  }
  
  public Complex sinh()
  {
    if (isNaN()) {
      return NaN;
    }
    return createComplex(MathUtils.sinh(real) * Math.cos(imaginary), MathUtils.cosh(real) * Math.sin(imaginary));
  }
  
  public Complex sqrt()
  {
    if (isNaN()) {
      return NaN;
    }
    if ((real == 0.0D) && (imaginary == 0.0D)) {
      return createComplex(0.0D, 0.0D);
    }
    double t = Math.sqrt((Math.abs(real) + abs()) / 2.0D);
    if (real >= 0.0D) {
      return createComplex(t, imaginary / (2.0D * t));
    }
    return createComplex(Math.abs(imaginary) / (2.0D * t), MathUtils.indicator(imaginary) * t);
  }
  
  public Complex sqrt1z()
  {
    return createComplex(1.0D, 0.0D).subtract(multiply(this)).sqrt();
  }
  
  public Complex tan()
  {
    if (isNaN()) {
      return NaN;
    }
    double real2 = 2.0D * real;
    double imaginary2 = 2.0D * imaginary;
    double d = Math.cos(real2) + MathUtils.cosh(imaginary2);
    
    return createComplex(Math.sin(real2) / d, MathUtils.sinh(imaginary2) / d);
  }
  
  public Complex tanh()
  {
    if (isNaN()) {
      return NaN;
    }
    double real2 = 2.0D * real;
    double imaginary2 = 2.0D * imaginary;
    double d = MathUtils.cosh(real2) + Math.cos(imaginary2);
    
    return createComplex(MathUtils.sinh(real2) / d, Math.sin(imaginary2) / d);
  }
  
  public double getArgument()
  {
    return Math.atan2(getImaginary(), getReal());
  }
  
  public List<Complex> nthRoot(int n)
    throws IllegalArgumentException
  {
    if (n <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot compute nth root for null or negative n: {0}", new Object[] { Integer.valueOf(n) });
    }
    List<Complex> result = new ArrayList();
    if (isNaN())
    {
      result.add(NaN);
      return result;
    }
    if (isInfinite())
    {
      result.add(INF);
      return result;
    }
    double nthRootOfAbs = Math.pow(abs(), 1.0D / n);
    
    double nthPhi = getArgument() / n;
    double slice = 6.283185307179586D / n;
    double innerPart = nthPhi;
    for (int k = 0; k < n; k++)
    {
      double realPart = nthRootOfAbs * Math.cos(innerPart);
      double imaginaryPart = nthRootOfAbs * Math.sin(innerPart);
      result.add(createComplex(realPart, imaginaryPart));
      innerPart += slice;
    }
    return result;
  }
  
  protected Complex createComplex(double realPart, double imaginaryPart)
  {
    return new Complex(realPart, imaginaryPart);
  }
  
  protected final Object readResolve()
  {
    return createComplex(real, imaginary);
  }
  
  public ComplexField getField()
  {
    return ComplexField.getInstance();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex.Complex
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */