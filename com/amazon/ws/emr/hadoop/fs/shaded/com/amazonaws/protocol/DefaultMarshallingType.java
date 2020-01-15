package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

final class DefaultMarshallingType<T>
  implements MarshallingType<T>
{
  private final Class<T> type;
  
  protected DefaultMarshallingType(Class<T> type)
  {
    this.type = type;
  }
  
  public boolean isDefaultMarshallerForType(Class<?> type)
  {
    return this.type.isAssignableFrom(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.DefaultMarshallingType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */