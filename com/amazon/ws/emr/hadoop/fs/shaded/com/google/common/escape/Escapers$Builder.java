package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public final class Escapers$Builder
{
  private final Map<Character, String> replacementMap = new HashMap();
  private char safeMin = '\000';
  private char safeMax = 65535;
  private String unsafeReplacement = null;
  
  public Builder setSafeRange(char safeMin, char safeMax)
  {
    this.safeMin = safeMin;
    this.safeMax = safeMax;
    return this;
  }
  
  public Builder setUnsafeReplacement(@Nullable String unsafeReplacement)
  {
    this.unsafeReplacement = unsafeReplacement;
    return this;
  }
  
  public Builder addEscape(char c, String replacement)
  {
    Preconditions.checkNotNull(replacement);
    
    replacementMap.put(Character.valueOf(c), replacement);
    return this;
  }
  
  public Escaper build()
  {
    new ArrayBasedCharEscaper(replacementMap, safeMin, safeMax)
    {
      private final char[] replacementChars = unsafeReplacement != null ? unsafeReplacement.toCharArray() : null;
      
      protected char[] escapeUnsafe(char c)
      {
        return replacementChars;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.Escapers.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */