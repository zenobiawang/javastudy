package com.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wanghui on 2016/5/31.
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> es) {
        super(es);
    }

    private final List<ObservableSet<E>> observes = new ArrayList<>();
}
