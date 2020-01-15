package com.amazon.ws.emr.hadoop.fs.property;

import java.util.Arrays;
import javax.annotation.Nullable;

public enum SeekStrategyName
{
  LAZY("lazy"),  EAGER("eager");
  
  private static final String LOWER_CASE_NAMES = Arrays.toString(values());
  private final String lowerCaseName;
  
  private SeekStrategyName(String lowerCaseName)
  {
    this.lowerCaseName = lowerCaseName;
  }
  
  public static String getNamesAsString()
  {
    return LOWER_CASE_NAMES;
  }
  
  @Nullable
  public static SeekStrategyName fromName(@Nullable String name)
  {
    for (SeekStrategyName seekStrategyName : ) {
      if (lowerCaseName.equals(name)) {
        return seekStrategyName;
      }
    }
    return null;
  }
  
  public String getName()
  {
    return lowerCaseName;
  }
  
  public boolean isLazySeekStrategy()
  {
    return this == LAZY;
  }
  
  public String toString()
  {
    return lowerCaseName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.property.SeekStrategyName
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */