package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment;

import java.util.Comparator;

class DefaultProcessingEnvironment$1
  implements Comparator
{
  private final DefaultProcessingEnvironment this$0;
  
  DefaultProcessingEnvironment$1(DefaultProcessingEnvironment paramDefaultProcessingEnvironment)
  {
    this$0 = paramDefaultProcessingEnvironment;
  }
  
  public int compare(Object arg0, Object arg1)
  {
    String key0 = (String)arg0;
    String key1 = (String)arg1;
    return key0.compareToIgnoreCase(key1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.environment.DefaultProcessingEnvironment.1
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */