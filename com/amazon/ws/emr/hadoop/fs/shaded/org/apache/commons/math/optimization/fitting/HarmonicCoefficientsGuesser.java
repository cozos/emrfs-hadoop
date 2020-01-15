package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;

public class HarmonicCoefficientsGuesser
{
  private final WeightedObservedPoint[] observations;
  private double a;
  private double omega;
  private double phi;
  
  public HarmonicCoefficientsGuesser(WeightedObservedPoint[] observations)
  {
    this.observations = ((WeightedObservedPoint[])observations.clone());
    a = NaN.0D;
    omega = NaN.0D;
  }
  
  public void guess()
    throws OptimizationException
  {
    sortObservations();
    guessAOmega();
    guessPhi();
  }
  
  private void sortObservations()
  {
    WeightedObservedPoint curr = observations[0];
    for (int j = 1; j < observations.length; j++)
    {
      WeightedObservedPoint prec = curr;
      curr = observations[j];
      if (curr.getX() < prec.getX())
      {
        int i = j - 1;
        WeightedObservedPoint mI = observations[i];
        while ((i >= 0) && (curr.getX() < mI.getX()))
        {
          observations[(i + 1)] = mI;
          if (i-- != 0) {
            mI = observations[i];
          } else {
            mI = null;
          }
        }
        observations[(i + 1)] = curr;
        curr = observations[j];
      }
    }
  }
  
  private void guessAOmega()
    throws OptimizationException
  {
    double sx2 = 0.0D;
    double sy2 = 0.0D;
    double sxy = 0.0D;
    double sxz = 0.0D;
    double syz = 0.0D;
    
    double currentX = observations[0].getX();
    double currentY = observations[0].getY();
    double f2Integral = 0.0D;
    double fPrime2Integral = 0.0D;
    double startX = currentX;
    for (int i = 1; i < observations.length; i++)
    {
      double previousX = currentX;
      double previousY = currentY;
      currentX = observations[i].getX();
      currentY = observations[i].getY();
      
      double dx = currentX - previousX;
      double dy = currentY - previousY;
      double f2StepIntegral = dx * (previousY * previousY + previousY * currentY + currentY * currentY) / 3.0D;
      
      double fPrime2StepIntegral = dy * dy / dx;
      
      double x = currentX - startX;
      f2Integral += f2StepIntegral;
      fPrime2Integral += fPrime2StepIntegral;
      
      sx2 += x * x;
      sy2 += f2Integral * f2Integral;
      sxy += x * f2Integral;
      sxz += x * fPrime2Integral;
      syz += f2Integral * fPrime2Integral;
    }
    double c1 = sy2 * sxz - sxy * syz;
    double c2 = sxy * sxz - sx2 * syz;
    double c3 = sx2 * sy2 - sxy * sxy;
    if ((c1 / c2 < 0.0D) || (c2 / c3 < 0.0D)) {
      throw new OptimizationException("unable to first guess the harmonic coefficients", new Object[0]);
    }
    a = Math.sqrt(c1 / c2);
    omega = Math.sqrt(c2 / c3);
  }
  
  private void guessPhi()
  {
    double fcMean = 0.0D;
    double fsMean = 0.0D;
    
    double currentX = observations[0].getX();
    double currentY = observations[0].getY();
    for (int i = 1; i < observations.length; i++)
    {
      double previousX = currentX;
      double previousY = currentY;
      currentX = observations[i].getX();
      currentY = observations[i].getY();
      double currentYPrime = (currentY - previousY) / (currentX - previousX);
      
      double omegaX = omega * currentX;
      double cosine = Math.cos(omegaX);
      double sine = Math.sin(omegaX);
      fcMean += omega * currentY * cosine - currentYPrime * sine;
      fsMean += omega * currentY * sine + currentYPrime * cosine;
    }
    phi = Math.atan2(-fsMean, fcMean);
  }
  
  public double getGuessedAmplitude()
  {
    return a;
  }
  
  public double getGuessedPulsation()
  {
    return omega;
  }
  
  public double getGuessedPhase()
  {
    return phi;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.HarmonicCoefficientsGuesser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */