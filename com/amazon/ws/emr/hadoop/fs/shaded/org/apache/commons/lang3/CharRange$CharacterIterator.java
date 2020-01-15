package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.util.Iterator;
import java.util.NoSuchElementException;

class CharRange$CharacterIterator
  implements Iterator<Character>
{
  private char current;
  private final CharRange range;
  private boolean hasNext;
  
  private CharRange$CharacterIterator(CharRange r)
  {
    range = r;
    hasNext = true;
    if (CharRange.access$100(range))
    {
      if (CharRange.access$200(range) == 0)
      {
        if (CharRange.access$300(range) == 65535) {
          hasNext = false;
        } else {
          current = ((char)(CharRange.access$300(range) + '\001'));
        }
      }
      else {
        current = '\000';
      }
    }
    else {
      current = CharRange.access$200(range);
    }
  }
  
  private void prepareNext()
  {
    if (CharRange.access$100(range))
    {
      if (current == 65535) {
        hasNext = false;
      } else if (current + '\001' == CharRange.access$200(range))
      {
        if (CharRange.access$300(range) == 65535) {
          hasNext = false;
        } else {
          current = ((char)(CharRange.access$300(range) + '\001'));
        }
      }
      else {
        current = ((char)(current + '\001'));
      }
    }
    else if (current < CharRange.access$300(range)) {
      current = ((char)(current + '\001'));
    } else {
      hasNext = false;
    }
  }
  
  public boolean hasNext()
  {
    return hasNext;
  }
  
  public Character next()
  {
    if (!hasNext) {
      throw new NoSuchElementException();
    }
    char cur = current;
    prepareNext();
    return Character.valueOf(cur);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.CharRange.CharacterIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */