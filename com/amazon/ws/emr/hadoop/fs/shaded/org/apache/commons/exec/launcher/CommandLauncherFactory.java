package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.OS;

public final class CommandLauncherFactory
{
  public static CommandLauncher createVMLauncher()
  {
    CommandLauncher launcher;
    CommandLauncher launcher;
    if (OS.isFamilyOpenVms()) {
      launcher = new VmsCommandLauncher();
    } else {
      launcher = new Java13CommandLauncher();
    }
    return launcher;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.CommandLauncherFactory
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */