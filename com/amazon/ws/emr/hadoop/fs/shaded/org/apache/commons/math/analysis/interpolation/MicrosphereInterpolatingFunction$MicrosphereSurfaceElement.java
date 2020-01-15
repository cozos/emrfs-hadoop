package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.ArrayRealVector;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealVector;
import java.util.Map.Entry;

class MicrosphereInterpolatingFunction$MicrosphereSurfaceElement
{
  private final RealVector normal;
  private double brightestIllumination;
  private Map.Entry<RealVector, Double> brightestSample;
  
  MicrosphereInterpolatingFunction$MicrosphereSurfaceElement(double[] n)
  {
    normal = new ArrayRealVector(n);
  }
  
  RealVector normal()
  {
    return normal;
  }
  
  void reset()
  {
    brightestIllumination = 0.0D;
    brightestSample = null;
  }
  
  void store(double illuminationFromSample, Map.Entry<RealVector, Double> sample)
  {
    if (illuminationFromSample > brightestIllumination)
    {
      brightestIllumination = illuminationFromSample;
      brightestSample = sample;
    }
  }
  
  double illumination()
  {
    return brightestIllumination;
  }
  
  Map.Entry<RealVector, Double> sample()
  {
    return brightestSample;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.MicrosphereInterpolatingFunction.MicrosphereSurfaceElement
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */