package CadastroPOO.model;

public class PessoaFisica extends Pessoa{
    private String cpf;
    private int idade;
    
    //construtores
    public PessoaFisica(int idade, String cpf, String nome, int id) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    //metodo exibir
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf + "\nIdade: " + idade);
    }
    
    //getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
