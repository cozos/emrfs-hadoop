package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

public class MissingArgumentException
  extends ParseException
{
  private Option option;
  
  public MissingArgumentException(String message)
  {
    super(message);
  }
  
  public MissingArgumentException(Option option)
  {
    this("Missing argument for option: " + option.getKey());
    this.option = option;
  }
  
  public Option getOption()
  {
    return option;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.MissingArgumentException
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */