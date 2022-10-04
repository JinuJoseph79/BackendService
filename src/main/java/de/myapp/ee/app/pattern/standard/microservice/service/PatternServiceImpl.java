package de.myapp.ee.app.pattern.standard.microservice.service;

import de.myapp.ee.app.pattern.standard.microservice.model.AlreadyExistsException;
import de.myapp.ee.app.pattern.standard.microservice.model.NotFoundExeption;
import de.myapp.ee.app.pattern.standard.microservice.model.Pattern;
import de.myapp.ee.app.pattern.standard.microservice.model.PatternDTO;
import de.myapp.ee.app.pattern.standard.microservice.repository.PatternRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternServiceImpl implements PatternService {
    private static final Logger log = LoggerFactory.getLogger(PatternServiceImpl.class);
    private final PatternRepository patternRepository;
    private final ModelMapper modelMapper;

    PatternServiceImpl(final PatternRepository patternRepository, ModelMapper modelMapper){
        this.patternRepository = patternRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPattern(PatternDTO patternDTO) {
        patternRepository.findByName(patternDTO.getName()).ifPresent(pattern -> {
            String errorMessage = "Pattern with same name already exists";
            log.error(errorMessage);
            throw new AlreadyExistsException(errorMessage);
        });

        Pattern pattern = modelMapper.map(patternDTO, Pattern.class);
        patternRepository.save(pattern);
        log.info("Pattern {} created", pattern);
    }

    @Override
    public List<Pattern> getAllPatterns() {
        return patternRepository.findAll();
    }

    @Override
    public Pattern getPattern(Long patternId) {
        String errorMessage = String.format("Pattern with id=%d not found", patternId);
        return patternRepository.findById(patternId).orElseThrow(() -> new NotFoundExeption(errorMessage));
    }

    @Override
    public void deletePattern(Long patternId) {
        String errorMessage = String.format("Pattern with id=%d not found", patternId);
        Pattern pattern = patternRepository.findById(patternId)
                .orElseThrow(() -> {
                    log.info(errorMessage);
                    throw new NotFoundExeption(errorMessage);
                });

        patternRepository.delete(pattern);
        log.info("Pattern {} deleted", pattern);
    }
}
