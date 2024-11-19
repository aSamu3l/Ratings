package it.samu3l.ratings.service;

import it.samu3l.ratings.model.Ratings;
import it.samu3l.ratings.model.RatingsDTO;

import java.util.List;

public interface IRatingsService {
    Ratings add(Ratings ratings);

    Ratings add(RatingsDTO ratingsDTO);

    Iterable<Ratings> getAll();

    Iterable<Ratings> getAllByTotem(String totem);

    List<Ratings> getTodayMeasurements();

    List<Ratings> getTodayMeasurementsByTotem(String totem);

    List<Ratings> getDayMeasurements(String day);

    List<Ratings> getDayMeasuramentsByTotem(String day, String totem);

    Ratings delete(int id);
}
