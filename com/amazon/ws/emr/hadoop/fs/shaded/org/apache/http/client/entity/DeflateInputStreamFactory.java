package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.IOException;
import java.io.InputStream;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DeflateInputStreamFactory
  implements InputStreamFactory
{
  private static final DeflateInputStreamFactory INSTANCE = new DeflateInputStreamFactory();
  
  public static DeflateInputStreamFactory getInstance()
  {
    return INSTANCE;
  }
  
  public InputStream create(InputStream inputStream)
    throws IOException
  {
    return new DeflateInputStream(inputStream);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DeflateInputStreamFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */