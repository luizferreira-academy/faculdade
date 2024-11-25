
package CadastroPOO;

import CadastroPOO.model.PessoaFisica;
import CadastroPOO.model.PessoaFisicaRepo;
import CadastroPOO.model.PessoaJuridica;
import CadastroPOO.model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        

        // Implementação do cadastro em modo texto
        int opcao;
        do {
            System.out.println("Selecione a opcao:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar execucao");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (F -> Fisica ou J -> Juridica):");
                    String tipo = scanner.nextLine();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Digite o ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CPF:");
                        String cpf = scanner.nextLine();
                        System.out.println("Digite a idade:");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        repo1.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Digite o ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CNPJ:");
                        String cnpj = scanner.nextLine();
                        repo3.inserir(new PessoaJuridica(id, nome, cnpj));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tipo (F -> Fisica ou J -> Juridica):");
                    tipo = scanner.nextLine();
                    System.out.println("Digite o ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = repo1.obter(id);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais:");
                            pessoaFisica.exibir();
                            System.out.println("Digite o novo nome:");
                            String novoNome = scanner.nextLine();
                            pessoaFisica.setNome(novoNome);
                            System.out.println("Digite o novo CPF:");
                            String novoCpf = scanner.nextLine();
                            pessoaFisica.setCpf(novoCpf);
                            System.out.println("Digite a nova idade:");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            pessoaFisica.setIdade(novaIdade);
                            repo1.alterar(pessoaFisica);
                            System.out.println("Pessoa fisica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa fisica não encontrada.");
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = repo3.obter(id);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais:");
                            pessoaJuridica.exibir();
                            System.out.println("Digite o novo nome:");
                            String novoNome = scanner.nextLine();
                            pessoaJuridica.setNome(novoNome);
                            System.out.println("Digite o novo CNPJ:");
                            String novoCnpj = scanner.nextLine();
                            pessoaJuridica.setCnpj(novoCnpj);
                            repo3.alterar(pessoaJuridica);
                            System.out.println("Pessoa juridica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa juridica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo invalido.");
                    }
                    break;
                case 3:
                    System.out.println("Escolha o tipo (F -> Fisica ou J -> Juridica):");
                    tipo = scanner.nextLine();
                    System.out.println("Digite o ID:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    if (tipo.equalsIgnoreCase("F")) {
                        repo1.excluir(id);
                        System.out.println("Pessoa fisica excluida com sucesso.");
                    } else if (tipo.equalsIgnoreCase("J")) {
                        repo3.excluir(id);
                        System.out.println("Pessoa juridica excluida com sucesso.");
                    } else {
                        System.out.println("Tipo invalido.");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o tipo (F -> Fisica ou J -> Juridica):");
                    tipo = scanner.nextLine();
                    System.out.println("Digite o ID:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    if (tipo.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaFisica = repo1.obter(id);
                        if (pessoaFisica != null) {
                            System.out.println("Dados da pessoa fisica:");
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa fisica nao encontrada.");
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        PessoaJuridica pessoaJuridica = repo3.obter(id);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados da pessoa juridica:");
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa juridica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo invalido.");
                    }
                    break;
                case 5:
                    System.out.println("Escolha o tipo (F -> Fisica ou J -> Juridica):");
                    tipo = scanner.nextLine();
                    if (tipo.equalsIgnoreCase("F")) {
                        System.out.println("Pessoas fisicas cadastradas:");
                        for (PessoaFisica pessoa : repo1.obterTodos()) {
                            pessoa.exibir();
                            System.out.println();
                        }
                    } else if (tipo.equalsIgnoreCase("J")) {
                        System.out.println("Pessoas juridicas cadastradas:");
                        for (PessoaJuridica pessoa : repo3.obterTodos()) {
                            pessoa.exibir();
                            System.out.println();
                        }
                    } else {
                        System.out.println("Tipo invalido.");
                    }
                    break;
                case 6:
                    try {
                        repo1.persistir("pessoas_fisicas_cadastro.bin");
                        repo3.persistir("pessoas_juridicas_cadastro.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        repo2.recuperar("pessoas_fisicas_cadastro.bin");
                        repo4.recuperar("pessoas_juridicas_cadastro.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Finalizando execucao.");
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        } while (opcao != 0);
    }
    
}
