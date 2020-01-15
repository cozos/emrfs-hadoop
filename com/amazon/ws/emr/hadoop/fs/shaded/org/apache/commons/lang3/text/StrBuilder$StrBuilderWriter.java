package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.io.Writer;

class StrBuilder$StrBuilderWriter
  extends Writer
{
  StrBuilder$StrBuilderWriter(StrBuilder paramStrBuilder) {}
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int c)
  {
    this$0.append((char)c);
  }
  
  public void write(char[] cbuf)
  {
    this$0.append(cbuf);
  }
  
  public void write(char[] cbuf, int off, int len)
  {
    this$0.append(cbuf, off, len);
  }
  
  public void write(String str)
  {
    this$0.append(str);
  }
  
  public void write(String str, int off, int len)
  {
    this$0.append(str, off, len);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrBuilder.StrBuilderWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */