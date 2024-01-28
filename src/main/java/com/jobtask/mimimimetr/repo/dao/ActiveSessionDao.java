package com.jobtask.mimimimetr.repo.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder
@Table(name = "active_session", schema = "mimimimetr")
@NoArgsConstructor
@AllArgsConstructor
public class ActiveSessionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID token;
    private boolean isVoted;
}
