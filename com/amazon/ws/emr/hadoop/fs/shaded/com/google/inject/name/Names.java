package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Names
{
  public static Named named(String name)
  {
    return new NamedImpl(name);
  }
  
  public static void bindProperties(Binder binder, Map<String, String> properties)
  {
    binder = binder.skipSources(new Class[] { Names.class });
    for (Map.Entry<String, String> entry : properties.entrySet())
    {
      String key = (String)entry.getKey();
      String value = (String)entry.getValue();
      binder.bind(Key.get(String.class, new NamedImpl(key))).toInstance(value);
    }
  }
  
  public static void bindProperties(Binder binder, Properties properties)
  {
    binder = binder.skipSources(new Class[] { Names.class });
    for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements();)
    {
      String propertyName = (String)e.nextElement();
      String value = properties.getProperty(propertyName);
      binder.bind(Key.get(String.class, new NamedImpl(propertyName))).toInstance(value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Names
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */