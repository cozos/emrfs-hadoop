package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtraMaterialsDescription
  implements Serializable
{
  public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
  private final Map<String, String> extra;
  private final ConflictResolution resolve;
  
  public static enum ConflictResolution
  {
    FAIL_FAST,  OVERRIDE,  OVERRIDDEN;
    
    private ConflictResolution() {}
  }
  
  public ExtraMaterialsDescription(Map<String, String> matdesc)
  {
    this(matdesc, ConflictResolution.FAIL_FAST);
  }
  
  public ExtraMaterialsDescription(Map<String, String> matdesc, ConflictResolution resolve)
  {
    if ((matdesc == null) || (resolve == null)) {
      throw new IllegalArgumentException();
    }
    extra = Collections.unmodifiableMap(new HashMap(matdesc));
    
    this.resolve = resolve;
  }
  
  public Map<String, String> getMaterialDescription()
  {
    return extra;
  }
  
  public ConflictResolution getConflictResolution()
  {
    return resolve;
  }
  
  public Map<String, String> mergeInto(Map<String, String> core)
  {
    if (extra.size() == 0) {
      return core;
    }
    if ((core == null) || (core.size() == 0)) {
      return extra;
    }
    switch (resolve)
    {
    case FAIL_FAST: 
      int total = core.size() + extra.size();
      Map<String, String> merged = new HashMap(core);
      merged.putAll(extra);
      if (total != merged.size()) {
        throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
      }
      return Collections.unmodifiableMap(merged);
    case OVERRIDDEN: 
      Map<String, String> merged = new HashMap(extra);
      merged.putAll(core);
      return Collections.unmodifiableMap(merged);
    case OVERRIDE: 
      Map<String, String> merged = new HashMap(core);
      merged.putAll(extra);
      return Collections.unmodifiableMap(merged);
    }
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ExtraMaterialsDescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */