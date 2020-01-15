package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Set;

public abstract class Languages$LanguageSet
{
  public static LanguageSet from(Set<String> langs)
  {
    return langs.isEmpty() ? Languages.NO_LANGUAGES : new Languages.SomeLanguages(langs, null);
  }
  
  public abstract boolean contains(String paramString);
  
  public abstract String getAny();
  
  public abstract boolean isEmpty();
  
  public abstract boolean isSingleton();
  
  public abstract LanguageSet restrictTo(LanguageSet paramLanguageSet);
  
  abstract LanguageSet merge(LanguageSet paramLanguageSet);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Languages.LanguageSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */