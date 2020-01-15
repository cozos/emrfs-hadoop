package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory
{
  @Beta
  @ThreadSafe
  public static abstract interface Policy
  {
    public abstract void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException paramPotentialDeadlockException);
  }
  
  @Beta
  public static abstract enum Policies
    implements CycleDetectingLockFactory.Policy
  {
    THROW,  WARN,  DISABLED;
    
    private Policies() {}
  }
  
  public static CycleDetectingLockFactory newInstance(Policy policy)
  {
    return new CycleDetectingLockFactory(policy);
  }
  
  public ReentrantLock newReentrantLock(String lockName)
  {
    return newReentrantLock(lockName, false);
  }
  
  public ReentrantLock newReentrantLock(String lockName, boolean fair)
  {
    return policy == Policies.DISABLED ? new ReentrantLock(fair) : new CycleDetectingReentrantLock(new LockGraphNode(lockName), fair, null);
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(String lockName)
  {
    return newReentrantReadWriteLock(lockName, false);
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(String lockName, boolean fair)
  {
    return policy == Policies.DISABLED ? new ReentrantReadWriteLock(fair) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(lockName), fair, null);
  }
  
  private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
  
  public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> enumClass, Policy policy)
  {
    Preconditions.checkNotNull(enumClass);
    Preconditions.checkNotNull(policy);
    
    Map<E, LockGraphNode> lockGraphNodes = getOrCreateNodes(enumClass);
    
    return new WithExplicitOrdering(policy, lockGraphNodes);
  }
  
  private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> clazz)
  {
    Map<? extends Enum, LockGraphNode> existing = (Map)lockGraphNodesPerType.get(clazz);
    if (existing != null) {
      return existing;
    }
    Map<? extends Enum, LockGraphNode> created = createNodes(clazz);
    existing = (Map)lockGraphNodesPerType.putIfAbsent(clazz, created);
    return (Map)MoreObjects.firstNonNull(existing, created);
  }
  
  @VisibleForTesting
  static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> clazz)
  {
    EnumMap<E, LockGraphNode> map = Maps.newEnumMap(clazz);
    E[] keys = (Enum[])clazz.getEnumConstants();
    int numKeys = keys.length;
    ArrayList<LockGraphNode> nodes = Lists.newArrayListWithCapacity(numKeys);
    for (E key : keys)
    {
      LockGraphNode node = new LockGraphNode(getLockName(key));
      nodes.add(node);
      map.put(key, node);
    }
    for (int i = 1; i < numKeys; i++) {
      ((LockGraphNode)nodes.get(i)).checkAcquiredLocks(Policies.THROW, nodes.subList(0, i));
    }
    for (int i = 0; i < numKeys - 1; i++) {
      ((LockGraphNode)nodes.get(i)).checkAcquiredLocks(Policies.DISABLED, nodes.subList(i + 1, numKeys));
    }
    return Collections.unmodifiableMap(map);
  }
  
  private static String getLockName(Enum<?> rank)
  {
    String str1 = String.valueOf(String.valueOf(rank.getDeclaringClass().getSimpleName()));String str2 = String.valueOf(String.valueOf(rank.name()));return 1 + str1.length() + str2.length() + str1 + "." + str2;
  }
  
  @Beta
  public static final class WithExplicitOrdering<E extends Enum<E>>
    extends CycleDetectingLockFactory
  {
    private final Map<E, CycleDetectingLockFactory.LockGraphNode> lockGraphNodes;
    
    @VisibleForTesting
    WithExplicitOrdering(CycleDetectingLockFactory.Policy policy, Map<E, CycleDetectingLockFactory.LockGraphNode> lockGraphNodes)
    {
      super(null);
      this.lockGraphNodes = lockGraphNodes;
    }
    
    public ReentrantLock newReentrantLock(E rank)
    {
      return newReentrantLock(rank, false);
    }
    
    public ReentrantLock newReentrantLock(E rank, boolean fair)
    {
      return policy == CycleDetectingLockFactory.Policies.DISABLED ? new ReentrantLock(fair) : new CycleDetectingLockFactory.CycleDetectingReentrantLock(this, (CycleDetectingLockFactory.LockGraphNode)lockGraphNodes.get(rank), fair, null);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(E rank)
    {
      return newReentrantReadWriteLock(rank, false);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(E rank, boolean fair)
    {
      return policy == CycleDetectingLockFactory.Policies.DISABLED ? new ReentrantReadWriteLock(fair) : new CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory.LockGraphNode)lockGraphNodes.get(rank), fair, null);
    }
  }
  
  private static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
  final Policy policy;
  
  private CycleDetectingLockFactory(Policy policy)
  {
    this.policy = ((Policy)Preconditions.checkNotNull(policy));
  }
  
  private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = new ThreadLocal()
  {
    protected ArrayList<CycleDetectingLockFactory.LockGraphNode> initialValue()
    {
      return Lists.newArrayListWithCapacity(3);
    }
  };
  
  private static class ExampleStackTrace
    extends IllegalStateException
  {
    static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    static Set<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), CycleDetectingLockFactory.LockGraphNode.class.getName());
    
    ExampleStackTrace(CycleDetectingLockFactory.LockGraphNode node1, CycleDetectingLockFactory.LockGraphNode node2)
    {
      super();
      StackTraceElement[] origStackTrace = getStackTrace();
      int i = 0;
      for (int n = origStackTrace.length; i < n; i++)
      {
        if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(origStackTrace[i].getClassName()))
        {
          setStackTrace(EMPTY_STACK_TRACE);
          break;
        }
        if (!EXCLUDED_CLASS_NAMES.contains(origStackTrace[i].getClassName()))
        {
          setStackTrace((StackTraceElement[])Arrays.copyOfRange(origStackTrace, i, n));
          break;
        }
      }
    }
  }
  
  @Beta
  public static final class PotentialDeadlockException
    extends CycleDetectingLockFactory.ExampleStackTrace
  {
    private final CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace;
    
    private PotentialDeadlockException(CycleDetectingLockFactory.LockGraphNode node1, CycleDetectingLockFactory.LockGraphNode node2, CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace)
    {
      super(node2);
      this.conflictingStackTrace = conflictingStackTrace;
      initCause(conflictingStackTrace);
    }
    
    public CycleDetectingLockFactory.ExampleStackTrace getConflictingStackTrace()
    {
      return conflictingStackTrace;
    }
    
    public String getMessage()
    {
      StringBuilder message = new StringBuilder(super.getMessage());
      for (Throwable t = conflictingStackTrace; t != null; t = t.getCause()) {
        message.append(", ").append(t.getMessage());
      }
      return message.toString();
    }
  }
  
  private static abstract interface CycleDetectingLock
  {
    public abstract CycleDetectingLockFactory.LockGraphNode getLockGraphNode();
    
    public abstract boolean isAcquiredByCurrentThread();
  }
  
  private static class LockGraphNode
  {
    final Map<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> allowedPriorLocks = new MapMaker().weakKeys().makeMap();
    final Map<LockGraphNode, CycleDetectingLockFactory.PotentialDeadlockException> disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
    final String lockName;
    
    LockGraphNode(String lockName)
    {
      this.lockName = ((String)Preconditions.checkNotNull(lockName));
    }
    
    String getLockName()
    {
      return lockName;
    }
    
    void checkAcquiredLocks(CycleDetectingLockFactory.Policy policy, List<LockGraphNode> acquiredLocks)
    {
      int i = 0;
      for (int size = acquiredLocks.size(); i < size; i++) {
        checkAcquiredLock(policy, (LockGraphNode)acquiredLocks.get(i));
      }
    }
    
    /* Error */
    void checkAcquiredLock(CycleDetectingLockFactory.Policy policy, LockGraphNode acquiredLock)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: if_acmpeq +7 -> 9
      //   5: iconst_1
      //   6: goto +4 -> 10
      //   9: iconst_0
      //   10: ldc 90
      //   12: aload_2
      //   13: invokevirtual 92	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:getLockName	()Ljava/lang/String;
      //   16: invokestatic 96	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   19: dup
      //   20: invokevirtual 99	java/lang/String:length	()I
      //   23: ifeq +9 -> 32
      //   26: invokevirtual 103	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   29: goto +12 -> 41
      //   32: pop
      //   33: new 59	java/lang/String
      //   36: dup_x1
      //   37: swap
      //   38: invokespecial 105	java/lang/String:<init>	(Ljava/lang/String;)V
      //   41: invokestatic 109	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkState	(ZLjava/lang/Object;)V
      //   44: aload_0
      //   45: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:allowedPriorLocks	Ljava/util/Map;
      //   48: aload_2
      //   49: invokeinterface 113 2 0
      //   54: ifeq +4 -> 58
      //   57: return
      //   58: aload_0
      //   59: getfield 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:disallowedPriorLocks	Ljava/util/Map;
      //   62: aload_2
      //   63: invokeinterface 115 2 0
      //   68: checkcast 13	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException
      //   71: astore_3
      //   72: aload_3
      //   73: ifnull +28 -> 101
      //   76: new 13	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException
      //   79: dup
      //   80: aload_2
      //   81: aload_0
      //   82: aload_3
      //   83: invokevirtual 119	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException:getConflictingStackTrace	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;
      //   86: aconst_null
      //   87: invokespecial 122	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$1;)V
      //   90: astore 4
      //   92: aload_1
      //   93: aload 4
      //   95: invokeinterface 126 2 0
      //   100: return
      //   101: invokestatic 132	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Sets:newIdentityHashSet	()Ljava/util/Set;
      //   104: astore 4
      //   106: aload_2
      //   107: aload_0
      //   108: aload 4
      //   110: invokespecial 136	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:findPathTo	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Ljava/util/Set;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;
      //   113: astore 5
      //   115: aload 5
      //   117: ifnonnull +26 -> 143
      //   120: aload_0
      //   121: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:allowedPriorLocks	Ljava/util/Map;
      //   124: aload_2
      //   125: new 10	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace
      //   128: dup
      //   129: aload_2
      //   130: aload_0
      //   131: invokespecial 139	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;)V
      //   134: invokeinterface 143 3 0
      //   139: pop
      //   140: goto +38 -> 178
      //   143: new 13	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException
      //   146: dup
      //   147: aload_2
      //   148: aload_0
      //   149: aload 5
      //   151: aconst_null
      //   152: invokespecial 122	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$PotentialDeadlockException:<init>	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$ExampleStackTrace;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$1;)V
      //   155: astore 6
      //   157: aload_0
      //   158: getfield 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/util/concurrent/CycleDetectingLockFactory$LockGraphNode:disallowedPriorLocks	Ljava/util/Map;
      //   161: aload_2
      //   162: aload 6
      //   164: invokeinterface 143 3 0
      //   169: pop
      //   170: aload_1
      //   171: aload 6
      //   173: invokeinterface 126 2 0
      //   178: return
      // Line number table:
      //   Java source line #668	-> byte code offset #0
      //   Java source line #673	-> byte code offset #44
      //   Java source line #677	-> byte code offset #57
      //   Java source line #679	-> byte code offset #58
      //   Java source line #681	-> byte code offset #72
      //   Java source line #685	-> byte code offset #76
      //   Java source line #688	-> byte code offset #92
      //   Java source line #689	-> byte code offset #100
      //   Java source line #693	-> byte code offset #101
      //   Java source line #694	-> byte code offset #106
      //   Java source line #696	-> byte code offset #115
      //   Java source line #705	-> byte code offset #120
      //   Java source line #710	-> byte code offset #143
      //   Java source line #712	-> byte code offset #157
      //   Java source line #713	-> byte code offset #170
      //   Java source line #715	-> byte code offset #178
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	179	0	this	LockGraphNode
      //   0	179	1	policy	CycleDetectingLockFactory.Policy
      //   0	179	2	acquiredLock	LockGraphNode
      //   72	107	3	previousDeadlockException	CycleDetectingLockFactory.PotentialDeadlockException
      //   92	9	4	exception	CycleDetectingLockFactory.PotentialDeadlockException
      //   106	73	4	seen	Set<LockGraphNode>
      //   115	64	5	path	CycleDetectingLockFactory.ExampleStackTrace
      //   157	21	6	exception	CycleDetectingLockFactory.PotentialDeadlockException
    }
    
    @Nullable
    private CycleDetectingLockFactory.ExampleStackTrace findPathTo(LockGraphNode node, Set<LockGraphNode> seen)
    {
      if (!seen.add(this)) {
        return null;
      }
      CycleDetectingLockFactory.ExampleStackTrace found = (CycleDetectingLockFactory.ExampleStackTrace)allowedPriorLocks.get(node);
      if (found != null) {
        return found;
      }
      for (Map.Entry<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> entry : allowedPriorLocks.entrySet())
      {
        LockGraphNode preAcquiredLock = (LockGraphNode)entry.getKey();
        found = preAcquiredLock.findPathTo(node, seen);
        if (found != null)
        {
          CycleDetectingLockFactory.ExampleStackTrace path = new CycleDetectingLockFactory.ExampleStackTrace(preAcquiredLock, this);
          
          path.setStackTrace(((CycleDetectingLockFactory.ExampleStackTrace)entry.getValue()).getStackTrace());
          path.initCause(found);
          return path;
        }
      }
      return null;
    }
  }
  
  private void aboutToAcquire(CycleDetectingLock lock)
  {
    if (!lock.isAcquiredByCurrentThread())
    {
      ArrayList<LockGraphNode> acquiredLockList = (ArrayList)acquiredLocks.get();
      LockGraphNode node = lock.getLockGraphNode();
      node.checkAcquiredLocks(policy, acquiredLockList);
      acquiredLockList.add(node);
    }
  }
  
  private void lockStateChanged(CycleDetectingLock lock)
  {
    if (!lock.isAcquiredByCurrentThread())
    {
      ArrayList<LockGraphNode> acquiredLockList = (ArrayList)acquiredLocks.get();
      LockGraphNode node = lock.getLockGraphNode();
      for (int i = acquiredLockList.size() - 1; i >= 0; i--) {
        if (acquiredLockList.get(i) == node)
        {
          acquiredLockList.remove(i);
          break;
        }
      }
    }
  }
  
  final class CycleDetectingReentrantLock
    extends ReentrantLock
    implements CycleDetectingLockFactory.CycleDetectingLock
  {
    private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
    
    private CycleDetectingReentrantLock(CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean fair)
    {
      super();
      this.lockGraphNode = ((CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(lockGraphNode));
    }
    
    public CycleDetectingLockFactory.LockGraphNode getLockGraphNode()
    {
      return lockGraphNode;
    }
    
    public boolean isAcquiredByCurrentThread()
    {
      return isHeldByCurrentThread();
    }
    
    public void lock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try
      {
        super.lock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(this);
      }
    }
    
    public void lockInterruptibly()
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try
      {
        super.lockInterruptibly();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(this);
      }
    }
    
    public boolean tryLock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try
      {
        return super.tryLock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(this);
      }
    }
    
    public boolean tryLock(long timeout, TimeUnit unit)
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try
      {
        return super.tryLock(timeout, unit);
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(this);
      }
    }
    
    public void unlock()
    {
      try
      {
        super.unlock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(this);
      }
    }
  }
  
  final class CycleDetectingReentrantReadWriteLock
    extends ReentrantReadWriteLock
    implements CycleDetectingLockFactory.CycleDetectingLock
  {
    private final CycleDetectingLockFactory.CycleDetectingReentrantReadLock readLock;
    private final CycleDetectingLockFactory.CycleDetectingReentrantWriteLock writeLock;
    private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
    
    private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory.LockGraphNode lockGraphNode, boolean fair)
    {
      super();
      readLock = new CycleDetectingLockFactory.CycleDetectingReentrantReadLock(CycleDetectingLockFactory.this, this);
      writeLock = new CycleDetectingLockFactory.CycleDetectingReentrantWriteLock(CycleDetectingLockFactory.this, this);
      this.lockGraphNode = ((CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(lockGraphNode));
    }
    
    public ReentrantReadWriteLock.ReadLock readLock()
    {
      return readLock;
    }
    
    public ReentrantReadWriteLock.WriteLock writeLock()
    {
      return writeLock;
    }
    
    public CycleDetectingLockFactory.LockGraphNode getLockGraphNode()
    {
      return lockGraphNode;
    }
    
    public boolean isAcquiredByCurrentThread()
    {
      return (isWriteLockedByCurrentThread()) || (getReadHoldCount() > 0);
    }
  }
  
  private class CycleDetectingReentrantReadLock
    extends ReentrantReadWriteLock.ReadLock
  {
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;
    
    CycleDetectingReentrantReadLock(CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock)
    {
      super();
      this.readWriteLock = readWriteLock;
    }
    
    public void lock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        super.lock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public void lockInterruptibly()
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        super.lockInterruptibly();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public boolean tryLock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        return super.tryLock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public boolean tryLock(long timeout, TimeUnit unit)
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        return super.tryLock(timeout, unit);
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public void unlock()
    {
      try
      {
        super.unlock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
  }
  
  private class CycleDetectingReentrantWriteLock
    extends ReentrantReadWriteLock.WriteLock
  {
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;
    
    CycleDetectingReentrantWriteLock(CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock)
    {
      super();
      this.readWriteLock = readWriteLock;
    }
    
    public void lock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        super.lock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public void lockInterruptibly()
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        super.lockInterruptibly();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public boolean tryLock()
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        return super.tryLock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public boolean tryLock(long timeout, TimeUnit unit)
      throws InterruptedException
    {
      CycleDetectingLockFactory.this.aboutToAcquire(readWriteLock);
      try
      {
        return super.tryLock(timeout, unit);
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
    
    public void unlock()
    {
      try
      {
        super.unlock();
      }
      finally
      {
        CycleDetectingLockFactory.this.lockStateChanged(readWriteLock);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */