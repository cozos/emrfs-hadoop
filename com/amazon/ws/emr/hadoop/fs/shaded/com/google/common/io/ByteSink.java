package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class ByteSink
{
  public CharSink asCharSink(Charset charset)
  {
    return new AsCharSink(charset, null);
  }
  
  public abstract OutputStream openStream()
    throws IOException;
  
  public OutputStream openBufferedStream()
    throws IOException
  {
    OutputStream out = openStream();
    return (out instanceof BufferedOutputStream) ? (BufferedOutputStream)out : new BufferedOutputStream(out);
  }
  
  public void write(byte[] bytes)
    throws IOException
  {
    Preconditions.checkNotNull(bytes);
    
    Closer closer = Closer.create();
    try
    {
      OutputStream out = (OutputStream)closer.register(openStream());
      out.write(bytes);
      out.flush();
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public long writeFrom(InputStream input)
    throws IOException
  {
    Preconditions.checkNotNull(input);
    
    Closer closer = Closer.create();
    try
    {
      OutputStream out = (OutputStream)closer.register(openStream());
      long written = ByteStreams.copy(input, out);
      out.flush();
      return written;
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  private final class AsCharSink
    extends CharSink
  {
    private final Charset charset;
    
    private AsCharSink(Charset charset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(charset));
    }
    
    public Writer openStream()
      throws IOException
    {
      return new OutputStreamWriter(openStream(), charset);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(ByteSink.this.toString()));String str2 = String.valueOf(String.valueOf(charset));return 13 + str1.length() + str2.length() + str1 + ".asCharSink(" + str2 + ")";
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */