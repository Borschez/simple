package ru.borsch.simple.service.impl.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borsch.simple.model.document.InternalDocument;
import ru.borsch.simple.repository.document.InternalDocumentRepository;
import ru.borsch.simple.service.document.InternalDocumentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("internalDocumentService")
@Transactional
public class InternalDocumentServiceImpl implements InternalDocumentService {
    @Autowired
    InternalDocumentRepository internalDocumentRepository;

    @Override
    public List<InternalDocument> findByExecutor(String executor) {
        return internalDocumentRepository.findByExecutor(executor);
    }

    @Override
    public String getDocumentTypeCode() {
        return "internal";
    }

    @Override
    public Optional<InternalDocument> findById(Long id) {
        return internalDocumentRepository.findById(id);
    }

    @Override
    public List<InternalDocument> findByRegistrationNumber(String registrationNumber) {
        return internalDocumentRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public List<InternalDocument> findByName(String name) {
        return internalDocumentRepository.findByName(name);
    }

    @Override
    public List<InternalDocument> findByState(String state) {
        return internalDocumentRepository.findByState(state);
    }

    @Override
    public List<InternalDocument> findAll() {
        return internalDocumentRepository.findAll();
    }
}
