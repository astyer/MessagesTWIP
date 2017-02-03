package com.company;

import java.util.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);

        boolean go = true;
        ArrayList msgLists = new ArrayList();

        System.out.println("Welcome to messenger!");
        System.out.println("Enter your phone number.");
        String ypn = input.nextLine();

        while(go)
        {
            boolean option = true;
            while(option)
            {
                System.out.println("Would you like to send a message (send), delete a message or conversation (delete), display messages (display), or move a message (move)?");
                String choice = input.nextLine();

                if(choice.equalsIgnoreCase("send"))
                {
                    option = false;
                    System.out.println("Enter the phone number you are sending your message to.");
                    String spn = input.nextLine();
                    System.out.println("Enter your message.");
                    String msg = input.nextLine();
                    System.out.println("Message sent.");
                    long cTime = System.currentTimeMillis();
                    Message m = new Message(ypn, spn, msg, cTime);
                    boolean found = false;
                    for(int j = 0; j<msgLists.size(); j++)
                    {
                        messageList d = (messageList)msgLists.get(j);
                        Message f = (Message)d.a.get(0);
                        if(spn.equals(f.snum))
                        {
                            found = true;
                            d.add(m);
                        }
                    }
                    if(!found)
                    {
                        messageList convo = new messageList();
                        msgLists.add(convo);
                        convo.add(m);
                    }
                }

                else if(choice.equalsIgnoreCase("delete"))
                {
                    if(msgLists.size() == 0)
                    {
                        System.out.println("Sorry, there are no active conversations.");
                        break;
                    }
                    option = false;
                    System.out.println("Would you like to delete an individual message (msg) or an entire conversation (convo)?");
                    String dType = input.nextLine();
                    if(dType.equalsIgnoreCase("msg"))
                    {
                        boolean notdone = true;
                        while(notdone)
                        {
                            System.out.println("Enter the number of the person whose conversation you want to delete a message from.");
                            String pern = input.nextLine();
                            messageList correct = new messageList();
                            boolean found = false;
                            for(int j = 0; j<msgLists.size(); j++)
                            {
                                messageList d = (messageList)msgLists.get(j);
                                Message f = (Message)d.a.get(0);
                                if(pern.equals(f.snum))
                                {
                                    correct = d;
                                    found = true;
                                }
                            }
                            if(found)
                            {
                                notdone = false;
                                System.out.println("Which message do you want to delete? (Enter the position number of the message with 1 being the most recent message)");
                                int pos = inputI.nextInt()-1;
                                correct.a.remove(pos);
                                System.out.println("Message deleted");
                            }
                            else
                            {
                                System.out.println("Sorry there is no conversation found with that number, try again.");
                            }
                        }
                    }
                    else
                    {
                        boolean notdone = true;
                        while(notdone)
                        {
                            System.out.println("Enter the number of the person whose conversation you want to delete.");
                            String pern = input.nextLine();
                            messageList correct = new messageList();
                            boolean found = false;
                            for(int j = 0; j<msgLists.size(); j++)
                            {
                                messageList d = (messageList)msgLists.get(j);
                                Message f = (Message)d.a.get(0);
                                if(pern.equals(f.snum))
                                {
                                    correct = d;
                                    found = true;
                                }
                            }
                            if(found)
                            {
                                notdone = false;
                                correct.a.clear();
                                System.out.println("Conversation deleted.");
                            }
                            else
                            {
                                System.out.println("Sorry there is no conversation found with that number, try again.");
                            }
                        }
                    }

                }

                else if(choice.equalsIgnoreCase("display"))
                {
                    if(msgLists.size() == 0)
                    {
                        System.out.println("Sorry, there are no active conversations.");
                        break;
                    }
                    option = false;
                    boolean notdone = true;
                    while(notdone)
                    {
                        System.out.println("Enter the number of the person whose conversation you want to see.");
                        String pern = input.nextLine();
                        messageList correct = new messageList();
                        boolean found = false;
                        for(int j = 0; j<msgLists.size(); j++)
                        {
                            messageList d = (messageList)msgLists.get(j);
                            if(d.a.size() != 0)
                            {
                                Message f = (Message)d.a.get(d.a.size()-1);
                                if(pern.equals(f.snum))
                                {
                                    correct = d;
                                    found = true;
                                }
                            }
                        }
                        if(found)
                        {
                            notdone = false;
                            for(int i = 0; i < correct.a.size(); i++)
                            {
                                Message x = (Message)correct.a.get(i);
                                Date date = new Date(x.time);
                                DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                                String time = formatter.format(date);
                                System.out.println(time + " - " + '"' + x.msg + '"');
                            }
                        }
                        else
                        {
                            System.out.println("Sorry there is no conversation found with that number, try again.");
                        }
                    }

                }

                else if(choice.equalsIgnoreCase("move"))
                {
                    if(msgLists.size() == 0)
                    {
                        System.out.println("Sorry, there are no active conversations.");
                        break;
                    }
                    option = false;
                    boolean notdone = true;
                    while(notdone)
                    {
                        System.out.println("Enter the number of the person whose conversation you want to move a message from.");
                        String from = input.nextLine();
                        System.out.println("Enter the number of the person whose conversation you want to move a message to.");
                        String to = input.nextLine();
                        messageList correctFrom = new messageList();
                        messageList correctTo = new messageList();
                        boolean found1 = false;
                        boolean found2 = false;
                        for(int j = 0; j<msgLists.size(); j++)
                        {
                            messageList d = (messageList)msgLists.get(j);
                            Message f = (Message)d.a.get(0);
                            if(from.equals(f.snum))
                            {
                                correctFrom = d;
                                found1 = true;
                            }
                            if(to.equals(f.snum))
                            {
                                correctTo = d;
                                found2 = true;
                            }
                        }
                        if(found1 && found2)
                        {
                            notdone = false;
                            System.out.println("Which message do you want to move? (Enter the position number of the message with 1 being the most recent message)");
                            int pos = inputI.nextInt()-1;
                            correctFrom.move(pos, correctFrom, correctTo);
                            System.out.println("Message moved.");
                        }
                        else if(found1)
                        {
                            System.out.println("Sorry there is no conversation to send to found with that number, try again.");
                        }
                        else if(found2)
                        {
                            System.out.println("Sorry there is no conversation to send from found with that number, try again.");
                        }
                        else
                        {
                            System.out.println("Sorry there are no conversations with those numbers, try again.");
                        }
                    }
                }

                else
                {
                    System.out.println("Sorry that is not an option, try again.");
                }
            }
            System.out.println("Would you like to continue using messenger? (yes or no)");
            String yn = input.nextLine();
            if(yn.equalsIgnoreCase("no"))
            {
                go = false;
            }
        }

    }
}
