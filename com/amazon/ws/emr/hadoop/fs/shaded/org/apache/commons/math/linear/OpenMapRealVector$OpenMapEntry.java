package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.OpenIntToDoubleHashMap;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.OpenIntToDoubleHashMap.Iterator;

public class OpenMapRealVector$OpenMapEntry
  extends RealVector.Entry
{
  private final OpenIntToDoubleHashMap.Iterator iter;
  
  protected OpenMapRealVector$OpenMapEntry(OpenMapRealVector paramOpenMapRealVector, OpenIntToDoubleHashMap.Iterator iter)
  {
    this.iter = iter;
  }
  
  public double getValue()
  {
    return iter.value();
  }
  
  public void setValue(double value)
  {
    OpenMapRealVector.access$000(this$0).put(iter.key(), value);
  }
  
  public int getIndex()
  {
    return iter.key();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.OpenMapRealVector.OpenMapEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */