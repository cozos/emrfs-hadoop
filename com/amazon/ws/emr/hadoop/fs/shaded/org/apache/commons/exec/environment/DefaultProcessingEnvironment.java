package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.DefaultExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.Executor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.OS;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.PumpStreamHandler;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DefaultProcessingEnvironment
{
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");
  protected Map procEnvironment;
  
  public synchronized Map getProcEnvironment()
    throws IOException
  {
    if (procEnvironment == null) {
      procEnvironment = createProcEnvironment();
    }
    Map copy = createEnvironmentMap();
    copy.putAll(procEnvironment);
    return copy;
  }
  
  protected Map createProcEnvironment()
    throws IOException
  {
    if (procEnvironment == null) {
      try
      {
        Method getenvs = System.class.getMethod("getenv", (Class[])null);
        Map env = (Map)getenvs.invoke(null, (Object[])null);
        procEnvironment = createEnvironmentMap();
        procEnvironment.putAll(env);
      }
      catch (NoSuchMethodException e) {}catch (IllegalAccessException e) {}catch (InvocationTargetException e) {}
    }
    if (procEnvironment == null)
    {
      procEnvironment = createEnvironmentMap();
      BufferedReader in = runProcEnvCommand();
      
      String var = null;
      String line;
      while ((line = in.readLine()) != null) {
        if (line.indexOf('=') == -1)
        {
          if (var == null) {
            var = LINE_SEPARATOR + line;
          } else {
            var = var + LINE_SEPARATOR + line;
          }
        }
        else
        {
          if (var != null) {
            EnvironmentUtils.addVariableToEnvironment(procEnvironment, var);
          }
          var = line;
        }
      }
      if (var != null) {
        EnvironmentUtils.addVariableToEnvironment(procEnvironment, var);
      }
    }
    return procEnvironment;
  }
  
  protected BufferedReader runProcEnvCommand()
    throws IOException
  {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Executor exe = new DefaultExecutor();
    exe.setStreamHandler(new PumpStreamHandler(out));
    
    exe.execute(getProcEnvCommand());
    return new BufferedReader(new StringReader(toString(out)));
  }
  
  protected CommandLine getProcEnvCommand()
  {
    String[] arguments = null;
    String executable;
    if (OS.isFamilyOS2())
    {
      String executable = "cmd";
      
      arguments = new String[] { "/c", "set" };
    }
    else if (OS.isFamilyWindows())
    {
      String executable;
      String executable;
      if (OS.isFamilyWin9x()) {
        executable = "command.com";
      } else {
        executable = "cmd";
      }
      arguments = new String[] { "/c", "set" };
    }
    else
    {
      String executable;
      if ((OS.isFamilyZOS()) || (OS.isFamilyUnix()))
      {
        String executable;
        if (new File("/bin/env").canRead())
        {
          executable = "/bin/env";
        }
        else
        {
          String executable;
          if (new File("/usr/bin/env").canRead()) {
            executable = "/usr/bin/env";
          } else {
            executable = "env";
          }
        }
      }
      else
      {
        String executable;
        if ((OS.isFamilyNetware()) || (OS.isFamilyOS400())) {
          executable = "env";
        } else {
          executable = null;
        }
      }
    }
    CommandLine commandLine = null;
    if (executable != null)
    {
      commandLine = new CommandLine(executable);
      commandLine.addArguments(arguments);
    }
    return commandLine;
  }
  
  private String toString(ByteArrayOutputStream bos)
  {
    if (OS.isFamilyZOS()) {
      try
      {
        return bos.toString("Cp1047");
      }
      catch (UnsupportedEncodingException e) {}
    } else if (OS.isFamilyOS400()) {
      try
      {
        return bos.toString("Cp500");
      }
      catch (UnsupportedEncodingException e) {}
    }
    return bos.toString();
  }
  
  private Map createEnvironmentMap()
  {
    if (OS.isFamilyWindows()) {
      new TreeMap(new Comparator()
      {
        public int compare(Object arg0, Object arg1)
        {
          String key0 = (String)arg0;
          String key1 = (String)arg1;
          return key0.compareToIgnoreCase(key1);
        }
      });
    }
    return new HashMap();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.DefaultProcessingEnvironment
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */