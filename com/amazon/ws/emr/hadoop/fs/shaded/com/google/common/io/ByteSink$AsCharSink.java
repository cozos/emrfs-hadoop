package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

final class ByteSink$AsCharSink
  extends CharSink
{
  private final Charset charset;
  
  private ByteSink$AsCharSink(ByteSink paramByteSink, Charset charset)
  {
    this.charset = ((Charset)Preconditions.checkNotNull(charset));
  }
  
  public Writer openStream()
    throws IOException
  {
    return new OutputStreamWriter(this$0.openStream(), charset);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(this$0.toString()));String str2 = String.valueOf(String.valueOf(charset));return 13 + str1.length() + str2.length() + str1 + ".asCharSink(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSink.AsCharSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */