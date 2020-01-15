package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

class DateUtils$DateIterator
  implements Iterator<Calendar>
{
  private final Calendar endFinal;
  private final Calendar spot;
  
  DateUtils$DateIterator(Calendar startFinal, Calendar endFinal)
  {
    this.endFinal = endFinal;
    spot = startFinal;
    spot.add(5, -1);
  }
  
  public boolean hasNext()
  {
    return spot.before(endFinal);
  }
  
  public Calendar next()
  {
    if (spot.equals(endFinal)) {
      throw new NoSuchElementException();
    }
    spot.add(5, 1);
    return (Calendar)spot.clone();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.DateUtils.DateIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */