package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class ParallelScanTask$1
  implements Callable<ScanResult>
{
  ParallelScanTask$1(ParallelScanTask this$0, ParallelScanTask.SegmentScanState paramSegmentScanState, int paramInt) {}
  
  public ScanResult call()
    throws Exception
  {
    try
    {
      if (val$currentSegmentState == ParallelScanTask.SegmentScanState.HasNextPage) {
        return ParallelScanTask.access$000(this$0, val$currentSegment, true);
      }
      if (val$currentSegmentState == ParallelScanTask.SegmentScanState.Waiting) {
        return ParallelScanTask.access$000(this$0, val$currentSegment, false);
      }
      throw new SdkClientException("Should not start a new future task");
    }
    catch (Exception e)
    {
      synchronized (ParallelScanTask.access$100(this$0))
      {
        ParallelScanTask.access$100(this$0).set(val$currentSegment, ParallelScanTask.SegmentScanState.Failed);
        ParallelScanTask.access$100(this$0).notifyAll();
        ParallelScanTask.access$200(this$0).shutdown();
      }
      throw e;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ParallelScanTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */