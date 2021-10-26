package com.rps.entities;

public enum Choice {

    ROCK("ROCK","PAPER"), PAPER("PAPER","SCISSOR"), SCISSOR("SCISSOR","ROCK"), EMPTY("ERROR","ERROR");

    private final String id;
    private final String wonBy;

     Choice(String id, String wonBy){

        this.id = id;
        this.wonBy = wonBy;
    }

    public static Choice getChoiceById(Choice userEnteredOption){
        for(Choice option: Choice.values()){
            if(userEnteredOption.equals(option)){
                return option;
            }
        }
        return EMPTY;
    }

    public boolean isWonBy(Choice option){
        return this.wonBy.equals(option.id);
    }


}
