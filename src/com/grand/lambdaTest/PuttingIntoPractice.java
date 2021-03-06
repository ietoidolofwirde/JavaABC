package com.grand.lambdaTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

//https://blog.csdn.net/nullbull/article/details/81234250

public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*找出2011年发生的所有交易，并按交易额排序

        交易员在哪些不同的城市工作过

        查找所有来自剑桥的交易员，并按姓名排序

        返回所有交易员的姓名字符串，并按字母顺序排序

        有没有交易员在米兰工作的？

        打印生活在剑桥的交易员的所有交易额

        所有交易中，最高的交易额是多少

        找到交易额最小的交易*/

        // 1 找出2011年发生的所有交易，并按交易额排序
        List<Transaction> tr2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction :: getValue))
                .collect(toList());

        System.out.println(tr2011);
        //=============================

        //Query2  交易员在哪些不同的城市工作过
        List<String> cities = transactions.stream().map(transaction->transaction.getTrader().getCity())
        .distinct().collect(toList());
        System.out.println(cities);

        //Query3 查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);

        //Query4 返回所有交易员的姓名字符串，并按字母顺序排序
        String traderStr = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1,n2) -> n1 + n2);
        System.out.println(traderStr);

        //Query5 有没有交易员在米兰工作的？
        boolean milanBased = transactions.stream().
                anyMatch(transaction->transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //Query6 打印生活在剑桥的交易员的所有交易额



    }
}
