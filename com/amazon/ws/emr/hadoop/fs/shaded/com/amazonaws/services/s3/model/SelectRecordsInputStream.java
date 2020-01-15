package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SelectRecordsInputStream
  extends SdkFilterInputStream
{
  private final SdkFilterInputStream abortableHttpStream;
  
  SelectRecordsInputStream(InputStream selectResultStream, SdkFilterInputStream abortableHttpStream)
  {
    super(selectResultStream);
    this.abortableHttpStream = abortableHttpStream;
  }
  
  public void abort()
  {
    super.abort();
    abortableHttpStream.abort();
  }
  
  public void close()
    throws IOException
  {
    super.close();
    abortableHttpStream.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectRecordsInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */