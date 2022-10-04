package de.myapp.ee.app.pattern.standard.microservice.controller;

import de.myapp.ee.app.pattern.standard.microservice.model.Pattern;
import de.myapp.ee.app.pattern.standard.microservice.model.PatternDTO;
import de.myapp.ee.app.pattern.standard.microservice.service.PatternService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatternController {

    private final PatternService patternService;

    PatternController(final PatternService patternService){
        this.patternService = patternService;
    }

    @PostMapping("/patterns")
    public ResponseEntity<Void> addPatterns(@RequestBody final PatternDTO patternDTO){
        patternService.addPattern(patternDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping("/pattern")
    public ResponseEntity<Void> addPattern(@RequestBody final PatternDTO patternDTO){
    	patternService.addPattern(patternDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/patterns")
    public ResponseEntity<List<Pattern>> getAllPatterns(){
         List<Pattern> patternList = patternService.getAllPatterns();
         return new ResponseEntity<>(patternList, HttpStatus.OK);
    }

    @GetMapping("/patterns/{patternId}")
    public ResponseEntity<Pattern> getPattern(@PathVariable final long patternId){
        Pattern pattern = patternService.getPattern(patternId);
        return new ResponseEntity<>(pattern, HttpStatus.OK);
    }

    @DeleteMapping("/patterns/{patternId}")
    public ResponseEntity<Void> deletePattern(@PathVariable final long patternId){
        patternService.deletePattern(patternId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
