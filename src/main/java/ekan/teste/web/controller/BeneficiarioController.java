package ekan.teste.web.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ekan.teste.entity.Beneficiario;
import ekan.teste.entity.Documento;
import ekan.teste.service.BeneficiarioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/beneficiarios")
@Slf4j
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping("")
    @PreAuthorize("isAuthenticated()")
    public List<Beneficiario> getBeneficiarios() {
    	log.info("process=get-beneficiario");
        return beneficiarioService.getAllBeneficiarios();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Beneficiario> getBeneficiario(@PathVariable Long id) {
        log.info("process=get-beneficiario, beneficiario_id={}", id);
        Optional<Beneficiario> beneficiario = beneficiarioService.getBeneficiarioById(id);
        return beneficiario.map( u -> ResponseEntity.ok(u))
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{id}/documentos")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Documento>> getDocumentos(@PathVariable Long id) {
        log.info("process=get-documentos, beneficiario_id={}", id);
        Optional<Beneficiario> beneficiario = beneficiarioService.getBeneficiarioById(id);
        return beneficiario.map( u -> ResponseEntity.ok(u.getDocumentos()))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    @PreAuthorize("isAuthenticated()")
    public Beneficiario createBeneficiario(@RequestBody Beneficiario beneficiario) {
        log.info("process=create-beneficiario, beneficiario_nome={}", beneficiario.getNome());
        return beneficiarioService.createBeneficiario(beneficiario);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public Beneficiario updateBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        log.info("process=update-beneficiario, user_id={}", id);
        beneficiario.setId(id);
        return beneficiarioService.updateBeneficiario(beneficiario);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteBeneficiario(@PathVariable Long id) {
        log.info("process=delete-beneficiario, beneficiario_id={}", id);
        beneficiarioService.deleteBeneficiario(id);
    }

}
