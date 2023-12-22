package ekan.teste.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ekan.teste.entity.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
