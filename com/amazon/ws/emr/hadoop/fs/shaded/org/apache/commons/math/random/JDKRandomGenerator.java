package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import java.util.Random;

public class JDKRandomGenerator
  extends Random
  implements RandomGenerator
{
  private static final long serialVersionUID = -7745277476784028798L;
  
  public void setSeed(int seed)
  {
    setSeed(seed);
  }
  
  public void setSeed(int[] seed)
  {
    long prime = 4294967291L;
    
    long combined = 0L;
    for (int s : seed) {
      combined = combined * 4294967291L + s;
    }
    setSeed(combined);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.JDKRandomGenerator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */