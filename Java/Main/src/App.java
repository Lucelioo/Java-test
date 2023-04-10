import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) throws Exception {
        usuario novoUsuario = new usuario;
        cronometro cronometroUsuario = new cronometro;
        novoUsuario.gerarID();
        novoUsuario.cadastrar();
        cronometroUsuario.Cronômetro();
    }
}

public class usuario{
        String[] Nome;
        int Idade;
        int id;

        void cadastrar(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do usuário:\n");
            Nome = scanner.nextLine();
            System.out.print("Digite a idade do usuário:\n");
            Idade = scanner.nextInt();
            System.out.print("Digite o id do usuário:\n");
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

    void Cronômetro(){
        System.out.print("Digite o tempo desejado:\n")
        tempoRestante = scanner.nextInt();
        
        System.out.print("Cronômetro iniciado!");

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