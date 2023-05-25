package objeto.consultoriomedico;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * Dev antigo: Matheus Schmidt
 * Dev novo: Lucas Pessoli
 */
public class Receita extends Pessoa{
    
    public Receita(String nomePaciente, int idade) {
        super(' ', nomePaciente, "", idade, ' ', "", "", "", "", "");
    }
    
    public String[] nomePaciente = new String[100];
    public String[] nomeMedico = new String[100];
    public String[] nomeMedicamento = new String[100];
    public int[] emissao = new int[100];
    public int[] codIdentificacao = new int[100];
    private int quantidade;
    private double dosagem;
    public int fimLoop;

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public int getQuatidade() {
        return quantidade;
    }

    public void setQuatidade(int quatidade) {
        this.quantidade = quatidade;
    }

    public void agendarHorario() {
        for (int i = 0; i != -1; i++) {
            fimLoop = i;
            Scanner ler = new Scanner(System.in);
            System.out.println("# Informe o seu nome:");
            nomePaciente[i] = ler.next();
            System.out.println("# Informe o nome do medico que lhe forneceu a receita:");
            nomeMedico[i] = ler.next();
            System.out.println("* Há quantos dias que o médico lhe forneceu a receita:");
            emissao[i] = ler.nextInt();
            System.out.println("#Informe o medicamento:");
            nomeMedicamento[i] = ler.next();
            Random gerador = new Random();
            codIdentificacao[i] = gerador.nextInt(1000);
            System.out.println("Seu código de identificação: " + codIdentificacao[i]);
            System.out.println("Sr(a)" + nomePaciente[i] + " seu codigo gerado para identificar o medicamento ou caso precise cancelar é " + codIdentificacao[i]);
            System.out.println("(0)Agendar outro paciente\n(1)Voltar para o menu");
            String escolha = ler.next();
            switch (escolha) {
                case "0":
                    break;
                case "1":
                    menu();
                    break;
                case "2":
                    exibirPessoasMarcadas();
                    break;
            }
        }
    }

    public void exibirPessoasMarcadas() {
        System.out.println("Pessoas agendadas:\n");
        for (int i = 0; i < fimLoop + 1; i++) {
            System.out.println("ID da pessoa: " + codIdentificacao[i]);
            System.out.println("Nome: " + nomePaciente[i]);
            System.out.println("Medico: " + nomeMedico[i]);
            System.out.println("Receita emitida há: " + emissao[i] + " dias");
            System.out.println("Medicamento: " + nomeMedicamento[i]);
            System.out.println("\n============================================\n");
        }
        menu();
    }

    public void cancelarHorario() {
        int idNovo;
        Scanner ler = new Scanner(System.in);
        System.out.println("Para o cancelamento do seu horário precisamos confirmar alguns dados: ");
        for (int i = 0; i < 100; i++) {
            System.out.println("Informe o seu nome: ");
            nomePaciente[i] = ler.next();
            System.out.println("Informe o seu codigo de identificador: ");
            idNovo = ler.nextInt();
            if (codIdentificacao[i] == idNovo) {
                System.out.println("Sucesso! " + nomePaciente[i] + ", seu horário foi cancelado com sucesso!");
                nomePaciente[3] = null;
                nomeMedico[i] = null;
                emissao[i] = 0;
                nomeMedicamento[i] = null;
                menu();
            } else {
                System.out.println("Erro!!!");

            }
        }
    }

    public void lembreteHorario() {
        Random gerar = new Random();
        quantidade = gerar.nextInt(1) + 6;
        dosagem = gerar.nextInt(2) + 2;
        Random random = new Random();
        int dia = random.nextInt(365);
        int mes = random.nextInt(12) + 1;
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, 2023);
        calendario.set(Calendar.MONTH, mes - 1);
        calendario.set(Calendar.DAY_OF_MONTH, 1);
        calendario.add(Calendar.DAY_OF_MONTH, dia);
        System.out.println(calendario.getTime());
        System.out.println("O seu medicamento deve ser tomado " + calendario.getTime() + " ml/g por dia durante " + quantidade + " dias.");
        menu();
    }
    
    @Override
    public void cadastrar(){
        for (int i = 0; i != -1; i++) {
            fimLoop = i;
            Scanner ler = new Scanner(System.in);
            System.out.println("# Informe o seu nome:");
            nomePaciente[i] = ler.next();
            System.out.println("# Informe o nome do medico que lhe forneceu a receita:");
            nomeMedico[i] = ler.next();
            System.out.println("* Há quantos dias que o médico lhe forneceu a receita:");
            emissao[i] = ler.nextInt();
            System.out.println("#Informe o medicamento:");
            nomeMedicamento[i] = ler.next();
            Random gerador = new Random();
            codIdentificacao[i] = gerador.nextInt(1000);
            System.out.println("Seu código de identificação: " + codIdentificacao[i]);
            System.out.println("Sr(a)" + nomePaciente[i] + " seu codigo gerado para identificar o medicamento ou caso precise cancelar é " + codIdentificacao[i]);
            System.out.println("(0)Agendar outro paciente\n(1)Voltar para o menu");
            String escolha = ler.next();
            switch (escolha) {
                case "0": //irá dar continuidade no loop
                    break;
                case "1":
                    menu();
                    break;
            }
        }
    }

    public void menu() {
        Scanner ler = new Scanner(System.in);
        boolean encerraLacoRepeticao = false;
        while(!encerraLacoRepeticao){
            System.out.println("Escolha uma das seguintes opções:\n[1] - Agendar Horario\n[2] - Cancelar Horario\n[3] - Mandar um lembrete\n[4] - Pessoas Agendadas\n[5] - Menu Principal");
            String escolha = ler.next();
            switch (escolha) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    cancelarHorario();
                    break;
                case "3":
                    lembreteHorario();
                    break;
                case "4":
                    exibirPessoasMarcadas();
                    break;
                case "5":
                    encerraLacoRepeticao = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
