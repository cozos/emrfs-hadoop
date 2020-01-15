package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

import java.util.Arrays;

final class DaitchMokotoffSoundex$Rule
{
  private final String pattern;
  private final String[] replacementAtStart;
  private final String[] replacementBeforeVowel;
  private final String[] replacementDefault;
  
  protected DaitchMokotoffSoundex$Rule(String pattern, String replacementAtStart, String replacementBeforeVowel, String replacementDefault)
  {
    this.pattern = pattern;
    this.replacementAtStart = replacementAtStart.split("\\|");
    this.replacementBeforeVowel = replacementBeforeVowel.split("\\|");
    this.replacementDefault = replacementDefault.split("\\|");
  }
  
  public int getPatternLength()
  {
    return pattern.length();
  }
  
  public String[] getReplacements(String context, boolean atStart)
  {
    if (atStart) {
      return replacementAtStart;
    }
    int nextIndex = getPatternLength();
    boolean nextCharIsVowel = nextIndex < context.length() ? isVowel(context.charAt(nextIndex)) : false;
    if (nextCharIsVowel) {
      return replacementBeforeVowel;
    }
    return replacementDefault;
  }
  
  private boolean isVowel(char ch)
  {
    return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u');
  }
  
  public boolean matches(String context)
  {
    return context.startsWith(pattern);
  }
  
  public String toString()
  {
    return String.format("%s=(%s,%s,%s)", new Object[] { pattern, Arrays.asList(replacementAtStart), Arrays.asList(replacementBeforeVowel), Arrays.asList(replacementDefault) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.DaitchMokotoffSoundex.Rule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */