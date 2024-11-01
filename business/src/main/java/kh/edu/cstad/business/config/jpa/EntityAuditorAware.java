package kh.edu.cstad.business.config.jpa;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EntityAuditorAware implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        if (auth == null || !(auth.getPrincipal() instanceof CustomUserDetails user)) {
//            return Optional.of("yelb");
//        }
//
//        return Optional.of(user.getUsername());
        return Optional.of("admin");
    }
}
