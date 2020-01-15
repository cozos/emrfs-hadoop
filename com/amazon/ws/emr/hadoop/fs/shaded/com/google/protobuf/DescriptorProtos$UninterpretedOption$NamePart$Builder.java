package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;

public final class DescriptorProtos$UninterpretedOption$NamePart$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$17800();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$17900().ensureFieldAccessorsInitialized(DescriptorProtos.UninterpretedOption.NamePart.class, Builder.class);
  }
  
  private DescriptorProtos$UninterpretedOption$NamePart$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$UninterpretedOption$NamePart$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders) {}
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    namePart_ = "";
    bitField0_ &= 0xFFFFFFFE;
    isExtension_ = false;
    bitField0_ &= 0xFFFFFFFD;
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$17800();
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart getDefaultInstanceForType()
  {
    return DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance();
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart build()
  {
    DescriptorProtos.UninterpretedOption.NamePart result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.UninterpretedOption.NamePart buildPartial()
  {
    DescriptorProtos.UninterpretedOption.NamePart result = new DescriptorProtos.UninterpretedOption.NamePart(this, null);
    int from_bitField0_ = bitField0_;
    int to_bitField0_ = 0;
    if ((from_bitField0_ & 0x1) == 1) {
      to_bitField0_ |= 0x1;
    }
    DescriptorProtos.UninterpretedOption.NamePart.access$18402(result, namePart_);
    if ((from_bitField0_ & 0x2) == 2) {
      to_bitField0_ |= 0x2;
    }
    DescriptorProtos.UninterpretedOption.NamePart.access$18502(result, isExtension_);
    DescriptorProtos.UninterpretedOption.NamePart.access$18602(result, to_bitField0_);
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.UninterpretedOption.NamePart)) {
      return mergeFrom((DescriptorProtos.UninterpretedOption.NamePart)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.UninterpretedOption.NamePart other)
  {
    if (other == DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance()) {
      return this;
    }
    if (other.hasNamePart())
    {
      bitField0_ |= 0x1;
      namePart_ = DescriptorProtos.UninterpretedOption.NamePart.access$18400(other);
      onChanged();
    }
    if (other.hasIsExtension()) {
      setIsExtension(other.getIsExtension());
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    if (!hasNamePart()) {
      return false;
    }
    if (!hasIsExtension()) {
      return false;
    }
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.UninterpretedOption.NamePart parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.UninterpretedOption.NamePart)DescriptorProtos.UninterpretedOption.NamePart.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.UninterpretedOption.NamePart)e.getUnfinishedMessage();
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
  
  private Object namePart_ = "";
  private boolean isExtension_;
  
  public boolean hasNamePart()
  {
    return (bitField0_ & 0x1) == 1;
  }
  
  public String getNamePart()
  {
    Object ref = namePart_;
    if (!(ref instanceof String))
    {
      String s = ((ByteString)ref).toStringUtf8();
      
      namePart_ = s;
      return s;
    }
    return (String)ref;
  }
  
  public ByteString getNamePartBytes()
  {
    Object ref = namePart_;
    if ((ref instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)ref);
      
      namePart_ = b;
      return b;
    }
    return (ByteString)ref;
  }
  
  public Builder setNamePart(String value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    namePart_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearNamePart()
  {
    bitField0_ &= 0xFFFFFFFE;
    namePart_ = DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance().getNamePart();
    onChanged();
    return this;
  }
  
  public Builder setNamePartBytes(ByteString value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    bitField0_ |= 0x1;
    namePart_ = value;
    onChanged();
    return this;
  }
  
  public boolean hasIsExtension()
  {
    return (bitField0_ & 0x2) == 2;
  }
  
  public boolean getIsExtension()
  {
    return isExtension_;
  }
  
  public Builder setIsExtension(boolean value)
  {
    bitField0_ |= 0x2;
    isExtension_ = value;
    onChanged();
    return this;
  }
  
  public Builder clearIsExtension()
  {
    bitField0_ &= 0xFFFFFFFD;
    isExtension_ = false;
    onChanged();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePart.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */