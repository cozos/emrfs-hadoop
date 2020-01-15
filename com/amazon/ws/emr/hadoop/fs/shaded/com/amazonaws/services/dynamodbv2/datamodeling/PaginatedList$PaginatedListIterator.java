package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class PaginatedList$PaginatedListIterator
  implements Iterator<T>
{
  private final boolean iterationOnly;
  private final List<T> allResultsCopy;
  private Iterator<T> innerIterator;
  private int pos = 0;
  
  public PaginatedList$PaginatedListIterator(PaginatedList paramPaginatedList, boolean iterationOnly)
  {
    this.iterationOnly = iterationOnly;
    if (iterationOnly)
    {
      synchronized (paramPaginatedList)
      {
        if (PaginatedList.access$000(paramPaginatedList)) {
          throw new UnsupportedOperationException("The list could only be iterated once in ITERATION_ONLY mode.");
        }
        PaginatedList.access$002(paramPaginatedList, true);
      }
      allResultsCopy = null;
      innerIterator = allResults.iterator();
    }
    else
    {
      allResultsCopy = new ArrayList();
      allResultsCopy.addAll(allResults);
      innerIterator = allResultsCopy.iterator();
    }
  }
  
  public boolean hasNext()
  {
    return (innerIterator.hasNext()) || (shouldSyncWithAllResultsList()) || 
      (PaginatedList.access$100(this$0));
  }
  
  private boolean shouldSyncWithAllResultsList()
  {
    return (!iterationOnly) && (this$0.allResults.size() > allResultsCopy.size());
  }
  
  public T next()
  {
    if (!innerIterator.hasNext())
    {
      if ((iterationOnly) || 
        (this$0.allResults.size() == allResultsCopy.size()))
      {
        if (!PaginatedList.access$100(this$0)) {
          throw new NoSuchElementException();
        }
        boolean clearPreviousResults = iterationOnly;
        PaginatedList.access$200(this$0, clearPreviousResults);
      }
      if (iterationOnly)
      {
        innerIterator = this$0.allResults.iterator();
      }
      else
      {
        if (this$0.allResults.size() > allResultsCopy.size()) {
          allResultsCopy.addAll(this$0.allResults.subList(allResultsCopy.size(), this$0.allResults
            .size()));
        }
        innerIterator = allResultsCopy.listIterator(pos);
      }
    }
    pos += 1;
    return (T)innerIterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList.PaginatedListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */