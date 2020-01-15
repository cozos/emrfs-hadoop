package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

final class TextFormat$TextGenerator
{
  private final Appendable output;
  private final StringBuilder indent = new StringBuilder();
  private boolean atStartOfLine = true;
  
  private TextFormat$TextGenerator(Appendable output)
  {
    this.output = output;
  }
  
  public void indent()
  {
    indent.append("  ");
  }
  
  public void outdent()
  {
    int length = indent.length();
    if (length == 0) {
      throw new IllegalArgumentException(" Outdent() without matching Indent().");
    }
    indent.delete(length - 2, length);
  }
  
  public void print(CharSequence text)
    throws IOException
  {
    int size = text.length();
    int pos = 0;
    for (int i = 0; i < size; i++) {
      if (text.charAt(i) == '\n')
      {
        write(text.subSequence(pos, size), i - pos + 1);
        pos = i + 1;
        atStartOfLine = true;
      }
    }
    write(text.subSequence(pos, size), size - pos);
  }
  
  private void write(CharSequence data, int size)
    throws IOException
  {
    if (size == 0) {
      return;
    }
    if (atStartOfLine)
    {
      atStartOfLine = false;
      output.append(indent);
    }
    output.append(data);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.TextFormat.TextGenerator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */