package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class OS2CommandLauncher
  extends CommandLauncherProxy
{
  public OS2CommandLauncher(CommandLauncher launcher)
  {
    super(launcher);
  }
  
  public Process exec(CommandLine cmd, Map env, File workingDir)
    throws IOException
  {
    if (workingDir == null) {
      return exec(cmd, env);
    }
    CommandLine newCmd = new CommandLine("cmd");
    newCmd.addArgument("/c");
    newCmd.addArguments(cmd.toStrings());
    
    return exec(newCmd, env);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.OS2CommandLauncher
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */