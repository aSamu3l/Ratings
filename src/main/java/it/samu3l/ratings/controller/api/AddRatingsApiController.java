package it.samu3l.ratings.controller.api;

import it.samu3l.ratings.model.RatingsDTO;
import it.samu3l.ratings.service.IRatingsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddRatingsApiController {
    @Autowired
    private IRatingsService ratingsService;

    @Value("${api.token}")
    private String apiToken;

    public AddRatingsApiController() {
    }

    @PostMapping("/add")
    public String add(@RequestBody RatingsDTO ratingsDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.equals(apiToken)) {
            return "Unauthorized";
        }
        return ratingsService.add(ratingsDTO).toString();
    }
}
