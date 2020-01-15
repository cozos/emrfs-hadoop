package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

final class DynamoDBMapper$StringListMap<T>
  extends LinkedHashMap<String, List<T>>
{
  private static final long serialVersionUID = -1L;
  
  public List<T> getPutIfNotExists(String key)
  {
    List<T> list = (List)get(key);
    if (list == null) {
      put(key, list = new LinkedList());
    }
    return list;
  }
  
  public boolean add(String key, T value)
  {
    return getPutIfNotExists(key).add(value);
  }
  
  public List<StringListMap<T>> subMaps(int size, boolean perMap)
  {
    LinkedList<StringListMap<T>> maps = new LinkedList();
    int index = 0;int count = 0;
    for (Map.Entry<String, List<T>> entry : entrySet()) {
      for (Iterator localIterator2 = ((List)entry.getValue()).iterator(); localIterator2.hasNext(); index = perMap ? count / size : index % size)
      {
        T value = localIterator2.next();
        if (index == maps.size()) {
          maps.add(new StringListMap());
        }
        ((StringListMap)maps.get(index)).add((String)entry.getKey(), value);
        count++;index++;
      }
    }
    return maps;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.StringListMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */