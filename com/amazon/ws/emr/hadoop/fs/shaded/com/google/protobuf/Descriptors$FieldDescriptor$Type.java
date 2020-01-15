package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public enum Descriptors$FieldDescriptor$Type
{
  DOUBLE(Descriptors.FieldDescriptor.JavaType.DOUBLE),  FLOAT(Descriptors.FieldDescriptor.JavaType.FLOAT),  INT64(Descriptors.FieldDescriptor.JavaType.LONG),  UINT64(Descriptors.FieldDescriptor.JavaType.LONG),  INT32(Descriptors.FieldDescriptor.JavaType.INT),  FIXED64(Descriptors.FieldDescriptor.JavaType.LONG),  FIXED32(Descriptors.FieldDescriptor.JavaType.INT),  BOOL(Descriptors.FieldDescriptor.JavaType.BOOLEAN),  STRING(Descriptors.FieldDescriptor.JavaType.STRING),  GROUP(Descriptors.FieldDescriptor.JavaType.MESSAGE),  MESSAGE(Descriptors.FieldDescriptor.JavaType.MESSAGE),  BYTES(Descriptors.FieldDescriptor.JavaType.BYTE_STRING),  UINT32(Descriptors.FieldDescriptor.JavaType.INT),  ENUM(Descriptors.FieldDescriptor.JavaType.ENUM),  SFIXED32(Descriptors.FieldDescriptor.JavaType.INT),  SFIXED64(Descriptors.FieldDescriptor.JavaType.LONG),  SINT32(Descriptors.FieldDescriptor.JavaType.INT),  SINT64(Descriptors.FieldDescriptor.JavaType.LONG);
  
  private Descriptors.FieldDescriptor.JavaType javaType;
  
  private Descriptors$FieldDescriptor$Type(Descriptors.FieldDescriptor.JavaType javaType)
  {
    this.javaType = javaType;
  }
  
  public DescriptorProtos.FieldDescriptorProto.Type toProto()
  {
    return DescriptorProtos.FieldDescriptorProto.Type.valueOf(ordinal() + 1);
  }
  
  public Descriptors.FieldDescriptor.JavaType getJavaType()
  {
    return javaType;
  }
  
  public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type)
  {
    return values()[(type.getNumber() - 1)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FieldDescriptor.Type
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */