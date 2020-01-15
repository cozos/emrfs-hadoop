package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

public abstract interface CommandLineParser
{
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString)
    throws ParseException;
  
  public abstract CommandLine parse(Options paramOptions, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.CommandLineParser
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */