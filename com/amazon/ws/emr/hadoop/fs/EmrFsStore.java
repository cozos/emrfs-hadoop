package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ByteString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.Descriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FileDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistryLite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.BuilderParent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Internal.EnumLiteMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.InvalidProtocolBufferException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.MessageOrBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Parser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ProtocolMessageEnum;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.List;

public final class EmrFsStore
{
  private static Descriptors.Descriptor internal_static_MetadataFile_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_MetadataFile_fieldAccessorTable;
  private static Descriptors.FileDescriptor descriptor;
  public static void registerAllExtensions(ExtensionRegistry registry) {}
  
  public static final class MetadataFile
    extends GeneratedMessage
    implements EmrFsStore.MetadataFileOrBuilder
  {
    private static final MetadataFile defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private MetadataFile(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private MetadataFile(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static MetadataFile getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public MetadataFile getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private MetadataFile(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      initFields();
      int mutable_bitField0_ = 0;
      
      UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
      try
      {
        boolean done = false;
        while (!done)
        {
          int tag = input.readTag();
          switch (tag)
          {
          case 0: 
            done = true;
            break;
          default: 
            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          case 8: 
            bitField0_ |= 0x1;
            version_ = input.readInt32();
            break;
          case 16: 
            int rawValue = input.readEnum();
            State value = State.valueOf(rawValue);
            if (value == null)
            {
              unknownFields.mergeVarintField(2, rawValue);
            }
            else
            {
              bitField0_ |= 0x2;
              state_ = value;
            }
            break;
          case 24: 
            bitField0_ |= 0x4;
            isDirectory_ = input.readBool();
          }
        }
      }
      catch (InvalidProtocolBufferException e)
      {
        throw e.setUnfinishedMessage(this);
      }
      catch (IOException e)
      {
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
      }
      finally
      {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return EmrFsStore.internal_static_MetadataFile_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return 
        EmrFsStore.internal_static_MetadataFile_fieldAccessorTable.ensureFieldAccessorsInitialized(MetadataFile.class, Builder.class);
    }
    
    public static Parser<MetadataFile> PARSER = new AbstractParser()
    {
      public EmrFsStore.MetadataFile parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new EmrFsStore.MetadataFile(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int version_;
    public static final int STATE_FIELD_NUMBER = 2;
    private State state_;
    public static final int ISDIRECTORY_FIELD_NUMBER = 3;
    private boolean isDirectory_;
    
    public Parser<MetadataFile> getParserForType()
    {
      return PARSER;
    }
    
    public static enum State
      implements ProtocolMessageEnum
    {
      DISCOVERED(0, 0),  PUT(1, 1),  DELETED(2, 2);
      
      public static final int DISCOVERED_VALUE = 0;
      public static final int PUT_VALUE = 1;
      public static final int DELETED_VALUE = 2;
      
      public final int getNumber()
      {
        return value;
      }
      
      public static State valueOf(int value)
      {
        switch (value)
        {
        case 0: 
          return DISCOVERED;
        case 1: 
          return PUT;
        case 2: 
          return DELETED;
        }
        return null;
      }
      
      public static Internal.EnumLiteMap<State> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      private static Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap()
      {
        public EmrFsStore.MetadataFile.State findValueByNumber(int number)
        {
          return EmrFsStore.MetadataFile.State.valueOf(number);
        }
      };
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(index);
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)EmrFsStore.MetadataFile.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final State[] VALUES = values();
      private final int index;
      private final int value;
      
      public static State valueOf(Descriptors.EnumValueDescriptor desc)
      {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private State(int index, int value)
      {
        this.index = index;
        this.value = value;
      }
    }
    
    public boolean hasVersion()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public int getVersion()
    {
      return version_;
    }
    
    public boolean hasState()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public State getState()
    {
      return state_;
    }
    
    public boolean hasIsDirectory()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public boolean getIsDirectory()
    {
      return isDirectory_;
    }
    
    private void initFields()
    {
      version_ = 0;
      state_ = State.DISCOVERED;
      isDirectory_ = false;
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      if (!hasVersion())
      {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(CodedOutputStream output)
      throws IOException
    {
      getSerializedSize();
      if ((bitField0_ & 0x1) == 1) {
        output.writeInt32(1, version_);
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeEnum(2, state_.getNumber());
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeBool(3, isDirectory_);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0L;
    
    public int getSerializedSize()
    {
      int size = memoizedSerializedSize;
      if (size != -1) {
        return size;
      }
      size = 0;
      if ((bitField0_ & 0x1) == 1) {
        size = size + CodedOutputStream.computeInt32Size(1, version_);
      }
      if ((bitField0_ & 0x2) == 2) {
        size = size + CodedOutputStream.computeEnumSize(2, state_.getNumber());
      }
      if ((bitField0_ & 0x4) == 4) {
        size = size + CodedOutputStream.computeBoolSize(3, isDirectory_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static MetadataFile parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (MetadataFile)PARSER.parseFrom(data);
    }
    
    public static MetadataFile parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MetadataFile)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MetadataFile parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (MetadataFile)PARSER.parseFrom(data);
    }
    
    public static MetadataFile parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MetadataFile)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MetadataFile parseFrom(InputStream input)
      throws IOException
    {
      return (MetadataFile)PARSER.parseFrom(input);
    }
    
    public static MetadataFile parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MetadataFile)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static MetadataFile parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (MetadataFile)PARSER.parseDelimitedFrom(input);
    }
    
    public static MetadataFile parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MetadataFile)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static MetadataFile parseFrom(CodedInputStream input)
      throws IOException
    {
      return (MetadataFile)PARSER.parseFrom(input);
    }
    
    public static MetadataFile parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MetadataFile)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(MetadataFile prototype)
    {
      return newBuilder().mergeFrom(prototype);
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent)
    {
      Builder builder = new Builder(parent, null);
      return builder;
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
      implements EmrFsStore.MetadataFileOrBuilder
    {
      private int bitField0_;
      private int version_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return EmrFsStore.internal_static_MetadataFile_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return 
          EmrFsStore.internal_static_MetadataFile_fieldAccessorTable.ensureFieldAccessorsInitialized(EmrFsStore.MetadataFile.class, Builder.class);
      }
      
      private Builder()
      {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessage.BuilderParent parent)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (EmrFsStore.MetadataFile.alwaysUseFieldBuilders) {}
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
        return EmrFsStore.internal_static_MetadataFile_descriptor;
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
        version_ = version_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        state_ = state_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        isDirectory_ = isDirectory_;
        bitField0_ = to_bitField0_;
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
    
    static
    {
      defaultInstance = new MetadataFile(true);
      defaultInstance.initFields();
    }
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  static
  {
    String[] descriptorData = { "\n\020EmrFsStore.proto\"\001\n\fMetadataFile\022\017\n\007version\030\001 \002(\005\022\"\n\005state\030\002 \001(\0162\023.MetadataFile.State\022\023\n\013isDirectory\030\003 \001(\b\"-\n\005State\022\016\n\nDISCOVERED\020\000\022\007\n\003PUT\020\001\022\013\n\007DELETED\020\002B&\n\033com.amazon.ws.emr.hadoop.fs\001\000\001\000\001\000" };
    
    Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
      {
        EmrFsStore.access$1102(root);
        EmrFsStore.access$002(
          (Descriptors.Descriptor)EmrFsStore.getDescriptor().getMessageTypes().get(0));
        EmrFsStore.access$102(new GeneratedMessage.FieldAccessorTable(
        
          EmrFsStore.internal_static_MetadataFile_descriptor, new String[] { "Version", "State", "IsDirectory" }));
        
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
  }
  
  public static abstract interface MetadataFileOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasVersion();
    
    public abstract int getVersion();
    
    public abstract boolean hasState();
    
    public abstract EmrFsStore.MetadataFile.State getState();
    
    public abstract boolean hasIsDirectory();
    
    public abstract boolean getIsDirectory();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */