package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final Pattern pattern;
  
  public RegexFileFilter(String pattern)
  {
    if (pattern == null) {
      throw new IllegalArgumentException("Pattern is missing");
    }
    this.pattern = Pattern.compile(pattern);
  }
  
  public RegexFileFilter(String pattern, IOCase caseSensitivity)
  {
    if (pattern == null) {
      throw new IllegalArgumentException("Pattern is missing");
    }
    int flags = 0;
    if ((caseSensitivity != null) && (!caseSensitivity.isCaseSensitive())) {
      flags = 2;
    }
    this.pattern = Pattern.compile(pattern, flags);
  }
  
  public RegexFileFilter(String pattern, int flags)
  {
    if (pattern == null) {
      throw new IllegalArgumentException("Pattern is missing");
    }
    this.pattern = Pattern.compile(pattern, flags);
  }
  
  public RegexFileFilter(Pattern pattern)
  {
    if (pattern == null) {
      throw new IllegalArgumentException("Pattern is missing");
    }
    this.pattern = pattern;
  }
  
  public boolean accept(File dir, String name)
  {
    return pattern.matcher(name).matches();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.RegexFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */