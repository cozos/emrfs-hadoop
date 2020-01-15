package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import java.util.concurrent.FutureTask;

public class HttpRequestFutureTask<V>
  extends FutureTask<V>
{
  private final HttpUriRequest request;
  private final HttpRequestTaskCallable<V> callable;
  
  public HttpRequestFutureTask(HttpUriRequest request, HttpRequestTaskCallable<V> httpCallable)
  {
    super(httpCallable);
    this.request = request;
    callable = httpCallable;
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    callable.cancel();
    if (mayInterruptIfRunning) {
      request.abort();
    }
    return super.cancel(mayInterruptIfRunning);
  }
  
  public long scheduledTime()
  {
    return callable.getScheduled();
  }
  
  public long startedTime()
  {
    return callable.getStarted();
  }
  
  public long endedTime()
  {
    if (isDone()) {
      return callable.getEnded();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public long requestDuration()
  {
    if (isDone()) {
      return endedTime() - startedTime();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public long taskDuration()
  {
    if (isDone()) {
      return endedTime() - scheduledTime();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public String toString()
  {
    return request.getRequestLine().getUri();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpRequestFutureTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */