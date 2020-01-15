package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

public class ChromosomePair
{
  private final Chromosome first;
  private final Chromosome second;
  
  public ChromosomePair(Chromosome c1, Chromosome c2)
  {
    first = c1;
    second = c2;
  }
  
  public Chromosome getFirst()
  {
    return first;
  }
  
  public Chromosome getSecond()
  {
    return second;
  }
  
  public String toString()
  {
    return String.format("(%s,%s)", new Object[] { getFirst(), getSecond() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.ChromosomePair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */