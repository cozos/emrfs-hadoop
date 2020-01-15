package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public abstract interface DefaultPrettyPrinter$Indenter
{
  public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException;
  
  public abstract boolean isInline();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */