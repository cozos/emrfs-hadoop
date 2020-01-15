package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter
{
  private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter = GeneratedMessage.ExtendableMessage.access$600(this$0).iterator();
  private Map.Entry<Descriptors.FieldDescriptor, Object> next;
  private final boolean messageSetWireFormat;
  
  private GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage.ExtendableMessage paramExtendableMessage, boolean messageSetWireFormat)
  {
    if (iter.hasNext()) {
      next = ((Map.Entry)iter.next());
    }
    this.messageSetWireFormat = messageSetWireFormat;
  }
  
  public void writeUntil(int end, CodedOutputStream output)
    throws IOException
  {
    while ((next != null) && (((Descriptors.FieldDescriptor)next.getKey()).getNumber() < end))
    {
      Descriptors.FieldDescriptor descriptor = (Descriptors.FieldDescriptor)next.getKey();
      if ((messageSetWireFormat) && (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!descriptor.isRepeated()))
      {
        if ((next instanceof LazyField.LazyEntry)) {
          output.writeRawMessageSetExtension(descriptor.getNumber(), ((LazyField.LazyEntry)next).getField().toByteString());
        } else {
          output.writeMessageSetExtension(descriptor.getNumber(), (Message)next.getValue());
        }
      }
      else {
        FieldSet.writeField(descriptor, next.getValue(), output);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.ExtendableMessage.ExtensionWriter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */