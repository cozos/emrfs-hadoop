package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.SummaryStatistics;
import java.io.IOException;
import java.util.List;

class EmpiricalDistributionImpl$ArrayDataAdapter
  extends EmpiricalDistributionImpl.DataAdapter
{
  private double[] inputArray;
  
  public EmpiricalDistributionImpl$ArrayDataAdapter(EmpiricalDistributionImpl paramEmpiricalDistributionImpl, double[] in)
  {
    super(paramEmpiricalDistributionImpl, null);
    inputArray = in;
  }
  
  public void computeStats()
    throws IOException
  {
    EmpiricalDistributionImpl.access$302(this$0, new SummaryStatistics());
    for (int i = 0; i < inputArray.length; i++) {
      EmpiricalDistributionImpl.access$300(this$0).addValue(inputArray[i]);
    }
  }
  
  public void computeBinStats()
    throws IOException
  {
    for (int i = 0; i < inputArray.length; i++)
    {
      SummaryStatistics stats = (SummaryStatistics)EmpiricalDistributionImpl.access$200(this$0).get(EmpiricalDistributionImpl.access$100(this$0, inputArray[i]));
      
      stats.addValue(inputArray[i]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.EmpiricalDistributionImpl.ArrayDataAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */