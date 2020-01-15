package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm;

import java.util.NoSuchElementException;

final class Languages$2
  extends Languages.LanguageSet
{
  public boolean contains(String language)
  {
    return true;
  }
  
  public String getAny()
  {
    throw new NoSuchElementException("Can't fetch any language from the any language set.");
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isSingleton()
  {
    return false;
  }
  
  public Languages.LanguageSet restrictTo(Languages.LanguageSet other)
  {
    return other;
  }
  
  public Languages.LanguageSet merge(Languages.LanguageSet other)
  {
    return other;
  }
  
  public String toString()
  {
    return "ANY_LANGUAGE";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.bm.Languages.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */