package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Beta
public final class Splitter$MapSplitter
{
  private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
  private final Splitter outerSplitter;
  private final Splitter entrySplitter;
  
  private Splitter$MapSplitter(Splitter outerSplitter, Splitter entrySplitter)
  {
    this.outerSplitter = outerSplitter;
    this.entrySplitter = ((Splitter)Preconditions.checkNotNull(entrySplitter));
  }
  
  public Map<String, String> split(CharSequence sequence)
  {
    Map<String, String> map = new LinkedHashMap();
    for (String entry : outerSplitter.split(sequence))
    {
      Iterator<String> entryFields = Splitter.access$000(entrySplitter, entry);
      
      Preconditions.checkArgument(entryFields.hasNext(), "Chunk [%s] is not a valid entry", new Object[] { entry });
      String key = (String)entryFields.next();
      Preconditions.checkArgument(!map.containsKey(key), "Duplicate key [%s] found.", new Object[] { key });
      
      Preconditions.checkArgument(entryFields.hasNext(), "Chunk [%s] is not a valid entry", new Object[] { entry });
      String value = (String)entryFields.next();
      map.put(key, value);
      
      Preconditions.checkArgument(!entryFields.hasNext(), "Chunk [%s] is not a valid entry", new Object[] { entry });
    }
    return Collections.unmodifiableMap(map);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter.MapSplitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */