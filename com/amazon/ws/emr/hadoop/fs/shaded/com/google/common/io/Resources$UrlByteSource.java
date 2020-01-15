package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

final class Resources$UrlByteSource
  extends ByteSource
{
  private final URL url;
  
  private Resources$UrlByteSource(URL url)
  {
    this.url = ((URL)Preconditions.checkNotNull(url));
  }
  
  public InputStream openStream()
    throws IOException
  {
    return url.openStream();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(url));return 24 + str.length() + "Resources.asByteSource(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Resources.UrlByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */