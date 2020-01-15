package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos
{
  private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FileOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MessageOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_SourceCodeInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable;
  private static Descriptors.FileDescriptor descriptor;
  public static void registerAllExtensions(ExtensionRegistry registry) {}
  
  public static abstract interface FileDescriptorSetOrBuilder
    extends MessageOrBuilder
  {
    public abstract List<DescriptorProtos.FileDescriptorProto> getFileList();
    
    public abstract DescriptorProtos.FileDescriptorProto getFile(int paramInt);
    
    public abstract int getFileCount();
    
    public abstract List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getFileOrBuilderList();
    
    public abstract DescriptorProtos.FileDescriptorProtoOrBuilder getFileOrBuilder(int paramInt);
  }
  
  public static final class FileDescriptorSet
    extends GeneratedMessage
    implements DescriptorProtos.FileDescriptorSetOrBuilder
  {
    private static final FileDescriptorSet defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private FileDescriptorSet(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private FileDescriptorSet(boolean noInit)
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
    private FileDescriptorSet(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable.ensureFieldAccessorsInitialized(FileDescriptorSet.class, Builder.class);
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
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.FileDescriptorSet.class, Builder.class);
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
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
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
  
  public static abstract interface FileDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract boolean hasPackage();
    
    public abstract String getPackage();
    
    public abstract ByteString getPackageBytes();
    
    public abstract List<String> getDependencyList();
    
    public abstract int getDependencyCount();
    
    public abstract String getDependency(int paramInt);
    
    public abstract ByteString getDependencyBytes(int paramInt);
    
    public abstract List<Integer> getPublicDependencyList();
    
    public abstract int getPublicDependencyCount();
    
    public abstract int getPublicDependency(int paramInt);
    
    public abstract List<Integer> getWeakDependencyList();
    
    public abstract int getWeakDependencyCount();
    
    public abstract int getWeakDependency(int paramInt);
    
    public abstract List<DescriptorProtos.DescriptorProto> getMessageTypeList();
    
    public abstract DescriptorProtos.DescriptorProto getMessageType(int paramInt);
    
    public abstract int getMessageTypeCount();
    
    public abstract List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList();
    
    public abstract DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList();
    
    public abstract DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt);
    
    public abstract int getEnumTypeCount();
    
    public abstract List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();
    
    public abstract DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.ServiceDescriptorProto> getServiceList();
    
    public abstract DescriptorProtos.ServiceDescriptorProto getService(int paramInt);
    
    public abstract int getServiceCount();
    
    public abstract List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList();
    
    public abstract DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.FieldDescriptorProto> getExtensionList();
    
    public abstract DescriptorProtos.FieldDescriptorProto getExtension(int paramInt);
    
    public abstract int getExtensionCount();
    
    public abstract List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();
    
    public abstract DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int paramInt);
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.FileOptions getOptions();
    
    public abstract DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder();
    
    public abstract boolean hasSourceCodeInfo();
    
    public abstract DescriptorProtos.SourceCodeInfo getSourceCodeInfo();
    
    public abstract DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();
  }
  
  public static final class FileDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.FileDescriptorProtoOrBuilder
  {
    private static final FileDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private FileDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private FileDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static FileDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public FileDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private FileDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            bitField0_ |= 0x2;
            package_ = input.readBytes();
            break;
          case 26: 
            if ((mutable_bitField0_ & 0x4) != 4)
            {
              dependency_ = new LazyStringArrayList();
              mutable_bitField0_ |= 0x4;
            }
            dependency_.add(input.readBytes());
            break;
          case 34: 
            if ((mutable_bitField0_ & 0x20) != 32)
            {
              messageType_ = new ArrayList();
              mutable_bitField0_ |= 0x20;
            }
            messageType_.add(input.readMessage(DescriptorProtos.DescriptorProto.PARSER, extensionRegistry));
            break;
          case 42: 
            if ((mutable_bitField0_ & 0x40) != 64)
            {
              enumType_ = new ArrayList();
              mutable_bitField0_ |= 0x40;
            }
            enumType_.add(input.readMessage(DescriptorProtos.EnumDescriptorProto.PARSER, extensionRegistry));
            break;
          case 50: 
            if ((mutable_bitField0_ & 0x80) != 128)
            {
              service_ = new ArrayList();
              mutable_bitField0_ |= 0x80;
            }
            service_.add(input.readMessage(DescriptorProtos.ServiceDescriptorProto.PARSER, extensionRegistry));
            break;
          case 58: 
            if ((mutable_bitField0_ & 0x100) != 256)
            {
              extension_ = new ArrayList();
              mutable_bitField0_ |= 0x100;
            }
            extension_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
            break;
          case 66: 
            DescriptorProtos.FileOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x4) == 4) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.FileOptions)input.readMessage(DescriptorProtos.FileOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x4;
            break;
          case 74: 
            DescriptorProtos.SourceCodeInfo.Builder subBuilder = null;
            if ((bitField0_ & 0x8) == 8) {
              subBuilder = sourceCodeInfo_.toBuilder();
            }
            sourceCodeInfo_ = ((DescriptorProtos.SourceCodeInfo)input.readMessage(DescriptorProtos.SourceCodeInfo.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(sourceCodeInfo_);
              sourceCodeInfo_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x8;
            break;
          case 80: 
            if ((mutable_bitField0_ & 0x8) != 8)
            {
              publicDependency_ = new ArrayList();
              mutable_bitField0_ |= 0x8;
            }
            publicDependency_.add(Integer.valueOf(input.readInt32()));
            break;
          case 82: 
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (((mutable_bitField0_ & 0x8) != 8) && (input.getBytesUntilLimit() > 0))
            {
              publicDependency_ = new ArrayList();
              mutable_bitField0_ |= 0x8;
            }
            while (input.getBytesUntilLimit() > 0) {
              publicDependency_.add(Integer.valueOf(input.readInt32()));
            }
            input.popLimit(limit);
            break;
          case 88: 
            if ((mutable_bitField0_ & 0x10) != 16)
            {
              weakDependency_ = new ArrayList();
              mutable_bitField0_ |= 0x10;
            }
            weakDependency_.add(Integer.valueOf(input.readInt32()));
            break;
          case 90: 
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (((mutable_bitField0_ & 0x10) != 16) && (input.getBytesUntilLimit() > 0))
            {
              weakDependency_ = new ArrayList();
              mutable_bitField0_ |= 0x10;
            }
            while (input.getBytesUntilLimit() > 0) {
              weakDependency_.add(Integer.valueOf(input.readInt32()));
            }
            input.popLimit(limit);
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
        if ((mutable_bitField0_ & 0x4) == 4) {
          dependency_ = new UnmodifiableLazyStringList(dependency_);
        }
        if ((mutable_bitField0_ & 0x20) == 32) {
          messageType_ = Collections.unmodifiableList(messageType_);
        }
        if ((mutable_bitField0_ & 0x40) == 64) {
          enumType_ = Collections.unmodifiableList(enumType_);
        }
        if ((mutable_bitField0_ & 0x80) == 128) {
          service_ = Collections.unmodifiableList(service_);
        }
        if ((mutable_bitField0_ & 0x100) == 256) {
          extension_ = Collections.unmodifiableList(extension_);
        }
        if ((mutable_bitField0_ & 0x8) == 8) {
          publicDependency_ = Collections.unmodifiableList(publicDependency_);
        }
        if ((mutable_bitField0_ & 0x10) == 16) {
          weakDependency_ = Collections.unmodifiableList(weakDependency_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FileDescriptorProto.class, Builder.class);
    }
    
    public static Parser<FileDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.FileDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.FileDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private Object package_;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    private LazyStringList dependency_;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    private List<Integer> publicDependency_;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private List<Integer> weakDependency_;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    private List<DescriptorProtos.DescriptorProto> messageType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    private List<DescriptorProtos.EnumDescriptorProto> enumType_;
    public static final int SERVICE_FIELD_NUMBER = 6;
    private List<DescriptorProtos.ServiceDescriptorProto> service_;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    private List<DescriptorProtos.FieldDescriptorProto> extension_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos.FileOptions options_;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    private DescriptorProtos.SourceCodeInfo sourceCodeInfo_;
    
    public Parser<FileDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasPackage()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public String getPackage()
    {
      Object ref = package_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        package_ = s;
      }
      return s;
    }
    
    public ByteString getPackageBytes()
    {
      Object ref = package_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        package_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public List<String> getDependencyList()
    {
      return dependency_;
    }
    
    public int getDependencyCount()
    {
      return dependency_.size();
    }
    
    public String getDependency(int index)
    {
      return (String)dependency_.get(index);
    }
    
    public ByteString getDependencyBytes(int index)
    {
      return dependency_.getByteString(index);
    }
    
    public List<Integer> getPublicDependencyList()
    {
      return publicDependency_;
    }
    
    public int getPublicDependencyCount()
    {
      return publicDependency_.size();
    }
    
    public int getPublicDependency(int index)
    {
      return ((Integer)publicDependency_.get(index)).intValue();
    }
    
    public List<Integer> getWeakDependencyList()
    {
      return weakDependency_;
    }
    
    public int getWeakDependencyCount()
    {
      return weakDependency_.size();
    }
    
    public int getWeakDependency(int index)
    {
      return ((Integer)weakDependency_.get(index)).intValue();
    }
    
    public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
    {
      return messageType_;
    }
    
    public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList()
    {
      return messageType_;
    }
    
    public int getMessageTypeCount()
    {
      return messageType_.size();
    }
    
    public DescriptorProtos.DescriptorProto getMessageType(int index)
    {
      return (DescriptorProtos.DescriptorProto)messageType_.get(index);
    }
    
    public DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index)
    {
      return (DescriptorProtos.DescriptorProtoOrBuilder)messageType_.get(index);
    }
    
    public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
    {
      return enumType_;
    }
    
    public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
    {
      return enumType_;
    }
    
    public int getEnumTypeCount()
    {
      return enumType_.size();
    }
    
    public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
    {
      return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
    }
    
    public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
    {
      return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
    }
    
    public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
    {
      return service_;
    }
    
    public List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList()
    {
      return service_;
    }
    
    public int getServiceCount()
    {
      return service_.size();
    }
    
    public DescriptorProtos.ServiceDescriptorProto getService(int index)
    {
      return (DescriptorProtos.ServiceDescriptorProto)service_.get(index);
    }
    
    public DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index)
    {
      return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)service_.get(index);
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
    {
      return extension_;
    }
    
    public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
    {
      return extension_;
    }
    
    public int getExtensionCount()
    {
      return extension_.size();
    }
    
    public DescriptorProtos.FieldDescriptorProto getExtension(int index)
    {
      return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
    }
    
    public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
    {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public DescriptorProtos.FileOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    public boolean hasSourceCodeInfo()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public DescriptorProtos.SourceCodeInfo getSourceCodeInfo()
    {
      return sourceCodeInfo_;
    }
    
    public DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder()
    {
      return sourceCodeInfo_;
    }
    
    private void initFields()
    {
      name_ = "";
      package_ = "";
      dependency_ = LazyStringArrayList.EMPTY;
      publicDependency_ = Collections.emptyList();
      weakDependency_ = Collections.emptyList();
      messageType_ = Collections.emptyList();
      enumType_ = Collections.emptyList();
      service_ = Collections.emptyList();
      extension_ = Collections.emptyList();
      options_ = DescriptorProtos.FileOptions.getDefaultInstance();
      sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getMessageTypeCount(); i++) {
        if (!getMessageType(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getEnumTypeCount(); i++) {
        if (!getEnumType(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getServiceCount(); i++) {
        if (!getService(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getExtensionCount(); i++) {
        if (!getExtension(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBytes(2, getPackageBytes());
      }
      for (int i = 0; i < dependency_.size(); i++) {
        output.writeBytes(3, dependency_.getByteString(i));
      }
      for (int i = 0; i < messageType_.size(); i++) {
        output.writeMessage(4, (MessageLite)messageType_.get(i));
      }
      for (int i = 0; i < enumType_.size(); i++) {
        output.writeMessage(5, (MessageLite)enumType_.get(i));
      }
      for (int i = 0; i < service_.size(); i++) {
        output.writeMessage(6, (MessageLite)service_.get(i));
      }
      for (int i = 0; i < extension_.size(); i++) {
        output.writeMessage(7, (MessageLite)extension_.get(i));
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeMessage(8, options_);
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeMessage(9, sourceCodeInfo_);
      }
      for (int i = 0; i < publicDependency_.size(); i++) {
        output.writeInt32(10, ((Integer)publicDependency_.get(i)).intValue());
      }
      for (int i = 0; i < weakDependency_.size(); i++) {
        output.writeInt32(11, ((Integer)weakDependency_.get(i)).intValue());
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBytesSize(2, getPackageBytes());
      }
      int dataSize = 0;
      for (int i = 0; i < dependency_.size(); i++) {
        dataSize += CodedOutputStream.computeBytesSizeNoTag(dependency_.getByteString(i));
      }
      size += dataSize;
      size += 1 * getDependencyList().size();
      for (int i = 0; i < messageType_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(4, (MessageLite)messageType_.get(i));
      }
      for (int i = 0; i < enumType_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(5, (MessageLite)enumType_.get(i));
      }
      for (int i = 0; i < service_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(6, (MessageLite)service_.get(i));
      }
      for (int i = 0; i < extension_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(7, (MessageLite)extension_.get(i));
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeMessageSize(8, options_);
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeMessageSize(9, sourceCodeInfo_);
      }
      int dataSize = 0;
      for (int i = 0; i < publicDependency_.size(); i++) {
        dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)publicDependency_.get(i)).intValue());
      }
      size += dataSize;
      size += 1 * getPublicDependencyList().size();
      
      int dataSize = 0;
      for (int i = 0; i < weakDependency_.size(); i++) {
        dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)weakDependency_.get(i)).intValue());
      }
      size += dataSize;
      size += 1 * getWeakDependencyList().size();
      
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static FileDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (FileDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FileDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FileDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (FileDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FileDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FileDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static FileDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static FileDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$1000();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(FileDescriptorProto prototype)
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
      implements DescriptorProtos.FileDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.FileDescriptorProto.class, Builder.class);
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
        if (GeneratedMessage.alwaysUseFieldBuilders)
        {
          getMessageTypeFieldBuilder();
          getEnumTypeFieldBuilder();
          getServiceFieldBuilder();
          getExtensionFieldBuilder();
          getOptionsFieldBuilder();
          getSourceCodeInfoFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        package_ = "";
        bitField0_ &= 0xFFFFFFFD;
        dependency_ = LazyStringArrayList.EMPTY;
        bitField0_ &= 0xFFFFFFFB;
        publicDependency_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFF7;
        weakDependency_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFEF;
        if (messageTypeBuilder_ == null)
        {
          messageType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFDF;
        }
        else
        {
          messageTypeBuilder_.clear();
        }
        if (enumTypeBuilder_ == null)
        {
          enumType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFBF;
        }
        else
        {
          enumTypeBuilder_.clear();
        }
        if (serviceBuilder_ == null)
        {
          service_ = Collections.emptyList();
          bitField0_ &= 0xFF7F;
        }
        else
        {
          serviceBuilder_.clear();
        }
        if (extensionBuilder_ == null)
        {
          extension_ = Collections.emptyList();
          bitField0_ &= 0xFEFF;
        }
        else
        {
          extensionBuilder_.clear();
        }
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.FileOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFDFF;
        if (sourceCodeInfoBuilder_ == null) {
          sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
        } else {
          sourceCodeInfoBuilder_.clear();
        }
        bitField0_ &= 0xFBFF;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.FileDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.FileDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.FileDescriptorProto build()
      {
        DescriptorProtos.FileDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.FileDescriptorProto buildPartial()
      {
        DescriptorProtos.FileDescriptorProto result = new DescriptorProtos.FileDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        package_ = package_;
        if ((bitField0_ & 0x4) == 4)
        {
          dependency_ = new UnmodifiableLazyStringList(dependency_);
          
          bitField0_ &= 0xFFFFFFFB;
        }
        dependency_ = dependency_;
        if ((bitField0_ & 0x8) == 8)
        {
          publicDependency_ = Collections.unmodifiableList(publicDependency_);
          bitField0_ &= 0xFFFFFFF7;
        }
        publicDependency_ = publicDependency_;
        if ((bitField0_ & 0x10) == 16)
        {
          weakDependency_ = Collections.unmodifiableList(weakDependency_);
          bitField0_ &= 0xFFFFFFEF;
        }
        weakDependency_ = weakDependency_;
        if (messageTypeBuilder_ == null)
        {
          if ((bitField0_ & 0x20) == 32)
          {
            messageType_ = Collections.unmodifiableList(messageType_);
            bitField0_ &= 0xFFFFFFDF;
          }
          messageType_ = messageType_;
        }
        else
        {
          messageType_ = messageTypeBuilder_.build();
        }
        if (enumTypeBuilder_ == null)
        {
          if ((bitField0_ & 0x40) == 64)
          {
            enumType_ = Collections.unmodifiableList(enumType_);
            bitField0_ &= 0xFFFFFFBF;
          }
          enumType_ = enumType_;
        }
        else
        {
          enumType_ = enumTypeBuilder_.build();
        }
        if (serviceBuilder_ == null)
        {
          if ((bitField0_ & 0x80) == 128)
          {
            service_ = Collections.unmodifiableList(service_);
            bitField0_ &= 0xFF7F;
          }
          service_ = service_;
        }
        else
        {
          service_ = serviceBuilder_.build();
        }
        if (extensionBuilder_ == null)
        {
          if ((bitField0_ & 0x100) == 256)
          {
            extension_ = Collections.unmodifiableList(extension_);
            bitField0_ &= 0xFEFF;
          }
          extension_ = extension_;
        }
        else
        {
          extension_ = extensionBuilder_.build();
        }
        if ((from_bitField0_ & 0x200) == 512) {
          to_bitField0_ |= 0x4;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.FileOptions)optionsBuilder_.build());
        }
        if ((from_bitField0_ & 0x400) == 1024) {
          to_bitField0_ |= 0x8;
        }
        if (sourceCodeInfoBuilder_ == null) {
          sourceCodeInfo_ = sourceCodeInfo_;
        } else {
          sourceCodeInfo_ = ((DescriptorProtos.SourceCodeInfo)sourceCodeInfoBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.FileDescriptorProto)) {
          return mergeFrom((DescriptorProtos.FileDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.FileDescriptorProto other)
      {
        if (other == DescriptorProtos.FileDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (other.hasPackage())
        {
          bitField0_ |= 0x2;
          package_ = package_;
          onChanged();
        }
        if (!dependency_.isEmpty())
        {
          if (dependency_.isEmpty())
          {
            dependency_ = dependency_;
            bitField0_ &= 0xFFFFFFFB;
          }
          else
          {
            ensureDependencyIsMutable();
            dependency_.addAll(dependency_);
          }
          onChanged();
        }
        if (!publicDependency_.isEmpty())
        {
          if (publicDependency_.isEmpty())
          {
            publicDependency_ = publicDependency_;
            bitField0_ &= 0xFFFFFFF7;
          }
          else
          {
            ensurePublicDependencyIsMutable();
            publicDependency_.addAll(publicDependency_);
          }
          onChanged();
        }
        if (!weakDependency_.isEmpty())
        {
          if (weakDependency_.isEmpty())
          {
            weakDependency_ = weakDependency_;
            bitField0_ &= 0xFFFFFFEF;
          }
          else
          {
            ensureWeakDependencyIsMutable();
            weakDependency_.addAll(weakDependency_);
          }
          onChanged();
        }
        if (messageTypeBuilder_ == null)
        {
          if (!messageType_.isEmpty())
          {
            if (messageType_.isEmpty())
            {
              messageType_ = messageType_;
              bitField0_ &= 0xFFFFFFDF;
            }
            else
            {
              ensureMessageTypeIsMutable();
              messageType_.addAll(messageType_);
            }
            onChanged();
          }
        }
        else if (!messageType_.isEmpty()) {
          if (messageTypeBuilder_.isEmpty())
          {
            messageTypeBuilder_.dispose();
            messageTypeBuilder_ = null;
            messageType_ = messageType_;
            bitField0_ &= 0xFFFFFFDF;
            messageTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMessageTypeFieldBuilder() : null);
          }
          else
          {
            messageTypeBuilder_.addAllMessages(messageType_);
          }
        }
        if (enumTypeBuilder_ == null)
        {
          if (!enumType_.isEmpty())
          {
            if (enumType_.isEmpty())
            {
              enumType_ = enumType_;
              bitField0_ &= 0xFFFFFFBF;
            }
            else
            {
              ensureEnumTypeIsMutable();
              enumType_.addAll(enumType_);
            }
            onChanged();
          }
        }
        else if (!enumType_.isEmpty()) {
          if (enumTypeBuilder_.isEmpty())
          {
            enumTypeBuilder_.dispose();
            enumTypeBuilder_ = null;
            enumType_ = enumType_;
            bitField0_ &= 0xFFFFFFBF;
            enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
          }
          else
          {
            enumTypeBuilder_.addAllMessages(enumType_);
          }
        }
        if (serviceBuilder_ == null)
        {
          if (!service_.isEmpty())
          {
            if (service_.isEmpty())
            {
              service_ = service_;
              bitField0_ &= 0xFF7F;
            }
            else
            {
              ensureServiceIsMutable();
              service_.addAll(service_);
            }
            onChanged();
          }
        }
        else if (!service_.isEmpty()) {
          if (serviceBuilder_.isEmpty())
          {
            serviceBuilder_.dispose();
            serviceBuilder_ = null;
            service_ = service_;
            bitField0_ &= 0xFF7F;
            serviceBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getServiceFieldBuilder() : null);
          }
          else
          {
            serviceBuilder_.addAllMessages(service_);
          }
        }
        if (extensionBuilder_ == null)
        {
          if (!extension_.isEmpty())
          {
            if (extension_.isEmpty())
            {
              extension_ = extension_;
              bitField0_ &= 0xFEFF;
            }
            else
            {
              ensureExtensionIsMutable();
              extension_.addAll(extension_);
            }
            onChanged();
          }
        }
        else if (!extension_.isEmpty()) {
          if (extensionBuilder_.isEmpty())
          {
            extensionBuilder_.dispose();
            extensionBuilder_ = null;
            extension_ = extension_;
            bitField0_ &= 0xFEFF;
            extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
          }
          else
          {
            extensionBuilder_.addAllMessages(extension_);
          }
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        if (other.hasSourceCodeInfo()) {
          mergeSourceCodeInfo(other.getSourceCodeInfo());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getMessageTypeCount(); i++) {
          if (!getMessageType(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getEnumTypeCount(); i++) {
          if (!getEnumType(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getServiceCount(); i++) {
          if (!getService(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getExtensionCount(); i++) {
          if (!getExtension(i).isInitialized()) {
            return false;
          }
        }
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.FileDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.FileDescriptorProto)DescriptorProtos.FileDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.FileDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.FileDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      private Object package_ = "";
      
      public boolean hasPackage()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public String getPackage()
      {
        Object ref = package_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          package_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getPackageBytes()
      {
        Object ref = package_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          package_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setPackage(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        package_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearPackage()
      {
        bitField0_ &= 0xFFFFFFFD;
        package_ = DescriptorProtos.FileDescriptorProto.getDefaultInstance().getPackage();
        onChanged();
        return this;
      }
      
      public Builder setPackageBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        package_ = value;
        onChanged();
        return this;
      }
      
      private LazyStringList dependency_ = LazyStringArrayList.EMPTY;
      
      private void ensureDependencyIsMutable()
      {
        if ((bitField0_ & 0x4) != 4)
        {
          dependency_ = new LazyStringArrayList(dependency_);
          bitField0_ |= 0x4;
        }
      }
      
      public List<String> getDependencyList()
      {
        return Collections.unmodifiableList(dependency_);
      }
      
      public int getDependencyCount()
      {
        return dependency_.size();
      }
      
      public String getDependency(int index)
      {
        return (String)dependency_.get(index);
      }
      
      public ByteString getDependencyBytes(int index)
      {
        return dependency_.getByteString(index);
      }
      
      public Builder setDependency(int index, String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDependencyIsMutable();
        dependency_.set(index, value);
        onChanged();
        return this;
      }
      
      public Builder addDependency(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDependencyIsMutable();
        dependency_.add(value);
        onChanged();
        return this;
      }
      
      public Builder addAllDependency(Iterable<String> values)
      {
        ensureDependencyIsMutable();
        GeneratedMessage.Builder.addAll(values, dependency_);
        onChanged();
        return this;
      }
      
      public Builder clearDependency()
      {
        dependency_ = LazyStringArrayList.EMPTY;
        bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      }
      
      public Builder addDependencyBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDependencyIsMutable();
        dependency_.add(value);
        onChanged();
        return this;
      }
      
      private List<Integer> publicDependency_ = Collections.emptyList();
      
      private void ensurePublicDependencyIsMutable()
      {
        if ((bitField0_ & 0x8) != 8)
        {
          publicDependency_ = new ArrayList(publicDependency_);
          bitField0_ |= 0x8;
        }
      }
      
      public List<Integer> getPublicDependencyList()
      {
        return Collections.unmodifiableList(publicDependency_);
      }
      
      public int getPublicDependencyCount()
      {
        return publicDependency_.size();
      }
      
      public int getPublicDependency(int index)
      {
        return ((Integer)publicDependency_.get(index)).intValue();
      }
      
      public Builder setPublicDependency(int index, int value)
      {
        ensurePublicDependencyIsMutable();
        publicDependency_.set(index, Integer.valueOf(value));
        onChanged();
        return this;
      }
      
      public Builder addPublicDependency(int value)
      {
        ensurePublicDependencyIsMutable();
        publicDependency_.add(Integer.valueOf(value));
        onChanged();
        return this;
      }
      
      public Builder addAllPublicDependency(Iterable<? extends Integer> values)
      {
        ensurePublicDependencyIsMutable();
        GeneratedMessage.Builder.addAll(values, publicDependency_);
        onChanged();
        return this;
      }
      
      public Builder clearPublicDependency()
      {
        publicDependency_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFF7;
        onChanged();
        return this;
      }
      
      private List<Integer> weakDependency_ = Collections.emptyList();
      
      private void ensureWeakDependencyIsMutable()
      {
        if ((bitField0_ & 0x10) != 16)
        {
          weakDependency_ = new ArrayList(weakDependency_);
          bitField0_ |= 0x10;
        }
      }
      
      public List<Integer> getWeakDependencyList()
      {
        return Collections.unmodifiableList(weakDependency_);
      }
      
      public int getWeakDependencyCount()
      {
        return weakDependency_.size();
      }
      
      public int getWeakDependency(int index)
      {
        return ((Integer)weakDependency_.get(index)).intValue();
      }
      
      public Builder setWeakDependency(int index, int value)
      {
        ensureWeakDependencyIsMutable();
        weakDependency_.set(index, Integer.valueOf(value));
        onChanged();
        return this;
      }
      
      public Builder addWeakDependency(int value)
      {
        ensureWeakDependencyIsMutable();
        weakDependency_.add(Integer.valueOf(value));
        onChanged();
        return this;
      }
      
      public Builder addAllWeakDependency(Iterable<? extends Integer> values)
      {
        ensureWeakDependencyIsMutable();
        GeneratedMessage.Builder.addAll(values, weakDependency_);
        onChanged();
        return this;
      }
      
      public Builder clearWeakDependency()
      {
        weakDependency_ = Collections.emptyList();
        bitField0_ &= 0xFFFFFFEF;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.DescriptorProto> messageType_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> messageTypeBuilder_;
      
      private void ensureMessageTypeIsMutable()
      {
        if ((bitField0_ & 0x20) != 32)
        {
          messageType_ = new ArrayList(messageType_);
          bitField0_ |= 0x20;
        }
      }
      
      public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
      {
        if (messageTypeBuilder_ == null) {
          return Collections.unmodifiableList(messageType_);
        }
        return messageTypeBuilder_.getMessageList();
      }
      
      public int getMessageTypeCount()
      {
        if (messageTypeBuilder_ == null) {
          return messageType_.size();
        }
        return messageTypeBuilder_.getCount();
      }
      
      public DescriptorProtos.DescriptorProto getMessageType(int index)
      {
        if (messageTypeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProto)messageType_.get(index);
        }
        return (DescriptorProtos.DescriptorProto)messageTypeBuilder_.getMessage(index);
      }
      
      public Builder setMessageType(int index, DescriptorProtos.DescriptorProto value)
      {
        if (messageTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageTypeIsMutable();
          messageType_.set(index, value);
          onChanged();
        }
        else
        {
          messageTypeBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setMessageType(int index, DescriptorProtos.DescriptorProto.Builder builderForValue)
      {
        if (messageTypeBuilder_ == null)
        {
          ensureMessageTypeIsMutable();
          messageType_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          messageTypeBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addMessageType(DescriptorProtos.DescriptorProto value)
      {
        if (messageTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageTypeIsMutable();
          messageType_.add(value);
          onChanged();
        }
        else
        {
          messageTypeBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addMessageType(int index, DescriptorProtos.DescriptorProto value)
      {
        if (messageTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMessageTypeIsMutable();
          messageType_.add(index, value);
          onChanged();
        }
        else
        {
          messageTypeBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addMessageType(DescriptorProtos.DescriptorProto.Builder builderForValue)
      {
        if (messageTypeBuilder_ == null)
        {
          ensureMessageTypeIsMutable();
          messageType_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          messageTypeBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addMessageType(int index, DescriptorProtos.DescriptorProto.Builder builderForValue)
      {
        if (messageTypeBuilder_ == null)
        {
          ensureMessageTypeIsMutable();
          messageType_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          messageTypeBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllMessageType(Iterable<? extends DescriptorProtos.DescriptorProto> values)
      {
        if (messageTypeBuilder_ == null)
        {
          ensureMessageTypeIsMutable();
          GeneratedMessage.Builder.addAll(values, messageType_);
          onChanged();
        }
        else
        {
          messageTypeBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearMessageType()
      {
        if (messageTypeBuilder_ == null)
        {
          messageType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFDF;
          onChanged();
        }
        else
        {
          messageTypeBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeMessageType(int index)
      {
        if (messageTypeBuilder_ == null)
        {
          ensureMessageTypeIsMutable();
          messageType_.remove(index);
          onChanged();
        }
        else
        {
          messageTypeBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.DescriptorProto.Builder getMessageTypeBuilder(int index)
      {
        return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index)
      {
        if (messageTypeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProtoOrBuilder)messageType_.get(index);
        }
        return (DescriptorProtos.DescriptorProtoOrBuilder)messageTypeBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList()
      {
        if (messageTypeBuilder_ != null) {
          return messageTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(messageType_);
      }
      
      public DescriptorProtos.DescriptorProto.Builder addMessageTypeBuilder()
      {
        return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.DescriptorProto.Builder addMessageTypeBuilder(int index)
      {
        return (DescriptorProtos.DescriptorProto.Builder)getMessageTypeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.DescriptorProto.Builder> getMessageTypeBuilderList()
      {
        return getMessageTypeFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, DescriptorProtos.DescriptorProto.Builder, DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeFieldBuilder()
      {
        if (messageTypeBuilder_ == null)
        {
          messageTypeBuilder_ = new RepeatedFieldBuilder(messageType_, (bitField0_ & 0x20) == 32, getParentForChildren(), isClean());
          
          messageType_ = null;
        }
        return messageTypeBuilder_;
      }
      
      private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
      
      private void ensureEnumTypeIsMutable()
      {
        if ((bitField0_ & 0x40) != 64)
        {
          enumType_ = new ArrayList(enumType_);
          bitField0_ |= 0x40;
        }
      }
      
      public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
      {
        if (enumTypeBuilder_ == null) {
          return Collections.unmodifiableList(enumType_);
        }
        return enumTypeBuilder_.getMessageList();
      }
      
      public int getEnumTypeCount()
      {
        if (enumTypeBuilder_ == null) {
          return enumType_.size();
        }
        return enumTypeBuilder_.getCount();
      }
      
      public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
      {
        if (enumTypeBuilder_ == null) {
          return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
        }
        return (DescriptorProtos.EnumDescriptorProto)enumTypeBuilder_.getMessage(index);
      }
      
      public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.set(index, value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.add(value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.add(index, value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> values)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          GeneratedMessage.Builder.addAll(values, enumType_);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearEnumType()
      {
        if (enumTypeBuilder_ == null)
        {
          enumType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFBF;
          onChanged();
        }
        else
        {
          enumTypeBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeEnumType(int index)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.remove(index);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder getEnumTypeBuilder(int index)
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
      {
        if (enumTypeBuilder_ == null) {
          return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
        }
        return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumTypeBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
      {
        if (enumTypeBuilder_ != null) {
          return enumTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(enumType_);
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder()
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder(int index)
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(index, DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.EnumDescriptorProto.Builder> getEnumTypeBuilderList()
      {
        return getEnumTypeFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder()
      {
        if (enumTypeBuilder_ == null)
        {
          enumTypeBuilder_ = new RepeatedFieldBuilder(enumType_, (bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
          
          enumType_ = null;
        }
        return enumTypeBuilder_;
      }
      
      private List<DescriptorProtos.ServiceDescriptorProto> service_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> serviceBuilder_;
      
      private void ensureServiceIsMutable()
      {
        if ((bitField0_ & 0x80) != 128)
        {
          service_ = new ArrayList(service_);
          bitField0_ |= 0x80;
        }
      }
      
      public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
      {
        if (serviceBuilder_ == null) {
          return Collections.unmodifiableList(service_);
        }
        return serviceBuilder_.getMessageList();
      }
      
      public int getServiceCount()
      {
        if (serviceBuilder_ == null) {
          return service_.size();
        }
        return serviceBuilder_.getCount();
      }
      
      public DescriptorProtos.ServiceDescriptorProto getService(int index)
      {
        if (serviceBuilder_ == null) {
          return (DescriptorProtos.ServiceDescriptorProto)service_.get(index);
        }
        return (DescriptorProtos.ServiceDescriptorProto)serviceBuilder_.getMessage(index);
      }
      
      public Builder setService(int index, DescriptorProtos.ServiceDescriptorProto value)
      {
        if (serviceBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureServiceIsMutable();
          service_.set(index, value);
          onChanged();
        }
        else
        {
          serviceBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setService(int index, DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
      {
        if (serviceBuilder_ == null)
        {
          ensureServiceIsMutable();
          service_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          serviceBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addService(DescriptorProtos.ServiceDescriptorProto value)
      {
        if (serviceBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureServiceIsMutable();
          service_.add(value);
          onChanged();
        }
        else
        {
          serviceBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addService(int index, DescriptorProtos.ServiceDescriptorProto value)
      {
        if (serviceBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureServiceIsMutable();
          service_.add(index, value);
          onChanged();
        }
        else
        {
          serviceBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addService(DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
      {
        if (serviceBuilder_ == null)
        {
          ensureServiceIsMutable();
          service_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          serviceBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addService(int index, DescriptorProtos.ServiceDescriptorProto.Builder builderForValue)
      {
        if (serviceBuilder_ == null)
        {
          ensureServiceIsMutable();
          service_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          serviceBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllService(Iterable<? extends DescriptorProtos.ServiceDescriptorProto> values)
      {
        if (serviceBuilder_ == null)
        {
          ensureServiceIsMutable();
          GeneratedMessage.Builder.addAll(values, service_);
          onChanged();
        }
        else
        {
          serviceBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearService()
      {
        if (serviceBuilder_ == null)
        {
          service_ = Collections.emptyList();
          bitField0_ &= 0xFF7F;
          onChanged();
        }
        else
        {
          serviceBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeService(int index)
      {
        if (serviceBuilder_ == null)
        {
          ensureServiceIsMutable();
          service_.remove(index);
          onChanged();
        }
        else
        {
          serviceBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.ServiceDescriptorProto.Builder getServiceBuilder(int index)
      {
        return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index)
      {
        if (serviceBuilder_ == null) {
          return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)service_.get(index);
        }
        return (DescriptorProtos.ServiceDescriptorProtoOrBuilder)serviceBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList()
      {
        if (serviceBuilder_ != null) {
          return serviceBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(service_);
      }
      
      public DescriptorProtos.ServiceDescriptorProto.Builder addServiceBuilder()
      {
        return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().addBuilder(DescriptorProtos.ServiceDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.ServiceDescriptorProto.Builder addServiceBuilder(int index)
      {
        return (DescriptorProtos.ServiceDescriptorProto.Builder)getServiceFieldBuilder().addBuilder(index, DescriptorProtos.ServiceDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.ServiceDescriptorProto.Builder> getServiceBuilderList()
      {
        return getServiceFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.ServiceDescriptorProto, DescriptorProtos.ServiceDescriptorProto.Builder, DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceFieldBuilder()
      {
        if (serviceBuilder_ == null)
        {
          serviceBuilder_ = new RepeatedFieldBuilder(service_, (bitField0_ & 0x80) == 128, getParentForChildren(), isClean());
          
          service_ = null;
        }
        return serviceBuilder_;
      }
      
      private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> extensionBuilder_;
      
      private void ensureExtensionIsMutable()
      {
        if ((bitField0_ & 0x100) != 256)
        {
          extension_ = new ArrayList(extension_);
          bitField0_ |= 0x100;
        }
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
      {
        if (extensionBuilder_ == null) {
          return Collections.unmodifiableList(extension_);
        }
        return extensionBuilder_.getMessageList();
      }
      
      public int getExtensionCount()
      {
        if (extensionBuilder_ == null) {
          return extension_.size();
        }
        return extensionBuilder_.getCount();
      }
      
      public DescriptorProtos.FieldDescriptorProto getExtension(int index)
      {
        if (extensionBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProto)extensionBuilder_.getMessage(index);
      }
      
      public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.set(index, value);
          onChanged();
        }
        else
        {
          extensionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.add(value);
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.add(index, value);
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          GeneratedMessage.Builder.addAll(values, extension_);
          onChanged();
        }
        else
        {
          extensionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearExtension()
      {
        if (extensionBuilder_ == null)
        {
          extension_ = Collections.emptyList();
          bitField0_ &= 0xFEFF;
          onChanged();
        }
        else
        {
          extensionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeExtension(int index)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.remove(index);
          onChanged();
        }
        else
        {
          extensionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder getExtensionBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
      {
        if (extensionBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extensionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
      {
        if (extensionBuilder_ != null) {
          return extensionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(extension_);
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder()
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.FieldDescriptorProto.Builder> getExtensionBuilderList()
      {
        return getExtensionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder()
      {
        if (extensionBuilder_ == null)
        {
          extensionBuilder_ = new RepeatedFieldBuilder(extension_, (bitField0_ & 0x100) == 256, getParentForChildren(), isClean());
          
          extension_ = null;
        }
        return extensionBuilder_;
      }
      
      private DescriptorProtos.FileOptions options_ = DescriptorProtos.FileOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x200) == 512;
      }
      
      public DescriptorProtos.FileOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.FileOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.FileOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x200;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FileOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x200;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.FileOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x200) == 512) && (options_ != DescriptorProtos.FileOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.FileOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x200;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.FileOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFDFF;
        return this;
      }
      
      public DescriptorProtos.FileOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x200;
        onChanged();
        return (DescriptorProtos.FileOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.FileOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.FileOptions, DescriptorProtos.FileOptions.Builder, DescriptorProtos.FileOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
      
      private DescriptorProtos.SourceCodeInfo sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> sourceCodeInfoBuilder_;
      
      public boolean hasSourceCodeInfo()
      {
        return (bitField0_ & 0x400) == 1024;
      }
      
      public DescriptorProtos.SourceCodeInfo getSourceCodeInfo()
      {
        if (sourceCodeInfoBuilder_ == null) {
          return sourceCodeInfo_;
        }
        return (DescriptorProtos.SourceCodeInfo)sourceCodeInfoBuilder_.getMessage();
      }
      
      public Builder setSourceCodeInfo(DescriptorProtos.SourceCodeInfo value)
      {
        if (sourceCodeInfoBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          sourceCodeInfo_ = value;
          onChanged();
        }
        else
        {
          sourceCodeInfoBuilder_.setMessage(value);
        }
        bitField0_ |= 0x400;
        return this;
      }
      
      public Builder setSourceCodeInfo(DescriptorProtos.SourceCodeInfo.Builder builderForValue)
      {
        if (sourceCodeInfoBuilder_ == null)
        {
          sourceCodeInfo_ = builderForValue.build();
          onChanged();
        }
        else
        {
          sourceCodeInfoBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x400;
        return this;
      }
      
      public Builder mergeSourceCodeInfo(DescriptorProtos.SourceCodeInfo value)
      {
        if (sourceCodeInfoBuilder_ == null)
        {
          if (((bitField0_ & 0x400) == 1024) && (sourceCodeInfo_ != DescriptorProtos.SourceCodeInfo.getDefaultInstance())) {
            sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.newBuilder(sourceCodeInfo_).mergeFrom(value).buildPartial();
          } else {
            sourceCodeInfo_ = value;
          }
          onChanged();
        }
        else
        {
          sourceCodeInfoBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x400;
        return this;
      }
      
      public Builder clearSourceCodeInfo()
      {
        if (sourceCodeInfoBuilder_ == null)
        {
          sourceCodeInfo_ = DescriptorProtos.SourceCodeInfo.getDefaultInstance();
          onChanged();
        }
        else
        {
          sourceCodeInfoBuilder_.clear();
        }
        bitField0_ &= 0xFBFF;
        return this;
      }
      
      public DescriptorProtos.SourceCodeInfo.Builder getSourceCodeInfoBuilder()
      {
        bitField0_ |= 0x400;
        onChanged();
        return (DescriptorProtos.SourceCodeInfo.Builder)getSourceCodeInfoFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder()
      {
        if (sourceCodeInfoBuilder_ != null) {
          return (DescriptorProtos.SourceCodeInfoOrBuilder)sourceCodeInfoBuilder_.getMessageOrBuilder();
        }
        return sourceCodeInfo_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.SourceCodeInfo, DescriptorProtos.SourceCodeInfo.Builder, DescriptorProtos.SourceCodeInfoOrBuilder> getSourceCodeInfoFieldBuilder()
      {
        if (sourceCodeInfoBuilder_ == null)
        {
          sourceCodeInfoBuilder_ = new SingleFieldBuilder(sourceCodeInfo_, getParentForChildren(), isClean());
          
          sourceCodeInfo_ = null;
        }
        return sourceCodeInfoBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new FileDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface DescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract List<DescriptorProtos.FieldDescriptorProto> getFieldList();
    
    public abstract DescriptorProtos.FieldDescriptorProto getField(int paramInt);
    
    public abstract int getFieldCount();
    
    public abstract List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList();
    
    public abstract DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.FieldDescriptorProto> getExtensionList();
    
    public abstract DescriptorProtos.FieldDescriptorProto getExtension(int paramInt);
    
    public abstract int getExtensionCount();
    
    public abstract List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();
    
    public abstract DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.DescriptorProto> getNestedTypeList();
    
    public abstract DescriptorProtos.DescriptorProto getNestedType(int paramInt);
    
    public abstract int getNestedTypeCount();
    
    public abstract List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList();
    
    public abstract DescriptorProtoOrBuilder getNestedTypeOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList();
    
    public abstract DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt);
    
    public abstract int getEnumTypeCount();
    
    public abstract List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();
    
    public abstract DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int paramInt);
    
    public abstract List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList();
    
    public abstract DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int paramInt);
    
    public abstract int getExtensionRangeCount();
    
    public abstract List<? extends DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList();
    
    public abstract DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int paramInt);
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.MessageOptions getOptions();
    
    public abstract DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class DescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.DescriptorProtoOrBuilder
  {
    private static final DescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private DescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private DescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static DescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public DescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private DescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            if ((mutable_bitField0_ & 0x2) != 2)
            {
              field_ = new ArrayList();
              mutable_bitField0_ |= 0x2;
            }
            field_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
            break;
          case 26: 
            if ((mutable_bitField0_ & 0x8) != 8)
            {
              nestedType_ = new ArrayList();
              mutable_bitField0_ |= 0x8;
            }
            nestedType_.add(input.readMessage(PARSER, extensionRegistry));
            break;
          case 34: 
            if ((mutable_bitField0_ & 0x10) != 16)
            {
              enumType_ = new ArrayList();
              mutable_bitField0_ |= 0x10;
            }
            enumType_.add(input.readMessage(DescriptorProtos.EnumDescriptorProto.PARSER, extensionRegistry));
            break;
          case 42: 
            if ((mutable_bitField0_ & 0x20) != 32)
            {
              extensionRange_ = new ArrayList();
              mutable_bitField0_ |= 0x20;
            }
            extensionRange_.add(input.readMessage(ExtensionRange.PARSER, extensionRegistry));
            break;
          case 50: 
            if ((mutable_bitField0_ & 0x4) != 4)
            {
              extension_ = new ArrayList();
              mutable_bitField0_ |= 0x4;
            }
            extension_.add(input.readMessage(DescriptorProtos.FieldDescriptorProto.PARSER, extensionRegistry));
            break;
          case 58: 
            DescriptorProtos.MessageOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x2) == 2) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.MessageOptions)input.readMessage(DescriptorProtos.MessageOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x2;
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
        if ((mutable_bitField0_ & 0x2) == 2) {
          field_ = Collections.unmodifiableList(field_);
        }
        if ((mutable_bitField0_ & 0x8) == 8) {
          nestedType_ = Collections.unmodifiableList(nestedType_);
        }
        if ((mutable_bitField0_ & 0x10) == 16) {
          enumType_ = Collections.unmodifiableList(enumType_);
        }
        if ((mutable_bitField0_ & 0x20) == 32) {
          extensionRange_ = Collections.unmodifiableList(extensionRange_);
        }
        if ((mutable_bitField0_ & 0x4) == 4) {
          extension_ = Collections.unmodifiableList(extension_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProto.class, Builder.class);
    }
    
    public static Parser<DescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.DescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.DescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int FIELD_FIELD_NUMBER = 2;
    private List<DescriptorProtos.FieldDescriptorProto> field_;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    private List<DescriptorProtos.FieldDescriptorProto> extension_;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    private List<DescriptorProto> nestedType_;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    private List<DescriptorProtos.EnumDescriptorProto> enumType_;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    private List<ExtensionRange> extensionRange_;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private DescriptorProtos.MessageOptions options_;
    
    public Parser<DescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public static abstract interface ExtensionRangeOrBuilder
      extends MessageOrBuilder
    {
      public abstract boolean hasStart();
      
      public abstract int getStart();
      
      public abstract boolean hasEnd();
      
      public abstract int getEnd();
    }
    
    public static final class ExtensionRange
      extends GeneratedMessage
      implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
    {
      private static final ExtensionRange defaultInstance;
      private final UnknownFieldSet unknownFields;
      
      private ExtensionRange(GeneratedMessage.Builder<?> builder)
      {
        super();
        unknownFields = builder.getUnknownFields();
      }
      
      private ExtensionRange(boolean noInit)
      {
        unknownFields = UnknownFieldSet.getDefaultInstance();
      }
      
      public static ExtensionRange getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public ExtensionRange getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final UnknownFieldSet getUnknownFields()
      {
        return unknownFields;
      }
      
      private ExtensionRange(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
              start_ = input.readInt32();
              break;
            case 16: 
              bitField0_ |= 0x2;
              end_ = input.readInt32();
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
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable.ensureFieldAccessorsInitialized(ExtensionRange.class, Builder.class);
      }
      
      public static Parser<ExtensionRange> PARSER = new AbstractParser()
      {
        public DescriptorProtos.DescriptorProto.ExtensionRange parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
          throws InvalidProtocolBufferException
        {
          return new DescriptorProtos.DescriptorProto.ExtensionRange(input, extensionRegistry, null);
        }
      };
      private int bitField0_;
      public static final int START_FIELD_NUMBER = 1;
      private int start_;
      public static final int END_FIELD_NUMBER = 2;
      private int end_;
      
      public Parser<ExtensionRange> getParserForType()
      {
        return PARSER;
      }
      
      public boolean hasStart()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public int getStart()
      {
        return start_;
      }
      
      public boolean hasEnd()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public int getEnd()
      {
        return end_;
      }
      
      private void initFields()
      {
        start_ = 0;
        end_ = 0;
      }
      
      private byte memoizedIsInitialized = -1;
      
      public final boolean isInitialized()
      {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized != -1) {
          return isInitialized == 1;
        }
        memoizedIsInitialized = 1;
        return true;
      }
      
      public void writeTo(CodedOutputStream output)
        throws IOException
      {
        getSerializedSize();
        if ((bitField0_ & 0x1) == 1) {
          output.writeInt32(1, start_);
        }
        if ((bitField0_ & 0x2) == 2) {
          output.writeInt32(2, end_);
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
          size += CodedOutputStream.computeInt32Size(1, start_);
        }
        if ((bitField0_ & 0x2) == 2) {
          size += CodedOutputStream.computeInt32Size(2, end_);
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
      
      public static ExtensionRange parseFrom(ByteString data)
        throws InvalidProtocolBufferException
      {
        return (ExtensionRange)PARSER.parseFrom(data);
      }
      
      public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (ExtensionRange)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static ExtensionRange parseFrom(byte[] data)
        throws InvalidProtocolBufferException
      {
        return (ExtensionRange)PARSER.parseFrom(data);
      }
      
      public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (ExtensionRange)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static ExtensionRange parseFrom(InputStream input)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseFrom(input);
      }
      
      public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static ExtensionRange parseDelimitedFrom(InputStream input)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseDelimitedFrom(input);
      }
      
      public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseDelimitedFrom(input, extensionRegistry);
      }
      
      public static ExtensionRange parseFrom(CodedInputStream input)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseFrom(input);
      }
      
      public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (ExtensionRange)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static Builder newBuilder()
      {
        return Builder.access$3100();
      }
      
      public Builder newBuilderForType()
      {
        return newBuilder();
      }
      
      public static Builder newBuilder(ExtensionRange prototype)
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
        implements DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
      {
        private int bitField0_;
        private int start_;
        private int end_;
        
        public static final Descriptors.Descriptor getDescriptor()
        {
          return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
        }
        
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
          return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.ExtensionRange.class, Builder.class);
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
          if (GeneratedMessage.alwaysUseFieldBuilders) {}
        }
        
        private static Builder create()
        {
          return new Builder();
        }
        
        public Builder clear()
        {
          super.clear();
          start_ = 0;
          bitField0_ &= 0xFFFFFFFE;
          end_ = 0;
          bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        
        public Builder clone()
        {
          return create().mergeFrom(buildPartial());
        }
        
        public Descriptors.Descriptor getDescriptorForType()
        {
          return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange getDefaultInstanceForType()
        {
          return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange build()
        {
          DescriptorProtos.DescriptorProto.ExtensionRange result = buildPartial();
          if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
          }
          return result;
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange buildPartial()
        {
          DescriptorProtos.DescriptorProto.ExtensionRange result = new DescriptorProtos.DescriptorProto.ExtensionRange(this, null);
          int from_bitField0_ = bitField0_;
          int to_bitField0_ = 0;
          if ((from_bitField0_ & 0x1) == 1) {
            to_bitField0_ |= 0x1;
          }
          start_ = start_;
          if ((from_bitField0_ & 0x2) == 2) {
            to_bitField0_ |= 0x2;
          }
          end_ = end_;
          bitField0_ = to_bitField0_;
          onBuilt();
          return result;
        }
        
        public Builder mergeFrom(Message other)
        {
          if ((other instanceof DescriptorProtos.DescriptorProto.ExtensionRange)) {
            return mergeFrom((DescriptorProtos.DescriptorProto.ExtensionRange)other);
          }
          super.mergeFrom(other);
          return this;
        }
        
        public Builder mergeFrom(DescriptorProtos.DescriptorProto.ExtensionRange other)
        {
          if (other == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance()) {
            return this;
          }
          if (other.hasStart()) {
            setStart(other.getStart());
          }
          if (other.hasEnd()) {
            setEnd(other.getEnd());
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
          DescriptorProtos.DescriptorProto.ExtensionRange parsedMessage = null;
          try
          {
            parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)DescriptorProtos.DescriptorProto.ExtensionRange.PARSER.parsePartialFrom(input, extensionRegistry);
          }
          catch (InvalidProtocolBufferException e)
          {
            parsedMessage = (DescriptorProtos.DescriptorProto.ExtensionRange)e.getUnfinishedMessage();
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
        
        public boolean hasStart()
        {
          return (bitField0_ & 0x1) == 1;
        }
        
        public int getStart()
        {
          return start_;
        }
        
        public Builder setStart(int value)
        {
          bitField0_ |= 0x1;
          start_ = value;
          onChanged();
          return this;
        }
        
        public Builder clearStart()
        {
          bitField0_ &= 0xFFFFFFFE;
          start_ = 0;
          onChanged();
          return this;
        }
        
        public boolean hasEnd()
        {
          return (bitField0_ & 0x2) == 2;
        }
        
        public int getEnd()
        {
          return end_;
        }
        
        public Builder setEnd(int value)
        {
          bitField0_ |= 0x2;
          end_ = value;
          onChanged();
          return this;
        }
        
        public Builder clearEnd()
        {
          bitField0_ &= 0xFFFFFFFD;
          end_ = 0;
          onChanged();
          return this;
        }
      }
      
      static
      {
        defaultInstance = new ExtensionRange(true);
        defaultInstance.initFields();
      }
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
    {
      return field_;
    }
    
    public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
    {
      return field_;
    }
    
    public int getFieldCount()
    {
      return field_.size();
    }
    
    public DescriptorProtos.FieldDescriptorProto getField(int index)
    {
      return (DescriptorProtos.FieldDescriptorProto)field_.get(index);
    }
    
    public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index)
    {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)field_.get(index);
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
    {
      return extension_;
    }
    
    public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
    {
      return extension_;
    }
    
    public int getExtensionCount()
    {
      return extension_.size();
    }
    
    public DescriptorProtos.FieldDescriptorProto getExtension(int index)
    {
      return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
    }
    
    public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
    {
      return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
    }
    
    public List<DescriptorProto> getNestedTypeList()
    {
      return nestedType_;
    }
    
    public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
    {
      return nestedType_;
    }
    
    public int getNestedTypeCount()
    {
      return nestedType_.size();
    }
    
    public DescriptorProto getNestedType(int index)
    {
      return (DescriptorProto)nestedType_.get(index);
    }
    
    public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index)
    {
      return (DescriptorProtos.DescriptorProtoOrBuilder)nestedType_.get(index);
    }
    
    public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
    {
      return enumType_;
    }
    
    public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
    {
      return enumType_;
    }
    
    public int getEnumTypeCount()
    {
      return enumType_.size();
    }
    
    public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
    {
      return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
    }
    
    public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
    {
      return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
    }
    
    public List<ExtensionRange> getExtensionRangeList()
    {
      return extensionRange_;
    }
    
    public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
    {
      return extensionRange_;
    }
    
    public int getExtensionRangeCount()
    {
      return extensionRange_.size();
    }
    
    public ExtensionRange getExtensionRange(int index)
    {
      return (ExtensionRange)extensionRange_.get(index);
    }
    
    public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index)
    {
      return (ExtensionRangeOrBuilder)extensionRange_.get(index);
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public DescriptorProtos.MessageOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      field_ = Collections.emptyList();
      extension_ = Collections.emptyList();
      nestedType_ = Collections.emptyList();
      enumType_ = Collections.emptyList();
      extensionRange_ = Collections.emptyList();
      options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getFieldCount(); i++) {
        if (!getField(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getExtensionCount(); i++) {
        if (!getExtension(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getNestedTypeCount(); i++) {
        if (!getNestedType(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      for (int i = 0; i < getEnumTypeCount(); i++) {
        if (!getEnumType(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      for (int i = 0; i < field_.size(); i++) {
        output.writeMessage(2, (MessageLite)field_.get(i));
      }
      for (int i = 0; i < nestedType_.size(); i++) {
        output.writeMessage(3, (MessageLite)nestedType_.get(i));
      }
      for (int i = 0; i < enumType_.size(); i++) {
        output.writeMessage(4, (MessageLite)enumType_.get(i));
      }
      for (int i = 0; i < extensionRange_.size(); i++) {
        output.writeMessage(5, (MessageLite)extensionRange_.get(i));
      }
      for (int i = 0; i < extension_.size(); i++) {
        output.writeMessage(6, (MessageLite)extension_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeMessage(7, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      for (int i = 0; i < field_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(2, (MessageLite)field_.get(i));
      }
      for (int i = 0; i < nestedType_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(3, (MessageLite)nestedType_.get(i));
      }
      for (int i = 0; i < enumType_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(4, (MessageLite)enumType_.get(i));
      }
      for (int i = 0; i < extensionRange_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(5, (MessageLite)extensionRange_.get(i));
      }
      for (int i = 0; i < extension_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(6, (MessageLite)extension_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeMessageSize(7, options_);
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
    
    public static DescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (DescriptorProto)PARSER.parseFrom(data);
    }
    
    public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (DescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static DescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (DescriptorProto)PARSER.parseFrom(data);
    }
    
    public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (DescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static DescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseFrom(input);
    }
    
    public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static DescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static DescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseFrom(input);
    }
    
    public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (DescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$3700();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(DescriptorProto prototype)
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
      implements DescriptorProtos.DescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.DescriptorProto.class, Builder.class);
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
        if (GeneratedMessage.alwaysUseFieldBuilders)
        {
          getFieldFieldBuilder();
          getExtensionFieldBuilder();
          getNestedTypeFieldBuilder();
          getEnumTypeFieldBuilder();
          getExtensionRangeFieldBuilder();
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        if (fieldBuilder_ == null)
        {
          field_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          fieldBuilder_.clear();
        }
        if (extensionBuilder_ == null)
        {
          extension_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFB;
        }
        else
        {
          extensionBuilder_.clear();
        }
        if (nestedTypeBuilder_ == null)
        {
          nestedType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFF7;
        }
        else
        {
          nestedTypeBuilder_.clear();
        }
        if (enumTypeBuilder_ == null)
        {
          enumType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFEF;
        }
        else
        {
          enumTypeBuilder_.clear();
        }
        if (extensionRangeBuilder_ == null)
        {
          extensionRange_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFDF;
        }
        else
        {
          extensionRangeBuilder_.clear();
        }
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFBF;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
      }
      
      public DescriptorProtos.DescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.DescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.DescriptorProto build()
      {
        DescriptorProtos.DescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.DescriptorProto buildPartial()
      {
        DescriptorProtos.DescriptorProto result = new DescriptorProtos.DescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if (fieldBuilder_ == null)
        {
          if ((bitField0_ & 0x2) == 2)
          {
            field_ = Collections.unmodifiableList(field_);
            bitField0_ &= 0xFFFFFFFD;
          }
          field_ = field_;
        }
        else
        {
          field_ = fieldBuilder_.build();
        }
        if (extensionBuilder_ == null)
        {
          if ((bitField0_ & 0x4) == 4)
          {
            extension_ = Collections.unmodifiableList(extension_);
            bitField0_ &= 0xFFFFFFFB;
          }
          extension_ = extension_;
        }
        else
        {
          extension_ = extensionBuilder_.build();
        }
        if (nestedTypeBuilder_ == null)
        {
          if ((bitField0_ & 0x8) == 8)
          {
            nestedType_ = Collections.unmodifiableList(nestedType_);
            bitField0_ &= 0xFFFFFFF7;
          }
          nestedType_ = nestedType_;
        }
        else
        {
          nestedType_ = nestedTypeBuilder_.build();
        }
        if (enumTypeBuilder_ == null)
        {
          if ((bitField0_ & 0x10) == 16)
          {
            enumType_ = Collections.unmodifiableList(enumType_);
            bitField0_ &= 0xFFFFFFEF;
          }
          enumType_ = enumType_;
        }
        else
        {
          enumType_ = enumTypeBuilder_.build();
        }
        if (extensionRangeBuilder_ == null)
        {
          if ((bitField0_ & 0x20) == 32)
          {
            extensionRange_ = Collections.unmodifiableList(extensionRange_);
            bitField0_ &= 0xFFFFFFDF;
          }
          extensionRange_ = extensionRange_;
        }
        else
        {
          extensionRange_ = extensionRangeBuilder_.build();
        }
        if ((from_bitField0_ & 0x40) == 64) {
          to_bitField0_ |= 0x2;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.MessageOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.DescriptorProto)) {
          return mergeFrom((DescriptorProtos.DescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.DescriptorProto other)
      {
        if (other == DescriptorProtos.DescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (fieldBuilder_ == null)
        {
          if (!field_.isEmpty())
          {
            if (field_.isEmpty())
            {
              field_ = field_;
              bitField0_ &= 0xFFFFFFFD;
            }
            else
            {
              ensureFieldIsMutable();
              field_.addAll(field_);
            }
            onChanged();
          }
        }
        else if (!field_.isEmpty()) {
          if (fieldBuilder_.isEmpty())
          {
            fieldBuilder_.dispose();
            fieldBuilder_ = null;
            field_ = field_;
            bitField0_ &= 0xFFFFFFFD;
            fieldBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getFieldFieldBuilder() : null);
          }
          else
          {
            fieldBuilder_.addAllMessages(field_);
          }
        }
        if (extensionBuilder_ == null)
        {
          if (!extension_.isEmpty())
          {
            if (extension_.isEmpty())
            {
              extension_ = extension_;
              bitField0_ &= 0xFFFFFFFB;
            }
            else
            {
              ensureExtensionIsMutable();
              extension_.addAll(extension_);
            }
            onChanged();
          }
        }
        else if (!extension_.isEmpty()) {
          if (extensionBuilder_.isEmpty())
          {
            extensionBuilder_.dispose();
            extensionBuilder_ = null;
            extension_ = extension_;
            bitField0_ &= 0xFFFFFFFB;
            extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null);
          }
          else
          {
            extensionBuilder_.addAllMessages(extension_);
          }
        }
        if (nestedTypeBuilder_ == null)
        {
          if (!nestedType_.isEmpty())
          {
            if (nestedType_.isEmpty())
            {
              nestedType_ = nestedType_;
              bitField0_ &= 0xFFFFFFF7;
            }
            else
            {
              ensureNestedTypeIsMutable();
              nestedType_.addAll(nestedType_);
            }
            onChanged();
          }
        }
        else if (!nestedType_.isEmpty()) {
          if (nestedTypeBuilder_.isEmpty())
          {
            nestedTypeBuilder_.dispose();
            nestedTypeBuilder_ = null;
            nestedType_ = nestedType_;
            bitField0_ &= 0xFFFFFFF7;
            nestedTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNestedTypeFieldBuilder() : null);
          }
          else
          {
            nestedTypeBuilder_.addAllMessages(nestedType_);
          }
        }
        if (enumTypeBuilder_ == null)
        {
          if (!enumType_.isEmpty())
          {
            if (enumType_.isEmpty())
            {
              enumType_ = enumType_;
              bitField0_ &= 0xFFFFFFEF;
            }
            else
            {
              ensureEnumTypeIsMutable();
              enumType_.addAll(enumType_);
            }
            onChanged();
          }
        }
        else if (!enumType_.isEmpty()) {
          if (enumTypeBuilder_.isEmpty())
          {
            enumTypeBuilder_.dispose();
            enumTypeBuilder_ = null;
            enumType_ = enumType_;
            bitField0_ &= 0xFFFFFFEF;
            enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null);
          }
          else
          {
            enumTypeBuilder_.addAllMessages(enumType_);
          }
        }
        if (extensionRangeBuilder_ == null)
        {
          if (!extensionRange_.isEmpty())
          {
            if (extensionRange_.isEmpty())
            {
              extensionRange_ = extensionRange_;
              bitField0_ &= 0xFFFFFFDF;
            }
            else
            {
              ensureExtensionRangeIsMutable();
              extensionRange_.addAll(extensionRange_);
            }
            onChanged();
          }
        }
        else if (!extensionRange_.isEmpty()) {
          if (extensionRangeBuilder_.isEmpty())
          {
            extensionRangeBuilder_.dispose();
            extensionRangeBuilder_ = null;
            extensionRange_ = extensionRange_;
            bitField0_ &= 0xFFFFFFDF;
            extensionRangeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getExtensionRangeFieldBuilder() : null);
          }
          else
          {
            extensionRangeBuilder_.addAllMessages(extensionRange_);
          }
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getFieldCount(); i++) {
          if (!getField(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getExtensionCount(); i++) {
          if (!getExtension(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getNestedTypeCount(); i++) {
          if (!getNestedType(i).isInitialized()) {
            return false;
          }
        }
        for (int i = 0; i < getEnumTypeCount(); i++) {
          if (!getEnumType(i).isInitialized()) {
            return false;
          }
        }
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.DescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.DescriptorProto)DescriptorProtos.DescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.DescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.DescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.FieldDescriptorProto> field_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> fieldBuilder_;
      
      private void ensureFieldIsMutable()
      {
        if ((bitField0_ & 0x2) != 2)
        {
          field_ = new ArrayList(field_);
          bitField0_ |= 0x2;
        }
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
      {
        if (fieldBuilder_ == null) {
          return Collections.unmodifiableList(field_);
        }
        return fieldBuilder_.getMessageList();
      }
      
      public int getFieldCount()
      {
        if (fieldBuilder_ == null) {
          return field_.size();
        }
        return fieldBuilder_.getCount();
      }
      
      public DescriptorProtos.FieldDescriptorProto getField(int index)
      {
        if (fieldBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProto)field_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProto)fieldBuilder_.getMessage(index);
      }
      
      public Builder setField(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (fieldBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFieldIsMutable();
          field_.set(index, value);
          onChanged();
        }
        else
        {
          fieldBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (fieldBuilder_ == null)
        {
          ensureFieldIsMutable();
          field_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          fieldBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addField(DescriptorProtos.FieldDescriptorProto value)
      {
        if (fieldBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFieldIsMutable();
          field_.add(value);
          onChanged();
        }
        else
        {
          fieldBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addField(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (fieldBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFieldIsMutable();
          field_.add(index, value);
          onChanged();
        }
        else
        {
          fieldBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addField(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (fieldBuilder_ == null)
        {
          ensureFieldIsMutable();
          field_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          fieldBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addField(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (fieldBuilder_ == null)
        {
          ensureFieldIsMutable();
          field_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          fieldBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllField(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
      {
        if (fieldBuilder_ == null)
        {
          ensureFieldIsMutable();
          GeneratedMessage.Builder.addAll(values, field_);
          onChanged();
        }
        else
        {
          fieldBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearField()
      {
        if (fieldBuilder_ == null)
        {
          field_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          onChanged();
        }
        else
        {
          fieldBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeField(int index)
      {
        if (fieldBuilder_ == null)
        {
          ensureFieldIsMutable();
          field_.remove(index);
          onChanged();
        }
        else
        {
          fieldBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder getFieldBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index)
      {
        if (fieldBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProtoOrBuilder)field_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProtoOrBuilder)fieldBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldOrBuilderList()
      {
        if (fieldBuilder_ != null) {
          return fieldBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(field_);
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder()
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addFieldBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getFieldFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.FieldDescriptorProto.Builder> getFieldBuilderList()
      {
        return getFieldFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getFieldFieldBuilder()
      {
        if (fieldBuilder_ == null)
        {
          fieldBuilder_ = new RepeatedFieldBuilder(field_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
          
          field_ = null;
        }
        return fieldBuilder_;
      }
      
      private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> extensionBuilder_;
      
      private void ensureExtensionIsMutable()
      {
        if ((bitField0_ & 0x4) != 4)
        {
          extension_ = new ArrayList(extension_);
          bitField0_ |= 0x4;
        }
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
      {
        if (extensionBuilder_ == null) {
          return Collections.unmodifiableList(extension_);
        }
        return extensionBuilder_.getMessageList();
      }
      
      public int getExtensionCount()
      {
        if (extensionBuilder_ == null) {
          return extension_.size();
        }
        return extensionBuilder_.getCount();
      }
      
      public DescriptorProtos.FieldDescriptorProto getExtension(int index)
      {
        if (extensionBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProto)extension_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProto)extensionBuilder_.getMessage(index);
      }
      
      public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.set(index, value);
          onChanged();
        }
        else
        {
          extensionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.add(value);
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto value)
      {
        if (extensionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionIsMutable();
          extension_.add(index, value);
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtension(int index, DescriptorProtos.FieldDescriptorProto.Builder builderForValue)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> values)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          GeneratedMessage.Builder.addAll(values, extension_);
          onChanged();
        }
        else
        {
          extensionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearExtension()
      {
        if (extensionBuilder_ == null)
        {
          extension_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFB;
          onChanged();
        }
        else
        {
          extensionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeExtension(int index)
      {
        if (extensionBuilder_ == null)
        {
          ensureExtensionIsMutable();
          extension_.remove(index);
          onChanged();
        }
        else
        {
          extensionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder getExtensionBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index)
      {
        if (extensionBuilder_ == null) {
          return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extension_.get(index);
        }
        return (DescriptorProtos.FieldDescriptorProtoOrBuilder)extensionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList()
      {
        if (extensionBuilder_ != null) {
          return extensionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(extension_);
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder()
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.FieldDescriptorProto.Builder addExtensionBuilder(int index)
      {
        return (DescriptorProtos.FieldDescriptorProto.Builder)getExtensionFieldBuilder().addBuilder(index, DescriptorProtos.FieldDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.FieldDescriptorProto.Builder> getExtensionBuilderList()
      {
        return getExtensionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.FieldDescriptorProto, DescriptorProtos.FieldDescriptorProto.Builder, DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder()
      {
        if (extensionBuilder_ == null)
        {
          extensionBuilder_ = new RepeatedFieldBuilder(extension_, (bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
          
          extension_ = null;
        }
        return extensionBuilder_;
      }
      
      private List<DescriptorProtos.DescriptorProto> nestedType_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> nestedTypeBuilder_;
      
      private void ensureNestedTypeIsMutable()
      {
        if ((bitField0_ & 0x8) != 8)
        {
          nestedType_ = new ArrayList(nestedType_);
          bitField0_ |= 0x8;
        }
      }
      
      public List<DescriptorProtos.DescriptorProto> getNestedTypeList()
      {
        if (nestedTypeBuilder_ == null) {
          return Collections.unmodifiableList(nestedType_);
        }
        return nestedTypeBuilder_.getMessageList();
      }
      
      public int getNestedTypeCount()
      {
        if (nestedTypeBuilder_ == null) {
          return nestedType_.size();
        }
        return nestedTypeBuilder_.getCount();
      }
      
      public DescriptorProtos.DescriptorProto getNestedType(int index)
      {
        if (nestedTypeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProto)nestedType_.get(index);
        }
        return (DescriptorProtos.DescriptorProto)nestedTypeBuilder_.getMessage(index);
      }
      
      public Builder setNestedType(int index, DescriptorProtos.DescriptorProto value)
      {
        if (nestedTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNestedTypeIsMutable();
          nestedType_.set(index, value);
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setNestedType(int index, Builder builderForValue)
      {
        if (nestedTypeBuilder_ == null)
        {
          ensureNestedTypeIsMutable();
          nestedType_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addNestedType(DescriptorProtos.DescriptorProto value)
      {
        if (nestedTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNestedTypeIsMutable();
          nestedType_.add(value);
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addNestedType(int index, DescriptorProtos.DescriptorProto value)
      {
        if (nestedTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNestedTypeIsMutable();
          nestedType_.add(index, value);
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addNestedType(Builder builderForValue)
      {
        if (nestedTypeBuilder_ == null)
        {
          ensureNestedTypeIsMutable();
          nestedType_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addNestedType(int index, Builder builderForValue)
      {
        if (nestedTypeBuilder_ == null)
        {
          ensureNestedTypeIsMutable();
          nestedType_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllNestedType(Iterable<? extends DescriptorProtos.DescriptorProto> values)
      {
        if (nestedTypeBuilder_ == null)
        {
          ensureNestedTypeIsMutable();
          GeneratedMessage.Builder.addAll(values, nestedType_);
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearNestedType()
      {
        if (nestedTypeBuilder_ == null)
        {
          nestedType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFF7;
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeNestedType(int index)
      {
        if (nestedTypeBuilder_ == null)
        {
          ensureNestedTypeIsMutable();
          nestedType_.remove(index);
          onChanged();
        }
        else
        {
          nestedTypeBuilder_.remove(index);
        }
        return this;
      }
      
      public Builder getNestedTypeBuilder(int index)
      {
        return (Builder)getNestedTypeFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index)
      {
        if (nestedTypeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProtoOrBuilder)nestedType_.get(index);
        }
        return (DescriptorProtos.DescriptorProtoOrBuilder)nestedTypeBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeOrBuilderList()
      {
        if (nestedTypeBuilder_ != null) {
          return nestedTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(nestedType_);
      }
      
      public Builder addNestedTypeBuilder()
      {
        return (Builder)getNestedTypeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.getDefaultInstance());
      }
      
      public Builder addNestedTypeBuilder(int index)
      {
        return (Builder)getNestedTypeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.getDefaultInstance());
      }
      
      public List<Builder> getNestedTypeBuilderList()
      {
        return getNestedTypeFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto, Builder, DescriptorProtos.DescriptorProtoOrBuilder> getNestedTypeFieldBuilder()
      {
        if (nestedTypeBuilder_ == null)
        {
          nestedTypeBuilder_ = new RepeatedFieldBuilder(nestedType_, (bitField0_ & 0x8) == 8, getParentForChildren(), isClean());
          
          nestedType_ = null;
        }
        return nestedTypeBuilder_;
      }
      
      private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
      
      private void ensureEnumTypeIsMutable()
      {
        if ((bitField0_ & 0x10) != 16)
        {
          enumType_ = new ArrayList(enumType_);
          bitField0_ |= 0x10;
        }
      }
      
      public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
      {
        if (enumTypeBuilder_ == null) {
          return Collections.unmodifiableList(enumType_);
        }
        return enumTypeBuilder_.getMessageList();
      }
      
      public int getEnumTypeCount()
      {
        if (enumTypeBuilder_ == null) {
          return enumType_.size();
        }
        return enumTypeBuilder_.getCount();
      }
      
      public DescriptorProtos.EnumDescriptorProto getEnumType(int index)
      {
        if (enumTypeBuilder_ == null) {
          return (DescriptorProtos.EnumDescriptorProto)enumType_.get(index);
        }
        return (DescriptorProtos.EnumDescriptorProto)enumTypeBuilder_.getMessage(index);
      }
      
      public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.set(index, value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.add(value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto value)
      {
        if (enumTypeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureEnumTypeIsMutable();
          enumType_.add(index, value);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addEnumType(int index, DescriptorProtos.EnumDescriptorProto.Builder builderForValue)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> values)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          GeneratedMessage.Builder.addAll(values, enumType_);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearEnumType()
      {
        if (enumTypeBuilder_ == null)
        {
          enumType_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFEF;
          onChanged();
        }
        else
        {
          enumTypeBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeEnumType(int index)
      {
        if (enumTypeBuilder_ == null)
        {
          ensureEnumTypeIsMutable();
          enumType_.remove(index);
          onChanged();
        }
        else
        {
          enumTypeBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder getEnumTypeBuilder(int index)
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index)
      {
        if (enumTypeBuilder_ == null) {
          return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumType_.get(index);
        }
        return (DescriptorProtos.EnumDescriptorProtoOrBuilder)enumTypeBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList()
      {
        if (enumTypeBuilder_ != null) {
          return enumTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(enumType_);
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder()
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.EnumDescriptorProto.Builder addEnumTypeBuilder(int index)
      {
        return (DescriptorProtos.EnumDescriptorProto.Builder)getEnumTypeFieldBuilder().addBuilder(index, DescriptorProtos.EnumDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.EnumDescriptorProto.Builder> getEnumTypeBuilderList()
      {
        return getEnumTypeFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.EnumDescriptorProto, DescriptorProtos.EnumDescriptorProto.Builder, DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder()
      {
        if (enumTypeBuilder_ == null)
        {
          enumTypeBuilder_ = new RepeatedFieldBuilder(enumType_, (bitField0_ & 0x10) == 16, getParentForChildren(), isClean());
          
          enumType_ = null;
        }
        return enumTypeBuilder_;
      }
      
      private List<DescriptorProtos.DescriptorProto.ExtensionRange> extensionRange_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> extensionRangeBuilder_;
      
      private void ensureExtensionRangeIsMutable()
      {
        if ((bitField0_ & 0x20) != 32)
        {
          extensionRange_ = new ArrayList(extensionRange_);
          bitField0_ |= 0x20;
        }
      }
      
      public List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList()
      {
        if (extensionRangeBuilder_ == null) {
          return Collections.unmodifiableList(extensionRange_);
        }
        return extensionRangeBuilder_.getMessageList();
      }
      
      public int getExtensionRangeCount()
      {
        if (extensionRangeBuilder_ == null) {
          return extensionRange_.size();
        }
        return extensionRangeBuilder_.getCount();
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int index)
      {
        if (extensionRangeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRange_.get(index);
        }
        return (DescriptorProtos.DescriptorProto.ExtensionRange)extensionRangeBuilder_.getMessage(index);
      }
      
      public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
      {
        if (extensionRangeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionRangeIsMutable();
          extensionRange_.set(index, value);
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
      {
        if (extensionRangeBuilder_ == null)
        {
          ensureExtensionRangeIsMutable();
          extensionRange_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange value)
      {
        if (extensionRangeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionRangeIsMutable();
          extensionRange_.add(value);
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange value)
      {
        if (extensionRangeBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureExtensionRangeIsMutable();
          extensionRange_.add(index, value);
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
      {
        if (extensionRangeBuilder_ == null)
        {
          ensureExtensionRangeIsMutable();
          extensionRange_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addExtensionRange(int index, DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderForValue)
      {
        if (extensionRangeBuilder_ == null)
        {
          ensureExtensionRangeIsMutable();
          extensionRange_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllExtensionRange(Iterable<? extends DescriptorProtos.DescriptorProto.ExtensionRange> values)
      {
        if (extensionRangeBuilder_ == null)
        {
          ensureExtensionRangeIsMutable();
          GeneratedMessage.Builder.addAll(values, extensionRange_);
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearExtensionRange()
      {
        if (extensionRangeBuilder_ == null)
        {
          extensionRange_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFDF;
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeExtensionRange(int index)
      {
        if (extensionRangeBuilder_ == null)
        {
          ensureExtensionRangeIsMutable();
          extensionRange_.remove(index);
          onChanged();
        }
        else
        {
          extensionRangeBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange.Builder getExtensionRangeBuilder(int index)
      {
        return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index)
      {
        if (extensionRangeBuilder_ == null) {
          return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRange_.get(index);
        }
        return (DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder)extensionRangeBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList()
      {
        if (extensionRangeBuilder_ != null) {
          return extensionRangeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(extensionRange_);
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder()
      {
        return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange.Builder addExtensionRangeBuilder(int index)
      {
        return (DescriptorProtos.DescriptorProto.ExtensionRange.Builder)getExtensionRangeFieldBuilder().addBuilder(index, DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance());
      }
      
      public List<DescriptorProtos.DescriptorProto.ExtensionRange.Builder> getExtensionRangeBuilderList()
      {
        return getExtensionRangeFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.DescriptorProto.ExtensionRange, DescriptorProtos.DescriptorProto.ExtensionRange.Builder, DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeFieldBuilder()
      {
        if (extensionRangeBuilder_ == null)
        {
          extensionRangeBuilder_ = new RepeatedFieldBuilder(extensionRange_, (bitField0_ & 0x20) == 32, getParentForChildren(), isClean());
          
          extensionRange_ = null;
        }
        return extensionRangeBuilder_;
      }
      
      private DescriptorProtos.MessageOptions options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x40) == 64;
      }
      
      public DescriptorProtos.MessageOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.MessageOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.MessageOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x40;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MessageOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x40;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.MessageOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x40) == 64) && (options_ != DescriptorProtos.MessageOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.MessageOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x40;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFBF;
        return this;
      }
      
      public DescriptorProtos.MessageOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x40;
        onChanged();
        return (DescriptorProtos.MessageOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.MessageOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.MessageOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.MessageOptions, DescriptorProtos.MessageOptions.Builder, DescriptorProtos.MessageOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new DescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface FieldDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract boolean hasNumber();
    
    public abstract int getNumber();
    
    public abstract boolean hasLabel();
    
    public abstract DescriptorProtos.FieldDescriptorProto.Label getLabel();
    
    public abstract boolean hasType();
    
    public abstract DescriptorProtos.FieldDescriptorProto.Type getType();
    
    public abstract boolean hasTypeName();
    
    public abstract String getTypeName();
    
    public abstract ByteString getTypeNameBytes();
    
    public abstract boolean hasExtendee();
    
    public abstract String getExtendee();
    
    public abstract ByteString getExtendeeBytes();
    
    public abstract boolean hasDefaultValue();
    
    public abstract String getDefaultValue();
    
    public abstract ByteString getDefaultValueBytes();
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.FieldOptions getOptions();
    
    public abstract DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class FieldDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.FieldDescriptorProtoOrBuilder
  {
    private static final FieldDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private FieldDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private FieldDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static FieldDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public FieldDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private FieldDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            bitField0_ |= 0x20;
            extendee_ = input.readBytes();
            break;
          case 24: 
            bitField0_ |= 0x2;
            number_ = input.readInt32();
            break;
          case 32: 
            int rawValue = input.readEnum();
            Label value = Label.valueOf(rawValue);
            if (value == null)
            {
              unknownFields.mergeVarintField(4, rawValue);
            }
            else
            {
              bitField0_ |= 0x4;
              label_ = value;
            }
            break;
          case 40: 
            int rawValue = input.readEnum();
            Type value = Type.valueOf(rawValue);
            if (value == null)
            {
              unknownFields.mergeVarintField(5, rawValue);
            }
            else
            {
              bitField0_ |= 0x8;
              type_ = value;
            }
            break;
          case 50: 
            bitField0_ |= 0x10;
            typeName_ = input.readBytes();
            break;
          case 58: 
            bitField0_ |= 0x40;
            defaultValue_ = input.readBytes();
            break;
          case 66: 
            DescriptorProtos.FieldOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x80) == 128) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.FieldOptions)input.readMessage(DescriptorProtos.FieldOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x80;
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
      return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldDescriptorProto.class, Builder.class);
    }
    
    public static Parser<FieldDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.FieldDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.FieldDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int NUMBER_FIELD_NUMBER = 3;
    private int number_;
    public static final int LABEL_FIELD_NUMBER = 4;
    private Label label_;
    public static final int TYPE_FIELD_NUMBER = 5;
    private Type type_;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private Object typeName_;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    private Object extendee_;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    private Object defaultValue_;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private DescriptorProtos.FieldOptions options_;
    
    public Parser<FieldDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public static enum Type
      implements ProtocolMessageEnum
    {
      TYPE_DOUBLE(0, 1),  TYPE_FLOAT(1, 2),  TYPE_INT64(2, 3),  TYPE_UINT64(3, 4),  TYPE_INT32(4, 5),  TYPE_FIXED64(5, 6),  TYPE_FIXED32(6, 7),  TYPE_BOOL(7, 8),  TYPE_STRING(8, 9),  TYPE_GROUP(9, 10),  TYPE_MESSAGE(10, 11),  TYPE_BYTES(11, 12),  TYPE_UINT32(12, 13),  TYPE_ENUM(13, 14),  TYPE_SFIXED32(14, 15),  TYPE_SFIXED64(15, 16),  TYPE_SINT32(16, 17),  TYPE_SINT64(17, 18);
      
      public static final int TYPE_DOUBLE_VALUE = 1;
      public static final int TYPE_FLOAT_VALUE = 2;
      public static final int TYPE_INT64_VALUE = 3;
      public static final int TYPE_UINT64_VALUE = 4;
      public static final int TYPE_INT32_VALUE = 5;
      public static final int TYPE_FIXED64_VALUE = 6;
      public static final int TYPE_FIXED32_VALUE = 7;
      public static final int TYPE_BOOL_VALUE = 8;
      public static final int TYPE_STRING_VALUE = 9;
      public static final int TYPE_GROUP_VALUE = 10;
      public static final int TYPE_MESSAGE_VALUE = 11;
      public static final int TYPE_BYTES_VALUE = 12;
      public static final int TYPE_UINT32_VALUE = 13;
      public static final int TYPE_ENUM_VALUE = 14;
      public static final int TYPE_SFIXED32_VALUE = 15;
      public static final int TYPE_SFIXED64_VALUE = 16;
      public static final int TYPE_SINT32_VALUE = 17;
      public static final int TYPE_SINT64_VALUE = 18;
      
      public final int getNumber()
      {
        return value;
      }
      
      public static Type valueOf(int value)
      {
        switch (value)
        {
        case 1: 
          return TYPE_DOUBLE;
        case 2: 
          return TYPE_FLOAT;
        case 3: 
          return TYPE_INT64;
        case 4: 
          return TYPE_UINT64;
        case 5: 
          return TYPE_INT32;
        case 6: 
          return TYPE_FIXED64;
        case 7: 
          return TYPE_FIXED32;
        case 8: 
          return TYPE_BOOL;
        case 9: 
          return TYPE_STRING;
        case 10: 
          return TYPE_GROUP;
        case 11: 
          return TYPE_MESSAGE;
        case 12: 
          return TYPE_BYTES;
        case 13: 
          return TYPE_UINT32;
        case 14: 
          return TYPE_ENUM;
        case 15: 
          return TYPE_SFIXED32;
        case 16: 
          return TYPE_SFIXED64;
        case 17: 
          return TYPE_SINT32;
        case 18: 
          return TYPE_SINT64;
        }
        return null;
      }
      
      public static Internal.EnumLiteMap<Type> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap()
      {
        public DescriptorProtos.FieldDescriptorProto.Type findValueByNumber(int number)
        {
          return DescriptorProtos.FieldDescriptorProto.Type.valueOf(number);
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
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final Type[] VALUES = values();
      private final int index;
      private final int value;
      
      public static Type valueOf(Descriptors.EnumValueDescriptor desc)
      {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private Type(int index, int value)
      {
        this.index = index;
        this.value = value;
      }
    }
    
    public static enum Label
      implements ProtocolMessageEnum
    {
      LABEL_OPTIONAL(0, 1),  LABEL_REQUIRED(1, 2),  LABEL_REPEATED(2, 3);
      
      public static final int LABEL_OPTIONAL_VALUE = 1;
      public static final int LABEL_REQUIRED_VALUE = 2;
      public static final int LABEL_REPEATED_VALUE = 3;
      
      public final int getNumber()
      {
        return value;
      }
      
      public static Label valueOf(int value)
      {
        switch (value)
        {
        case 1: 
          return LABEL_OPTIONAL;
        case 2: 
          return LABEL_REQUIRED;
        case 3: 
          return LABEL_REPEATED;
        }
        return null;
      }
      
      public static Internal.EnumLiteMap<Label> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      private static Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap()
      {
        public DescriptorProtos.FieldDescriptorProto.Label findValueByNumber(int number)
        {
          return DescriptorProtos.FieldDescriptorProto.Label.valueOf(number);
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
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
      }
      
      private static final Label[] VALUES = values();
      private final int index;
      private final int value;
      
      public static Label valueOf(Descriptors.EnumValueDescriptor desc)
      {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private Label(int index, int value)
      {
        this.index = index;
        this.value = value;
      }
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasNumber()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public int getNumber()
    {
      return number_;
    }
    
    public boolean hasLabel()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public Label getLabel()
    {
      return label_;
    }
    
    public boolean hasType()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public Type getType()
    {
      return type_;
    }
    
    public boolean hasTypeName()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public String getTypeName()
    {
      Object ref = typeName_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        typeName_ = s;
      }
      return s;
    }
    
    public ByteString getTypeNameBytes()
    {
      Object ref = typeName_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        typeName_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasExtendee()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public String getExtendee()
    {
      Object ref = extendee_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        extendee_ = s;
      }
      return s;
    }
    
    public ByteString getExtendeeBytes()
    {
      Object ref = extendee_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        extendee_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasDefaultValue()
    {
      return (bitField0_ & 0x40) == 64;
    }
    
    public String getDefaultValue()
    {
      Object ref = defaultValue_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        defaultValue_ = s;
      }
      return s;
    }
    
    public ByteString getDefaultValueBytes()
    {
      Object ref = defaultValue_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        defaultValue_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x80) == 128;
    }
    
    public DescriptorProtos.FieldOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      number_ = 0;
      label_ = Label.LABEL_OPTIONAL;
      type_ = Type.TYPE_DOUBLE;
      typeName_ = "";
      extendee_ = "";
      defaultValue_ = "";
      options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      if ((bitField0_ & 0x20) == 32) {
        output.writeBytes(2, getExtendeeBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeInt32(3, number_);
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeEnum(4, label_.getNumber());
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeEnum(5, type_.getNumber());
      }
      if ((bitField0_ & 0x10) == 16) {
        output.writeBytes(6, getTypeNameBytes());
      }
      if ((bitField0_ & 0x40) == 64) {
        output.writeBytes(7, getDefaultValueBytes());
      }
      if ((bitField0_ & 0x80) == 128) {
        output.writeMessage(8, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      if ((bitField0_ & 0x20) == 32) {
        size += CodedOutputStream.computeBytesSize(2, getExtendeeBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeInt32Size(3, number_);
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeEnumSize(4, label_.getNumber());
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeEnumSize(5, type_.getNumber());
      }
      if ((bitField0_ & 0x10) == 16) {
        size += CodedOutputStream.computeBytesSize(6, getTypeNameBytes());
      }
      if ((bitField0_ & 0x40) == 64) {
        size += CodedOutputStream.computeBytesSize(7, getDefaultValueBytes());
      }
      if ((bitField0_ & 0x80) == 128) {
        size += CodedOutputStream.computeMessageSize(8, options_);
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
    
    public static FieldDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FieldDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FieldDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static FieldDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static FieldDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$5100();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(FieldDescriptorProto prototype)
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
      implements DescriptorProtos.FieldDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.FieldDescriptorProto.class, Builder.class);
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
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        number_ = 0;
        bitField0_ &= 0xFFFFFFFD;
        label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        bitField0_ &= 0xFFFFFFFB;
        type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
        bitField0_ &= 0xFFFFFFF7;
        typeName_ = "";
        bitField0_ &= 0xFFFFFFEF;
        extendee_ = "";
        bitField0_ &= 0xFFFFFFDF;
        defaultValue_ = "";
        bitField0_ &= 0xFFFFFFBF;
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFF7F;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.FieldDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.FieldDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.FieldDescriptorProto build()
      {
        DescriptorProtos.FieldDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.FieldDescriptorProto buildPartial()
      {
        DescriptorProtos.FieldDescriptorProto result = new DescriptorProtos.FieldDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        number_ = number_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        label_ = label_;
        if ((from_bitField0_ & 0x8) == 8) {
          to_bitField0_ |= 0x8;
        }
        type_ = type_;
        if ((from_bitField0_ & 0x10) == 16) {
          to_bitField0_ |= 0x10;
        }
        typeName_ = typeName_;
        if ((from_bitField0_ & 0x20) == 32) {
          to_bitField0_ |= 0x20;
        }
        extendee_ = extendee_;
        if ((from_bitField0_ & 0x40) == 64) {
          to_bitField0_ |= 0x40;
        }
        defaultValue_ = defaultValue_;
        if ((from_bitField0_ & 0x80) == 128) {
          to_bitField0_ |= 0x80;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.FieldOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.FieldDescriptorProto)) {
          return mergeFrom((DescriptorProtos.FieldDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.FieldDescriptorProto other)
      {
        if (other == DescriptorProtos.FieldDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (other.hasNumber()) {
          setNumber(other.getNumber());
        }
        if (other.hasLabel()) {
          setLabel(other.getLabel());
        }
        if (other.hasType()) {
          setType(other.getType());
        }
        if (other.hasTypeName())
        {
          bitField0_ |= 0x10;
          typeName_ = typeName_;
          onChanged();
        }
        if (other.hasExtendee())
        {
          bitField0_ |= 0x20;
          extendee_ = extendee_;
          onChanged();
        }
        if (other.hasDefaultValue())
        {
          bitField0_ |= 0x40;
          defaultValue_ = defaultValue_;
          onChanged();
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.FieldDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.FieldDescriptorProto)DescriptorProtos.FieldDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.FieldDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      private int number_;
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasNumber()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public int getNumber()
      {
        return number_;
      }
      
      public Builder setNumber(int value)
      {
        bitField0_ |= 0x2;
        number_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearNumber()
      {
        bitField0_ &= 0xFFFFFFFD;
        number_ = 0;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.FieldDescriptorProto.Label label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
      
      public boolean hasLabel()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Label getLabel()
      {
        return label_;
      }
      
      public Builder setLabel(DescriptorProtos.FieldDescriptorProto.Label value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x4;
        label_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearLabel()
      {
        bitField0_ &= 0xFFFFFFFB;
        label_ = DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.FieldDescriptorProto.Type type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
      
      public boolean hasType()
      {
        return (bitField0_ & 0x8) == 8;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Type getType()
      {
        return type_;
      }
      
      public Builder setType(DescriptorProtos.FieldDescriptorProto.Type value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x8;
        type_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearType()
      {
        bitField0_ &= 0xFFFFFFF7;
        type_ = DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE;
        onChanged();
        return this;
      }
      
      private Object typeName_ = "";
      
      public boolean hasTypeName()
      {
        return (bitField0_ & 0x10) == 16;
      }
      
      public String getTypeName()
      {
        Object ref = typeName_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          typeName_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getTypeNameBytes()
      {
        Object ref = typeName_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          typeName_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setTypeName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x10;
        typeName_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearTypeName()
      {
        bitField0_ &= 0xFFFFFFEF;
        typeName_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getTypeName();
        onChanged();
        return this;
      }
      
      public Builder setTypeNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x10;
        typeName_ = value;
        onChanged();
        return this;
      }
      
      private Object extendee_ = "";
      
      public boolean hasExtendee()
      {
        return (bitField0_ & 0x20) == 32;
      }
      
      public String getExtendee()
      {
        Object ref = extendee_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          extendee_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getExtendeeBytes()
      {
        Object ref = extendee_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          extendee_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setExtendee(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x20;
        extendee_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearExtendee()
      {
        bitField0_ &= 0xFFFFFFDF;
        extendee_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getExtendee();
        onChanged();
        return this;
      }
      
      public Builder setExtendeeBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x20;
        extendee_ = value;
        onChanged();
        return this;
      }
      
      private Object defaultValue_ = "";
      
      public boolean hasDefaultValue()
      {
        return (bitField0_ & 0x40) == 64;
      }
      
      public String getDefaultValue()
      {
        Object ref = defaultValue_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          defaultValue_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getDefaultValueBytes()
      {
        Object ref = defaultValue_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          defaultValue_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setDefaultValue(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x40;
        defaultValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearDefaultValue()
      {
        bitField0_ &= 0xFFFFFFBF;
        defaultValue_ = DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getDefaultValue();
        onChanged();
        return this;
      }
      
      public Builder setDefaultValueBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x40;
        defaultValue_ = value;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.FieldOptions options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x80) == 128;
      }
      
      public DescriptorProtos.FieldOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.FieldOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.FieldOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x80;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FieldOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x80;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.FieldOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x80) == 128) && (options_ != DescriptorProtos.FieldOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.FieldOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x80;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFF7F;
        return this;
      }
      
      public DescriptorProtos.FieldOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x80;
        onChanged();
        return (DescriptorProtos.FieldOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.FieldOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.FieldOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.FieldOptions, DescriptorProtos.FieldOptions.Builder, DescriptorProtos.FieldOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new FieldDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface EnumDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract List<DescriptorProtos.EnumValueDescriptorProto> getValueList();
    
    public abstract DescriptorProtos.EnumValueDescriptorProto getValue(int paramInt);
    
    public abstract int getValueCount();
    
    public abstract List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList();
    
    public abstract DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int paramInt);
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.EnumOptions getOptions();
    
    public abstract DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class EnumDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.EnumDescriptorProtoOrBuilder
  {
    private static final EnumDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private EnumDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private EnumDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static EnumDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public EnumDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private EnumDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            if ((mutable_bitField0_ & 0x2) != 2)
            {
              value_ = new ArrayList();
              mutable_bitField0_ |= 0x2;
            }
            value_.add(input.readMessage(DescriptorProtos.EnumValueDescriptorProto.PARSER, extensionRegistry));
            break;
          case 26: 
            DescriptorProtos.EnumOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x2) == 2) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.EnumOptions)input.readMessage(DescriptorProtos.EnumOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x2;
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
        if ((mutable_bitField0_ & 0x2) == 2) {
          value_ = Collections.unmodifiableList(value_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumDescriptorProto.class, Builder.class);
    }
    
    public static Parser<EnumDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.EnumDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.EnumDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private List<DescriptorProtos.EnumValueDescriptorProto> value_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos.EnumOptions options_;
    
    public Parser<EnumDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
    {
      return value_;
    }
    
    public List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList()
    {
      return value_;
    }
    
    public int getValueCount()
    {
      return value_.size();
    }
    
    public DescriptorProtos.EnumValueDescriptorProto getValue(int index)
    {
      return (DescriptorProtos.EnumValueDescriptorProto)value_.get(index);
    }
    
    public DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index)
    {
      return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)value_.get(index);
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public DescriptorProtos.EnumOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      value_ = Collections.emptyList();
      options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getValueCount(); i++) {
        if (!getValue(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      for (int i = 0; i < value_.size(); i++) {
        output.writeMessage(2, (MessageLite)value_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeMessage(3, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      for (int i = 0; i < value_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(2, (MessageLite)value_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeMessageSize(3, options_);
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
    
    public static EnumDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static EnumDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static EnumDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$6600();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(EnumDescriptorProto prototype)
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
      implements DescriptorProtos.EnumDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.EnumDescriptorProto.class, Builder.class);
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
        if (GeneratedMessage.alwaysUseFieldBuilders)
        {
          getValueFieldBuilder();
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        if (valueBuilder_ == null)
        {
          value_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          valueBuilder_.clear();
        }
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.EnumDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.EnumDescriptorProto build()
      {
        DescriptorProtos.EnumDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.EnumDescriptorProto buildPartial()
      {
        DescriptorProtos.EnumDescriptorProto result = new DescriptorProtos.EnumDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if (valueBuilder_ == null)
        {
          if ((bitField0_ & 0x2) == 2)
          {
            value_ = Collections.unmodifiableList(value_);
            bitField0_ &= 0xFFFFFFFD;
          }
          value_ = value_;
        }
        else
        {
          value_ = valueBuilder_.build();
        }
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x2;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.EnumOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.EnumDescriptorProto)) {
          return mergeFrom((DescriptorProtos.EnumDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumDescriptorProto other)
      {
        if (other == DescriptorProtos.EnumDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (valueBuilder_ == null)
        {
          if (!value_.isEmpty())
          {
            if (value_.isEmpty())
            {
              value_ = value_;
              bitField0_ &= 0xFFFFFFFD;
            }
            else
            {
              ensureValueIsMutable();
              value_.addAll(value_);
            }
            onChanged();
          }
        }
        else if (!value_.isEmpty()) {
          if (valueBuilder_.isEmpty())
          {
            valueBuilder_.dispose();
            valueBuilder_ = null;
            value_ = value_;
            bitField0_ &= 0xFFFFFFFD;
            valueBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getValueFieldBuilder() : null);
          }
          else
          {
            valueBuilder_.addAllMessages(value_);
          }
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getValueCount(); i++) {
          if (!getValue(i).isInitialized()) {
            return false;
          }
        }
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.EnumDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.EnumDescriptorProto)DescriptorProtos.EnumDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.EnumDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.EnumDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.EnumValueDescriptorProto> value_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> valueBuilder_;
      
      private void ensureValueIsMutable()
      {
        if ((bitField0_ & 0x2) != 2)
        {
          value_ = new ArrayList(value_);
          bitField0_ |= 0x2;
        }
      }
      
      public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
      {
        if (valueBuilder_ == null) {
          return Collections.unmodifiableList(value_);
        }
        return valueBuilder_.getMessageList();
      }
      
      public int getValueCount()
      {
        if (valueBuilder_ == null) {
          return value_.size();
        }
        return valueBuilder_.getCount();
      }
      
      public DescriptorProtos.EnumValueDescriptorProto getValue(int index)
      {
        if (valueBuilder_ == null) {
          return (DescriptorProtos.EnumValueDescriptorProto)value_.get(index);
        }
        return (DescriptorProtos.EnumValueDescriptorProto)valueBuilder_.getMessage(index);
      }
      
      public Builder setValue(int index, DescriptorProtos.EnumValueDescriptorProto value)
      {
        if (valueBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValueIsMutable();
          value_.set(index, value);
          onChanged();
        }
        else
        {
          valueBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setValue(int index, DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
      {
        if (valueBuilder_ == null)
        {
          ensureValueIsMutable();
          value_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          valueBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addValue(DescriptorProtos.EnumValueDescriptorProto value)
      {
        if (valueBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValueIsMutable();
          value_.add(value);
          onChanged();
        }
        else
        {
          valueBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addValue(int index, DescriptorProtos.EnumValueDescriptorProto value)
      {
        if (valueBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureValueIsMutable();
          value_.add(index, value);
          onChanged();
        }
        else
        {
          valueBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addValue(DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
      {
        if (valueBuilder_ == null)
        {
          ensureValueIsMutable();
          value_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          valueBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addValue(int index, DescriptorProtos.EnumValueDescriptorProto.Builder builderForValue)
      {
        if (valueBuilder_ == null)
        {
          ensureValueIsMutable();
          value_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          valueBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllValue(Iterable<? extends DescriptorProtos.EnumValueDescriptorProto> values)
      {
        if (valueBuilder_ == null)
        {
          ensureValueIsMutable();
          GeneratedMessage.Builder.addAll(values, value_);
          onChanged();
        }
        else
        {
          valueBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearValue()
      {
        if (valueBuilder_ == null)
        {
          value_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          onChanged();
        }
        else
        {
          valueBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeValue(int index)
      {
        if (valueBuilder_ == null)
        {
          ensureValueIsMutable();
          value_.remove(index);
          onChanged();
        }
        else
        {
          valueBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.EnumValueDescriptorProto.Builder getValueBuilder(int index)
      {
        return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index)
      {
        if (valueBuilder_ == null) {
          return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)value_.get(index);
        }
        return (DescriptorProtos.EnumValueDescriptorProtoOrBuilder)valueBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList()
      {
        if (valueBuilder_ != null) {
          return valueBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(value_);
      }
      
      public DescriptorProtos.EnumValueDescriptorProto.Builder addValueBuilder()
      {
        return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().addBuilder(DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.EnumValueDescriptorProto.Builder addValueBuilder(int index)
      {
        return (DescriptorProtos.EnumValueDescriptorProto.Builder)getValueFieldBuilder().addBuilder(index, DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.EnumValueDescriptorProto.Builder> getValueBuilderList()
      {
        return getValueFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.EnumValueDescriptorProto, DescriptorProtos.EnumValueDescriptorProto.Builder, DescriptorProtos.EnumValueDescriptorProtoOrBuilder> getValueFieldBuilder()
      {
        if (valueBuilder_ == null)
        {
          valueBuilder_ = new RepeatedFieldBuilder(value_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
          
          value_ = null;
        }
        return valueBuilder_;
      }
      
      private DescriptorProtos.EnumOptions options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public DescriptorProtos.EnumOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.EnumOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.EnumOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.EnumOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.EnumOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.EnumOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public DescriptorProtos.EnumOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x4;
        onChanged();
        return (DescriptorProtos.EnumOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.EnumOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.EnumOptions, DescriptorProtos.EnumOptions.Builder, DescriptorProtos.EnumOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new EnumDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface EnumValueDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract boolean hasNumber();
    
    public abstract int getNumber();
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.EnumValueOptions getOptions();
    
    public abstract DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class EnumValueDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
  {
    private static final EnumValueDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private EnumValueDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private EnumValueDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static EnumValueDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public EnumValueDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private EnumValueDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 16: 
            bitField0_ |= 0x2;
            number_ = input.readInt32();
            break;
          case 26: 
            DescriptorProtos.EnumValueOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x4) == 4) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.EnumValueOptions)input.readMessage(DescriptorProtos.EnumValueOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x4;
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
      return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValueDescriptorProto.class, Builder.class);
    }
    
    public static Parser<EnumValueDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.EnumValueDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.EnumValueDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private int number_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos.EnumValueOptions options_;
    
    public Parser<EnumValueDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasNumber()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public int getNumber()
    {
      return number_;
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public DescriptorProtos.EnumValueOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      number_ = 0;
      options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeInt32(2, number_);
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeMessage(3, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeInt32Size(2, number_);
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeMessageSize(3, options_);
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
    
    public static EnumValueDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumValueDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumValueDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static EnumValueDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$7600();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(EnumValueDescriptorProto prototype)
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
      implements DescriptorProtos.EnumValueDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.EnumValueDescriptorProto.class, Builder.class);
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
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        number_ = 0;
        bitField0_ &= 0xFFFFFFFD;
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.EnumValueDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.EnumValueDescriptorProto build()
      {
        DescriptorProtos.EnumValueDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.EnumValueDescriptorProto buildPartial()
      {
        DescriptorProtos.EnumValueDescriptorProto result = new DescriptorProtos.EnumValueDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        number_ = number_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.EnumValueOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.EnumValueDescriptorProto)) {
          return mergeFrom((DescriptorProtos.EnumValueDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumValueDescriptorProto other)
      {
        if (other == DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (other.hasNumber()) {
          setNumber(other.getNumber());
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.EnumValueDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.EnumValueDescriptorProto)DescriptorProtos.EnumValueDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.EnumValueDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      private int number_;
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasNumber()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public int getNumber()
      {
        return number_;
      }
      
      public Builder setNumber(int value)
      {
        bitField0_ |= 0x2;
        number_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearNumber()
      {
        bitField0_ &= 0xFFFFFFFD;
        number_ = 0;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.EnumValueOptions options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public DescriptorProtos.EnumValueOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.EnumValueOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.EnumValueOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumValueOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.EnumValueOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.EnumValueOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.EnumValueOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public DescriptorProtos.EnumValueOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x4;
        onChanged();
        return (DescriptorProtos.EnumValueOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.EnumValueOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.EnumValueOptions, DescriptorProtos.EnumValueOptions.Builder, DescriptorProtos.EnumValueOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new EnumValueDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface ServiceDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract List<DescriptorProtos.MethodDescriptorProto> getMethodList();
    
    public abstract DescriptorProtos.MethodDescriptorProto getMethod(int paramInt);
    
    public abstract int getMethodCount();
    
    public abstract List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList();
    
    public abstract DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int paramInt);
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.ServiceOptions getOptions();
    
    public abstract DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class ServiceDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
  {
    private static final ServiceDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private ServiceDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private ServiceDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static ServiceDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public ServiceDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private ServiceDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            if ((mutable_bitField0_ & 0x2) != 2)
            {
              method_ = new ArrayList();
              mutable_bitField0_ |= 0x2;
            }
            method_.add(input.readMessage(DescriptorProtos.MethodDescriptorProto.PARSER, extensionRegistry));
            break;
          case 26: 
            DescriptorProtos.ServiceOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x2) == 2) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.ServiceOptions)input.readMessage(DescriptorProtos.ServiceOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x2;
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
        if ((mutable_bitField0_ & 0x2) == 2) {
          method_ = Collections.unmodifiableList(method_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ServiceDescriptorProto.class, Builder.class);
    }
    
    public static Parser<ServiceDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.ServiceDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.ServiceDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int METHOD_FIELD_NUMBER = 2;
    private List<DescriptorProtos.MethodDescriptorProto> method_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos.ServiceOptions options_;
    
    public Parser<ServiceDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
    {
      return method_;
    }
    
    public List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList()
    {
      return method_;
    }
    
    public int getMethodCount()
    {
      return method_.size();
    }
    
    public DescriptorProtos.MethodDescriptorProto getMethod(int index)
    {
      return (DescriptorProtos.MethodDescriptorProto)method_.get(index);
    }
    
    public DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index)
    {
      return (DescriptorProtos.MethodDescriptorProtoOrBuilder)method_.get(index);
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public DescriptorProtos.ServiceOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      method_ = Collections.emptyList();
      options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getMethodCount(); i++) {
        if (!getMethod(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      for (int i = 0; i < method_.size(); i++) {
        output.writeMessage(2, (MessageLite)method_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeMessage(3, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      for (int i = 0; i < method_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(2, (MessageLite)method_.get(i));
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeMessageSize(3, options_);
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
    
    public static ServiceDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ServiceDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ServiceDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static ServiceDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static ServiceDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$8600();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(ServiceDescriptorProto prototype)
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
      implements DescriptorProtos.ServiceDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.ServiceDescriptorProto.class, Builder.class);
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
        if (GeneratedMessage.alwaysUseFieldBuilders)
        {
          getMethodFieldBuilder();
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        if (methodBuilder_ == null)
        {
          method_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          methodBuilder_.clear();
        }
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.ServiceDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.ServiceDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.ServiceDescriptorProto build()
      {
        DescriptorProtos.ServiceDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.ServiceDescriptorProto buildPartial()
      {
        DescriptorProtos.ServiceDescriptorProto result = new DescriptorProtos.ServiceDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if (methodBuilder_ == null)
        {
          if ((bitField0_ & 0x2) == 2)
          {
            method_ = Collections.unmodifiableList(method_);
            bitField0_ &= 0xFFFFFFFD;
          }
          method_ = method_;
        }
        else
        {
          method_ = methodBuilder_.build();
        }
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x2;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.ServiceOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.ServiceDescriptorProto)) {
          return mergeFrom((DescriptorProtos.ServiceDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.ServiceDescriptorProto other)
      {
        if (other == DescriptorProtos.ServiceDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (methodBuilder_ == null)
        {
          if (!method_.isEmpty())
          {
            if (method_.isEmpty())
            {
              method_ = method_;
              bitField0_ &= 0xFFFFFFFD;
            }
            else
            {
              ensureMethodIsMutable();
              method_.addAll(method_);
            }
            onChanged();
          }
        }
        else if (!method_.isEmpty()) {
          if (methodBuilder_.isEmpty())
          {
            methodBuilder_.dispose();
            methodBuilder_ = null;
            method_ = method_;
            bitField0_ &= 0xFFFFFFFD;
            methodBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getMethodFieldBuilder() : null);
          }
          else
          {
            methodBuilder_.addAllMessages(method_);
          }
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getMethodCount(); i++) {
          if (!getMethod(i).isInitialized()) {
            return false;
          }
        }
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.ServiceDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.ServiceDescriptorProto)DescriptorProtos.ServiceDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.ServiceDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.ServiceDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.MethodDescriptorProto> method_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> methodBuilder_;
      
      private void ensureMethodIsMutable()
      {
        if ((bitField0_ & 0x2) != 2)
        {
          method_ = new ArrayList(method_);
          bitField0_ |= 0x2;
        }
      }
      
      public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
      {
        if (methodBuilder_ == null) {
          return Collections.unmodifiableList(method_);
        }
        return methodBuilder_.getMessageList();
      }
      
      public int getMethodCount()
      {
        if (methodBuilder_ == null) {
          return method_.size();
        }
        return methodBuilder_.getCount();
      }
      
      public DescriptorProtos.MethodDescriptorProto getMethod(int index)
      {
        if (methodBuilder_ == null) {
          return (DescriptorProtos.MethodDescriptorProto)method_.get(index);
        }
        return (DescriptorProtos.MethodDescriptorProto)methodBuilder_.getMessage(index);
      }
      
      public Builder setMethod(int index, DescriptorProtos.MethodDescriptorProto value)
      {
        if (methodBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMethodIsMutable();
          method_.set(index, value);
          onChanged();
        }
        else
        {
          methodBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setMethod(int index, DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
      {
        if (methodBuilder_ == null)
        {
          ensureMethodIsMutable();
          method_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          methodBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addMethod(DescriptorProtos.MethodDescriptorProto value)
      {
        if (methodBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMethodIsMutable();
          method_.add(value);
          onChanged();
        }
        else
        {
          methodBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addMethod(int index, DescriptorProtos.MethodDescriptorProto value)
      {
        if (methodBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMethodIsMutable();
          method_.add(index, value);
          onChanged();
        }
        else
        {
          methodBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addMethod(DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
      {
        if (methodBuilder_ == null)
        {
          ensureMethodIsMutable();
          method_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          methodBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addMethod(int index, DescriptorProtos.MethodDescriptorProto.Builder builderForValue)
      {
        if (methodBuilder_ == null)
        {
          ensureMethodIsMutable();
          method_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          methodBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllMethod(Iterable<? extends DescriptorProtos.MethodDescriptorProto> values)
      {
        if (methodBuilder_ == null)
        {
          ensureMethodIsMutable();
          GeneratedMessage.Builder.addAll(values, method_);
          onChanged();
        }
        else
        {
          methodBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearMethod()
      {
        if (methodBuilder_ == null)
        {
          method_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          onChanged();
        }
        else
        {
          methodBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeMethod(int index)
      {
        if (methodBuilder_ == null)
        {
          ensureMethodIsMutable();
          method_.remove(index);
          onChanged();
        }
        else
        {
          methodBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.MethodDescriptorProto.Builder getMethodBuilder(int index)
      {
        return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index)
      {
        if (methodBuilder_ == null) {
          return (DescriptorProtos.MethodDescriptorProtoOrBuilder)method_.get(index);
        }
        return (DescriptorProtos.MethodDescriptorProtoOrBuilder)methodBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList()
      {
        if (methodBuilder_ != null) {
          return methodBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(method_);
      }
      
      public DescriptorProtos.MethodDescriptorProto.Builder addMethodBuilder()
      {
        return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().addBuilder(DescriptorProtos.MethodDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.MethodDescriptorProto.Builder addMethodBuilder(int index)
      {
        return (DescriptorProtos.MethodDescriptorProto.Builder)getMethodFieldBuilder().addBuilder(index, DescriptorProtos.MethodDescriptorProto.getDefaultInstance());
      }
      
      public List<DescriptorProtos.MethodDescriptorProto.Builder> getMethodBuilderList()
      {
        return getMethodFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.MethodDescriptorProto, DescriptorProtos.MethodDescriptorProto.Builder, DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodFieldBuilder()
      {
        if (methodBuilder_ == null)
        {
          methodBuilder_ = new RepeatedFieldBuilder(method_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
          
          method_ = null;
        }
        return methodBuilder_;
      }
      
      private DescriptorProtos.ServiceOptions options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public DescriptorProtos.ServiceOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.ServiceOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.ServiceOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.ServiceOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.ServiceOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x4) == 4) && (options_ != DescriptorProtos.ServiceOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.ServiceOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x4;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public DescriptorProtos.ServiceOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x4;
        onChanged();
        return (DescriptorProtos.ServiceOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.ServiceOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.ServiceOptions, DescriptorProtos.ServiceOptions.Builder, DescriptorProtos.ServiceOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new ServiceDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface MethodDescriptorProtoOrBuilder
    extends MessageOrBuilder
  {
    public abstract boolean hasName();
    
    public abstract String getName();
    
    public abstract ByteString getNameBytes();
    
    public abstract boolean hasInputType();
    
    public abstract String getInputType();
    
    public abstract ByteString getInputTypeBytes();
    
    public abstract boolean hasOutputType();
    
    public abstract String getOutputType();
    
    public abstract ByteString getOutputTypeBytes();
    
    public abstract boolean hasOptions();
    
    public abstract DescriptorProtos.MethodOptions getOptions();
    
    public abstract DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder();
  }
  
  public static final class MethodDescriptorProto
    extends GeneratedMessage
    implements DescriptorProtos.MethodDescriptorProtoOrBuilder
  {
    private static final MethodDescriptorProto defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private MethodDescriptorProto(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private MethodDescriptorProto(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static MethodDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public MethodDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private MethodDescriptorProto(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            name_ = input.readBytes();
            break;
          case 18: 
            bitField0_ |= 0x2;
            inputType_ = input.readBytes();
            break;
          case 26: 
            bitField0_ |= 0x4;
            outputType_ = input.readBytes();
            break;
          case 34: 
            DescriptorProtos.MethodOptions.Builder subBuilder = null;
            if ((bitField0_ & 0x8) == 8) {
              subBuilder = options_.toBuilder();
            }
            options_ = ((DescriptorProtos.MethodOptions)input.readMessage(DescriptorProtos.MethodOptions.PARSER, extensionRegistry));
            if (subBuilder != null)
            {
              subBuilder.mergeFrom(options_);
              options_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x8;
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
      return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(MethodDescriptorProto.class, Builder.class);
    }
    
    public static Parser<MethodDescriptorProto> PARSER = new AbstractParser()
    {
      public DescriptorProtos.MethodDescriptorProto parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.MethodDescriptorProto(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private Object name_;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    private Object inputType_;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private Object outputType_;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private DescriptorProtos.MethodOptions options_;
    
    public Parser<MethodDescriptorProto> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasName()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getName()
    {
      Object ref = name_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
    
    public ByteString getNameBytes()
    {
      Object ref = name_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        name_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasInputType()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public String getInputType()
    {
      Object ref = inputType_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        inputType_ = s;
      }
      return s;
    }
    
    public ByteString getInputTypeBytes()
    {
      Object ref = inputType_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        inputType_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasOutputType()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public String getOutputType()
    {
      Object ref = outputType_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        outputType_ = s;
      }
      return s;
    }
    
    public ByteString getOutputTypeBytes()
    {
      Object ref = outputType_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        outputType_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasOptions()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public DescriptorProtos.MethodOptions getOptions()
    {
      return options_;
    }
    
    public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder()
    {
      return options_;
    }
    
    private void initFields()
    {
      name_ = "";
      inputType_ = "";
      outputType_ = "";
      options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      if ((hasOptions()) && 
        (!getOptions().isInitialized()))
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
        output.writeBytes(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBytes(2, getInputTypeBytes());
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeBytes(3, getOutputTypeBytes());
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeMessage(4, options_);
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
        size += CodedOutputStream.computeBytesSize(1, getNameBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBytesSize(2, getInputTypeBytes());
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeBytesSize(3, getOutputTypeBytes());
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeMessageSize(4, options_);
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
    
    public static MethodDescriptorProto parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MethodDescriptorProto parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(data);
    }
    
    public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MethodDescriptorProto parseFrom(InputStream input)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static MethodDescriptorProto parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseDelimitedFrom(input);
    }
    
    public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static MethodDescriptorProto parseFrom(CodedInputStream input)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(input);
    }
    
    public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodDescriptorProto)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$9600();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(MethodDescriptorProto prototype)
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
      implements DescriptorProtos.MethodDescriptorProtoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.MethodDescriptorProto.class, Builder.class);
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
          getOptionsFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        name_ = "";
        bitField0_ &= 0xFFFFFFFE;
        inputType_ = "";
        bitField0_ &= 0xFFFFFFFD;
        outputType_ = "";
        bitField0_ &= 0xFFFFFFFB;
        if (optionsBuilder_ == null) {
          options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
        } else {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFF7;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
      }
      
      public DescriptorProtos.MethodDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.MethodDescriptorProto.getDefaultInstance();
      }
      
      public DescriptorProtos.MethodDescriptorProto build()
      {
        DescriptorProtos.MethodDescriptorProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.MethodDescriptorProto buildPartial()
      {
        DescriptorProtos.MethodDescriptorProto result = new DescriptorProtos.MethodDescriptorProto(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        name_ = name_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        inputType_ = inputType_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        outputType_ = outputType_;
        if ((from_bitField0_ & 0x8) == 8) {
          to_bitField0_ |= 0x8;
        }
        if (optionsBuilder_ == null) {
          options_ = options_;
        } else {
          options_ = ((DescriptorProtos.MethodOptions)optionsBuilder_.build());
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.MethodDescriptorProto)) {
          return mergeFrom((DescriptorProtos.MethodDescriptorProto)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.MethodDescriptorProto other)
      {
        if (other == DescriptorProtos.MethodDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (other.hasName())
        {
          bitField0_ |= 0x1;
          name_ = name_;
          onChanged();
        }
        if (other.hasInputType())
        {
          bitField0_ |= 0x2;
          inputType_ = inputType_;
          onChanged();
        }
        if (other.hasOutputType())
        {
          bitField0_ |= 0x4;
          outputType_ = outputType_;
          onChanged();
        }
        if (other.hasOptions()) {
          mergeOptions(other.getOptions());
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((hasOptions()) && 
          (!getOptions().isInitialized())) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.MethodDescriptorProto parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.MethodDescriptorProto)DescriptorProtos.MethodDescriptorProto.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.MethodDescriptorProto)e.getUnfinishedMessage();
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
      
      private Object name_ = "";
      
      public boolean hasName()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getName()
      {
        Object ref = name_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          name_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getNameBytes()
      {
        Object ref = name_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          name_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setName(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearName()
      {
        bitField0_ &= 0xFFFFFFFE;
        name_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder setNameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        name_ = value;
        onChanged();
        return this;
      }
      
      private Object inputType_ = "";
      
      public boolean hasInputType()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public String getInputType()
      {
        Object ref = inputType_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          inputType_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getInputTypeBytes()
      {
        Object ref = inputType_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          inputType_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setInputType(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        inputType_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearInputType()
      {
        bitField0_ &= 0xFFFFFFFD;
        inputType_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getInputType();
        onChanged();
        return this;
      }
      
      public Builder setInputTypeBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        inputType_ = value;
        onChanged();
        return this;
      }
      
      private Object outputType_ = "";
      
      public boolean hasOutputType()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public String getOutputType()
      {
        Object ref = outputType_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          outputType_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getOutputTypeBytes()
      {
        Object ref = outputType_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          outputType_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setOutputType(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x4;
        outputType_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearOutputType()
      {
        bitField0_ &= 0xFFFFFFFB;
        outputType_ = DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getOutputType();
        onChanged();
        return this;
      }
      
      public Builder setOutputTypeBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x4;
        outputType_ = value;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.MethodOptions options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
      private SingleFieldBuilder<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> optionsBuilder_;
      
      public boolean hasOptions()
      {
        return (bitField0_ & 0x8) == 8;
      }
      
      public DescriptorProtos.MethodOptions getOptions()
      {
        if (optionsBuilder_ == null) {
          return options_;
        }
        return (DescriptorProtos.MethodOptions)optionsBuilder_.getMessage();
      }
      
      public Builder setOptions(DescriptorProtos.MethodOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          options_ = value;
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(value);
        }
        bitField0_ |= 0x8;
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MethodOptions.Builder builderForValue)
      {
        if (optionsBuilder_ == null)
        {
          options_ = builderForValue.build();
          onChanged();
        }
        else
        {
          optionsBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x8;
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.MethodOptions value)
      {
        if (optionsBuilder_ == null)
        {
          if (((bitField0_ & 0x8) == 8) && (options_ != DescriptorProtos.MethodOptions.getDefaultInstance())) {
            options_ = DescriptorProtos.MethodOptions.newBuilder(options_).mergeFrom(value).buildPartial();
          } else {
            options_ = value;
          }
          onChanged();
        }
        else
        {
          optionsBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x8;
        return this;
      }
      
      public Builder clearOptions()
      {
        if (optionsBuilder_ == null)
        {
          options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
          onChanged();
        }
        else
        {
          optionsBuilder_.clear();
        }
        bitField0_ &= 0xFFFFFFF7;
        return this;
      }
      
      public DescriptorProtos.MethodOptions.Builder getOptionsBuilder()
      {
        bitField0_ |= 0x8;
        onChanged();
        return (DescriptorProtos.MethodOptions.Builder)getOptionsFieldBuilder().getBuilder();
      }
      
      public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder()
      {
        if (optionsBuilder_ != null) {
          return (DescriptorProtos.MethodOptionsOrBuilder)optionsBuilder_.getMessageOrBuilder();
        }
        return options_;
      }
      
      private SingleFieldBuilder<DescriptorProtos.MethodOptions, DescriptorProtos.MethodOptions.Builder, DescriptorProtos.MethodOptionsOrBuilder> getOptionsFieldBuilder()
      {
        if (optionsBuilder_ == null)
        {
          optionsBuilder_ = new SingleFieldBuilder(options_, getParentForChildren(), isClean());
          
          options_ = null;
        }
        return optionsBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new MethodDescriptorProto(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface FileOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.FileOptions>
  {
    public abstract boolean hasJavaPackage();
    
    public abstract String getJavaPackage();
    
    public abstract ByteString getJavaPackageBytes();
    
    public abstract boolean hasJavaOuterClassname();
    
    public abstract String getJavaOuterClassname();
    
    public abstract ByteString getJavaOuterClassnameBytes();
    
    public abstract boolean hasJavaMultipleFiles();
    
    public abstract boolean getJavaMultipleFiles();
    
    public abstract boolean hasJavaGenerateEqualsAndHash();
    
    public abstract boolean getJavaGenerateEqualsAndHash();
    
    public abstract boolean hasOptimizeFor();
    
    public abstract DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor();
    
    public abstract boolean hasGoPackage();
    
    public abstract String getGoPackage();
    
    public abstract ByteString getGoPackageBytes();
    
    public abstract boolean hasCcGenericServices();
    
    public abstract boolean getCcGenericServices();
    
    public abstract boolean hasJavaGenericServices();
    
    public abstract boolean getJavaGenericServices();
    
    public abstract boolean hasPyGenericServices();
    
    public abstract boolean getPyGenericServices();
    
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class FileOptions
    extends GeneratedMessage.ExtendableMessage<FileOptions>
    implements DescriptorProtos.FileOptionsOrBuilder
  {
    private static final FileOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private FileOptions(GeneratedMessage.ExtendableBuilder<FileOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private FileOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static FileOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public FileOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private FileOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            bitField0_ |= 0x1;
            javaPackage_ = input.readBytes();
            break;
          case 66: 
            bitField0_ |= 0x2;
            javaOuterClassname_ = input.readBytes();
            break;
          case 72: 
            int rawValue = input.readEnum();
            OptimizeMode value = OptimizeMode.valueOf(rawValue);
            if (value == null)
            {
              unknownFields.mergeVarintField(9, rawValue);
            }
            else
            {
              bitField0_ |= 0x10;
              optimizeFor_ = value;
            }
            break;
          case 80: 
            bitField0_ |= 0x4;
            javaMultipleFiles_ = input.readBool();
            break;
          case 90: 
            bitField0_ |= 0x20;
            goPackage_ = input.readBytes();
            break;
          case 128: 
            bitField0_ |= 0x40;
            ccGenericServices_ = input.readBool();
            break;
          case 136: 
            bitField0_ |= 0x80;
            javaGenericServices_ = input.readBool();
            break;
          case 144: 
            bitField0_ |= 0x100;
            pyGenericServices_ = input.readBool();
            break;
          case 160: 
            bitField0_ |= 0x8;
            javaGenerateEqualsAndHash_ = input.readBool();
            break;
          case 7994: 
            if ((mutable_bitField0_ & 0x200) != 512)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x200;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x200) == 512) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(FileOptions.class, Builder.class);
    }
    
    public static Parser<FileOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.FileOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.FileOptions(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    private Object javaPackage_;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    private Object javaOuterClassname_;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    private boolean javaMultipleFiles_;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    private boolean javaGenerateEqualsAndHash_;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private OptimizeMode optimizeFor_;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    private Object goPackage_;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    private boolean ccGenericServices_;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    private boolean javaGenericServices_;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    private boolean pyGenericServices_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<FileOptions> getParserForType()
    {
      return PARSER;
    }
    
    public static enum OptimizeMode
      implements ProtocolMessageEnum
    {
      SPEED(0, 1),  CODE_SIZE(1, 2),  LITE_RUNTIME(2, 3);
      
      public static final int SPEED_VALUE = 1;
      public static final int CODE_SIZE_VALUE = 2;
      public static final int LITE_RUNTIME_VALUE = 3;
      
      public final int getNumber()
      {
        return value;
      }
      
      public static OptimizeMode valueOf(int value)
      {
        switch (value)
        {
        case 1: 
          return SPEED;
        case 2: 
          return CODE_SIZE;
        case 3: 
          return LITE_RUNTIME;
        }
        return null;
      }
      
      public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      private static Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap()
      {
        public DescriptorProtos.FileOptions.OptimizeMode findValueByNumber(int number)
        {
          return DescriptorProtos.FileOptions.OptimizeMode.valueOf(number);
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
        return (Descriptors.EnumDescriptor)DescriptorProtos.FileOptions.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final OptimizeMode[] VALUES = values();
      private final int index;
      private final int value;
      
      public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor desc)
      {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private OptimizeMode(int index, int value)
      {
        this.index = index;
        this.value = value;
      }
    }
    
    public boolean hasJavaPackage()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getJavaPackage()
    {
      Object ref = javaPackage_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        javaPackage_ = s;
      }
      return s;
    }
    
    public ByteString getJavaPackageBytes()
    {
      Object ref = javaPackage_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        javaPackage_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasJavaOuterClassname()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public String getJavaOuterClassname()
    {
      Object ref = javaOuterClassname_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        javaOuterClassname_ = s;
      }
      return s;
    }
    
    public ByteString getJavaOuterClassnameBytes()
    {
      Object ref = javaOuterClassname_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        javaOuterClassname_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasJavaMultipleFiles()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public boolean getJavaMultipleFiles()
    {
      return javaMultipleFiles_;
    }
    
    public boolean hasJavaGenerateEqualsAndHash()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public boolean getJavaGenerateEqualsAndHash()
    {
      return javaGenerateEqualsAndHash_;
    }
    
    public boolean hasOptimizeFor()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public OptimizeMode getOptimizeFor()
    {
      return optimizeFor_;
    }
    
    public boolean hasGoPackage()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public String getGoPackage()
    {
      Object ref = goPackage_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        goPackage_ = s;
      }
      return s;
    }
    
    public ByteString getGoPackageBytes()
    {
      Object ref = goPackage_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        goPackage_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasCcGenericServices()
    {
      return (bitField0_ & 0x40) == 64;
    }
    
    public boolean getCcGenericServices()
    {
      return ccGenericServices_;
    }
    
    public boolean hasJavaGenericServices()
    {
      return (bitField0_ & 0x80) == 128;
    }
    
    public boolean getJavaGenericServices()
    {
      return javaGenericServices_;
    }
    
    public boolean hasPyGenericServices()
    {
      return (bitField0_ & 0x100) == 256;
    }
    
    public boolean getPyGenericServices()
    {
      return pyGenericServices_;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      javaPackage_ = "";
      javaOuterClassname_ = "";
      javaMultipleFiles_ = false;
      javaGenerateEqualsAndHash_ = false;
      optimizeFor_ = OptimizeMode.SPEED;
      goPackage_ = "";
      ccGenericServices_ = false;
      javaGenericServices_ = false;
      pyGenericServices_ = false;
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<FileOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      if ((bitField0_ & 0x1) == 1) {
        output.writeBytes(1, getJavaPackageBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBytes(8, getJavaOuterClassnameBytes());
      }
      if ((bitField0_ & 0x10) == 16) {
        output.writeEnum(9, optimizeFor_.getNumber());
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeBool(10, javaMultipleFiles_);
      }
      if ((bitField0_ & 0x20) == 32) {
        output.writeBytes(11, getGoPackageBytes());
      }
      if ((bitField0_ & 0x40) == 64) {
        output.writeBool(16, ccGenericServices_);
      }
      if ((bitField0_ & 0x80) == 128) {
        output.writeBool(17, javaGenericServices_);
      }
      if ((bitField0_ & 0x100) == 256) {
        output.writeBool(18, pyGenericServices_);
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeBool(20, javaGenerateEqualsAndHash_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
        size += CodedOutputStream.computeBytesSize(1, getJavaPackageBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBytesSize(8, getJavaOuterClassnameBytes());
      }
      if ((bitField0_ & 0x10) == 16) {
        size += CodedOutputStream.computeEnumSize(9, optimizeFor_.getNumber());
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeBoolSize(10, javaMultipleFiles_);
      }
      if ((bitField0_ & 0x20) == 32) {
        size += CodedOutputStream.computeBytesSize(11, getGoPackageBytes());
      }
      if ((bitField0_ & 0x40) == 64) {
        size += CodedOutputStream.computeBoolSize(16, ccGenericServices_);
      }
      if ((bitField0_ & 0x80) == 128) {
        size += CodedOutputStream.computeBoolSize(17, javaGenericServices_);
      }
      if ((bitField0_ & 0x100) == 256) {
        size += CodedOutputStream.computeBoolSize(18, pyGenericServices_);
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeBoolSize(20, javaGenerateEqualsAndHash_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static FileOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (FileOptions)PARSER.parseFrom(data);
    }
    
    public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FileOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FileOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (FileOptions)PARSER.parseFrom(data);
    }
    
    public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FileOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FileOptions parseFrom(InputStream input)
      throws IOException
    {
      return (FileOptions)PARSER.parseFrom(input);
    }
    
    public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static FileOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (FileOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static FileOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (FileOptions)PARSER.parseFrom(input);
    }
    
    public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FileOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$10700();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(FileOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FileOptions, Builder>
      implements DescriptorProtos.FileOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.FileOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        javaPackage_ = "";
        bitField0_ &= 0xFFFFFFFE;
        javaOuterClassname_ = "";
        bitField0_ &= 0xFFFFFFFD;
        javaMultipleFiles_ = false;
        bitField0_ &= 0xFFFFFFFB;
        javaGenerateEqualsAndHash_ = false;
        bitField0_ &= 0xFFFFFFF7;
        optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
        bitField0_ &= 0xFFFFFFEF;
        goPackage_ = "";
        bitField0_ &= 0xFFFFFFDF;
        ccGenericServices_ = false;
        bitField0_ &= 0xFFFFFFBF;
        javaGenericServices_ = false;
        bitField0_ &= 0xFF7F;
        pyGenericServices_ = false;
        bitField0_ &= 0xFEFF;
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFDFF;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
      }
      
      public DescriptorProtos.FileOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.FileOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.FileOptions build()
      {
        DescriptorProtos.FileOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.FileOptions buildPartial()
      {
        DescriptorProtos.FileOptions result = new DescriptorProtos.FileOptions(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        javaPackage_ = javaPackage_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        javaOuterClassname_ = javaOuterClassname_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        javaMultipleFiles_ = javaMultipleFiles_;
        if ((from_bitField0_ & 0x8) == 8) {
          to_bitField0_ |= 0x8;
        }
        javaGenerateEqualsAndHash_ = javaGenerateEqualsAndHash_;
        if ((from_bitField0_ & 0x10) == 16) {
          to_bitField0_ |= 0x10;
        }
        optimizeFor_ = optimizeFor_;
        if ((from_bitField0_ & 0x20) == 32) {
          to_bitField0_ |= 0x20;
        }
        goPackage_ = goPackage_;
        if ((from_bitField0_ & 0x40) == 64) {
          to_bitField0_ |= 0x40;
        }
        ccGenericServices_ = ccGenericServices_;
        if ((from_bitField0_ & 0x80) == 128) {
          to_bitField0_ |= 0x80;
        }
        javaGenericServices_ = javaGenericServices_;
        if ((from_bitField0_ & 0x100) == 256) {
          to_bitField0_ |= 0x100;
        }
        pyGenericServices_ = pyGenericServices_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x200) == 512)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFDFF;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.FileOptions)) {
          return mergeFrom((DescriptorProtos.FileOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.FileOptions other)
      {
        if (other == DescriptorProtos.FileOptions.getDefaultInstance()) {
          return this;
        }
        if (other.hasJavaPackage())
        {
          bitField0_ |= 0x1;
          javaPackage_ = javaPackage_;
          onChanged();
        }
        if (other.hasJavaOuterClassname())
        {
          bitField0_ |= 0x2;
          javaOuterClassname_ = javaOuterClassname_;
          onChanged();
        }
        if (other.hasJavaMultipleFiles()) {
          setJavaMultipleFiles(other.getJavaMultipleFiles());
        }
        if (other.hasJavaGenerateEqualsAndHash()) {
          setJavaGenerateEqualsAndHash(other.getJavaGenerateEqualsAndHash());
        }
        if (other.hasOptimizeFor()) {
          setOptimizeFor(other.getOptimizeFor());
        }
        if (other.hasGoPackage())
        {
          bitField0_ |= 0x20;
          goPackage_ = goPackage_;
          onChanged();
        }
        if (other.hasCcGenericServices()) {
          setCcGenericServices(other.getCcGenericServices());
        }
        if (other.hasJavaGenericServices()) {
          setJavaGenericServices(other.getJavaGenericServices());
        }
        if (other.hasPyGenericServices()) {
          setPyGenericServices(other.getPyGenericServices());
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFDFF;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFDFF;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.FileOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.FileOptions)DescriptorProtos.FileOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.FileOptions)e.getUnfinishedMessage();
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
      
      private Object javaPackage_ = "";
      
      public boolean hasJavaPackage()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getJavaPackage()
      {
        Object ref = javaPackage_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          javaPackage_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getJavaPackageBytes()
      {
        Object ref = javaPackage_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          javaPackage_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setJavaPackage(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        javaPackage_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearJavaPackage()
      {
        bitField0_ &= 0xFFFFFFFE;
        javaPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaPackage();
        onChanged();
        return this;
      }
      
      public Builder setJavaPackageBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        javaPackage_ = value;
        onChanged();
        return this;
      }
      
      private Object javaOuterClassname_ = "";
      private boolean javaMultipleFiles_;
      private boolean javaGenerateEqualsAndHash_;
      
      public boolean hasJavaOuterClassname()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public String getJavaOuterClassname()
      {
        Object ref = javaOuterClassname_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          javaOuterClassname_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getJavaOuterClassnameBytes()
      {
        Object ref = javaOuterClassname_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          javaOuterClassname_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setJavaOuterClassname(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        javaOuterClassname_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearJavaOuterClassname()
      {
        bitField0_ &= 0xFFFFFFFD;
        javaOuterClassname_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaOuterClassname();
        onChanged();
        return this;
      }
      
      public Builder setJavaOuterClassnameBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        javaOuterClassname_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasJavaMultipleFiles()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public boolean getJavaMultipleFiles()
      {
        return javaMultipleFiles_;
      }
      
      public Builder setJavaMultipleFiles(boolean value)
      {
        bitField0_ |= 0x4;
        javaMultipleFiles_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearJavaMultipleFiles()
      {
        bitField0_ &= 0xFFFFFFFB;
        javaMultipleFiles_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasJavaGenerateEqualsAndHash()
      {
        return (bitField0_ & 0x8) == 8;
      }
      
      public boolean getJavaGenerateEqualsAndHash()
      {
        return javaGenerateEqualsAndHash_;
      }
      
      public Builder setJavaGenerateEqualsAndHash(boolean value)
      {
        bitField0_ |= 0x8;
        javaGenerateEqualsAndHash_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearJavaGenerateEqualsAndHash()
      {
        bitField0_ &= 0xFFFFFFF7;
        javaGenerateEqualsAndHash_ = false;
        onChanged();
        return this;
      }
      
      private DescriptorProtos.FileOptions.OptimizeMode optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
      
      public boolean hasOptimizeFor()
      {
        return (bitField0_ & 0x10) == 16;
      }
      
      public DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor()
      {
        return optimizeFor_;
      }
      
      public Builder setOptimizeFor(DescriptorProtos.FileOptions.OptimizeMode value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x10;
        optimizeFor_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearOptimizeFor()
      {
        bitField0_ &= 0xFFFFFFEF;
        optimizeFor_ = DescriptorProtos.FileOptions.OptimizeMode.SPEED;
        onChanged();
        return this;
      }
      
      private Object goPackage_ = "";
      private boolean ccGenericServices_;
      private boolean javaGenericServices_;
      private boolean pyGenericServices_;
      
      public boolean hasGoPackage()
      {
        return (bitField0_ & 0x20) == 32;
      }
      
      public String getGoPackage()
      {
        Object ref = goPackage_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          goPackage_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getGoPackageBytes()
      {
        Object ref = goPackage_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          goPackage_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setGoPackage(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x20;
        goPackage_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearGoPackage()
      {
        bitField0_ &= 0xFFFFFFDF;
        goPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getGoPackage();
        onChanged();
        return this;
      }
      
      public Builder setGoPackageBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x20;
        goPackage_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasCcGenericServices()
      {
        return (bitField0_ & 0x40) == 64;
      }
      
      public boolean getCcGenericServices()
      {
        return ccGenericServices_;
      }
      
      public Builder setCcGenericServices(boolean value)
      {
        bitField0_ |= 0x40;
        ccGenericServices_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearCcGenericServices()
      {
        bitField0_ &= 0xFFFFFFBF;
        ccGenericServices_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasJavaGenericServices()
      {
        return (bitField0_ & 0x80) == 128;
      }
      
      public boolean getJavaGenericServices()
      {
        return javaGenericServices_;
      }
      
      public Builder setJavaGenericServices(boolean value)
      {
        bitField0_ |= 0x80;
        javaGenericServices_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearJavaGenericServices()
      {
        bitField0_ &= 0xFF7F;
        javaGenericServices_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasPyGenericServices()
      {
        return (bitField0_ & 0x100) == 256;
      }
      
      public boolean getPyGenericServices()
      {
        return pyGenericServices_;
      }
      
      public Builder setPyGenericServices(boolean value)
      {
        bitField0_ |= 0x100;
        pyGenericServices_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearPyGenericServices()
      {
        bitField0_ &= 0xFEFF;
        pyGenericServices_ = false;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x200) != 512)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x200;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFDFF;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x200) == 512, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new FileOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface MessageOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.MessageOptions>
  {
    public abstract boolean hasMessageSetWireFormat();
    
    public abstract boolean getMessageSetWireFormat();
    
    public abstract boolean hasNoStandardDescriptorAccessor();
    
    public abstract boolean getNoStandardDescriptorAccessor();
    
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class MessageOptions
    extends GeneratedMessage.ExtendableMessage<MessageOptions>
    implements DescriptorProtos.MessageOptionsOrBuilder
  {
    private static final MessageOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private MessageOptions(GeneratedMessage.ExtendableBuilder<MessageOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private MessageOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static MessageOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public MessageOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private MessageOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            messageSetWireFormat_ = input.readBool();
            break;
          case 16: 
            bitField0_ |= 0x2;
            noStandardDescriptorAccessor_ = input.readBool();
            break;
          case 7994: 
            if ((mutable_bitField0_ & 0x4) != 4)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x4;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x4) == 4) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(MessageOptions.class, Builder.class);
    }
    
    public static Parser<MessageOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.MessageOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.MessageOptions(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    private boolean messageSetWireFormat_;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    private boolean noStandardDescriptorAccessor_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<MessageOptions> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasMessageSetWireFormat()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public boolean getMessageSetWireFormat()
    {
      return messageSetWireFormat_;
    }
    
    public boolean hasNoStandardDescriptorAccessor()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public boolean getNoStandardDescriptorAccessor()
    {
      return noStandardDescriptorAccessor_;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      messageSetWireFormat_ = false;
      noStandardDescriptorAccessor_ = false;
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<MessageOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      if ((bitField0_ & 0x1) == 1) {
        output.writeBool(1, messageSetWireFormat_);
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBool(2, noStandardDescriptorAccessor_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
        size += CodedOutputStream.computeBoolSize(1, messageSetWireFormat_);
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBoolSize(2, noStandardDescriptorAccessor_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static MessageOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (MessageOptions)PARSER.parseFrom(data);
    }
    
    public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MessageOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MessageOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (MessageOptions)PARSER.parseFrom(data);
    }
    
    public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MessageOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MessageOptions parseFrom(InputStream input)
      throws IOException
    {
      return (MessageOptions)PARSER.parseFrom(input);
    }
    
    public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MessageOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static MessageOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (MessageOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MessageOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static MessageOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (MessageOptions)PARSER.parseFrom(input);
    }
    
    public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MessageOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$12400();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(MessageOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.MessageOptions, Builder>
      implements DescriptorProtos.MessageOptionsOrBuilder
    {
      private int bitField0_;
      private boolean messageSetWireFormat_;
      private boolean noStandardDescriptorAccessor_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.MessageOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        messageSetWireFormat_ = false;
        bitField0_ &= 0xFFFFFFFE;
        noStandardDescriptorAccessor_ = false;
        bitField0_ &= 0xFFFFFFFD;
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFB;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
      }
      
      public DescriptorProtos.MessageOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.MessageOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.MessageOptions build()
      {
        DescriptorProtos.MessageOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.MessageOptions buildPartial()
      {
        DescriptorProtos.MessageOptions result = new DescriptorProtos.MessageOptions(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        messageSetWireFormat_ = messageSetWireFormat_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x4) == 4)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFFB;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.MessageOptions)) {
          return mergeFrom((DescriptorProtos.MessageOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.MessageOptions other)
      {
        if (other == DescriptorProtos.MessageOptions.getDefaultInstance()) {
          return this;
        }
        if (other.hasMessageSetWireFormat()) {
          setMessageSetWireFormat(other.getMessageSetWireFormat());
        }
        if (other.hasNoStandardDescriptorAccessor()) {
          setNoStandardDescriptorAccessor(other.getNoStandardDescriptorAccessor());
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFFB;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFB;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.MessageOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.MessageOptions)DescriptorProtos.MessageOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.MessageOptions)e.getUnfinishedMessage();
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
      
      public boolean hasMessageSetWireFormat()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public boolean getMessageSetWireFormat()
      {
        return messageSetWireFormat_;
      }
      
      public Builder setMessageSetWireFormat(boolean value)
      {
        bitField0_ |= 0x1;
        messageSetWireFormat_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearMessageSetWireFormat()
      {
        bitField0_ &= 0xFFFFFFFE;
        messageSetWireFormat_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasNoStandardDescriptorAccessor()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public boolean getNoStandardDescriptorAccessor()
      {
        return noStandardDescriptorAccessor_;
      }
      
      public Builder setNoStandardDescriptorAccessor(boolean value)
      {
        bitField0_ |= 0x2;
        noStandardDescriptorAccessor_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearNoStandardDescriptorAccessor()
      {
        bitField0_ &= 0xFFFFFFFD;
        noStandardDescriptorAccessor_ = false;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x4) != 4)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x4;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFB;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new MessageOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface FieldOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.FieldOptions>
  {
    public abstract boolean hasCtype();
    
    public abstract DescriptorProtos.FieldOptions.CType getCtype();
    
    public abstract boolean hasPacked();
    
    public abstract boolean getPacked();
    
    public abstract boolean hasLazy();
    
    public abstract boolean getLazy();
    
    public abstract boolean hasDeprecated();
    
    public abstract boolean getDeprecated();
    
    public abstract boolean hasExperimentalMapKey();
    
    public abstract String getExperimentalMapKey();
    
    public abstract ByteString getExperimentalMapKeyBytes();
    
    public abstract boolean hasWeak();
    
    public abstract boolean getWeak();
    
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class FieldOptions
    extends GeneratedMessage.ExtendableMessage<FieldOptions>
    implements DescriptorProtos.FieldOptionsOrBuilder
  {
    private static final FieldOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private FieldOptions(GeneratedMessage.ExtendableBuilder<FieldOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private FieldOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static FieldOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public FieldOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private FieldOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            int rawValue = input.readEnum();
            CType value = CType.valueOf(rawValue);
            if (value == null)
            {
              unknownFields.mergeVarintField(1, rawValue);
            }
            else
            {
              bitField0_ |= 0x1;
              ctype_ = value;
            }
            break;
          case 16: 
            bitField0_ |= 0x2;
            packed_ = input.readBool();
            break;
          case 24: 
            bitField0_ |= 0x8;
            deprecated_ = input.readBool();
            break;
          case 40: 
            bitField0_ |= 0x4;
            lazy_ = input.readBool();
            break;
          case 74: 
            bitField0_ |= 0x10;
            experimentalMapKey_ = input.readBytes();
            break;
          case 80: 
            bitField0_ |= 0x20;
            weak_ = input.readBool();
            break;
          case 7994: 
            if ((mutable_bitField0_ & 0x40) != 64)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x40;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x40) == 64) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldOptions.class, Builder.class);
    }
    
    public static Parser<FieldOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.FieldOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.FieldOptions(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int CTYPE_FIELD_NUMBER = 1;
    private CType ctype_;
    public static final int PACKED_FIELD_NUMBER = 2;
    private boolean packed_;
    public static final int LAZY_FIELD_NUMBER = 5;
    private boolean lazy_;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    private boolean deprecated_;
    public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
    private Object experimentalMapKey_;
    public static final int WEAK_FIELD_NUMBER = 10;
    private boolean weak_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<FieldOptions> getParserForType()
    {
      return PARSER;
    }
    
    public static enum CType
      implements ProtocolMessageEnum
    {
      STRING(0, 0),  CORD(1, 1),  STRING_PIECE(2, 2);
      
      public static final int STRING_VALUE = 0;
      public static final int CORD_VALUE = 1;
      public static final int STRING_PIECE_VALUE = 2;
      
      public final int getNumber()
      {
        return value;
      }
      
      public static CType valueOf(int value)
      {
        switch (value)
        {
        case 0: 
          return STRING;
        case 1: 
          return CORD;
        case 2: 
          return STRING_PIECE;
        }
        return null;
      }
      
      public static Internal.EnumLiteMap<CType> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      private static Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap()
      {
        public DescriptorProtos.FieldOptions.CType findValueByNumber(int number)
        {
          return DescriptorProtos.FieldOptions.CType.valueOf(number);
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
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final CType[] VALUES = values();
      private final int index;
      private final int value;
      
      public static CType valueOf(Descriptors.EnumValueDescriptor desc)
      {
        if (desc.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private CType(int index, int value)
      {
        this.index = index;
        this.value = value;
      }
    }
    
    public boolean hasCtype()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public CType getCtype()
    {
      return ctype_;
    }
    
    public boolean hasPacked()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public boolean getPacked()
    {
      return packed_;
    }
    
    public boolean hasLazy()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public boolean getLazy()
    {
      return lazy_;
    }
    
    public boolean hasDeprecated()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public boolean getDeprecated()
    {
      return deprecated_;
    }
    
    public boolean hasExperimentalMapKey()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public String getExperimentalMapKey()
    {
      Object ref = experimentalMapKey_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        experimentalMapKey_ = s;
      }
      return s;
    }
    
    public ByteString getExperimentalMapKeyBytes()
    {
      Object ref = experimentalMapKey_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        experimentalMapKey_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasWeak()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public boolean getWeak()
    {
      return weak_;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      ctype_ = CType.STRING;
      packed_ = false;
      lazy_ = false;
      deprecated_ = false;
      experimentalMapKey_ = "";
      weak_ = false;
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<FieldOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      if ((bitField0_ & 0x1) == 1) {
        output.writeEnum(1, ctype_.getNumber());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeBool(2, packed_);
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeBool(3, deprecated_);
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeBool(5, lazy_);
      }
      if ((bitField0_ & 0x10) == 16) {
        output.writeBytes(9, getExperimentalMapKeyBytes());
      }
      if ((bitField0_ & 0x20) == 32) {
        output.writeBool(10, weak_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
        size += CodedOutputStream.computeEnumSize(1, ctype_.getNumber());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeBoolSize(2, packed_);
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeBoolSize(3, deprecated_);
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeBoolSize(5, lazy_);
      }
      if ((bitField0_ & 0x10) == 16) {
        size += CodedOutputStream.computeBytesSize(9, getExperimentalMapKeyBytes());
      }
      if ((bitField0_ & 0x20) == 32) {
        size += CodedOutputStream.computeBoolSize(10, weak_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static FieldOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (FieldOptions)PARSER.parseFrom(data);
    }
    
    public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FieldOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FieldOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (FieldOptions)PARSER.parseFrom(data);
    }
    
    public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (FieldOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static FieldOptions parseFrom(InputStream input)
      throws IOException
    {
      return (FieldOptions)PARSER.parseFrom(input);
    }
    
    public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static FieldOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (FieldOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static FieldOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (FieldOptions)PARSER.parseFrom(input);
    }
    
    public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (FieldOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$13400();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(FieldOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FieldOptions, Builder>
      implements DescriptorProtos.FieldOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.FieldOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
        bitField0_ &= 0xFFFFFFFE;
        packed_ = false;
        bitField0_ &= 0xFFFFFFFD;
        lazy_ = false;
        bitField0_ &= 0xFFFFFFFB;
        deprecated_ = false;
        bitField0_ &= 0xFFFFFFF7;
        experimentalMapKey_ = "";
        bitField0_ &= 0xFFFFFFEF;
        weak_ = false;
        bitField0_ &= 0xFFFFFFDF;
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFBF;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
      }
      
      public DescriptorProtos.FieldOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.FieldOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.FieldOptions build()
      {
        DescriptorProtos.FieldOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.FieldOptions buildPartial()
      {
        DescriptorProtos.FieldOptions result = new DescriptorProtos.FieldOptions(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        ctype_ = ctype_;
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x2;
        }
        packed_ = packed_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x4;
        }
        lazy_ = lazy_;
        if ((from_bitField0_ & 0x8) == 8) {
          to_bitField0_ |= 0x8;
        }
        deprecated_ = deprecated_;
        if ((from_bitField0_ & 0x10) == 16) {
          to_bitField0_ |= 0x10;
        }
        experimentalMapKey_ = experimentalMapKey_;
        if ((from_bitField0_ & 0x20) == 32) {
          to_bitField0_ |= 0x20;
        }
        weak_ = weak_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x40) == 64)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFBF;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.FieldOptions)) {
          return mergeFrom((DescriptorProtos.FieldOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.FieldOptions other)
      {
        if (other == DescriptorProtos.FieldOptions.getDefaultInstance()) {
          return this;
        }
        if (other.hasCtype()) {
          setCtype(other.getCtype());
        }
        if (other.hasPacked()) {
          setPacked(other.getPacked());
        }
        if (other.hasLazy()) {
          setLazy(other.getLazy());
        }
        if (other.hasDeprecated()) {
          setDeprecated(other.getDeprecated());
        }
        if (other.hasExperimentalMapKey())
        {
          bitField0_ |= 0x10;
          experimentalMapKey_ = experimentalMapKey_;
          onChanged();
        }
        if (other.hasWeak()) {
          setWeak(other.getWeak());
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFBF;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFBF;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.FieldOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.FieldOptions)DescriptorProtos.FieldOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.FieldOptions)e.getUnfinishedMessage();
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
      
      private DescriptorProtos.FieldOptions.CType ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
      private boolean packed_;
      private boolean lazy_;
      private boolean deprecated_;
      
      public boolean hasCtype()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public DescriptorProtos.FieldOptions.CType getCtype()
      {
        return ctype_;
      }
      
      public Builder setCtype(DescriptorProtos.FieldOptions.CType value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x1;
        ctype_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearCtype()
      {
        bitField0_ &= 0xFFFFFFFE;
        ctype_ = DescriptorProtos.FieldOptions.CType.STRING;
        onChanged();
        return this;
      }
      
      public boolean hasPacked()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public boolean getPacked()
      {
        return packed_;
      }
      
      public Builder setPacked(boolean value)
      {
        bitField0_ |= 0x2;
        packed_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearPacked()
      {
        bitField0_ &= 0xFFFFFFFD;
        packed_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasLazy()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public boolean getLazy()
      {
        return lazy_;
      }
      
      public Builder setLazy(boolean value)
      {
        bitField0_ |= 0x4;
        lazy_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearLazy()
      {
        bitField0_ &= 0xFFFFFFFB;
        lazy_ = false;
        onChanged();
        return this;
      }
      
      public boolean hasDeprecated()
      {
        return (bitField0_ & 0x8) == 8;
      }
      
      public boolean getDeprecated()
      {
        return deprecated_;
      }
      
      public Builder setDeprecated(boolean value)
      {
        bitField0_ |= 0x8;
        deprecated_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearDeprecated()
      {
        bitField0_ &= 0xFFFFFFF7;
        deprecated_ = false;
        onChanged();
        return this;
      }
      
      private Object experimentalMapKey_ = "";
      private boolean weak_;
      
      public boolean hasExperimentalMapKey()
      {
        return (bitField0_ & 0x10) == 16;
      }
      
      public String getExperimentalMapKey()
      {
        Object ref = experimentalMapKey_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          experimentalMapKey_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getExperimentalMapKeyBytes()
      {
        Object ref = experimentalMapKey_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          experimentalMapKey_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setExperimentalMapKey(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x10;
        experimentalMapKey_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearExperimentalMapKey()
      {
        bitField0_ &= 0xFFFFFFEF;
        experimentalMapKey_ = DescriptorProtos.FieldOptions.getDefaultInstance().getExperimentalMapKey();
        onChanged();
        return this;
      }
      
      public Builder setExperimentalMapKeyBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x10;
        experimentalMapKey_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasWeak()
      {
        return (bitField0_ & 0x20) == 32;
      }
      
      public boolean getWeak()
      {
        return weak_;
      }
      
      public Builder setWeak(boolean value)
      {
        bitField0_ |= 0x20;
        weak_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearWeak()
      {
        bitField0_ &= 0xFFFFFFDF;
        weak_ = false;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x40) != 64)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x40;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFBF;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new FieldOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface EnumOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.EnumOptions>
  {
    public abstract boolean hasAllowAlias();
    
    public abstract boolean getAllowAlias();
    
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class EnumOptions
    extends GeneratedMessage.ExtendableMessage<EnumOptions>
    implements DescriptorProtos.EnumOptionsOrBuilder
  {
    private static final EnumOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private EnumOptions(GeneratedMessage.ExtendableBuilder<EnumOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private EnumOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static EnumOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public EnumOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private EnumOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 16: 
            bitField0_ |= 0x1;
            allowAlias_ = input.readBool();
            break;
          case 7994: 
            if ((mutable_bitField0_ & 0x2) != 2)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x2;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x2) == 2) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumOptions.class, Builder.class);
    }
    
    public static Parser<EnumOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.EnumOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.EnumOptions(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
    private boolean allowAlias_;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<EnumOptions> getParserForType()
    {
      return PARSER;
    }
    
    public boolean hasAllowAlias()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public boolean getAllowAlias()
    {
      return allowAlias_;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      allowAlias_ = true;
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<EnumOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      if ((bitField0_ & 0x1) == 1) {
        output.writeBool(2, allowAlias_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
        size += CodedOutputStream.computeBoolSize(2, allowAlias_);
      }
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static EnumOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (EnumOptions)PARSER.parseFrom(data);
    }
    
    public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (EnumOptions)PARSER.parseFrom(data);
    }
    
    public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumOptions parseFrom(InputStream input)
      throws IOException
    {
      return (EnumOptions)PARSER.parseFrom(input);
    }
    
    public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static EnumOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (EnumOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static EnumOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (EnumOptions)PARSER.parseFrom(input);
    }
    
    public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$14800();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(EnumOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.EnumOptions, Builder>
      implements DescriptorProtos.EnumOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.EnumOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        allowAlias_ = true;
        bitField0_ &= 0xFFFFFFFE;
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
      }
      
      public DescriptorProtos.EnumOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.EnumOptions build()
      {
        DescriptorProtos.EnumOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.EnumOptions buildPartial()
      {
        DescriptorProtos.EnumOptions result = new DescriptorProtos.EnumOptions(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if ((from_bitField0_ & 0x1) == 1) {
          to_bitField0_ |= 0x1;
        }
        allowAlias_ = allowAlias_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x2) == 2)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFFD;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.EnumOptions)) {
          return mergeFrom((DescriptorProtos.EnumOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumOptions other)
      {
        if (other == DescriptorProtos.EnumOptions.getDefaultInstance()) {
          return this;
        }
        if (other.hasAllowAlias()) {
          setAllowAlias(other.getAllowAlias());
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFFD;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFD;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.EnumOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.EnumOptions)DescriptorProtos.EnumOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.EnumOptions)e.getUnfinishedMessage();
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
      
      private boolean allowAlias_ = true;
      
      public boolean hasAllowAlias()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public boolean getAllowAlias()
      {
        return allowAlias_;
      }
      
      public Builder setAllowAlias(boolean value)
      {
        bitField0_ |= 0x1;
        allowAlias_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearAllowAlias()
      {
        bitField0_ &= 0xFFFFFFFE;
        allowAlias_ = true;
        onChanged();
        return this;
      }
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x2) != 2)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x2;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new EnumOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface EnumValueOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.EnumValueOptions>
  {
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class EnumValueOptions
    extends GeneratedMessage.ExtendableMessage<EnumValueOptions>
    implements DescriptorProtos.EnumValueOptionsOrBuilder
  {
    private static final EnumValueOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private EnumValueOptions(GeneratedMessage.ExtendableBuilder<EnumValueOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private EnumValueOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static EnumValueOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public EnumValueOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private EnumValueOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 7994: 
            if ((mutable_bitField0_ & 0x1) != 1)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x1;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x1) == 1) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValueOptions.class, Builder.class);
    }
    
    public static Parser<EnumValueOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.EnumValueOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.EnumValueOptions(input, extensionRegistry, null);
      }
    };
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<EnumValueOptions> getParserForType()
    {
      return PARSER;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<EnumValueOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static EnumValueOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (EnumValueOptions)PARSER.parseFrom(data);
    }
    
    public static EnumValueOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumValueOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumValueOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (EnumValueOptions)PARSER.parseFrom(data);
    }
    
    public static EnumValueOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (EnumValueOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static EnumValueOptions parseFrom(InputStream input)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseFrom(input);
    }
    
    public static EnumValueOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static EnumValueOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static EnumValueOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static EnumValueOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseFrom(input);
    }
    
    public static EnumValueOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (EnumValueOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$15700();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(EnumValueOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.EnumValueOptions, Builder>
      implements DescriptorProtos.EnumValueOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.EnumValueOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
      }
      
      public DescriptorProtos.EnumValueOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumValueOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.EnumValueOptions build()
      {
        DescriptorProtos.EnumValueOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.EnumValueOptions buildPartial()
      {
        DescriptorProtos.EnumValueOptions result = new DescriptorProtos.EnumValueOptions(this, null);
        int from_bitField0_ = bitField0_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x1) == 1)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFFE;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.EnumValueOptions)) {
          return mergeFrom((DescriptorProtos.EnumValueOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumValueOptions other)
      {
        if (other == DescriptorProtos.EnumValueOptions.getDefaultInstance()) {
          return this;
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFE;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.EnumValueOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.EnumValueOptions)DescriptorProtos.EnumValueOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.EnumValueOptions)e.getUnfinishedMessage();
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
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x1) != 1)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x1;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new EnumValueOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface ServiceOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.ServiceOptions>
  {
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class ServiceOptions
    extends GeneratedMessage.ExtendableMessage<ServiceOptions>
    implements DescriptorProtos.ServiceOptionsOrBuilder
  {
    private static final ServiceOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private ServiceOptions(GeneratedMessage.ExtendableBuilder<ServiceOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private ServiceOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static ServiceOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public ServiceOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private ServiceOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 7994: 
            if ((mutable_bitField0_ & 0x1) != 1)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x1;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x1) == 1) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(ServiceOptions.class, Builder.class);
    }
    
    public static Parser<ServiceOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.ServiceOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.ServiceOptions(input, extensionRegistry, null);
      }
    };
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<ServiceOptions> getParserForType()
    {
      return PARSER;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<ServiceOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static ServiceOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (ServiceOptions)PARSER.parseFrom(data);
    }
    
    public static ServiceOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ServiceOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ServiceOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (ServiceOptions)PARSER.parseFrom(data);
    }
    
    public static ServiceOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (ServiceOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static ServiceOptions parseFrom(InputStream input)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseFrom(input);
    }
    
    public static ServiceOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static ServiceOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static ServiceOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static ServiceOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseFrom(input);
    }
    
    public static ServiceOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (ServiceOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$16400();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(ServiceOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.ServiceOptions, Builder>
      implements DescriptorProtos.ServiceOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.ServiceOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
      }
      
      public DescriptorProtos.ServiceOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.ServiceOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.ServiceOptions build()
      {
        DescriptorProtos.ServiceOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.ServiceOptions buildPartial()
      {
        DescriptorProtos.ServiceOptions result = new DescriptorProtos.ServiceOptions(this, null);
        int from_bitField0_ = bitField0_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x1) == 1)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFFE;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.ServiceOptions)) {
          return mergeFrom((DescriptorProtos.ServiceOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.ServiceOptions other)
      {
        if (other == DescriptorProtos.ServiceOptions.getDefaultInstance()) {
          return this;
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFE;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.ServiceOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.ServiceOptions)DescriptorProtos.ServiceOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.ServiceOptions)e.getUnfinishedMessage();
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
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x1) != 1)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x1;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new ServiceOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface MethodOptionsOrBuilder
    extends GeneratedMessage.ExtendableMessageOrBuilder<DescriptorProtos.MethodOptions>
  {
    public abstract List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList();
    
    public abstract DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt);
    
    public abstract int getUninterpretedOptionCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int paramInt);
  }
  
  public static final class MethodOptions
    extends GeneratedMessage.ExtendableMessage<MethodOptions>
    implements DescriptorProtos.MethodOptionsOrBuilder
  {
    private static final MethodOptions defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private MethodOptions(GeneratedMessage.ExtendableBuilder<MethodOptions, ?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private MethodOptions(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static MethodOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public MethodOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private MethodOptions(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 7994: 
            if ((mutable_bitField0_ & 0x1) != 1)
            {
              uninterpretedOption_ = new ArrayList();
              mutable_bitField0_ |= 0x1;
            }
            uninterpretedOption_.add(input.readMessage(DescriptorProtos.UninterpretedOption.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x1) == 1) {
          uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(MethodOptions.class, Builder.class);
    }
    
    public static Parser<MethodOptions> PARSER = new AbstractParser()
    {
      public DescriptorProtos.MethodOptions parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.MethodOptions(input, extensionRegistry, null);
      }
    };
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_;
    
    public Parser<MethodOptions> getParserForType()
    {
      return PARSER;
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return uninterpretedOption_;
    }
    
    public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
    {
      return uninterpretedOption_;
    }
    
    public int getUninterpretedOptionCount()
    {
      return uninterpretedOption_.size();
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
    {
      return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
    }
    
    public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
    {
      return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
    }
    
    private void initFields()
    {
      uninterpretedOption_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getUninterpretedOptionCount(); i++) {
        if (!getUninterpretedOption(i).isInitialized())
        {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!extensionsAreInitialized())
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
      
      GeneratedMessage.ExtendableMessage<MethodOptions>.ExtensionWriter extensionWriter = newExtensionWriter();
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        output.writeMessage(999, (MessageLite)uninterpretedOption_.get(i));
      }
      extensionWriter.writeUntil(536870912, output);
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
      for (int i = 0; i < uninterpretedOption_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(999, (MessageLite)uninterpretedOption_.get(i));
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    protected Object writeReplace()
      throws ObjectStreamException
    {
      return super.writeReplace();
    }
    
    public static MethodOptions parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (MethodOptions)PARSER.parseFrom(data);
    }
    
    public static MethodOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MethodOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MethodOptions parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (MethodOptions)PARSER.parseFrom(data);
    }
    
    public static MethodOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (MethodOptions)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static MethodOptions parseFrom(InputStream input)
      throws IOException
    {
      return (MethodOptions)PARSER.parseFrom(input);
    }
    
    public static MethodOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static MethodOptions parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (MethodOptions)PARSER.parseDelimitedFrom(input);
    }
    
    public static MethodOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodOptions)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static MethodOptions parseFrom(CodedInputStream input)
      throws IOException
    {
      return (MethodOptions)PARSER.parseFrom(input);
    }
    
    public static MethodOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (MethodOptions)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$17100();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(MethodOptions prototype)
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
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.MethodOptions, Builder>
      implements DescriptorProtos.MethodOptionsOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.MethodOptions.class, Builder.class);
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
          getUninterpretedOptionFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
      }
      
      public DescriptorProtos.MethodOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.MethodOptions.getDefaultInstance();
      }
      
      public DescriptorProtos.MethodOptions build()
      {
        DescriptorProtos.MethodOptions result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.MethodOptions buildPartial()
      {
        DescriptorProtos.MethodOptions result = new DescriptorProtos.MethodOptions(this, null);
        int from_bitField0_ = bitField0_;
        if (uninterpretedOptionBuilder_ == null)
        {
          if ((bitField0_ & 0x1) == 1)
          {
            uninterpretedOption_ = Collections.unmodifiableList(uninterpretedOption_);
            bitField0_ &= 0xFFFFFFFE;
          }
          uninterpretedOption_ = uninterpretedOption_;
        }
        else
        {
          uninterpretedOption_ = uninterpretedOptionBuilder_.build();
        }
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.MethodOptions)) {
          return mergeFrom((DescriptorProtos.MethodOptions)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.MethodOptions other)
      {
        if (other == DescriptorProtos.MethodOptions.getDefaultInstance()) {
          return this;
        }
        if (uninterpretedOptionBuilder_ == null)
        {
          if (!uninterpretedOption_.isEmpty())
          {
            if (uninterpretedOption_.isEmpty())
            {
              uninterpretedOption_ = uninterpretedOption_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensureUninterpretedOptionIsMutable();
              uninterpretedOption_.addAll(uninterpretedOption_);
            }
            onChanged();
          }
        }
        else if (!uninterpretedOption_.isEmpty()) {
          if (uninterpretedOptionBuilder_.isEmpty())
          {
            uninterpretedOptionBuilder_.dispose();
            uninterpretedOptionBuilder_ = null;
            uninterpretedOption_ = uninterpretedOption_;
            bitField0_ &= 0xFFFFFFFE;
            uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null);
          }
          else
          {
            uninterpretedOptionBuilder_.addAllMessages(uninterpretedOption_);
          }
        }
        mergeExtensionFields(other);
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getUninterpretedOptionCount(); i++) {
          if (!getUninterpretedOption(i).isInitialized()) {
            return false;
          }
        }
        if (!extensionsAreInitialized()) {
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.MethodOptions parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.MethodOptions)DescriptorProtos.MethodOptions.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.MethodOptions)e.getUnfinishedMessage();
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
      
      private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
      
      private void ensureUninterpretedOptionIsMutable()
      {
        if ((bitField0_ & 0x1) != 1)
        {
          uninterpretedOption_ = new ArrayList(uninterpretedOption_);
          bitField0_ |= 0x1;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return Collections.unmodifiableList(uninterpretedOption_);
        }
        return uninterpretedOptionBuilder_.getMessageList();
      }
      
      public int getUninterpretedOptionCount()
      {
        if (uninterpretedOptionBuilder_ == null) {
          return uninterpretedOption_.size();
        }
        return uninterpretedOptionBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption)uninterpretedOptionBuilder_.getMessage(index);
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption value)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, value);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addUninterpretedOption(int index, DescriptorProtos.UninterpretedOption.Builder builderForValue)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> values)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          GeneratedMessage.ExtendableBuilder.addAll(values, uninterpretedOption_);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOption_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeUninterpretedOption(int index)
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          ensureUninterpretedOptionIsMutable();
          uninterpretedOption_.remove(index);
          onChanged();
        }
        else
        {
          uninterpretedOptionBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.Builder getUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index)
      {
        if (uninterpretedOptionBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOption_.get(index);
        }
        return (DescriptorProtos.UninterpretedOptionOrBuilder)uninterpretedOptionBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList()
      {
        if (uninterpretedOptionBuilder_ != null) {
          return uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(uninterpretedOption_);
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.Builder addUninterpretedOptionBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.Builder)getUninterpretedOptionFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.Builder> getUninterpretedOptionBuilderList()
      {
        return getUninterpretedOptionFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption, DescriptorProtos.UninterpretedOption.Builder, DescriptorProtos.UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder()
      {
        if (uninterpretedOptionBuilder_ == null)
        {
          uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(uninterpretedOption_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
          
          uninterpretedOption_ = null;
        }
        return uninterpretedOptionBuilder_;
      }
    }
    
    static
    {
      defaultInstance = new MethodOptions(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface UninterpretedOptionOrBuilder
    extends MessageOrBuilder
  {
    public abstract List<DescriptorProtos.UninterpretedOption.NamePart> getNameList();
    
    public abstract DescriptorProtos.UninterpretedOption.NamePart getName(int paramInt);
    
    public abstract int getNameCount();
    
    public abstract List<? extends DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList();
    
    public abstract DescriptorProtos.UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int paramInt);
    
    public abstract boolean hasIdentifierValue();
    
    public abstract String getIdentifierValue();
    
    public abstract ByteString getIdentifierValueBytes();
    
    public abstract boolean hasPositiveIntValue();
    
    public abstract long getPositiveIntValue();
    
    public abstract boolean hasNegativeIntValue();
    
    public abstract long getNegativeIntValue();
    
    public abstract boolean hasDoubleValue();
    
    public abstract double getDoubleValue();
    
    public abstract boolean hasStringValue();
    
    public abstract ByteString getStringValue();
    
    public abstract boolean hasAggregateValue();
    
    public abstract String getAggregateValue();
    
    public abstract ByteString getAggregateValueBytes();
  }
  
  public static final class UninterpretedOption
    extends GeneratedMessage
    implements DescriptorProtos.UninterpretedOptionOrBuilder
  {
    private static final UninterpretedOption defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private UninterpretedOption(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private UninterpretedOption(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static UninterpretedOption getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public UninterpretedOption getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private UninterpretedOption(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 18: 
            if ((mutable_bitField0_ & 0x1) != 1)
            {
              name_ = new ArrayList();
              mutable_bitField0_ |= 0x1;
            }
            name_.add(input.readMessage(NamePart.PARSER, extensionRegistry));
            break;
          case 26: 
            bitField0_ |= 0x1;
            identifierValue_ = input.readBytes();
            break;
          case 32: 
            bitField0_ |= 0x2;
            positiveIntValue_ = input.readUInt64();
            break;
          case 40: 
            bitField0_ |= 0x4;
            negativeIntValue_ = input.readInt64();
            break;
          case 49: 
            bitField0_ |= 0x8;
            doubleValue_ = input.readDouble();
            break;
          case 58: 
            bitField0_ |= 0x10;
            stringValue_ = input.readBytes();
            break;
          case 66: 
            bitField0_ |= 0x20;
            aggregateValue_ = input.readBytes();
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
        if ((mutable_bitField0_ & 0x1) == 1) {
          name_ = Collections.unmodifiableList(name_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable.ensureFieldAccessorsInitialized(UninterpretedOption.class, Builder.class);
    }
    
    public static Parser<UninterpretedOption> PARSER = new AbstractParser()
    {
      public DescriptorProtos.UninterpretedOption parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.UninterpretedOption(input, extensionRegistry, null);
      }
    };
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 2;
    private List<NamePart> name_;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    private Object identifierValue_;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    private long positiveIntValue_;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    private long negativeIntValue_;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    private double doubleValue_;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private ByteString stringValue_;
    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private Object aggregateValue_;
    
    public Parser<UninterpretedOption> getParserForType()
    {
      return PARSER;
    }
    
    public static abstract interface NamePartOrBuilder
      extends MessageOrBuilder
    {
      public abstract boolean hasNamePart();
      
      public abstract String getNamePart();
      
      public abstract ByteString getNamePartBytes();
      
      public abstract boolean hasIsExtension();
      
      public abstract boolean getIsExtension();
    }
    
    public static final class NamePart
      extends GeneratedMessage
      implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
    {
      private static final NamePart defaultInstance;
      private final UnknownFieldSet unknownFields;
      
      private NamePart(GeneratedMessage.Builder<?> builder)
      {
        super();
        unknownFields = builder.getUnknownFields();
      }
      
      private NamePart(boolean noInit)
      {
        unknownFields = UnknownFieldSet.getDefaultInstance();
      }
      
      public static NamePart getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public NamePart getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final UnknownFieldSet getUnknownFields()
      {
        return unknownFields;
      }
      
      private NamePart(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
            case 10: 
              bitField0_ |= 0x1;
              namePart_ = input.readBytes();
              break;
            case 16: 
              bitField0_ |= 0x2;
              isExtension_ = input.readBool();
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
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable.ensureFieldAccessorsInitialized(NamePart.class, Builder.class);
      }
      
      public static Parser<NamePart> PARSER = new AbstractParser()
      {
        public DescriptorProtos.UninterpretedOption.NamePart parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
          throws InvalidProtocolBufferException
        {
          return new DescriptorProtos.UninterpretedOption.NamePart(input, extensionRegistry, null);
        }
      };
      private int bitField0_;
      public static final int NAME_PART_FIELD_NUMBER = 1;
      private Object namePart_;
      public static final int IS_EXTENSION_FIELD_NUMBER = 2;
      private boolean isExtension_;
      
      public Parser<NamePart> getParserForType()
      {
        return PARSER;
      }
      
      public boolean hasNamePart()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getNamePart()
      {
        Object ref = namePart_;
        if ((ref instanceof String)) {
          return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          namePart_ = s;
        }
        return s;
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
      
      public boolean hasIsExtension()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public boolean getIsExtension()
      {
        return isExtension_;
      }
      
      private void initFields()
      {
        namePart_ = "";
        isExtension_ = false;
      }
      
      private byte memoizedIsInitialized = -1;
      
      public final boolean isInitialized()
      {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized != -1) {
          return isInitialized == 1;
        }
        if (!hasNamePart())
        {
          memoizedIsInitialized = 0;
          return false;
        }
        if (!hasIsExtension())
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
          output.writeBytes(1, getNamePartBytes());
        }
        if ((bitField0_ & 0x2) == 2) {
          output.writeBool(2, isExtension_);
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
          size += CodedOutputStream.computeBytesSize(1, getNamePartBytes());
        }
        if ((bitField0_ & 0x2) == 2) {
          size += CodedOutputStream.computeBoolSize(2, isExtension_);
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
      
      public static NamePart parseFrom(ByteString data)
        throws InvalidProtocolBufferException
      {
        return (NamePart)PARSER.parseFrom(data);
      }
      
      public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (NamePart)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static NamePart parseFrom(byte[] data)
        throws InvalidProtocolBufferException
      {
        return (NamePart)PARSER.parseFrom(data);
      }
      
      public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (NamePart)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static NamePart parseFrom(InputStream input)
        throws IOException
      {
        return (NamePart)PARSER.parseFrom(input);
      }
      
      public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (NamePart)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static NamePart parseDelimitedFrom(InputStream input)
        throws IOException
      {
        return (NamePart)PARSER.parseDelimitedFrom(input);
      }
      
      public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (NamePart)PARSER.parseDelimitedFrom(input, extensionRegistry);
      }
      
      public static NamePart parseFrom(CodedInputStream input)
        throws IOException
      {
        return (NamePart)PARSER.parseFrom(input);
      }
      
      public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (NamePart)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static Builder newBuilder()
      {
        return Builder.access$18100();
      }
      
      public Builder newBuilderForType()
      {
        return newBuilder();
      }
      
      public static Builder newBuilder(NamePart prototype)
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
        implements DescriptorProtos.UninterpretedOption.NamePartOrBuilder
      {
        private int bitField0_;
        
        public static final Descriptors.Descriptor getDescriptor()
        {
          return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
        }
        
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
          return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.UninterpretedOption.NamePart.class, Builder.class);
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
          return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
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
          namePart_ = namePart_;
          if ((from_bitField0_ & 0x2) == 2) {
            to_bitField0_ |= 0x2;
          }
          isExtension_ = isExtension_;
          bitField0_ = to_bitField0_;
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
            namePart_ = namePart_;
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
      
      static
      {
        defaultInstance = new NamePart(true);
        defaultInstance.initFields();
      }
    }
    
    public List<NamePart> getNameList()
    {
      return name_;
    }
    
    public List<? extends NamePartOrBuilder> getNameOrBuilderList()
    {
      return name_;
    }
    
    public int getNameCount()
    {
      return name_.size();
    }
    
    public NamePart getName(int index)
    {
      return (NamePart)name_.get(index);
    }
    
    public NamePartOrBuilder getNameOrBuilder(int index)
    {
      return (NamePartOrBuilder)name_.get(index);
    }
    
    public boolean hasIdentifierValue()
    {
      return (bitField0_ & 0x1) == 1;
    }
    
    public String getIdentifierValue()
    {
      Object ref = identifierValue_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        identifierValue_ = s;
      }
      return s;
    }
    
    public ByteString getIdentifierValueBytes()
    {
      Object ref = identifierValue_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        identifierValue_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    public boolean hasPositiveIntValue()
    {
      return (bitField0_ & 0x2) == 2;
    }
    
    public long getPositiveIntValue()
    {
      return positiveIntValue_;
    }
    
    public boolean hasNegativeIntValue()
    {
      return (bitField0_ & 0x4) == 4;
    }
    
    public long getNegativeIntValue()
    {
      return negativeIntValue_;
    }
    
    public boolean hasDoubleValue()
    {
      return (bitField0_ & 0x8) == 8;
    }
    
    public double getDoubleValue()
    {
      return doubleValue_;
    }
    
    public boolean hasStringValue()
    {
      return (bitField0_ & 0x10) == 16;
    }
    
    public ByteString getStringValue()
    {
      return stringValue_;
    }
    
    public boolean hasAggregateValue()
    {
      return (bitField0_ & 0x20) == 32;
    }
    
    public String getAggregateValue()
    {
      Object ref = aggregateValue_;
      if ((ref instanceof String)) {
        return (String)ref;
      }
      ByteString bs = (ByteString)ref;
      
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        aggregateValue_ = s;
      }
      return s;
    }
    
    public ByteString getAggregateValueBytes()
    {
      Object ref = aggregateValue_;
      if ((ref instanceof String))
      {
        ByteString b = ByteString.copyFromUtf8((String)ref);
        
        aggregateValue_ = b;
        return b;
      }
      return (ByteString)ref;
    }
    
    private void initFields()
    {
      name_ = Collections.emptyList();
      identifierValue_ = "";
      positiveIntValue_ = 0L;
      negativeIntValue_ = 0L;
      doubleValue_ = 0.0D;
      stringValue_ = ByteString.EMPTY;
      aggregateValue_ = "";
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      for (int i = 0; i < getNameCount(); i++) {
        if (!getName(i).isInitialized())
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
      for (int i = 0; i < name_.size(); i++) {
        output.writeMessage(2, (MessageLite)name_.get(i));
      }
      if ((bitField0_ & 0x1) == 1) {
        output.writeBytes(3, getIdentifierValueBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        output.writeUInt64(4, positiveIntValue_);
      }
      if ((bitField0_ & 0x4) == 4) {
        output.writeInt64(5, negativeIntValue_);
      }
      if ((bitField0_ & 0x8) == 8) {
        output.writeDouble(6, doubleValue_);
      }
      if ((bitField0_ & 0x10) == 16) {
        output.writeBytes(7, stringValue_);
      }
      if ((bitField0_ & 0x20) == 32) {
        output.writeBytes(8, getAggregateValueBytes());
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
      for (int i = 0; i < name_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(2, (MessageLite)name_.get(i));
      }
      if ((bitField0_ & 0x1) == 1) {
        size += CodedOutputStream.computeBytesSize(3, getIdentifierValueBytes());
      }
      if ((bitField0_ & 0x2) == 2) {
        size += CodedOutputStream.computeUInt64Size(4, positiveIntValue_);
      }
      if ((bitField0_ & 0x4) == 4) {
        size += CodedOutputStream.computeInt64Size(5, negativeIntValue_);
      }
      if ((bitField0_ & 0x8) == 8) {
        size += CodedOutputStream.computeDoubleSize(6, doubleValue_);
      }
      if ((bitField0_ & 0x10) == 16) {
        size += CodedOutputStream.computeBytesSize(7, stringValue_);
      }
      if ((bitField0_ & 0x20) == 32) {
        size += CodedOutputStream.computeBytesSize(8, getAggregateValueBytes());
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
    
    public static UninterpretedOption parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (UninterpretedOption)PARSER.parseFrom(data);
    }
    
    public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (UninterpretedOption)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static UninterpretedOption parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (UninterpretedOption)PARSER.parseFrom(data);
    }
    
    public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (UninterpretedOption)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static UninterpretedOption parseFrom(InputStream input)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseFrom(input);
    }
    
    public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static UninterpretedOption parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseDelimitedFrom(input);
    }
    
    public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static UninterpretedOption parseFrom(CodedInputStream input)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseFrom(input);
    }
    
    public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (UninterpretedOption)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$18700();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(UninterpretedOption prototype)
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
      implements DescriptorProtos.UninterpretedOptionOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.UninterpretedOption.class, Builder.class);
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
          getNameFieldBuilder();
        }
      }
      
      private static Builder create()
      {
        return new Builder();
      }
      
      public Builder clear()
      {
        super.clear();
        if (nameBuilder_ == null)
        {
          name_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
        }
        else
        {
          nameBuilder_.clear();
        }
        identifierValue_ = "";
        bitField0_ &= 0xFFFFFFFD;
        positiveIntValue_ = 0L;
        bitField0_ &= 0xFFFFFFFB;
        negativeIntValue_ = 0L;
        bitField0_ &= 0xFFFFFFF7;
        doubleValue_ = 0.0D;
        bitField0_ &= 0xFFFFFFEF;
        stringValue_ = ByteString.EMPTY;
        bitField0_ &= 0xFFFFFFDF;
        aggregateValue_ = "";
        bitField0_ &= 0xFFFFFFBF;
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(buildPartial());
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
      }
      
      public DescriptorProtos.UninterpretedOption getDefaultInstanceForType()
      {
        return DescriptorProtos.UninterpretedOption.getDefaultInstance();
      }
      
      public DescriptorProtos.UninterpretedOption build()
      {
        DescriptorProtos.UninterpretedOption result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      public DescriptorProtos.UninterpretedOption buildPartial()
      {
        DescriptorProtos.UninterpretedOption result = new DescriptorProtos.UninterpretedOption(this, null);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (nameBuilder_ == null)
        {
          if ((bitField0_ & 0x1) == 1)
          {
            name_ = Collections.unmodifiableList(name_);
            bitField0_ &= 0xFFFFFFFE;
          }
          name_ = name_;
        }
        else
        {
          name_ = nameBuilder_.build();
        }
        if ((from_bitField0_ & 0x2) == 2) {
          to_bitField0_ |= 0x1;
        }
        identifierValue_ = identifierValue_;
        if ((from_bitField0_ & 0x4) == 4) {
          to_bitField0_ |= 0x2;
        }
        positiveIntValue_ = positiveIntValue_;
        if ((from_bitField0_ & 0x8) == 8) {
          to_bitField0_ |= 0x4;
        }
        negativeIntValue_ = negativeIntValue_;
        if ((from_bitField0_ & 0x10) == 16) {
          to_bitField0_ |= 0x8;
        }
        doubleValue_ = doubleValue_;
        if ((from_bitField0_ & 0x20) == 32) {
          to_bitField0_ |= 0x10;
        }
        stringValue_ = stringValue_;
        if ((from_bitField0_ & 0x40) == 64) {
          to_bitField0_ |= 0x20;
        }
        aggregateValue_ = aggregateValue_;
        bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(Message other)
      {
        if ((other instanceof DescriptorProtos.UninterpretedOption)) {
          return mergeFrom((DescriptorProtos.UninterpretedOption)other);
        }
        super.mergeFrom(other);
        return this;
      }
      
      public Builder mergeFrom(DescriptorProtos.UninterpretedOption other)
      {
        if (other == DescriptorProtos.UninterpretedOption.getDefaultInstance()) {
          return this;
        }
        if (nameBuilder_ == null)
        {
          if (!name_.isEmpty())
          {
            if (name_.isEmpty())
            {
              name_ = name_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensureNameIsMutable();
              name_.addAll(name_);
            }
            onChanged();
          }
        }
        else if (!name_.isEmpty()) {
          if (nameBuilder_.isEmpty())
          {
            nameBuilder_.dispose();
            nameBuilder_ = null;
            name_ = name_;
            bitField0_ &= 0xFFFFFFFE;
            nameBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getNameFieldBuilder() : null);
          }
          else
          {
            nameBuilder_.addAllMessages(name_);
          }
        }
        if (other.hasIdentifierValue())
        {
          bitField0_ |= 0x2;
          identifierValue_ = identifierValue_;
          onChanged();
        }
        if (other.hasPositiveIntValue()) {
          setPositiveIntValue(other.getPositiveIntValue());
        }
        if (other.hasNegativeIntValue()) {
          setNegativeIntValue(other.getNegativeIntValue());
        }
        if (other.hasDoubleValue()) {
          setDoubleValue(other.getDoubleValue());
        }
        if (other.hasStringValue()) {
          setStringValue(other.getStringValue());
        }
        if (other.hasAggregateValue())
        {
          bitField0_ |= 0x40;
          aggregateValue_ = aggregateValue_;
          onChanged();
        }
        mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized()
      {
        for (int i = 0; i < getNameCount(); i++) {
          if (!getName(i).isInitialized()) {
            return false;
          }
        }
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        DescriptorProtos.UninterpretedOption parsedMessage = null;
        try
        {
          parsedMessage = (DescriptorProtos.UninterpretedOption)DescriptorProtos.UninterpretedOption.PARSER.parsePartialFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          parsedMessage = (DescriptorProtos.UninterpretedOption)e.getUnfinishedMessage();
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
      
      private List<DescriptorProtos.UninterpretedOption.NamePart> name_ = Collections.emptyList();
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> nameBuilder_;
      
      private void ensureNameIsMutable()
      {
        if ((bitField0_ & 0x1) != 1)
        {
          name_ = new ArrayList(name_);
          bitField0_ |= 0x1;
        }
      }
      
      public List<DescriptorProtos.UninterpretedOption.NamePart> getNameList()
      {
        if (nameBuilder_ == null) {
          return Collections.unmodifiableList(name_);
        }
        return nameBuilder_.getMessageList();
      }
      
      public int getNameCount()
      {
        if (nameBuilder_ == null) {
          return name_.size();
        }
        return nameBuilder_.getCount();
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart getName(int index)
      {
        if (nameBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption.NamePart)name_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption.NamePart)nameBuilder_.getMessage(index);
      }
      
      public Builder setName(int index, DescriptorProtos.UninterpretedOption.NamePart value)
      {
        if (nameBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNameIsMutable();
          name_.set(index, value);
          onChanged();
        }
        else
        {
          nameBuilder_.setMessage(index, value);
        }
        return this;
      }
      
      public Builder setName(int index, DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
      {
        if (nameBuilder_ == null)
        {
          ensureNameIsMutable();
          name_.set(index, builderForValue.build());
          onChanged();
        }
        else
        {
          nameBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addName(DescriptorProtos.UninterpretedOption.NamePart value)
      {
        if (nameBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNameIsMutable();
          name_.add(value);
          onChanged();
        }
        else
        {
          nameBuilder_.addMessage(value);
        }
        return this;
      }
      
      public Builder addName(int index, DescriptorProtos.UninterpretedOption.NamePart value)
      {
        if (nameBuilder_ == null)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureNameIsMutable();
          name_.add(index, value);
          onChanged();
        }
        else
        {
          nameBuilder_.addMessage(index, value);
        }
        return this;
      }
      
      public Builder addName(DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
      {
        if (nameBuilder_ == null)
        {
          ensureNameIsMutable();
          name_.add(builderForValue.build());
          onChanged();
        }
        else
        {
          nameBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      
      public Builder addName(int index, DescriptorProtos.UninterpretedOption.NamePart.Builder builderForValue)
      {
        if (nameBuilder_ == null)
        {
          ensureNameIsMutable();
          name_.add(index, builderForValue.build());
          onChanged();
        }
        else
        {
          nameBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      
      public Builder addAllName(Iterable<? extends DescriptorProtos.UninterpretedOption.NamePart> values)
      {
        if (nameBuilder_ == null)
        {
          ensureNameIsMutable();
          GeneratedMessage.Builder.addAll(values, name_);
          onChanged();
        }
        else
        {
          nameBuilder_.addAllMessages(values);
        }
        return this;
      }
      
      public Builder clearName()
      {
        if (nameBuilder_ == null)
        {
          name_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          onChanged();
        }
        else
        {
          nameBuilder_.clear();
        }
        return this;
      }
      
      public Builder removeName(int index)
      {
        if (nameBuilder_ == null)
        {
          ensureNameIsMutable();
          name_.remove(index);
          onChanged();
        }
        else
        {
          nameBuilder_.remove(index);
        }
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart.Builder getNameBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().getBuilder(index);
      }
      
      public DescriptorProtos.UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int index)
      {
        if (nameBuilder_ == null) {
          return (DescriptorProtos.UninterpretedOption.NamePartOrBuilder)name_.get(index);
        }
        return (DescriptorProtos.UninterpretedOption.NamePartOrBuilder)nameBuilder_.getMessageOrBuilder(index);
      }
      
      public List<? extends DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList()
      {
        if (nameBuilder_ != null) {
          return nameBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(name_);
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart.Builder addNameBuilder()
      {
        return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().addBuilder(DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance());
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart.Builder addNameBuilder(int index)
      {
        return (DescriptorProtos.UninterpretedOption.NamePart.Builder)getNameFieldBuilder().addBuilder(index, DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance());
      }
      
      public List<DescriptorProtos.UninterpretedOption.NamePart.Builder> getNameBuilderList()
      {
        return getNameFieldBuilder().getBuilderList();
      }
      
      private RepeatedFieldBuilder<DescriptorProtos.UninterpretedOption.NamePart, DescriptorProtos.UninterpretedOption.NamePart.Builder, DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameFieldBuilder()
      {
        if (nameBuilder_ == null)
        {
          nameBuilder_ = new RepeatedFieldBuilder(name_, (bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
          
          name_ = null;
        }
        return nameBuilder_;
      }
      
      private Object identifierValue_ = "";
      private long positiveIntValue_;
      private long negativeIntValue_;
      private double doubleValue_;
      
      public boolean hasIdentifierValue()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public String getIdentifierValue()
      {
        Object ref = identifierValue_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          identifierValue_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getIdentifierValueBytes()
      {
        Object ref = identifierValue_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          identifierValue_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setIdentifierValue(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        identifierValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearIdentifierValue()
      {
        bitField0_ &= 0xFFFFFFFD;
        identifierValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getIdentifierValue();
        onChanged();
        return this;
      }
      
      public Builder setIdentifierValueBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x2;
        identifierValue_ = value;
        onChanged();
        return this;
      }
      
      public boolean hasPositiveIntValue()
      {
        return (bitField0_ & 0x4) == 4;
      }
      
      public long getPositiveIntValue()
      {
        return positiveIntValue_;
      }
      
      public Builder setPositiveIntValue(long value)
      {
        bitField0_ |= 0x4;
        positiveIntValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearPositiveIntValue()
      {
        bitField0_ &= 0xFFFFFFFB;
        positiveIntValue_ = 0L;
        onChanged();
        return this;
      }
      
      public boolean hasNegativeIntValue()
      {
        return (bitField0_ & 0x8) == 8;
      }
      
      public long getNegativeIntValue()
      {
        return negativeIntValue_;
      }
      
      public Builder setNegativeIntValue(long value)
      {
        bitField0_ |= 0x8;
        negativeIntValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearNegativeIntValue()
      {
        bitField0_ &= 0xFFFFFFF7;
        negativeIntValue_ = 0L;
        onChanged();
        return this;
      }
      
      public boolean hasDoubleValue()
      {
        return (bitField0_ & 0x10) == 16;
      }
      
      public double getDoubleValue()
      {
        return doubleValue_;
      }
      
      public Builder setDoubleValue(double value)
      {
        bitField0_ |= 0x10;
        doubleValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearDoubleValue()
      {
        bitField0_ &= 0xFFFFFFEF;
        doubleValue_ = 0.0D;
        onChanged();
        return this;
      }
      
      private ByteString stringValue_ = ByteString.EMPTY;
      
      public boolean hasStringValue()
      {
        return (bitField0_ & 0x20) == 32;
      }
      
      public ByteString getStringValue()
      {
        return stringValue_;
      }
      
      public Builder setStringValue(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x20;
        stringValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearStringValue()
      {
        bitField0_ &= 0xFFFFFFDF;
        stringValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getStringValue();
        onChanged();
        return this;
      }
      
      private Object aggregateValue_ = "";
      
      public boolean hasAggregateValue()
      {
        return (bitField0_ & 0x40) == 64;
      }
      
      public String getAggregateValue()
      {
        Object ref = aggregateValue_;
        if (!(ref instanceof String))
        {
          String s = ((ByteString)ref).toStringUtf8();
          
          aggregateValue_ = s;
          return s;
        }
        return (String)ref;
      }
      
      public ByteString getAggregateValueBytes()
      {
        Object ref = aggregateValue_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          aggregateValue_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public Builder setAggregateValue(String value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x40;
        aggregateValue_ = value;
        onChanged();
        return this;
      }
      
      public Builder clearAggregateValue()
      {
        bitField0_ &= 0xFFFFFFBF;
        aggregateValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getAggregateValue();
        onChanged();
        return this;
      }
      
      public Builder setAggregateValueBytes(ByteString value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x40;
        aggregateValue_ = value;
        onChanged();
        return this;
      }
    }
    
    static
    {
      defaultInstance = new UninterpretedOption(true);
      defaultInstance.initFields();
    }
  }
  
  public static abstract interface SourceCodeInfoOrBuilder
    extends MessageOrBuilder
  {
    public abstract List<DescriptorProtos.SourceCodeInfo.Location> getLocationList();
    
    public abstract DescriptorProtos.SourceCodeInfo.Location getLocation(int paramInt);
    
    public abstract int getLocationCount();
    
    public abstract List<? extends DescriptorProtos.SourceCodeInfo.LocationOrBuilder> getLocationOrBuilderList();
    
    public abstract DescriptorProtos.SourceCodeInfo.LocationOrBuilder getLocationOrBuilder(int paramInt);
  }
  
  public static final class SourceCodeInfo
    extends GeneratedMessage
    implements DescriptorProtos.SourceCodeInfoOrBuilder
  {
    private static final SourceCodeInfo defaultInstance;
    private final UnknownFieldSet unknownFields;
    
    private SourceCodeInfo(GeneratedMessage.Builder<?> builder)
    {
      super();
      unknownFields = builder.getUnknownFields();
    }
    
    private SourceCodeInfo(boolean noInit)
    {
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public static SourceCodeInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public SourceCodeInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    private SourceCodeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
          case 10: 
            if ((mutable_bitField0_ & 0x1) != 1)
            {
              location_ = new ArrayList();
              mutable_bitField0_ |= 0x1;
            }
            location_.add(input.readMessage(Location.PARSER, extensionRegistry));
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
        if ((mutable_bitField0_ & 0x1) == 1) {
          location_ = Collections.unmodifiableList(location_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceCodeInfo.class, Builder.class);
    }
    
    public static Parser<SourceCodeInfo> PARSER = new AbstractParser()
    {
      public DescriptorProtos.SourceCodeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return new DescriptorProtos.SourceCodeInfo(input, extensionRegistry, null);
      }
    };
    public static final int LOCATION_FIELD_NUMBER = 1;
    private List<Location> location_;
    
    public Parser<SourceCodeInfo> getParserForType()
    {
      return PARSER;
    }
    
    public static abstract interface LocationOrBuilder
      extends MessageOrBuilder
    {
      public abstract List<Integer> getPathList();
      
      public abstract int getPathCount();
      
      public abstract int getPath(int paramInt);
      
      public abstract List<Integer> getSpanList();
      
      public abstract int getSpanCount();
      
      public abstract int getSpan(int paramInt);
      
      public abstract boolean hasLeadingComments();
      
      public abstract String getLeadingComments();
      
      public abstract ByteString getLeadingCommentsBytes();
      
      public abstract boolean hasTrailingComments();
      
      public abstract String getTrailingComments();
      
      public abstract ByteString getTrailingCommentsBytes();
    }
    
    public static final class Location
      extends GeneratedMessage
      implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
    {
      private static final Location defaultInstance;
      private final UnknownFieldSet unknownFields;
      
      private Location(GeneratedMessage.Builder<?> builder)
      {
        super();
        unknownFields = builder.getUnknownFields();
      }
      
      private Location(boolean noInit)
      {
        unknownFields = UnknownFieldSet.getDefaultInstance();
      }
      
      public static Location getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public Location getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final UnknownFieldSet getUnknownFields()
      {
        return unknownFields;
      }
      
      private Location(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
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
              if ((mutable_bitField0_ & 0x1) != 1)
              {
                path_ = new ArrayList();
                mutable_bitField0_ |= 0x1;
              }
              path_.add(Integer.valueOf(input.readInt32()));
              break;
            case 10: 
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (((mutable_bitField0_ & 0x1) != 1) && (input.getBytesUntilLimit() > 0))
              {
                path_ = new ArrayList();
                mutable_bitField0_ |= 0x1;
              }
              while (input.getBytesUntilLimit() > 0) {
                path_.add(Integer.valueOf(input.readInt32()));
              }
              input.popLimit(limit);
              break;
            case 16: 
              if ((mutable_bitField0_ & 0x2) != 2)
              {
                span_ = new ArrayList();
                mutable_bitField0_ |= 0x2;
              }
              span_.add(Integer.valueOf(input.readInt32()));
              break;
            case 18: 
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (((mutable_bitField0_ & 0x2) != 2) && (input.getBytesUntilLimit() > 0))
              {
                span_ = new ArrayList();
                mutable_bitField0_ |= 0x2;
              }
              while (input.getBytesUntilLimit() > 0) {
                span_.add(Integer.valueOf(input.readInt32()));
              }
              input.popLimit(limit);
              break;
            case 26: 
              bitField0_ |= 0x1;
              leadingComments_ = input.readBytes();
              break;
            case 34: 
              bitField0_ |= 0x2;
              trailingComments_ = input.readBytes();
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
          if ((mutable_bitField0_ & 0x1) == 1) {
            path_ = Collections.unmodifiableList(path_);
          }
          if ((mutable_bitField0_ & 0x2) == 2) {
            span_ = Collections.unmodifiableList(span_);
          }
          this.unknownFields = unknownFields.build();
          makeExtensionsImmutable();
        }
      }
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(Location.class, Builder.class);
      }
      
      public static Parser<Location> PARSER = new AbstractParser()
      {
        public DescriptorProtos.SourceCodeInfo.Location parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
          throws InvalidProtocolBufferException
        {
          return new DescriptorProtos.SourceCodeInfo.Location(input, extensionRegistry, null);
        }
      };
      private int bitField0_;
      public static final int PATH_FIELD_NUMBER = 1;
      private List<Integer> path_;
      
      public Parser<Location> getParserForType()
      {
        return PARSER;
      }
      
      public List<Integer> getPathList()
      {
        return path_;
      }
      
      public int getPathCount()
      {
        return path_.size();
      }
      
      public int getPath(int index)
      {
        return ((Integer)path_.get(index)).intValue();
      }
      
      private int pathMemoizedSerializedSize = -1;
      public static final int SPAN_FIELD_NUMBER = 2;
      private List<Integer> span_;
      
      public List<Integer> getSpanList()
      {
        return span_;
      }
      
      public int getSpanCount()
      {
        return span_.size();
      }
      
      public int getSpan(int index)
      {
        return ((Integer)span_.get(index)).intValue();
      }
      
      private int spanMemoizedSerializedSize = -1;
      public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
      private Object leadingComments_;
      public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
      private Object trailingComments_;
      
      public boolean hasLeadingComments()
      {
        return (bitField0_ & 0x1) == 1;
      }
      
      public String getLeadingComments()
      {
        Object ref = leadingComments_;
        if ((ref instanceof String)) {
          return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          leadingComments_ = s;
        }
        return s;
      }
      
      public ByteString getLeadingCommentsBytes()
      {
        Object ref = leadingComments_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          leadingComments_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      public boolean hasTrailingComments()
      {
        return (bitField0_ & 0x2) == 2;
      }
      
      public String getTrailingComments()
      {
        Object ref = trailingComments_;
        if ((ref instanceof String)) {
          return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          trailingComments_ = s;
        }
        return s;
      }
      
      public ByteString getTrailingCommentsBytes()
      {
        Object ref = trailingComments_;
        if ((ref instanceof String))
        {
          ByteString b = ByteString.copyFromUtf8((String)ref);
          
          trailingComments_ = b;
          return b;
        }
        return (ByteString)ref;
      }
      
      private void initFields()
      {
        path_ = Collections.emptyList();
        span_ = Collections.emptyList();
        leadingComments_ = "";
        trailingComments_ = "";
      }
      
      private byte memoizedIsInitialized = -1;
      
      public final boolean isInitialized()
      {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized != -1) {
          return isInitialized == 1;
        }
        memoizedIsInitialized = 1;
        return true;
      }
      
      public void writeTo(CodedOutputStream output)
        throws IOException
      {
        getSerializedSize();
        if (getPathList().size() > 0)
        {
          output.writeRawVarint32(10);
          output.writeRawVarint32(pathMemoizedSerializedSize);
        }
        for (int i = 0; i < path_.size(); i++) {
          output.writeInt32NoTag(((Integer)path_.get(i)).intValue());
        }
        if (getSpanList().size() > 0)
        {
          output.writeRawVarint32(18);
          output.writeRawVarint32(spanMemoizedSerializedSize);
        }
        for (int i = 0; i < span_.size(); i++) {
          output.writeInt32NoTag(((Integer)span_.get(i)).intValue());
        }
        if ((bitField0_ & 0x1) == 1) {
          output.writeBytes(3, getLeadingCommentsBytes());
        }
        if ((bitField0_ & 0x2) == 2) {
          output.writeBytes(4, getTrailingCommentsBytes());
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
        
        int dataSize = 0;
        for (int i = 0; i < path_.size(); i++) {
          dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)path_.get(i)).intValue());
        }
        size += dataSize;
        if (!getPathList().isEmpty())
        {
          size++;
          size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        pathMemoizedSerializedSize = dataSize;
        
        int dataSize = 0;
        for (int i = 0; i < span_.size(); i++) {
          dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer)span_.get(i)).intValue());
        }
        size += dataSize;
        if (!getSpanList().isEmpty())
        {
          size++;
          size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        spanMemoizedSerializedSize = dataSize;
        if ((bitField0_ & 0x1) == 1) {
          size += CodedOutputStream.computeBytesSize(3, getLeadingCommentsBytes());
        }
        if ((bitField0_ & 0x2) == 2) {
          size += CodedOutputStream.computeBytesSize(4, getTrailingCommentsBytes());
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
      
      public static Location parseFrom(ByteString data)
        throws InvalidProtocolBufferException
      {
        return (Location)PARSER.parseFrom(data);
      }
      
      public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (Location)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static Location parseFrom(byte[] data)
        throws InvalidProtocolBufferException
      {
        return (Location)PARSER.parseFrom(data);
      }
      
      public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        return (Location)PARSER.parseFrom(data, extensionRegistry);
      }
      
      public static Location parseFrom(InputStream input)
        throws IOException
      {
        return (Location)PARSER.parseFrom(input);
      }
      
      public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (Location)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static Location parseDelimitedFrom(InputStream input)
        throws IOException
      {
        return (Location)PARSER.parseDelimitedFrom(input);
      }
      
      public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (Location)PARSER.parseDelimitedFrom(input, extensionRegistry);
      }
      
      public static Location parseFrom(CodedInputStream input)
        throws IOException
      {
        return (Location)PARSER.parseFrom(input);
      }
      
      public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws IOException
      {
        return (Location)PARSER.parseFrom(input, extensionRegistry);
      }
      
      public static Builder newBuilder()
      {
        return Builder.access$20400();
      }
      
      public Builder newBuilderForType()
      {
        return newBuilder();
      }
      
      public static Builder newBuilder(Location prototype)
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
        implements DescriptorProtos.SourceCodeInfo.LocationOrBuilder
      {
        private int bitField0_;
        
        public static final Descriptors.Descriptor getDescriptor()
        {
          return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
        }
        
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
        {
          return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.SourceCodeInfo.Location.class, Builder.class);
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
          if (GeneratedMessage.alwaysUseFieldBuilders) {}
        }
        
        private static Builder create()
        {
          return new Builder();
        }
        
        public Builder clear()
        {
          super.clear();
          path_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          span_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          leadingComments_ = "";
          bitField0_ &= 0xFFFFFFFB;
          trailingComments_ = "";
          bitField0_ &= 0xFFFFFFF7;
          return this;
        }
        
        public Builder clone()
        {
          return create().mergeFrom(buildPartial());
        }
        
        public Descriptors.Descriptor getDescriptorForType()
        {
          return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
        }
        
        public DescriptorProtos.SourceCodeInfo.Location getDefaultInstanceForType()
        {
          return DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance();
        }
        
        public DescriptorProtos.SourceCodeInfo.Location build()
        {
          DescriptorProtos.SourceCodeInfo.Location result = buildPartial();
          if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
          }
          return result;
        }
        
        public DescriptorProtos.SourceCodeInfo.Location buildPartial()
        {
          DescriptorProtos.SourceCodeInfo.Location result = new DescriptorProtos.SourceCodeInfo.Location(this, null);
          int from_bitField0_ = bitField0_;
          int to_bitField0_ = 0;
          if ((bitField0_ & 0x1) == 1)
          {
            path_ = Collections.unmodifiableList(path_);
            bitField0_ &= 0xFFFFFFFE;
          }
          path_ = path_;
          if ((bitField0_ & 0x2) == 2)
          {
            span_ = Collections.unmodifiableList(span_);
            bitField0_ &= 0xFFFFFFFD;
          }
          span_ = span_;
          if ((from_bitField0_ & 0x4) == 4) {
            to_bitField0_ |= 0x1;
          }
          leadingComments_ = leadingComments_;
          if ((from_bitField0_ & 0x8) == 8) {
            to_bitField0_ |= 0x2;
          }
          trailingComments_ = trailingComments_;
          bitField0_ = to_bitField0_;
          onBuilt();
          return result;
        }
        
        public Builder mergeFrom(Message other)
        {
          if ((other instanceof DescriptorProtos.SourceCodeInfo.Location)) {
            return mergeFrom((DescriptorProtos.SourceCodeInfo.Location)other);
          }
          super.mergeFrom(other);
          return this;
        }
        
        public Builder mergeFrom(DescriptorProtos.SourceCodeInfo.Location other)
        {
          if (other == DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance()) {
            return this;
          }
          if (!path_.isEmpty())
          {
            if (path_.isEmpty())
            {
              path_ = path_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensurePathIsMutable();
              path_.addAll(path_);
            }
            onChanged();
          }
          if (!span_.isEmpty())
          {
            if (span_.isEmpty())
            {
              span_ = span_;
              bitField0_ &= 0xFFFFFFFD;
            }
            else
            {
              ensureSpanIsMutable();
              span_.addAll(span_);
            }
            onChanged();
          }
          if (other.hasLeadingComments())
          {
            bitField0_ |= 0x4;
            leadingComments_ = leadingComments_;
            onChanged();
          }
          if (other.hasTrailingComments())
          {
            bitField0_ |= 0x8;
            trailingComments_ = trailingComments_;
            onChanged();
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
          DescriptorProtos.SourceCodeInfo.Location parsedMessage = null;
          try
          {
            parsedMessage = (DescriptorProtos.SourceCodeInfo.Location)DescriptorProtos.SourceCodeInfo.Location.PARSER.parsePartialFrom(input, extensionRegistry);
          }
          catch (InvalidProtocolBufferException e)
          {
            parsedMessage = (DescriptorProtos.SourceCodeInfo.Location)e.getUnfinishedMessage();
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
        
        private List<Integer> path_ = Collections.emptyList();
        
        private void ensurePathIsMutable()
        {
          if ((bitField0_ & 0x1) != 1)
          {
            path_ = new ArrayList(path_);
            bitField0_ |= 0x1;
          }
        }
        
        public List<Integer> getPathList()
        {
          return Collections.unmodifiableList(path_);
        }
        
        public int getPathCount()
        {
          return path_.size();
        }
        
        public int getPath(int index)
        {
          return ((Integer)path_.get(index)).intValue();
        }
        
        public Builder setPath(int index, int value)
        {
          ensurePathIsMutable();
          path_.set(index, Integer.valueOf(value));
          onChanged();
          return this;
        }
        
        public Builder addPath(int value)
        {
          ensurePathIsMutable();
          path_.add(Integer.valueOf(value));
          onChanged();
          return this;
        }
        
        public Builder addAllPath(Iterable<? extends Integer> values)
        {
          ensurePathIsMutable();
          GeneratedMessage.Builder.addAll(values, path_);
          onChanged();
          return this;
        }
        
        public Builder clearPath()
        {
          path_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFE;
          onChanged();
          return this;
        }
        
        private List<Integer> span_ = Collections.emptyList();
        
        private void ensureSpanIsMutable()
        {
          if ((bitField0_ & 0x2) != 2)
          {
            span_ = new ArrayList(span_);
            bitField0_ |= 0x2;
          }
        }
        
        public List<Integer> getSpanList()
        {
          return Collections.unmodifiableList(span_);
        }
        
        public int getSpanCount()
        {
          return span_.size();
        }
        
        public int getSpan(int index)
        {
          return ((Integer)span_.get(index)).intValue();
        }
        
        public Builder setSpan(int index, int value)
        {
          ensureSpanIsMutable();
          span_.set(index, Integer.valueOf(value));
          onChanged();
          return this;
        }
        
        public Builder addSpan(int value)
        {
          ensureSpanIsMutable();
          span_.add(Integer.valueOf(value));
          onChanged();
          return this;
        }
        
        public Builder addAllSpan(Iterable<? extends Integer> values)
        {
          ensureSpanIsMutable();
          GeneratedMessage.Builder.addAll(values, span_);
          onChanged();
          return this;
        }
        
        public Builder clearSpan()
        {
          span_ = Collections.emptyList();
          bitField0_ &= 0xFFFFFFFD;
          onChanged();
          return this;
        }
        
        private Object leadingComments_ = "";
        
        public boolean hasLeadingComments()
        {
          return (bitField0_ & 0x4) == 4;
        }
        
        public String getLeadingComments()
        {
          Object ref = leadingComments_;
          if (!(ref instanceof String))
          {
            String s = ((ByteString)ref).toStringUtf8();
            
            leadingComments_ = s;
            return s;
          }
          return (String)ref;
        }
        
        public ByteString getLeadingCommentsBytes()
        {
          Object ref = leadingComments_;
          if ((ref instanceof String))
          {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            
            leadingComments_ = b;
            return b;
          }
          return (ByteString)ref;
        }
        
        public Builder setLeadingComments(String value)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          bitField0_ |= 0x4;
          leadingComments_ = value;
          onChanged();
          return this;
        }
        
        public Builder clearLeadingComments()
        {
          bitField0_ &= 0xFFFFFFFB;
          leadingComments_ = DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance().getLeadingComments();
          onChanged();
          return this;
        }
        
        public Builder setLeadingCommentsBytes(ByteString value)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          bitField0_ |= 0x4;
          leadingComments_ = value;
          onChanged();
          return this;
        }
        
        private Object trailingComments_ = "";
        
        public boolean hasTrailingComments()
        {
          return (bitField0_ & 0x8) == 8;
        }
        
        public String getTrailingComments()
        {
          Object ref = trailingComments_;
          if (!(ref instanceof String))
          {
            String s = ((ByteString)ref).toStringUtf8();
            
            trailingComments_ = s;
            return s;
          }
          return (String)ref;
        }
        
        public ByteString getTrailingCommentsBytes()
        {
          Object ref = trailingComments_;
          if ((ref instanceof String))
          {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            
            trailingComments_ = b;
            return b;
          }
          return (ByteString)ref;
        }
        
        public Builder setTrailingComments(String value)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          bitField0_ |= 0x8;
          trailingComments_ = value;
          onChanged();
          return this;
        }
        
        public Builder clearTrailingComments()
        {
          bitField0_ &= 0xFFFFFFF7;
          trailingComments_ = DescriptorProtos.SourceCodeInfo.Location.getDefaultInstance().getTrailingComments();
          onChanged();
          return this;
        }
        
        public Builder setTrailingCommentsBytes(ByteString value)
        {
          if (value == null) {
            throw new NullPointerException();
          }
          bitField0_ |= 0x8;
          trailingComments_ = value;
          onChanged();
          return this;
        }
      }
      
      static
      {
        defaultInstance = new Location(true);
        defaultInstance.initFields();
      }
    }
    
    public List<Location> getLocationList()
    {
      return location_;
    }
    
    public List<? extends LocationOrBuilder> getLocationOrBuilderList()
    {
      return location_;
    }
    
    public int getLocationCount()
    {
      return location_.size();
    }
    
    public Location getLocation(int index)
    {
      return (Location)location_.get(index);
    }
    
    public LocationOrBuilder getLocationOrBuilder(int index)
    {
      return (LocationOrBuilder)location_.get(index);
    }
    
    private void initFields()
    {
      location_ = Collections.emptyList();
    }
    
    private byte memoizedIsInitialized = -1;
    
    public final boolean isInitialized()
    {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) {
        return isInitialized == 1;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(CodedOutputStream output)
      throws IOException
    {
      getSerializedSize();
      for (int i = 0; i < location_.size(); i++) {
        output.writeMessage(1, (MessageLite)location_.get(i));
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
      for (int i = 0; i < location_.size(); i++) {
        size += CodedOutputStream.computeMessageSize(1, (MessageLite)location_.get(i));
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
    
    public static SourceCodeInfo parseFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (SourceCodeInfo)PARSER.parseFrom(data);
    }
    
    public static SourceCodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (SourceCodeInfo)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static SourceCodeInfo parseFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (SourceCodeInfo)PARSER.parseFrom(data);
    }
    
    public static SourceCodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (SourceCodeInfo)PARSER.parseFrom(data, extensionRegistry);
    }
    
    public static SourceCodeInfo parseFrom(InputStream input)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseFrom(input);
    }
    
    public static SourceCodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static SourceCodeInfo parseDelimitedFrom(InputStream input)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseDelimitedFrom(input);
    }
    
    public static SourceCodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    public static SourceCodeInfo parseFrom(CodedInputStream input)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseFrom(input);
    }
    
    public static SourceCodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (SourceCodeInfo)PARSER.parseFrom(input, extensionRegistry);
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$21200();
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public static Builder newBuilder(SourceCodeInfo prototype)
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
      implements DescriptorProtos.SourceCodeInfoOrBuilder
    {
      private int bitField0_;
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos.SourceCodeInfo.class, Builder.class);
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
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
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
          location_ = location_;
        }
        else
        {
          location_ = locationBuilder_.build();
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
          if (!location_.isEmpty())
          {
            if (location_.isEmpty())
            {
              location_ = location_;
              bitField0_ &= 0xFFFFFFFE;
            }
            else
            {
              ensureLocationIsMutable();
              location_.addAll(location_);
            }
            onChanged();
          }
        }
        else if (!location_.isEmpty()) {
          if (locationBuilder_.isEmpty())
          {
            locationBuilder_.dispose();
            locationBuilder_ = null;
            location_ = location_;
            bitField0_ &= 0xFFFFFFFE;
            locationBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? getLocationFieldBuilder() : null);
          }
          else
          {
            locationBuilder_.addAllMessages(location_);
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
    
    static
    {
      defaultInstance = new SourceCodeInfo(true);
      defaultInstance.initFields();
    }
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  static
  {
    String[] descriptorData = { "\n google/protobuf/descriptor.proto\022\017google.protobuf\"G\n\021FileDescriptorSet\0222\n\004file\030\001 \003(\0132$.google.protobuf.FileDescriptorProto\"Ë\003\n\023FileDescriptorProto\022\f\n\004name\030\001 \001(\t\022\017\n\007package\030\002 \001(\t\022\022\n\ndependency\030\003 \003(\t\022\031\n\021public_dependency\030\n \003(\005\022\027\n\017weak_dependency\030\013 \003(\005\0226\n\fmessage_type\030\004 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\005 \003(\0132$.google.protobuf.EnumDescriptorProto\0228\n\007service\030\006 \003(\0132'.google.protobuf.", "ServiceDescriptorProto\0228\n\textension\030\007 \003(\0132%.google.protobuf.FieldDescriptorProto\022-\n\007options\030\b \001(\0132\034.google.protobuf.FileOptions\0229\n\020source_code_info\030\t \001(\0132\037.google.protobuf.SourceCodeInfo\"©\003\n\017DescriptorProto\022\f\n\004name\030\001 \001(\t\0224\n\005field\030\002 \003(\0132%.google.protobuf.FieldDescriptorProto\0228\n\textension\030\006 \003(\0132%.google.protobuf.FieldDescriptorProto\0225\n\013nested_type\030\003 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type", "\030\004 \003(\0132$.google.protobuf.EnumDescriptorProto\022H\n\017extension_range\030\005 \003(\0132/.google.protobuf.DescriptorProto.ExtensionRange\0220\n\007options\030\007 \001(\0132\037.google.protobuf.MessageOptions\032,\n\016ExtensionRange\022\r\n\005start\030\001 \001(\005\022\013\n\003end\030\002 \001(\005\"\005\n\024FieldDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\003 \001(\005\022:\n\005label\030\004 \001(\0162+.google.protobuf.FieldDescriptorProto.Label\0228\n\004type\030\005 \001(\0162*.google.protobuf.FieldDescriptorProto.Type\022\021\n\ttype_name", "\030\006 \001(\t\022\020\n\bextendee\030\002 \001(\t\022\025\n\rdefault_value\030\007 \001(\t\022.\n\007options\030\b \001(\0132\035.google.protobuf.FieldOptions\"¶\002\n\004Type\022\017\n\013TYPE_DOUBLE\020\001\022\016\n\nTYPE_FLOAT\020\002\022\016\n\nTYPE_INT64\020\003\022\017\n\013TYPE_UINT64\020\004\022\016\n\nTYPE_INT32\020\005\022\020\n\fTYPE_FIXED64\020\006\022\020\n\fTYPE_FIXED32\020\007\022\r\n\tTYPE_BOOL\020\b\022\017\n\013TYPE_STRING\020\t\022\016\n\nTYPE_GROUP\020\n\022\020\n\fTYPE_MESSAGE\020\013\022\016\n\nTYPE_BYTES\020\f\022\017\n\013TYPE_UINT32\020\r\022\r\n\tTYPE_ENUM\020\016\022\021\n\rTYPE_SFIXED32\020\017\022\021\n\rTYPE_SFIXED64\020\020\022\017\n\013TYPE_SINT32\020\021\022\017\n\013TYPE_", "SINT64\020\022\"C\n\005Label\022\022\n\016LABEL_OPTIONAL\020\001\022\022\n\016LABEL_REQUIRED\020\002\022\022\n\016LABEL_REPEATED\020\003\"\001\n\023EnumDescriptorProto\022\f\n\004name\030\001 \001(\t\0228\n\005value\030\002 \003(\0132).google.protobuf.EnumValueDescriptorProto\022-\n\007options\030\003 \001(\0132\034.google.protobuf.EnumOptions\"l\n\030EnumValueDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\002 \001(\005\0222\n\007options\030\003 \001(\0132!.google.protobuf.EnumValueOptions\"\001\n\026ServiceDescriptorProto\022\f\n\004name\030\001 \001(\t\0226\n\006method\030\002 \003(\0132&.google.pro", "tobuf.MethodDescriptorProto\0220\n\007options\030\003 \001(\0132\037.google.protobuf.ServiceOptions\"\n\025MethodDescriptorProto\022\f\n\004name\030\001 \001(\t\022\022\n\ninput_type\030\002 \001(\t\022\023\n\013output_type\030\003 \001(\t\022/\n\007options\030\004 \001(\0132\036.google.protobuf.MethodOptions\"é\003\n\013FileOptions\022\024\n\fjava_package\030\001 \001(\t\022\034\n\024java_outer_classname\030\b \001(\t\022\"\n\023java_multiple_files\030\n \001(\b:\005false\022,\n\035java_generate_equals_and_hash\030\024 \001(\b:\005false\022F\n\foptimize_for\030\t \001(\0162).google.protobuf.Fil", "eOptions.OptimizeMode:\005SPEED\022\022\n\ngo_package\030\013 \001(\t\022\"\n\023cc_generic_services\030\020 \001(\b:\005false\022$\n\025java_generic_services\030\021 \001(\b:\005false\022\"\n\023py_generic_services\030\022 \001(\b:\005false\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\022\t\n\005SPEED\020\001\022\r\n\tCODE_SIZE\020\002\022\020\n\fLITE_RUNTIME\020\003*\t\bè\007\020\002\"¸\001\n\016MessageOptions\022&\n\027message_set_wire_format\030\001 \001(\b:\005false\022.\n\037no_standard_descriptor_accessor\030\002 \001(\b:\005", "false\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"¾\002\n\fFieldOptions\022:\n\005ctype\030\001 \001(\0162#.google.protobuf.FieldOptions.CType:\006STRING\022\016\n\006packed\030\002 \001(\b\022\023\n\004lazy\030\005 \001(\b:\005false\022\031\n\ndeprecated\030\003 \001(\b:\005false\022\034\n\024experimental_map_key\030\t \001(\t\022\023\n\004weak\030\n \001(\b:\005false\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption\"/\n\005CType\022\n\n\006STRING\020\000\022\b\n\004CORD\020\001\022\020\n\fSTRING_PIECE\020\002*\t\bè\007", "\020\002\"x\n\013EnumOptions\022\031\n\013allow_alias\030\002 \001(\b:\004true\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"b\n\020EnumValueOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"`\n\016ServiceOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"_\n\rMethodOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.Uninter", "pretedOption*\t\bè\007\020\002\"\002\n\023UninterpretedOption\022;\n\004name\030\002 \003(\0132-.google.protobuf.UninterpretedOption.NamePart\022\030\n\020identifier_value\030\003 \001(\t\022\032\n\022positive_int_value\030\004 \001(\004\022\032\n\022negative_int_value\030\005 \001(\003\022\024\n\fdouble_value\030\006 \001(\001\022\024\n\fstring_value\030\007 \001(\f\022\027\n\017aggregate_value\030\b \001(\t\0323\n\bNamePart\022\021\n\tname_part\030\001 \002(\t\022\024\n\fis_extension\030\002 \002(\b\"±\001\n\016SourceCodeInfo\022:\n\blocation\030\001 \003(\0132(.google.protobuf.SourceCodeInfo.Location\032c\n\bLocat", "ion\022\020\n\004path\030\001 \003(\005B\002\020\001\022\020\n\004span\030\002 \003(\005B\002\020\001\022\030\n\020leading_comments\030\003 \001(\t\022\031\n\021trailing_comments\030\004 \001(\tB)\n\023com.google.protobufB\020DescriptorProtosH\001" };
    
    Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
      {
        DescriptorProtos.access$21602(root);
        DescriptorProtos.access$002((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(0));
        
        DescriptorProtos.access$102(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[] { "File" }));
        
        DescriptorProtos.access$702((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(1));
        
        DescriptorProtos.access$802(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[] { "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo" }));
        
        DescriptorProtos.access$2502((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(2));
        
        DescriptorProtos.access$2602(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options" }));
        
        DescriptorProtos.access$2802((Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0));
        
        DescriptorProtos.access$2902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor, new String[] { "Start", "End" }));
        
        DescriptorProtos.access$4802((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(3));
        
        DescriptorProtos.access$4902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options" }));
        
        DescriptorProtos.access$6302((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(4));
        
        DescriptorProtos.access$6402(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[] { "Name", "Value", "Options" }));
        
        DescriptorProtos.access$7302((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(5));
        
        DescriptorProtos.access$7402(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor, new String[] { "Name", "Number", "Options" }));
        
        DescriptorProtos.access$8302((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(6));
        
        DescriptorProtos.access$8402(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor, new String[] { "Name", "Method", "Options" }));
        
        DescriptorProtos.access$9302((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(7));
        
        DescriptorProtos.access$9402(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[] { "Name", "InputType", "OutputType", "Options" }));
        
        DescriptorProtos.access$10402((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(8));
        
        DescriptorProtos.access$10502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption" }));
        
        DescriptorProtos.access$12102((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(9));
        
        DescriptorProtos.access$12202(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption" }));
        
        DescriptorProtos.access$13102((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(10));
        
        DescriptorProtos.access$13202(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[] { "Ctype", "Packed", "Lazy", "Deprecated", "ExperimentalMapKey", "Weak", "UninterpretedOption" }));
        
        DescriptorProtos.access$14502((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(11));
        
        DescriptorProtos.access$14602(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[] { "AllowAlias", "UninterpretedOption" }));
        
        DescriptorProtos.access$15402((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(12));
        
        DescriptorProtos.access$15502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[] { "UninterpretedOption" }));
        
        DescriptorProtos.access$16102((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(13));
        
        DescriptorProtos.access$16202(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[] { "UninterpretedOption" }));
        
        DescriptorProtos.access$16802((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(14));
        
        DescriptorProtos.access$16902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[] { "UninterpretedOption" }));
        
        DescriptorProtos.access$17502((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(15));
        
        DescriptorProtos.access$17602(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue" }));
        
        DescriptorProtos.access$17802((Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0));
        
        DescriptorProtos.access$17902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor, new String[] { "NamePart", "IsExtension" }));
        
        DescriptorProtos.access$19802((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(16));
        
        DescriptorProtos.access$19902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor, new String[] { "Location" }));
        
        DescriptorProtos.access$20102((Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor.getNestedTypes().get(0));
        
        DescriptorProtos.access$20202(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor, new String[] { "Path", "Span", "LeadingComments", "TrailingComments" }));
        
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */