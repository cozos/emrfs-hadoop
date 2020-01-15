package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.RandomGenerator;
import java.util.ArrayList;
import java.util.List;

public class RandomKeyMutation
  implements MutationPolicy
{
  public Chromosome mutate(Chromosome original)
  {
    if (!(original instanceof RandomKey)) {
      throw MathRuntimeException.createIllegalArgumentException("RandomKeyMutation works only with RandomKeys, got " + original.getClass().getSimpleName(), new Object[0]);
    }
    RandomKey<?> originalRk = (RandomKey)original;
    List<Double> repr = originalRk.getRepresentation();
    int rInd = GeneticAlgorithm.getRandomGenerator().nextInt(repr.size());
    
    List<Double> newRepr = new ArrayList(repr);
    newRepr.set(rInd, Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
    
    return originalRk.newFixedLengthChromosome(newRepr);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.genetics.RandomKeyMutation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */