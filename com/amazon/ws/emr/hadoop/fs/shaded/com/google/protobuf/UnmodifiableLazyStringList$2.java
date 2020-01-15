package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Iterator;

class UnmodifiableLazyStringList$2
  implements Iterator<String>
{
  Iterator<String> iter = UnmodifiableLazyStringList.access$000(this$0).iterator();
  
  UnmodifiableLazyStringList$2(UnmodifiableLazyStringList paramUnmodifiableLazyStringList) {}
  
  public boolean hasNext()
  {
    return iter.hasNext();
  }
  
  public String next()
  {
    return (String)iter.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnmodifiableLazyStringList.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */