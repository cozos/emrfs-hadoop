package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface GeneratedMessage$ExtendableMessageOrBuilder<MessageType extends GeneratedMessage.ExtendableMessage>
  extends MessageOrBuilder
{
  public abstract <Type> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
  
  public abstract <Type> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension);
  
  public abstract <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
  
  public abstract <Type> Type getExtension(GeneratedMessage.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */