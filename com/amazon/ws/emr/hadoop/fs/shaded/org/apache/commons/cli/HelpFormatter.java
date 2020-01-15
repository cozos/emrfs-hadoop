package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter
{
  public static final int DEFAULT_WIDTH = 74;
  public static final int DEFAULT_LEFT_PAD = 1;
  public static final int DEFAULT_DESC_PAD = 3;
  public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
  public static final String DEFAULT_OPT_PREFIX = "-";
  public static final String DEFAULT_LONG_OPT_PREFIX = "--";
  public static final String DEFAULT_ARG_NAME = "arg";
  /**
   * @deprecated
   */
  public int defaultWidth;
  /**
   * @deprecated
   */
  public int defaultLeftPad;
  /**
   * @deprecated
   */
  public int defaultDescPad;
  /**
   * @deprecated
   */
  public String defaultSyntaxPrefix;
  /**
   * @deprecated
   */
  public String defaultNewLine;
  /**
   * @deprecated
   */
  public String defaultOptPrefix;
  /**
   * @deprecated
   */
  public String defaultLongOptPrefix;
  /**
   * @deprecated
   */
  public String defaultArgName;
  protected Comparator optionComparator;
  
  public HelpFormatter()
  {
    defaultWidth = 74;
    
    defaultLeftPad = 1;
    
    defaultDescPad = 3;
    
    defaultSyntaxPrefix = "usage: ";
    
    defaultNewLine = System.getProperty("line.separator");
    
    defaultOptPrefix = "-";
    
    defaultLongOptPrefix = "--";
    
    defaultArgName = "arg";
    
    optionComparator = new OptionComparator(null);
  }
  
  public void setWidth(int width)
  {
    defaultWidth = width;
  }
  
  public int getWidth()
  {
    return defaultWidth;
  }
  
  public void setLeftPadding(int padding)
  {
    defaultLeftPad = padding;
  }
  
  public int getLeftPadding()
  {
    return defaultLeftPad;
  }
  
  public void setDescPadding(int padding)
  {
    defaultDescPad = padding;
  }
  
  public int getDescPadding()
  {
    return defaultDescPad;
  }
  
  public void setSyntaxPrefix(String prefix)
  {
    defaultSyntaxPrefix = prefix;
  }
  
  public String getSyntaxPrefix()
  {
    return defaultSyntaxPrefix;
  }
  
  public void setNewLine(String newline)
  {
    defaultNewLine = newline;
  }
  
  public String getNewLine()
  {
    return defaultNewLine;
  }
  
  public void setOptPrefix(String prefix)
  {
    defaultOptPrefix = prefix;
  }
  
  public String getOptPrefix()
  {
    return defaultOptPrefix;
  }
  
  public void setLongOptPrefix(String prefix)
  {
    defaultLongOptPrefix = prefix;
  }
  
  public String getLongOptPrefix()
  {
    return defaultLongOptPrefix;
  }
  
  public void setArgName(String name)
  {
    defaultArgName = name;
  }
  
  public String getArgName()
  {
    return defaultArgName;
  }
  
  public Comparator getOptionComparator()
  {
    return optionComparator;
  }
  
  public void setOptionComparator(Comparator comparator)
  {
    if (comparator == null) {
      optionComparator = new OptionComparator(null);
    } else {
      optionComparator = comparator;
    }
  }
  
  public void printHelp(String cmdLineSyntax, Options options)
  {
    printHelp(defaultWidth, cmdLineSyntax, null, options, null, false);
  }
  
  public void printHelp(String cmdLineSyntax, Options options, boolean autoUsage)
  {
    printHelp(defaultWidth, cmdLineSyntax, null, options, null, autoUsage);
  }
  
  public void printHelp(String cmdLineSyntax, String header, Options options, String footer)
  {
    printHelp(cmdLineSyntax, header, options, footer, false);
  }
  
  public void printHelp(String cmdLineSyntax, String header, Options options, String footer, boolean autoUsage)
  {
    printHelp(defaultWidth, cmdLineSyntax, header, options, footer, autoUsage);
  }
  
  public void printHelp(int width, String cmdLineSyntax, String header, Options options, String footer)
  {
    printHelp(width, cmdLineSyntax, header, options, footer, false);
  }
  
  public void printHelp(int width, String cmdLineSyntax, String header, Options options, String footer, boolean autoUsage)
  {
    PrintWriter pw = new PrintWriter(System.out);
    
    printHelp(pw, width, cmdLineSyntax, header, options, defaultLeftPad, defaultDescPad, footer, autoUsage);
    pw.flush();
  }
  
  public void printHelp(PrintWriter pw, int width, String cmdLineSyntax, String header, Options options, int leftPad, int descPad, String footer)
  {
    printHelp(pw, width, cmdLineSyntax, header, options, leftPad, descPad, footer, false);
  }
  
  public void printHelp(PrintWriter pw, int width, String cmdLineSyntax, String header, Options options, int leftPad, int descPad, String footer, boolean autoUsage)
  {
    if ((cmdLineSyntax == null) || (cmdLineSyntax.length() == 0)) {
      throw new IllegalArgumentException("cmdLineSyntax not provided");
    }
    if (autoUsage) {
      printUsage(pw, width, cmdLineSyntax, options);
    } else {
      printUsage(pw, width, cmdLineSyntax);
    }
    if ((header != null) && (header.trim().length() > 0)) {
      printWrapped(pw, width, header);
    }
    printOptions(pw, width, options, leftPad, descPad);
    if ((footer != null) && (footer.trim().length() > 0)) {
      printWrapped(pw, width, footer);
    }
  }
  
  public void printUsage(PrintWriter pw, int width, String app, Options options)
  {
    StringBuffer buff = new StringBuffer(defaultSyntaxPrefix).append(app).append(" ");
    
    Collection processedGroups = new ArrayList();
    
    List optList = new ArrayList(options.getOptions());
    Collections.sort(optList, getOptionComparator());
    for (Iterator i = optList.iterator(); i.hasNext();)
    {
      Option option = (Option)i.next();
      
      OptionGroup group = options.getOptionGroup(option);
      if (group != null)
      {
        if (!processedGroups.contains(group))
        {
          processedGroups.add(group);
          
          appendOptionGroup(buff, group);
        }
      }
      else {
        appendOption(buff, option, option.isRequired());
      }
      if (i.hasNext()) {
        buff.append(" ");
      }
    }
    printWrapped(pw, width, buff.toString().indexOf(' ') + 1, buff.toString());
  }
  
  private void appendOptionGroup(StringBuffer buff, OptionGroup group)
  {
    if (!group.isRequired()) {
      buff.append("[");
    }
    List optList = new ArrayList(group.getOptions());
    Collections.sort(optList, getOptionComparator());
    for (Iterator i = optList.iterator(); i.hasNext();)
    {
      appendOption(buff, (Option)i.next(), true);
      if (i.hasNext()) {
        buff.append(" | ");
      }
    }
    if (!group.isRequired()) {
      buff.append("]");
    }
  }
  
  private static void appendOption(StringBuffer buff, Option option, boolean required)
  {
    if (!required) {
      buff.append("[");
    }
    if (option.getOpt() != null) {
      buff.append("-").append(option.getOpt());
    } else {
      buff.append("--").append(option.getLongOpt());
    }
    if ((option.hasArg()) && (option.hasArgName())) {
      buff.append(" <").append(option.getArgName()).append(">");
    }
    if (!required) {
      buff.append("]");
    }
  }
  
  public void printUsage(PrintWriter pw, int width, String cmdLineSyntax)
  {
    int argPos = cmdLineSyntax.indexOf(' ') + 1;
    
    printWrapped(pw, width, defaultSyntaxPrefix.length() + argPos, defaultSyntaxPrefix + cmdLineSyntax);
  }
  
  public void printOptions(PrintWriter pw, int width, Options options, int leftPad, int descPad)
  {
    StringBuffer sb = new StringBuffer();
    
    renderOptions(sb, width, options, leftPad, descPad);
    pw.println(sb.toString());
  }
  
  public void printWrapped(PrintWriter pw, int width, String text)
  {
    printWrapped(pw, width, 0, text);
  }
  
  public void printWrapped(PrintWriter pw, int width, int nextLineTabStop, String text)
  {
    StringBuffer sb = new StringBuffer(text.length());
    
    renderWrappedText(sb, width, nextLineTabStop, text);
    pw.println(sb.toString());
  }
  
  protected StringBuffer renderOptions(StringBuffer sb, int width, Options options, int leftPad, int descPad)
  {
    String lpad = createPadding(leftPad);
    String dpad = createPadding(descPad);
    
    int max = 0;
    
    List prefixList = new ArrayList();
    
    List optList = options.helpOptions();
    
    Collections.sort(optList, getOptionComparator());
    for (Iterator i = optList.iterator(); i.hasNext();)
    {
      Option option = (Option)i.next();
      StringBuffer optBuf = new StringBuffer(8);
      if (option.getOpt() == null)
      {
        optBuf.append(lpad).append("   " + defaultLongOptPrefix).append(option.getLongOpt());
      }
      else
      {
        optBuf.append(lpad).append(defaultOptPrefix).append(option.getOpt());
        if (option.hasLongOpt()) {
          optBuf.append(',').append(defaultLongOptPrefix).append(option.getLongOpt());
        }
      }
      if (option.hasArg()) {
        if (option.hasArgName()) {
          optBuf.append(" <").append(option.getArgName()).append(">");
        } else {
          optBuf.append(' ');
        }
      }
      prefixList.add(optBuf);
      max = optBuf.length() > max ? optBuf.length() : max;
    }
    int x = 0;
    for (Iterator i = optList.iterator(); i.hasNext();)
    {
      Option option = (Option)i.next();
      StringBuffer optBuf = new StringBuffer(prefixList.get(x++).toString());
      if (optBuf.length() < max) {
        optBuf.append(createPadding(max - optBuf.length()));
      }
      optBuf.append(dpad);
      
      int nextLineTabStop = max + descPad;
      if (option.getDescription() != null) {
        optBuf.append(option.getDescription());
      }
      renderWrappedText(sb, width, nextLineTabStop, optBuf.toString());
      if (i.hasNext()) {
        sb.append(defaultNewLine);
      }
    }
    return sb;
  }
  
  protected StringBuffer renderWrappedText(StringBuffer sb, int width, int nextLineTabStop, String text)
  {
    int pos = findWrapPos(text, width, 0);
    if (pos == -1)
    {
      sb.append(rtrim(text));
      
      return sb;
    }
    sb.append(rtrim(text.substring(0, pos))).append(defaultNewLine);
    if (nextLineTabStop >= width) {
      nextLineTabStop = 1;
    }
    String padding = createPadding(nextLineTabStop);
    for (;;)
    {
      text = padding + text.substring(pos).trim();
      pos = findWrapPos(text, width, 0);
      if (pos == -1)
      {
        sb.append(text);
        
        return sb;
      }
      if ((text.length() > width) && (pos == nextLineTabStop - 1)) {
        pos = width;
      }
      sb.append(rtrim(text.substring(0, pos))).append(defaultNewLine);
    }
  }
  
  protected int findWrapPos(String text, int width, int startPos)
  {
    int pos = -1;
    if ((((pos = text.indexOf('\n', startPos)) != -1) && (pos <= width)) || (((pos = text.indexOf('\t', startPos)) != -1) && (pos <= width))) {
      return pos + 1;
    }
    if (startPos + width >= text.length()) {
      return -1;
    }
    pos = startPos + width;
    char c;
    while ((pos >= startPos) && ((c = text.charAt(pos)) != ' ') && (c != '\n') && (c != '\r')) {
      pos--;
    }
    if (pos > startPos) {
      return pos;
    }
    pos = startPos + width;
    char c;
    while ((pos <= text.length()) && ((c = text.charAt(pos)) != ' ') && (c != '\n') && (c != '\r')) {
      pos++;
    }
    return pos == text.length() ? -1 : pos;
  }
  
  protected String createPadding(int len)
  {
    StringBuffer sb = new StringBuffer(len);
    for (int i = 0; i < len; i++) {
      sb.append(' ');
    }
    return sb.toString();
  }
  
  protected String rtrim(String s)
  {
    if ((s == null) || (s.length() == 0)) {
      return s;
    }
    int pos = s.length();
    while ((pos > 0) && (Character.isWhitespace(s.charAt(pos - 1)))) {
      pos--;
    }
    return s.substring(0, pos);
  }
  
  private static class OptionComparator
    implements Comparator
  {
    OptionComparator(HelpFormatter.1 x0)
    {
      this();
    }
    
    public int compare(Object o1, Object o2)
    {
      Option opt1 = (Option)o1;
      Option opt2 = (Option)o2;
      
      return opt1.getKey().compareToIgnoreCase(opt2.getKey());
    }
    
    private OptionComparator() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.cli.HelpFormatter
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.7.1
 */