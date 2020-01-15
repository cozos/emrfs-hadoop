package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.EnvironmentUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Java13CommandLauncher
  extends CommandLauncherImpl
{
  public Process exec(CommandLine cmd, Map env, File workingDir)
    throws IOException
  {
    String[] envVars = EnvironmentUtils.toStrings(env);
    
    return Runtime.getRuntime().exec(cmd.toStrings(), envVars, workingDir);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.Java13CommandLauncher
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */