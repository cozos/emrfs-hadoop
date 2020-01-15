package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class CaseFormat$StringConverter
  extends Converter<String, String>
  implements Serializable
{
  private final CaseFormat sourceFormat;
  private final CaseFormat targetFormat;
  private static final long serialVersionUID = 0L;
  
  CaseFormat$StringConverter(CaseFormat sourceFormat, CaseFormat targetFormat)
  {
    this.sourceFormat = ((CaseFormat)Preconditions.checkNotNull(sourceFormat));
    this.targetFormat = ((CaseFormat)Preconditions.checkNotNull(targetFormat));
  }
  
  protected String doForward(String s)
  {
    return s == null ? null : sourceFormat.to(targetFormat, s);
  }
  
  protected String doBackward(String s)
  {
    return s == null ? null : targetFormat.to(sourceFormat, s);
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof StringConverter))
    {
      StringConverter that = (StringConverter)object;
      return (sourceFormat.equals(sourceFormat)) && (targetFormat.equals(targetFormat));
    }
    return false;
  }
  
  public int hashCode()
  {
    return sourceFormat.hashCode() ^ targetFormat.hashCode();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(sourceFormat));String str2 = String.valueOf(String.valueOf(targetFormat));return 14 + str1.length() + str2.length() + str1 + ".converterTo(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CaseFormat.StringConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */