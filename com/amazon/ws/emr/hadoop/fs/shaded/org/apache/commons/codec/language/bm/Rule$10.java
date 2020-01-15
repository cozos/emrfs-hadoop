package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Rule$10
  implements Rule.RPattern
{
  Pattern pattern = Pattern.compile(val$regex);
  
  Rule$10(String paramString) {}
  
  public boolean isMatch(CharSequence input)
  {
    Matcher matcher = pattern.matcher(input);
    return matcher.find();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Rule.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */