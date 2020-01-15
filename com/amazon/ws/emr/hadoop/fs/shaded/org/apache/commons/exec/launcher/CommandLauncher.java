package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public abstract interface CommandLauncher
{
  public abstract Process exec(CommandLine paramCommandLine, Map paramMap)
    throws IOException;
  
  public abstract Process exec(CommandLine paramCommandLine, Map paramMap, File paramFile)
    throws IOException;
  
  public abstract boolean isFailure(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncher
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */