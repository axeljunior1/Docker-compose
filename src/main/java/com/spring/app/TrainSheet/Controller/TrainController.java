package com.spring.app.TrainSheet.Controller;

import com.spring.app.TrainSheet.Entity.Discipline;
import com.spring.app.TrainSheet.Entity.Exercice;
import com.spring.app.TrainSheet.Entity.Seance;
import com.spring.app.TrainSheet.Repository.DisciplineRepository;
import com.spring.app.TrainSheet.Repository.ExerciceRepository;
import com.spring.app.TrainSheet.Repository.SeanceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class TrainController {

    private final SeanceRepository seanceRepository;
    private final ExerciceRepository exerciceRepository;
    private final DisciplineRepository disciplineRepository;

    public TrainController(SeanceRepository seanceRepository, ExerciceRepository exerciceRepository, DisciplineRepository disciplineRepository) {
        this.seanceRepository = seanceRepository;
        this.exerciceRepository = exerciceRepository;
        this.disciplineRepository = disciplineRepository;
    }


    // Get Seance, Exercices and Discipline
    @CrossOrigin
    @GetMapping("/seances")
    public Iterable<Seance> getSeance(){
        return seanceRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/seances/{id}/exercices")
    public Iterable<Exercice> getExercice(@PathVariable Long id) throws Exception {
        if (seanceRepository.findById(id).isPresent()){
            return seanceRepository.findById(id).get().getExercice();
        }
        throw new Exception("The seance: " + id +" you are asking for doesn't exist");
    }
    @CrossOrigin
    @GetMapping("/seances/{id}/disciplines")
    public Iterable<Discipline> getDiscipline(@PathVariable Long id) throws Exception {
        Optional<Seance> seanceById = seanceRepository.findById(id);
        if (seanceById.isPresent()){
            return seanceById.get().getDisciplines();
        }else {
            throw new Exception("The seance: " + id +" you are asking for doesn't exist");
        }
    }

    // Get by id
    @CrossOrigin
    @GetMapping("/seances/{id}")
    public Optional<Seance> getSeanceById(@PathVariable Long id){
        return seanceRepository.findById(id);
    }
    @CrossOrigin
    @GetMapping("/seances/{id}/exercices/{idExercice}")
    public Exercice getExerciceById(@PathVariable Long id, @PathVariable Long idExercice){
        Set<Exercice> exercices = seanceRepository.findById(id).get().getExercice();
        for (Exercice e :exercices ) {
            if (e.getId().equals(idExercice)) return e;
        }
        return null;
    }
    @CrossOrigin
    @GetMapping("/seances/{id}/disciplines/{idDisc}")
    public Discipline getDisciplineById(@PathVariable Long id, @PathVariable Long idDisc){
        Set<Discipline> disciplines = seanceRepository.findById(id).get().getDisciplines();
        for (Discipline d : disciplines ) {
            if (d.getId().equals(idDisc)) return d;
        }
        return null;
    }

    //Post
    @CrossOrigin
    @PostMapping("/seances")
    public void postSeance(@RequestBody Seance seance){
        seanceRepository.save(seance);
    }
    @CrossOrigin
    @PostMapping("/seances/{id}/exercices")
    public Exercice postExercice(@PathVariable Long id, @RequestBody Exercice exercice){
        exercice.setSeance(seanceRepository.findById(id).get());
        exerciceRepository.save(exercice);
        return exercice;
    }

    @CrossOrigin
    @PostMapping("/seances/{id}/disciplines")
    public Discipline postExercice(@PathVariable Long id, @RequestBody Discipline discipline){
        discipline.setSeance(seanceRepository.findById(id).get());
        if (seanceRepository.findById(id).isPresent()) {
            disciplineRepository.save(discipline);
        }
        return discipline;
    }

    //Delete

    @CrossOrigin
    @DeleteMapping("/seances/{id}")
    public void DelSeance(@PathVariable Long id){
        seanceRepository.deleteById(id);
    }
    @CrossOrigin
    @DeleteMapping("/seances/exercices/{ide}")
    public void DelExercice(@PathVariable Long ide){
        exerciceRepository.deleteById(ide);
    }
    @CrossOrigin
    @DeleteMapping("/seances/disciplines/{idd}")
    public void DelDiscipline(@PathVariable Long idd){
        disciplineRepository.deleteById(idd);
    }









}
