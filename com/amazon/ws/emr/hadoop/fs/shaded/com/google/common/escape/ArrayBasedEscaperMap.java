package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap
{
  private final char[][] replacementArray;
  
  public static ArrayBasedEscaperMap create(Map<Character, String> replacements)
  {
    return new ArrayBasedEscaperMap(createReplacementArray(replacements));
  }
  
  private ArrayBasedEscaperMap(char[][] replacementArray)
  {
    this.replacementArray = replacementArray;
  }
  
  char[][] getReplacementArray()
  {
    return replacementArray;
  }
  
  @VisibleForTesting
  static char[][] createReplacementArray(Map<Character, String> map)
  {
    Preconditions.checkNotNull(map);
    if (map.isEmpty()) {
      return EMPTY_REPLACEMENT_ARRAY;
    }
    char max = ((Character)Collections.max(map.keySet())).charValue();
    char[][] replacements = new char[max + '\001'][];
    for (Iterator i$ = map.keySet().iterator(); i$.hasNext();)
    {
      char c = ((Character)i$.next()).charValue();
      replacements[c] = ((String)map.get(Character.valueOf(c))).toCharArray();
    }
    return replacements;
  }
  
  private static final char[][] EMPTY_REPLACEMENT_ARRAY = new char[0][0];
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.ArrayBasedEscaperMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */