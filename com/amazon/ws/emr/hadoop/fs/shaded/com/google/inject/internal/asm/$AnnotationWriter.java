package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

final class $AnnotationWriter
  implements .AnnotationVisitor
{
  private final .ClassWriter a;
  private int b;
  private final boolean c;
  private final .ByteVector d;
  private final .ByteVector e;
  private final int f;
  AnnotationWriter g;
  AnnotationWriter h;
  
  $AnnotationWriter(.ClassWriter paramClassWriter, boolean paramBoolean, .ByteVector paramByteVector1, .ByteVector paramByteVector2, int paramInt)
  {
    a = paramClassWriter;
    c = paramBoolean;
    d = paramByteVector1;
    e = paramByteVector2;
    f = paramInt;
  }
  
  public void visit(String paramString, Object paramObject)
  {
    b += 1;
    if (c) {
      d.putShort(a.newUTF8(paramString));
    }
    if ((paramObject instanceof String))
    {
      d.b(115, a.newUTF8((String)paramObject));
    }
    else if ((paramObject instanceof Byte))
    {
      d.b(66, a.a(((Byte)paramObject).byteValue()).a);
    }
    else if ((paramObject instanceof Boolean))
    {
      int i = ((Boolean)paramObject).booleanValue() ? 1 : 0;
      d.b(90, a.a(i).a);
    }
    else if ((paramObject instanceof Character))
    {
      d.b(67, a.a(((Character)paramObject).charValue()).a);
    }
    else if ((paramObject instanceof Short))
    {
      d.b(83, a.a(((Short)paramObject).shortValue()).a);
    }
    else if ((paramObject instanceof .Type))
    {
      d.b(99, a.newUTF8(((.Type)paramObject).getDescriptor()));
    }
    else
    {
      Object localObject;
      int j;
      if ((paramObject instanceof byte[]))
      {
        localObject = (byte[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(66, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof boolean[]))
      {
        localObject = (boolean[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(90, a.a(localObject[j] != 0 ? 1 : 0).a);
        }
      }
      else if ((paramObject instanceof short[]))
      {
        localObject = (short[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(83, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof char[]))
      {
        localObject = (char[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(67, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof int[]))
      {
        localObject = (int[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(73, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof long[]))
      {
        localObject = (long[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(74, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof float[]))
      {
        localObject = (float[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(70, a.a(localObject[j]).a);
        }
      }
      else if ((paramObject instanceof double[]))
      {
        localObject = (double[])paramObject;
        d.b(91, localObject.length);
        for (j = 0; j < localObject.length; j++) {
          d.b(68, a.a(localObject[j]).a);
        }
      }
      else
      {
        localObject = a.a(paramObject);
        d.b(".s.IFJDCS".charAt(b), a);
      }
    }
  }
  
  public void visitEnum(String paramString1, String paramString2, String paramString3)
  {
    b += 1;
    if (c) {
      d.putShort(a.newUTF8(paramString1));
    }
    d.b(101, a.newUTF8(paramString2)).putShort(a.newUTF8(paramString3));
  }
  
  public .AnnotationVisitor visitAnnotation(String paramString1, String paramString2)
  {
    b += 1;
    if (c) {
      d.putShort(a.newUTF8(paramString1));
    }
    d.b(64, a.newUTF8(paramString2)).putShort(0);
    return new AnnotationWriter(a, true, d, d, d.b - 2);
  }
  
  public .AnnotationVisitor visitArray(String paramString)
  {
    b += 1;
    if (c) {
      d.putShort(a.newUTF8(paramString));
    }
    d.b(91, 0);
    return new AnnotationWriter(a, false, d, d, d.b - 2);
  }
  
  public void visitEnd()
  {
    if (e != null)
    {
      byte[] arrayOfByte = e.a;
      arrayOfByte[f] = ((byte)(b >>> 8));
      arrayOfByte[(f + 1)] = ((byte)b);
    }
  }
  
  int a()
  {
    int i = 0;
    for (AnnotationWriter localAnnotationWriter = this; localAnnotationWriter != null; localAnnotationWriter = g) {
      i += d.b;
    }
    return i;
  }
  
  void a(.ByteVector paramByteVector)
  {
    int i = 0;
    int j = 2;
    Object localObject1 = this;
    Object localObject2 = null;
    while (localObject1 != null)
    {
      i++;
      j += d.b;
      ((AnnotationWriter)localObject1).visitEnd();
      h = ((AnnotationWriter)localObject2);
      localObject2 = localObject1;
      localObject1 = g;
    }
    paramByteVector.putInt(j);
    paramByteVector.putShort(i);
    for (localObject1 = localObject2; localObject1 != null; localObject1 = h) {
      paramByteVector.putByteArray(d.a, 0, d.b);
    }
  }
  
  static void a(AnnotationWriter[] paramArrayOfAnnotationWriter, int paramInt, .ByteVector paramByteVector)
  {
    int i = 1 + 2 * (paramArrayOfAnnotationWriter.length - paramInt);
    for (int j = paramInt; j < paramArrayOfAnnotationWriter.length; j++) {
      i += (paramArrayOfAnnotationWriter[j] == null ? 0 : paramArrayOfAnnotationWriter[j].a());
    }
    paramByteVector.putInt(i).putByte(paramArrayOfAnnotationWriter.length - paramInt);
    for (j = paramInt; j < paramArrayOfAnnotationWriter.length; j++)
    {
      Object localObject1 = paramArrayOfAnnotationWriter[j];
      Object localObject2 = null;
      int k = 0;
      while (localObject1 != null)
      {
        k++;
        ((AnnotationWriter)localObject1).visitEnd();
        h = ((AnnotationWriter)localObject2);
        localObject2 = localObject1;
        localObject1 = g;
      }
      paramByteVector.putShort(k);
      for (localObject1 = localObject2; localObject1 != null; localObject1 = h) {
        paramByteVector.putByteArray(d.a, 0, d.b);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..AnnotationWriter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */