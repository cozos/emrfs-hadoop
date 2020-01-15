package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm.util..TraceClassVisitor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class $DebuggingClassWriter
  extends .ClassWriter
{
  public static final String DEBUG_LOCATION_PROPERTY = "cglib.debugLocation";
  private static String debugLocation = System.getProperty("cglib.debugLocation");
  private static boolean traceEnabled;
  private String className;
  private String superName;
  
  static
  {
    if (debugLocation != null)
    {
      System.err.println("CGLIB debugging enabled, writing to '" + debugLocation + "'");
      try
      {
        Class.forName("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm.util.$TraceClassVisitor");
        traceEnabled = true;
      }
      catch (Throwable ignore) {}
    }
  }
  
  public $DebuggingClassWriter(int flags)
  {
    super(flags);
  }
  
  public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
  {
    className = name.replace('/', '.');
    this.superName = superName.replace('/', '.');
    super.visit(version, access, name, signature, superName, interfaces);
  }
  
  public String getClassName()
  {
    return className;
  }
  
  public String getSuperName()
  {
    return superName;
  }
  
  public byte[] toByteArray()
  {
    (byte[])AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        byte[] b = .DebuggingClassWriter.this.toByteArray();
        if (.DebuggingClassWriter.debugLocation != null)
        {
          String dirs = className.replace('.', File.separatorChar);
          try
          {
            new File(.DebuggingClassWriter.debugLocation + File.separatorChar + dirs).getParentFile().mkdirs();
            
            File file = new File(new File(.DebuggingClassWriter.debugLocation), dirs + ".class");
            OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            try
            {
              out.write(b);
            }
            finally
            {
              out.close();
            }
            if (.DebuggingClassWriter.traceEnabled)
            {
              file = new File(new File(.DebuggingClassWriter.debugLocation), dirs + ".asm");
              out = new BufferedOutputStream(new FileOutputStream(file));
              try
              {
                .ClassReader cr = new .ClassReader(b);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
                .TraceClassVisitor tcv = new .TraceClassVisitor(null, pw);
                cr.accept(tcv, 0);
                pw.flush();
              }
              finally
              {
                out.close();
              }
            }
          }
          catch (IOException e)
          {
            throw new .CodeGenerationException(e);
          }
        }
        return b;
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DebuggingClassWriter
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */