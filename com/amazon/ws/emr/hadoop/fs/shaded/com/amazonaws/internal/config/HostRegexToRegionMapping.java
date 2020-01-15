package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Immutable
public class HostRegexToRegionMapping
{
  private final String regionName;
  private final Pattern hostNameRegexPattern;
  
  public HostRegexToRegionMapping(String hostNameRegex, String regionName)
  {
    if ((hostNameRegex == null) || (hostNameRegex.isEmpty())) {
      throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex must be non-empty");
    }
    try
    {
      hostNameRegexPattern = Pattern.compile(hostNameRegex);
    }
    catch (PatternSyntaxException e)
    {
      throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex is not a valid regex", e);
    }
    if ((regionName == null) || (regionName.isEmpty())) {
      throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: regionName must be non-empty");
    }
    this.regionName = regionName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public boolean isHostNameMatching(String hostname)
  {
    return hostNameRegexPattern.matcher(hostname).matches();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HostRegexToRegionMapping
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */