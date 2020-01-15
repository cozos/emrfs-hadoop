package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@Beta
@GwtIncompatible("java.util.ArrayDeque")
public final class EvictingQueue<E>
  extends ForwardingQueue<E>
  implements Serializable
{
  private final Queue<E> delegate;
  @VisibleForTesting
  final int maxSize;
  private static final long serialVersionUID = 0L;
  
  private EvictingQueue(int maxSize)
  {
    Preconditions.checkArgument(maxSize >= 0, "maxSize (%s) must >= 0", new Object[] { Integer.valueOf(maxSize) });
    delegate = new ArrayDeque(maxSize);
    this.maxSize = maxSize;
  }
  
  public static <E> EvictingQueue<E> create(int maxSize)
  {
    return new EvictingQueue(maxSize);
  }
  
  public int remainingCapacity()
  {
    return maxSize - size();
  }
  
  protected Queue<E> delegate()
  {
    return delegate;
  }
  
  public boolean offer(E e)
  {
    return add(e);
  }
  
  public boolean add(E e)
  {
    Preconditions.checkNotNull(e);
    if (maxSize == 0) {
      return true;
    }
    if (size() == maxSize) {
      delegate.remove();
    }
    delegate.add(e);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> collection)
  {
    return standardAddAll(collection);
  }
  
  public boolean contains(Object object)
  {
    return delegate().contains(Preconditions.checkNotNull(object));
  }
  
  public boolean remove(Object object)
  {
    return delegate().remove(Preconditions.checkNotNull(object));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EvictingQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */