package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.NoSuchElementException;

final class Languages$1
  extends Languages.LanguageSet
{
  public boolean contains(String language)
  {
    return false;
  }
  
  public String getAny()
  {
    throw new NoSuchElementException("Can't fetch any language from the empty language set.");
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isSingleton()
  {
    return false;
  }
  
  public Languages.LanguageSet restrictTo(Languages.LanguageSet other)
  {
    return this;
  }
  
  public Languages.LanguageSet merge(Languages.LanguageSet other)
  {
    return other;
  }
  
  public String toString()
  {
    return "NO_LANGUAGES";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Languages.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */