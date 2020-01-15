package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class UnknownFieldSet$Parser
  extends AbstractParser<UnknownFieldSet>
{
  public UnknownFieldSet parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
    try
    {
      builder.mergeFrom(input);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet.Parser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */