package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm.util..TraceClassVisitor;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.PrivilegedAction;

class $DebuggingClassWriter$1
  implements PrivilegedAction
{
  private final .DebuggingClassWriter this$0;
  
  $DebuggingClassWriter$1(.DebuggingClassWriter paramDebuggingClassWriter)
  {
    this$0 = paramDebuggingClassWriter;
  }
  
  public Object run()
  {
    byte[] b = .DebuggingClassWriter.access$001(this$0);
    if (.DebuggingClassWriter.access$100() != null)
    {
      String dirs = .DebuggingClassWriter.access$200(this$0).replace('.', File.separatorChar);
      try
      {
        new File(.DebuggingClassWriter.access$100() + File.separatorChar + dirs).getParentFile().mkdirs();
        
        File file = new File(new File(.DebuggingClassWriter.access$100()), dirs + ".class");
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        try
        {
          out.write(b);
        }
        finally
        {
          out.close();
        }
        if (.DebuggingClassWriter.access$300())
        {
          file = new File(new File(.DebuggingClassWriter.access$100()), dirs + ".asm");
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DebuggingClassWriter.1
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */