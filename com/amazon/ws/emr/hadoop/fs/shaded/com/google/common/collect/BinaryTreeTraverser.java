package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.Iterator;

@Beta
@GwtCompatible(emulated=true)
public abstract class BinaryTreeTraverser<T>
  extends TreeTraverser<T>
{
  public abstract Optional<T> leftChild(T paramT);
  
  public abstract Optional<T> rightChild(T paramT);
  
  public final Iterable<T> children(final T root)
  {
    Preconditions.checkNotNull(root);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        new AbstractIterator()
        {
          boolean doneLeft;
          boolean doneRight;
          
          protected T computeNext()
          {
            if (!doneLeft)
            {
              doneLeft = true;
              Optional<T> left = leftChild(val$root);
              if (left.isPresent()) {
                return (T)left.get();
              }
            }
            if (!doneRight)
            {
              doneRight = true;
              Optional<T> right = rightChild(val$root);
              if (right.isPresent()) {
                return (T)right.get();
              }
            }
            return (T)endOfData();
          }
        };
      }
    };
  }
  
  UnmodifiableIterator<T> preOrderIterator(T root)
  {
    return new PreOrderIterator(root);
  }
  
  private final class PreOrderIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T>
  {
    private final Deque<T> stack;
    
    PreOrderIterator()
    {
      stack = new ArrayDeque();
      stack.addLast(root);
    }
    
    public boolean hasNext()
    {
      return !stack.isEmpty();
    }
    
    public T next()
    {
      T result = stack.removeLast();
      BinaryTreeTraverser.pushIfPresent(stack, rightChild(result));
      BinaryTreeTraverser.pushIfPresent(stack, leftChild(result));
      return result;
    }
    
    public T peek()
    {
      return (T)stack.getLast();
    }
  }
  
  UnmodifiableIterator<T> postOrderIterator(T root)
  {
    return new PostOrderIterator(root);
  }
  
  private final class PostOrderIterator
    extends UnmodifiableIterator<T>
  {
    private final Deque<T> stack;
    private final BitSet hasExpanded;
    
    PostOrderIterator()
    {
      stack = new ArrayDeque();
      stack.addLast(root);
      hasExpanded = new BitSet();
    }
    
    public boolean hasNext()
    {
      return !stack.isEmpty();
    }
    
    public T next()
    {
      for (;;)
      {
        T node = stack.getLast();
        boolean expandedNode = hasExpanded.get(stack.size() - 1);
        if (expandedNode)
        {
          stack.removeLast();
          hasExpanded.clear(stack.size());
          return node;
        }
        hasExpanded.set(stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(stack, rightChild(node));
        BinaryTreeTraverser.pushIfPresent(stack, leftChild(node));
      }
    }
  }
  
  public final FluentIterable<T> inOrderTraversal(final T root)
  {
    Preconditions.checkNotNull(root);
    new FluentIterable()
    {
      public UnmodifiableIterator<T> iterator()
      {
        return new BinaryTreeTraverser.InOrderIterator(BinaryTreeTraverser.this, root);
      }
    };
  }
  
  private final class InOrderIterator
    extends AbstractIterator<T>
  {
    private final Deque<T> stack;
    private final BitSet hasExpandedLeft;
    
    InOrderIterator()
    {
      stack = new ArrayDeque();
      hasExpandedLeft = new BitSet();
      stack.addLast(root);
    }
    
    protected T computeNext()
    {
      while (!stack.isEmpty())
      {
        T node = stack.getLast();
        if (hasExpandedLeft.get(stack.size() - 1))
        {
          stack.removeLast();
          hasExpandedLeft.clear(stack.size());
          BinaryTreeTraverser.pushIfPresent(stack, rightChild(node));
          return node;
        }
        hasExpandedLeft.set(stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(stack, leftChild(node));
      }
      return (T)endOfData();
    }
  }
  
  private static <T> void pushIfPresent(Deque<T> stack, Optional<T> node)
  {
    if (node.isPresent()) {
      stack.addLast(node.get());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */