package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

public class UniformRandomGenerator
  implements NormalizedRandomGenerator
{
  private static final long serialVersionUID = 1569292426375546027L;
  private static final double SQRT3 = Math.sqrt(3.0D);
  private final RandomGenerator generator;
  
  public UniformRandomGenerator(RandomGenerator generator)
  {
    this.generator = generator;
  }
  
  public double nextNormalizedDouble()
  {
    return SQRT3 * (2.0D * generator.nextDouble() - 1.0D);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.UniformRandomGenerator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */