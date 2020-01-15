package com.amazonaws.services.sqs.buffered;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class AmazonSQSBufferedAsyncClient$CachingMap
  extends LinkedHashMap<String, QueueBuffer>
{
  private static final long serialVersionUID = 1L;
  private static final int MAX_ENTRIES = 100;
  
  public AmazonSQSBufferedAsyncClient$CachingMap(AmazonSQSBufferedAsyncClient this$0, int initial, float loadFactor, boolean accessOrder)
  {
    super(initial, loadFactor, accessOrder);
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, QueueBuffer> eldest)
  {
    return size() > 100;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient.CachingMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */