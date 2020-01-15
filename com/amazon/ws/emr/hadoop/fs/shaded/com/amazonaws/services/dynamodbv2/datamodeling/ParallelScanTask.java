package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelScanTask
{
  private final List<ScanRequest> parallelScanRequests;
  private final int totalSegments;
  private final List<Future<ScanResult>> segmentScanFutureTasks;
  private final List<ScanResult> segmentScanResults;
  private final List<SegmentScanState> segmentScanStates;
  private ExecutorService executorService;
  private final AmazonDynamoDB dynamo;
  
  @Deprecated
  public ParallelScanTask(DynamoDBMapper mapper, AmazonDynamoDB dynamo, List<ScanRequest> parallelScanRequests)
  {
    this(dynamo, parallelScanRequests);
  }
  
  ParallelScanTask(AmazonDynamoDB dynamo, List<ScanRequest> parallelScanRequests)
  {
    this(dynamo, parallelScanRequests, Executors.newCachedThreadPool());
  }
  
  @SdkTestInternalApi
  ParallelScanTask(AmazonDynamoDB dynamo, List<ScanRequest> parallelScanRequests, ExecutorService executorService)
  {
    this.dynamo = dynamo;
    this.parallelScanRequests = parallelScanRequests;
    totalSegments = parallelScanRequests.size();
    this.executorService = executorService;
    
    segmentScanFutureTasks = Collections.synchronizedList(new ArrayList(totalSegments));
    segmentScanResults = Collections.synchronizedList(new ArrayList(totalSegments));
    
    segmentScanStates = Collections.synchronizedList(new ArrayList(totalSegments));
    
    initSegmentScanStates();
  }
  
  String getTableName()
  {
    return ((ScanRequest)parallelScanRequests.get(0)).getTableName();
  }
  
  public boolean isAllSegmentScanFinished()
  {
    synchronized (segmentScanStates)
    {
      for (int segment = 0; segment < totalSegments; segment++) {
        if (segmentScanStates.get(segment) != SegmentScanState.SegmentScanCompleted) {
          return false;
        }
      }
      executorService.shutdown();
      return true;
    }
  }
  
  public List<ScanResult> getNextBatchOfScanResults()
    throws SdkClientException
  {
    startScanNextPages();
    synchronized (segmentScanStates)
    {
      while ((segmentScanStates.contains(SegmentScanState.Waiting)) || 
        (segmentScanStates.contains(SegmentScanState.Scanning))) {
        try
        {
          segmentScanStates.wait();
        }
        catch (InterruptedException ie)
        {
          throw new SdkClientException("Parallel scan interrupted by other thread.", ie);
        }
      }
      return marshalParallelScanResults();
    }
  }
  
  private void startScanNextPages()
  {
    for (int segment = 0; segment < totalSegments; segment++)
    {
      final int currentSegment = segment;
      final SegmentScanState currentSegmentState = (SegmentScanState)segmentScanStates.get(currentSegment);
      if (currentSegmentState == SegmentScanState.Scanning) {
        throw new SdkClientException("Should never see a 'Scanning' state when starting parallel scans.");
      }
      if ((currentSegmentState == SegmentScanState.Failed) || (currentSegmentState == SegmentScanState.SegmentScanCompleted))
      {
        segmentScanResults.set(currentSegment, null);
      }
      else
      {
        synchronized (segmentScanStates)
        {
          segmentScanStates.set(currentSegment, SegmentScanState.Scanning);
          segmentScanStates.notifyAll();
        }
        Future<ScanResult> futureTask = executorService.submit(new Callable()
        {
          public ScanResult call()
            throws Exception
          {
            try
            {
              if (currentSegmentState == ParallelScanTask.SegmentScanState.HasNextPage) {
                return ParallelScanTask.this.scanNextPageOfSegment(currentSegment, true);
              }
              if (currentSegmentState == ParallelScanTask.SegmentScanState.Waiting) {
                return ParallelScanTask.this.scanNextPageOfSegment(currentSegment, false);
              }
              throw new SdkClientException("Should not start a new future task");
            }
            catch (Exception e)
            {
              synchronized (segmentScanStates)
              {
                segmentScanStates.set(currentSegment, ParallelScanTask.SegmentScanState.Failed);
                segmentScanStates.notifyAll();
                executorService.shutdown();
              }
              throw e;
            }
          }
        });
        segmentScanFutureTasks.set(currentSegment, futureTask);
      }
    }
  }
  
  private List<ScanResult> marshalParallelScanResults()
  {
    List<ScanResult> scanResults = new LinkedList();
    for (int segment = 0; segment < totalSegments; segment++)
    {
      SegmentScanState currentSegmentState = (SegmentScanState)segmentScanStates.get(segment);
      if (currentSegmentState == SegmentScanState.Failed) {
        try
        {
          ((Future)segmentScanFutureTasks.get(segment)).get();
          throw new SdkClientException("No Exception found in the failed scan task.");
        }
        catch (ExecutionException ee)
        {
          if ((ee.getCause() instanceof AmazonClientException)) {
            throw ((SdkClientException)ee.getCause());
          }
          throw new SdkClientException("Internal error during the scan on segment #" + segment + ".", ee.getCause());
        }
        catch (Exception e)
        {
          throw new SdkClientException("Error during the scan on segment #" + segment + ".", e);
        }
      }
      if ((currentSegmentState == SegmentScanState.HasNextPage) || (currentSegmentState == SegmentScanState.SegmentScanCompleted))
      {
        ScanResult scanResult = (ScanResult)segmentScanResults.get(segment);
        scanResults.add(scanResult);
      }
      else if ((currentSegmentState == SegmentScanState.Waiting) || (currentSegmentState == SegmentScanState.Scanning))
      {
        throw new SdkClientException("Should never see a 'Scanning' or 'Waiting' state when marshalling parallel scan results.");
      }
    }
    return scanResults;
  }
  
  private ScanResult scanNextPageOfSegment(int currentSegment, boolean checkLastEvaluatedKey)
  {
    ScanRequest segmentScanRequest = (ScanRequest)parallelScanRequests.get(currentSegment);
    if (checkLastEvaluatedKey)
    {
      ScanResult lastScanResult = (ScanResult)segmentScanResults.get(currentSegment);
      segmentScanRequest.setExclusiveStartKey(lastScanResult.getLastEvaluatedKey());
    }
    else
    {
      segmentScanRequest.setExclusiveStartKey(null);
    }
    ScanResult scanResult = dynamo.scan((ScanRequest)DynamoDBMapper.applyUserAgent(segmentScanRequest));
    
    segmentScanResults.set(currentSegment, scanResult);
    synchronized (segmentScanStates)
    {
      if (null == scanResult.getLastEvaluatedKey()) {
        segmentScanStates.set(currentSegment, SegmentScanState.SegmentScanCompleted);
      } else {
        segmentScanStates.set(currentSegment, SegmentScanState.HasNextPage);
      }
      segmentScanStates.notifyAll();
    }
    return scanResult;
  }
  
  private void initSegmentScanStates()
  {
    for (int segment = 0; segment < totalSegments; segment++)
    {
      segmentScanFutureTasks.add(null);
      segmentScanResults.add(null);
      segmentScanStates.add(SegmentScanState.Waiting);
    }
  }
  
  private static enum SegmentScanState
  {
    Waiting,  Scanning,  Failed,  HasNextPage,  SegmentScanCompleted;
    
    private SegmentScanState() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ParallelScanTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */