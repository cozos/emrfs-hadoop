package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import java.util.List;

final class $ClassNameReader$1
  extends .ClassAdapter
{
  private final List val$array;
  
  $ClassNameReader$1(.ClassVisitor x0, List paramList)
  {
    super(x0);val$array = paramList;
  }
  
  public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
  {
    val$array.add(name.replace('/', '.'));
    if (superName != null) {
      val$array.add(superName.replace('/', '.'));
    }
    for (int i = 0; i < interfaces.length; i++) {
      val$array.add(interfaces[i].replace('/', '.'));
    }
    throw .ClassNameReader.access$100();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassNameReader.1
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */