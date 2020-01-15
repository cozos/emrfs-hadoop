package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;

abstract class LineBuffer
{
  private StringBuilder line = new StringBuilder();
  private boolean sawReturn;
  
  protected void add(char[] cbuf, int off, int len)
    throws IOException
  {
    int pos = off;
    if ((sawReturn) && (len > 0)) {
      if (finishLine(cbuf[pos] == '\n')) {
        pos++;
      }
    }
    int start = pos;
    for (int end = off + len; pos < end; pos++) {
      switch (cbuf[pos])
      {
      case '\r': 
        line.append(cbuf, start, pos - start);
        sawReturn = true;
        if (pos + 1 < end) {
          if (finishLine(cbuf[(pos + 1)] == '\n')) {
            pos++;
          }
        }
        start = pos + 1;
        break;
      case '\n': 
        line.append(cbuf, start, pos - start);
        finishLine(true);
        start = pos + 1;
      }
    }
    line.append(cbuf, start, off + len - start);
  }
  
  private boolean finishLine(boolean sawNewline)
    throws IOException
  {
    handleLine(line.toString(), sawNewline ? "\n" : sawReturn ? "\r" : sawNewline ? "\r\n" : "");
    
    line = new StringBuilder();
    sawReturn = false;
    return sawNewline;
  }
  
  protected void finish()
    throws IOException
  {
    if ((sawReturn) || (line.length() > 0)) {
      finishLine(false);
    }
  }
  
  protected abstract void handleLine(String paramString1, String paramString2)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.LineBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */