/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CadastroPOO;

import CadastroPOO.model.PessoaFisica;
import CadastroPOO.model.PessoaFisicaRepo;
import CadastroPOO.model.PessoaJuridica;
import CadastroPOO.model.PessoaJuridicaRepo;
import java.io.IOException;


public class MainCadastro {
    public static void main(String[] args) {
        //Repositório (repo1)
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // adicionando pessoas
        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Carlos", "22222222222", 52);

        repo1.inserir(pessoaFisica1);
        repo1.inserir(pessoaFisica2);

        try {
            //método de persistência em repo1
            repo1.persistir("pessoasFisicas.dat");

            //Repositório (repo2).
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            //método de recuperação em repo2
            repo2.recuperar("pessoasFisicas.dat");

            // Exibir os dados de todas as pessoas físicas recuperadas.
            System.out.println("Dados de Pessoa Fisica Recuperados:");
            repo2.obterTodos().forEach(PessoaFisica::exibir);

            //Repositório (repo3).
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            //Adicionando pessoas, utilizando o construtor completo.
            PessoaJuridica pessoaJuridica1 = new PessoaJuridica(3, "XPTO Sales", "33333333333333");
            PessoaJuridica pessoaJuridica2 = new PessoaJuridica(4, "XPTO Solutions", "44444444444444");

            repo3.inserir(pessoaJuridica1);
            repo3.inserir(pessoaJuridica2);

            //método de persistência em repo3
            repo3.persistir("pessoasJuridicas.dat");

            //Repositório (repo4).
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            //método de recuperação repo4
            repo4.recuperar("pessoasJuridicas.dat");

            // Exibir os dados de todas as pessoas jurídicas recuperadas.
            System.out.println("\nDados de Pessoa Juridica Recuperados:");
            repo4.obterTodos().forEach(PessoaJuridica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
            
}
