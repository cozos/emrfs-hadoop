package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..AnnotationVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Attribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..FieldVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..MethodVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;

final class $LineNumbers
{
  private final Class type;
  private final Map<String, Integer> lines = .Maps.newHashMap();
  private String source;
  private int firstLine = Integer.MAX_VALUE;
  
  public $LineNumbers(Class type)
    throws IOException
  {
    this.type = type;
    if (!type.isArray())
    {
      InputStream in = type.getResourceAsStream("/" + type.getName().replace('.', '/') + ".class");
      if (in != null) {
        new .ClassReader(in).accept(new LineNumberReader(null), 4);
      }
    }
  }
  
  public String getSource()
  {
    return source;
  }
  
  public Integer getLineNumber(Member member)
  {
    .Preconditions.checkArgument(type == member.getDeclaringClass(), "Member %s belongs to %s, not %s", new Object[] { member, member.getDeclaringClass(), type });
    
    return (Integer)lines.get(memberKey(member));
  }
  
  public int getFirstLine()
  {
    return firstLine == Integer.MAX_VALUE ? 1 : firstLine;
  }
  
  private String memberKey(Member member)
  {
    .Preconditions.checkNotNull(member, "member");
    if ((member instanceof Field)) {
      return member.getName();
    }
    if ((member instanceof Method)) {
      return member.getName() + .Type.getMethodDescriptor((Method)member);
    }
    if ((member instanceof Constructor))
    {
      StringBuilder sb = new StringBuilder().append("<init>(");
      for (Class param : ((Constructor)member).getParameterTypes()) {
        sb.append(.Type.getDescriptor(param));
      }
      return ")V";
    }
    throw new IllegalArgumentException("Unsupported implementation class for Member, " + member.getClass());
  }
  
  private class LineNumberReader
    implements .ClassVisitor, .MethodVisitor, .AnnotationVisitor
  {
    private int line = -1;
    private String pendingMethod;
    private String name;
    
    private LineNumberReader() {}
    
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
      .LineNumbers.this.source = source;
    }
    
    public void visitLineNumber(int line, .Label start)
    {
      if (line < firstLine) {
        firstLine = line;
      }
      this.line = line;
      if (pendingMethod != null)
      {
        lines.put(pendingMethod, Integer.valueOf(line));
        pendingMethod = null;
      }
    }
    
    public void visitFieldInsn(int opcode, String owner, String name, String desc)
    {
      if ((opcode == 181) && (this.name.equals(owner)) && (!lines.containsKey(name)) && (line != -1)) {
        lines.put(name, Integer.valueOf(line));
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..LineNumbers
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */