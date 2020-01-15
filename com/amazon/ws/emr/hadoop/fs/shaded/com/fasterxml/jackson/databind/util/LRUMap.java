package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class LRUMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final transient int _maxEntries;
  protected final transient ConcurrentHashMap<K, V> _map;
  protected transient int _jdkSerializeMaxEntries;
  
  public LRUMap(int initialEntries, int maxEntries)
  {
    _map = new ConcurrentHashMap(initialEntries, 0.8F, 4);
    _maxEntries = maxEntries;
  }
  
  public V put(K key, V value)
  {
    if (_map.size() >= _maxEntries) {
      synchronized (this)
      {
        if (_map.size() >= _maxEntries) {
          clear();
        }
      }
    }
    return (V)_map.put(key, value);
  }
  
  public V putIfAbsent(K key, V value)
  {
    if (_map.size() >= _maxEntries) {
      synchronized (this)
      {
        if (_map.size() >= _maxEntries) {
          clear();
        }
      }
    }
    return (V)_map.putIfAbsent(key, value);
  }
  
  public V get(Object key)
  {
    return (V)_map.get(key);
  }
  
  public void clear()
  {
    _map.clear();
  }
  
  public int size()
  {
    return _map.size();
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException
  {
    _jdkSerializeMaxEntries = in.readInt();
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.writeInt(_jdkSerializeMaxEntries);
  }
  
  protected Object readResolve()
  {
    return new LRUMap(_jdkSerializeMaxEntries, _jdkSerializeMaxEntries);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.LRUMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */