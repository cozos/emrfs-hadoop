package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

class DynamicMessage$1
  extends AbstractParser<DynamicMessage>
{
  DynamicMessage$1(DynamicMessage paramDynamicMessage) {}
  
  public DynamicMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    DynamicMessage.Builder builder = DynamicMessage.newBuilder(DynamicMessage.access$200(this$0));
    try
    {
      builder.mergeFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e.setUnfinishedMessage(builder.buildPartial());
    }
    catch (IOException e)
    {
      throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(builder.buildPartial());
    }
    return builder.buildPartial();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DynamicMessage.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */