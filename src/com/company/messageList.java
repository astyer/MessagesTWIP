package com.company;

import java.util.*;

public class messageList {

    public ArrayList a = new ArrayList();

    public void add(Message m)
    {
        a.add(0, m);
    }

    public void move(int position, messageList from, messageList to)
    {
        to.add((Message)from.a.get(position));
        from.a.remove(position);
    }

}
