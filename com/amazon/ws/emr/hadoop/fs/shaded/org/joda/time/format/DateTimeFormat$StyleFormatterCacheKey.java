package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.util.Locale;

class DateTimeFormat$StyleFormatterCacheKey
{
  private final int combinedTypeAndStyle;
  private final Locale locale;
  
  public DateTimeFormat$StyleFormatterCacheKey(int paramInt1, int paramInt2, int paramInt3, Locale paramLocale)
  {
    locale = paramLocale;
    
    combinedTypeAndStyle = (paramInt1 + (paramInt2 << 4) + (paramInt3 << 8));
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + combinedTypeAndStyle;
    i = 31 * i + (locale == null ? 0 : locale.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof StyleFormatterCacheKey)) {
      return false;
    }
    StyleFormatterCacheKey localStyleFormatterCacheKey = (StyleFormatterCacheKey)paramObject;
    if (combinedTypeAndStyle != combinedTypeAndStyle) {
      return false;
    }
    if (locale == null)
    {
      if (locale != null) {
        return false;
      }
    }
    else if (!locale.equals(locale)) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat.StyleFormatterCacheKey
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */