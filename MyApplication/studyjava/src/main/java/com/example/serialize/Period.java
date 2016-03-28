package com.example.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 * Created by wanghui on 2016/3/28.
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

}
