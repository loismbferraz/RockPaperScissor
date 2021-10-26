package com.rps.entities;

public enum Choice {

    ROCK("ROCK","PAPER"), PAPER("PAPER","SCISSOR"), SCISSOR("SCISSOR","ROCK"), EMPTY("ERROR","ERROR");

    private final String id;
    private final String wonBy;

     Choice(String id, String wonBy){

        this.id = id;
        this.wonBy = wonBy;
    }

    public static Choice getChoiceById(String userEnteredOption){
        for(Choice option: Choice.values()){
            if(userEnteredOption.equals(option.id)){
                return option;
            }
        }
        return EMPTY;
    }

    public boolean isWonBy(String option){
        return this.wonBy.equals(option);
    }


}
