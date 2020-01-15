package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

final class DaitchMokotoffSoundex$Branch
{
  private final StringBuilder builder;
  private String cachedString;
  private String lastReplacement;
  
  private DaitchMokotoffSoundex$Branch()
  {
    builder = new StringBuilder();
    lastReplacement = null;
    cachedString = null;
  }
  
  public Branch createBranch()
  {
    Branch branch = new Branch();
    builder.append(toString());
    lastReplacement = lastReplacement;
    return branch;
  }
  
  public boolean equals(Object other)
  {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Branch)) {
      return false;
    }
    return toString().equals(((Branch)other).toString());
  }
  
  public void finish()
  {
    while (builder.length() < 6)
    {
      builder.append('0');
      cachedString = null;
    }
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public void processNextReplacement(String replacement, boolean forceAppend)
  {
    boolean append = (lastReplacement == null) || (!lastReplacement.endsWith(replacement)) || (forceAppend);
    if ((append) && (builder.length() < 6))
    {
      builder.append(replacement);
      if (builder.length() > 6) {
        builder.delete(6, builder.length());
      }
      cachedString = null;
    }
    lastReplacement = replacement;
  }
  
  public String toString()
  {
    if (cachedString == null) {
      cachedString = builder.toString();
    }
    return cachedString;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.DaitchMokotoffSoundex.Branch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */