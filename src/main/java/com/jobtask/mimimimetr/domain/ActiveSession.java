package com.jobtask.mimimimetr.domain;

import com.jobtask.mimimimetr.repo.dao.ActiveSessionDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ActiveSession {
    private final SessionToken token;
    private final SessionStatus status;

    public record SessionToken (UUID value) {}
    public record SessionStatus (boolean isVoted) {}

    public ActiveSession(ActiveSessionDao activeSessionDao) {
        this(
                new SessionToken(activeSessionDao.getToken()),
                new SessionStatus(activeSessionDao.isVoted())
        );
    }

}
