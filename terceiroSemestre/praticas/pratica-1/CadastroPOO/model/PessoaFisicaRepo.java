package CadastroPOO.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    //arrayList
    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    
    //método inserir
    public void inserir(PessoaFisica pessoaFisica){
        pessoasFisicas.add(pessoaFisica);
    }
    
    //método alterar
    public void alterar(PessoaFisica pessoaFisica){
        
    }
    
    //método excluir
    public void excluir(int id){
       pessoasFisicas.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    //método obter 
    public PessoaFisica obter(int id){
        return  pessoasFisicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    //método obterTodos
    public List<PessoaFisica> obterTodos(){
        return new ArrayList<>(pessoasFisicas);
    }
    
    //método persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }
    
    //metodo recuperar
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (List<PessoaFisica>) inputStream.readObject();
        }
    }
}
