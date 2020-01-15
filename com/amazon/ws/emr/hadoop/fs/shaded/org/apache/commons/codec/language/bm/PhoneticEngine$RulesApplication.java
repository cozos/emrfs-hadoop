package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.List;
import java.util.Map;

final class PhoneticEngine$RulesApplication
{
  private final Map<String, List<Rule>> finalRules;
  private final CharSequence input;
  private PhoneticEngine.PhonemeBuilder phonemeBuilder;
  private int i;
  private final int maxPhonemes;
  private boolean found;
  
  public PhoneticEngine$RulesApplication(Map<String, List<Rule>> finalRules, CharSequence input, PhoneticEngine.PhonemeBuilder phonemeBuilder, int i, int maxPhonemes)
  {
    if (finalRules == null) {
      throw new NullPointerException("The finalRules argument must not be null");
    }
    this.finalRules = finalRules;
    this.phonemeBuilder = phonemeBuilder;
    this.input = input;
    this.i = i;
    this.maxPhonemes = maxPhonemes;
  }
  
  public int getI()
  {
    return i;
  }
  
  public PhoneticEngine.PhonemeBuilder getPhonemeBuilder()
  {
    return phonemeBuilder;
  }
  
  public RulesApplication invoke()
  {
    found = false;
    int patternLength = 1;
    List<Rule> rules = (List)finalRules.get(input.subSequence(i, i + patternLength));
    if (rules != null) {
      for (Rule rule : rules)
      {
        String pattern = rule.getPattern();
        patternLength = pattern.length();
        if (rule.patternAndContextMatches(input, i))
        {
          phonemeBuilder.apply(rule.getPhoneme(), maxPhonemes);
          found = true;
          break;
        }
      }
    }
    if (!found) {
      patternLength = 1;
    }
    i += patternLength;
    return this;
  }
  
  public boolean isFound()
  {
    return found;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */