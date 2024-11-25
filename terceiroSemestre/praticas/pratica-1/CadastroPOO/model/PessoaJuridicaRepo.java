package CadastroPOO.model;

import CadastroPOO.model.PessoaJuridica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    public List<PessoaJuridica> pessoasJuridicas = new ArrayList();
    
    //metodo inserir
    public void inserir(PessoaJuridica pessoaJuridica){
        pessoasJuridicas.add(pessoaJuridica);
    }
    
    //metodo alterar
    public void alterar(PessoaJuridica pessoaJuridica){
        
    }
    
    //metood excluir
    public void excluir(int id){
        pessoasJuridicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    //metodo obter
    public PessoaJuridica obter(int id){
        return pessoasJuridicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    //metodo obter todos
    public List<PessoaJuridica> obterTodos(){
        return new ArrayList <>(pessoasJuridicas);
    }
    
    //metodo persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasJuridicas);
        }
    }
    
    //metodo recuperar
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (List<PessoaJuridica>) inputStream.readObject();
        }
    }
}


