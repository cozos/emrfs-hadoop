package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

final class ByteSource$AsCharSource
  extends CharSource
{
  private final Charset charset;
  
  private ByteSource$AsCharSource(ByteSource paramByteSource, Charset charset)
  {
    this.charset = ((Charset)Preconditions.checkNotNull(charset));
  }
  
  public Reader openStream()
    throws IOException
  {
    return new InputStreamReader(this$0.openStream(), charset);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(this$0.toString()));String str2 = String.valueOf(String.valueOf(charset));return 15 + str1.length() + str2.length() + str1 + ".asCharSource(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSource.AsCharSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */