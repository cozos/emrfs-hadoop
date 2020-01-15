package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.net.URI;
import java.net.URISyntaxException;

final class StandardTypeConverters$ToUri$1
  extends StandardTypeConverters.ToUri<String>
{
  StandardTypeConverters$ToUri$1()
  {
    super(null);
  }
  
  public final URI convert(String o)
  {
    try
    {
      return new URI(o);
    }
    catch (URISyntaxException e)
    {
      throw new IllegalArgumentException("malformed URI", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ToUri.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */