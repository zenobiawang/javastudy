package com.example.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Created by wanghui on 2016/3/28.   有疑问
 * 保护性的编写readObject方法
 *
 */
public class MutablePeriod {
    public Period mPeriod;
    public Date start;
    public Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(new Period(new Date(), new Date()));

            byte[] ref = {0x71, 0, 0x71, 5};
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            mPeriod = (Period) ois.readObject();
            start = (Date) ois.readObject();
            end = (Date) ois.readObject();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        start = new Date(start.getTime());
        end = new Date(end.getTime());
    }
}
