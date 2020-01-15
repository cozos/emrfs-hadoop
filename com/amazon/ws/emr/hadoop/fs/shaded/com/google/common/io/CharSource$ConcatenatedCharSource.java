package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;

final class CharSource$ConcatenatedCharSource
  extends CharSource
{
  private final Iterable<? extends CharSource> sources;
  
  CharSource$ConcatenatedCharSource(Iterable<? extends CharSource> sources)
  {
    this.sources = ((Iterable)Preconditions.checkNotNull(sources));
  }
  
  public Reader openStream()
    throws IOException
  {
    return new MultiReader(sources.iterator());
  }
  
  public boolean isEmpty()
    throws IOException
  {
    for (CharSource source : sources) {
      if (!source.isEmpty()) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(sources));return 19 + str.length() + "CharSource.concat(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharSource.ConcatenatedCharSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */