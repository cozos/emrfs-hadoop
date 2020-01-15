package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Comparator;

@Beta
public final class MinMaxPriorityQueue$Builder<B>
{
  private static final int UNSET_EXPECTED_SIZE = -1;
  private final Comparator<B> comparator;
  private int expectedSize = -1;
  private int maximumSize = Integer.MAX_VALUE;
  
  private MinMaxPriorityQueue$Builder(Comparator<B> comparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(comparator));
  }
  
  public Builder<B> expectedSize(int expectedSize)
  {
    Preconditions.checkArgument(expectedSize >= 0);
    this.expectedSize = expectedSize;
    return this;
  }
  
  public Builder<B> maximumSize(int maximumSize)
  {
    Preconditions.checkArgument(maximumSize > 0);
    this.maximumSize = maximumSize;
    return this;
  }
  
  public <T extends B> MinMaxPriorityQueue<T> create()
  {
    return create(Collections.emptySet());
  }
  
  public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> initialContents)
  {
    MinMaxPriorityQueue<T> queue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(expectedSize, maximumSize, initialContents), null);
    for (T element : initialContents) {
      queue.offer(element);
    }
    return queue;
  }
  
  private <T extends B> Ordering<T> ordering()
  {
    return Ordering.from(comparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MinMaxPriorityQueue.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */