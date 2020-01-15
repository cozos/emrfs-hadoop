package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

public class LambdaConfiguration
  extends NotificationConfiguration
  implements Serializable
{
  private final String functionARN;
  
  public LambdaConfiguration(String functionARN, EnumSet<S3Event> events)
  {
    super(events);
    this.functionARN = functionARN;
  }
  
  public LambdaConfiguration(String functionARN, String... events)
  {
    super(events);
    this.functionARN = functionARN;
  }
  
  public String getFunctionARN()
  {
    return functionARN;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.LambdaConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */