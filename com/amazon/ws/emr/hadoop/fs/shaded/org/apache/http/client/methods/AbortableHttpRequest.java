package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionReleaseTrigger;
import java.io.IOException;

@Deprecated
public abstract interface AbortableHttpRequest
{
  public abstract void setConnectionRequest(ClientConnectionRequest paramClientConnectionRequest)
    throws IOException;
  
  public abstract void setReleaseTrigger(ConnectionReleaseTrigger paramConnectionReleaseTrigger)
    throws IOException;
  
  public abstract void abort();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.AbortableHttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */