package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultIndenter
  extends DefaultPrettyPrinter.NopIndenter
{
  private static final long serialVersionUID = 1L;
  public static final String SYS_LF;
  
  static
  {
    String lf;
    try
    {
      lf = System.getProperty("line.separator");
    }
    catch (Throwable t)
    {
      lf = "\n";
    }
    SYS_LF = lf;
  }
  
  public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
  private static final int INDENT_LEVELS = 16;
  private final char[] indents;
  private final int charsPerLevel;
  private final String eol;
  
  public DefaultIndenter()
  {
    this("  ", SYS_LF);
  }
  
  public DefaultIndenter(String indent, String eol)
  {
    charsPerLevel = indent.length();
    
    indents = new char[indent.length() * 16];
    int offset = 0;
    for (int i = 0; i < 16; i++)
    {
      indent.getChars(0, indent.length(), indents, offset);
      offset += indent.length();
    }
    this.eol = eol;
  }
  
  public DefaultIndenter withLinefeed(String lf)
  {
    if (lf.equals(eol)) {
      return this;
    }
    return new DefaultIndenter(getIndent(), lf);
  }
  
  public DefaultIndenter withIndent(String indent)
  {
    if (indent.equals(getIndent())) {
      return this;
    }
    return new DefaultIndenter(indent, eol);
  }
  
  public boolean isInline()
  {
    return false;
  }
  
  public void writeIndentation(JsonGenerator jg, int level)
    throws IOException
  {
    jg.writeRaw(eol);
    if (level > 0)
    {
      level *= charsPerLevel;
      while (level > indents.length)
      {
        jg.writeRaw(indents, 0, indents.length);
        level -= indents.length;
      }
      jg.writeRaw(indents, 0, level);
    }
  }
  
  public String getEol()
  {
    return eol;
  }
  
  public String getIndent()
  {
    return new String(indents, 0, charsPerLevel);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */