package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

class InjectionPoint$InjectableMembers
{
  InjectionPoint.InjectableMember head;
  InjectionPoint.InjectableMember tail;
  
  void add(InjectionPoint.InjectableMember member)
  {
    if (head == null)
    {
      head = (tail = member);
    }
    else
    {
      previous = tail;
      tail.next = member;
      tail = member;
    }
  }
  
  void remove(InjectionPoint.InjectableMember member)
  {
    if (previous != null) {
      previous.next = next;
    }
    if (next != null) {
      next.previous = previous;
    }
    if (head == member) {
      head = next;
    }
    if (tail == member) {
      tail = previous;
    }
  }
  
  boolean isEmpty()
  {
    return head == null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.InjectableMembers
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */