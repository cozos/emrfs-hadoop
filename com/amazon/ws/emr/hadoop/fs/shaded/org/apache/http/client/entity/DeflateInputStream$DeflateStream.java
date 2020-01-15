package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class DeflateInputStream$DeflateStream
  extends InflaterInputStream
{
  private boolean closed = false;
  
  public DeflateInputStream$DeflateStream(InputStream in, Inflater inflater)
  {
    super(in, inflater);
  }
  
  public void close()
    throws IOException
  {
    if (closed) {
      return;
    }
    closed = true;
    inf.end();
    super.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DeflateInputStream.DeflateStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */