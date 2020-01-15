package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class ExtensionRegistryLite$ObjectIntPair
{
  private final Object object;
  private final int number;
  
  ExtensionRegistryLite$ObjectIntPair(Object object, int number)
  {
    this.object = object;
    this.number = number;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(object) * 65535 + number;
  }
  
  public boolean equals(Object obj)
  {
    if (!(obj instanceof ObjectIntPair)) {
      return false;
    }
    ObjectIntPair other = (ObjectIntPair)obj;
    return (object == object) && (number == number);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistryLite.ObjectIntPair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */