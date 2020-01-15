package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.regex.Pattern;

class CharSource$CharSequenceCharSource
  extends CharSource
{
  private static final Splitter LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
  private final CharSequence seq;
  
  protected CharSource$CharSequenceCharSource(CharSequence seq)
  {
    this.seq = ((CharSequence)Preconditions.checkNotNull(seq));
  }
  
  public Reader openStream()
  {
    return new CharSequenceReader(seq);
  }
  
  public String read()
  {
    return seq.toString();
  }
  
  public boolean isEmpty()
  {
    return seq.length() == 0;
  }
  
  private Iterable<String> lines()
  {
    new Iterable()
    {
      public Iterator<String> iterator()
      {
        new AbstractIterator()
        {
          Iterator<String> lines = CharSource.CharSequenceCharSource.LINE_SPLITTER.split(seq).iterator();
          
          protected String computeNext()
          {
            if (lines.hasNext())
            {
              String next = (String)lines.next();
              if ((lines.hasNext()) || (!next.isEmpty())) {
                return next;
              }
            }
            return (String)endOfData();
          }
        };
      }
    };
  }
  
  public String readFirstLine()
  {
    Iterator<String> lines = lines().iterator();
    return lines.hasNext() ? (String)lines.next() : null;
  }
  
  public ImmutableList<String> readLines()
  {
    return ImmutableList.copyOf(lines());
  }
  
  public <T> T readLines(LineProcessor<T> processor)
    throws IOException
  {
    for (String line : lines()) {
      if (!processor.processLine(line)) {
        break;
      }
    }
    return (T)processor.getResult();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(Ascii.truncate(seq, 30, "...")));return 17 + str.length() + "CharSource.wrap(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharSource.CharSequenceCharSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */