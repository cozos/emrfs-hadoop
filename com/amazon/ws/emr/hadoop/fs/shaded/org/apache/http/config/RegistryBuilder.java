package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class RegistryBuilder<I>
{
  private final Map<String, I> items;
  
  public static <I> RegistryBuilder<I> create()
  {
    return new RegistryBuilder();
  }
  
  RegistryBuilder()
  {
    items = new HashMap();
  }
  
  public RegistryBuilder<I> register(String id, I item)
  {
    Args.notEmpty(id, "ID");
    Args.notNull(item, "Item");
    items.put(id.toLowerCase(Locale.ROOT), item);
    return this;
  }
  
  public Registry<I> build()
  {
    return new Registry(items);
  }
  
  public String toString()
  {
    return items.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.RegistryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */