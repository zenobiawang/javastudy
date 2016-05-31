package com.example.concurrency;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wanghui on 2016/5/31.
 */
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> mEs;

    public ForwardingSet(Set<E> es) {
        mEs = es;
    }

    @Override
    public int size() {
        return mEs.size();
    }

    @Override
    public boolean isEmpty() {
        return mEs.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mEs.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return mEs.iterator();
    }

    @Override
    public Object[] toArray() {
        return mEs.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return mEs.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return mEs.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return mEs.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return mEs.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return mEs.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return mEs.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return mEs.retainAll(c);
    }

    @Override
    public void clear() {
        mEs.clear();
    }
}
