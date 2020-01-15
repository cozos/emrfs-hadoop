package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.BufferedReader;

class EmpiricalDistributionImpl$DataAdapterFactory
{
  private EmpiricalDistributionImpl$DataAdapterFactory(EmpiricalDistributionImpl paramEmpiricalDistributionImpl) {}
  
  public EmpiricalDistributionImpl.DataAdapter getAdapter(Object in)
  {
    if ((in instanceof BufferedReader))
    {
      BufferedReader inputStream = (BufferedReader)in;
      return new EmpiricalDistributionImpl.StreamDataAdapter(this$0, inputStream);
    }
    if ((in instanceof double[]))
    {
      double[] inputArray = (double[])in;
      return new EmpiricalDistributionImpl.ArrayDataAdapter(this$0, inputArray);
    }
    throw MathRuntimeException.createIllegalArgumentException("input data comes from unsupported datasource: {0}, supported sources: {1}, {2}", new Object[] { in.getClass().getName(), BufferedReader.class.getName(), double[].class.getName() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.EmpiricalDistributionImpl.DataAdapterFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */