package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

public class $Attribute
{
  public final String type;
  byte[] b;
  Attribute a;
  
  protected $Attribute(String paramString)
  {
    type = paramString;
  }
  
  public boolean isUnknown()
  {
    return true;
  }
  
  public boolean isCodeAttribute()
  {
    return false;
  }
  
  protected .Label[] getLabels()
  {
    return null;
  }
  
  protected Attribute read(.ClassReader paramClassReader, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3, .Label[] paramArrayOfLabel)
  {
    Attribute localAttribute = new Attribute(type);
    b = new byte[paramInt2];
    System.arraycopy(b, paramInt1, b, 0, paramInt2);
    return localAttribute;
  }
  
  protected .ByteVector write(.ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    .ByteVector localByteVector = new .ByteVector();
    a = b;
    b = b.length;
    return localByteVector;
  }
  
  final int a()
  {
    int i = 0;
    for (Attribute localAttribute = this; localAttribute != null; localAttribute = a) {
      i++;
    }
    return i;
  }
  
  final int a(.ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Attribute localAttribute = this;
    int i = 0;
    while (localAttribute != null)
    {
      paramClassWriter.newUTF8(type);
      i += writeb + 6;
      localAttribute = a;
    }
    return i;
  }
  
  final void a(.ClassWriter paramClassWriter, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, .ByteVector paramByteVector)
  {
    for (Attribute localAttribute = this; localAttribute != null; localAttribute = a)
    {
      .ByteVector localByteVector = localAttribute.write(paramClassWriter, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      paramByteVector.putShort(paramClassWriter.newUTF8(type)).putInt(b);
      paramByteVector.putByteArray(a, 0, b);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Attribute
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */