package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

public class LookupTranslator
  extends CharSequenceTranslator
{
  private final HashMap<String, CharSequence> lookupMap;
  private final int shortest;
  private final int longest;
  
  public LookupTranslator(CharSequence[]... lookup)
  {
    lookupMap = new HashMap();
    int _shortest = Integer.MAX_VALUE;
    int _longest = 0;
    if (lookup != null) {
      for (CharSequence[] seq : lookup)
      {
        lookupMap.put(seq[0].toString(), seq[1]);
        int sz = seq[0].length();
        if (sz < _shortest) {
          _shortest = sz;
        }
        if (sz > _longest) {
          _longest = sz;
        }
      }
    }
    shortest = _shortest;
    longest = _longest;
  }
  
  public int translate(CharSequence input, int index, Writer out)
    throws IOException
  {
    int max = longest;
    if (index + longest > input.length()) {
      max = input.length() - index;
    }
    for (int i = max; i >= shortest; i--)
    {
      CharSequence subSeq = input.subSequence(index, index + i);
      CharSequence result = (CharSequence)lookupMap.get(subSeq.toString());
      if (result != null)
      {
        out.write(result.toString());
        return i;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.translate.LookupTranslator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */