package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public final class GeneratedMessageLite$GeneratedExtension<ContainingType extends MessageLite, Type>
{
  private final ContainingType containingTypeDefaultInstance;
  private final Type defaultValue;
  private final MessageLite messageDefaultInstance;
  private final GeneratedMessageLite.ExtensionDescriptor descriptor;
  
  private GeneratedMessageLite$GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, GeneratedMessageLite.ExtensionDescriptor descriptor)
  {
    if (containingTypeDefaultInstance == null) {
      throw new IllegalArgumentException("Null containingTypeDefaultInstance");
    }
    if ((descriptor.getLiteType() == WireFormat.FieldType.MESSAGE) && (messageDefaultInstance == null)) {
      throw new IllegalArgumentException("Null messageDefaultInstance");
    }
    this.containingTypeDefaultInstance = containingTypeDefaultInstance;
    this.defaultValue = defaultValue;
    this.messageDefaultInstance = messageDefaultInstance;
    this.descriptor = descriptor;
  }
  
  public ContainingType getContainingTypeDefaultInstance()
  {
    return containingTypeDefaultInstance;
  }
  
  public int getNumber()
  {
    return descriptor.getNumber();
  }
  
  public MessageLite getMessageDefaultInstance()
  {
    return messageDefaultInstance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.GeneratedExtension
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */