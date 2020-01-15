package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public class Descriptors$DescriptorValidationException
  extends Exception
{
  private static final long serialVersionUID = 5750205775490483148L;
  private final String name;
  private final Message proto;
  private final String description;
  
  public String getProblemSymbolName()
  {
    return name;
  }
  
  public Message getProblemProto()
  {
    return proto;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  private Descriptors$DescriptorValidationException(Descriptors.GenericDescriptor problemDescriptor, String description)
  {
    super(problemDescriptor.getFullName() + ": " + description);
    
    name = problemDescriptor.getFullName();
    proto = problemDescriptor.toProto();
    this.description = description;
  }
  
  private Descriptors$DescriptorValidationException(Descriptors.GenericDescriptor problemDescriptor, String description, Throwable cause)
  {
    this(problemDescriptor, description);
    initCause(cause);
  }
  
  private Descriptors$DescriptorValidationException(Descriptors.FileDescriptor problemDescriptor, String description)
  {
    super(problemDescriptor.getName() + ": " + description);
    
    name = problemDescriptor.getName();
    proto = problemDescriptor.toProto();
    this.description = description;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.DescriptorValidationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */