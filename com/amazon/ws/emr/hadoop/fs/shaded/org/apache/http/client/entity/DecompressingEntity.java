package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DecompressingEntity
  extends HttpEntityWrapper
{
  private static final int BUFFER_SIZE = 2048;
  private final InputStreamFactory inputStreamFactory;
  private InputStream content;
  
  public DecompressingEntity(HttpEntity wrapped, InputStreamFactory inputStreamFactory)
  {
    super(wrapped);
    this.inputStreamFactory = inputStreamFactory;
  }
  
  private InputStream getDecompressingStream()
    throws IOException
  {
    InputStream in = wrappedEntity.getContent();
    return new LazyDecompressingInputStream(in, inputStreamFactory);
  }
  
  public InputStream getContent()
    throws IOException
  {
    if (wrappedEntity.isStreaming())
    {
      if (content == null) {
        content = getDecompressingStream();
      }
      return content;
    }
    return getDecompressingStream();
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    InputStream instream = getContent();
    try
    {
      byte[] buffer = new byte['ࠀ'];
      int l;
      while ((l = instream.read(buffer)) != -1) {
        outstream.write(buffer, 0, l);
      }
    }
    finally
    {
      instream.close();
    }
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return -1L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DecompressingEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */