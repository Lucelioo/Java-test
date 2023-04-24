import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario novoUsuario = new Usuario();
        Cronometro cronometroUsuario = new Cronometro();
        novoUsuario.gerarID();
        novoUsuario.cadastrar();
        cronometroUsuario.Cronometro();
    }
}

class Usuario{
        String Nome;
        int Idade;

        public void cadastrar(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do usuario:\n");
            Nome = scanner.nextLine();
            System.out.print("Digite a idade do usuario:\n");
            Idade = scanner.nextInt();
        }

        public void gerarID(){
            Random random = new Random();
            System.out.print("id:");

            for(int i = 1; i <= 6; i++){
                int numero = random.nextInt(100) + 1;
                System.out.print(numero);
            }
            System.out.print("\n");
        }
}

class Cronometro{
    int tempoRestante;

    public void Cronometro(){
        System.out.print("Digite o tempo desejado:\n");
        Scanner scanner = new Scanner(System.in);
        tempoRestante = scanner.nextInt();
        
        System.out.print("Cronometro iniciado!");

        TimerTask task = new TimerTask(){
            public void run(){
                if(tempoRestante > 0){
                    System.out.print("Tempo restante: " + tempoRestante-- + "\n");
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

class listaEquip{
    String[] Equipamento;
    boolean disponibilidade;

    public void verificarDisponibilidade(){
        if(disponibilidade == true){
            System.out.print("Equipamento disponivel!");
        }
        else{
            System.out.print("Equipamento nao disponivel");
        }
    }

    public void buscarEquipamento(String[] x){
        Equipamento = x;
        if(disponibilidade = true){
            System.out.print("Equipamento encontrado: "+Equipamento);
        }
    }
}
