package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@Beta
public final class PatternFilenameFilter
  implements FilenameFilter
{
  private final Pattern pattern;
  
  public PatternFilenameFilter(String patternStr)
  {
    this(Pattern.compile(patternStr));
  }
  
  public PatternFilenameFilter(Pattern pattern)
  {
    this.pattern = ((Pattern)Preconditions.checkNotNull(pattern));
  }
  
  public boolean accept(@Nullable File dir, String fileName)
  {
    return pattern.matcher(fileName).matches();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.PatternFilenameFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */