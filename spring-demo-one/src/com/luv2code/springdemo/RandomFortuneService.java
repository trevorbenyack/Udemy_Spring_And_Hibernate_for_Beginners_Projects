package com.luv2code.springdemo;

public class RandomFortuneService implements FortuneService {

    @Override
    public String getFortune() {

        String fortunes[] = {
                "You are going to find the love of your life",
                "You will gain immense wealth",
                "Keep on truckin' -- Nothing exciting happening today"
        };

        return fortunes[(int)(Math.random() * 3)];
    }
}
