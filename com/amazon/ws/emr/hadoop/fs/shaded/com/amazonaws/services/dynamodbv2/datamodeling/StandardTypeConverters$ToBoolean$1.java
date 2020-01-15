package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StandardTypeConverters$ToBoolean$1
  extends StandardTypeConverters.ToBoolean<String>
{
  StandardTypeConverters$ToBoolean$1()
  {
    super(null);
  }
  
  private final Pattern N0 = Pattern.compile("(?i)[N0]");
  private final Pattern Y1 = Pattern.compile("(?i)[Y1]");
  
  public final Boolean convert(String o)
  {
    return Y1.matcher(o).matches() ? Boolean.TRUE : N0.matcher(o).matches() ? Boolean.FALSE : Boolean.valueOf(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToBoolean.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */