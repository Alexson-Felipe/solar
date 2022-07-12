package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Fornecedor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class FornecedorModel {

    private UUID id;
    private String nome;
    private LocalDate aniver;
    private String cnpj;
    private Long idade;
    private String documento;
    private Boolean documentoValido;

    public FornecedorModel(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
        this.aniver = fornecedor.getAniver();
        this.cnpj = fornecedor.getDocumento();

        this.idade = fornecedor.getIdade();
        this.documento = this.cnpj;
        this.documentoValido = fornecedor.getDocumentoValido();
    }
}
