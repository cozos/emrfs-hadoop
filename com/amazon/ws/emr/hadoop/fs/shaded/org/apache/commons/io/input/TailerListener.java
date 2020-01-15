package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

public abstract interface TailerListener
{
  public abstract void init(Tailer paramTailer);
  
  public abstract void fileNotFound();
  
  public abstract void fileRotated();
  
  public abstract void handle(String paramString);
  
  public abstract void handle(Exception paramException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.TailerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */