package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;

public class $Block
{
  private .CodeEmitter e;
  private .Label start;
  private .Label end;
  
  public $Block(.CodeEmitter e)
  {
    this.e = e;
    start = e.mark();
  }
  
  public .CodeEmitter getCodeEmitter()
  {
    return e;
  }
  
  public void end()
  {
    if (end != null) {
      throw new IllegalStateException("end of label already set");
    }
    end = e.mark();
  }
  
  public .Label getStart()
  {
    return start;
  }
  
  public .Label getEnd()
  {
    return end;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Block
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */