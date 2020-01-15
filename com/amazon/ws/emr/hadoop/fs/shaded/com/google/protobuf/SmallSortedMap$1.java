package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class SmallSortedMap$1
  extends SmallSortedMap<FieldDescriptorType, Object>
{
  SmallSortedMap$1(int x0)
  {
    super(x0, null);
  }
  
  public void makeImmutable()
  {
    if (!isImmutable())
    {
      for (int i = 0; i < getNumArrayEntries(); i++)
      {
        Map.Entry<FieldDescriptorType, Object> entry = getArrayEntryAt(i);
        if (((FieldSet.FieldDescriptorLite)entry.getKey()).isRepeated())
        {
          List value = (List)entry.getValue();
          entry.setValue(Collections.unmodifiableList(value));
        }
      }
      for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
        if (((FieldSet.FieldDescriptorLite)entry.getKey()).isRepeated())
        {
          List value = (List)entry.getValue();
          entry.setValue(Collections.unmodifiableList(value));
        }
      }
    }
    super.makeImmutable();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SmallSortedMap.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */