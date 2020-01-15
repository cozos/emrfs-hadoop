package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public final class BytesToNameCanonicalizer
{
  private static final int DEFAULT_T_SIZE = 64;
  private static final int MAX_T_SIZE = 65536;
  static final int MAX_ENTRIES_FOR_REUSE = 6000;
  private static final int MAX_COLL_CHAIN_LENGTH = 200;
  static final int MIN_HASH_SIZE = 16;
  static final int INITIAL_COLLISION_LEN = 32;
  static final int LAST_VALID_BUCKET = 254;
  protected final BytesToNameCanonicalizer _parent;
  protected final AtomicReference<TableInfo> _tableInfo;
  private final int _seed;
  protected boolean _intern;
  protected final boolean _failOnDoS;
  protected int _count;
  protected int _longestCollisionList;
  protected int _hashMask;
  protected int[] _hash;
  protected Name[] _mainNames;
  protected Bucket[] _collList;
  protected int _collCount;
  protected int _collEnd;
  private transient boolean _needRehash;
  private boolean _hashShared;
  private boolean _namesShared;
  private boolean _collListShared;
  protected BitSet _overflows;
  private static final int MULT = 33;
  private static final int MULT2 = 65599;
  private static final int MULT3 = 31;
  
  private BytesToNameCanonicalizer(int sz, boolean intern, int seed, boolean failOnDoS)
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
    _tableInfo = new AtomicReference(initTableInfo(sz));
  }
  
  private BytesToNameCanonicalizer(BytesToNameCanonicalizer parent, boolean intern, int seed, boolean failOnDoS, TableInfo state)
  {
    _parent = parent;
    _seed = seed;
    _intern = intern;
    _failOnDoS = failOnDoS;
    _tableInfo = null;
    
    _count = count;
    _hashMask = mainHashMask;
    _hash = mainHash;
    _mainNames = mainNames;
    _collList = collList;
    _collCount = collCount;
    _collEnd = collEnd;
    _longestCollisionList = longestCollisionList;
    
    _needRehash = false;
    _hashShared = true;
    _namesShared = true;
    _collListShared = true;
  }
  
  private TableInfo initTableInfo(int sz)
  {
    return new TableInfo(0, sz - 1, new int[sz], new Name[sz], null, 0, 0, 0);
  }
  
  public static BytesToNameCanonicalizer createRoot()
  {
    long now = System.currentTimeMillis();
    
    int seed = (int)now + (int)(now >>> 32) | 0x1;
    return createRoot(seed);
  }
  
  protected static BytesToNameCanonicalizer createRoot(int seed)
  {
    return new BytesToNameCanonicalizer(64, true, seed, true);
  }
  
  public BytesToNameCanonicalizer makeChild(int flags)
  {
    return new BytesToNameCanonicalizer(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(flags), _seed, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(flags), (TableInfo)_tableInfo.get());
  }
  
  @Deprecated
  public BytesToNameCanonicalizer makeChild(boolean canonicalize, boolean intern)
  {
    return new BytesToNameCanonicalizer(this, intern, _seed, true, (TableInfo)_tableInfo.get());
  }
  
  public void release()
  {
    if ((_parent != null) && (maybeDirty()))
    {
      _parent.mergeChild(new TableInfo(this));
      
      _hashShared = true;
      _namesShared = true;
      _collListShared = true;
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
      childState = initTableInfo(64);
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
    return _hash.length;
  }
  
  public boolean maybeDirty()
  {
    return !_hashShared;
  }
  
  public int hashSeed()
  {
    return _seed;
  }
  
  public int collisionCount()
  {
    return _collCount;
  }
  
  public int maxCollisionLength()
  {
    return _longestCollisionList;
  }
  
  public static Name getEmptyName()
  {
    return Name1.getEmptyName();
  }
  
  public Name findName(int q1)
  {
    int hash = calcHash(q1);
    int ix = hash & _hashMask;
    int val = _hash[ix];
    if ((val >> 8 ^ hash) << 8 == 0)
    {
      Name name = _mainNames[ix];
      if (name == null) {
        return null;
      }
      if (name.equals(q1)) {
        return name;
      }
    }
    else if (val == 0)
    {
      return null;
    }
    val &= 0xFF;
    if (val > 0)
    {
      val--;
      Bucket bucket = _collList[val];
      if (bucket != null) {
        return bucket.find(hash, q1, 0);
      }
    }
    return null;
  }
  
  public Name findName(int q1, int q2)
  {
    int hash = q2 == 0 ? calcHash(q1) : calcHash(q1, q2);
    int ix = hash & _hashMask;
    int val = _hash[ix];
    if ((val >> 8 ^ hash) << 8 == 0)
    {
      Name name = _mainNames[ix];
      if (name == null) {
        return null;
      }
      if (name.equals(q1, q2)) {
        return name;
      }
    }
    else if (val == 0)
    {
      return null;
    }
    val &= 0xFF;
    if (val > 0)
    {
      val--;
      Bucket bucket = _collList[val];
      if (bucket != null) {
        return bucket.find(hash, q1, q2);
      }
    }
    return null;
  }
  
  public Name findName(int q1, int q2, int q3)
  {
    int hash = calcHash(q1, q2, q3);
    int ix = hash & _hashMask;
    int val = _hash[ix];
    if ((val >> 8 ^ hash) << 8 == 0)
    {
      Name name = _mainNames[ix];
      if (name == null) {
        return null;
      }
      if (name.equals(q1, q2, q3)) {
        return name;
      }
    }
    else if (val == 0)
    {
      return null;
    }
    val &= 0xFF;
    if (val > 0)
    {
      val--;
      Bucket bucket = _collList[val];
      if (bucket != null) {
        return bucket.find(hash, q1, q2, q3);
      }
    }
    return null;
  }
  
  public Name findName(int[] q, int qlen)
  {
    if (qlen < 4)
    {
      if (qlen == 3) {
        return findName(q[0], q[1], q[2]);
      }
      return findName(q[0], qlen < 2 ? 0 : q[1]);
    }
    int hash = calcHash(q, qlen);
    
    int ix = hash & _hashMask;
    int val = _hash[ix];
    if ((val >> 8 ^ hash) << 8 == 0)
    {
      Name name = _mainNames[ix];
      if ((name == null) || (name.equals(q, qlen))) {
        return name;
      }
    }
    else if (val == 0)
    {
      return null;
    }
    val &= 0xFF;
    if (val > 0)
    {
      val--;
      Bucket bucket = _collList[val];
      if (bucket != null) {
        return bucket.find(hash, q, qlen);
      }
    }
    return null;
  }
  
  public Name addName(String name, int q1, int q2)
  {
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int hash = q2 == 0 ? calcHash(q1) : calcHash(q1, q2);
    Name symbol = constructName(hash, name, q1, q2);
    _addSymbol(hash, symbol);
    return symbol;
  }
  
  public Name addName(String name, int[] q, int qlen)
  {
    if (_intern) {
      name = InternCache.instance.intern(name);
    }
    int hash;
    int hash;
    if (qlen < 4)
    {
      int hash;
      if (qlen == 1)
      {
        hash = calcHash(q[0]);
      }
      else
      {
        int hash;
        if (qlen == 2) {
          hash = calcHash(q[0], q[1]);
        } else {
          hash = calcHash(q[0], q[1], q[2]);
        }
      }
    }
    else
    {
      hash = calcHash(q, qlen);
    }
    Name symbol = constructName(hash, name, q, qlen);
    _addSymbol(hash, symbol);
    return symbol;
  }
  
  public int calcHash(int q1)
  {
    int hash = q1 ^ _seed;
    hash += (hash >>> 15);
    hash ^= hash >>> 9;
    return hash;
  }
  
  public int calcHash(int q1, int q2)
  {
    int hash = q1;
    hash ^= hash >>> 15;
    hash += q2 * 33;
    hash ^= _seed;
    hash += (hash >>> 7);
    
    hash ^= hash >>> 4;
    return hash;
  }
  
  public int calcHash(int q1, int q2, int q3)
  {
    int hash = q1 ^ _seed;
    hash += (hash >>> 9);
    hash *= 33;
    hash += q2;
    hash *= 65599;
    hash += (hash >>> 15);
    hash ^= q3;
    hash += (hash >>> 17);
    
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
    hash *= 33;
    hash += q[1];
    hash *= 65599;
    hash += (hash >>> 15);
    hash ^= q[2];
    hash += (hash >>> 17);
    for (int i = 3; i < qlen; i++)
    {
      hash = hash * 31 ^ q[i];
      
      hash += (hash >>> 3);
      hash ^= hash << 7;
    }
    hash += (hash >>> 15);
    hash ^= hash << 9;
    return hash;
  }
  
  protected static int[] calcQuads(byte[] wordBytes)
  {
    int blen = wordBytes.length;
    int[] result = new int[(blen + 3) / 4];
    for (int i = 0; i < blen; i++)
    {
      int x = wordBytes[i] & 0xFF;
      
      i++;
      if (i < blen)
      {
        x = x << 8 | wordBytes[i] & 0xFF;
        i++;
        if (i < blen)
        {
          x = x << 8 | wordBytes[i] & 0xFF;
          i++;
          if (i < blen) {
            x = x << 8 | wordBytes[i] & 0xFF;
          }
        }
      }
      result[(i >> 2)] = x;
    }
    return result;
  }
  
  private void _addSymbol(int hash, Name symbol)
  {
    if (_hashShared) {
      unshareMain();
    }
    if (_needRehash) {
      rehash();
    }
    _count += 1;
    
    int ix = hash & _hashMask;
    if (_mainNames[ix] == null)
    {
      _hash[ix] = (hash << 8);
      if (_namesShared) {
        unshareNames();
      }
      _mainNames[ix] = symbol;
    }
    else
    {
      if (_collListShared) {
        unshareCollision();
      }
      _collCount += 1;
      int entryValue = _hash[ix];
      int bucket = entryValue & 0xFF;
      if (bucket == 0)
      {
        if (_collEnd <= 254)
        {
          bucket = _collEnd;
          _collEnd += 1;
          if (bucket >= _collList.length) {
            expandCollision();
          }
        }
        else
        {
          bucket = findBestBucket();
        }
        _hash[ix] = (entryValue & 0xFF00 | bucket + 1);
      }
      else
      {
        bucket--;
      }
      Bucket newB = new Bucket(symbol, _collList[bucket]);
      int collLen = length;
      if (collLen > 200)
      {
        _handleSpillOverflow(bucket, newB);
      }
      else
      {
        _collList[bucket] = newB;
        
        _longestCollisionList = Math.max(length, _longestCollisionList);
      }
    }
    int hashSize = _hash.length;
    if (_count > hashSize >> 1)
    {
      int hashQuarter = hashSize >> 2;
      if (_count > hashSize - hashQuarter) {
        _needRehash = true;
      } else if (_collCount >= hashQuarter) {
        _needRehash = true;
      }
    }
  }
  
  private void _handleSpillOverflow(int bindex, Bucket newBucket)
  {
    if (_overflows == null)
    {
      _overflows = new BitSet();
      _overflows.set(bindex);
    }
    else if (_overflows.get(bindex))
    {
      if (_failOnDoS) {
        reportTooManyCollisions(200);
      }
      _intern = false;
    }
    else
    {
      _overflows.set(bindex);
    }
    _collList[bindex] = null;
    _count -= length;
    
    _longestCollisionList = -1;
  }
  
  private void rehash()
  {
    _needRehash = false;
    
    _namesShared = false;
    
    int[] oldMainHash = _hash;
    int len = oldMainHash.length;
    int newLen = len + len;
    if (newLen > 65536)
    {
      nukeSymbols();
      return;
    }
    _hash = new int[newLen];
    _hashMask = (newLen - 1);
    Name[] oldNames = _mainNames;
    _mainNames = new Name[newLen];
    int symbolsSeen = 0;
    for (int i = 0; i < len; i++)
    {
      Name symbol = oldNames[i];
      if (symbol != null)
      {
        symbolsSeen++;
        int hash = symbol.hashCode();
        int ix = hash & _hashMask;
        _mainNames[ix] = symbol;
        _hash[ix] = (hash << 8);
      }
    }
    int oldEnd = _collEnd;
    if (oldEnd == 0)
    {
      _longestCollisionList = 0;
      return;
    }
    _collCount = 0;
    _collEnd = 0;
    _collListShared = false;
    
    int maxColl = 0;
    
    Bucket[] oldBuckets = _collList;
    _collList = new Bucket[oldBuckets.length];
    for (int i = 0; i < oldEnd; i++) {
      for (Bucket curr = oldBuckets[i]; curr != null; curr = next)
      {
        symbolsSeen++;
        Name symbol = name;
        int hash = symbol.hashCode();
        int ix = hash & _hashMask;
        int val = _hash[ix];
        if (_mainNames[ix] == null)
        {
          _hash[ix] = (hash << 8);
          _mainNames[ix] = symbol;
        }
        else
        {
          _collCount += 1;
          int bucket = val & 0xFF;
          if (bucket == 0)
          {
            if (_collEnd <= 254)
            {
              bucket = _collEnd;
              _collEnd += 1;
              if (bucket >= _collList.length) {
                expandCollision();
              }
            }
            else
            {
              bucket = findBestBucket();
            }
            _hash[ix] = (val & 0xFF00 | bucket + 1);
          }
          else
          {
            bucket--;
          }
          Bucket newB = new Bucket(symbol, _collList[bucket]);
          _collList[bucket] = newB;
          maxColl = Math.max(maxColl, length);
        }
      }
    }
    _longestCollisionList = maxColl;
    if (symbolsSeen != _count) {
      throw new RuntimeException("Internal error: count after rehash " + symbolsSeen + "; should be " + _count);
    }
  }
  
  private void nukeSymbols()
  {
    _count = 0;
    _longestCollisionList = 0;
    Arrays.fill(_hash, 0);
    Arrays.fill(_mainNames, null);
    Arrays.fill(_collList, null);
    _collCount = 0;
    _collEnd = 0;
  }
  
  private int findBestBucket()
  {
    Bucket[] buckets = _collList;
    int bestCount = Integer.MAX_VALUE;
    int bestIx = -1;
    
    int i = 0;
    for (int len = _collEnd; i < len; i++)
    {
      Bucket b = buckets[i];
      if (b == null) {
        return i;
      }
      int count = length;
      if (count < bestCount)
      {
        if (count == 1) {
          return i;
        }
        bestCount = count;
        bestIx = i;
      }
    }
    return bestIx;
  }
  
  private void unshareMain()
  {
    int[] old = _hash;
    _hash = Arrays.copyOf(old, old.length);
    _hashShared = false;
  }
  
  private void unshareCollision()
  {
    Bucket[] old = _collList;
    if (old == null) {
      _collList = new Bucket[32];
    } else {
      _collList = ((Bucket[])Arrays.copyOf(old, old.length));
    }
    _collListShared = false;
  }
  
  private void unshareNames()
  {
    Name[] old = _mainNames;
    _mainNames = ((Name[])Arrays.copyOf(old, old.length));
    _namesShared = false;
  }
  
  private void expandCollision()
  {
    Bucket[] old = _collList;
    _collList = ((Bucket[])Arrays.copyOf(old, old.length * 2));
  }
  
  private static Name constructName(int hash, String name, int q1, int q2)
  {
    if (q2 == 0) {
      return new Name1(name, hash, q1);
    }
    return new Name2(name, hash, q1, q2);
  }
  
  private static Name constructName(int hash, String name, int[] quads, int qlen)
  {
    if (qlen < 4)
    {
      switch (qlen)
      {
      case 1: 
        return new Name1(name, hash, quads[0]);
      case 2: 
        return new Name2(name, hash, quads[0], quads[1]);
      }
      return new Name3(name, hash, quads[0], quads[1], quads[2]);
    }
    return NameN.construct(name, hash, quads, qlen);
  }
  
  protected void reportTooManyCollisions(int maxLen)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + _count + ") now exceeds maximum, " + maxLen + " -- suspect a DoS attack based on hash collisions");
  }
  
  private static final class TableInfo
  {
    public final int count;
    public final int mainHashMask;
    public final int[] mainHash;
    public final Name[] mainNames;
    public final BytesToNameCanonicalizer.Bucket[] collList;
    public final int collCount;
    public final int collEnd;
    public final int longestCollisionList;
    
    public TableInfo(int count, int mainHashMask, int[] mainHash, Name[] mainNames, BytesToNameCanonicalizer.Bucket[] collList, int collCount, int collEnd, int longestCollisionList)
    {
      this.count = count;
      this.mainHashMask = mainHashMask;
      this.mainHash = mainHash;
      this.mainNames = mainNames;
      this.collList = collList;
      this.collCount = collCount;
      this.collEnd = collEnd;
      this.longestCollisionList = longestCollisionList;
    }
    
    public TableInfo(BytesToNameCanonicalizer src)
    {
      count = _count;
      mainHashMask = _hashMask;
      mainHash = _hash;
      mainNames = _mainNames;
      collList = _collList;
      collCount = _collCount;
      collEnd = _collEnd;
      longestCollisionList = _longestCollisionList;
    }
  }
  
  private static final class Bucket
  {
    public final Name name;
    public final Bucket next;
    public final int hash;
    public final int length;
    
    Bucket(Name name, Bucket next)
    {
      this.name = name;
      this.next = next;
      length = (next == null ? 1 : length + 1);
      hash = name.hashCode();
    }
    
    public Name find(int h, int firstQuad, int secondQuad)
    {
      if ((hash == h) && 
        (name.equals(firstQuad, secondQuad))) {
        return name;
      }
      for (Bucket curr = next; curr != null; curr = next) {
        if (hash == h)
        {
          Name currName = name;
          if (currName.equals(firstQuad, secondQuad)) {
            return currName;
          }
        }
      }
      return null;
    }
    
    public Name find(int h, int q1, int q2, int q3)
    {
      if ((hash == h) && 
        (name.equals(q1, q2, q3))) {
        return name;
      }
      for (Bucket curr = next; curr != null; curr = next) {
        if (hash == h)
        {
          Name currName = name;
          if (currName.equals(q1, q2, q3)) {
            return currName;
          }
        }
      }
      return null;
    }
    
    public Name find(int h, int[] quads, int qlen)
    {
      if ((hash == h) && 
        (name.equals(quads, qlen))) {
        return name;
      }
      for (Bucket curr = next; curr != null; curr = next) {
        if (hash == h)
        {
          Name currName = name;
          if (currName.equals(quads, qlen)) {
            return currName;
          }
        }
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */