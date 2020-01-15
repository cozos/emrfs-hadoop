package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends ExtendableMessage<MessageType>>
  extends GeneratedMessageLite
  implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType>
{
  private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;
  
  protected GeneratedMessageLite$ExtendableMessage()
  {
    extensions = FieldSet.newFieldSet();
  }
  
  protected GeneratedMessageLite$ExtendableMessage(GeneratedMessageLite.ExtendableBuilder<MessageType, ?> builder)
  {
    extensions = GeneratedMessageLite.ExtendableBuilder.access$000(builder);
  }
  
  private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType, ?> extension)
  {
    if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
      throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }
  }
  
  public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    return extensions.hasField(GeneratedMessageLite.GeneratedExtension.access$100(extension));
  }
  
  public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension)
  {
    verifyExtensionContainingType(extension);
    return extensions.getRepeatedFieldCount(GeneratedMessageLite.GeneratedExtension.access$100(extension));
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension)
  {
    verifyExtensionContainingType(extension);
    Object value = extensions.getField(GeneratedMessageLite.GeneratedExtension.access$100(extension));
    if (value == null) {
      return (Type)GeneratedMessageLite.GeneratedExtension.access$200(extension);
    }
    return (Type)value;
  }
  
  public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index)
  {
    verifyExtensionContainingType(extension);
    return (Type)extensions.getRepeatedField(GeneratedMessageLite.GeneratedExtension.access$100(extension), index);
  }
  
  protected boolean extensionsAreInitialized()
  {
    return extensions.isInitialized();
  }
  
  protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return GeneratedMessageLite.access$300(extensions, getDefaultInstanceForType(), input, extensionRegistry, tag);
  }
  
  protected void makeExtensionsImmutable()
  {
    extensions.makeImmutable();
  }
  
  protected class ExtensionWriter
  {
    private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = extensions.iterator();
    private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
    private final boolean messageSetWireFormat;
    
    private ExtensionWriter(boolean messageSetWireFormat)
    {
      if (iter.hasNext()) {
        next = ((Map.Entry)iter.next());
      }
      this.messageSetWireFormat = messageSetWireFormat;
    }
    
    public void writeUntil(int end, CodedOutputStream output)
      throws IOException
    {
      while ((next != null) && (((GeneratedMessageLite.ExtensionDescriptor)next.getKey()).getNumber() < end))
      {
        GeneratedMessageLite.ExtensionDescriptor extension = (GeneratedMessageLite.ExtensionDescriptor)next.getKey();
        if ((messageSetWireFormat) && (extension.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!extension.isRepeated())) {
          output.writeMessageSetExtension(extension.getNumber(), (MessageLite)next.getValue());
        } else {
          FieldSet.writeField(extension, next.getValue(), output);
        }
        if (iter.hasNext()) {
          next = ((Map.Entry)iter.next());
        } else {
          next = null;
        }
      }
    }
  }
  
  protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter()
  {
    return new ExtensionWriter(false, null);
  }
  
  protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter()
  {
    return new ExtensionWriter(true, null);
  }
  
  protected int extensionsSerializedSize()
  {
    return extensions.getSerializedSize();
  }
  
  protected int extensionsSerializedSizeAsMessageSet()
  {
    return extensions.getMessageSetSerializedSize();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.ExtendableMessage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */