package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Lang$LangRule
{
  private final boolean acceptOnMatch;
  private final Set<String> languages;
  private final Pattern pattern;
  
  private Lang$LangRule(Pattern pattern, Set<String> languages, boolean acceptOnMatch)
  {
    this.pattern = pattern;
    this.languages = languages;
    this.acceptOnMatch = acceptOnMatch;
  }
  
  public boolean matches(String txt)
  {
    return pattern.matcher(txt).find();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Lang.LangRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */