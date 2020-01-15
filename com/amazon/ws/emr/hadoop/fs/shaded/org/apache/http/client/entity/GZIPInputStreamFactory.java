package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class GZIPInputStreamFactory
  implements InputStreamFactory
{
  private static final GZIPInputStreamFactory INSTANCE = new GZIPInputStreamFactory();
  
  public static GZIPInputStreamFactory getInstance()
  {
    return INSTANCE;
  }
  
  public InputStream create(InputStream inputStream)
    throws IOException
  {
    return new GZIPInputStream(inputStream);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.GZIPInputStreamFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */