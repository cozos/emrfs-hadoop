package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import java.io.IOException;
import java.util.Map;

public abstract class CommandLauncherProxy
  extends CommandLauncherImpl
{
  private final CommandLauncher myLauncher;
  
  public CommandLauncherProxy(CommandLauncher launcher)
  {
    myLauncher = launcher;
  }
  
  public Process exec(CommandLine cmd, Map env)
    throws IOException
  {
    return myLauncher.exec(cmd, env);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncherProxy
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */