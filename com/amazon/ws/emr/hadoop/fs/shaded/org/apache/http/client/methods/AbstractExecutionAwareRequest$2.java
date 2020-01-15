package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionReleaseTrigger;
import java.io.IOException;

class AbstractExecutionAwareRequest$2
  implements Cancellable
{
  AbstractExecutionAwareRequest$2(AbstractExecutionAwareRequest paramAbstractExecutionAwareRequest, ConnectionReleaseTrigger paramConnectionReleaseTrigger) {}
  
  public boolean cancel()
  {
    try
    {
      val$releaseTrigger.abortConnection();
      return true;
    }
    catch (IOException ex) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.AbstractExecutionAwareRequest.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */