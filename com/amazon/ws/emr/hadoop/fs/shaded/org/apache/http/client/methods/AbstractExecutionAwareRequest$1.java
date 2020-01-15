package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;

class AbstractExecutionAwareRequest$1
  implements Cancellable
{
  AbstractExecutionAwareRequest$1(AbstractExecutionAwareRequest paramAbstractExecutionAwareRequest, ClientConnectionRequest paramClientConnectionRequest) {}
  
  public boolean cancel()
  {
    val$connRequest.abortRequest();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.AbstractExecutionAwareRequest.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */