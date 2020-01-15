package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class AggregateSummaryStatistics
  implements StatisticalSummary, Serializable
{
  private static final long serialVersionUID = -8207112444016386906L;
  private final SummaryStatistics statisticsPrototype;
  private final SummaryStatistics statistics;
  
  public AggregateSummaryStatistics()
  {
    this(new SummaryStatistics());
  }
  
  public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics)
  {
    this(prototypeStatistics, prototypeStatistics == null ? null : new SummaryStatistics(prototypeStatistics));
  }
  
  public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics, SummaryStatistics initialStatistics)
  {
    statisticsPrototype = (prototypeStatistics == null ? new SummaryStatistics() : prototypeStatistics);
    
    statistics = (initialStatistics == null ? new SummaryStatistics() : initialStatistics);
  }
  
  /* Error */
  public double getMax()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getMax	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #135	-> byte code offset #0
    //   Java source line #136	-> byte code offset #7
    //   Java source line #137	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getMean()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 48	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getMean	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #146	-> byte code offset #0
    //   Java source line #147	-> byte code offset #7
    //   Java source line #148	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getMin()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getMin	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #158	-> byte code offset #0
    //   Java source line #159	-> byte code offset #7
    //   Java source line #160	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public long getN()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 55	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getN	()J
    //   14: aload_1
    //   15: monitorexit
    //   16: lreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #169	-> byte code offset #0
    //   Java source line #170	-> byte code offset #7
    //   Java source line #171	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getStandardDeviation()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 58	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getStandardDeviation	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #181	-> byte code offset #0
    //   Java source line #182	-> byte code offset #7
    //   Java source line #183	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getSum()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 61	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getSum	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #192	-> byte code offset #0
    //   Java source line #193	-> byte code offset #7
    //   Java source line #194	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getVariance()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 64	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getVariance	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #204	-> byte code offset #0
    //   Java source line #205	-> byte code offset #7
    //   Java source line #206	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getSumOfLogs()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 67	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getSumOfLogs	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #216	-> byte code offset #0
    //   Java source line #217	-> byte code offset #7
    //   Java source line #218	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getGeometricMean()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 70	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getGeometricMean	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #228	-> byte code offset #0
    //   Java source line #229	-> byte code offset #7
    //   Java source line #230	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getSumsq()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 73	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getSumsq	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #240	-> byte code offset #0
    //   Java source line #241	-> byte code offset #7
    //   Java source line #242	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public double getSecondMoment()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   11: invokevirtual 76	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics:getSecondMoment	()D
    //   14: aload_1
    //   15: monitorexit
    //   16: dreturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #254	-> byte code offset #0
    //   Java source line #255	-> byte code offset #7
    //   Java source line #256	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	AggregateSummaryStatistics
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public StatisticalSummary getSummary()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:statistics	Lcom/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/SummaryStatistics;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: new 80	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/StatisticalSummaryValues
    //   10: dup
    //   11: aload_0
    //   12: invokevirtual 81	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getMean	()D
    //   15: aload_0
    //   16: invokevirtual 82	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getVariance	()D
    //   19: aload_0
    //   20: invokevirtual 83	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getN	()J
    //   23: aload_0
    //   24: invokevirtual 84	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getMax	()D
    //   27: aload_0
    //   28: invokevirtual 85	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getMin	()D
    //   31: aload_0
    //   32: invokevirtual 86	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/AggregateSummaryStatistics:getSum	()D
    //   35: invokespecial 89	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/math/stat/descriptive/StatisticalSummaryValues:<init>	(DDJDDD)V
    //   38: aload_1
    //   39: monitorexit
    //   40: areturn
    //   41: astore_2
    //   42: aload_1
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Line number table:
    //   Java source line #266	-> byte code offset #0
    //   Java source line #267	-> byte code offset #7
    //   Java source line #269	-> byte code offset #41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	AggregateSummaryStatistics
    //   5	38	1	Ljava/lang/Object;	Object
    //   41	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	40	41	finally
    //   41	44	41	finally
  }
  
  public SummaryStatistics createContributingStatistics()
  {
    SummaryStatistics contributingStatistics = new AggregatingSummaryStatistics(statistics);
    
    SummaryStatistics.copy(statisticsPrototype, contributingStatistics);
    
    return contributingStatistics;
  }
  
  public static StatisticalSummaryValues aggregate(Collection<SummaryStatistics> statistics)
  {
    if (statistics == null) {
      return null;
    }
    Iterator<SummaryStatistics> iterator = statistics.iterator();
    if (!iterator.hasNext()) {
      return null;
    }
    SummaryStatistics current = (SummaryStatistics)iterator.next();
    long n = current.getN();
    double min = current.getMin();
    double sum = current.getSum();
    double max = current.getMax();
    double m2 = current.getSecondMoment();
    double mean = current.getMean();
    while (iterator.hasNext())
    {
      current = (SummaryStatistics)iterator.next();
      if ((current.getMin() < min) || (Double.isNaN(min))) {
        min = current.getMin();
      }
      if ((current.getMax() > max) || (Double.isNaN(max))) {
        max = current.getMax();
      }
      sum += current.getSum();
      double oldN = n;
      double curN = current.getN();
      n = (n + curN);
      double meanDiff = current.getMean() - mean;
      mean = sum / n;
      m2 = m2 + current.getSecondMoment() + meanDiff * meanDiff * oldN * curN / n;
    }
    double variance;
    double variance;
    if (n == 0L)
    {
      variance = NaN.0D;
    }
    else
    {
      double variance;
      if (n == 1L) {
        variance = 0.0D;
      } else {
        variance = m2 / (n - 1L);
      }
    }
    return new StatisticalSummaryValues(mean, variance, n, max, min, sum);
  }
  
  private static class AggregatingSummaryStatistics
    extends SummaryStatistics
  {
    private static final long serialVersionUID = 1L;
    private final SummaryStatistics aggregateStatistics;
    
    public AggregatingSummaryStatistics(SummaryStatistics aggregateStatistics)
    {
      this.aggregateStatistics = aggregateStatistics;
    }
    
    public void addValue(double value)
    {
      super.addValue(value);
      synchronized (aggregateStatistics)
      {
        aggregateStatistics.addValue(value);
      }
    }
    
    public boolean equals(Object object)
    {
      if (object == this) {
        return true;
      }
      if (!(object instanceof AggregatingSummaryStatistics)) {
        return false;
      }
      AggregatingSummaryStatistics stat = (AggregatingSummaryStatistics)object;
      return (super.equals(stat)) && (aggregateStatistics.equals(aggregateStatistics));
    }
    
    public int hashCode()
    {
      return 123 + super.hashCode() + aggregateStatistics.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.AggregateSummaryStatistics
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */