package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

class $MethodWriter
  implements .MethodVisitor
{
  MethodWriter a;
  final .ClassWriter b;
  private int c;
  private final int d;
  private final int e;
  private final String f;
  String g;
  int h;
  int i;
  int j;
  int[] k;
  private .ByteVector l;
  private .AnnotationWriter m;
  private .AnnotationWriter n;
  private .AnnotationWriter[] o;
  private .AnnotationWriter[] p;
  private int S;
  private .Attribute q;
  private .ByteVector r = new .ByteVector();
  private int s;
  private int t;
  private int u;
  private .ByteVector v;
  private int w;
  private int[] x;
  private int y;
  private int[] z;
  private int A;
  private .Handler B;
  private .Handler C;
  private int D;
  private .ByteVector E;
  private int F;
  private .ByteVector G;
  private int H;
  private .ByteVector I;
  private .Attribute J;
  private boolean K;
  private int L;
  private final int M;
  private .Label N;
  private .Label O;
  private .Label P;
  private int Q;
  private int R;
  
  $MethodWriter(.ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (A == null) {
      A = this;
    } else {
      B.a = this;
    }
    B = this;
    b = paramClassWriter;
    c = paramInt;
    d = paramClassWriter.newUTF8(paramString1);
    e = paramClassWriter.newUTF8(paramString2);
    f = paramString2;
    g = paramString3;
    int i1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      j = paramArrayOfString.length;
      k = new int[j];
      for (i1 = 0; i1 < j; i1++) {
        k[i1] = paramClassWriter.newClass(paramArrayOfString[i1]);
      }
    }
    M = (paramBoolean1 ? 1 : paramBoolean2 ? 0 : 2);
    if ((paramBoolean1) || (paramBoolean2))
    {
      if ((paramBoolean2) && ("<init>".equals(paramString1))) {
        c |= 0x40000;
      }
      i1 = a(f) >> 2;
      if ((paramInt & 0x8) != 0) {
        i1--;
      }
      t = i1;
      N = new .Label();
      N.a |= 0x8;
      visitLabel(N);
    }
  }
  
  public .AnnotationVisitor visitAnnotationDefault()
  {
    l = new .ByteVector();
    return new .AnnotationWriter(b, false, l, null, 0);
  }
  
  public .AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    .ByteVector localByteVector = new .ByteVector();
    localByteVector.putShort(b.newUTF8(paramString)).putShort(0);
    .AnnotationWriter localAnnotationWriter = new .AnnotationWriter(b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      g = m;
      m = localAnnotationWriter;
    }
    else
    {
      g = n;
      n = localAnnotationWriter;
    }
    return localAnnotationWriter;
  }
  
  public .AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean)
  {
    .ByteVector localByteVector = new .ByteVector();
    if ("Ljava/lang/Synthetic;".equals(paramString))
    {
      S = Math.max(S, paramInt + 1);
      return new .AnnotationWriter(b, false, localByteVector, null, 0);
    }
    localByteVector.putShort(b.newUTF8(paramString)).putShort(0);
    .AnnotationWriter localAnnotationWriter = new .AnnotationWriter(b, true, localByteVector, localByteVector, 2);
    if (paramBoolean)
    {
      if (o == null) {
        o = new .AnnotationWriter[.Type.getArgumentTypes(f).length];
      }
      g = o[paramInt];
      o[paramInt] = localAnnotationWriter;
    }
    else
    {
      if (p == null) {
        p = new .AnnotationWriter[.Type.getArgumentTypes(f).length];
      }
      g = p[paramInt];
      p[paramInt] = localAnnotationWriter;
    }
    return localAnnotationWriter;
  }
  
  public void visitAttribute(.Attribute paramAttribute)
  {
    if (paramAttribute.isCodeAttribute())
    {
      a = J;
      J = paramAttribute;
    }
    else
    {
      a = q;
      q = paramAttribute;
    }
  }
  
  public void visitCode() {}
  
  public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2)
  {
    if (M == 0) {
      return;
    }
    int i1;
    if (paramInt1 == -1)
    {
      a(r.b, paramInt2, paramInt3);
      for (i1 = 0; i1 < paramInt2; i1++) {
        if ((paramArrayOfObject1[i1] instanceof String)) {
          z[(y++)] = (0x1700000 | b.c((String)paramArrayOfObject1[i1]));
        } else if ((paramArrayOfObject1[i1] instanceof Integer)) {
          z[(y++)] = ((Integer)paramArrayOfObject1[i1]).intValue();
        } else {
          z[(y++)] = (0x1800000 | b.a("", c));
        }
      }
      for (i1 = 0; i1 < paramInt3; i1++) {
        if ((paramArrayOfObject2[i1] instanceof String)) {
          z[(y++)] = (0x1700000 | b.c((String)paramArrayOfObject2[i1]));
        } else if ((paramArrayOfObject2[i1] instanceof Integer)) {
          z[(y++)] = ((Integer)paramArrayOfObject2[i1]).intValue();
        } else {
          z[(y++)] = (0x1800000 | b.a("", c));
        }
      }
      b();
    }
    else
    {
      if (v == null)
      {
        v = new .ByteVector();
        i1 = r.b;
      }
      else
      {
        i1 = r.b - w - 1;
      }
      int i2;
      switch (paramInt1)
      {
      case 0: 
        v.putByte(255).putShort(i1).putShort(paramInt2);
        for (i2 = 0; i2 < paramInt2; i2++) {
          a(paramArrayOfObject1[i2]);
        }
        v.putShort(paramInt3);
        for (i2 = 0; i2 < paramInt3; i2++) {
          a(paramArrayOfObject2[i2]);
        }
        break;
      case 1: 
        v.putByte(251 + paramInt2).putShort(i1);
        for (i2 = 0; i2 < paramInt2; i2++) {
          a(paramArrayOfObject1[i2]);
        }
        break;
      case 2: 
        v.putByte(251 - paramInt2).putShort(i1);
        break;
      case 3: 
        if (i1 < 64) {
          v.putByte(i1);
        } else {
          v.putByte(251).putShort(i1);
        }
        break;
      case 4: 
        if (i1 < 64) {
          v.putByte(64 + i1);
        } else {
          v.putByte(247).putShort(i1);
        }
        a(paramArrayOfObject2[0]);
      }
      w = r.b;
      u += 1;
    }
  }
  
  public void visitInsn(int paramInt)
  {
    r.putByte(paramInt);
    if (P != null)
    {
      if (M == 0)
      {
        P.h.a(paramInt, 0, null, null);
      }
      else
      {
        int i1 = Q + .Frame.a[paramInt];
        if (i1 > R) {
          R = i1;
        }
        Q = i1;
      }
      if (((paramInt >= 172) && (paramInt <= 177)) || (paramInt == 191)) {
        e();
      }
    }
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt1, paramInt2, null, null);
      }
      else if (paramInt1 != 188)
      {
        int i1 = Q + 1;
        if (i1 > R) {
          R = i1;
        }
        Q = i1;
      }
    }
    if (paramInt1 == 17) {
      r.b(paramInt1, paramInt2);
    } else {
      r.a(paramInt1, paramInt2);
    }
  }
  
  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    int i1;
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt1, paramInt2, null, null);
      }
      else if (paramInt1 == 169)
      {
        P.a |= 0x100;
        P.f = Q;
        e();
      }
      else
      {
        i1 = Q + .Frame.a[paramInt1];
        if (i1 > R) {
          R = i1;
        }
        Q = i1;
      }
    }
    if (M != 2)
    {
      if ((paramInt1 == 22) || (paramInt1 == 24) || (paramInt1 == 55) || (paramInt1 == 57)) {
        i1 = paramInt2 + 2;
      } else {
        i1 = paramInt2 + 1;
      }
      if (i1 > t) {
        t = i1;
      }
    }
    if ((paramInt2 < 4) && (paramInt1 != 169))
    {
      if (paramInt1 < 54) {
        i1 = 26 + (paramInt1 - 21 << 2) + paramInt2;
      } else {
        i1 = 59 + (paramInt1 - 54 << 2) + paramInt2;
      }
      r.putByte(i1);
    }
    else if (paramInt2 >= 256)
    {
      r.putByte(196).b(paramInt1, paramInt2);
    }
    else
    {
      r.a(paramInt1, paramInt2);
    }
    if ((paramInt1 >= 54) && (M == 0) && (A > 0)) {
      visitLabel(new .Label());
    }
  }
  
  public void visitTypeInsn(int paramInt, String paramString)
  {
    .Item localItem = b.a(paramString);
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt, r.b, b, localItem);
      }
      else if (paramInt == 187)
      {
        int i1 = Q + 1;
        if (i1 > R) {
          R = i1;
        }
        Q = i1;
      }
    }
    r.b(paramInt, a);
  }
  
  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    .Item localItem = b.a(paramString1, paramString2, paramString3);
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt, 0, b, localItem);
      }
      else
      {
        int i1 = paramString3.charAt(0);
        int i2;
        switch (paramInt)
        {
        case 178: 
          i2 = Q + ((i1 == 68) || (i1 == 74) ? 2 : 1);
          break;
        case 179: 
          i2 = Q + ((i1 == 68) || (i1 == 74) ? -2 : -1);
          break;
        case 180: 
          i2 = Q + ((i1 == 68) || (i1 == 74) ? 1 : 0);
          break;
        default: 
          i2 = Q + ((i1 == 68) || (i1 == 74) ? -3 : -2);
        }
        if (i2 > R) {
          R = i2;
        }
        Q = i2;
      }
    }
    r.b(paramInt, a);
  }
  
  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = paramInt == 185;
    .Item localItem = b.a(paramString1, paramString2, paramString3, bool);
    int i1 = c;
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt, 0, b, localItem);
      }
      else
      {
        if (i1 == 0)
        {
          i1 = a(paramString3);
          c = i1;
        }
        int i2;
        if (paramInt == 184) {
          i2 = Q - (i1 >> 2) + (i1 & 0x3) + 1;
        } else {
          i2 = Q - (i1 >> 2) + (i1 & 0x3);
        }
        if (i2 > R) {
          R = i2;
        }
        Q = i2;
      }
    }
    if (bool)
    {
      if (i1 == 0)
      {
        i1 = a(paramString3);
        c = i1;
      }
      r.b(185, a).a(i1 >> 2, 0);
    }
    else
    {
      r.b(paramInt, a);
    }
  }
  
  public void visitJumpInsn(int paramInt, .Label paramLabel)
  {
    .Label localLabel = null;
    if (P != null) {
      if (M == 0)
      {
        P.h.a(paramInt, 0, null, null);
        aa |= 0x10;
        a(0, paramLabel);
        if (paramInt != 167) {
          localLabel = new .Label();
        }
      }
      else if (paramInt == 168)
      {
        if ((a & 0x200) == 0)
        {
          a |= 0x200;
          L += 1;
        }
        P.a |= 0x80;
        a(Q + 1, paramLabel);
        localLabel = new .Label();
      }
      else
      {
        Q += .Frame.a[paramInt];
        a(Q, paramLabel);
      }
    }
    if (((a & 0x2) != 0) && (c - r.b < 32768))
    {
      if (paramInt == 167)
      {
        r.putByte(200);
      }
      else if (paramInt == 168)
      {
        r.putByte(201);
      }
      else
      {
        if (localLabel != null) {
          a |= 0x10;
        }
        r.putByte(paramInt <= 166 ? (paramInt + 1 ^ 0x1) - 1 : paramInt ^ 0x1);
        r.putShort(8);
        r.putByte(200);
      }
      paramLabel.a(this, r, r.b - 1, true);
    }
    else
    {
      r.putByte(paramInt);
      paramLabel.a(this, r, r.b - 1, false);
    }
    if (P != null)
    {
      if (localLabel != null) {
        visitLabel(localLabel);
      }
      if (paramInt == 167) {
        e();
      }
    }
  }
  
  public void visitLabel(.Label paramLabel)
  {
    K |= paramLabel.a(this, r.b, r.a);
    if ((a & 0x1) != 0) {
      return;
    }
    if (M == 0)
    {
      if (P != null)
      {
        if (c == P.c)
        {
          P.a |= a & 0x10;
          h = P.h;
          return;
        }
        a(0, paramLabel);
      }
      P = paramLabel;
      if (h == null)
      {
        h = new .Frame();
        h.b = paramLabel;
      }
      if (O != null)
      {
        if (c == O.c)
        {
          O.a |= a & 0x10;
          h = O.h;
          P = O;
          return;
        }
        O.i = paramLabel;
      }
      O = paramLabel;
    }
    else if (M == 1)
    {
      if (P != null)
      {
        P.g = R;
        a(Q, paramLabel);
      }
      P = paramLabel;
      Q = 0;
      R = 0;
      if (O != null) {
        O.i = paramLabel;
      }
      O = paramLabel;
    }
  }
  
  public void visitLdcInsn(Object paramObject)
  {
    .Item localItem = b.a(paramObject);
    if (P != null) {
      if (M == 0)
      {
        P.h.a(18, 0, b, localItem);
      }
      else
      {
        if ((b == 5) || (b == 6)) {
          i1 = Q + 2;
        } else {
          i1 = Q + 1;
        }
        if (i1 > R) {
          R = i1;
        }
        Q = i1;
      }
    }
    int i1 = a;
    if ((b == 5) || (b == 6)) {
      r.b(20, i1);
    } else if (i1 >= 256) {
      r.b(19, i1);
    } else {
      r.a(18, i1);
    }
  }
  
  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    if ((P != null) && (M == 0)) {
      P.h.a(132, paramInt1, null, null);
    }
    if (M != 2)
    {
      int i1 = paramInt1 + 1;
      if (i1 > t) {
        t = i1;
      }
    }
    if ((paramInt1 > 255) || (paramInt2 > 127) || (paramInt2 < -128)) {
      r.putByte(196).b(132, paramInt1).putShort(paramInt2);
    } else {
      r.putByte(132).a(paramInt1, paramInt2);
    }
  }
  
  public void visitTableSwitchInsn(int paramInt1, int paramInt2, .Label paramLabel, .Label[] paramArrayOfLabel)
  {
    int i1 = r.b;
    r.putByte(170);
    r.b += (4 - r.b % 4) % 4;
    paramLabel.a(this, r, i1, true);
    r.putInt(paramInt1).putInt(paramInt2);
    for (int i2 = 0; i2 < paramArrayOfLabel.length; i2++) {
      paramArrayOfLabel[i2].a(this, r, i1, true);
    }
    a(paramLabel, paramArrayOfLabel);
  }
  
  public void visitLookupSwitchInsn(.Label paramLabel, int[] paramArrayOfInt, .Label[] paramArrayOfLabel)
  {
    int i1 = r.b;
    r.putByte(171);
    r.b += (4 - r.b % 4) % 4;
    paramLabel.a(this, r, i1, true);
    r.putInt(paramArrayOfLabel.length);
    for (int i2 = 0; i2 < paramArrayOfLabel.length; i2++)
    {
      r.putInt(paramArrayOfInt[i2]);
      paramArrayOfLabel[i2].a(this, r, i1, true);
    }
    a(paramLabel, paramArrayOfLabel);
  }
  
  private void a(.Label paramLabel, .Label[] paramArrayOfLabel)
  {
    if (P != null)
    {
      int i1;
      if (M == 0)
      {
        P.h.a(171, 0, null, null);
        a(0, paramLabel);
        aa |= 0x10;
        for (i1 = 0; i1 < paramArrayOfLabel.length; i1++)
        {
          a(0, paramArrayOfLabel[i1]);
          aa |= 0x10;
        }
      }
      else
      {
        Q -= 1;
        a(Q, paramLabel);
        for (i1 = 0; i1 < paramArrayOfLabel.length; i1++) {
          a(Q, paramArrayOfLabel[i1]);
        }
      }
      e();
    }
  }
  
  public void visitMultiANewArrayInsn(String paramString, int paramInt)
  {
    .Item localItem = b.a(paramString);
    if (P != null) {
      if (M == 0) {
        P.h.a(197, paramInt, b, localItem);
      } else {
        Q += 1 - paramInt;
      }
    }
    r.b(197, a).putByte(paramInt);
  }
  
  public void visitTryCatchBlock(.Label paramLabel1, .Label paramLabel2, .Label paramLabel3, String paramString)
  {
    A += 1;
    .Handler localHandler = new .Handler();
    a = paramLabel1;
    b = paramLabel2;
    c = paramLabel3;
    d = paramString;
    e = (paramString != null ? b.newClass(paramString) : 0);
    if (C == null) {
      B = localHandler;
    } else {
      C.f = localHandler;
    }
    C = localHandler;
  }
  
  public void visitLocalVariable(String paramString1, String paramString2, String paramString3, .Label paramLabel1, .Label paramLabel2, int paramInt)
  {
    if (paramString3 != null)
    {
      if (G == null) {
        G = new .ByteVector();
      }
      F += 1;
      G.putShort(c).putShort(c - c).putShort(b.newUTF8(paramString1)).putShort(b.newUTF8(paramString3)).putShort(paramInt);
    }
    if (E == null) {
      E = new .ByteVector();
    }
    D += 1;
    E.putShort(c).putShort(c - c).putShort(b.newUTF8(paramString1)).putShort(b.newUTF8(paramString2)).putShort(paramInt);
    if (M != 2)
    {
      int i1 = paramString2.charAt(0);
      int i2 = paramInt + ((i1 == 74) || (i1 == 68) ? 2 : 1);
      if (i2 > t) {
        t = i2;
      }
    }
  }
  
  public void visitLineNumber(int paramInt, .Label paramLabel)
  {
    if (I == null) {
      I = new .ByteVector();
    }
    H += 1;
    I.putShort(c);
    I.putShort(paramInt);
  }
  
  public void visitMaxs(int paramInt1, int paramInt2)
  {
    .Handler localHandler;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject6;
    if (M == 0)
    {
      for (localHandler = B; localHandler != null; localHandler = f)
      {
        localObject1 = a.a();
        localObject2 = c.a();
        .Label localLabel1 = b.a();
        localObject4 = d == null ? "java/lang/Throwable" : d;
        int i4 = 0x1700000 | b.c((String)localObject4);
        a |= 0x10;
        while (localObject1 != localLabel1)
        {
          .Edge localEdge1 = new .Edge();
          a = i4;
          b = ((.Label)localObject2);
          c = j;
          j = localEdge1;
          localObject1 = i;
        }
      }
      localObject1 = N.h;
      localObject2 = .Type.getArgumentTypes(f);
      ((.Frame)localObject1).a(b, c, (.Type[])localObject2, t);
      b((.Frame)localObject1);
      int i2 = 0;
      localObject4 = N;
      int i9;
      while (localObject4 != null)
      {
        localObject5 = localObject4;
        localObject4 = k;
        k = null;
        localObject1 = h;
        if ((a & 0x10) != 0) {
          a |= 0x20;
        }
        a |= 0x40;
        int i6 = d.length + g;
        if (i6 > i2) {
          i2 = i6;
        }
        for (.Edge localEdge2 = j; localEdge2 != null; localEdge2 = c)
        {
          .Label localLabel2 = b.a();
          i9 = ((.Frame)localObject1).a(b, h, a);
          if ((i9 != 0) && (k == null))
          {
            k = ((.Label)localObject4);
            localObject4 = localLabel2;
          }
        }
      }
      s = i2;
      for (Object localObject5 = N; localObject5 != null; localObject5 = i)
      {
        localObject1 = h;
        if ((a & 0x20) != 0) {
          b((.Frame)localObject1);
        }
        if ((a & 0x40) == 0)
        {
          localObject6 = i;
          int i7 = c;
          int i8 = (localObject6 == null ? r.b : c) - 1;
          if (i8 >= i7)
          {
            for (i9 = i7; i9 < i8; i9++) {
              r.a[i9] = 0;
            }
            r.a[i8] = -65;
            a(i7, 0, 1);
            z[(y++)] = (0x1700000 | b.c("java/lang/Throwable"));
            b();
          }
        }
      }
    }
    else if (M == 1)
    {
      Object localObject3;
      for (localHandler = B; localHandler != null; localHandler = f)
      {
        localObject1 = a;
        localObject2 = c;
        localObject3 = b;
        while (localObject1 != localObject3)
        {
          localObject4 = new .Edge();
          a = Integer.MAX_VALUE;
          b = ((.Label)localObject2);
          if ((a & 0x80) == 0)
          {
            c = j;
            j = ((.Edge)localObject4);
          }
          else
          {
            c = j.c.c;
            j.c.c = ((.Edge)localObject4);
          }
          localObject1 = i;
        }
      }
      if (L > 0)
      {
        i1 = 0;
        N.b(null, 1L, L);
        for (localObject2 = N; localObject2 != null; localObject2 = i) {
          if ((a & 0x80) != 0)
          {
            localObject3 = j.c.b;
            if ((a & 0x400) == 0)
            {
              i1++;
              ((.Label)localObject3).b(null, i1 / 32L << 32 | 1L << i1 % 32, L);
            }
          }
        }
        for (localObject2 = N; localObject2 != null; localObject2 = i) {
          if ((a & 0x80) != 0)
          {
            for (localObject3 = N; localObject3 != null; localObject3 = i) {
              a &= 0xFBFF;
            }
            localObject4 = j.c.b;
            ((.Label)localObject4).b((.Label)localObject2, 0L, L);
          }
        }
      }
      int i1 = 0;
      localObject2 = N;
      while (localObject2 != null)
      {
        localObject3 = localObject2;
        localObject2 = k;
        int i3 = f;
        int i5 = i3 + g;
        if (i5 > i1) {
          i1 = i5;
        }
        localObject6 = j;
        if ((a & 0x80) != 0) {}
        for (localObject6 = c; localObject6 != null; localObject6 = c)
        {
          localObject3 = b;
          if ((a & 0x8) == 0)
          {
            f = (a == Integer.MAX_VALUE ? 1 : i3 + a);
            a |= 0x8;
            k = ((.Label)localObject2);
            localObject2 = localObject3;
          }
        }
      }
      s = i1;
    }
    else
    {
      s = paramInt1;
      t = paramInt2;
    }
  }
  
  public void visitEnd() {}
  
  static int a(String paramString)
  {
    int i1 = 1;
    int i2 = 1;
    for (;;)
    {
      int i3 = paramString.charAt(i2++);
      if (i3 == 41)
      {
        i3 = paramString.charAt(i2);
        return i1 << 2 | ((i3 == 68) || (i3 == 74) ? 2 : i3 == 86 ? 0 : 1);
      }
      if (i3 == 76)
      {
        while (paramString.charAt(i2++) != ';') {}
        i1++;
      }
      else if (i3 == 91)
      {
        while ((i3 = paramString.charAt(i2)) == '[') {
          i2++;
        }
        if ((i3 == 68) || (i3 == 74)) {
          i1--;
        }
      }
      else if ((i3 == 68) || (i3 == 74))
      {
        i1 += 2;
      }
      else
      {
        i1++;
      }
    }
  }
  
  private void a(int paramInt, .Label paramLabel)
  {
    .Edge localEdge = new .Edge();
    a = paramInt;
    b = paramLabel;
    c = P.j;
    P.j = localEdge;
  }
  
  private void e()
  {
    if (M == 0)
    {
      .Label localLabel = new .Label();
      h = new .Frame();
      h.b = localLabel;
      localLabel.a(this, r.b, r.a);
      O.i = localLabel;
      O = localLabel;
    }
    else
    {
      P.g = R;
    }
    P = null;
  }
  
  private void b(.Frame paramFrame)
  {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int[] arrayOfInt1 = c;
    int[] arrayOfInt2 = d;
    int i5;
    for (int i4 = 0; i4 < arrayOfInt1.length; i4++)
    {
      i5 = arrayOfInt1[i4];
      if (i5 == 16777216)
      {
        i1++;
      }
      else
      {
        i2 += i1 + 1;
        i1 = 0;
      }
      if ((i5 == 16777220) || (i5 == 16777219)) {
        i4++;
      }
    }
    for (i4 = 0; i4 < arrayOfInt2.length; i4++)
    {
      i5 = arrayOfInt2[i4];
      i3++;
      if ((i5 == 16777220) || (i5 == 16777219)) {
        i4++;
      }
    }
    a(b.c, i2, i3);
    i4 = 0;
    while (i2 > 0)
    {
      i5 = arrayOfInt1[i4];
      z[(y++)] = i5;
      if ((i5 == 16777220) || (i5 == 16777219)) {
        i4++;
      }
      i4++;
      i2--;
    }
    for (i4 = 0; i4 < arrayOfInt2.length; i4++)
    {
      i5 = arrayOfInt2[i4];
      z[(y++)] = i5;
      if ((i5 == 16777220) || (i5 == 16777219)) {
        i4++;
      }
    }
    b();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 3 + paramInt2 + paramInt3;
    if ((z == null) || (z.length < i1)) {
      z = new int[i1];
    }
    z[0] = paramInt1;
    z[1] = paramInt2;
    z[2] = paramInt3;
    y = 3;
  }
  
  private void b()
  {
    if (x != null)
    {
      if (v == null) {
        v = new .ByteVector();
      }
      c();
      u += 1;
    }
    x = z;
    z = null;
  }
  
  private void c()
  {
    int i1 = z[1];
    int i2 = z[2];
    if ((b.b & 0xFFFF) < 50)
    {
      v.putShort(z[0]).putShort(i1);
      a(3, 3 + i1);
      v.putShort(i2);
      a(3 + i1, 3 + i1 + i2);
      return;
    }
    int i3 = x[1];
    int i4 = 255;
    int i5 = 0;
    int i6;
    if (u == 0) {
      i6 = z[0];
    } else {
      i6 = z[0] - x[0] - 1;
    }
    if (i2 == 0)
    {
      i5 = i1 - i3;
      switch (i5)
      {
      case -3: 
      case -2: 
      case -1: 
        i4 = 248;
        i3 = i1;
        break;
      case 0: 
        i4 = i6 < 64 ? 0 : 251;
        break;
      case 1: 
      case 2: 
      case 3: 
        i4 = 252;
      }
    }
    else if ((i1 == i3) && (i2 == 1))
    {
      i4 = i6 < 63 ? 64 : 247;
    }
    if (i4 != 255)
    {
      int i7 = 3;
      for (int i8 = 0; i8 < i3; i8++)
      {
        if (z[i7] != x[i7])
        {
          i4 = 255;
          break;
        }
        i7++;
      }
    }
    switch (i4)
    {
    case 0: 
      v.putByte(i6);
      break;
    case 64: 
      v.putByte(64 + i6);
      a(3 + i1, 4 + i1);
      break;
    case 247: 
      v.putByte(247).putShort(i6);
      a(3 + i1, 4 + i1);
      break;
    case 251: 
      v.putByte(251).putShort(i6);
      break;
    case 248: 
      v.putByte(251 + i5).putShort(i6);
      break;
    case 252: 
      v.putByte(251 + i5).putShort(i6);
      a(3 + i3, 3 + i1);
      break;
    default: 
      v.putByte(255).putShort(i6).putShort(i1);
      a(3, 3 + i1);
      v.putShort(i2);
      a(3 + i1, 3 + i1 + i2);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    for (int i1 = paramInt1; i1 < paramInt2; i1++)
    {
      int i2 = z[i1];
      int i3 = i2 & 0xF0000000;
      if (i3 == 0)
      {
        int i4 = i2 & 0xFFFFF;
        switch (i2 & 0xFF00000)
        {
        case 24117248: 
          v.putByte(7).putShort(b.newClass(b.E[i4].g));
          break;
        case 25165824: 
          v.putByte(8).putShort(b.E[i4].c);
          break;
        default: 
          v.putByte(i4);
        }
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        i3 >>= 28;
        while (i3-- > 0) {
          localStringBuffer.append('[');
        }
        if ((i2 & 0xFF00000) == 24117248)
        {
          localStringBuffer.append('L');
          localStringBuffer.append(b.E[(i2 & 0xFFFFF)].g);
          localStringBuffer.append(';');
        }
        else
        {
          switch (i2 & 0xF)
          {
          case 1: 
            localStringBuffer.append('I');
            break;
          case 2: 
            localStringBuffer.append('F');
            break;
          case 3: 
            localStringBuffer.append('D');
            break;
          case 9: 
            localStringBuffer.append('Z');
            break;
          case 10: 
            localStringBuffer.append('B');
            break;
          case 11: 
            localStringBuffer.append('C');
            break;
          case 12: 
            localStringBuffer.append('S');
            break;
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            localStringBuffer.append('J');
          }
        }
        v.putByte(7).putShort(b.newClass(localStringBuffer.toString()));
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      v.putByte(7).putShort(b.newClass((String)paramObject));
    } else if ((paramObject instanceof Integer)) {
      v.putByte(((Integer)paramObject).intValue());
    } else {
      v.putByte(8).putShort(c);
    }
  }
  
  final int a()
  {
    if (h != 0) {
      return 6 + i;
    }
    if (K) {
      d();
    }
    int i1 = 8;
    int i2;
    if (r.b > 0)
    {
      b.newUTF8("Code");
      i1 += 18 + r.b + 8 * A;
      if (E != null)
      {
        b.newUTF8("LocalVariableTable");
        i1 += 8 + E.b;
      }
      if (G != null)
      {
        b.newUTF8("LocalVariableTypeTable");
        i1 += 8 + G.b;
      }
      if (I != null)
      {
        b.newUTF8("LineNumberTable");
        i1 += 8 + I.b;
      }
      if (v != null)
      {
        i2 = (b.b & 0xFFFF) >= 50 ? 1 : 0;
        b.newUTF8(i2 != 0 ? "StackMapTable" : "StackMap");
        i1 += 8 + v.b;
      }
      if (J != null) {
        i1 += J.a(b, r.a, r.b, s, t);
      }
    }
    if (j > 0)
    {
      b.newUTF8("Exceptions");
      i1 += 8 + 2 * j;
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49))
    {
      b.newUTF8("Synthetic");
      i1 += 6;
    }
    if ((c & 0x20000) != 0)
    {
      b.newUTF8("Deprecated");
      i1 += 6;
    }
    if (g != null)
    {
      b.newUTF8("Signature");
      b.newUTF8(g);
      i1 += 8;
    }
    if (l != null)
    {
      b.newUTF8("AnnotationDefault");
      i1 += 6 + l.b;
    }
    if (m != null)
    {
      b.newUTF8("RuntimeVisibleAnnotations");
      i1 += 8 + m.a();
    }
    if (n != null)
    {
      b.newUTF8("RuntimeInvisibleAnnotations");
      i1 += 8 + n.a();
    }
    if (o != null)
    {
      b.newUTF8("RuntimeVisibleParameterAnnotations");
      i1 += 7 + 2 * (o.length - S);
      for (i2 = o.length - 1; i2 >= S; i2--) {
        i1 += (o[i2] == null ? 0 : o[i2].a());
      }
    }
    if (p != null)
    {
      b.newUTF8("RuntimeInvisibleParameterAnnotations");
      i1 += 7 + 2 * (p.length - S);
      for (i2 = p.length - 1; i2 >= S; i2--) {
        i1 += (p[i2] == null ? 0 : p[i2].a());
      }
    }
    if (q != null) {
      i1 += q.a(b, null, 0, -1, -1);
    }
    return i1;
  }
  
  final void a(.ByteVector paramByteVector)
  {
    paramByteVector.putShort(c).putShort(d).putShort(e);
    if (h != 0)
    {
      paramByteVector.putByteArray(b.J.b, h, i);
      return;
    }
    int i1 = 0;
    if (r.b > 0) {
      i1++;
    }
    if (j > 0) {
      i1++;
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49)) {
      i1++;
    }
    if ((c & 0x20000) != 0) {
      i1++;
    }
    if (g != null) {
      i1++;
    }
    if (l != null) {
      i1++;
    }
    if (m != null) {
      i1++;
    }
    if (n != null) {
      i1++;
    }
    if (o != null) {
      i1++;
    }
    if (p != null) {
      i1++;
    }
    if (q != null) {
      i1 += q.a();
    }
    paramByteVector.putShort(i1);
    int i2;
    if (r.b > 0)
    {
      i2 = 12 + r.b + 8 * A;
      if (E != null) {
        i2 += 8 + E.b;
      }
      if (G != null) {
        i2 += 8 + G.b;
      }
      if (I != null) {
        i2 += 8 + I.b;
      }
      if (v != null) {
        i2 += 8 + v.b;
      }
      if (J != null) {
        i2 += J.a(b, r.a, r.b, s, t);
      }
      paramByteVector.putShort(b.newUTF8("Code")).putInt(i2);
      paramByteVector.putShort(s).putShort(t);
      paramByteVector.putInt(r.b).putByteArray(r.a, 0, r.b);
      paramByteVector.putShort(A);
      if (A > 0) {
        for (.Handler localHandler = B; localHandler != null; localHandler = f) {
          paramByteVector.putShort(a.c).putShort(b.c).putShort(c.c).putShort(e);
        }
      }
      i1 = 0;
      if (E != null) {
        i1++;
      }
      if (G != null) {
        i1++;
      }
      if (I != null) {
        i1++;
      }
      if (v != null) {
        i1++;
      }
      if (J != null) {
        i1 += J.a();
      }
      paramByteVector.putShort(i1);
      if (E != null)
      {
        paramByteVector.putShort(b.newUTF8("LocalVariableTable"));
        paramByteVector.putInt(E.b + 2).putShort(D);
        paramByteVector.putByteArray(E.a, 0, E.b);
      }
      if (G != null)
      {
        paramByteVector.putShort(b.newUTF8("LocalVariableTypeTable"));
        paramByteVector.putInt(G.b + 2).putShort(F);
        paramByteVector.putByteArray(G.a, 0, G.b);
      }
      if (I != null)
      {
        paramByteVector.putShort(b.newUTF8("LineNumberTable"));
        paramByteVector.putInt(I.b + 2).putShort(H);
        paramByteVector.putByteArray(I.a, 0, I.b);
      }
      if (v != null)
      {
        int i3 = (b.b & 0xFFFF) >= 50 ? 1 : 0;
        paramByteVector.putShort(b.newUTF8(i3 != 0 ? "StackMapTable" : "StackMap"));
        paramByteVector.putInt(v.b + 2).putShort(u);
        paramByteVector.putByteArray(v.a, 0, v.b);
      }
      if (J != null) {
        J.a(b, r.a, r.b, t, s, paramByteVector);
      }
    }
    if (j > 0)
    {
      paramByteVector.putShort(b.newUTF8("Exceptions")).putInt(2 * j + 2);
      paramByteVector.putShort(j);
      for (i2 = 0; i2 < j; i2++) {
        paramByteVector.putShort(k[i2]);
      }
    }
    if (((c & 0x1000) != 0) && ((b.b & 0xFFFF) < 49)) {
      paramByteVector.putShort(b.newUTF8("Synthetic")).putInt(0);
    }
    if ((c & 0x20000) != 0) {
      paramByteVector.putShort(b.newUTF8("Deprecated")).putInt(0);
    }
    if (g != null) {
      paramByteVector.putShort(b.newUTF8("Signature")).putInt(2).putShort(b.newUTF8(g));
    }
    if (l != null)
    {
      paramByteVector.putShort(b.newUTF8("AnnotationDefault"));
      paramByteVector.putInt(l.b);
      paramByteVector.putByteArray(l.a, 0, l.b);
    }
    if (m != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeVisibleAnnotations"));
      m.a(paramByteVector);
    }
    if (n != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeInvisibleAnnotations"));
      n.a(paramByteVector);
    }
    if (o != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeVisibleParameterAnnotations"));
      .AnnotationWriter.a(o, S, paramByteVector);
    }
    if (p != null)
    {
      paramByteVector.putShort(b.newUTF8("RuntimeInvisibleParameterAnnotations"));
      .AnnotationWriter.a(p, S, paramByteVector);
    }
    if (q != null) {
      q.a(b, null, 0, -1, -1, paramByteVector);
    }
  }
  
  private void d()
  {
    byte[] arrayOfByte = r.a;
    Object localObject1 = new int[0];
    Object localObject2 = new int[0];
    boolean[] arrayOfBoolean = new boolean[r.b];
    int i1 = 3;
    int i4;
    int i5;
    int i6;
    Object localObject5;
    do
    {
      if (i1 == 3) {
        i1 = 2;
      }
      i2 = 0;
      while (i2 < arrayOfByte.length)
      {
        int i3 = arrayOfByte[i2] & 0xFF;
        i4 = 0;
        switch (.ClassWriter.a[i3])
        {
        case 0: 
        case 4: 
          i2++;
          break;
        case 8: 
          if (i3 > 201)
          {
            i3 = i3 < 218 ? i3 - 49 : i3 - 20;
            i5 = i2 + c(arrayOfByte, i2 + 1);
          }
          else
          {
            i5 = i2 + b(arrayOfByte, i2 + 1);
          }
          i6 = a((int[])localObject1, (int[])localObject2, i2, i5);
          if (((i6 < 32768) || (i6 > 32767)) && (arrayOfBoolean[i2] == 0))
          {
            if ((i3 == 167) || (i3 == 168)) {
              i4 = 2;
            } else {
              i4 = 5;
            }
            arrayOfBoolean[i2] = true;
          }
          i2 += 3;
          break;
        case 9: 
          i2 += 5;
          break;
        case 13: 
          if (i1 == 1)
          {
            i6 = a((int[])localObject1, (int[])localObject2, 0, i2);
            i4 = -(i6 & 0x3);
          }
          else if (arrayOfBoolean[i2] == 0)
          {
            i4 = i2 & 0x3;
            arrayOfBoolean[i2] = true;
          }
          i2 = i2 + 4 - (i2 & 0x3);
          i2 += 4 * (a(arrayOfByte, i2 + 8) - a(arrayOfByte, i2 + 4) + 1) + 12;
          break;
        case 14: 
          if (i1 == 1)
          {
            i6 = a((int[])localObject1, (int[])localObject2, 0, i2);
            i4 = -(i6 & 0x3);
          }
          else if (arrayOfBoolean[i2] == 0)
          {
            i4 = i2 & 0x3;
            arrayOfBoolean[i2] = true;
          }
          i2 = i2 + 4 - (i2 & 0x3);
          i2 += 8 * a(arrayOfByte, i2 + 4) + 8;
          break;
        case 16: 
          i3 = arrayOfByte[(i2 + 1)] & 0xFF;
          if (i3 == 132) {
            i2 += 6;
          } else {
            i2 += 4;
          }
          break;
        case 1: 
        case 3: 
        case 10: 
          i2 += 2;
          break;
        case 2: 
        case 5: 
        case 6: 
        case 11: 
        case 12: 
          i2 += 3;
          break;
        case 7: 
          i2 += 5;
          break;
        case 15: 
        default: 
          i2 += 4;
        }
        if (i4 != 0)
        {
          localObject4 = new int[localObject1.length + 1];
          localObject5 = new int[localObject2.length + 1];
          System.arraycopy(localObject1, 0, localObject4, 0, localObject1.length);
          System.arraycopy(localObject2, 0, localObject5, 0, localObject2.length);
          localObject4[localObject1.length] = i2;
          localObject5[localObject2.length] = i4;
          localObject1 = localObject4;
          localObject2 = localObject5;
          if (i4 > 0) {
            i1 = 3;
          }
        }
      }
      if (i1 < 3) {
        i1--;
      }
    } while (i1 != 0);
    .ByteVector localByteVector = new .ByteVector(r.b);
    int i2 = 0;
    while (i2 < r.b)
    {
      i4 = arrayOfByte[i2] & 0xFF;
      int i7;
      int i8;
      switch (.ClassWriter.a[i4])
      {
      case 0: 
      case 4: 
        localByteVector.putByte(i4);
        i2++;
        break;
      case 8: 
        if (i4 > 201)
        {
          i4 = i4 < 218 ? i4 - 49 : i4 - 20;
          i5 = i2 + c(arrayOfByte, i2 + 1);
        }
        else
        {
          i5 = i2 + b(arrayOfByte, i2 + 1);
        }
        i6 = a((int[])localObject1, (int[])localObject2, i2, i5);
        if (arrayOfBoolean[i2] != 0)
        {
          if (i4 == 167)
          {
            localByteVector.putByte(200);
          }
          else if (i4 == 168)
          {
            localByteVector.putByte(201);
          }
          else
          {
            localByteVector.putByte(i4 <= 166 ? (i4 + 1 ^ 0x1) - 1 : i4 ^ 0x1);
            localByteVector.putShort(8);
            localByteVector.putByte(200);
            i6 -= 3;
          }
          localByteVector.putInt(i6);
        }
        else
        {
          localByteVector.putByte(i4);
          localByteVector.putShort(i6);
        }
        i2 += 3;
        break;
      case 9: 
        i5 = i2 + a(arrayOfByte, i2 + 1);
        i6 = a((int[])localObject1, (int[])localObject2, i2, i5);
        localByteVector.putByte(i4);
        localByteVector.putInt(i6);
        i2 += 5;
        break;
      case 13: 
        i7 = i2;
        i2 = i2 + 4 - (i7 & 0x3);
        localByteVector.putByte(170);
        b += (4 - b % 4) % 4;
        i5 = i7 + a(arrayOfByte, i2);
        i2 += 4;
        i6 = a((int[])localObject1, (int[])localObject2, i7, i5);
        localByteVector.putInt(i6);
        i8 = a(arrayOfByte, i2);
        i2 += 4;
        localByteVector.putInt(i8);
        i8 = a(arrayOfByte, i2) - i8 + 1;
        i2 += 4;
        localByteVector.putInt(a(arrayOfByte, i2 - 4));
      case 14: 
      case 16: 
      case 1: 
      case 3: 
      case 10: 
      case 2: 
      case 5: 
      case 6: 
      case 11: 
      case 12: 
      case 7: 
      case 15: 
      default: 
        while (i8 > 0)
        {
          i5 = i7 + a(arrayOfByte, i2);
          i2 += 4;
          i6 = a((int[])localObject1, (int[])localObject2, i7, i5);
          localByteVector.putInt(i6);
          i8--;
          continue;
          i7 = i2;
          i2 = i2 + 4 - (i7 & 0x3);
          localByteVector.putByte(171);
          b += (4 - b % 4) % 4;
          i5 = i7 + a(arrayOfByte, i2);
          i2 += 4;
          i6 = a((int[])localObject1, (int[])localObject2, i7, i5);
          localByteVector.putInt(i6);
          i8 = a(arrayOfByte, i2);
          i2 += 4;
          localByteVector.putInt(i8);
          while (i8 > 0)
          {
            localByteVector.putInt(a(arrayOfByte, i2));
            i2 += 4;
            i5 = i7 + a(arrayOfByte, i2);
            i2 += 4;
            i6 = a((int[])localObject1, (int[])localObject2, i7, i5);
            localByteVector.putInt(i6);
            i8--;
            continue;
            i4 = arrayOfByte[(i2 + 1)] & 0xFF;
            if (i4 == 132)
            {
              localByteVector.putByteArray(arrayOfByte, i2, 6);
              i2 += 6;
            }
            else
            {
              localByteVector.putByteArray(arrayOfByte, i2, 4);
              i2 += 4;
              break;
              localByteVector.putByteArray(arrayOfByte, i2, 2);
              i2 += 2;
              break;
              localByteVector.putByteArray(arrayOfByte, i2, 3);
              i2 += 3;
              break;
              localByteVector.putByteArray(arrayOfByte, i2, 5);
              i2 += 5;
              break;
              localByteVector.putByteArray(arrayOfByte, i2, 4);
              i2 += 4;
            }
          }
        }
      }
    }
    if (u > 0) {
      if (M == 0)
      {
        u = 0;
        v = null;
        x = null;
        z = null;
        localObject3 = new .Frame();
        b = N;
        localObject4 = .Type.getArgumentTypes(f);
        ((.Frame)localObject3).a(b, c, (.Type[])localObject4, t);
        b((.Frame)localObject3);
        for (localObject5 = N; localObject5 != null; localObject5 = i)
        {
          i2 = c - 3;
          if (((a & 0x20) != 0) || ((i2 >= 0) && (arrayOfBoolean[i2] != 0)))
          {
            a((int[])localObject1, (int[])localObject2, (.Label)localObject5);
            b(h);
          }
        }
      }
      else
      {
        b.I = true;
      }
    }
    for (Object localObject3 = B; localObject3 != null; localObject3 = f)
    {
      a((int[])localObject1, (int[])localObject2, a);
      a((int[])localObject1, (int[])localObject2, b);
      a((int[])localObject1, (int[])localObject2, c);
    }
    for (int i9 = 0; i9 < 2; i9++)
    {
      localObject4 = i9 == 0 ? E : G;
      if (localObject4 != null)
      {
        arrayOfByte = a;
        for (i2 = 0; i2 < b; i2 += 10)
        {
          i5 = c(arrayOfByte, i2);
          i6 = a((int[])localObject1, (int[])localObject2, 0, i5);
          a(arrayOfByte, i2, i6);
          i5 += c(arrayOfByte, i2 + 2);
          i6 = a((int[])localObject1, (int[])localObject2, 0, i5) - i6;
          a(arrayOfByte, i2 + 2, i6);
        }
      }
    }
    if (I != null)
    {
      arrayOfByte = I.a;
      for (i2 = 0; i2 < I.b; i2 += 4) {
        a(arrayOfByte, i2, a((int[])localObject1, (int[])localObject2, 0, c(arrayOfByte, i2)));
      }
    }
    for (Object localObject4 = J; localObject4 != null; localObject4 = a)
    {
      localObject5 = ((.Attribute)localObject4).getLabels();
      if (localObject5 != null) {
        for (i9 = localObject5.length - 1; i9 >= 0; i9--) {
          a((int[])localObject1, (int[])localObject2, localObject5[i9]);
        }
      }
    }
    r = localByteVector;
  }
  
  static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  static short b(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)((paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF);
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >>> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }
  
  static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2 - paramInt1;
    for (int i2 = 0; i2 < paramArrayOfInt1.length; i2++) {
      if ((paramInt1 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt2)) {
        i1 += paramArrayOfInt2[i2];
      } else if ((paramInt2 < paramArrayOfInt1[i2]) && (paramArrayOfInt1[i2] <= paramInt1)) {
        i1 -= paramArrayOfInt2[i2];
      }
    }
    return i1;
  }
  
  static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, .Label paramLabel)
  {
    if ((a & 0x4) == 0)
    {
      c = a(paramArrayOfInt1, paramArrayOfInt2, 0, c);
      a |= 0x4;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..MethodWriter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */