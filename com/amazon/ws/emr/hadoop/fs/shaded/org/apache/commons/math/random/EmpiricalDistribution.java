package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.StatisticalSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.SummaryStatistics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public abstract interface EmpiricalDistribution
{
  public abstract void load(double[] paramArrayOfDouble);
  
  public abstract void load(File paramFile)
    throws IOException;
  
  public abstract void load(URL paramURL)
    throws IOException;
  
  public abstract double getNextValue()
    throws IllegalStateException;
  
  public abstract StatisticalSummary getSampleStats()
    throws IllegalStateException;
  
  public abstract boolean isLoaded();
  
  public abstract int getBinCount();
  
  public abstract List<SummaryStatistics> getBinStats();
  
  public abstract double[] getUpperBounds();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.EmpiricalDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */