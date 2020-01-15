package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

public class $ClassWriter
  implements .ClassVisitor
{
  public static final int COMPUTE_MAXS = 1;
  public static final int COMPUTE_FRAMES = 2;
  static final byte[] a;
  .ClassReader J;
  int b;
  int c = 1;
  final .ByteVector d = new .ByteVector();
  .Item[] e = new .Item['Ā'];
  int f = (int)(0.75D * e.length);
  final .Item g = new .Item();
  final .Item h = new .Item();
  final .Item i = new .Item();
  .Item[] E;
  private short D;
  private int j;
  private int k;
  String F;
  private int l;
  private int m;
  private int n;
  private int[] o;
  private int p;
  private .ByteVector q;
  private int r;
  private int s;
  private .AnnotationWriter t;
  private .AnnotationWriter u;
  private .Attribute v;
  private int w;
  private .ByteVector x;
  .FieldWriter y;
  .FieldWriter z;
  .MethodWriter A;
  .MethodWriter B;
  private final boolean H;
  private final boolean G;
  boolean I;
  
  public $ClassWriter(int paramInt)
  {
    H = ((paramInt & 0x1) != 0);
    G = ((paramInt & 0x2) != 0);
  }
  
  public $ClassWriter(.ClassReader paramClassReader, int paramInt)
  {
    this(paramInt);
    paramClassReader.a(this);
    J = paramClassReader;
  }
  
  public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    b = paramInt1;
    j = paramInt2;
    k = newClass(paramString1);
    F = paramString1;
    if (paramString2 != null) {
      l = newUTF8(paramString2);
    }
    m = (paramString3 == null ? 0 : newClass(paramString3));
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      n = paramArrayOfString.length;
      o = new int[n];
      for (int i1 = 0; i1 < n; i1++) {
        o[i1] = newClass(paramArrayOfString[i1]);
      }
    }
  }
  
  public void visitSource(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      p = newUTF8(paramString1);
    }
    if (paramString2 != null) {
      q = new .ByteVector().putUTF8(paramString2);
    }
  }
  
  public void visitOuterClass(String paramString1, String paramString2, String paramString3)
  {
    r = newClass(paramString1);
    if ((paramString2 != null) && (paramString3 != null)) {
      s = newNameType(paramString2, paramString3);
    }
  }
  
  public .AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    .ByteVector localByteVector = new .ByteVector();
    localByteVector.putShort(newUTF8(paramString)).putShort(0);
    .AnnotationWriter localAnnotationWriter = new .AnnotationWriter(this, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      g = t;
      t = localAnnotationWriter;
    }
    else
    {
      g = u;
      u = localAnnotationWriter;
    }
    return localAnnotationWriter;
  }
  
  public void visitAttribute(.Attribute paramAttribute)
  {
    a = v;
    v = paramAttribute;
  }
  
  public void visitInnerClass(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (x == null) {
      x = new .ByteVector();
    }
    w += 1;
    x.putShort(paramString1 == null ? 0 : newClass(paramString1));
    x.putShort(paramString2 == null ? 0 : newClass(paramString2));
    x.putShort(paramString3 == null ? 0 : newUTF8(paramString3));
    x.putShort(paramInt);
  }
  
  public .FieldVisitor visitField(int paramInt, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    return new .FieldWriter(this, paramInt, paramString1, paramString2, paramString3, paramObject);
  }
  
  public .MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    return new .MethodWriter(this, paramInt, paramString1, paramString2, paramString3, paramArrayOfString, H, G);
  }
  
  public void visitEnd() {}
  
  public byte[] toByteArray()
  {
    int i1 = 24 + 2 * n;
    int i2 = 0;
    for (.FieldWriter localFieldWriter = y; localFieldWriter != null; localFieldWriter = a)
    {
      i2++;
      i1 += localFieldWriter.a();
    }
    int i3 = 0;
    for (.MethodWriter localMethodWriter = A; localMethodWriter != null; localMethodWriter = a)
    {
      i3++;
      i1 += localMethodWriter.a();
    }
    int i4 = 0;
    if (l != 0)
    {
      i4++;
      i1 += 8;
      newUTF8("Signature");
    }
    if (p != 0)
    {
      i4++;
      i1 += 8;
      newUTF8("SourceFile");
    }
    if (q != null)
    {
      i4++;
      i1 += q.b + 4;
      newUTF8("SourceDebugExtension");
    }
    if (r != 0)
    {
      i4++;
      i1 += 10;
      newUTF8("EnclosingMethod");
    }
    if ((j & 0x20000) != 0)
    {
      i4++;
      i1 += 6;
      newUTF8("Deprecated");
    }
    if (((j & 0x1000) != 0) && ((b & 0xFFFF) < 49))
    {
      i4++;
      i1 += 6;
      newUTF8("Synthetic");
    }
    if (x != null)
    {
      i4++;
      i1 += 8 + x.b;
      newUTF8("InnerClasses");
    }
    if (t != null)
    {
      i4++;
      i1 += 8 + t.a();
      newUTF8("RuntimeVisibleAnnotations");
    }
    if (u != null)
    {
      i4++;
      i1 += 8 + u.a();
      newUTF8("RuntimeInvisibleAnnotations");
    }
    if (v != null)
    {
      i4 += v.a();
      i1 += v.a(this, null, 0, -1, -1);
    }
    i1 += d.b;
    .ByteVector localByteVector = new .ByteVector(i1);
    localByteVector.putInt(-889275714).putInt(b);
    localByteVector.putShort(c).putByteArray(d.a, 0, d.b);
    localByteVector.putShort(j).putShort(k).putShort(m);
    localByteVector.putShort(n);
    for (int i5 = 0; i5 < n; i5++) {
      localByteVector.putShort(o[i5]);
    }
    localByteVector.putShort(i2);
    for (localFieldWriter = y; localFieldWriter != null; localFieldWriter = a) {
      localFieldWriter.a(localByteVector);
    }
    localByteVector.putShort(i3);
    for (localMethodWriter = A; localMethodWriter != null; localMethodWriter = a) {
      localMethodWriter.a(localByteVector);
    }
    localByteVector.putShort(i4);
    if (l != 0) {
      localByteVector.putShort(newUTF8("Signature")).putInt(2).putShort(l);
    }
    if (p != 0) {
      localByteVector.putShort(newUTF8("SourceFile")).putInt(2).putShort(p);
    }
    if (q != null)
    {
      i5 = q.b - 2;
      localByteVector.putShort(newUTF8("SourceDebugExtension")).putInt(i5);
      localByteVector.putByteArray(q.a, 2, i5);
    }
    if (r != 0)
    {
      localByteVector.putShort(newUTF8("EnclosingMethod")).putInt(4);
      localByteVector.putShort(r).putShort(s);
    }
    if ((j & 0x20000) != 0) {
      localByteVector.putShort(newUTF8("Deprecated")).putInt(0);
    }
    if (((j & 0x1000) != 0) && ((b & 0xFFFF) < 49)) {
      localByteVector.putShort(newUTF8("Synthetic")).putInt(0);
    }
    if (x != null)
    {
      localByteVector.putShort(newUTF8("InnerClasses"));
      localByteVector.putInt(x.b + 2).putShort(w);
      localByteVector.putByteArray(x.a, 0, x.b);
    }
    if (t != null)
    {
      localByteVector.putShort(newUTF8("RuntimeVisibleAnnotations"));
      t.a(localByteVector);
    }
    if (u != null)
    {
      localByteVector.putShort(newUTF8("RuntimeInvisibleAnnotations"));
      u.a(localByteVector);
    }
    if (v != null) {
      v.a(this, null, 0, -1, -1, localByteVector);
    }
    if (I)
    {
      ClassWriter localClassWriter = new ClassWriter(2);
      new .ClassReader(a).accept(localClassWriter, 4);
      return localClassWriter.toByteArray();
    }
    return a;
  }
  
  .Item a(Object paramObject)
  {
    int i1;
    if ((paramObject instanceof Integer))
    {
      i1 = ((Integer)paramObject).intValue();
      return a(i1);
    }
    if ((paramObject instanceof Byte))
    {
      i1 = ((Byte)paramObject).intValue();
      return a(i1);
    }
    if ((paramObject instanceof Character))
    {
      i1 = ((Character)paramObject).charValue();
      return a(i1);
    }
    if ((paramObject instanceof Short))
    {
      i1 = ((Short)paramObject).intValue();
      return a(i1);
    }
    if ((paramObject instanceof Boolean))
    {
      i1 = ((Boolean)paramObject).booleanValue() ? 1 : 0;
      return a(i1);
    }
    if ((paramObject instanceof Float))
    {
      float f1 = ((Float)paramObject).floatValue();
      return a(f1);
    }
    if ((paramObject instanceof Long))
    {
      long l1 = ((Long)paramObject).longValue();
      return a(l1);
    }
    if ((paramObject instanceof Double))
    {
      double d1 = ((Double)paramObject).doubleValue();
      return a(d1);
    }
    if ((paramObject instanceof String)) {
      return b((String)paramObject);
    }
    if ((paramObject instanceof .Type))
    {
      .Type localType = (.Type)paramObject;
      return a(localType.getSort() == 10 ? localType.getInternalName() : localType.getDescriptor());
    }
    throw new IllegalArgumentException("value " + paramObject);
  }
  
  public int newConst(Object paramObject)
  {
    return aa;
  }
  
  public int newUTF8(String paramString)
  {
    g.a(1, paramString, null, null);
    .Item localItem = a(g);
    if (localItem == null)
    {
      d.putByte(1).putUTF8(paramString);
      localItem = new .Item(c++, g);
      b(localItem);
    }
    return a;
  }
  
  .Item a(String paramString)
  {
    h.a(7, paramString, null, null);
    .Item localItem = a(h);
    if (localItem == null)
    {
      d.b(7, newUTF8(paramString));
      localItem = new .Item(c++, h);
      b(localItem);
    }
    return localItem;
  }
  
  public int newClass(String paramString)
  {
    return aa;
  }
  
  .Item a(String paramString1, String paramString2, String paramString3)
  {
    i.a(9, paramString1, paramString2, paramString3);
    .Item localItem = a(i);
    if (localItem == null)
    {
      a(9, newClass(paramString1), newNameType(paramString2, paramString3));
      localItem = new .Item(c++, i);
      b(localItem);
    }
    return localItem;
  }
  
  public int newField(String paramString1, String paramString2, String paramString3)
  {
    return aa;
  }
  
  .Item a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i1 = paramBoolean ? 11 : 10;
    i.a(i1, paramString1, paramString2, paramString3);
    .Item localItem = a(i);
    if (localItem == null)
    {
      a(i1, newClass(paramString1), newNameType(paramString2, paramString3));
      localItem = new .Item(c++, i);
      b(localItem);
    }
    return localItem;
  }
  
  public int newMethod(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return aa;
  }
  
  .Item a(int paramInt)
  {
    g.a(paramInt);
    .Item localItem = a(g);
    if (localItem == null)
    {
      d.putByte(3).putInt(paramInt);
      localItem = new .Item(c++, g);
      b(localItem);
    }
    return localItem;
  }
  
  .Item a(float paramFloat)
  {
    g.a(paramFloat);
    .Item localItem = a(g);
    if (localItem == null)
    {
      d.putByte(4).putInt(g.c);
      localItem = new .Item(c++, g);
      b(localItem);
    }
    return localItem;
  }
  
  .Item a(long paramLong)
  {
    g.a(paramLong);
    .Item localItem = a(g);
    if (localItem == null)
    {
      d.putByte(5).putLong(paramLong);
      localItem = new .Item(c, g);
      b(localItem);
      c += 2;
    }
    return localItem;
  }
  
  .Item a(double paramDouble)
  {
    g.a(paramDouble);
    .Item localItem = a(g);
    if (localItem == null)
    {
      d.putByte(6).putLong(g.d);
      localItem = new .Item(c, g);
      b(localItem);
      c += 2;
    }
    return localItem;
  }
  
  private .Item b(String paramString)
  {
    h.a(8, paramString, null, null);
    .Item localItem = a(h);
    if (localItem == null)
    {
      d.b(8, newUTF8(paramString));
      localItem = new .Item(c++, h);
      b(localItem);
    }
    return localItem;
  }
  
  public int newNameType(String paramString1, String paramString2)
  {
    h.a(12, paramString1, paramString2, null);
    .Item localItem = a(h);
    if (localItem == null)
    {
      a(12, newUTF8(paramString1), newUTF8(paramString2));
      localItem = new .Item(c++, h);
      b(localItem);
    }
    return a;
  }
  
  int c(String paramString)
  {
    g.a(13, paramString, null, null);
    .Item localItem = a(g);
    if (localItem == null) {
      localItem = c(g);
    }
    return a;
  }
  
  int a(String paramString, int paramInt)
  {
    g.b = 14;
    g.c = paramInt;
    g.g = paramString;
    g.j = (0x7FFFFFFF & 14 + paramString.hashCode() + paramInt);
    .Item localItem = a(g);
    if (localItem == null) {
      localItem = c(g);
    }
    return a;
  }
  
  private .Item c(.Item paramItem)
  {
    D = ((short)(D + 1));
    .Item localItem = new .Item(D, g);
    b(localItem);
    if (E == null) {
      E = new .Item[16];
    }
    if (D == E.length)
    {
      .Item[] arrayOfItem = new .Item[2 * E.length];
      System.arraycopy(E, 0, arrayOfItem, 0, E.length);
      E = arrayOfItem;
    }
    E[D] = localItem;
    return localItem;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    h.b = 15;
    h.d = (paramInt1 | paramInt2 << 32);
    h.j = (0x7FFFFFFF & 15 + paramInt1 + paramInt2);
    .Item localItem = a(h);
    if (localItem == null)
    {
      String str1 = E[paramInt1].g;
      String str2 = E[paramInt2].g;
      h.c = c(getCommonSuperClass(str1, str2));
      localItem = new .Item(0, h);
      b(localItem);
    }
    return c;
  }
  
  protected String getCommonSuperClass(String paramString1, String paramString2)
  {
    Class localClass1;
    Class localClass2;
    try
    {
      localClass1 = Class.forName(paramString1.replace('/', '.'));
      localClass2 = Class.forName(paramString2.replace('/', '.'));
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.toString());
    }
    if (localClass1.isAssignableFrom(localClass2)) {
      return paramString1;
    }
    if (localClass2.isAssignableFrom(localClass1)) {
      return paramString2;
    }
    if ((localClass1.isInterface()) || (localClass2.isInterface())) {
      return "java/lang/Object";
    }
    do
    {
      localClass1 = localClass1.getSuperclass();
    } while (!localClass1.isAssignableFrom(localClass2));
    return localClass1.getName().replace('.', '/');
  }
  
  private .Item a(.Item paramItem)
  {
    for (.Item localItem = e[(j % e.length)]; (localItem != null) && (!paramItem.a(localItem)); localItem = k) {}
    return localItem;
  }
  
  private void b(.Item paramItem)
  {
    if (c > f)
    {
      i1 = e.length;
      int i2 = i1 * 2 + 1;
      .Item[] arrayOfItem = new .Item[i2];
      for (int i3 = i1 - 1; i3 >= 0; i3--)
      {
        .Item localItem;
        for (Object localObject = e[i3]; localObject != null; localObject = localItem)
        {
          int i4 = j % arrayOfItem.length;
          localItem = k;
          k = arrayOfItem[i4];
          arrayOfItem[i4] = localObject;
        }
      }
      e = arrayOfItem;
      f = ((int)(i2 * 0.75D));
    }
    int i1 = j % e.length;
    k = e[i1];
    e[i1] = paramItem;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    d.b(paramInt1, paramInt2).putShort(paramInt3);
  }
  
  static
  {
    byte[] arrayOfByte = new byte['Ü'];
    String str = "AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHAFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII";
    for (int i1 = 0; i1 < arrayOfByte.length; i1++) {
      arrayOfByte[i1] = ((byte)(str.charAt(i1) - 'A'));
    }
    a = arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassWriter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */