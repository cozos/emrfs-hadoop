package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.AbstractModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultBindingScopingVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Elements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class Modules$RealOverriddenModuleBuilder
  implements Modules.OverriddenModuleBuilder
{
  private final .ImmutableSet<Module> baseModules;
  
  private Modules$RealOverriddenModuleBuilder(Iterable<? extends Module> baseModules)
  {
    this.baseModules = .ImmutableSet.copyOf(baseModules);
  }
  
  public Module with(Module... overrides)
  {
    return with(Arrays.asList(overrides));
  }
  
  public Module with(final Iterable<? extends Module> overrides)
  {
    new AbstractModule()
    {
      public void configure()
      {
        Binder baseBinder = binder();
        List<Element> baseElements = Elements.getElements(baseModules);
        if (baseElements.size() == 1)
        {
          Element element = (Element).Iterables.getOnlyElement(baseElements);
          if ((element instanceof PrivateElements))
          {
            PrivateElements privateElements = (PrivateElements)element;
            PrivateBinder privateBinder = baseBinder.newPrivateBinder().withSource(privateElements.getSource());
            for (Key exposed : privateElements.getExposedKeys()) {
              privateBinder.withSource(privateElements.getExposedSource(exposed)).expose(exposed);
            }
            baseBinder = privateBinder;
            baseElements = privateElements.getElements();
          }
        }
        Binder binder = baseBinder;
        LinkedHashSet<Element> elements = new LinkedHashSet(baseElements);
        List<Element> overrideElements = Elements.getElements(overrides);
        
        final Set<Key<?>> overriddenKeys = .Sets.newHashSet();
        final Set<Class<? extends Annotation>> overridesScopeAnnotations = .Sets.newHashSet();
        
        new Modules.ModuleWriter(binder)
        {
          public <T> Void visit(Binding<T> binding)
          {
            overriddenKeys.add(binding.getKey());
            return (Void)super.visit(binding);
          }
          
          public Void visit(ScopeBinding scopeBinding)
          {
            overridesScopeAnnotations.add(scopeBinding.getAnnotationType());
            return (Void)super.visit(scopeBinding);
          }
          
          public Void visit(PrivateElements privateElements)
          {
            overriddenKeys.addAll(privateElements.getExposedKeys());
            return (Void)super.visit(privateElements);
          }
        }.writeAll(overrideElements);
        
        final Map<Scope, Object> scopeInstancesInUse = .Maps.newHashMap();
        final List<ScopeBinding> scopeBindings = .Lists.newArrayList();
        new Modules.ModuleWriter(binder)
        {
          public <T> Void visit(Binding<T> binding)
          {
            if (!overriddenKeys.remove(binding.getKey()))
            {
              super.visit(binding);
              
              Scope scope = Modules.RealOverriddenModuleBuilder.1.this.getScopeInstanceOrNull(binding);
              if (scope != null) {
                scopeInstancesInUse.put(scope, binding.getSource());
              }
            }
            return null;
          }
          
          void rewrite(Binder binder, PrivateElements privateElements, Set<Key<?>> keysToSkip)
          {
            PrivateBinder privateBinder = binder.withSource(privateElements.getSource()).newPrivateBinder();
            
            Set<Key<?>> skippedExposes = .Sets.newHashSet();
            for (Key<?> key : privateElements.getExposedKeys()) {
              if (keysToSkip.remove(key)) {
                skippedExposes.add(key);
              } else {
                privateBinder.withSource(privateElements.getExposedSource(key)).expose(key);
              }
            }
            for (Element element : privateElements.getElements()) {
              if ((!(element instanceof Binding)) || (!skippedExposes.remove(((Binding)element).getKey()))) {
                if ((element instanceof PrivateElements)) {
                  rewrite(privateBinder, (PrivateElements)element, skippedExposes);
                } else {
                  element.applyTo(privateBinder);
                }
              }
            }
          }
          
          public Void visit(PrivateElements privateElements)
          {
            rewrite(binder, privateElements, overriddenKeys);
            return null;
          }
          
          public Void visit(ScopeBinding scopeBinding)
          {
            scopeBindings.add(scopeBinding);
            return null;
          }
        }.writeAll(elements);
        
        new Modules.ModuleWriter(binder)
        {
          public Void visit(ScopeBinding scopeBinding)
          {
            if (!overridesScopeAnnotations.remove(scopeBinding.getAnnotationType()))
            {
              super.visit(scopeBinding);
            }
            else
            {
              Object source = scopeInstancesInUse.get(scopeBinding.getScope());
              if (source != null) {
                binder.withSource(source).addError("The scope for @%s is bound directly and cannot be overridden.", new Object[] { scopeBinding.getAnnotationType().getSimpleName() });
              }
            }
            return null;
          }
        }.writeAll(scopeBindings);
      }
      
      private Scope getScopeInstanceOrNull(Binding<?> binding)
      {
        (Scope)binding.acceptScopingVisitor(new DefaultBindingScopingVisitor()
        {
          public Scope visitScope(Scope scope)
          {
            return scope;
          }
        });
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.RealOverriddenModuleBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */