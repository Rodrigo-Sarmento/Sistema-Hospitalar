import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        List<Medico> medicos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Consulta> consultas = new ArrayList<>();


        int escolha = 0;
        while(escolha != 7){
            System.out.println("*** Sistema Hospitalar ***");
            System.out.println("1-Cadastrar Paciente");
            System.out.println("2- Listar Pacientes");
            System.out.println("3-Cadastrar Medico");
            System.out.println("4-Listar Medicos");
            System.out.println("5-Cadastrar Consulta");
            System.out.println("6-Listar Consultas");
            System.out.println("7-Sair");
            escolha = s.nextInt();
            if(escolha == 1){
                cadastrarPaciente(pacientes);
            } else if (escolha == 2) {
                System.out.println("*** Lista de Pacientes ***");
                for(Paciente p : pacientes){
                    System.out.println("Nome: "+p.getNome());
                    System.out.println("CPF: "+p.getCpf());
                    System.out.println("----------------------------");
                }
            } else if (escolha == 3) {
                cadastrarMedico(medicos);
            } else if (escolha == 4) {
                System.out.println("*** Lista de Médicos ***");
                for(Medico m : medicos){
                    System.out.println("Nome: "+m.getNome());
                    System.out.println("CRM: "+m.getCpf());
                    System.out.println("----------------------------");
                }
            } else if (escolha == 5) {
                cadastrarConsulta(consultas, medicos, pacientes);
            } else if (escolha == 6) {
                System.out.println("*** Lista de Consultas ***");
                for(Consulta c : consultas){
                    System.out.println("Data: "+c.getData());
                    System.out.println("Medico: "+c.getMedico().getNome());
                    System.out.println("Paciente: "+c.getPaciente().getNome());
                    System.out.println("----------------------------");
                }
            } else if (escolha == 7) {
                System.out.println("Você saiu do sistema!");
            }

        }

    }

    private static void cadastrarPaciente(List<Paciente> pacientes){
        Scanner s = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.println("Nome do paciente: ");
        paciente.setNome(s.next());

        System.out.println("Endereco do paciente: ");
        paciente.setEndereco(s.next());

        System.out.println("CPF do paciente: ");
        paciente.setCpf(s.next());

        System.out.println("Responsável pelo paciente: ");
        paciente.setResponsavel(s.next());

        System.out.println("Quarto do paciente: ");
        paciente.setNumQuarto(s.nextInt());

        System.out.println("Andar do paciente: ");
        paciente.setAndar(s.nextInt());

        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");

    }

    private static void cadastrarMedico(List<Medico> medicos){
        Scanner s = new Scanner(System.in);
        Medico medico = new Medico();

        System.out.println("Nome do medico: ");
        medico.setNome(s.next());

        System.out.println("Endereco do medico: ");
        medico.setEndereco(s.next());

        System.out.println("CPF do medico: ");
        medico.setCpf(s.next());

        System.out.println("CRM do médico: ");
        medico.setCrm(s.next());
        
        System.out.println("Especialidade do médico: ");
        medico.setEspecialidade(s.next());

        System.out.println("Turno do médico: ");
        medico.setTurno(s.next());

        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");

    }

    private static void cadastrarConsulta(List<Consulta> consultas, List<Medico> medicos, List<Paciente> pacientes){
        Scanner s = new Scanner(System.in);
        Consulta consulta = new Consulta();

        System.out.println("Data da consulta: ");
        consulta.setData(s.next());

        System.out.println("Escolha o médico:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + "- " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }
        int escolhaMedico = s.nextInt();
        consulta.setMedico(medicos.get(escolhaMedico - 1));

        System.out.println("Escolha o paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + "- " + pacientes.get(i).getNome());
        }
        int escolhaPaciente = s.nextInt();
        consulta.setPaciente(pacientes.get(escolhaPaciente - 1));

        consultas.add(consulta);
        System.out.println("Consulta cadastrada com sucesso!");
    }
}
