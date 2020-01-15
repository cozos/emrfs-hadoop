package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Beta
@GwtCompatible
public final class CharEscaperBuilder
{
  private final Map<Character, String> map;
  
  private static class CharArrayDecorator
    extends CharEscaper
  {
    private final char[][] replacements;
    private final int replaceLength;
    
    CharArrayDecorator(char[][] replacements)
    {
      this.replacements = replacements;
      replaceLength = replacements.length;
    }
    
    public String escape(String s)
    {
      int slen = s.length();
      for (int index = 0; index < slen; index++)
      {
        char c = s.charAt(index);
        if ((c < replacements.length) && (replacements[c] != null)) {
          return escapeSlow(s, index);
        }
      }
      return s;
    }
    
    protected char[] escape(char c)
    {
      return c < replaceLength ? replacements[c] : null;
    }
  }
  
  private int max = -1;
  
  public CharEscaperBuilder()
  {
    map = new HashMap();
  }
  
  public CharEscaperBuilder addEscape(char c, String r)
  {
    map.put(Character.valueOf(c), Preconditions.checkNotNull(r));
    if (c > max) {
      max = c;
    }
    return this;
  }
  
  public CharEscaperBuilder addEscapes(char[] cs, String r)
  {
    Preconditions.checkNotNull(r);
    for (char c : cs) {
      addEscape(c, r);
    }
    return this;
  }
  
  public char[][] toArray()
  {
    char[][] result = new char[max + 1][];
    for (Map.Entry<Character, String> entry : map.entrySet()) {
      result[((Character)entry.getKey()).charValue()] = ((String)entry.getValue()).toCharArray();
    }
    return result;
  }
  
  public Escaper toEscaper()
  {
    return new CharArrayDecorator(toArray());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.CharEscaperBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */