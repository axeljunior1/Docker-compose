package com.spring.app.trainSheet.controller;

import com.spring.app.trainSheet.entity.Discipline;
import com.spring.app.trainSheet.entity.Exercise;
import com.spring.app.trainSheet.entity.Session;
import com.spring.app.trainSheet.exceptionhandler.TrainSheetException;
import com.spring.app.trainSheet.repository.DisciplineRepository;
import com.spring.app.trainSheet.repository.ExerciseRepository;
import com.spring.app.trainSheet.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

import static java.lang.String.format;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TrainController {

    private final SessionRepository sessionRepository;
    private final ExerciseRepository exerciseRepository;
    private final DisciplineRepository disciplineRepository;


    // Get Session, Exercises and Discipline
    @GetMapping("/session")
    public Collection<Session> getSession() {
        return sessionRepository.findAll();
    }

    @GetMapping("/session/{id}/exercises")
    public Collection<Exercise> getExercise(@PathVariable Long id) {
        return sessionRepository
                .findById(id)
                .orElseThrow(() -> new TrainSheetException(format("The session: %s you are asking for doesn't exist", id)))
                .getExercises();
    }

    @GetMapping("/session/{id}/disciplines")
    public Collection<Discipline> getDiscipline(@PathVariable Long id) {
        return sessionRepository
                .findById(id)
                .orElseThrow(() -> new TrainSheetException(format("The session: %s you are asking for doesn't exist", id)))
                .getDisciplines();
    }

    // Get by id
    @GetMapping("/session/{id}")
    public Session getSeanceById(@PathVariable Long id) {
        return sessionRepository
                .findById(id)
                .orElseThrow();
    }

    @GetMapping("/session/{id}/exercises/{exerciseId}")
    public Exercise getExerciseById(@PathVariable Long id, @PathVariable Long exerciseId) {
        return sessionRepository.findById(id)
                .orElseThrow()
                .getExercises()
                .stream()
                .filter(exercise -> Objects.equals(exercise.getId(), exerciseId))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/session/{id}/disciplines/{disciplineId}")
    public Discipline getDisciplineById(@PathVariable Long id, @PathVariable Long disciplineId) {
        return sessionRepository
                .findById(id)
                .orElseThrow()
                .getDisciplines()
                .stream()
                .filter(discipline -> Objects.equals(discipline.getId(), disciplineId))
                .findFirst().orElseThrow();
    }

    //Post Request
    @PostMapping("/session")
    public void createSeance(@RequestBody Session session) {
        sessionRepository.save(session);
    }

    @PostMapping("/session/{id}/exercises")
    public Exercise createExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        Session session = sessionRepository
                .findById(id)
                .orElseThrow();
        exercise.setSession(session);
        exerciseRepository.save(exercise);
        return exercise;
    }

    @PostMapping("/session/{id}/disciplines")
    public Discipline createExercise(@PathVariable Long id, @RequestBody Discipline discipline) {
        Session session = sessionRepository
                .findById(id)
                .orElseThrow();
        discipline.setSession(session);
        return disciplineRepository.save(discipline);
    }

    // Delete request
    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @DeleteMapping("/sessions/exercises/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseRepository.deleteById(id);
    }

    @DeleteMapping("/sessions/disciplines/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
        disciplineRepository.deleteById(id);
    }

}
