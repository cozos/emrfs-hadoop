package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Closeable;
import java.io.IOException;

public class SelectObjectContentResult
  implements Closeable
{
  private SelectObjectContentEventStream payload;
  
  public SelectObjectContentEventStream getPayload()
  {
    return payload;
  }
  
  public void setPayload(SelectObjectContentEventStream payload)
  {
    this.payload = payload;
  }
  
  public SelectObjectContentResult withPayload(SelectObjectContentEventStream payload)
  {
    setPayload(payload);
    return this;
  }
  
  public void close()
    throws IOException
  {
    if (payload != null) {
      payload.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */