package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to messenger!");

        boolean go = true;
        while(go)
        {
            System.out.println("Please enter your phone number");
            String pn = input.nextLine();
            System.out.println("Please enter your message");
            String msg = input.nextLine();
            long cTime = System.currentTimeMillis();
            Message m = new Message(pn, msg, cTime);
            messageList msgs = new messageList();

            msgs.add(m);

            System.out.println("Would you like to continue messaging? (yes or no)");
            String yn = input.nextLine();
            if(yn.equalsIgnoreCase("no"))
            {
                go = false;
            }
        }

    }
}
