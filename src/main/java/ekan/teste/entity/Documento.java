package ekan.teste.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Documento")
@Data
public class Documento {

    @Id
    @SequenceGenerator(name = "documento_id_generator", sequenceName = "documento_id_seq")
    @GeneratedValue(generator = "documento_id_generator")
    Long id;
    
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dtInclusao")
    private Timestamp dtInclusao;

    @Column(name = "dtAtualicao")
    private Timestamp dtAtualizacao;

}
