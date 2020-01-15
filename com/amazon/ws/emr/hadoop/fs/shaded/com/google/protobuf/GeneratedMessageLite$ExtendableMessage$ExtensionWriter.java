package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter
{
  private final Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = GeneratedMessageLite.ExtendableMessage.access$400(this$0).iterator();
  private Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;
  private final boolean messageSetWireFormat;
  
  private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite.ExtendableMessage paramExtendableMessage, boolean messageSetWireFormat)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */