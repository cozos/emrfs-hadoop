package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class $Join
{
  public static String join(String delimiter, Iterable<?> tokens)
  {
    return join(delimiter, tokens.iterator());
  }
  
  public static String join(String delimiter, Object[] tokens)
  {
    return join(delimiter, Arrays.asList(tokens));
  }
  
  public static String join(String delimiter, @.Nullable Object firstToken, Object... otherTokens)
  {
    .Preconditions.checkNotNull(otherTokens);
    return join(delimiter, .Lists.newArrayList(firstToken, otherTokens));
  }
  
  public static String join(String delimiter, Iterator<?> tokens)
  {
    StringBuilder sb = new StringBuilder();
    join(sb, delimiter, tokens);
    return sb.toString();
  }
  
  public static String join(String keyValueSeparator, String entryDelimiter, Map<?, ?> map)
  {
    return ((StringBuilder)join(new StringBuilder(), keyValueSeparator, entryDelimiter, map)).toString();
  }
  
  public static <T extends Appendable> T join(T appendable, String delimiter, Iterable<?> tokens)
  {
    return join(appendable, delimiter, tokens.iterator());
  }
  
  public static <T extends Appendable> T join(T appendable, String delimiter, Object[] tokens)
  {
    return join(appendable, delimiter, Arrays.asList(tokens));
  }
  
  public static <T extends Appendable> T join(T appendable, String delimiter, @.Nullable Object firstToken, Object... otherTokens)
  {
    .Preconditions.checkNotNull(otherTokens);
    return join(appendable, delimiter, .Lists.newArrayList(firstToken, otherTokens));
  }
  
  public static <T extends Appendable> T join(T appendable, String delimiter, Iterator<?> tokens)
  {
    .Preconditions.checkNotNull(appendable);
    .Preconditions.checkNotNull(delimiter);
    if (tokens.hasNext()) {
      try
      {
        appendOneToken(appendable, tokens.next());
        while (tokens.hasNext())
        {
          appendable.append(delimiter);
          appendOneToken(appendable, tokens.next());
        }
      }
      catch (IOException e)
      {
        throw new JoinException(e, null);
      }
    }
    return appendable;
  }
  
  public static <T extends Appendable> T join(T appendable, String keyValueSeparator, String entryDelimiter, Map<?, ?> map)
  {
    .Preconditions.checkNotNull(appendable);
    .Preconditions.checkNotNull(keyValueSeparator);
    .Preconditions.checkNotNull(entryDelimiter);
    Iterator<? extends Map.Entry<?, ?>> entries = map.entrySet().iterator();
    if (entries.hasNext()) {
      try
      {
        appendOneEntry(appendable, keyValueSeparator, (Map.Entry)entries.next());
        while (entries.hasNext())
        {
          appendable.append(entryDelimiter);
          appendOneEntry(appendable, keyValueSeparator, (Map.Entry)entries.next());
        }
      }
      catch (IOException e)
      {
        throw new JoinException(e, null);
      }
    }
    return appendable;
  }
  
  private static void appendOneEntry(Appendable appendable, String keyValueSeparator, Map.Entry<?, ?> entry)
    throws IOException
  {
    appendOneToken(appendable, entry.getKey());
    appendable.append(keyValueSeparator);
    appendOneToken(appendable, entry.getValue());
  }
  
  private static void appendOneToken(Appendable appendable, Object token)
    throws IOException
  {
    appendable.append(toCharSequence(token));
  }
  
  private static CharSequence toCharSequence(Object token)
  {
    return (token instanceof CharSequence) ? (CharSequence)token : String.valueOf(token);
  }
  
  public static class JoinException
    extends RuntimeException
  {
    private static final long serialVersionUID = 1L;
    
    private JoinException(IOException cause)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Join
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */