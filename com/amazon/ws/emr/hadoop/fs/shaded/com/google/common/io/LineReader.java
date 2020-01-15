package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
public final class LineReader
{
  private final Readable readable;
  private final Reader reader;
  private final char[] buf = new char['က'];
  private final CharBuffer cbuf = CharBuffer.wrap(buf);
  private final Queue<String> lines = new LinkedList();
  private final LineBuffer lineBuf = new LineBuffer()
  {
    protected void handleLine(String line, String end)
    {
      lines.add(line);
    }
  };
  
  public LineReader(Readable readable)
  {
    this.readable = ((Readable)Preconditions.checkNotNull(readable));
    reader = ((readable instanceof Reader) ? (Reader)readable : null);
  }
  
  public String readLine()
    throws IOException
  {
    while (lines.peek() == null)
    {
      cbuf.clear();
      
      int read = reader != null ? reader.read(buf, 0, buf.length) : readable.read(cbuf);
      if (read == -1)
      {
        lineBuf.finish();
        break;
      }
      lineBuf.add(buf, 0, read);
    }
    return (String)lines.poll();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.LineReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */