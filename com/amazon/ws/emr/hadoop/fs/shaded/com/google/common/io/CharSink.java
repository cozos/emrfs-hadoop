package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class CharSink
{
  public abstract Writer openStream()
    throws IOException;
  
  public Writer openBufferedStream()
    throws IOException
  {
    Writer writer = openStream();
    return (writer instanceof BufferedWriter) ? (BufferedWriter)writer : new BufferedWriter(writer);
  }
  
  public void write(CharSequence charSequence)
    throws IOException
  {
    Preconditions.checkNotNull(charSequence);
    
    Closer closer = Closer.create();
    try
    {
      Writer out = (Writer)closer.register(openStream());
      out.append(charSequence);
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
  
  public void writeLines(Iterable<? extends CharSequence> lines)
    throws IOException
  {
    writeLines(lines, System.getProperty("line.separator"));
  }
  
  public void writeLines(Iterable<? extends CharSequence> lines, String lineSeparator)
    throws IOException
  {
    Preconditions.checkNotNull(lines);
    Preconditions.checkNotNull(lineSeparator);
    
    Closer closer = Closer.create();
    try
    {
      Writer out = (Writer)closer.register(openBufferedStream());
      for (CharSequence line : lines) {
        out.append(line).append(lineSeparator);
      }
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
  
  public long writeFrom(Readable readable)
    throws IOException
  {
    Preconditions.checkNotNull(readable);
    
    Closer closer = Closer.create();
    try
    {
      Writer out = (Writer)closer.register(openStream());
      long written = CharStreams.copy(readable, out);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */