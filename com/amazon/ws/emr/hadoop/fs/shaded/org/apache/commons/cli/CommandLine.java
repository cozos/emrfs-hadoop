package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CommandLine
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List args = new LinkedList();
  private List options = new ArrayList();
  
  public boolean hasOption(String opt)
  {
    return options.contains(resolveOption(opt));
  }
  
  public boolean hasOption(char opt)
  {
    return hasOption(String.valueOf(opt));
  }
  
  /**
   * @deprecated
   */
  public Object getOptionObject(String opt)
  {
    try
    {
      return getParsedOptionValue(opt);
    }
    catch (ParseException pe)
    {
      System.err.println("Exception found converting " + opt + " to desired type: " + pe.getMessage());
    }
    return null;
  }
  
  public Object getParsedOptionValue(String opt)
    throws ParseException
  {
    String res = getOptionValue(opt);
    
    Option option = resolveOption(opt);
    if (option == null) {
      return null;
    }
    Object type = option.getType();
    
    return res == null ? null : TypeHandler.createValue(res, type);
  }
  
  public Object getOptionObject(char opt)
  {
    return getOptionObject(String.valueOf(opt));
  }
  
  public String getOptionValue(String opt)
  {
    String[] values = getOptionValues(opt);
    
    return values == null ? null : values[0];
  }
  
  public String getOptionValue(char opt)
  {
    return getOptionValue(String.valueOf(opt));
  }
  
  public String[] getOptionValues(String opt)
  {
    List values = new ArrayList();
    for (Iterator it = options.iterator(); it.hasNext();)
    {
      Option option = (Option)it.next();
      if ((opt.equals(option.getOpt())) || (opt.equals(option.getLongOpt()))) {
        values.addAll(option.getValuesList());
      }
    }
    return values.isEmpty() ? null : (String[])values.toArray(new String[values.size()]);
  }
  
  private Option resolveOption(String opt)
  {
    opt = Util.stripLeadingHyphens(opt);
    for (Iterator it = options.iterator(); it.hasNext();)
    {
      Option option = (Option)it.next();
      if (opt.equals(option.getOpt())) {
        return option;
      }
      if (opt.equals(option.getLongOpt())) {
        return option;
      }
    }
    return null;
  }
  
  public String[] getOptionValues(char opt)
  {
    return getOptionValues(String.valueOf(opt));
  }
  
  public String getOptionValue(String opt, String defaultValue)
  {
    String answer = getOptionValue(opt);
    
    return answer != null ? answer : defaultValue;
  }
  
  public String getOptionValue(char opt, String defaultValue)
  {
    return getOptionValue(String.valueOf(opt), defaultValue);
  }
  
  public Properties getOptionProperties(String opt)
  {
    Properties props = new Properties();
    for (Iterator it = options.iterator(); it.hasNext();)
    {
      Option option = (Option)it.next();
      if ((opt.equals(option.getOpt())) || (opt.equals(option.getLongOpt())))
      {
        List values = option.getValuesList();
        if (values.size() >= 2) {
          props.put(values.get(0), values.get(1));
        } else if (values.size() == 1) {
          props.put(values.get(0), "true");
        }
      }
    }
    return props;
  }
  
  public String[] getArgs()
  {
    String[] answer = new String[args.size()];
    
    args.toArray(answer);
    
    return answer;
  }
  
  public List getArgList()
  {
    return args;
  }
  
  void addArg(String arg)
  {
    args.add(arg);
  }
  
  void addOption(Option opt)
  {
    options.add(opt);
  }
  
  public Iterator iterator()
  {
    return options.iterator();
  }
  
  public Option[] getOptions()
  {
    Collection processed = options;
    
    Option[] optionsArray = new Option[processed.size()];
    
    return (Option[])processed.toArray(optionsArray);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.CommandLine
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */