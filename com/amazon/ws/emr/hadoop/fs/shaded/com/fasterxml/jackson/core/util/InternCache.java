package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

public final class InternCache
  extends ConcurrentHashMap<String, String>
{
  private static final int MAX_ENTRIES = 180;
  public static final InternCache instance = new InternCache();
  private final Object lock = new Object();
  
  private InternCache()
  {
    super(180, 0.8F, 4);
  }
  
  public String intern(String input)
  {
    String result = (String)get(input);
    if (result != null) {
      return result;
    }
    if (size() >= 180) {
      synchronized (lock)
      {
        if (size() >= 180) {
          clear();
        }
      }
    }
    result = input.intern();
    put(result, result);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.InternCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */