package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class CycleDetectingLockFactory$LockGraphNode
{
  final Map<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> allowedPriorLocks = new MapMaker().weakKeys().makeMap();
  final Map<LockGraphNode, CycleDetectingLockFactory.PotentialDeadlockException> disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
  final String lockName;
  
  CycleDetectingLockFactory$LockGraphNode(String lockName)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */