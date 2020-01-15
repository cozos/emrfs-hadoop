package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OpenVmsProcessingEnvironment
  extends DefaultProcessingEnvironment
{
  protected Map createProcEnvironment()
    throws IOException
  {
    if (procEnvironment == null)
    {
      BufferedReader in = runProcEnvCommand();
      procEnvironment = addVMSenvironmentVariables(new HashMap(), in);
    }
    return procEnvironment;
  }
  
  protected CommandLine getProcEnvCommand()
  {
    CommandLine commandLine = new CommandLine("show");
    commandLine.addArgument("symbol/global");
    commandLine.addArgument("*");
    return commandLine;
  }
  
  private Map addVMSenvironmentVariables(Map environment, BufferedReader in)
    throws IOException
  {
    String line;
    while ((line = in.readLine()) != null)
    {
      String SEP = "==";
      int sepidx = line.indexOf("==");
      if (sepidx > 0)
      {
        String name = line.substring(0, sepidx).trim();
        String value = line.substring(sepidx + "==".length()).trim();
        value = value.substring(1, value.length() - 1);
        environment.put(name, value);
      }
    }
    return environment;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.OpenVmsProcessingEnvironment
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */