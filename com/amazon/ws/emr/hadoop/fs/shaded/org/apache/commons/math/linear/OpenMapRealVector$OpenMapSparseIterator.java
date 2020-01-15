package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.OpenIntToDoubleHashMap;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.OpenIntToDoubleHashMap.Iterator;
import java.util.Iterator;

public class OpenMapRealVector$OpenMapSparseIterator
  implements Iterator<RealVector.Entry>
{
  private final OpenIntToDoubleHashMap.Iterator iter;
  private final RealVector.Entry current;
  
  protected OpenMapRealVector$OpenMapSparseIterator(OpenMapRealVector paramOpenMapRealVector)
  {
    iter = OpenMapRealVector.access$000(paramOpenMapRealVector).iterator();
    current = new OpenMapRealVector.OpenMapEntry(paramOpenMapRealVector, iter);
  }
  
  public boolean hasNext()
  {
    return iter.hasNext();
  }
  
  public RealVector.Entry next()
  {
    iter.advance();
    return current;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Not supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.OpenMapRealVector.OpenMapSparseIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */