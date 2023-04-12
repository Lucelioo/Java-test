import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        usuario novoUsuario = new usuario();
        cronometro cronometroUsuario = new cronometro();
        novoUsuario.gerarID();
        novoUsuario.cadastrar();
        cronometroUsuario.Cronometro();
    }
}

public class usuario{
        String Nome;
        int Idade;
        int id;

        void cadastrar(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do usuario:\n");
            Nome = scanner.nextLine();
            System.out.print("Digite a idade do usuario:\n");
            Idade = scanner.nextInt();
            System.out.print("Digite o id do usuario:\n");
            id = scanner.nextInt();
        }

        void gerarID(){
            Random random = new Random();

            for(int i = 1; i <= 6; i++){
                int numero = random.nextInt(100) + 1;
                System.out.print(numero + " ");
            }
        }
}

public class cronometro{
    int tempoRestante;

    void Cronometro(){
        System.out.print("Digite o tempo desejado:\n");
        tempoRestante = scanner.nextInt();
        
        System.out.print("Cronometro iniciado!");

        TimerTask task = new TimerTask(){
            public void run(){
                if(tempoRestante > 0){
                    System.out.print("Tempo restante: " + tempoRestante--);
                }else{
                    System.out.print("Tempo esgotado!");
                    cancel();
                }
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}

public class listaEquip{
    String[] Equipamento;
    boolean disponibilidade;

    void verificarDisponibilidade(){
        if(disponibilidade == true){
            System.out.print("Equipamento disponivel!");
        }
        else{
            System.out.print("Equipamento nao disponivel");
        }
    }

    void buscarEquipamento(String[] x){
        Equipamento = x;
        if(disponibilidade = true){
            System.out.print("Equipamento encontrado: "+Equipamento);
        }
    }
}
