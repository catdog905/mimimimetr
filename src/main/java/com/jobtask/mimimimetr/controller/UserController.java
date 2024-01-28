package com.jobtask.mimimimetr.controller;


import com.jobtask.mimimimetr.domain.ActiveSession;
import com.jobtask.mimimimetr.service.SessionManager;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController {
    private final SessionManager sessionManager;

    @GetMapping("/next-pair")
    public ResponseEntity<String> getNextPair(HttpSession session) {
        ActiveSession activeSession =
                Optional.of(session.getAttribute("voting_token"))
                        .filter(rawToken -> rawToken instanceof UUID)
                        .map(votingToken -> {
                            try {
                                return sessionManager.getSession((UUID) votingToken);
                            } catch (SessionManager.NoSuchSession e) {
                                return sessionManager.newSession();
                            }
                        })
                        .orElseGet(sessionManager::newSession);
        // Return 2 images
        session.setAttribute("voting_token", activeSession.getToken());
        // Get next pair from database
        return ResponseEntity.ok("Hello, world!");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard(int n, HttpSession session) {
        // Return n best cat
        return ResponseEntity.ok("Hello");
    }
}
