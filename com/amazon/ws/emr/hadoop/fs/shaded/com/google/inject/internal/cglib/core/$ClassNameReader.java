package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassVisitor;
import java.util.ArrayList;
import java.util.List;

public class $ClassNameReader
{
  private static final EarlyExitException EARLY_EXIT = new EarlyExitException(null);
  
  private static class EarlyExitException
    extends RuntimeException
  {
    private EarlyExitException() {}
    
    EarlyExitException(.ClassNameReader.1 x0)
    {
      this();
    }
  }
  
  public static String getClassName(.ClassReader r)
  {
    return getClassInfo(r)[0];
  }
  
  public static String[] getClassInfo(.ClassReader r)
  {
    List array = new ArrayList();
    try
    {
      r.accept(new .ClassAdapter(null)
      {
        private final List val$array;
        
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
        {
          val$array.add(name.replace('/', '.'));
          if (superName != null) {
            val$array.add(superName.replace('/', '.'));
          }
          for (int i = 0; i < interfaces.length; i++) {
            val$array.add(interfaces[i].replace('/', '.'));
          }
          throw .ClassNameReader.EARLY_EXIT;
        }
      }, 6);
    }
    catch (EarlyExitException e) {}
    return (String[])array.toArray(new String[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassNameReader
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */