package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.util.Queue;

class LineReader$1
  extends LineBuffer
{
  LineReader$1(LineReader paramLineReader) {}
  
  protected void handleLine(String line, String end)
  {
    LineReader.access$000(this$0).add(line);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.LineReader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */