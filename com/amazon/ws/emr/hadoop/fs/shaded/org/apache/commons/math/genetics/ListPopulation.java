package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ListPopulation
  implements Population
{
  private List<Chromosome> chromosomes;
  private int populationLimit;
  
  public ListPopulation(List<Chromosome> chromosomes, int populationLimit)
  {
    if (chromosomes.size() > populationLimit) {
      throw new IllegalArgumentException("List of chromosomes bigger than maxPopulationSize.");
    }
    if (populationLimit < 0) {
      throw new IllegalArgumentException("Population limit has to be >= 0");
    }
    this.chromosomes = chromosomes;
    this.populationLimit = populationLimit;
  }
  
  public ListPopulation(int populationLimit)
  {
    if (populationLimit < 0) {
      throw new IllegalArgumentException("Population limit has to be >= 0");
    }
    this.populationLimit = populationLimit;
    chromosomes = new ArrayList(populationLimit);
  }
  
  public void setChromosomes(List<Chromosome> chromosomes)
  {
    this.chromosomes = chromosomes;
  }
  
  public List<Chromosome> getChromosomes()
  {
    return chromosomes;
  }
  
  public void addChromosome(Chromosome chromosome)
  {
    chromosomes.add(chromosome);
  }
  
  public Chromosome getFittestChromosome()
  {
    Chromosome bestChromosome = (Chromosome)chromosomes.get(0);
    for (Chromosome chromosome : chromosomes) {
      if (chromosome.compareTo(bestChromosome) > 0) {
        bestChromosome = chromosome;
      }
    }
    return bestChromosome;
  }
  
  public int getPopulationLimit()
  {
    return populationLimit;
  }
  
  public void setPopulationLimit(int populationLimit)
  {
    this.populationLimit = populationLimit;
  }
  
  public int getPopulationSize()
  {
    return chromosomes.size();
  }
  
  public String toString()
  {
    return chromosomes.toString();
  }
  
  public Iterator<Chromosome> iterator()
  {
    return chromosomes.iterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.ListPopulation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */