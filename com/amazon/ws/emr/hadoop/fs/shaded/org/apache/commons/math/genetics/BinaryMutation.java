package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.RandomGenerator;
import java.util.ArrayList;
import java.util.List;

public class BinaryMutation
  implements MutationPolicy
{
  public Chromosome mutate(Chromosome original)
  {
    if (!(original instanceof BinaryChromosome)) {
      throw new IllegalArgumentException("Binary mutation works on BinaryChromosome only.");
    }
    BinaryChromosome origChrom = (BinaryChromosome)original;
    List<Integer> newRepr = new ArrayList(origChrom.getRepresentation());
    
    int geneIndex = GeneticAlgorithm.getRandomGenerator().nextInt(origChrom.getLength());
    
    newRepr.set(geneIndex, Integer.valueOf(((Integer)origChrom.getRepresentation().get(geneIndex)).intValue() == 0 ? 1 : 0));
    
    Chromosome newChrom = origChrom.newFixedLengthChromosome(newRepr);
    return newChrom;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.BinaryMutation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */