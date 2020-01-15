package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage$Builder<BuilderType extends Builder>
  extends AbstractMessage.Builder<BuilderType>
{
  private GeneratedMessage.BuilderParent builderParent;
  private Builder<BuilderType>.BuilderParentImpl meAsParent;
  private boolean isClean;
  private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();
  
  protected GeneratedMessage$Builder()
  {
    this(null);
  }
  
  protected GeneratedMessage$Builder(GeneratedMessage.BuilderParent builderParent)
  {
    this.builderParent = builderParent;
  }
  
  void dispose()
  {
    builderParent = null;
  }
  
  protected void onBuilt()
  {
    if (builderParent != null) {
      markClean();
    }
  }
  
  protected void markClean()
  {
    isClean = true;
  }
  
  protected boolean isClean()
  {
    return isClean;
  }
  
  public BuilderType clone()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public BuilderType clear()
  {
    unknownFields = UnknownFieldSet.getDefaultInstance();
    onChanged();
    return this;
  }
  
  protected abstract GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable();
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return GeneratedMessage.FieldAccessorTable.access$000(internalGetFieldAccessorTable());
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable());
  }
  
  private Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable()
  {
    TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap();
    
    Descriptors.Descriptor descriptor = GeneratedMessage.FieldAccessorTable.access$000(internalGetFieldAccessorTable());
    for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
      if (field.isRepeated())
      {
        List value = (List)getField(field);
        if (!value.isEmpty()) {
          result.put(field, value);
        }
      }
      else if (hasField(field))
      {
        result.put(field, getField(field));
      }
    }
    return result;
  }
  
  public Message.Builder newBuilderForField(Descriptors.FieldDescriptor field)
  {
    return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).newBuilder();
  }
  
  public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field)
  {
    return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).getBuilder(this);
  }
  
  public boolean hasField(Descriptors.FieldDescriptor field)
  {
    return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).has(this);
  }
  
  public Object getField(Descriptors.FieldDescriptor field)
  {
    Object object = GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).get(this);
    if (field.isRepeated()) {
      return Collections.unmodifiableList((List)object);
    }
    return object;
  }
  
  public BuilderType setField(Descriptors.FieldDescriptor field, Object value)
  {
    GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).set(this, value);
    return this;
  }
  
  public BuilderType clearField(Descriptors.FieldDescriptor field)
  {
    GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).clear(this);
    return this;
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
  {
    return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).getRepeatedCount(this);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
  {
    return GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).getRepeated(this, index);
  }
  
  public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value)
  {
    GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).setRepeated(this, index, value);
    
    return this;
  }
  
  public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value)
  {
    GeneratedMessage.FieldAccessorTable.access$100(internalGetFieldAccessorTable(), field).addRepeated(this, value);
    return this;
  }
  
  public final BuilderType setUnknownFields(UnknownFieldSet unknownFields)
  {
    this.unknownFields = unknownFields;
    onChanged();
    return this;
  }
  
  public final BuilderType mergeUnknownFields(UnknownFieldSet unknownFields)
  {
    this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
    
    onChanged();
    return this;
  }
  
  public boolean isInitialized()
  {
    for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields())
    {
      if ((field.isRequired()) && 
        (!hasField(field))) {
        return false;
      }
      if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        if (field.isRepeated())
        {
          List<Message> messageList = (List)getField(field);
          for (Message element : messageList) {
            if (!element.isInitialized()) {
              return false;
            }
          }
        }
        else if ((hasField(field)) && (!((Message)getField(field)).isInitialized()))
        {
          return false;
        }
      }
    }
    return true;
  }
  
  public final UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag)
    throws IOException
  {
    return unknownFields.mergeFieldFrom(tag, input);
  }
  
  private class BuilderParentImpl
    implements GeneratedMessage.BuilderParent
  {
    private BuilderParentImpl() {}
    
    public void markDirty()
    {
      onChanged();
    }
  }
  
  protected GeneratedMessage.BuilderParent getParentForChildren()
  {
    if (meAsParent == null) {
      meAsParent = new BuilderParentImpl(null);
    }
    return meAsParent;
  }
  
  protected final void onChanged()
  {
    if ((isClean) && (builderParent != null))
    {
      builderParent.markDirty();
      
      isClean = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessage.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */