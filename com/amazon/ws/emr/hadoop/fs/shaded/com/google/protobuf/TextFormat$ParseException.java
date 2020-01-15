package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public class TextFormat$ParseException
  extends IOException
{
  private static final long serialVersionUID = 3196188060225107702L;
  private final int line;
  private final int column;
  
  public TextFormat$ParseException(String message)
  {
    this(-1, -1, message);
  }
  
  public TextFormat$ParseException(int line, int column, String message)
  {
    super(Integer.toString(line) + ":" + column + ": " + message);
    this.line = line;
    this.column = column;
  }
  
  public int getLine()
  {
    return line;
  }
  
  public int getColumn()
  {
    return column;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.TextFormat.ParseException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */