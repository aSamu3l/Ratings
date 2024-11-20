package it.samu3l.ratings.controller;

import it.samu3l.ratings.model.Ratings;
import it.samu3l.ratings.model.RatingsViewDTO;
import it.samu3l.ratings.service.IRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RequestMapping("/")
public class RatingsController {
    @Autowired
    private IRatingsService ratingsService;

    @RequestMapping("all")
    public String all(Model model, @RequestParam(value = "totem", required = false) String room) {
        List<Ratings> ratings;

        if (room != null)
            ratings = (List<Ratings>) ratingsService.getAllByTotem(room);
        else
            ratings = (List<Ratings>) ratingsService.getAll();

        RatingsViewDTO ratingsViewDTO = new RatingsViewDTO();

        for (Ratings rating : ratings) {
            switch (rating.getRating()) {
                case 3:
                    ratingsViewDTO.addPositive();
                    break;
                case 2:
                    ratingsViewDTO.addNeutral();
                    break;
                case 1:
                    ratingsViewDTO.addNegative();
                    break;
            }
        }

        model.addAttribute("ratings", ratingsViewDTO);

        return "index";
    }

    @RequestMapping("")
    public String today(Model model, @RequestParam(value = "totem", required = false) String room, @RequestParam(value = "day", required = false) String day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate date;

        if (day == null) {
            date = LocalDate.now();
        } else {
            try {
                date = LocalDate.parse(day, formatter);
            } catch (DateTimeParseException e) {
                model.addAttribute("error", "Invalid date format. Please use ddMMyyyy.");
                return "error";
            }
        }

        List<Ratings> ratings;

        if (room != null)
            ratings = ratingsService.getDayMeasuramentsByTotem(date.toString(), room);
        else
            ratings = ratingsService.getDayMeasurements(date.toString());

        RatingsViewDTO ratingsViewDTO = new RatingsViewDTO();

        for (Ratings rating : ratings) {
            switch (rating.getRating()) {
                case 3:
                    ratingsViewDTO.addPositive();
                    break;
                case 2:
                    ratingsViewDTO.addNeutral();
                    break;
                case 1:
                    ratingsViewDTO.addNegative();
                    break;
            }
        }

        model.addAttribute("ratings", ratingsViewDTO);

        return "index";
    }
}
