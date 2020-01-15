package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class PaginatedList<T>
  implements List<T>
{
  private static final String UNMODIFIABLE_MESSAGE = "This is an unmodifiable list";
  private static final String ITERATION_ONLY_UNSUPPORTED_OPERATION_MESSAGE = " is not supported when using ITERATION_ONLY configuration.";
  protected final DynamoDBMapper mapper;
  protected final Class<T> clazz;
  protected final AmazonDynamoDB dynamo;
  protected boolean allResultsLoaded = false;
  protected final List<T> allResults;
  protected final List<T> nextResults = new LinkedList();
  private final DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy;
  private boolean iterationStarted = false;
  
  public PaginatedList(DynamoDBMapper mapper, Class<T> clazz, AmazonDynamoDB dynamo)
  {
    this(mapper, clazz, dynamo, null);
  }
  
  public PaginatedList(DynamoDBMapper mapper, Class<T> clazz, AmazonDynamoDB dynamo, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy)
  {
    this.mapper = mapper;
    this.clazz = clazz;
    this.dynamo = dynamo;
    this.paginationLoadingStrategy = (paginationLoadingStrategy == null ? DynamoDBMapperConfig.PaginationLoadingStrategy.LAZY_LOADING : paginationLoadingStrategy);
    
    allResults = new ArrayList();
  }
  
  public synchronized void loadAllResults()
  {
    checkUnsupportedOperationForIterationOnlyMode("loadAllResults()");
    if (allResultsLoaded) {
      return;
    }
    while (nextResultsAvailable()) {
      moveNextResults(false);
    }
    allResultsLoaded = true;
  }
  
  private boolean nextResultsAvailable()
  {
    return (!nextResults.isEmpty()) || (loadNextResults());
  }
  
  private synchronized boolean loadNextResults()
  {
    if (atEndOfResults()) {
      return false;
    }
    do
    {
      nextResults.addAll(fetchNextPage());
    } while ((!atEndOfResults()) && (nextResults.isEmpty()));
    return !nextResults.isEmpty();
  }
  
  private void moveNextResults(boolean clearPreviousResults)
  {
    if (clearPreviousResults) {
      allResults.clear();
    }
    allResults.addAll(nextResults);
    nextResults.clear();
  }
  
  protected abstract List<T> fetchNextPage();
  
  protected abstract boolean atEndOfResults();
  
  public Iterator<T> iterator()
  {
    return new PaginatedListIterator(paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.ITERATION_ONLY);
  }
  
  private class PaginatedListIterator
    implements Iterator<T>
  {
    private final boolean iterationOnly;
    private final List<T> allResultsCopy;
    private Iterator<T> innerIterator;
    private int pos = 0;
    
    public PaginatedListIterator(boolean iterationOnly)
    {
      this.iterationOnly = iterationOnly;
      if (iterationOnly)
      {
        synchronized (PaginatedList.this)
        {
          if (iterationStarted) {
            throw new UnsupportedOperationException("The list could only be iterated once in ITERATION_ONLY mode.");
          }
          iterationStarted = true;
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
        (PaginatedList.this.nextResultsAvailable());
    }
    
    private boolean shouldSyncWithAllResultsList()
    {
      return (!iterationOnly) && (allResults.size() > allResultsCopy.size());
    }
    
    public T next()
    {
      if (!innerIterator.hasNext())
      {
        if ((iterationOnly) || 
          (allResults.size() == allResultsCopy.size()))
        {
          if (!PaginatedList.this.nextResultsAvailable()) {
            throw new NoSuchElementException();
          }
          boolean clearPreviousResults = iterationOnly;
          PaginatedList.this.moveNextResults(clearPreviousResults);
        }
        if (iterationOnly)
        {
          innerIterator = allResults.iterator();
        }
        else
        {
          if (allResults.size() > allResultsCopy.size()) {
            allResultsCopy.addAll(allResults.subList(allResultsCopy.size(), allResults
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
  
  public boolean isEmpty()
  {
    checkUnsupportedOperationForIterationOnlyMode("isEmpty()");
    
    return !iterator().hasNext();
  }
  
  public T get(int n)
  {
    checkUnsupportedOperationForIterationOnlyMode("get(int n)");
    while ((allResults.size() <= n) && (nextResultsAvailable())) {
      moveNextResults(false);
    }
    return (T)allResults.get(n);
  }
  
  public boolean contains(Object arg0)
  {
    checkUnsupportedOperationForIterationOnlyMode("contains(Object arg0)");
    if (allResults.contains(arg0)) {
      return true;
    }
    while (nextResultsAvailable())
    {
      boolean found = nextResults.contains(arg0);
      moveNextResults(false);
      if (found) {
        return true;
      }
    }
    return false;
  }
  
  public List<T> subList(int arg0, int arg1)
  {
    checkUnsupportedOperationForIterationOnlyMode("subList(int arg0, int arg1)");
    while ((allResults.size() < arg1) && (nextResultsAvailable())) {
      moveNextResults(false);
    }
    return Collections.unmodifiableList(allResults.subList(arg0, arg1));
  }
  
  public int indexOf(Object arg0)
  {
    checkUnsupportedOperationForIterationOnlyMode("indexOf(Object org0)");
    
    int indexOf = allResults.indexOf(arg0);
    if (indexOf >= 0) {
      return indexOf;
    }
    while (nextResultsAvailable())
    {
      indexOf = nextResults.indexOf(arg0);
      int size = allResults.size();
      moveNextResults(false);
      if (indexOf >= 0) {
        return indexOf + size;
      }
    }
    return -1;
  }
  
  public int size()
  {
    loadAllResults();
    return allResults.size();
  }
  
  public boolean containsAll(Collection<?> arg0)
  {
    loadAllResults();
    return allResults.containsAll(arg0);
  }
  
  public int lastIndexOf(Object arg0)
  {
    loadAllResults();
    return allResults.lastIndexOf(arg0);
  }
  
  public Object[] toArray()
  {
    loadAllResults();
    return allResults.toArray();
  }
  
  public <X> X[] toArray(X[] a)
  {
    loadAllResults();
    return allResults.toArray(a);
  }
  
  public ListIterator<T> listIterator()
  {
    throw new UnsupportedOperationException("ListIterators are not supported for this list");
  }
  
  public ListIterator<T> listIterator(int arg0)
  {
    throw new UnsupportedOperationException("ListIterators are not supported for this list");
  }
  
  public boolean remove(Object arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public T remove(int arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public boolean removeAll(Collection<?> arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public boolean retainAll(Collection<?> arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public T set(int arg0, T arg1)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public boolean add(T arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public void add(int arg0, T arg1)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public boolean addAll(Collection<? extends T> arg0)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public boolean addAll(int arg0, Collection<? extends T> arg1)
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("This is an unmodifiable list");
  }
  
  private void checkUnsupportedOperationForIterationOnlyMode(String methodSignature)
  {
    if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.ITERATION_ONLY) {
      throw new UnsupportedOperationException(methodSignature + " is not supported when using ITERATION_ONLY configuration.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */