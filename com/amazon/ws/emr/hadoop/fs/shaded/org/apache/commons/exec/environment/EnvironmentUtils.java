package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.OS;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EnvironmentUtils
{
  private static final DefaultProcessingEnvironment PROCESSING_ENVIRONMENT_IMPLEMENTATION;
  
  static
  {
    if (OS.isFamilyOpenVms()) {
      PROCESSING_ENVIRONMENT_IMPLEMENTATION = new OpenVmsProcessingEnvironment();
    } else {
      PROCESSING_ENVIRONMENT_IMPLEMENTATION = new DefaultProcessingEnvironment();
    }
  }
  
  public static String[] toStrings(Map environment)
  {
    if (environment == null) {
      return null;
    }
    String[] result = new String[environment.size()];
    int i = 0;
    for (Iterator iter = environment.entrySet().iterator(); iter.hasNext();)
    {
      Map.Entry entry = (Map.Entry)iter.next();
      
      result[i] = (entry.getKey().toString() + "=" + entry.getValue().toString());
      i++;
    }
    return result;
  }
  
  public static Map getProcEnvironment()
    throws IOException
  {
    return PROCESSING_ENVIRONMENT_IMPLEMENTATION.getProcEnvironment();
  }
  
  public static void addVariableToEnvironment(Map environment, String keyAndValue)
  {
    String[] parsedVariable = parseEnvironmentVariable(keyAndValue);
    environment.put(parsedVariable[0], parsedVariable[1]);
  }
  
  private static String[] parseEnvironmentVariable(String keyAndValue)
  {
    int index = keyAndValue.indexOf('=');
    if (index == -1) {
      throw new IllegalArgumentException("Environment variable for this platform must contain an equals sign ('=')");
    }
    String[] result = new String[2];
    result[0] = keyAndValue.substring(0, index);
    result[1] = keyAndValue.substring(index + 1);
    
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.EnvironmentUtils
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */