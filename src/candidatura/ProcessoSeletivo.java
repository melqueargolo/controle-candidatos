package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
         String[] candidatos = { "felipe", "marcia", "julia", "paulo", "augusto" };
         for(String candidato: candidatos){
           entrandoemcontato(candidato);
        }
    }
    static void entrandoemcontato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando =! atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.err.println("Contato realizado com sucesso! ");
            }

        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", número maximo " + tentativasRealizadas + " realizada");
    }

    static boolean atender(){
        return new Random().nextInt(3)== 1;

    }

    static void imprimirSelecionados(){
        String[] candidatos = { "felipe", "marcia", "julia", "paulo", "augusto" };
        System.out.println("Impimindo a lista de candidatos informando o elemento");

        // for(int indice=0; indice < candidatos.length; indice++){
        //     System.out.println("o candidato de n° " + (indice+1) + " é o " + candidatos[indice]);

        // }
        System.out.println("Forma abreviada de iteração foreach");

        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "felipe", "marcia", "julia", "paulo", "augusto", "monica", "fabricio", "mirela","daniela", "jorge" };
    

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados< 5 && candidatosAtual < candidatos.length ){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+candidato+ " solicitou este valor de sálario "+salarioPretendido);
            if(salarioBase>=salarioPretendido)
            {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;

        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");

        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");

        } else {
            System.out.println("aguardando o resultado dos demais candidatos");
        }

    }
}
