import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario[] usuarios = new Usuario[3];

        usuarios[0] = new Usuario("Menino Ney", 31);
        usuarios[1] = new Usuario("Maria", 30);
        usuarios[2] = new Usuario("Jose", 33);
        
        for(int i = 0; i<3;i++){
            usuarios[i].gerarID();
        }
        
        //Cronometro cronometroUsuario = new Cronometro();

        ListaEquip[] novaLista = new ListaEquip[3];

        novaLista[0] = new ListaEquip("Computador", true);
        novaLista[1] = new ListaEquip("Playstation", true);
        novaLista[2] = new ListaEquip("Xbox", false);

        novaLista[2].verificarDisponibilidade("Xbox");
        
        Caixa diaVenda = new Caixa(10);
        
        diaVenda.registrarVenda(10.5f);
        diaVenda.registrarVenda(7.0f);
        diaVenda.registrarVenda(5.5f);
        
        diaVenda.calcularReceita();
        System.out.print("\n"+diaVenda.getReceita());

    }
}

class Usuario{
        String Nome;
        int Idade;

        public Usuario(String nome, int idade){
            this.Nome = nome;
            this.Idade = idade;

            System.out.print(nome + " " + idade + "\n");
        }

        public void gerarID() {
            Random random = new Random();
            System.out.print("id:");
            StringBuilder id = new StringBuilder();
        
            for(int i = 1; i <= 6; i++) {
                int numero = random.nextInt(10);
                id.append(numero);
            }
        
            System.out.print(id.substring(0, 6) + "\n");
        }
}

class Cronometro{
    int tempoRestante;

    public Cronometro(){
        System.out.print("\nDigite o tempo desejado em horas, minutos e segundos:\n");
        Scanner scanner = new Scanner(System.in);
        int horas = scanner.nextInt();
        int minutos = scanner.nextInt();
        int segundos = scanner.nextInt();
        
        tempoRestante = horas * 3600 + minutos * 60 + segundos;
        
        System.out.print("Cronometro iniciado!");

        TimerTask task = new TimerTask(){
            public void run(){
                if(tempoRestante > 0){
                    int horas = tempoRestante / 3600;
                    int minutos = (tempoRestante % 3600) / 60;
                    int segundos = tempoRestante % 60;
                    System.out.printf("Tempo restante: %02d:%02d:%02d \n", horas, minutos, segundos);
                    
                    tempoRestante--;
                }else{
                    System.out.println("Tempo esgotado!");
                    cancel();
                }
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}


class ListaEquip{
    private String nomeEquipamento;
    private boolean disponibilidade;

    public ListaEquip(String nomeEquipamento, boolean disponibilidade) {
        this.nomeEquipamento = nomeEquipamento;
        this.disponibilidade = disponibilidade;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void verificarDisponibilidade(String equipamento) {
        if (nomeEquipamento.equals(equipamento)) {
            if (disponibilidade) {
                System.out.println("O equipamento " + equipamento + " esta disponivel.");
            } else {
                System.out.println("O equipamento " + equipamento + " nao esta disponivel no momento.");
            }
        } else {
            System.out.println("O equipamento " + equipamento + " nao foi encontrado na lista.");
        }
    }
}

class Caixa{
    private float[] venda;
    private float receita;

    public Caixa(int tamanhoArrayVenda) {
        this.venda = new float[tamanhoArrayVenda];
        this.receita = 0.0f;
    }

    public void registrarVenda(float valor) {
        // adiciona o valor da venda no array de vendas
        for (int i = 0; i < venda.length; i++) {
            if (venda[i] == 0.0f) {
                venda[i] = valor;
                break;
            }
        }
    }

    public void calcularReceita() {
        for (float valor : venda) {
            receita += valor;
        }
    }

    public float getReceita() {
        return receita;
    }
}
