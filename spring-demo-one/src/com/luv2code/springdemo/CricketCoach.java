package com.luv2code.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    // add new fields for emailAddress and team
    private String emailAddress;
    private String team;

    // create no-arg constructor
    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }
    
    // this is the setter method that will be called by Spring to inject the dependency
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("CricketCoach: inside setter method - setFortuneService");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        System.out.println("CricketCoach: inside setter method - setEmailAddress");
    }
    
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
        System.out.println("CricketCoach: inside setter method - setTeam");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
