package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util.StringUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VmsCommandLauncher
  extends Java13CommandLauncher
{
  public Process exec(CommandLine cmd, Map env)
    throws IOException
  {
    CommandLine vmsCmd = new CommandLine(createCommandFile(cmd, env).getPath());
    
    return super.exec(vmsCmd, env);
  }
  
  public Process exec(CommandLine cmd, Map env, File workingDir)
    throws IOException
  {
    CommandLine vmsCmd = new CommandLine(createCommandFile(cmd, env).getPath());
    
    return super.exec(vmsCmd, env, workingDir);
  }
  
  public boolean isFailure(int exitValue)
  {
    return exitValue % 2 == 0;
  }
  
  private File createCommandFile(CommandLine cmd, Map env)
    throws IOException
  {
    File script = File.createTempFile("EXEC", ".TMP");
    script.deleteOnExit();
    PrintWriter out = null;
    try
    {
      out = new PrintWriter(new FileWriter(script.getAbsolutePath(), true));
      Iterator iter;
      if (env != null)
      {
        Set entries = env.entrySet();
        for (iter = entries.iterator(); iter.hasNext();)
        {
          Map.Entry entry = (Map.Entry)iter.next();
          out.print("$ ");
          out.print(entry.getKey());
          out.print(" == ");
          out.println('"');
          String value = (String)entry.getValue();
          if (value.indexOf('"') > 0)
          {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < value.length(); i++)
            {
              char c = value.charAt(i);
              if (c == '"') {
                sb.append('"');
              }
              sb.append(c);
            }
            value = sb.toString();
          }
          out.print(value);
          out.println('"');
        }
      }
      String command = cmd.getExecutable();
      if (cmd.isFile())
      {
        out.print("$ @");
        
        String[] parts = StringUtils.split(command, "/");
        out.print(parts[0]);
        out.print(":[");
        out.print(parts[1]);
        int lastPart = parts.length - 1;
        for (int i = 2; i < lastPart; i++)
        {
          out.print(".");
          out.print(parts[i]);
        }
        out.print("]");
        out.print(parts[lastPart]);
      }
      else
      {
        out.print("$ ");
        out.print(command);
      }
      String[] args = cmd.getArguments();
      for (int i = 0; i < args.length; i++)
      {
        out.println(" -");
        out.print(args[i]);
      }
      out.println();
    }
    finally
    {
      if (out != null) {
        out.close();
      }
    }
    return script;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.launcher.VmsCommandLauncher
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */