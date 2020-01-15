package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class $FastClassEmitter$GetIndexCallback
  implements .ObjectSwitchCallback
{
  private .CodeEmitter e;
  private Map indexes = new HashMap();
  
  public $FastClassEmitter$GetIndexCallback(.CodeEmitter e, List methods)
  {
    this.e = e;
    int index = 0;
    for (Iterator it = methods.iterator(); it.hasNext();) {
      indexes.put(it.next(), new Integer(index++));
    }
  }
  
  public void processCase(Object key, .Label end)
  {
    e.push(((Integer)indexes.get(key)).intValue());
    e.return_value();
  }
  
  public void processDefault()
  {
    e.push(-1);
    e.return_value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClassEmitter.GetIndexCallback
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */