package ekan.teste.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import ekan.teste.security.SecurityUser;
import lombok.Data;

@Data
@Entity
@Table(name="Beneficiario")
public class Beneficiario{

    @Id
    @SequenceGenerator(name = "beneficiario_id_generator", sequenceName = "beneficiario_id_seq")
    @GeneratedValue(generator = "beneficiario_id_generator")
    private Long id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "dtNascimento")
    private Timestamp dtNascimento;

    @Column(name = "dtInclusao")
    private Timestamp dtInclusao;

    @Column(name = "dtAtualicao")
    private Timestamp dtAtualizacao;
    

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "beneficiario_role",
            joinColumns = @JoinColumn(name = "beneficiario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "documento_id", referencedColumnName = "id"))
    private List<Documento> documentos;



}
