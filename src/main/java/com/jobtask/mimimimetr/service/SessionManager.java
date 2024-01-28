package com.jobtask.mimimimetr.service;

import com.jobtask.mimimimetr.domain.ActiveSession;
import com.jobtask.mimimimetr.repo.ActiveSessionRepository;
import com.jobtask.mimimimetr.repo.CatRepository;
import com.jobtask.mimimimetr.repo.dao.ActiveSessionDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SessionManager {

    private final ActiveSessionRepository activeSessionRepository;

    public ActiveSession getSession(UUID sessionToken) throws NoSuchSession {
        return new ActiveSession(
                activeSessionRepository
                        .findById(sessionToken)
                        .orElseThrow(() -> new NoSuchSession(sessionToken)));
    }

    @AllArgsConstructor
    @Getter
    public static class NoSuchSession extends Exception {
        private final UUID token;
    }


    public ActiveSession newSession() {
        return new ActiveSession(
                activeSessionRepository.save(
                        ActiveSessionDao.builder()
                                .isVoted(false)
                                .build()));
    }
}
