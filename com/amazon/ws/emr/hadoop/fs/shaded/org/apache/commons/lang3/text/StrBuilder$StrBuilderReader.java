package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.io.Reader;

class StrBuilder$StrBuilderReader
  extends Reader
{
  private int pos;
  private int mark;
  
  StrBuilder$StrBuilderReader(StrBuilder paramStrBuilder) {}
  
  public void close() {}
  
  public int read()
  {
    if (!ready()) {
      return -1;
    }
    return this$0.charAt(pos++);
  }
  
  public int read(char[] b, int off, int len)
  {
    if ((off < 0) || (len < 0) || (off > b.length) || (off + len > b.length) || (off + len < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (len == 0) {
      return 0;
    }
    if (pos >= this$0.size()) {
      return -1;
    }
    if (pos + len > this$0.size()) {
      len = this$0.size() - pos;
    }
    this$0.getChars(pos, pos + len, b, off);
    pos += len;
    return len;
  }
  
  public long skip(long n)
  {
    if (pos + n > this$0.size()) {
      n = this$0.size() - pos;
    }
    if (n < 0L) {
      return 0L;
    }
    pos = ((int)(pos + n));
    return n;
  }
  
  public boolean ready()
  {
    return pos < this$0.size();
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void mark(int readAheadLimit)
  {
    mark = pos;
  }
  
  public void reset()
  {
    pos = mark;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrBuilder.StrBuilderReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */