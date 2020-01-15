package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

import java.util.Collections;
import java.util.List;

public class ElitisticListPopulation
  extends ListPopulation
{
  private double elitismRate = 0.9D;
  
  public ElitisticListPopulation(List<Chromosome> chromosomes, int populationLimit, double elitismRate)
  {
    super(chromosomes, populationLimit);
    this.elitismRate = elitismRate;
  }
  
  public ElitisticListPopulation(int populationLimit, double elitismRate)
  {
    super(populationLimit);
    this.elitismRate = elitismRate;
  }
  
  public Population nextGeneration()
  {
    ElitisticListPopulation nextGeneration = new ElitisticListPopulation(getPopulationLimit(), getElitismRate());
    
    List<Chromosome> oldChromosomes = getChromosomes();
    Collections.sort(oldChromosomes);
    
    int boundIndex = (int)Math.ceil((1.0D - getElitismRate()) * oldChromosomes.size());
    for (int i = boundIndex; i < oldChromosomes.size(); i++) {
      nextGeneration.addChromosome((Chromosome)oldChromosomes.get(i));
    }
    return nextGeneration;
  }
  
  public void setElitismRate(double elitismRate)
  {
    if ((elitismRate < 0.0D) || (elitismRate > 1.0D)) {
      throw new IllegalArgumentException("Elitism rate has to be in [0,1]");
    }
    this.elitismRate = elitismRate;
  }
  
  public double getElitismRate()
  {
    return elitismRate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.ElitisticListPopulation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */