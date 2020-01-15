package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

public class UnrecognizedOptionException
  extends ParseException
{
  private String option;
  
  public UnrecognizedOptionException(String message)
  {
    super(message);
  }
  
  public UnrecognizedOptionException(String message, String option)
  {
    this(message);
    this.option = option;
  }
  
  public String getOption()
  {
    return option;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.UnrecognizedOptionException
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */