package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface GeneratedMessageLite$ExtendableMessageOrBuilder<MessageType extends GeneratedMessageLite.ExtendableMessage>
  extends MessageLiteOrBuilder
{
  public abstract <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
  
  public abstract <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension);
  
  public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> paramGeneratedExtension);
  
  public abstract <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> paramGeneratedExtension, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */