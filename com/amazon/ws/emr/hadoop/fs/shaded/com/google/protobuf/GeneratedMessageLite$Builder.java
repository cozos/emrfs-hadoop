package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public abstract class GeneratedMessageLite$Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder>
  extends AbstractMessageLite.Builder<BuilderType>
{
  public BuilderType clear()
  {
    return this;
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public abstract BuilderType mergeFrom(MessageType paramMessageType);
  
  public abstract MessageType getDefaultInstanceForType();
  
  protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return input.skipField(tag);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */