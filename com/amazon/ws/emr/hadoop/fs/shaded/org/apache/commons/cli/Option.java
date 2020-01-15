package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option
  implements Cloneable, Serializable
{
  private static final long serialVersionUID = 1L;
  public static final int UNINITIALIZED = -1;
  public static final int UNLIMITED_VALUES = -2;
  private String opt;
  private String longOpt;
  private String argName = "arg";
  private String description;
  private boolean required;
  private boolean optionalArg;
  private int numberOfArgs = -1;
  private Object type;
  private List values = new ArrayList();
  private char valuesep;
  
  public Option(String opt, String description)
    throws IllegalArgumentException
  {
    this(opt, null, false, description);
  }
  
  public Option(String opt, boolean hasArg, String description)
    throws IllegalArgumentException
  {
    this(opt, null, hasArg, description);
  }
  
  public Option(String opt, String longOpt, boolean hasArg, String description)
    throws IllegalArgumentException
  {
    OptionValidator.validateOption(opt);
    
    this.opt = opt;
    this.longOpt = longOpt;
    if (hasArg) {
      numberOfArgs = 1;
    }
    this.description = description;
  }
  
  public int getId()
  {
    return getKey().charAt(0);
  }
  
  String getKey()
  {
    if (opt == null) {
      return longOpt;
    }
    return opt;
  }
  
  public String getOpt()
  {
    return opt;
  }
  
  public Object getType()
  {
    return type;
  }
  
  public void setType(Object type)
  {
    this.type = type;
  }
  
  public String getLongOpt()
  {
    return longOpt;
  }
  
  public void setLongOpt(String longOpt)
  {
    this.longOpt = longOpt;
  }
  
  public void setOptionalArg(boolean optionalArg)
  {
    this.optionalArg = optionalArg;
  }
  
  public boolean hasOptionalArg()
  {
    return optionalArg;
  }
  
  public boolean hasLongOpt()
  {
    return longOpt != null;
  }
  
  public boolean hasArg()
  {
    return (numberOfArgs > 0) || (numberOfArgs == -2);
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public boolean isRequired()
  {
    return required;
  }
  
  public void setRequired(boolean required)
  {
    this.required = required;
  }
  
  public void setArgName(String argName)
  {
    this.argName = argName;
  }
  
  public String getArgName()
  {
    return argName;
  }
  
  public boolean hasArgName()
  {
    return (argName != null) && (argName.length() > 0);
  }
  
  public boolean hasArgs()
  {
    return (numberOfArgs > 1) || (numberOfArgs == -2);
  }
  
  public void setArgs(int num)
  {
    numberOfArgs = num;
  }
  
  public void setValueSeparator(char sep)
  {
    valuesep = sep;
  }
  
  public char getValueSeparator()
  {
    return valuesep;
  }
  
  public boolean hasValueSeparator()
  {
    return valuesep > 0;
  }
  
  public int getArgs()
  {
    return numberOfArgs;
  }
  
  void addValueForProcessing(String value)
  {
    switch (numberOfArgs)
    {
    case -1: 
      throw new RuntimeException("NO_ARGS_ALLOWED");
    }
    processValue(value);
  }
  
  private void processValue(String value)
  {
    if (hasValueSeparator())
    {
      char sep = getValueSeparator();
      
      int index = value.indexOf(sep);
      while (index != -1)
      {
        if (values.size() == numberOfArgs - 1) {
          break;
        }
        add(value.substring(0, index));
        
        value = value.substring(index + 1);
        
        index = value.indexOf(sep);
      }
    }
    add(value);
  }
  
  private void add(String value)
  {
    if ((numberOfArgs > 0) && (values.size() > numberOfArgs - 1)) {
      throw new RuntimeException("Cannot add value, list full.");
    }
    values.add(value);
  }
  
  public String getValue()
  {
    return hasNoValues() ? null : (String)values.get(0);
  }
  
  public String getValue(int index)
    throws IndexOutOfBoundsException
  {
    return hasNoValues() ? null : (String)values.get(index);
  }
  
  public String getValue(String defaultValue)
  {
    String value = getValue();
    
    return value != null ? value : defaultValue;
  }
  
  public String[] getValues()
  {
    return hasNoValues() ? null : (String[])values.toArray(new String[values.size()]);
  }
  
  public List getValuesList()
  {
    return values;
  }
  
  public String toString()
  {
    StringBuffer buf = new StringBuffer().append("[ option: ");
    
    buf.append(opt);
    if (longOpt != null) {
      buf.append(" ").append(longOpt);
    }
    buf.append(" ");
    if (hasArgs()) {
      buf.append("[ARG...]");
    } else if (hasArg()) {
      buf.append(" [ARG]");
    }
    buf.append(" :: ").append(description);
    if (type != null) {
      buf.append(" :: ").append(type);
    }
    buf.append(" ]");
    
    return buf.toString();
  }
  
  private boolean hasNoValues()
  {
    return values.isEmpty();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Option option = (Option)o;
    if (opt != null ? !opt.equals(opt) : opt != null) {
      return false;
    }
    if (longOpt != null ? !longOpt.equals(longOpt) : longOpt != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = opt != null ? opt.hashCode() : 0;
    result = 31 * result + (longOpt != null ? longOpt.hashCode() : 0);
    return result;
  }
  
  public Object clone()
  {
    try
    {
      Option option = (Option)super.clone();
      values = new ArrayList(values);
      return option;
    }
    catch (CloneNotSupportedException cnse)
    {
      throw new RuntimeException("A CloneNotSupportedException was thrown: " + cnse.getMessage());
    }
  }
  
  void clearValues()
  {
    values.clear();
  }
  
  /**
   * @deprecated
   */
  public boolean addValue(String value)
  {
    throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.Option
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */