package ekan.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ekan.teste.entity.Beneficiario;
import ekan.teste.repo.BeneficiarioRepository;

@Service
@Transactional
public class BeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;

    @Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public Optional<Beneficiario> getBeneficiarioById(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public List<Beneficiario> getAllBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario createBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario updateBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public void deleteBeneficiario(Long beneficiarioId) {
    	beneficiarioRepository.deleteById(beneficiarioId);
    }

}
