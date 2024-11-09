package kh.edu.cstad.gateway_server;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/profile")
    UserProfile secured(@AuthenticationPrincipal Authentication auth) {

        OAuth2AuthenticationToken oauth2 = (OAuth2AuthenticationToken) auth;
        DefaultOidcUser oidcUser = (DefaultOidcUser) oauth2.getPrincipal();

        // Print all attributes to the console (for debugging)
        System.out.println("claim = "+oidcUser.getClaims());
        // All claims should be in here
        System.out.println("claim = "+oidcUser.getClaims());

        // You can either use getAttributes() or getClaim() depending on where the claims are stored
        return new UserProfile(
                oidcUser.getName(),  // The username
                oidcUser.getAttributes().get("name")+"",  // Getting 'name' claim
                oidcUser.getAttributes().get("email") != null ? oidcUser.getAttributes().get("email").toString() : "No email"  // Getting 'email' claim, handle null case
        );
    }
}


