package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class QueueItem{
        String word;
        int len;
        public QueueItem(String word, int len){
            this.word = word;
            this.len = len;
        }
    }
    static Queue<QueueItem> queue;
    static HashSet<String> dictionary;

    public static void main(String[] args) {
        dictionary = new HashSet<>();
        dictionary.add("POON");
        dictionary.add("SOON");
        dictionary.add("NOON");
        dictionary.add("MOON");
        dictionary.add("PLEE");
        dictionary.add("SAME");
        dictionary.add("POIE");
        dictionary.add("PLEA");
        dictionary.add("PLIE");
        dictionary.add("POIN");

        String start = "TOON";
        String end = "PLEA";

        System.out.println("Length of shortest chain to reach a target word is: "+shortestChainLen(start,end));
    }

    public static int shortestChainLen(String start, String end){
        queue = new LinkedList<>();
        QueueItem item  = new QueueItem(start,1);
        queue.add(item);

        while (!queue.isEmpty()){
            QueueItem front = queue.poll();
            Iterator<String> it = dictionary.iterator();
            while (it.hasNext()){
                String temp = it.next();
                if(isAdjacent(temp,front.word)){
                    queue.add(new QueueItem(temp,front.len+1));
                    it.remove();

                    if (temp == end){
                        return queue.peek().len;
                    }
                }
            }

        }
        return 0;
    }

    public static boolean isAdjacent(String str1, String str2){
        if (str1.length()!=str2.length()){
            return false;
        }
        int characterDiffer = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                characterDiffer++;
            }
        }
        return (characterDiffer == 1);
    }

}



