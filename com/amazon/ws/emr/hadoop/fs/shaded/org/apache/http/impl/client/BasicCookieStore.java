package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieIdentityComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Contract(threading=ThreadingBehavior.SAFE)
public class BasicCookieStore
  implements CookieStore, Serializable
{
  private static final long serialVersionUID = -7581093305228232025L;
  private final TreeSet<Cookie> cookies;
  private final ReadWriteLock lock;
  
  public BasicCookieStore()
  {
    cookies = new TreeSet(new CookieIdentityComparator());
    lock = new ReentrantReadWriteLock();
  }
  
  public void addCookie(Cookie cookie)
  {
    if (cookie != null)
    {
      lock.writeLock().lock();
      try
      {
        cookies.remove(cookie);
        if (!cookie.isExpired(new Date())) {
          cookies.add(cookie);
        }
      }
      finally
      {
        lock.writeLock().unlock();
      }
    }
  }
  
  public void addCookies(Cookie[] cookies)
  {
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        addCookie(cookie);
      }
    }
  }
  
  public List<Cookie> getCookies()
  {
    lock.readLock().lock();
    try
    {
      return new ArrayList(cookies);
    }
    finally
    {
      lock.readLock().unlock();
    }
  }
  
  public boolean clearExpired(Date date)
  {
    if (date == null) {
      return false;
    }
    lock.writeLock().lock();
    try
    {
      boolean removed = false;
      for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
        if (((Cookie)it.next()).isExpired(date))
        {
          it.remove();
          removed = true;
        }
      }
      return removed;
    }
    finally
    {
      lock.writeLock().unlock();
    }
  }
  
  public void clear()
  {
    lock.writeLock().lock();
    try
    {
      cookies.clear();
    }
    finally
    {
      lock.writeLock().unlock();
    }
  }
  
  public String toString()
  {
    lock.readLock().lock();
    try
    {
      return cookies.toString();
    }
    finally
    {
      lock.readLock().unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicCookieStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */