package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorSet$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.FileDescriptorSetOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$000();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos.FileDescriptorSet.class, Builder.class);
  }
  
  private DescriptorProtos$FileDescriptorSet$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders) {
      getFileFieldBuilder();
    }
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    if (fileBuilder_ == null)
    {
      file_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
    }
    else
    {
      fileBuilder_.clear();
    }
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$000();
  }
  
  public DescriptorProtos.FileDescriptorSet getDefaultInstanceForType()
  {
    return DescriptorProtos.FileDescriptorSet.getDefaultInstance();
  }
  
  public DescriptorProtos.FileDescriptorSet build()
  {
    DescriptorProtos.FileDescriptorSet result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.FileDescriptorSet buildPartial()
  {
    DescriptorProtos.FileDescriptorSet result = new DescriptorProtos.FileDescriptorSet(this, null);
    int from_bitField0_ = bitField0_;
    if (fileBuilder_ == null)
    {
      if ((bitField0_ & 0x1) == 1)
      {
        file_ = Collections.unmodifiableList(file_);
        bitField0_ &= 0xFFFFFFFE;
      }
      DescriptorProtos.FileDescriptorSet.access$602(result, file_);
    }
    else
    {
      DescriptorProtos.FileDescriptorSet.access$602(result, fileBuilder_.build());
    }
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.FileDescriptorSet)) {
      return mergeFrom((DescriptorProtos.FileDescriptorSet)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.FileDescriptorSet other)
  {
    if (other == DescriptorProtos.FileDescriptorSet.getDefaultInstance()) {
      return this;
    }
    if (fileBuilder_ == null)
    {
      if (!DescriptorProtos.FileDescriptorSet.access$600(other).isEmpty())
      {
        if (file_.isEmpty())
        {
          file_ = DescriptorProtos.FileDescriptorSet.access$600(other);
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          ensureFileIsMutable();
          file_.addAll(DescriptorProtos.FileDescriptorSet.access$600(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.FileDescriptorSet.access$600(other).isEmpty()) {
      if (fileBuilder_.isEmpty())
      {
        fileBuilder_.dispose();
        fileBuilder_ = null;
        file_ = DescriptorProtos.FileDescriptorSet.access$600(other);
        bitField0_ &= 0xFFFFFFFE;
        fileBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getFileFieldBuilder() : null);
      }
      else
      {
        fileBuilder_.addAllMessages(DescriptorProtos.FileDescriptorSet.access$600(other));
      }
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    for (int i = 0; i < getFileCount(); i++) {
      if (!getFile(i).isInitialized()) {
        return false;
      }
    }
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.FileDescriptorSet parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.FileDescriptorSet)DescriptorProtos.FileDescriptorSet.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.FileDescriptorSet)e.getUnfinishedMessage();
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
  
  private List<DescriptorProtos.FileDescriptorProto> file_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> fileBuilder_;
  
  private void ensureFileIsMutable()
  {
    if ((bitField0_ & 0x1) != 1)
    {
      file_ = new ArrayList(file_);
      bitField0_ |= 0x1;
    }
  }
  
  public List<DescriptorProtos.FileDescriptorProto> getFileList()
  {
    if (fileBuilder_ == null) {
      return Collections.unmodifiableList(file_);
    }
    return fileBuilder_.getMessageList();
  }
  
  public int getFileCount()
  {
    if (fileBuilder_ == null) {
      return file_.size();
    }
    return fileBuilder_.getCount();
  }
  
  public DescriptorProtos.FileDescriptorProto getFile(int index)
  {
    if (fileBuilder_ == null) {
      return (DescriptorProtos.FileDescriptorProto)file_.get(index);
    }
    return (DescriptorProtos.FileDescriptorProto)fileBuilder_.getMessage(index);
  }
  
  public Builder setFile(int index, DescriptorProtos.FileDescriptorProto value)
  {
    if (fileBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      file_.set(index, value);
      onChanged();
    }
    else
    {
      fileBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue)
  {
    if (fileBuilder_ == null)
    {
      ensureFileIsMutable();
      file_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      fileBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addFile(DescriptorProtos.FileDescriptorProto value)
  {
    if (fileBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      file_.add(value);
      onChanged();
    }
    else
    {
      fileBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addFile(int index, DescriptorProtos.FileDescriptorProto value)
  {
    if (fileBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFileIsMutable();
      file_.add(index, value);
      onChanged();
    }
    else
    {
      fileBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addFile(DescriptorProtos.FileDescriptorProto.Builder builderForValue)
  {
    if (fileBuilder_ == null)
    {
      ensureFileIsMutable();
      file_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      fileBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addFile(int index, DescriptorProtos.FileDescriptorProto.Builder builderForValue)
  {
    if (fileBuilder_ == null)
    {
      ensureFileIsMutable();
      file_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      fileBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> values)
  {
    if (fileBuilder_ == null)
    {
      ensureFileIsMutable();
      GeneratedMessage.Builder.addAll(values, file_);
      onChanged();
    }
    else
    {
      fileBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearFile()
  {
    if (fileBuilder_ == null)
    {
      file_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
      onChanged();
    }
    else
    {
      fileBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeFile(int index)
  {
    if (fileBuilder_ == null)
    {
      ensureFileIsMutable();
      file_.remove(index);
      onChanged();
    }
    else
    {
      fileBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.FileDescriptorProto.Builder getFileBuilder(int index)
  {
    return (DescriptorProtos.FileDescriptorProto.Builder)getFileFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.FileDescriptorProtoOrBuilder getFileOrBuilder(int index)
  {
    if (fileBuilder_ == null) {
      return (DescriptorProtos.FileDescriptorProtoOrBuilder)file_.get(index);
    }
    return (DescriptorProtos.FileDescriptorProtoOrBuilder)fileBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getFileOrBuilderList()
  {
    if (fileBuilder_ != null) {
      return fileBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(file_);
  }
  
  public DescriptorProtos.FileDescriptorProto.Builder addFileBuilder()
  {
    return (DescriptorProtos.FileDescriptorProto.Builder)getFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
  }
  
  public DescriptorProtos.FileDescriptorProto.Builder addFileBuilder(int index)
  {
    return (DescriptorProtos.FileDescriptorProto.Builder)getFileFieldBuilder().addBuilder(index, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
  }
  
  public List<DescriptorProtos.FileDescriptorProto.Builder> getFileBuilderList()
  {
    return getFileFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getFileFieldBuilder()
  {
    if (fileBuilder_ == null)
    {
      fileBuilder_ = new RepeatedFieldBuilder(file_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
      
      file_ = null;
    }
    return fileBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileDescriptorSet.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */