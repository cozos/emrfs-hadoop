package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

public class AlreadySelectedException
  extends ParseException
{
  private OptionGroup group;
  private Option option;
  
  public AlreadySelectedException(String message)
  {
    super(message);
  }
  
  public AlreadySelectedException(OptionGroup group, Option option)
  {
    this("The option '" + option.getKey() + "' was specified but an option from this group " + "has already been selected: '" + group.getSelected() + "'");
    
    this.group = group;
    this.option = option;
  }
  
  public OptionGroup getOptionGroup()
  {
    return group;
  }
  
  public Option getOption()
  {
    return option;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.AlreadySelectedException
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */