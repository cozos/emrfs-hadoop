package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.net.MalformedURLException;
import java.net.URL;

final class StandardTypeConverters$ToUrl$1
  extends StandardTypeConverters.ToUrl<String>
{
  StandardTypeConverters$ToUrl$1()
  {
    super(null);
  }
  
  public final URL convert(String o)
  {
    try
    {
      return new URL(o);
    }
    catch (MalformedURLException e)
    {
      throw new IllegalArgumentException("malformed URL", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToUrl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */