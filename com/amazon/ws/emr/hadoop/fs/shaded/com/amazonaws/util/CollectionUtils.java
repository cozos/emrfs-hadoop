package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CollectionUtils
{
  public static <T> boolean isNullOrEmpty(Collection<T> collection)
  {
    return (collection == null) || (collection.isEmpty());
  }
  
  public static <T> List<T> mergeLists(List<T> list1, List<T> list2)
  {
    List<T> merged = new LinkedList();
    if (list1 != null) {
      merged.addAll(list1);
    }
    if (list2 != null) {
      merged.addAll(list2);
    }
    return merged;
  }
  
  public static String join(Collection<String> toJoin, String separator)
  {
    if (isNullOrEmpty(toJoin)) {
      return "";
    }
    StringBuilder joinedString = new StringBuilder();
    int currentIndex = 0;
    for (String s : toJoin)
    {
      if (s != null) {
        joinedString.append(s);
      }
      if (currentIndex++ != toJoin.size() - 1) {
        joinedString.append(separator);
      }
    }
    return joinedString.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */