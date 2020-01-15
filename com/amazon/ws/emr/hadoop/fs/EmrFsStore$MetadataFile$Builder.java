package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.Descriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistryLite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.BuilderParent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Parser;
import java.io.IOException;

public final class EmrFsStore$MetadataFile$Builder
  extends GeneratedMessage.Builder<Builder>
  implements EmrFsStore.MetadataFileOrBuilder
{
  private int bitField0_;
  private int version_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return EmrFsStore.access$000();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return 
      EmrFsStore.access$100().ensureFieldAccessorsInitialized(EmrFsStore.MetadataFile.class, Builder.class);
  }
  
  private EmrFsStore$MetadataFile$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private EmrFsStore$MetadataFile$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (EmrFsStore.MetadataFile.access$500()) {}
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    version_ = 0;
    bitField0_ &= 0xFFFFFFFE;
    state_ = EmrFsStore.MetadataFile.State.DISCOVERED;
    bitField0_ &= 0xFFFFFFFD;
    isDirectory_ = false;
    bitField0_ &= 0xFFFFFFFB;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return EmrFsStore.access$000();
  }
  
  public EmrFsStore.MetadataFile getDefaultInstanceForType()
  {
    return EmrFsStore.MetadataFile.getDefaultInstance();
  }
  
  public EmrFsStore.MetadataFile build()
  {
    EmrFsStore.MetadataFile result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public EmrFsStore.MetadataFile buildPartial()
  {
    EmrFsStore.MetadataFile result = new EmrFsStore.MetadataFile(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    EmrFsStore.MetadataFile.access$702(result, version_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    EmrFsStore.MetadataFile.access$802(result, state_);
    if ((from_bitField0_ & 0x4) == 4) {
      to_bitField0_ |= 0x4;
    }
    EmrFsStore.MetadataFile.access$902(result, isDirectory_);
    EmrFsStore.MetadataFile.access$1002(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof EmrFsStore.MetadataFile)) {
      return mergeFrom((EmrFsStore.MetadataFile)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(EmrFsStore.MetadataFile other)
  {
    if (other == EmrFsStore.MetadataFile.getDefaultInstance()) {
      return this;
    }
    if (other.hasVersion()) {
      setVersion(other.getVersion());
    }
    if (other.hasState()) {
      setState(other.getState());
    }
    if (other.hasIsDirectory()) {
      setIsDirectory(other.getIsDirectory());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    if (!hasVersion()) {
      return false;
    }
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    EmrFsStore.MetadataFile parsedMessage = null;
    try
    {
      parsedMessage = (EmrFsStore.MetadataFile)EmrFsStore.MetadataFile.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (EmrFsStore.MetadataFile)e.getUnfinishedMessage();
      throw e;
    }
    finally
    {
      if (parsedMessage != null) {
        mergeFrom(parsedMessage);
      }
    }
    return this;
  }
  
  public boolean hasVersion()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public int getVersion()
  {
    return version_;
  }
  
  public Builder setVersion(int value)
  {
    bitField0_ |= 0x1;
    version_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearVersion()
  {
    bitField0_ &= 0xFFFFFFFE;
    version_ = 0;
    onChanged();
    return this;
  }
  
  private EmrFsStore.MetadataFile.State state_ = EmrFsStore.MetadataFile.State.DISCOVERED;
  private boolean isDirectory_;
  
  public boolean hasState()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public EmrFsStore.MetadataFile.State getState()
  {
    return state_;
  }
  
  public Builder setState(EmrFsStore.MetadataFile.State value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x2;
    state_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearState()
  {
    bitField0_ &= 0xFFFFFFFD;
    state_ = EmrFsStore.MetadataFile.State.DISCOVERED;
    onChanged();
    return this;
  }
  
  public boolean hasIsDirectory()
  {
    return (bitField0_ & 0x4) == 4;
  }
  
  public boolean getIsDirectory()
  {
    return isDirectory_;
  }
  
  public Builder setIsDirectory(boolean value)
  {
    bitField0_ |= 0x4;
    isDirectory_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearIsDirectory()
  {
    bitField0_ &= 0xFFFFFFFB;
    isDirectory_ = false;
    onChanged();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */