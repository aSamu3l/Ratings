package it.samu3l.ratings.service;

import it.samu3l.ratings.model.Ratings;
import it.samu3l.ratings.model.RatingsDTO;
import it.samu3l.ratings.repository.IRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RatingsService implements IRatingsService {
    @Autowired
    private IRatingsRepository ratingsRepository;

    @Override
    public Ratings add(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    @Override
    public Ratings add(RatingsDTO ratingsDTO) {
        return ratingsRepository.save(new Ratings(ratingsDTO.getTotem(), ratingsDTO.getRating()));
    }

    @Override
    public Iterable<Ratings> getAll() {
        return ratingsRepository.getAllByOrderByIdDesc();
    }

    @Override
    public Iterable<Ratings> getAllByTotem(String totem) {
        return ratingsRepository.findAllByTotemOrderByIdDesc(totem);
    }

    @Override
    public List<Ratings> getTodayMeasurements() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return ratingsRepository.findByTimestampBetweenOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp);
    }

    @Override
    public List<Ratings> getTodayMeasurementsByTotem(String totem) {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return ratingsRepository.findByTimestampBetweenAndTotemOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp, totem);
    }

    @Override
    public List<Ratings> getDayMeasurements(String day) {
        LocalDate date = LocalDate.parse(day);
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return ratingsRepository.findByTimestampBetweenOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp);
    }

    @Override
    public List<Ratings> getDayMeasuramentsByTotem(String day, String totem) {
        LocalDate date = LocalDate.parse(day);
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return ratingsRepository.findByTimestampBetweenAndTotemOrderByIdDesc(startOfDayTimestamp, endOfDayTimestamp, totem);
    }

    @Override
    public Ratings delete(int id) {
        Ratings ratings = ratingsRepository.findById(id).orElseThrow();
        ratingsRepository.delete(ratings);
        return ratings;
    }
}
