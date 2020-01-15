package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultPrettyPrinter$FixedSpaceIndenter
  extends DefaultPrettyPrinter.NopIndenter
{
  public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();
  
  public void writeIndentation(JsonGenerator jg, int level)
    throws IOException
  {
    jg.writeRaw(' ');
  }
  
  public boolean isInline()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */