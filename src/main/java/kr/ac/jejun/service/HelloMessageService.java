package kr.ac.jejun.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Service
public class HelloMessageService {
    @PreAuthorize("authenticated")
    public String getMessage() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return "Hello" + authentication;
    }
}
