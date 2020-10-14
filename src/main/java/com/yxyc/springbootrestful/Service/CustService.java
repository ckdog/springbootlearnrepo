package com.yxyc.springbootrestful.Service;

import com.yxyc.springbootrestful.domain.Cust;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CustService implements Service {
    @Override
    public Object getCust() {
        List<Cust> list = new LinkedList<>();
        for (int i=0;i<4;i++) {
            Cust cust = new Cust();
            cust.setId(String.valueOf(i));
            cust.setAge(i+10);
            cust.setBirthday(new Date());
            cust.setGender(String.valueOf(i%2));
            list.add(cust);
        }

        return list;
    }
}
