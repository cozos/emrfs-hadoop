package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

final class $FieldWriter
  implements .FieldVisitor
{
  FieldWriter a;
  private final .ClassWriter b;
  private final int c;
  private final int d;
  private final int e;
  private int f;
  private int g;
  private .AnnotationWriter h;
  private .AnnotationWriter i;
  private .Attribute j;
  
  $FieldWriter(.ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    if (y == null) {
      y = this;
    } else {
      z.a = this;
    }
    z = this;
    b = paramClassWriter;
    c = paramInt;
    d = paramClassWriter.newUTF8(paramString1);
    e = paramClassWriter.newUTF8(paramString2);
    if (paramString3 != null) {
      f = paramClassWriter.newUTF8(paramString3);
    }
    if (paramObject != null) {
      g = aa;
    }
  }
  
  public .AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    .ByteVector localByteVector = new .ByteVector();
    localByteVector.putShort(b.newUTF8(paramString)).putShort(0);
    .AnnotationWriter localAnnotationWriter = new .AnnotationWriter(b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      g = h;
      h = localAnnotationWriter;
    }
    else
    {
      g = i;
      i = localAnnotationWriter;
    }
    return localAnnotationWriter;
  }
  
  public void visitAttribute(.Attribute paramAttribute)
  {
    a = j;
    j = paramAttribute;
  }
  
  public void visitEnd() {}
  
  int a()
  {
    int k = 8;
    if (g != 0)
    {
      b.newUTF8("ConstantValue");
      k += 8;
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49))
    {
      b.newUTF8("Synthetic");
      k += 6;
    }
    if ((c & 0x20000) != 0)
    {
      b.newUTF8("Deprecated");
      k += 6;
    }
    if (f != 0)
    {
      b.newUTF8("Signature");
      k += 8;
    }
    if (h != null)
    {
      b.newUTF8("RuntimeVisibleAnnotations");
      k += 8 + h.a();
    }
    if (i != null)
    {
      b.newUTF8("RuntimeInvisibleAnnotations");
      k += 8 + i.a();
    }
    if (j != null) {
      k += j.a(b, null, 0, -1, -1);
    }
    return k;
  }
  
  void a(.ByteVector paramByteVector)
  {
    paramByteVector.putShort(c).putShort(d).putShort(e);
    int k = 0;
    if (g != 0) {
      k++;
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49)) {
      k++;
    }
    if ((c & 0x20000) != 0) {
      k++;
    }
    if (f != 0) {
      k++;
    }
    if (h != null) {
      k++;
    }
    if (i != null) {
      k++;
    }
    if (j != null) {
      k += j.a();
    }
    paramByteVector.putShort(k);
    if (g != 0)
    {
      paramByteVector.putShort(b.newUTF8("ConstantValue"));
      paramByteVector.putInt(2).putShort(g);
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49)) {
      paramByteVector.putShort(b.newUTF8("Synthetic")).putInt(0);
    }
    if ((c & 0x20000) != 0) {
      paramByteVector.putShort(b.newUTF8("Deprecated")).putInt(0);
    }
    if (f != 0)
    {
      paramByteVector.putShort(b.newUTF8("Signature"));
      paramByteVector.putInt(2).putShort(f);
    }
    if (h != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeVisibleAnnotations"));
      h.a(paramByteVector);
    }
    if (i != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeInvisibleAnnotations"));
      i.a(paramByteVector);
    }
    if (j != null) {
      j.a(b, null, 0, -1, -1, paramByteVector);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..FieldWriter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */