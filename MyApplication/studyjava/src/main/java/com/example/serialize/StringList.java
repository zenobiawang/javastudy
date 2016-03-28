package com.example.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by wanghui on 2016/3/28.
 * 考虑使用自定义的序列化形式
 * 先包含链表中字符串的数目，然后紧跟着这些字符串即是合理的序列化形式
 * transient修饰符表明这个实例域将从一个类的默认序列化形式中省略掉
 */
public final class StringList implements Serializable{
    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s){

    }
    private void writeObject(ObjectOutputStream s)throws IOException{
        s.defaultWriteObject();
        s.writeInt(size);
        for (Entry e = head; e != null; e = e.next){
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s)throws IOException, ClassNotFoundException{
        s.defaultReadObject();
        int num = s.readInt();
        for (int i = 0; i < num; i ++){
            add((String) s.readObject());
        }
    }
}
