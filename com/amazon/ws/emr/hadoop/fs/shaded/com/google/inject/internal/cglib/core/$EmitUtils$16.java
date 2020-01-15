package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

final class $EmitUtils$16
  implements .ObjectSwitchCallback
{
  private final .CodeEmitter val$e;
  private final Map val$fbuckets;
  private final .ObjectSwitchCallback val$callback;
  private final .EmitUtils.ParameterTyper val$typer;
  private final .Label val$def;
  private final .Label val$end;
  private final BitSet val$checked;
  
  $EmitUtils$16(.CodeEmitter paramCodeEmitter, Map paramMap, .ObjectSwitchCallback paramObjectSwitchCallback, .EmitUtils.ParameterTyper paramParameterTyper, .Label paramLabel1, .Label paramLabel2, BitSet paramBitSet)
  {
    val$e = paramCodeEmitter;val$fbuckets = paramMap;val$callback = paramObjectSwitchCallback;val$typer = paramParameterTyper;val$def = paramLabel1;val$end = paramLabel2;val$checked = paramBitSet;
  }
  
  public void processCase(Object key, .Label dontUseEnd)
    throws Exception
  {
    .EmitUtils.access$900(val$e, (List)val$fbuckets.get(key), val$callback, val$typer, val$def, val$end, val$checked);
  }
  
  public void processDefault()
    throws Exception
  {
    val$e.goTo(val$def);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.16
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */