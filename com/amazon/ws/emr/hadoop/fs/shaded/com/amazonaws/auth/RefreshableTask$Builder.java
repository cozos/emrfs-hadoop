package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import java.util.concurrent.Callable;

@NotThreadSafe
public class RefreshableTask$Builder<T>
{
  private Callable<T> refreshCallable;
  private SdkPredicate<T> shouldDoBlockingRefresh;
  private SdkPredicate<T> shouldDoAsyncRefresh;
  
  public Builder withRefreshCallable(Callable<T> refreshCallable)
  {
    this.refreshCallable = refreshCallable;
    return this;
  }
  
  public Builder withBlockingRefreshPredicate(SdkPredicate<T> shouldDoBlockingRefresh)
  {
    this.shouldDoBlockingRefresh = shouldDoBlockingRefresh;
    return this;
  }
  
  public Builder withAsyncRefreshPredicate(SdkPredicate<T> shouldDoAsyncRefresh)
  {
    this.shouldDoAsyncRefresh = shouldDoAsyncRefresh;
    return this;
  }
  
  public RefreshableTask<T> build()
  {
    return new RefreshableTask(refreshCallable, shouldDoBlockingRefresh, shouldDoAsyncRefresh, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RefreshableTask.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */