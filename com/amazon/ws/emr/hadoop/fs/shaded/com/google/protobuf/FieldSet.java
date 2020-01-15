package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>>
{
  private final SmallSortedMap<FieldDescriptorType, Object> fields;
  private boolean isImmutable;
  private boolean hasLazyField = false;
  
  private FieldSet()
  {
    fields = SmallSortedMap.newFieldMap(16);
  }
  
  private FieldSet(boolean dummy)
  {
    fields = SmallSortedMap.newFieldMap(0);
    makeImmutable();
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet()
  {
    return new FieldSet();
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet()
  {
    return DEFAULT_INSTANCE;
  }
  
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  
  public void makeImmutable()
  {
    if (isImmutable) {
      return;
    }
    fields.makeImmutable();
    isImmutable = true;
  }
  
  public boolean isImmutable()
  {
    return isImmutable;
  }
  
  public FieldSet<FieldDescriptorType> clone()
  {
    FieldSet<FieldDescriptorType> clone = newFieldSet();
    for (int i = 0; i < fields.getNumArrayEntries(); i++)
    {
      Map.Entry<FieldDescriptorType, Object> entry = fields.getArrayEntryAt(i);
      FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
      clone.setField(descriptor, entry.getValue());
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries())
    {
      FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
      clone.setField(descriptor, entry.getValue());
    }
    hasLazyField = hasLazyField;
    return clone;
  }
  
  public void clear()
  {
    fields.clear();
    hasLazyField = false;
  }
  
  public Map<FieldDescriptorType, Object> getAllFields()
  {
    if (hasLazyField)
    {
      SmallSortedMap<FieldDescriptorType, Object> result = SmallSortedMap.newFieldMap(16);
      for (int i = 0; i < fields.getNumArrayEntries(); i++) {
        cloneFieldEntry(result, fields.getArrayEntryAt(i));
      }
      for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
        cloneFieldEntry(result, entry);
      }
      if (fields.isImmutable()) {
        result.makeImmutable();
      }
      return result;
    }
    return fields.isImmutable() ? fields : Collections.unmodifiableMap(fields);
  }
  
  private void cloneFieldEntry(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry)
  {
    FieldDescriptorType key = (FieldDescriptorLite)entry.getKey();
    Object value = entry.getValue();
    if ((value instanceof LazyField)) {
      map.put(key, ((LazyField)value).getValue());
    } else {
      map.put(key, value);
    }
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (hasLazyField) {
      return new LazyField.LazyIterator(fields.entrySet().iterator());
    }
    return fields.entrySet().iterator();
  }
  
  public boolean hasField(FieldDescriptorType descriptor)
  {
    if (descriptor.isRepeated()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return fields.get(descriptor) != null;
  }
  
  public Object getField(FieldDescriptorType descriptor)
  {
    Object o = fields.get(descriptor);
    if ((o instanceof LazyField)) {
      return ((LazyField)o).getValue();
    }
    return o;
  }
  
  public void setField(FieldDescriptorType descriptor, Object value)
  {
    if (descriptor.isRepeated())
    {
      if (!(value instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      List newList = new ArrayList();
      newList.addAll((List)value);
      for (Object element : newList) {
        verifyType(descriptor.getLiteType(), element);
      }
      value = newList;
    }
    else
    {
      verifyType(descriptor.getLiteType(), value);
    }
    if ((value instanceof LazyField)) {
      hasLazyField = true;
    }
    fields.put(descriptor, value);
  }
  
  public void clearField(FieldDescriptorType descriptor)
  {
    fields.remove(descriptor);
    if (fields.isEmpty()) {
      hasLazyField = false;
    }
  }
  
  public int getRepeatedFieldCount(FieldDescriptorType descriptor)
  {
    if (!descriptor.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    Object value = getField(descriptor);
    if (value == null) {
      return 0;
    }
    return ((List)value).size();
  }
  
  public Object getRepeatedField(FieldDescriptorType descriptor, int index)
  {
    if (!descriptor.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    Object value = getField(descriptor);
    if (value == null) {
      throw new IndexOutOfBoundsException();
    }
    return ((List)value).get(index);
  }
  
  public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value)
  {
    if (!descriptor.isRepeated()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    Object list = getField(descriptor);
    if (list == null) {
      throw new IndexOutOfBoundsException();
    }
    verifyType(descriptor.getLiteType(), value);
    ((List)list).set(index, value);
  }
  
  public void addRepeatedField(FieldDescriptorType descriptor, Object value)
  {
    if (!descriptor.isRepeated()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    verifyType(descriptor.getLiteType(), value);
    
    Object existingValue = getField(descriptor);
    List<Object> list;
    if (existingValue == null)
    {
      List<Object> list = new ArrayList();
      fields.put(descriptor, list);
    }
    else
    {
      list = (List)existingValue;
    }
    list.add(value);
  }
  
  private static void verifyType(WireFormat.FieldType type, Object value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    boolean isValid = false;
    switch (type.getJavaType())
    {
    case INT: 
      isValid = value instanceof Integer; break;
    case LONG: 
      isValid = value instanceof Long; break;
    case FLOAT: 
      isValid = value instanceof Float; break;
    case DOUBLE: 
      isValid = value instanceof Double; break;
    case BOOLEAN: 
      isValid = value instanceof Boolean; break;
    case STRING: 
      isValid = value instanceof String; break;
    case BYTE_STRING: 
      isValid = value instanceof ByteString; break;
    case ENUM: 
      isValid = value instanceof Internal.EnumLite;
      break;
    case MESSAGE: 
      isValid = ((value instanceof MessageLite)) || ((value instanceof LazyField));
    }
    if (!isValid) {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
  }
  
  public boolean isInitialized()
  {
    for (int i = 0; i < fields.getNumArrayEntries(); i++) {
      if (!isInitialized(fields.getArrayEntryAt(i))) {
        return false;
      }
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      if (!isInitialized(entry)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry)
  {
    FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
    if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
      if (descriptor.isRepeated())
      {
        for (MessageLite element : (List)entry.getValue()) {
          if (!element.isInitialized()) {
            return false;
          }
        }
      }
      else
      {
        Object value = entry.getValue();
        if ((value instanceof MessageLite))
        {
          if (!((MessageLite)value).isInitialized()) {
            return false;
          }
        }
        else
        {
          if ((value instanceof LazyField)) {
            return true;
          }
          throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
      }
    }
    return true;
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType type, boolean isPacked)
  {
    if (isPacked) {
      return 2;
    }
    return type.getWireType();
  }
  
  public void mergeFrom(FieldSet<FieldDescriptorType> other)
  {
    for (int i = 0; i < fields.getNumArrayEntries(); i++) {
      mergeFromField(fields.getArrayEntryAt(i));
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      mergeFromField(entry);
    }
  }
  
  private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry)
  {
    FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
    Object otherValue = entry.getValue();
    if ((otherValue instanceof LazyField)) {
      otherValue = ((LazyField)otherValue).getValue();
    }
    if (descriptor.isRepeated())
    {
      Object value = getField(descriptor);
      if (value == null) {
        fields.put(descriptor, new ArrayList((List)otherValue));
      } else {
        ((List)value).addAll((List)otherValue);
      }
    }
    else if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      Object value = getField(descriptor);
      if (value == null) {
        fields.put(descriptor, otherValue);
      } else {
        fields.put(descriptor, descriptor.internalMergeFrom(((MessageLite)value).toBuilder(), (MessageLite)otherValue).build());
      }
    }
    else
    {
      fields.put(descriptor, otherValue);
    }
  }
  
  public static Object readPrimitiveField(CodedInputStream input, WireFormat.FieldType type)
    throws IOException
  {
    switch (type)
    {
    case DOUBLE: 
      return Double.valueOf(input.readDouble());
    case FLOAT: 
      return Float.valueOf(input.readFloat());
    case INT64: 
      return Long.valueOf(input.readInt64());
    case UINT64: 
      return Long.valueOf(input.readUInt64());
    case INT32: 
      return Integer.valueOf(input.readInt32());
    case FIXED64: 
      return Long.valueOf(input.readFixed64());
    case FIXED32: 
      return Integer.valueOf(input.readFixed32());
    case BOOL: 
      return Boolean.valueOf(input.readBool());
    case STRING: 
      return input.readString();
    case BYTES: 
      return input.readBytes();
    case UINT32: 
      return Integer.valueOf(input.readUInt32());
    case SFIXED32: 
      return Integer.valueOf(input.readSFixed32());
    case SFIXED64: 
      return Long.valueOf(input.readSFixed64());
    case SINT32: 
      return Integer.valueOf(input.readSInt32());
    case SINT64: 
      return Long.valueOf(input.readSInt64());
    case GROUP: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case MESSAGE: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case ENUM: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    }
    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    for (int i = 0; i < fields.getNumArrayEntries(); i++)
    {
      Map.Entry<FieldDescriptorType, Object> entry = fields.getArrayEntryAt(i);
      
      writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), output);
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), output);
    }
  }
  
  public void writeMessageSetTo(CodedOutputStream output)
    throws IOException
  {
    for (int i = 0; i < fields.getNumArrayEntries(); i++) {
      writeMessageSetTo(fields.getArrayEntryAt(i), output);
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      writeMessageSetTo(entry, output);
    }
  }
  
  private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream output)
    throws IOException
  {
    FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
    if ((descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!descriptor.isRepeated()) && (!descriptor.isPacked())) {
      output.writeMessageSetExtension(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)entry.getValue());
    } else {
      writeField(descriptor, entry.getValue(), output);
    }
  }
  
  private static void writeElement(CodedOutputStream output, WireFormat.FieldType type, int number, Object value)
    throws IOException
  {
    if (type == WireFormat.FieldType.GROUP)
    {
      output.writeGroup(number, (MessageLite)value);
    }
    else
    {
      output.writeTag(number, getWireFormatForFieldType(type, false));
      writeElementNoTag(output, type, value);
    }
  }
  
  private static void writeElementNoTag(CodedOutputStream output, WireFormat.FieldType type, Object value)
    throws IOException
  {
    switch (type)
    {
    case DOUBLE: 
      output.writeDoubleNoTag(((Double)value).doubleValue()); break;
    case FLOAT: 
      output.writeFloatNoTag(((Float)value).floatValue()); break;
    case INT64: 
      output.writeInt64NoTag(((Long)value).longValue()); break;
    case UINT64: 
      output.writeUInt64NoTag(((Long)value).longValue()); break;
    case INT32: 
      output.writeInt32NoTag(((Integer)value).intValue()); break;
    case FIXED64: 
      output.writeFixed64NoTag(((Long)value).longValue()); break;
    case FIXED32: 
      output.writeFixed32NoTag(((Integer)value).intValue()); break;
    case BOOL: 
      output.writeBoolNoTag(((Boolean)value).booleanValue()); break;
    case STRING: 
      output.writeStringNoTag((String)value); break;
    case GROUP: 
      output.writeGroupNoTag((MessageLite)value); break;
    case MESSAGE: 
      output.writeMessageNoTag((MessageLite)value); break;
    case BYTES: 
      output.writeBytesNoTag((ByteString)value); break;
    case UINT32: 
      output.writeUInt32NoTag(((Integer)value).intValue()); break;
    case SFIXED32: 
      output.writeSFixed32NoTag(((Integer)value).intValue()); break;
    case SFIXED64: 
      output.writeSFixed64NoTag(((Long)value).longValue()); break;
    case SINT32: 
      output.writeSInt32NoTag(((Integer)value).intValue()); break;
    case SINT64: 
      output.writeSInt64NoTag(((Long)value).longValue()); break;
    case ENUM: 
      output.writeEnumNoTag(((Internal.EnumLite)value).getNumber());
    }
  }
  
  public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output)
    throws IOException
  {
    WireFormat.FieldType type = descriptor.getLiteType();
    int number = descriptor.getNumber();
    if (descriptor.isRepeated())
    {
      List<?> valueList = (List)value;
      if (descriptor.isPacked())
      {
        output.writeTag(number, 2);
        
        int dataSize = 0;
        for (Object element : valueList) {
          dataSize += computeElementSizeNoTag(type, element);
        }
        output.writeRawVarint32(dataSize);
        for (Object element : valueList) {
          writeElementNoTag(output, type, element);
        }
      }
      else
      {
        for (Object element : valueList) {
          writeElement(output, type, number, element);
        }
      }
    }
    else if ((value instanceof LazyField))
    {
      writeElement(output, type, number, ((LazyField)value).getValue());
    }
    else
    {
      writeElement(output, type, number, value);
    }
  }
  
  public int getSerializedSize()
  {
    int size = 0;
    for (int i = 0; i < fields.getNumArrayEntries(); i++)
    {
      Map.Entry<FieldDescriptorType, Object> entry = fields.getArrayEntryAt(i);
      
      size += computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      size += computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
    }
    return size;
  }
  
  public int getMessageSetSerializedSize()
  {
    int size = 0;
    for (int i = 0; i < fields.getNumArrayEntries(); i++) {
      size += getMessageSetSerializedSize(fields.getArrayEntryAt(i));
    }
    for (Map.Entry<FieldDescriptorType, Object> entry : fields.getOverflowEntries()) {
      size += getMessageSetSerializedSize(entry);
    }
    return size;
  }
  
  private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry)
  {
    FieldDescriptorType descriptor = (FieldDescriptorLite)entry.getKey();
    Object value = entry.getValue();
    if ((descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) && (!descriptor.isRepeated()) && (!descriptor.isPacked()))
    {
      if ((value instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite)entry.getKey()).getNumber(), (LazyField)value);
      }
      return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)value);
    }
    return computeFieldSize(descriptor, value);
  }
  
  private static int computeElementSize(WireFormat.FieldType type, int number, Object value)
  {
    int tagSize = CodedOutputStream.computeTagSize(number);
    if (type == WireFormat.FieldType.GROUP) {
      tagSize *= 2;
    }
    return tagSize + computeElementSizeNoTag(type, value);
  }
  
  private static int computeElementSizeNoTag(WireFormat.FieldType type, Object value)
  {
    switch (type)
    {
    case DOUBLE: 
      return CodedOutputStream.computeDoubleSizeNoTag(((Double)value).doubleValue());
    case FLOAT: 
      return CodedOutputStream.computeFloatSizeNoTag(((Float)value).floatValue());
    case INT64: 
      return CodedOutputStream.computeInt64SizeNoTag(((Long)value).longValue());
    case UINT64: 
      return CodedOutputStream.computeUInt64SizeNoTag(((Long)value).longValue());
    case INT32: 
      return CodedOutputStream.computeInt32SizeNoTag(((Integer)value).intValue());
    case FIXED64: 
      return CodedOutputStream.computeFixed64SizeNoTag(((Long)value).longValue());
    case FIXED32: 
      return CodedOutputStream.computeFixed32SizeNoTag(((Integer)value).intValue());
    case BOOL: 
      return CodedOutputStream.computeBoolSizeNoTag(((Boolean)value).booleanValue());
    case STRING: 
      return CodedOutputStream.computeStringSizeNoTag((String)value);
    case GROUP: 
      return CodedOutputStream.computeGroupSizeNoTag((MessageLite)value);
    case BYTES: 
      return CodedOutputStream.computeBytesSizeNoTag((ByteString)value);
    case UINT32: 
      return CodedOutputStream.computeUInt32SizeNoTag(((Integer)value).intValue());
    case SFIXED32: 
      return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)value).intValue());
    case SFIXED64: 
      return CodedOutputStream.computeSFixed64SizeNoTag(((Long)value).longValue());
    case SINT32: 
      return CodedOutputStream.computeSInt32SizeNoTag(((Integer)value).intValue());
    case SINT64: 
      return CodedOutputStream.computeSInt64SizeNoTag(((Long)value).longValue());
    case MESSAGE: 
      if ((value instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)value);
      }
      return CodedOutputStream.computeMessageSizeNoTag((MessageLite)value);
    case ENUM: 
      return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)value).getNumber());
    }
    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
  }
  
  public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value)
  {
    WireFormat.FieldType type = descriptor.getLiteType();
    int number = descriptor.getNumber();
    if (descriptor.isRepeated())
    {
      if (descriptor.isPacked())
      {
        int dataSize = 0;
        for (Object element : (List)value) {
          dataSize += computeElementSizeNoTag(type, element);
        }
        return dataSize + CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeRawVarint32Size(dataSize);
      }
      int size = 0;
      for (Object element : (List)value) {
        size += computeElementSize(type, number, element);
      }
      return size;
    }
    return computeElementSize(type, number, value);
  }
  
  public static abstract interface FieldDescriptorLite<T extends FieldDescriptorLite<T>>
    extends Comparable<T>
  {
    public abstract int getNumber();
    
    public abstract WireFormat.FieldType getLiteType();
    
    public abstract WireFormat.JavaType getLiteJavaType();
    
    public abstract boolean isRepeated();
    
    public abstract boolean isPacked();
    
    public abstract Internal.EnumLiteMap<?> getEnumType();
    
    public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.FieldSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */