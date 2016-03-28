package com.example.serialize;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wanghui on 2016/3/28.
 * 谨慎的实现Serializable接口
 * 最好的约束关系在所有的约束关系都已经建立的情况下再创建对象。
 * 受保护的无参构造器和一个初始化方法
 * 利用campareAndSet方法来操作枚举的原子引用，是一个很好的线程安全状态机
 */
public abstract class AbstractFoo {
    private int x;
    private int y;
    private enum State{NEW, INITIALIZING, INITIALIZED}
    private final AtomicReference<State> init = new AtomicReference<>(State.NEW);  //原子引用

    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }

    protected AbstractFoo() {
    }

    protected final void initialize(int x, int y){
        if (!init.compareAndSet(State.NEW, State.INITIALIZED)){
            throw new IllegalArgumentException("Already initialized");
        }

        this.x = x;
        this.y = y;

        init.set(State.INITIALIZED);
    }

    protected final int getX(){
        checkInit();
        return x;
    }

    protected final int getY(){
        checkInit();
        return y;
    }

    private void checkInit(){
        if (init.get() != State.INITIALIZED){
            throw new IllegalArgumentException("Uninitialized");
        }
    }
}
