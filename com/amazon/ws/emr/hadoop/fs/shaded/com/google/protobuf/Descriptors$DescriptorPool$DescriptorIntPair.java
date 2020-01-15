package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class Descriptors$DescriptorPool$DescriptorIntPair
{
  private final Descriptors.GenericDescriptor descriptor;
  private final int number;
  
  Descriptors$DescriptorPool$DescriptorIntPair(Descriptors.GenericDescriptor descriptor, int number)
  {
    this.descriptor = descriptor;
    this.number = number;
  }
  
  public int hashCode()
  {
    return descriptor.hashCode() * 65535 + number;
  }
  
  public boolean equals(Object obj)
  {
    if (!(obj instanceof DescriptorIntPair)) {
      return false;
    }
    DescriptorIntPair other = (DescriptorIntPair)obj;
    return (descriptor == descriptor) && (number == number);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.DescriptorPool.DescriptorIntPair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */