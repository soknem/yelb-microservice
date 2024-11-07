package kh.edu.cstad.identity.init;

import jakarta.annotation.PostConstruct;
import kh.edu.cstad.identity.domain.Role;
import kh.edu.cstad.identity.domain.User;
import kh.edu.cstad.identity.repository.RoleRepository;
import kh.edu.cstad.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Init {

    private static final Logger logger = LoggerFactory.getLogger(Init.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostConstruct
    public void init() {
        try {
            initRoles();
            initUser();
        } catch (Exception e) {
            logger.error("Initialization failed: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void initRoles() {
        try {
            List<String> roleNames = Arrays.asList("USER", "ADMIN", "MODERATOR");
            for (String roleName : roleNames) {
                String roleFullName = "ROLE_" + roleName;
                if (roleRepository.findByName(roleFullName) == null) {
                    Role role = new Role();
                    role.setName(roleFullName);
                    roleRepository.save(role);
                    logger.info("Initialized role: {}", roleFullName);
                }
            }
        } catch (Exception e) {
            logger.error("Error initializing roles: {}", e.getMessage(), e);
        }
    }

    @Transactional
    public void initUser() {
        try {
            if (userRepository.count() == 0) {
                Role userRole = roleRepository.findByName("ROLE_USER");
                if (userRole == null) {
                    userRole = new Role();
                    userRole.setName("ROLE_USER");
                    userRole = roleRepository.save(userRole);
                }

                User user = new User();
                user.setEmail("soknem@gmail.com");
                user.setPassword(passwordEncoder.encode("soknem"));
                user.setName("soknem");
                user.setIsEnabled(true);

                Set<Role> roles = new HashSet<>();
                roles.add(userRole);
                user.setRoles(roles);

                userRepository.save(user);
                logger.info("Initialized a new user: {}", user.getEmail());
            }
        } catch (Exception e) {
            logger.error("Error initializing user: {}", e.getMessage(), e);
        }
    }
}
