package com.jobtask.mimimimetr.repo.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "voting", schema = "mimimimetr")
public class VotingDao {

    @Id
    private UUID session;

    @Id
    private Long firstCatId;

    @Id
    private Long secondCatId;

    private boolean decision;
}
