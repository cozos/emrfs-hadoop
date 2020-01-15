package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.EnvironmentUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public abstract class CommandLauncherImpl
  implements CommandLauncher
{
  public Process exec(CommandLine cmd, Map env)
    throws IOException
  {
    String[] envVar = EnvironmentUtils.toStrings(env);
    return Runtime.getRuntime().exec(cmd.toStrings(), envVar);
  }
  
  public abstract Process exec(CommandLine paramCommandLine, Map paramMap, File paramFile)
    throws IOException;
  
  public boolean isFailure(int exitValue)
  {
    return exitValue != 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncherImpl
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */