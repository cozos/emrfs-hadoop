package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

public class GaussianRandomGenerator
  implements NormalizedRandomGenerator
{
  private final RandomGenerator generator;
  
  public GaussianRandomGenerator(RandomGenerator generator)
  {
    this.generator = generator;
  }
  
  public double nextNormalizedDouble()
  {
    return generator.nextGaussian();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.GaussianRandomGenerator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */