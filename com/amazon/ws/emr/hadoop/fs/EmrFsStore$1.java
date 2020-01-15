package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.Descriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FileDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ExtensionRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import java.util.List;

final class EmrFsStore$1
  implements Descriptors.FileDescriptor.InternalDescriptorAssigner
{
  public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root)
  {
    EmrFsStore.access$1102(root);
    EmrFsStore.access$002(
      (Descriptors.Descriptor)EmrFsStore.getDescriptor().getMessageTypes().get(0));
    EmrFsStore.access$102(new GeneratedMessage.FieldAccessorTable(
    
      EmrFsStore.access$000(), new String[] { "Version", "State", "IsDirectory" }));
    
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */