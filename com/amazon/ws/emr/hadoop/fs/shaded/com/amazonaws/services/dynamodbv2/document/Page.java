package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import java.util.Iterator;
import java.util.List;

public abstract class Page<T, R>
  implements Iterable<T>
{
  private final List<T> content;
  private final R lowLevelResult;
  
  public abstract boolean hasNextPage();
  
  public abstract Page<T, R> nextPage();
  
  public Page(List<T> content, R lowLevelResult)
  {
    if ((content == null) || (lowLevelResult == null)) {
      throw new IllegalArgumentException("both content and lowLevelResult must be specified");
    }
    this.content = content;
    this.lowLevelResult = lowLevelResult;
  }
  
  public final int size()
  {
    return content.size();
  }
  
  public final Iterator<T> iterator()
  {
    return content.iterator();
  }
  
  public String toString()
  {
    return content.toString();
  }
  
  public final R getLowLevelResult()
  {
    return (R)lowLevelResult;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */