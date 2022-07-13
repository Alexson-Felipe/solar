package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Farmaceutico;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class FarmaceuticoModel {

    private UUID id;
    private String nome;
    private LocalDate aniver;
    private String cpf;

    private String promocaoDia;
    private Long idade;
    private String documento;
    private Boolean documentoValido;
    public FarmaceuticoModel(Farmaceutico farmaceutico) {
        this.id = farmaceutico.getId();
        this.nome = farmaceutico.getNome();
        this.aniver = farmaceutico.getAniver();
        this.cpf = farmaceutico.getDocumento();
        this.idade = farmaceutico.getIdade();
        this.promocaoDia = farmaceutico.getPromocaoDia();
        this.documento = cpf;
        this.documentoValido = farmaceutico.getDocumentoValido();
    }
}
