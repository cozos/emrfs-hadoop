package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassWriter;

public class $DefaultGeneratorStrategy
  implements .GeneratorStrategy
{
  public static final DefaultGeneratorStrategy INSTANCE = new DefaultGeneratorStrategy();
  
  public byte[] generate(.ClassGenerator cg)
    throws Exception
  {
    .ClassWriter cw = getClassWriter();
    transform(cg).generateClass(cw);
    return transform(cw.toByteArray());
  }
  
  protected .ClassWriter getClassWriter()
    throws Exception
  {
    return new .DebuggingClassWriter(1);
  }
  
  protected byte[] transform(byte[] b)
    throws Exception
  {
    return b;
  }
  
  protected .ClassGenerator transform(.ClassGenerator cg)
    throws Exception
  {
    return cg;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DefaultGeneratorStrategy
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */