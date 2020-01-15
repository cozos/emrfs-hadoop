package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Progress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Stats;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

class ProgressStaxUnmarshaller
  implements Unmarshaller<Progress, StaxUnmarshallerContext>
{
  private static final ProgressStaxUnmarshaller instance = new ProgressStaxUnmarshaller();
  
  public static ProgressStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public Progress unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    Stats queryStats = StatsStaxUnmarshaller.getInstance().unmarshall(context);
    return new Progress().withBytesProcessed(queryStats.getBytesProcessed())
      .withBytesReturned(queryStats.getBytesReturned())
      .withBytesScanned(queryStats.getBytesScanned());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ProgressStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */