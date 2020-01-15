package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OptionGroup
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Map optionMap = new HashMap();
  private String selected;
  private boolean required;
  
  public OptionGroup addOption(Option option)
  {
    optionMap.put(option.getKey(), option);
    
    return this;
  }
  
  public Collection getNames()
  {
    return optionMap.keySet();
  }
  
  public Collection getOptions()
  {
    return optionMap.values();
  }
  
  public void setSelected(Option option)
    throws AlreadySelectedException
  {
    if ((selected == null) || (selected.equals(option.getOpt()))) {
      selected = option.getOpt();
    } else {
      throw new AlreadySelectedException(this, option);
    }
  }
  
  public String getSelected()
  {
    return selected;
  }
  
  public void setRequired(boolean required)
  {
    this.required = required;
  }
  
  public boolean isRequired()
  {
    return required;
  }
  
  public String toString()
  {
    StringBuffer buff = new StringBuffer();
    
    Iterator iter = getOptions().iterator();
    
    buff.append("[");
    while (iter.hasNext())
    {
      Option option = (Option)iter.next();
      if (option.getOpt() != null)
      {
        buff.append("-");
        buff.append(option.getOpt());
      }
      else
      {
        buff.append("--");
        buff.append(option.getLongOpt());
      }
      buff.append(" ");
      buff.append(option.getDescription());
      if (iter.hasNext()) {
        buff.append(", ");
      }
    }
    buff.append("]");
    
    return buff.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.OptionGroup
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */