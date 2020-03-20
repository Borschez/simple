package ru.borsch.simple.service.impl.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borsch.simple.model.document.IncomingDocument;
import ru.borsch.simple.repository.document.IncomingDocumentRepository;
import ru.borsch.simple.service.document.IncomingDocumentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("incomingDocumentService")
@Transactional
public class IncomingDocumentServiceImpl implements IncomingDocumentService {
    @Autowired
    IncomingDocumentRepository incomingDocumentRepository;

    @Override
    public List<IncomingDocument> findByAddressee(String addressee) {
        return incomingDocumentRepository.findByAddressee(addressee);
    }

    @Override
    public String getDocumentTypeCode() {
        return "incoming";
    }

    @Override
    public Optional<IncomingDocument> findById(Long id) {
        return incomingDocumentRepository.findById(id);
    }

    @Override
    public List<IncomingDocument> findByRegistrationNumber(String registrationNumber) {
        return incomingDocumentRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public List<IncomingDocument> findByName(String name) {
        return incomingDocumentRepository.findByName(name);
    }

    @Override
    public List<IncomingDocument> findByState(String state) {
        return incomingDocumentRepository.findByState(state);
    }

    @Override
    public List<IncomingDocument> findAll() {
        return incomingDocumentRepository.findAll();
    }
}
