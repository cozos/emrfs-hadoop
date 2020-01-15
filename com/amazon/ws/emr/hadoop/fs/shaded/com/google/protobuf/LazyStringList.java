package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface LazyStringList
  extends List<String>
{
  public abstract ByteString getByteString(int paramInt);
  
  public abstract void add(ByteString paramByteString);
  
  public abstract List<?> getUnderlyingElements();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LazyStringList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */