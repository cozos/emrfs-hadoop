package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.SummaryStatistics;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

class EmpiricalDistributionImpl$StreamDataAdapter
  extends EmpiricalDistributionImpl.DataAdapter
{
  private BufferedReader inputStream;
  
  public EmpiricalDistributionImpl$StreamDataAdapter(EmpiricalDistributionImpl paramEmpiricalDistributionImpl, BufferedReader in)
  {
    super(paramEmpiricalDistributionImpl, null);
    inputStream = in;
  }
  
  public void computeBinStats()
    throws IOException
  {
    String str = null;
    double val = 0.0D;
    while ((str = inputStream.readLine()) != null)
    {
      val = Double.parseDouble(str);
      SummaryStatistics stats = (SummaryStatistics)EmpiricalDistributionImpl.access$200(this$0).get(EmpiricalDistributionImpl.access$100(this$0, val));
      stats.addValue(val);
    }
    inputStream.close();
    inputStream = null;
  }
  
  public void computeStats()
    throws IOException
  {
    String str = null;
    double val = 0.0D;
    EmpiricalDistributionImpl.access$302(this$0, new SummaryStatistics());
    while ((str = inputStream.readLine()) != null)
    {
      val = Double.valueOf(str).doubleValue();
      EmpiricalDistributionImpl.access$300(this$0).addValue(val);
    }
    inputStream.close();
    inputStream = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.EmpiricalDistributionImpl.StreamDataAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */