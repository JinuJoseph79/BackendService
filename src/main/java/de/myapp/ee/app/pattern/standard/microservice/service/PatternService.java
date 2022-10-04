package de.myapp.ee.app.pattern.standard.microservice.service;

import java.util.List;

import de.myapp.ee.app.pattern.standard.microservice.model.Pattern;
import de.myapp.ee.app.pattern.standard.microservice.model.PatternDTO;

public interface PatternService {
    void addPattern(PatternDTO pattern);
    List<Pattern> getAllPatterns();
    Pattern getPattern(Long patternId);
    void deletePattern(Long patternId);
}
