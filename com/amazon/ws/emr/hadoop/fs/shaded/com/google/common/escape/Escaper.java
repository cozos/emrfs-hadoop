package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

@Beta
@GwtCompatible
public abstract class Escaper
{
  private final Function<String, String> asFunction = new Function()
  {
    public String apply(String from)
    {
      return escape(from);
    }
  };
  
  public abstract String escape(String paramString);
  
  public final Function<String, String> asFunction()
  {
    return asFunction;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */