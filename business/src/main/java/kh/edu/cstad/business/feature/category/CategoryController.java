package kh.edu.cstad.business.feature.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public Map<String,String> findAl(){
        return Map.of("name","soknem");
    }
}
