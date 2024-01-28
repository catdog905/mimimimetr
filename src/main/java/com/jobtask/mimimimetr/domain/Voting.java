package com.jobtask.mimimimetr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;


public class Voting {

    private ActiveSession.SessionToken sessionToken;

    private Cat.CatId firstCatId;

    private Cat.CatId secondCatId;

    private VotingDecision decision;

    public enum VotingDecision {
        FIRST_CAT,
        SECOND_CAT
    }
}
