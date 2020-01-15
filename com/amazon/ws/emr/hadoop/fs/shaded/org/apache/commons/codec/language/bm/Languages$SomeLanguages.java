package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class Languages$SomeLanguages
  extends Languages.LanguageSet
{
  private final Set<String> languages;
  
  private Languages$SomeLanguages(Set<String> languages)
  {
    this.languages = Collections.unmodifiableSet(languages);
  }
  
  public boolean contains(String language)
  {
    return languages.contains(language);
  }
  
  public String getAny()
  {
    return (String)languages.iterator().next();
  }
  
  public Set<String> getLanguages()
  {
    return languages;
  }
  
  public boolean isEmpty()
  {
    return languages.isEmpty();
  }
  
  public boolean isSingleton()
  {
    return languages.size() == 1;
  }
  
  public Languages.LanguageSet restrictTo(Languages.LanguageSet other)
  {
    if (other == Languages.NO_LANGUAGES) {
      return other;
    }
    if (other == Languages.ANY_LANGUAGE) {
      return this;
    }
    SomeLanguages sl = (SomeLanguages)other;
    Set<String> ls = new HashSet(Math.min(languages.size(), languages.size()));
    for (String lang : languages) {
      if (languages.contains(lang)) {
        ls.add(lang);
      }
    }
    return from(ls);
  }
  
  public Languages.LanguageSet merge(Languages.LanguageSet other)
  {
    if (other == Languages.NO_LANGUAGES) {
      return this;
    }
    if (other == Languages.ANY_LANGUAGE) {
      return other;
    }
    SomeLanguages sl = (SomeLanguages)other;
    Set<String> ls = new HashSet(languages);
    for (String lang : languages) {
      ls.add(lang);
    }
    return from(ls);
  }
  
  public String toString()
  {
    return "Languages(" + languages.toString() + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Languages.SomeLanguages
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */