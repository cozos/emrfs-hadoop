package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistryLite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;

final class EmrFsStore$MetadataFile$1
  extends AbstractParser<EmrFsStore.MetadataFile>
{
  public EmrFsStore.MetadataFile parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return new EmrFsStore.MetadataFile(input, extensionRegistry, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */