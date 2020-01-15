package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class ByteQuadsCanonicalizer
{
  private static final int DEFAULT_T_SIZE = 64;
  private static final int MAX_T_SIZE = 65536;
  static final int MIN_HASH_SIZE = 16;
  static final int MAX_ENTRIES_FOR_REUSE = 6000;
  protected final ByteQuadsCanonicalizer _parent;
  protected final AtomicReference<TableInfo> _tableInfo;
  private final int _seed;
  protected boolean _intern;
  protected final boolean _failOnDoS;
  protected int[] _hashArea;
  protected int _hashSize;
  protected int _secondaryStart;
  protected int _tertiaryStart;
  protected int _tertiaryShift;
  protected int _count;
  protected String[] _names;
  protected int _spilloverEnd;
  protected int _longNameOffset;
  private transient boolean _needRehash;
  private boolean _hashShared;
  private static final int MULT = 33;
  private static final int MULT2 = 65599;
  private static final int MULT3 = 31;
  
  private ByteQuadsCanonicalizer(int sz, boolean intern, int seed, boolean failOnDoS)
  {
    _parent = null;
    _seed = seed;
    _intern = intern;
    _failOnDoS = failOnDoS;
    if (sz < 16)
    {
      sz = 16;
    }
    else if ((sz & sz - 1) != 0)
    {
      int curr = 16;
      while (curr < sz) {
        curr += curr;
      }
      sz = curr;
    }
    _tableInfo = new AtomicReference(TableInfo.createInitial(sz));
  }
  
  private ByteQuadsCanonicalizer(ByteQuadsCanonicalizer parent, boolean intern, int seed, boolean failOnDoS, TableInfo state)
  {
    _parent = parent;
    _seed = seed;
    _intern = intern;
    _failOnDoS = failOnDoS;
    _tableInfo = null;
    
    _count = count;
    _hashSize = size;
    _secondaryStart = (_hashSize << 2);
    _tertiaryStart = (_secondaryStart + (_secondaryStart >> 1));
    _tertiaryShift = tertiaryShift;
    
    _hashArea = mainHash;
    _names = names;
    
    _spilloverEnd = spilloverEnd;
    _longNameOffset = longNameOffset;
    
    _needRehash = false;
    _hashShared = true;
  }
  
  public static ByteQuadsCanonicalizer createRoot()
  {
    long now = System.currentTimeMillis();
    
    int seed = (int)now + (int)(now >>> 32) | 0x1;
    return createRoot(seed);
  }
  
  protected static ByteQuadsCanonicalizer createRoot(int seed)
  {
    return new ByteQuadsCanonicalizer(64, true, seed, true);
  }
  
  public ByteQuadsCanonicalizer makeChild(int flags)
  {
    return new ByteQuadsCanonicalizer(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(flags), _seed, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(flags), (TableInfo)_tableInfo.get());
  }
  
  public void release()
  {
    if ((_parent != null) && (maybeDirty()))
    {
      _parent.mergeChild(new TableInfo(this));
      
      _hashShared = true;
    }
  }
  
  private void mergeChild(TableInfo childState)
  {
    int childCount = count;
    TableInfo currState = (TableInfo)_tableInfo.get();
    if (childCount == count) {
      return;
    }
    if (childCount > 6000) {
      childState = TableInfo.createInitial(64);
    }
    _tableInfo.compareAndSet(currState, childState);
  }
  
  public int size()
  {
    if (_tableInfo != null) {
      return _tableInfo.get()).count;
    }
    return _count;
  }
  
  public int bucketCount()
  {
    return _hashSize;
  }
  
  public boolean maybeDirty()
  {
    return !_hashShared;
  }
  
  public int hashSeed()
  {
    return _seed;
  }
  
  public int primaryCount()
  {
    int count = 0;
    int offset = 3;
    for (int end = _secondaryStart; offset < end; offset += 4) {
      if (_hashArea[offset] != 0) {
        count++;
      }
    }
    return count;
  }
  
  public int secondaryCount()
  {
    int count = 0;
    int offset = _secondaryStart + 3;
    for (int end = _tertiaryStart; offset < end; offset += 4) {
      if (_hashArea[offset] != 0) {
        count++;
      }
    }
    return count;
  }
  
  public int tertiaryCount()
  {
    int count = 0;
    int offset = _tertiaryStart + 3;
    for (int end = offset + _hashSize; offset < end; offset += 4) {
      if (_hashArea[offset] != 0) {
        count++;
      }
    }
    return count;
  }
  
  public int spilloverCount()
  {
    return _spilloverEnd - _spilloverStart() >> 2;
  }
  
  public int totalCount()
  {
    int count = 0;
    int offset = 3;
    for (int end = _hashSize << 3; offset < end; offset += 4) {
      if (_hashArea[offset] != 0) {
        count++;
      }
    }
    return count;
  }
  
  public String toString()
  {
    int pri = primaryCount();
    int sec = secondaryCount();
    int tert = tertiaryCount();
    int spill = spilloverCount();
    int total = totalCount();
    return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[] { getClass().getName(), Integer.valueOf(_count), Integer.valueOf(_hashSize), Integer.valueOf(pri), Integer.valueOf(sec), Integer.valueOf(tert), Integer.valueOf(spill), Integer.valueOf(total), Integer.valueOf(pri + sec + tert + spill), Integer.valueOf(total) });
  }
  
  public String findName(int q1)
  {
    int offset = _calcOffset(calcHash(q1));
    
    int[] hashArea = _hashArea;
    
    int len = hashArea[(offset + 3)];
    if (len == 1)
    {
      if (hashArea[offset] == q1) {
        return _names[(offset >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    int offset2 = _secondaryStart + (offset >> 3 << 2);
    
    len = hashArea[(offset2 + 3)];
    if (len == 1)
    {
      if (hashArea[offset2] == q1) {
        return _names[(offset2 >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    return _findSecondary(offset, q1);
  }
  
  public String findName(int q1, int q2)
  {
    int offset = _calcOffset(calcHash(q1, q2));
    
    int[] hashArea = _hashArea;
    
    int len = hashArea[(offset + 3)];
    if (len == 2)
    {
      if ((q1 == hashArea[offset]) && (q2 == hashArea[(offset + 1)])) {
        return _names[(offset >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    int offset2 = _secondaryStart + (offset >> 3 << 2);
    
    len = hashArea[(offset2 + 3)];
    if (len == 2)
    {
      if ((q1 == hashArea[offset2]) && (q2 == hashArea[(offset2 + 1)])) {
        return _names[(offset2 >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    return _findSecondary(offset, q1, q2);
  }
  
  public String findName(int q1, int q2, int q3)
  {
    int offset = _calcOffset(calcHash(q1, q2, q3));
    int[] hashArea = _hashArea;
    int len = hashArea[(offset + 3)];
    if (len == 3)
    {
      if ((q1 == hashArea[offset]) && (hashArea[(offset + 1)] == q2) && (hashArea[(offset + 2)] == q3)) {
        return _names[(offset >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    int offset2 = _secondaryStart + (offset >> 3 << 2);
    
    len = hashArea[(offset2 + 3)];
    if (len == 3)
    {
      if ((q1 == hashArea[offset2]) && (hashArea[(offset2 + 1)] == q2) && (hashArea[(offset2 + 2)] == q3)) {
        return _names[(offset2 >> 2)];
      }
    }
    else if (len == 0) {
      return null;
    }
    return _findSecondary(offset, q1, q2, q3);
  }
  
  public String findName(int[] q, int qlen)
  {
    if (qlen < 4)
    {
      if (qlen == 3) {
        return findName(q[0], q[1], q[2]);
      }
      if (qlen == 2) {
        return findName(q[0], q[1]);
      }
      return findName(q[0]);
    }
    int hash = calcHash(q, qlen);
    int offset = _calcOffset(hash);
    
    int[] hashArea = _hashArea;
    
    int len = hashArea[(offset + 3)];
    if ((hash == hashArea[offset]) && (len == qlen)) {
      if (_verifyLongName(q, qlen, hashArea[(offset + 1)])) {
        return _names[(offset >> 2)];
      }
    }
    if (len == 0) {
      return null;
    }
    int offset2 = _secondaryStart + (offset >> 3 << 2);
    
    int len2 = hashArea[(offset2 + 3)];
    if ((hash == hashArea[offset2]) && (len2 == qlen) && 
      (_verifyLongName(q, qlen, hashArea[(offset2 + 1)]))) {
      return _names[(offset2 >> 2)];
    }
    if (len == 0) {
      return null;
    }
    return _findSecondary(offset, hash, q, qlen);
  }
  
  private final int _calcOffset(int hash)
  {
    int ix = hash & _hashSize - 1;
    
    return ix << 2;
  }
  
  private String _findSecondary(int origOffset, int q1)
  {
    int offset = _tertiaryStart + (origOffset >> _tertiaryShift + 2 << _tertiaryShift);
    int[] hashArea = _hashArea;
    int bucketSize = 1 << _tertiaryShift;
    for (int end = offset + bucketSize; offset < end; offset += 4)
    {
      int len = hashArea[(offset + 3)];
      if ((q1 == hashArea[offset]) && (1 == len)) {
        return _names[(offset >> 2)];
      }
      if (len == 0) {
        return null;
      }
    }
    for (offset = _spilloverStart(); offset < _spilloverEnd; offset += 4) {
      if ((q1 == hashArea[offset]) && (1 == hashArea[(offset + 3)])) {
        return _names[(offset >> 2)];
      }
    }
    return null;
  }
  
  private String _findSecondary(int origOffset, int q1, int q2)
  {
    int offset = _tertiaryStart + (origOffset >> _tertiaryShift + 2 << _tertiaryShift);
    int[] hashArea = _hashArea;
    
    int bucketSize = 1 << _tertiaryShift;
    for (int end = offset + bucketSize; offset < end; offset += 4)
    {
      int len = hashArea[(offset + 3)];
      if ((q1 == hashArea[offset]) && (q2 == hashArea[(offset + 1)]) && (2 == len)) {
        return _names[(offset >> 2)];
      }
      if (len == 0) {
        return null;
      }
    }
    for (offset = _spilloverStart(); offset < _spilloverEnd; offset += 4) {
      if ((q1 == hashArea[offset]) && (q2 == hashArea[(offset + 1)]) && (2 == hashArea[(offset + 3)])) {
        return _names[(offset >> 2)];
      }
    }
    return null;
  }
  
  private String _findSecondary(int origOffset, int q1, int q2, int q3)
  {
    int offset = _tertiaryStart + (origOffset >> _tertiaryShift + 2 << _tertiaryShift);
    int[] hashArea = _hashArea;
    
    int bucketSize = 1 << _tertiaryShift;
    for (int end = offset + bucketSize; offset < end; offset += 4)
    {
      int len = hashArea[(offset + 3)];
      if ((q1 == hashArea[offset]) && (q2 == hashArea[(offset + 1)]) && (q3 == hashArea[(offset + 2)]) && (3 == len)) {
        return _names[(offset >> 2)];
      }
      if (len == 0) {
        return null;
      }
    }
    for (offset = _spilloverStart(); offset < _spilloverEnd; offset += 4) {
      if ((q1 == hashArea[offset]) && (q2 == hashArea[(offset + 1)]) && (q3 == hashArea[(offset + 2)]) && (3 == hashArea[(offset + 3)])) {
        return _names[(offset >> 2)];
      }
    }
    return null;
  }
  
  private String _findSecondary(int origOffset, int hash, int[] q, int qlen)
  {
    int offset = _tertiaryStart + (origOffset >> _tertiaryShift + 2 << _tertiaryShift);
    int[] hashArea = _hashArea;
    
    int bucketSize = 1 << _tertiaryShift;
    for (int end = offset + bucketSize; offset < end; offset += 4)
    {
      int len = hashArea[(offset + 3)];
      if ((hash == hashArea[offset]) && (qlen == len) && 
        (_verifyLongName(q, qlen, hashArea[(offset + 1)]))) {
        return _names[(offset >> 2)];
      }
      if (len == 0) {
        return null;
      }
    }
    for (offset = _spilloverStart(); offset < _spilloverEnd; offset += 4) {
      if ((hash == hashArea[offset]) && (qlen == hashArea[(offset + 3)]) && 
        (_verifyLongName(q, qlen, hashArea[(offset + 1)]))) {
        return _names[(offset >> 2)];
      }
    }
    return null;
  }
  
  private boolean _verifyLongName(int[] q, int qlen, int spillOffset)
  {
    int[] hashArea = _hashArea;
    
    int ix = 0;
    switch (qlen)
    {
    default: 
      return _verifyLongName2(q, qlen, spillOffset);
    case 8: 
      if (q[(ix++)] != hashArea[(spillOffset++)]) {
        return false;
      }
    case 7: 
      if (q[(ix++)] != hashArea[(spillOffset++)]) {
        return false;
      }
    case 6: 
      if (q[(ix++)] != hashArea[(spillOffset++)]) {
        return false;
      }
    case 5: 
      if (q[(ix++)] != hashArea[(spillOffset++)]) {
        return false;
      }
      break;
    }
    if (q[(ix++)] != hashArea[(spillOffset++)]) {
      return false;
    }
    if (q[(ix++)] != hashArea[(spillOffset++)]) {
      return false;
    }
    if (q[(ix++)] != hashArea[(spillOffset++)]) {
      return false;
    }
    if (q[(ix++)] != hashArea[(spillOffset++)]) {
      return false;
    }
    return true;
  }
  
  private boolean _verifyLongName2(int[] q, int qlen, int spillOffset)
  {
    int ix = 0;
    do
    {
      if (q[(ix++)] != _hashArea[(spillOffset++)]) {
        return false;
      }
    } while (ix < qlen);
    return true;
  }
  
  public String addName(String name, int q1)
  {
    _verifySharing();
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int offset = _findOffsetForAdd(calcHash(q1));
    _hashArea[offset] = q1;
    _hashArea[(offset + 3)] = 1;
    _names[(offset >> 2)] = name;
    _count += 1;
    _verifyNeedForRehash();
    return name;
  }
  
  public String addName(String name, int q1, int q2)
  {
    _verifySharing();
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int hash = q2 == 0 ? calcHash(q1) : calcHash(q1, q2);
    int offset = _findOffsetForAdd(hash);
    _hashArea[offset] = q1;
    _hashArea[(offset + 1)] = q2;
    _hashArea[(offset + 3)] = 2;
    _names[(offset >> 2)] = name;
    _count += 1;
    _verifyNeedForRehash();
    return name;
  }
  
  public String addName(String name, int q1, int q2, int q3)
  {
    _verifySharing();
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int offset = _findOffsetForAdd(calcHash(q1, q2, q3));
    _hashArea[offset] = q1;
    _hashArea[(offset + 1)] = q2;
    _hashArea[(offset + 2)] = q3;
    _hashArea[(offset + 3)] = 3;
    _names[(offset >> 2)] = name;
    _count += 1;
    _verifyNeedForRehash();
    return name;
  }
  
  public String addName(String name, int[] q, int qlen)
  {
    _verifySharing();
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int offset;
    switch (qlen)
    {
    case 1: 
      offset = _findOffsetForAdd(calcHash(q[0]));
      _hashArea[offset] = q[0];
      _hashArea[(offset + 3)] = 1;
      
      break;
    case 2: 
      offset = _findOffsetForAdd(calcHash(q[0], q[1]));
      _hashArea[offset] = q[0];
      _hashArea[(offset + 1)] = q[1];
      _hashArea[(offset + 3)] = 2;
      
      break;
    case 3: 
      offset = _findOffsetForAdd(calcHash(q[0], q[1], q[2]));
      _hashArea[offset] = q[0];
      _hashArea[(offset + 1)] = q[1];
      _hashArea[(offset + 2)] = q[2];
      _hashArea[(offset + 3)] = 3;
      
      break;
    default: 
      int hash = calcHash(q, qlen);
      offset = _findOffsetForAdd(hash);
      
      _hashArea[offset] = hash;
      int longStart = _appendLongName(q, qlen);
      _hashArea[(offset + 1)] = longStart;
      _hashArea[(offset + 3)] = qlen;
    }
    _names[(offset >> 2)] = name;
    
    _count += 1;
    _verifyNeedForRehash();
    return name;
  }
  
  private void _verifyNeedForRehash()
  {
    if (_count > _hashSize >> 1)
    {
      int spillCount = _spilloverEnd - _spilloverStart() >> 2;
      if ((spillCount > 1 + _count >> 7) || (_count > _hashSize * 0.8D)) {
        _needRehash = true;
      }
    }
  }
  
  private void _verifySharing()
  {
    if (_hashShared)
    {
      _hashArea = Arrays.copyOf(_hashArea, _hashArea.length);
      _names = ((String[])Arrays.copyOf(_names, _names.length));
      _hashShared = false;
      
      _verifyNeedForRehash();
    }
    if (_needRehash) {
      rehash();
    }
  }
  
  private int _findOffsetForAdd(int hash)
  {
    int offset = _calcOffset(hash);
    int[] hashArea = _hashArea;
    if (hashArea[(offset + 3)] == 0) {
      return offset;
    }
    int offset2 = _secondaryStart + (offset >> 3 << 2);
    if (hashArea[(offset2 + 3)] == 0) {
      return offset2;
    }
    offset2 = _tertiaryStart + (offset >> _tertiaryShift + 2 << _tertiaryShift);
    int bucketSize = 1 << _tertiaryShift;
    for (int end = offset2 + bucketSize; offset2 < end; offset2 += 4) {
      if (hashArea[(offset2 + 3)] == 0) {
        return offset2;
      }
    }
    offset = _spilloverEnd;
    _spilloverEnd += 4;
    
    int end = _hashSize << 3;
    if (_spilloverEnd >= end)
    {
      if (_failOnDoS) {
        _reportTooManyCollisions();
      }
      _needRehash = true;
    }
    return offset;
  }
  
  private int _appendLongName(int[] quads, int qlen)
  {
    int start = _longNameOffset;
    if (start + qlen > _hashArea.length)
    {
      int toAdd = start + qlen - _hashArea.length;
      
      int minAdd = Math.min(4096, _hashSize);
      
      int newSize = _hashArea.length + Math.max(toAdd, minAdd);
      _hashArea = Arrays.copyOf(_hashArea, newSize);
    }
    System.arraycopy(quads, 0, _hashArea, start, qlen);
    _longNameOffset += qlen;
    return start;
  }
  
  public int calcHash(int q1)
  {
    int hash = q1 ^ _seed;
    
    hash += (hash >>> 16);
    hash ^= hash << 3;
    hash += (hash >>> 12);
    return hash;
  }
  
  public int calcHash(int q1, int q2)
  {
    int hash = q1;
    
    hash += (hash >>> 15);
    hash ^= hash >>> 9;
    hash += q2 * 33;
    hash ^= _seed;
    hash += (hash >>> 16);
    hash ^= hash >>> 4;
    hash += (hash << 3);
    
    return hash;
  }
  
  public int calcHash(int q1, int q2, int q3)
  {
    int hash = q1 ^ _seed;
    hash += (hash >>> 9);
    hash *= 31;
    hash += q2;
    hash *= 33;
    hash += (hash >>> 15);
    hash ^= q3;
    
    hash += (hash >>> 4);
    
    hash += (hash >>> 15);
    hash ^= hash << 9;
    
    return hash;
  }
  
  public int calcHash(int[] q, int qlen)
  {
    if (qlen < 4) {
      throw new IllegalArgumentException();
    }
    int hash = q[0] ^ _seed;
    hash += (hash >>> 9);
    hash += q[1];
    hash += (hash >>> 15);
    hash *= 33;
    hash ^= q[2];
    hash += (hash >>> 4);
    for (int i = 3; i < qlen; i++)
    {
      int next = q[i];
      next ^= next >> 21;
      hash += next;
    }
    hash *= 65599;
    
    hash += (hash >>> 19);
    hash ^= hash << 5;
    return hash;
  }
  
  private void rehash()
  {
    _needRehash = false;
    
    _hashShared = false;
    
    int[] oldHashArea = _hashArea;
    String[] oldNames = _names;
    int oldSize = _hashSize;
    int oldCount = _count;
    int newSize = oldSize + oldSize;
    int oldEnd = _spilloverEnd;
    if (newSize > 65536)
    {
      nukeSymbols(true);
      return;
    }
    _hashArea = new int[oldHashArea.length + (oldSize << 3)];
    _hashSize = newSize;
    _secondaryStart = (newSize << 2);
    _tertiaryStart = (_secondaryStart + (_secondaryStart >> 1));
    _tertiaryShift = _calcTertiaryShift(newSize);
    
    _names = new String[oldNames.length << 1];
    nukeSymbols(false);
    
    int copyCount = 0;
    int[] q = new int[16];
    int offset = 0;
    for (int end = oldEnd; offset < end; offset += 4)
    {
      int len = oldHashArea[(offset + 3)];
      if (len != 0)
      {
        copyCount++;
        String name = oldNames[(offset >> 2)];
        switch (len)
        {
        case 1: 
          q[0] = oldHashArea[offset];
          addName(name, q, 1);
          break;
        case 2: 
          q[0] = oldHashArea[offset];
          q[1] = oldHashArea[(offset + 1)];
          addName(name, q, 2);
          break;
        case 3: 
          q[0] = oldHashArea[offset];
          q[1] = oldHashArea[(offset + 1)];
          q[2] = oldHashArea[(offset + 2)];
          addName(name, q, 3);
          break;
        default: 
          if (len > q.length) {
            q = new int[len];
          }
          int qoff = oldHashArea[(offset + 1)];
          System.arraycopy(oldHashArea, qoff, q, 0, len);
          addName(name, q, len);
        }
      }
    }
    if (copyCount != oldCount) {
      throw new IllegalStateException("Failed rehash(): old count=" + oldCount + ", copyCount=" + copyCount);
    }
  }
  
  private void nukeSymbols(boolean fill)
  {
    _count = 0;
    
    _spilloverEnd = _spilloverStart();
    
    _longNameOffset = (_hashSize << 3);
    if (fill)
    {
      Arrays.fill(_hashArea, 0);
      Arrays.fill(_names, null);
    }
  }
  
  private final int _spilloverStart()
  {
    int offset = _hashSize;
    return (offset << 3) - offset;
  }
  
  protected void _reportTooManyCollisions()
  {
    if (_hashSize <= 1024) {
      return;
    }
    throw new IllegalStateException("Spill-over slots in symbol table with " + _count + " entries, hash area of " + _hashSize + " slots is now full (all " + (_hashSize >> 3) + " slots -- suspect a DoS attack based on hash collisions." + " You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
  }
  
  static int _calcTertiaryShift(int primarySlots)
  {
    int tertSlots = primarySlots >> 2;
    if (tertSlots < 64) {
      return 4;
    }
    if (tertSlots <= 256) {
      return 5;
    }
    if (tertSlots <= 1024) {
      return 6;
    }
    return 7;
  }
  
  private static final class TableInfo
  {
    public final int size;
    public final int count;
    public final int tertiaryShift;
    public final int[] mainHash;
    public final String[] names;
    public final int spilloverEnd;
    public final int longNameOffset;
    
    public TableInfo(int size, int count, int tertiaryShift, int[] mainHash, String[] names, int spilloverEnd, int longNameOffset)
    {
      this.size = size;
      this.count = count;
      this.tertiaryShift = tertiaryShift;
      this.mainHash = mainHash;
      this.names = names;
      this.spilloverEnd = spilloverEnd;
      this.longNameOffset = longNameOffset;
    }
    
    public TableInfo(ByteQuadsCanonicalizer src)
    {
      size = _hashSize;
      count = _count;
      tertiaryShift = _tertiaryShift;
      mainHash = _hashArea;
      names = _names;
      spilloverEnd = _spilloverEnd;
      longNameOffset = _longNameOffset;
    }
    
    public static TableInfo createInitial(int sz)
    {
      int hashAreaSize = sz << 3;
      int tertShift = ByteQuadsCanonicalizer._calcTertiaryShift(sz);
      
      return new TableInfo(sz, 0, tertShift, new int[hashAreaSize], new String[sz << 1], hashAreaSize - sz, hashAreaSize);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */