package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..AnnotationVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Attribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..FieldVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..MethodVisitor;
import java.util.Map;

class $LineNumbers$LineNumberReader
  implements .ClassVisitor, .MethodVisitor, .AnnotationVisitor
{
  private int line = -1;
  private String pendingMethod;
  private String name;
  
  private $LineNumbers$LineNumberReader(.LineNumbers paramLineNumbers) {}
  
  public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
  {
    this.name = name;
  }
  
  public .MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
  {
    if ((access & 0x2) != 0) {
      return null;
    }
    pendingMethod = (name + desc);
    line = -1;
    return this;
  }
  
  public void visitSource(String source, String debug)
  {
    .LineNumbers.access$102(this$0, source);
  }
  
  public void visitLineNumber(int line, .Label start)
  {
    if (line < .LineNumbers.access$200(this$0)) {
      .LineNumbers.access$202(this$0, line);
    }
    this.line = line;
    if (pendingMethod != null)
    {
      .LineNumbers.access$300(this$0).put(pendingMethod, Integer.valueOf(line));
      pendingMethod = null;
    }
  }
  
  public void visitFieldInsn(int opcode, String owner, String name, String desc)
  {
    if ((opcode == 181) && (this.name.equals(owner)) && (!.LineNumbers.access$300(this$0).containsKey(name)) && (line != -1)) {
      .LineNumbers.access$300(this$0).put(name, Integer.valueOf(line));
    }
  }
  
  public void visitEnd() {}
  
  public void visitInnerClass(String name, String outerName, String innerName, int access) {}
  
  public void visitOuterClass(String owner, String name, String desc) {}
  
  public void visitAttribute(.Attribute attr) {}
  
  public .FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
  {
    return null;
  }
  
  public .AnnotationVisitor visitAnnotation(String desc, boolean visible)
  {
    return this;
  }
  
  public .AnnotationVisitor visitAnnotation(String name, String desc)
  {
    return this;
  }
  
  public .AnnotationVisitor visitAnnotationDefault()
  {
    return this;
  }
  
  public .AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible)
  {
    return this;
  }
  
  public .AnnotationVisitor visitArray(String name)
  {
    return this;
  }
  
  public void visitEnum(String name, String desc, String value) {}
  
  public void visit(String name, Object value) {}
  
  public void visitCode() {}
  
  public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {}
  
  public void visitIincInsn(int var, int increment) {}
  
  public void visitInsn(int opcode) {}
  
  public void visitIntInsn(int opcode, int operand) {}
  
  public void visitJumpInsn(int opcode, .Label label) {}
  
  public void visitLabel(.Label label) {}
  
  public void visitLdcInsn(Object cst) {}
  
  public void visitLocalVariable(String name, String desc, String signature, .Label start, .Label end, int index) {}
  
  public void visitLookupSwitchInsn(.Label dflt, int[] keys, .Label[] labels) {}
  
  public void visitMaxs(int maxStack, int maxLocals) {}
  
  public void visitMethodInsn(int opcode, String owner, String name, String desc) {}
  
  public void visitMultiANewArrayInsn(String desc, int dims) {}
  
  public void visitTableSwitchInsn(int min, int max, .Label dflt, .Label[] labels) {}
  
  public void visitTryCatchBlock(.Label start, .Label end, .Label handler, String type) {}
  
  public void visitTypeInsn(int opcode, String desc) {}
  
  public void visitVarInsn(int opcode, int var) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..LineNumbers.LineNumberReader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */