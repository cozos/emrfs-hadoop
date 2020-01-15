package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorSet
  extends GeneratedMessage
  implements DescriptorProtos.FileDescriptorSetOrBuilder
{
  private static final FileDescriptorSet defaultInstance;
  private final UnknownFieldSet unknownFields;
  
  private DescriptorProtos$FileDescriptorSet(GeneratedMessage.Builder<?> builder)
  {
    super(builder);
    unknownFields = builder.getUnknownFields();
  }
  
  private DescriptorProtos$FileDescriptorSet(boolean noInit)
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
  }
  
  public static FileDescriptorSet getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public FileDescriptorSet getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  /* Error */
  private DescriptorProtos$FileDescriptorSet(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 91	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/GeneratedMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 75	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 77	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 108	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:initFields	()V
    //   18: iconst_0
    //   19: istore_3
    //   20: invokestatic 112	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet:newBuilder	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet$Builder;
    //   23: astore 4
    //   25: iconst_0
    //   26: istore 5
    //   28: iload 5
    //   30: ifne +106 -> 136
    //   33: aload_1
    //   34: invokevirtual 118	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/CodedInputStream:readTag	()I
    //   37: istore 6
    //   39: iload 6
    //   41: lookupswitch	default:+33->74, 0:+27->68, 10:+52->93
    //   68: iconst_1
    //   69: istore 5
    //   71: goto +62 -> 133
    //   74: aload_0
    //   75: aload_1
    //   76: aload 4
    //   78: aload_2
    //   79: iload 6
    //   81: invokevirtual 122	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:parseUnknownField	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/CodedInputStream;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet$Builder;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/ExtensionRegistryLite;I)Z
    //   84: ifne +49 -> 133
    //   87: iconst_1
    //   88: istore 5
    //   90: goto +43 -> 133
    //   93: iload_3
    //   94: iconst_1
    //   95: iand
    //   96: iconst_1
    //   97: if_icmpeq +18 -> 115
    //   100: aload_0
    //   101: new 124	java/util/ArrayList
    //   104: dup
    //   105: invokespecial 125	java/util/ArrayList:<init>	()V
    //   108: putfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   111: iload_3
    //   112: iconst_1
    //   113: ior
    //   114: istore_3
    //   115: aload_0
    //   116: getfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   119: aload_1
    //   120: getstatic 129	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorProto:PARSER	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/Parser;
    //   123: aload_2
    //   124: invokevirtual 133	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/CodedInputStream:readMessage	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/Parser;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/MessageLite;
    //   127: invokeinterface 139 2 0
    //   132: pop
    //   133: goto -105 -> 28
    //   136: iload_3
    //   137: iconst_1
    //   138: iand
    //   139: iconst_1
    //   140: if_icmpne +14 -> 154
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   148: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   151: putfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   154: aload_0
    //   155: aload 4
    //   157: invokevirtual 148	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet$Builder:build	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet;
    //   160: putfield 83	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:unknownFields	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet;
    //   163: aload_0
    //   164: invokevirtual 151	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:makeExtensionsImmutable	()V
    //   167: goto +67 -> 234
    //   170: astore 5
    //   172: aload 5
    //   174: aload_0
    //   175: invokevirtual 155	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/MessageLite;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException;
    //   178: athrow
    //   179: astore 5
    //   181: new 103	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException
    //   184: dup
    //   185: aload 5
    //   187: invokevirtual 159	java/io/IOException:getMessage	()Ljava/lang/String;
    //   190: invokespecial 162	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: invokevirtual 155	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/MessageLite;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException;
    //   197: athrow
    //   198: astore 7
    //   200: iload_3
    //   201: iconst_1
    //   202: iand
    //   203: iconst_1
    //   204: if_icmpne +14 -> 218
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   212: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   215: putfield 127	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:file_	Ljava/util/List;
    //   218: aload_0
    //   219: aload 4
    //   221: invokevirtual 148	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet$Builder:build	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet;
    //   224: putfield 83	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:unknownFields	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/UnknownFieldSet;
    //   227: aload_0
    //   228: invokevirtual 151	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/DescriptorProtos$FileDescriptorSet:makeExtensionsImmutable	()V
    //   231: aload 7
    //   233: athrow
    //   234: return
    // Line number table:
    //   Java source line #75	-> byte code offset #0
    //   Java source line #184	-> byte code offset #4
    //   Java source line #208	-> byte code offset #9
    //   Java source line #76	-> byte code offset #14
    //   Java source line #77	-> byte code offset #18
    //   Java source line #78	-> byte code offset #20
    //   Java source line #81	-> byte code offset #25
    //   Java source line #82	-> byte code offset #28
    //   Java source line #83	-> byte code offset #33
    //   Java source line #84	-> byte code offset #39
    //   Java source line #86	-> byte code offset #68
    //   Java source line #87	-> byte code offset #71
    //   Java source line #89	-> byte code offset #74
    //   Java source line #91	-> byte code offset #87
    //   Java source line #96	-> byte code offset #93
    //   Java source line #97	-> byte code offset #100
    //   Java source line #98	-> byte code offset #111
    //   Java source line #100	-> byte code offset #115
    //   Java source line #104	-> byte code offset #133
    //   Java source line #111	-> byte code offset #136
    //   Java source line #112	-> byte code offset #143
    //   Java source line #114	-> byte code offset #154
    //   Java source line #115	-> byte code offset #163
    //   Java source line #116	-> byte code offset #167
    //   Java source line #105	-> byte code offset #170
    //   Java source line #106	-> byte code offset #172
    //   Java source line #107	-> byte code offset #179
    //   Java source line #108	-> byte code offset #181
    //   Java source line #111	-> byte code offset #198
    //   Java source line #112	-> byte code offset #207
    //   Java source line #114	-> byte code offset #218
    //   Java source line #115	-> byte code offset #227
    //   Java source line #117	-> byte code offset #234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	FileDescriptorSet
    //   0	235	1	input	CodedInputStream
    //   0	235	2	extensionRegistry	ExtensionRegistryLite
    //   19	182	3	mutable_bitField0_	int
    //   23	197	4	unknownFields	UnknownFieldSet.Builder
    //   26	63	5	done	boolean
    //   170	3	5	e	InvalidProtocolBufferException
    //   179	7	5	e	IOException
    //   37	43	6	tag	int
    //   198	34	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	136	170	com/amazon/ws/emr/hadoop/fs/shaded/com/google/protobuf/InvalidProtocolBufferException
    //   25	136	179	java/io/IOException
    //   25	136	198	finally
    //   170	200	198	finally
  }
  
  public static final Descriptors.Descriptor getDescriptor()
  {
    return DescriptorProtos.access$000();
  }
  
  protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
  {
    return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(FileDescriptorSet.class, Builder.class);
  }
  
  public static Parser<FileDescriptorSet> PARSER = new AbstractParser()
  {
    public DescriptorProtos.FileDescriptorSet parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return new DescriptorProtos.FileDescriptorSet(input, extensionRegistry, null);
    }
  };
  public static final int FILE_FIELD_NUMBER = 1;
  private List<DescriptorProtos.FileDescriptorProto> file_;
  
  public Parser<FileDescriptorSet> getParserForType()
  {
    return PARSER;
  }
  
  public List<DescriptorProtos.FileDescriptorProto> getFileList()
  {
    return file_;
  }
  
  public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getFileOrBuilderList()
  {
    return file_;
  }
  
  public int getFileCount()
  {
    return file_.size();
  }
  
  public DescriptorProtos.FileDescriptorProto getFile(int index)
  {
    return (DescriptorProtos.FileDescriptorProto)file_.get(index);
  }
  
  public DescriptorProtos.FileDescriptorProtoOrBuilder getFileOrBuilder(int index)
  {
    return (DescriptorProtos.FileDescriptorProtoOrBuilder)file_.get(index);
  }
  
  private void initFields()
  {
    file_ = Collections.emptyList();
  }
  
  private byte memoizedIsInitialized = -1;
  
  public final boolean isInitialized()
  {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) {
      return isInitialized == 1;
    }
    for (int i = 0; i < getFileCount(); i++) {
      if (!getFile(i).isInitialized())
      {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    getSerializedSize();
    for (int i = 0; i < file_.size(); i++) {
      output.writeMessage(1, (MessageLite)file_.get(i));
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
    for (int i = 0; i < file_.size(); i++) {
      size += CodedOutputStream.computeMessageSize(1, (MessageLite)file_.get(i));
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
  
  public static FileDescriptorSet parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorSet)PARSER.parseFrom(data);
  }
  
  public static FileDescriptorSet parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorSet)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileDescriptorSet parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorSet)PARSER.parseFrom(data);
  }
  
  public static FileDescriptorSet parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return (FileDescriptorSet)PARSER.parseFrom(data, extensionRegistry);
  }
  
  public static FileDescriptorSet parseFrom(InputStream input)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseFrom(input);
  }
  
  public static FileDescriptorSet parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static FileDescriptorSet parseDelimitedFrom(InputStream input)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseDelimitedFrom(input);
  }
  
  public static FileDescriptorSet parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  
  public static FileDescriptorSet parseFrom(CodedInputStream input)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseFrom(input);
  }
  
  public static FileDescriptorSet parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return (FileDescriptorSet)PARSER.parseFrom(input, extensionRegistry);
  }
  
  public static Builder newBuilder()
  {
    return Builder.access$300();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public static Builder newBuilder(FileDescriptorSet prototype)
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
        file_ = file_;
      }
      else
      {
        file_ = fileBuilder_.build();
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
        if (!file_.isEmpty())
        {
          if (file_.isEmpty())
          {
            file_ = file_;
            bitField0_ &= 0xFFFFFFFE;
          }
          else
          {
            ensureFileIsMutable();
            file_.addAll(file_);
          }
          onChanged();
        }
      }
      else if (!file_.isEmpty()) {
        if (fileBuilder_.isEmpty())
        {
          fileBuilder_.dispose();
          fileBuilder_ = null;
          file_ = file_;
          bitField0_ &= 0xFFFFFFFE;
          fileBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getFileFieldBuilder() : null);
        }
        else
        {
          fileBuilder_.addAllMessages(file_);
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
  
  static
  {
    defaultInstance = new FileDescriptorSet(true);
    defaultInstance.initFields();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileDescriptorSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */