package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Collections;
import java.util.Comparator;

public final class Rule$Phoneme
  implements Rule.PhonemeExpr
{
  public static final Comparator<Phoneme> COMPARATOR = new Comparator()
  {
    public int compare(Rule.Phoneme o1, Rule.Phoneme o2)
    {
      for (int i = 0; i < phonemeText.length(); i++)
      {
        if (i >= phonemeText.length()) {
          return 1;
        }
        int c = phonemeText.charAt(i) - phonemeText.charAt(i);
        if (c != 0) {
          return c;
        }
      }
      if (phonemeText.length() < phonemeText.length()) {
        return -1;
      }
      return 0;
    }
  };
  private final StringBuilder phonemeText;
  private final Languages.LanguageSet languages;
  
  public Rule$Phoneme(CharSequence phonemeText, Languages.LanguageSet languages)
  {
    this.phonemeText = new StringBuilder(phonemeText);
    this.languages = languages;
  }
  
  public Rule$Phoneme(Phoneme phonemeLeft, Phoneme phonemeRight)
  {
    this(phonemeText, languages);
    phonemeText.append(phonemeText);
  }
  
  public Rule$Phoneme(Phoneme phonemeLeft, Phoneme phonemeRight, Languages.LanguageSet languages)
  {
    this(phonemeText, languages);
    phonemeText.append(phonemeText);
  }
  
  public Phoneme append(CharSequence str)
  {
    phonemeText.append(str);
    return this;
  }
  
  public Languages.LanguageSet getLanguages()
  {
    return languages;
  }
  
  public Iterable<Phoneme> getPhonemes()
  {
    return Collections.singleton(this);
  }
  
  public CharSequence getPhonemeText()
  {
    return phonemeText;
  }
  
  @Deprecated
  public Phoneme join(Phoneme right)
  {
    return new Phoneme(phonemeText.toString() + phonemeText.toString(), languages.restrictTo(languages));
  }
  
  public Phoneme mergeWithLanguage(Languages.LanguageSet lang)
  {
    return new Phoneme(phonemeText.toString(), languages.merge(lang));
  }
  
  public String toString()
  {
    return phonemeText.toString() + "[" + languages + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Rule.Phoneme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */