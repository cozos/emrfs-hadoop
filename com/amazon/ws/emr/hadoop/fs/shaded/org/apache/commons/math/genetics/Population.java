package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

public abstract interface Population
  extends Iterable<Chromosome>
{
  public abstract int getPopulationSize();
  
  public abstract int getPopulationLimit();
  
  public abstract Population nextGeneration();
  
  public abstract void addChromosome(Chromosome paramChromosome);
  
  public abstract Chromosome getFittestChromosome();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.Population
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */