package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.UnitSphereRandomVectorGenerator;

public class MicrosphereInterpolator
  implements MultivariateRealInterpolator
{
  public static final int DEFAULT_MICROSPHERE_ELEMENTS = 2000;
  public static final int DEFAULT_BRIGHTNESS_EXPONENT = 2;
  private int microsphereElements;
  private int brightnessExponent;
  
  public MicrosphereInterpolator()
  {
    this(2000, 2);
  }
  
  public MicrosphereInterpolator(int microsphereElements, int brightnessExponent)
  {
    setMicropshereElements(microsphereElements);
    setBrightnessExponent(brightnessExponent);
  }
  
  public MultivariateRealFunction interpolate(double[][] xval, double[] yval)
    throws MathException, IllegalArgumentException
  {
    UnitSphereRandomVectorGenerator rand = new UnitSphereRandomVectorGenerator(xval[0].length);
    
    return new MicrosphereInterpolatingFunction(xval, yval, brightnessExponent, microsphereElements, rand);
  }
  
  public void setBrightnessExponent(int brightnessExponent)
  {
    if (brightnessExponent < 0) {
      throw MathRuntimeException.createIllegalArgumentException("brightness exponent should be positive or null, but got {0}", new Object[] { Integer.valueOf(brightnessExponent) });
    }
    this.brightnessExponent = brightnessExponent;
  }
  
  public void setMicropshereElements(int elements)
  {
    if (microsphereElements < 0) {
      throw MathRuntimeException.createIllegalArgumentException("number of microsphere elements must be positive, but got {0}", new Object[] { Integer.valueOf(microsphereElements) });
    }
    microsphereElements = elements;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.MicrosphereInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */