package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueueBufferConfig
{
  public static final int MAX_BATCH_SIZE_DEFAULT = 10;
  private int maxBatchSize;
  public static final long SERVICE_MAX_BATCH_SIZE_BYTES = 262144L;
  private long maxBatchOpenMs;
  public static final long MAX_BATCH_OPEN_MS_DEFAULT = 200L;
  private boolean deleteInBackground = false;
  private boolean longPoll;
  private static final boolean LONG_POLL_DEFAULT = true;
  private int maxInflightOutboundBatches;
  public static final int MAX_INFLIGHT_OUTBOUND_BATCHES_DEFAULT = 5;
  private int maxInflightReceiveBatches;
  public static final int MAX_INFLIGHT_RECEIVE_BATCHES_DEFAULT = 10;
  private int maxDoneReceiveBatches;
  public static final int MAX_DONE_RECEIVE_BATCHES_DEFAULT = 10;
  private long maxBatchSizeBytes;
  public static final long MAX_BATCH_SIZE_BYTES_DEFAULT = 262144L;
  private int visibilityTimeoutSeconds;
  public static final int VISIBILITY_TIMEOUT_SECONDS_DEFAULT = -1;
  private int longPollWaitTimeoutSeconds;
  public static final int LONGPOLL_WAIT_TIMEOUT_SECONDS_DEFAULT = 20;
  private int minReceiveWaitTimeMs = 50;
  public static final int MIN_RECEIVE_WAIT_TIME_MS_DEFAULT = 50;
  private List<String> receiveMessageAttributeNames = RECEIVE_MESSAGE_ATTRIBUTE_NAMES_DEFAULT;
  public static final List<String> RECEIVE_MESSAGE_ATTRIBUTE_NAMES_DEFAULT = ;
  private List<String> receiveAttributeNames = RECEIVE_ATTRIBUTE_NAMES_DEFAULT;
  public static final List<String> RECEIVE_ATTRIBUTE_NAMES_DEFAULT = Collections.emptyList();
  private boolean adaptivePrefetching = false;
  public static final boolean ADAPTIVE_PREFETCHING_DEFAULT = false;
  private boolean flushOnShutdown = false;
  
  public QueueBufferConfig(long maxBatchOpenMs, int maxInflightOutboundBatches, int maxInflightReceiveBatches, int maxDoneReceiveBatches, boolean paramLongPoll, long maxBatchSizeBytes, int visibilityTimeout, int longPollTimeout, int maxBatch)
  {
    this.maxBatchOpenMs = maxBatchOpenMs;
    this.maxInflightOutboundBatches = maxInflightOutboundBatches;
    this.maxInflightReceiveBatches = maxInflightReceiveBatches;
    this.maxDoneReceiveBatches = maxDoneReceiveBatches;
    longPoll = paramLongPoll;
    this.maxBatchSizeBytes = maxBatchSizeBytes;
    visibilityTimeoutSeconds = visibilityTimeout;
    longPollWaitTimeoutSeconds = longPollTimeout;
    maxBatchSize = maxBatch;
  }
  
  public QueueBufferConfig()
  {
    this(200L, 5, 10, 10, true, 262144L, -1, 20, 10);
  }
  
  public QueueBufferConfig(QueueBufferConfig other)
  {
    longPoll = longPoll;
    longPollWaitTimeoutSeconds = longPollWaitTimeoutSeconds;
    minReceiveWaitTimeMs = minReceiveWaitTimeMs;
    maxBatchOpenMs = maxBatchOpenMs;
    maxBatchSize = maxBatchSize;
    maxBatchSizeBytes = maxBatchSizeBytes;
    maxDoneReceiveBatches = maxDoneReceiveBatches;
    maxInflightOutboundBatches = maxInflightOutboundBatches;
    maxInflightReceiveBatches = maxInflightReceiveBatches;
    visibilityTimeoutSeconds = visibilityTimeoutSeconds;
    flushOnShutdown = flushOnShutdown;
    receiveAttributeNames = receiveAttributeNames;
    receiveMessageAttributeNames = receiveMessageAttributeNames;
    adaptivePrefetching = adaptivePrefetching;
    deleteInBackground = deleteInBackground;
  }
  
  public String toString()
  {
    return "QueueBufferConfig [maxBatchSize=" + maxBatchSize + ", maxBatchOpenMs=" + maxBatchOpenMs + ", longPoll=" + longPoll + ", maxInflightOutboundBatches=" + maxInflightOutboundBatches + ", maxInflightReceiveBatches=" + maxInflightReceiveBatches + ", maxDoneReceiveBatches=" + maxDoneReceiveBatches + ", maxBatchSizeBytes=" + maxBatchSizeBytes + ", visibilityTimeoutSeconds=" + visibilityTimeoutSeconds + ", longPollWaitTimeoutSeconds=" + longPollWaitTimeoutSeconds + "]";
  }
  
  public long getMaxBatchOpenMs()
  {
    return maxBatchOpenMs;
  }
  
  public void setMaxBatchOpenMs(long maxBatchOpenMs)
  {
    this.maxBatchOpenMs = maxBatchOpenMs;
  }
  
  public QueueBufferConfig withMaxBatchOpenMs(long maxBatchOpenMs)
  {
    setMaxBatchOpenMs(maxBatchOpenMs);
    return this;
  }
  
  public boolean isDeleteInBackground()
  {
    return deleteInBackground;
  }
  
  public void setDeleteInBackground(boolean deleteInBackground)
  {
    this.deleteInBackground = deleteInBackground;
  }
  
  public QueueBufferConfig withDeleteInBackground(boolean deleteInBackground)
  {
    setDeleteInBackground(deleteInBackground);
    return this;
  }
  
  public boolean isLongPoll()
  {
    return longPoll;
  }
  
  public void setLongPoll(boolean longPoll)
  {
    this.longPoll = longPoll;
  }
  
  public QueueBufferConfig withLongPoll(boolean longPoll)
  {
    setLongPoll(longPoll);
    return this;
  }
  
  public int getMaxInflightOutboundBatches()
  {
    return maxInflightOutboundBatches;
  }
  
  public void setMaxInflightOutboundBatches(int maxInflightOutboundBatches)
  {
    this.maxInflightOutboundBatches = maxInflightOutboundBatches;
  }
  
  public QueueBufferConfig withMaxInflightOutboundBatches(int maxInflightOutboundBatches)
  {
    setMaxInflightOutboundBatches(maxInflightOutboundBatches);
    return this;
  }
  
  public int getMaxInflightReceiveBatches()
  {
    return maxInflightReceiveBatches;
  }
  
  public void setMaxInflightReceiveBatches(int maxInflightReceiveBatches)
  {
    this.maxInflightReceiveBatches = maxInflightReceiveBatches;
  }
  
  public QueueBufferConfig withMaxInflightReceiveBatches(int maxInflightReceiveBatches)
  {
    setMaxInflightReceiveBatches(maxInflightReceiveBatches);
    return this;
  }
  
  public int getMaxDoneReceiveBatches()
  {
    return maxDoneReceiveBatches;
  }
  
  public void setMaxDoneReceiveBatches(int maxDoneReceiveBatches)
  {
    this.maxDoneReceiveBatches = maxDoneReceiveBatches;
  }
  
  public QueueBufferConfig withMaxDoneReceiveBatches(int maxDoneReceiveBatches)
  {
    setMaxDoneReceiveBatches(maxDoneReceiveBatches);
    return this;
  }
  
  public long getMaxBatchSizeBytes()
  {
    return maxBatchSizeBytes;
  }
  
  public void setMaxBatchSizeBytes(long maxBatchSizeBytes)
  {
    if (maxBatchSizeBytes > 262144L) {
      throw new IllegalArgumentException("Maximum Size of the message cannot be greater than the allowed limit of 262144 bytes");
    }
    this.maxBatchSizeBytes = maxBatchSizeBytes;
  }
  
  public QueueBufferConfig withMaxBatchSizeBytes(long maxBatchSizeBytes)
  {
    setMaxBatchSizeBytes(maxBatchSizeBytes);
    return this;
  }
  
  public int getVisibilityTimeoutSeconds()
  {
    return visibilityTimeoutSeconds;
  }
  
  public void setVisibilityTimeoutSeconds(int visibilityTimeoutSeconds)
  {
    this.visibilityTimeoutSeconds = visibilityTimeoutSeconds;
  }
  
  public QueueBufferConfig withVisibilityTimeoutSeconds(int visibilityTimeoutSeconds)
  {
    setVisibilityTimeoutSeconds(visibilityTimeoutSeconds);
    return this;
  }
  
  public void setLongPollWaitTimeoutSeconds(int longPollWaitTimeoutSeconds)
  {
    this.longPollWaitTimeoutSeconds = longPollWaitTimeoutSeconds;
  }
  
  public int getLongPollWaitTimeoutSeconds()
  {
    return longPollWaitTimeoutSeconds;
  }
  
  public QueueBufferConfig withLongPollWaitTimeoutSeconds(int longPollWaitTimeoutSeconds)
  {
    setLongPollWaitTimeoutSeconds(longPollWaitTimeoutSeconds);
    return this;
  }
  
  public int getMinReceiveWaitTimeMs()
  {
    return minReceiveWaitTimeMs;
  }
  
  public void setMinReceiveWaitTimeMs(int minReceiveWaitTimeMs)
  {
    this.minReceiveWaitTimeMs = minReceiveWaitTimeMs;
  }
  
  public QueueBufferConfig withMinReceiveWaitTimeMs(int minReceiveWaitTimeMs)
  {
    setMinReceiveWaitTimeMs(minReceiveWaitTimeMs);
    return this;
  }
  
  public int getMaxBatchSize()
  {
    return maxBatchSize;
  }
  
  public void setMaxBatchSize(int maxBatchSize)
  {
    this.maxBatchSize = maxBatchSize;
  }
  
  public QueueBufferConfig withMaxBatchSize(int maxBatchSize)
  {
    setMaxBatchSize(maxBatchSize);
    return this;
  }
  
  public List<String> getReceiveAttributeNames()
  {
    return receiveAttributeNames;
  }
  
  public void setReceiveAttributeNames(List<String> receiveAttributeNames)
  {
    if (receiveAttributeNames == null) {
      this.receiveAttributeNames = Collections.emptyList();
    } else {
      this.receiveAttributeNames = Collections.unmodifiableList(new ArrayList(receiveAttributeNames));
    }
  }
  
  public QueueBufferConfig withReceiveAttributeNames(List<String> receiveAttributes)
  {
    setReceiveAttributeNames(receiveAttributes);
    return this;
  }
  
  public List<String> getReceiveMessageAttributeNames()
  {
    return receiveMessageAttributeNames;
  }
  
  public void setReceiveMessageAttributeNames(List<String> receiveMessageAttributeNames)
  {
    if (receiveMessageAttributeNames == null) {
      this.receiveMessageAttributeNames = Collections.emptyList();
    } else {
      this.receiveMessageAttributeNames = Collections.unmodifiableList(new ArrayList(receiveMessageAttributeNames));
    }
  }
  
  public QueueBufferConfig withReceiveMessageAttributeNames(List<String> receiveMessageAttributes)
  {
    setReceiveMessageAttributeNames(receiveMessageAttributes);
    return this;
  }
  
  public void setAdaptivePrefetching(boolean adaptivePrefetching)
  {
    this.adaptivePrefetching = adaptivePrefetching;
  }
  
  public boolean isAdapativePrefetching()
  {
    return adaptivePrefetching;
  }
  
  public QueueBufferConfig withAdapativePrefetching(boolean adaptivePrefetching)
  {
    setAdaptivePrefetching(adaptivePrefetching);
    return this;
  }
  
  public boolean isFlushOnShutdown()
  {
    return flushOnShutdown;
  }
  
  public void setFlushOnShutdown(boolean flushOnShutdown)
  {
    this.flushOnShutdown = flushOnShutdown;
  }
  
  public QueueBufferConfig withFlushOnShutdown(boolean flushOnShutdown)
  {
    setFlushOnShutdown(flushOnShutdown);
    return this;
  }
  
  void validate()
  {
    if (visibilityTimeoutSeconds == 0) {
      throw new AmazonClientException("Visibility timeout value may not be equal to zero ");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBufferConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */