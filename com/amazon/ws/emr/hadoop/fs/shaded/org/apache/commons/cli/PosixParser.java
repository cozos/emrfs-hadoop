package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser
  extends Parser
{
  private List tokens = new ArrayList();
  private boolean eatTheRest;
  private Option currentOption;
  private Options options;
  
  private void init()
  {
    eatTheRest = false;
    tokens.clear();
  }
  
  protected String[] flatten(Options options, String[] arguments, boolean stopAtNonOption)
  {
    init();
    this.options = options;
    
    Iterator iter = Arrays.asList(arguments).iterator();
    while (iter.hasNext())
    {
      String token = (String)iter.next();
      if (token.startsWith("--"))
      {
        int pos = token.indexOf('=');
        String opt = pos == -1 ? token : token.substring(0, pos);
        if (!options.hasOption(opt))
        {
          processNonOptionToken(token, stopAtNonOption);
        }
        else
        {
          currentOption = options.getOption(opt);
          
          tokens.add(opt);
          if (pos != -1) {
            tokens.add(token.substring(pos + 1));
          }
        }
      }
      else if ("-".equals(token))
      {
        tokens.add(token);
      }
      else if (token.startsWith("-"))
      {
        if ((token.length() == 2) || (options.hasOption(token))) {
          processOptionToken(token, stopAtNonOption);
        } else {
          burstToken(token, stopAtNonOption);
        }
      }
      else
      {
        processNonOptionToken(token, stopAtNonOption);
      }
      gobble(iter);
    }
    return (String[])tokens.toArray(new String[tokens.size()]);
  }
  
  private void gobble(Iterator iter)
  {
    if (eatTheRest) {
      while (iter.hasNext()) {
        tokens.add(iter.next());
      }
    }
  }
  
  private void processNonOptionToken(String value, boolean stopAtNonOption)
  {
    if ((stopAtNonOption) && ((currentOption == null) || (!currentOption.hasArg())))
    {
      eatTheRest = true;
      tokens.add("--");
    }
    tokens.add(value);
  }
  
  private void processOptionToken(String token, boolean stopAtNonOption)
  {
    if ((stopAtNonOption) && (!options.hasOption(token))) {
      eatTheRest = true;
    }
    if (options.hasOption(token)) {
      currentOption = options.getOption(token);
    }
    tokens.add(token);
  }
  
  protected void burstToken(String token, boolean stopAtNonOption)
  {
    for (int i = 1; i < token.length(); i++)
    {
      String ch = String.valueOf(token.charAt(i));
      if (options.hasOption(ch))
      {
        tokens.add("-" + ch);
        currentOption = options.getOption(ch);
        if ((currentOption.hasArg()) && (token.length() != i + 1))
        {
          tokens.add(token.substring(i + 1));
          
          break;
        }
      }
      else
      {
        if (stopAtNonOption)
        {
          processNonOptionToken(token.substring(i), true);
          break;
        }
        tokens.add(token);
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.PosixParser
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */