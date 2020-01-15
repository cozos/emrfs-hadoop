package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

class CommandLine$Argument
{
  private final String value;
  private final boolean handleQuoting;
  private final CommandLine this$0;
  
  CommandLine$Argument(CommandLine x0, String x1, boolean x2, CommandLine.1 x3)
  {
    this(x0, x1, x2);
  }
  
  private CommandLine$Argument(CommandLine paramCommandLine, String value, boolean handleQuoting)
  {
    this$0 = paramCommandLine;
    this.value = value.trim();
    this.handleQuoting = handleQuoting;
  }
  
  private String getValue()
  {
    return value;
  }
  
  private boolean isHandleQuoting()
  {
    return handleQuoting;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine.Argument
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */