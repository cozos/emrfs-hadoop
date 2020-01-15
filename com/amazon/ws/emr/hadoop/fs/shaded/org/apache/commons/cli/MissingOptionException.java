package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

public class MissingOptionException
  extends ParseException
{
  private List missingOptions;
  
  public MissingOptionException(String message)
  {
    super(message);
  }
  
  public MissingOptionException(List missingOptions)
  {
    this(createMessage(missingOptions));
    this.missingOptions = missingOptions;
  }
  
  public List getMissingOptions()
  {
    return missingOptions;
  }
  
  private static String createMessage(List missingOptions)
  {
    StringBuffer buff = new StringBuffer("Missing required option");
    buff.append(missingOptions.size() == 1 ? "" : "s");
    buff.append(": ");
    
    Iterator it = missingOptions.iterator();
    while (it.hasNext())
    {
      buff.append(it.next());
      if (it.hasNext()) {
        buff.append(", ");
      }
    }
    return buff.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.MissingOptionException
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */