package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm;

public class $MethodAdapter
  implements .MethodVisitor
{
  protected .MethodVisitor mv;
  
  public $MethodAdapter(.MethodVisitor paramMethodVisitor)
  {
    mv = paramMethodVisitor;
  }
  
  public .AnnotationVisitor visitAnnotationDefault()
  {
    return mv.visitAnnotationDefault();
  }
  
  public .AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean)
  {
    return mv.visitAnnotation(paramString, paramBoolean);
  }
  
  public .AnnotationVisitor visitParameterAnnotation(int paramInt, String paramString, boolean paramBoolean)
  {
    return mv.visitParameterAnnotation(paramInt, paramString, paramBoolean);
  }
  
  public void visitAttribute(.Attribute paramAttribute)
  {
    mv.visitAttribute(paramAttribute);
  }
  
  public void visitCode()
  {
    mv.visitCode();
  }
  
  public void visitFrame(int paramInt1, int paramInt2, Object[] paramArrayOfObject1, int paramInt3, Object[] paramArrayOfObject2)
  {
    mv.visitFrame(paramInt1, paramInt2, paramArrayOfObject1, paramInt3, paramArrayOfObject2);
  }
  
  public void visitInsn(int paramInt)
  {
    mv.visitInsn(paramInt);
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2)
  {
    mv.visitIntInsn(paramInt1, paramInt2);
  }
  
  public void visitVarInsn(int paramInt1, int paramInt2)
  {
    mv.visitVarInsn(paramInt1, paramInt2);
  }
  
  public void visitTypeInsn(int paramInt, String paramString)
  {
    mv.visitTypeInsn(paramInt, paramString);
  }
  
  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mv.visitFieldInsn(paramInt, paramString1, paramString2, paramString3);
  }
  
  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mv.visitMethodInsn(paramInt, paramString1, paramString2, paramString3);
  }
  
  public void visitJumpInsn(int paramInt, .Label paramLabel)
  {
    mv.visitJumpInsn(paramInt, paramLabel);
  }
  
  public void visitLabel(.Label paramLabel)
  {
    mv.visitLabel(paramLabel);
  }
  
  public void visitLdcInsn(Object paramObject)
  {
    mv.visitLdcInsn(paramObject);
  }
  
  public void visitIincInsn(int paramInt1, int paramInt2)
  {
    mv.visitIincInsn(paramInt1, paramInt2);
  }
  
  public void visitTableSwitchInsn(int paramInt1, int paramInt2, .Label paramLabel, .Label[] paramArrayOfLabel)
  {
    mv.visitTableSwitchInsn(paramInt1, paramInt2, paramLabel, paramArrayOfLabel);
  }
  
  public void visitLookupSwitchInsn(.Label paramLabel, int[] paramArrayOfInt, .Label[] paramArrayOfLabel)
  {
    mv.visitLookupSwitchInsn(paramLabel, paramArrayOfInt, paramArrayOfLabel);
  }
  
  public void visitMultiANewArrayInsn(String paramString, int paramInt)
  {
    mv.visitMultiANewArrayInsn(paramString, paramInt);
  }
  
  public void visitTryCatchBlock(.Label paramLabel1, .Label paramLabel2, .Label paramLabel3, String paramString)
  {
    mv.visitTryCatchBlock(paramLabel1, paramLabel2, paramLabel3, paramString);
  }
  
  public void visitLocalVariable(String paramString1, String paramString2, String paramString3, .Label paramLabel1, .Label paramLabel2, int paramInt)
  {
    mv.visitLocalVariable(paramString1, paramString2, paramString3, paramLabel1, paramLabel2, paramInt);
  }
  
  public void visitLineNumber(int paramInt, .Label paramLabel)
  {
    mv.visitLineNumber(paramInt, paramLabel);
  }
  
  public void visitMaxs(int paramInt1, int paramInt2)
  {
    mv.visitMaxs(paramInt1, paramInt2);
  }
  
  public void visitEnd()
  {
    mv.visitEnd();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..MethodAdapter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */