package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Builder
  extends GeneratedMessage.Builder<Builder>
  implements DescriptorProtos.SourceCodeInfoOrBuilder
{
  private int bitField0_;
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$19800();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$19900().ensureFieldAccessorsInitialized(DescriptorProtos.SourceCodeInfo.class, Builder.class);
  }
  
  private DescriptorProtos$SourceCodeInfo$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessage.BuilderParent parent)
  {
    super(parent);
    maybeForceBuilderInitialization();
  }
  
  private void maybeForceBuilderInitialization()
  {
    if (GeneratedMessage.alwaysUseFieldBuilders) {
      getLocationFieldBuilder();
    }
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  public Builder clear()
  {
    super.clear();
    if (locationBuilder_ == null)
    {
      location_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
    }
    else
    {
      locationBuilder_.clear();
    }
    return this;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return DescriptorProtos.access$19800();
  }
  
  public DescriptorProtos.SourceCodeInfo getDefaultInstanceForType()
  {
    return DescriptorProtos.SourceCodeInfo.getDefaultInstance();
  }
  
  public DescriptorProtos.SourceCodeInfo build()
  {
    DescriptorProtos.SourceCodeInfo result = buildPartial();
    if (!result.isInitialized()) {
      throw newUninitializedMessageException(result);
    }
    return result;
  }
  
  public DescriptorProtos.SourceCodeInfo buildPartial()
  {
    DescriptorProtos.SourceCodeInfo result = new DescriptorProtos.SourceCodeInfo(this, null);
    int from_bitField0_ = bitField0_;
    if (locationBuilder_ == null)
    {
      if ((bitField0_ & 0x1) == 1)
      {
        location_ = Collections.unmodifiableList(location_);
        bitField0_ &= 0xFFFFFFFE;
      }
      DescriptorProtos.SourceCodeInfo.access$21502(result, location_);
    }
    else
    {
      DescriptorProtos.SourceCodeInfo.access$21502(result, locationBuilder_.build());
    }
    onBuilt();
    return result;
  }
  
  public Builder mergeFrom(Message other)
  {
    if ((other instanceof DescriptorProtos.SourceCodeInfo)) {
      return mergeFrom((DescriptorProtos.SourceCodeInfo)other);
    }
    super.mergeFrom(other);
    return this;
  }
  
  public Builder mergeFrom(DescriptorProtos.SourceCodeInfo other)
  {
    if (other == DescriptorProtos.SourceCodeInfo.getDefaultInstance()) {
      return this;
    }
    if (locationBuilder_ == null)
    {
      if (!DescriptorProtos.SourceCodeInfo.access$21500(other).isEmpty())
      {
        if (location_.isEmpty())
        {
          location_ = DescriptorProtos.SourceCodeInfo.access$21500(other);
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          ensureLocationIsMutable();
          location_.addAll(DescriptorProtos.SourceCodeInfo.access$21500(other));
        }
        onChanged();
      }
    }
    else if (!DescriptorProtos.SourceCodeInfo.access$21500(other).isEmpty()) {
      if (locationBuilder_.isEmpty())
      {
        locationBuilder_.dispose();
        locationBuilder_ = null;
        location_ = DescriptorProtos.SourceCodeInfo.access$21500(other);
        bitField0_ &= 0xFFFFFFFE;
        locationBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getLocationFieldBuilder() : null);
      }
      else
      {
        locationBuilder_.addAllMessages(DescriptorProtos.SourceCodeInfo.access$21500(other));
      }
    }
    mergeUnknownFields(other.getUnknownFields());
    return this;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    DescriptorProtos.SourceCodeInfo parsedMessage = null;
    try
    {
      parsedMessage = (DescriptorProtos.SourceCodeInfo)DescriptorProtos.SourceCodeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
    }
    catch (InvalidProtocolBufferException e)
    {
      parsedMessage = (DescriptorProtos.SourceCodeInfo)e.getUnfinishedMessage();
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
  
  private List<DescriptorProtos.SourceCodeInfo.Location> location_ = Collections.emptyList();
  private RepeatedFieldBuilder<DescriptorProtos.SourceCodeInfo.Location, DescriptorProtos.SourceCodeInfo.Location.Builder, DescriptorProtos.SourceCodeInfo.LocationOrBuilder> locationBuilder_;
  
  private void ensureLocationIsMutable()
  {
    if ((bitField0_ & 0x1) != 1)
    {
      location_ = new ArrayList(location_);
      bitField0_ |= 0x1;
    }
  }
  
  public List<DescriptorProtos.SourceCodeInfo.Location> getLocationList()
  {
    if (locationBuilder_ == null) {
      return Collections.unmodifiableList(location_);
    }
    return locationBuilder_.getMessageList();
  }
  
  public int getLocationCount()
  {
    if (locationBuilder_ == null) {
      return location_.size();
    }
    return locationBuilder_.getCount();
  }
  
  public DescriptorProtos.SourceCodeInfo.Location getLocation(int index)
  {
    if (locationBuilder_ == null) {
      return (DescriptorProtos.SourceCodeInfo.Location)location_.get(index);
    }
    return (DescriptorProtos.SourceCodeInfo.Location)locationBuilder_.getMessage(index);
  }
  
  public Builder setLocation(int index, DescriptorProtos.SourceCodeInfo.Location value)
  {
    if (locationBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureLocationIsMutable();
      location_.set(index, value);
      onChanged();
    }
    else
    {
      locationBuilder_.setMessage(index, value);
    }
    return this;
  }
  
  public Builder setLocation(int index, DescriptorProtos.SourceCodeInfo.Location.Builder builderForValue)
  {
    if (locationBuilder_ == null)
    {
      ensureLocationIsMutable();
      location_.set(index, builderForValue.build());
      onChanged();
    }
    else
    {
      locationBuilder_.setMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addLocation(DescriptorProtos.SourceCodeInfo.Location value)
  {
    if (locationBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureLocationIsMutable();
      location_.add(value);
      onChanged();
    }
    else
    {
      locationBuilder_.addMessage(value);
    }
    return this;
  }
  
  public Builder addLocation(int index, DescriptorProtos.SourceCodeInfo.Location value)
  {
    if (locationBuilder_ == null)
    {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureLocationIsMutable();
      location_.add(index, value);
      onChanged();
    }
    else
    {
      locationBuilder_.addMessage(index, value);
    }
    return this;
  }
  
  public Builder addLocation(DescriptorProtos.SourceCodeInfo.Location.Builder builderForValue)
  {
    if (locationBuilder_ == null)
    {
      ensureLocationIsMutable();
      location_.add(builderForValue.build());
      onChanged();
    }
    else
    {
      locationBuilder_.addMessage(builderForValue.build());
    }
    return this;
  }
  
  public Builder addLocation(int index, DescriptorProtos.SourceCodeInfo.Location.Builder builderForValue)
  {
    if (locationBuilder_ == null)
    {
      ensureLocationIsMutable();
      location_.add(index, builderForValue.build());
      onChanged();
    }
    else
    {
      locationBuilder_.addMessage(index, builderForValue.build());
    }
    return this;
  }
  
  public Builder addAllLocation(Iterable<? extends DescriptorProtos.SourceCodeInfo.Location> values)
  {
    if (locationBuilder_ == null)
    {
      ensureLocationIsMutable();
      GeneratedMessage.Builder.addAll(values, location_);
      onChanged();
    }
    else
    {
      locationBuilder_.addAllMessages(values);
    }
    return this;
  }
  
  public Builder clearLocation()
  {
    if (locationBuilder_ == null)
    {
      location_ = Collections.emptyList();
      bitField0_ &= 0xFFFFFFFE;
      onChanged();
    }
    else
    {
      locationBuilder_.clear();
    }
    return this;
  }
  
  public Builder removeLocation(int index)
  {
    if (locationBuilder_ == null)
    {
      ensureLocationIsMutable();
      location_.remove(index);
      onChanged();
    }
    else
    {
      locationBuilder_.remove(index);
    }
    return this;
  }
  
  public DescriptorProtos.SourceCodeInfo.Location.Builder getLocationBuilder(int index)
  {
    return (DescriptorProtos.SourceCodeInfo.Location.Builder)getLocationFieldBuilder().getBuilder(index);
  }
  
  public DescriptorProtos.SourceCodeInfo.LocationOrBuilder getLocationOrBuilder(int index)
  {
    if (locationBuilder_ == null) {
      return (DescriptorProtos.SourceCodeInfo.LocationOrBuilder)location_.get(index);
    }
    return (DescriptorProtos.SourceCodeInfo.LocationOrBuilder)locationBuilder_.getMessageOrBuilder(index);
  }
  
  public List<? extends DescriptorProtos.SourceCodeInfo.LocationOrBuilder> getLocationOrBuilderList()
  {
    if (locationBuilder_ != null) {
      return locationBuilder_.getMessageOrBuilderList();
    }
    return Collections.unmodifiableList(location_);
  }
  
  public DescriptorProtos.SourceCodeInfo.Location.Builder addLocationBuilder()
  {
    return (DescriptorProtos.SourceCodeInfo.Location.Builder)getLocationFieldBuilder().addBuilder(DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance());
  }
  
  public DescriptorProtos.SourceCodeInfo.Location.Builder addLocationBuilder(int index)
  {
    return (DescriptorProtos.SourceCodeInfo.Location.Builder)getLocationFieldBuilder().addBuilder(index, DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance());
  }
  
  public List<DescriptorProtos.SourceCodeInfo.Location.Builder> getLocationBuilderList()
  {
    return getLocationFieldBuilder().getBuilderList();
  }
  
  private RepeatedFieldBuilder<DescriptorProtos.SourceCodeInfo.Location, DescriptorProtos.SourceCodeInfo.Location.Builder, DescriptorProtos.SourceCodeInfo.LocationOrBuilder> getLocationFieldBuilder()
  {
    if (locationBuilder_ == null)
    {
      locationBuilder_ = new RepeatedFieldBuilder(location_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
      
      location_ = null;
    }
    return locationBuilder_;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.SourceCodeInfo.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */