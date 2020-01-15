package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class SLF4JLogFactory
  extends LogFactory
{
  ConcurrentMap<String, Log> loggerMap;
  public static final String LOG_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log";
  
  public SLF4JLogFactory()
  {
    loggerMap = new ConcurrentHashMap();
  }
  
  protected Hashtable attributes = new Hashtable();
  
  public Object getAttribute(String name)
  {
    return attributes.get(name);
  }
  
  public String[] getAttributeNames()
  {
    List<String> names = new ArrayList();
    Enumeration<String> keys = attributes.keys();
    while (keys.hasMoreElements()) {
      names.add((String)keys.nextElement());
    }
    String[] results = new String[names.size()];
    for (int i = 0; i < results.length; i++) {
      results[i] = ((String)names.get(i));
    }
    return results;
  }
  
  public Log getInstance(Class clazz)
    throws LogConfigurationException
  {
    return getInstance(clazz.getName());
  }
  
  public Log getInstance(String name)
    throws LogConfigurationException
  {
    Log instance = (Log)loggerMap.get(name);
    if (instance != null) {
      return instance;
    }
    Logger slf4jLogger = LoggerFactory.getLogger(name);
    Log newInstance;
    Log newInstance;
    if ((slf4jLogger instanceof LocationAwareLogger)) {
      newInstance = new SLF4JLocationAwareLog((LocationAwareLogger)slf4jLogger);
    } else {
      newInstance = new SLF4JLog(slf4jLogger);
    }
    Log oldInstance = (Log)loggerMap.putIfAbsent(name, newInstance);
    return oldInstance == null ? newInstance : oldInstance;
  }
  
  public void release()
  {
    System.out.println("WARN: The method " + SLF4JLogFactory.class + "#release() was invoked.");
    System.out.println("WARN: Please see http://www.slf4j.org/codes.html#release for an explanation.");
    System.out.flush();
  }
  
  public void removeAttribute(String name)
  {
    attributes.remove(name);
  }
  
  public void setAttribute(String name, Object value)
  {
    if (value == null) {
      attributes.remove(name);
    } else {
      attributes.put(name, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.impl.SLF4JLogFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */