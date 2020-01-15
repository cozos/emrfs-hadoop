package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.util.Comparator;

class HelpFormatter$OptionComparator
  implements Comparator
{
  HelpFormatter$OptionComparator(HelpFormatter.1 x0)
  {
    this();
  }
  
  public int compare(Object o1, Object o2)
  {
    Option opt1 = (Option)o1;
    Option opt2 = (Option)o2;
    
    return opt1.getKey().compareToIgnoreCase(opt2.getKey());
  }
  
  private HelpFormatter$OptionComparator() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.HelpFormatter.OptionComparator
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */