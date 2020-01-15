package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;

public final class Joiner$MapJoiner
{
  private final Joiner joiner;
  private final String keyValueSeparator;
  
  private Joiner$MapJoiner(Joiner joiner, String keyValueSeparator)
  {
    this.joiner = joiner;
    this.keyValueSeparator = ((String)Preconditions.checkNotNull(keyValueSeparator));
  }
  
  public <A extends Appendable> A appendTo(A appendable, Map<?, ?> map)
    throws IOException
  {
    return appendTo(appendable, map.entrySet());
  }
  
  public StringBuilder appendTo(StringBuilder builder, Map<?, ?> map)
  {
    return appendTo(builder, map.entrySet());
  }
  
  public String join(Map<?, ?> map)
  {
    return join(map.entrySet());
  }
  
  @Beta
  public <A extends Appendable> A appendTo(A appendable, Iterable<? extends Map.Entry<?, ?>> entries)
    throws IOException
  {
    return appendTo(appendable, entries.iterator());
  }
  
  @Beta
  public <A extends Appendable> A appendTo(A appendable, Iterator<? extends Map.Entry<?, ?>> parts)
    throws IOException
  {
    Preconditions.checkNotNull(appendable);
    if (parts.hasNext())
    {
      Map.Entry<?, ?> entry = (Map.Entry)parts.next();
      appendable.append(joiner.toString(entry.getKey()));
      appendable.append(keyValueSeparator);
      appendable.append(joiner.toString(entry.getValue()));
      while (parts.hasNext())
      {
        appendable.append(Joiner.access$100(joiner));
        Map.Entry<?, ?> e = (Map.Entry)parts.next();
        appendable.append(joiner.toString(e.getKey()));
        appendable.append(keyValueSeparator);
        appendable.append(joiner.toString(e.getValue()));
      }
    }
    return appendable;
  }
  
  @Beta
  public StringBuilder appendTo(StringBuilder builder, Iterable<? extends Map.Entry<?, ?>> entries)
  {
    return appendTo(builder, entries.iterator());
  }
  
  @Beta
  public StringBuilder appendTo(StringBuilder builder, Iterator<? extends Map.Entry<?, ?>> entries)
  {
    try
    {
      appendTo(builder, entries);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
    return builder;
  }
  
  @Beta
  public String join(Iterable<? extends Map.Entry<?, ?>> entries)
  {
    return join(entries.iterator());
  }
  
  @Beta
  public String join(Iterator<? extends Map.Entry<?, ?>> entries)
  {
    return appendTo(new StringBuilder(), entries).toString();
  }
  
  @CheckReturnValue
  public MapJoiner useForNull(String nullText)
  {
    return new MapJoiner(joiner.useForNull(nullText), keyValueSeparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner.MapJoiner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */