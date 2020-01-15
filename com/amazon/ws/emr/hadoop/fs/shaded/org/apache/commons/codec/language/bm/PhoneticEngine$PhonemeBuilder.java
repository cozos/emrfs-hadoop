package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

final class PhoneticEngine$PhonemeBuilder
{
  private final Set<Rule.Phoneme> phonemes;
  
  public static PhonemeBuilder empty(Languages.LanguageSet languages)
  {
    return new PhonemeBuilder(new Rule.Phoneme("", languages));
  }
  
  private PhoneticEngine$PhonemeBuilder(Rule.Phoneme phoneme)
  {
    phonemes = new LinkedHashSet();
    phonemes.add(phoneme);
  }
  
  private PhoneticEngine$PhonemeBuilder(Set<Rule.Phoneme> phonemes)
  {
    this.phonemes = phonemes;
  }
  
  public void append(CharSequence str)
  {
    for (Rule.Phoneme ph : phonemes) {
      ph.append(str);
    }
  }
  
  public void apply(Rule.PhonemeExpr phonemeExpr, int maxPhonemes)
  {
    Set<Rule.Phoneme> newPhonemes = new LinkedHashSet(maxPhonemes);
    for (Iterator i$ = phonemes.iterator(); i$.hasNext();)
    {
      left = (Rule.Phoneme)i$.next();
      for (Rule.Phoneme right : phonemeExpr.getPhonemes())
      {
        Languages.LanguageSet languages = left.getLanguages().restrictTo(right.getLanguages());
        if (!languages.isEmpty())
        {
          Rule.Phoneme join = new Rule.Phoneme(left, right, languages);
          if (newPhonemes.size() < maxPhonemes)
          {
            newPhonemes.add(join);
            if (newPhonemes.size() >= maxPhonemes) {
              break label153;
            }
          }
        }
      }
    }
    Rule.Phoneme left;
    label153:
    phonemes.clear();
    phonemes.addAll(newPhonemes);
  }
  
  public Set<Rule.Phoneme> getPhonemes()
  {
    return phonemes;
  }
  
  public String makeString()
  {
    StringBuilder sb = new StringBuilder();
    for (Rule.Phoneme ph : phonemes)
    {
      if (sb.length() > 0) {
        sb.append("|");
      }
      sb.append(ph.getPhonemeText());
    }
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */