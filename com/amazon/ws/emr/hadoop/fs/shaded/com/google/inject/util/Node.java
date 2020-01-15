package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import java.lang.annotation.Annotation;
import java.util.Set;

class Node
{
  private final Key<?> key;
  private int appliedScope = Integer.MAX_VALUE;
  private Node effectiveScopeDependency;
  private int effectiveScope = Integer.MIN_VALUE;
  private Class<? extends Annotation> appliedScopeAnnotation;
  private Set<Node> users = .ImmutableSet.of();
  
  Node(Key<?> key)
  {
    this.key = key;
  }
  
  void setScopeRank(int rank, Class<? extends Annotation> annotation)
  {
    appliedScope = rank;
    effectiveScope = rank;
    appliedScopeAnnotation = annotation;
  }
  
  private void setEffectiveScope(int effectiveScope, Node effectiveScopeDependency)
  {
    if (this.effectiveScope >= effectiveScope) {
      return;
    }
    this.effectiveScope = effectiveScope;
    this.effectiveScopeDependency = effectiveScopeDependency;
    pushScopeToUsers();
  }
  
  void pushScopeToUsers()
  {
    for (Node user : users) {
      user.setEffectiveScope(effectiveScope, this);
    }
  }
  
  boolean isScopedCorrectly()
  {
    return appliedScope >= effectiveScope;
  }
  
  boolean isEffectiveScopeAppliedScope()
  {
    return appliedScope == effectiveScope;
  }
  
  Node effectiveScopeDependency()
  {
    return effectiveScopeDependency;
  }
  
  public void addUser(Node node)
  {
    if (users.isEmpty()) {
      users = .Sets.newHashSet();
    }
    users.add(node);
  }
  
  public String toString()
  {
    return appliedScopeAnnotation != null ? Errors.convert(key) + " in @" + appliedScopeAnnotation.getSimpleName() : Errors.convert(key).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Node
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */