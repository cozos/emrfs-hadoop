package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter$NopIndenter
  implements DefaultPrettyPrinter.Indenter, Serializable
{
  public static final NopIndenter instance = new NopIndenter();
  
  public void writeIndentation(JsonGenerator jg, int level)
    throws IOException
  {}
  
  public boolean isInline()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */