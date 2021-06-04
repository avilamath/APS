
import java.util.Scanner;

public class APS {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Projeto APS / UAM - Universidade Anhembi Morumbi \n");
        System.out.println("Olá! tudo bem? Este programa irá realizar uma simulação do lançamento de um projétil de canhão com o objetivo de atingir determinado alvo!");
        System.out.println("Espera-se que com esse programa, obtenha-se o alcance horizontal, o tempo do trajeto, a altura máxima atingida pela bala e se o projétil acertou o alvo!.\n");

        //velocidade inicial
        int velocidadeInicial = 0;

        while (velocidadeInicial <= 0) {
            System.out.println("Informe a velocidade inicial do projétil! EX: 20, 80 (Valor em m/s)");
            velocidadeInicial = entrada.nextInt();
            if (velocidadeInicial <= 0) {
                System.out.println("Você deve informar um valor maior que 0!");
            }
        }

        // angulo de inclinação
        int angulo = 0;

        while ((angulo <= 0 || angulo > 90)) {
            System.out.println("Informe o angulo de inclinação do canhão entre 0 e 90 graus! Ex: (30, 50))");
            angulo = entrada.nextInt();
            if ((angulo <= 0 || angulo > 90)) {
                System.out.println("Informe novamente o angulo do disparo! (entre 0 e 90 graus)");
            }
        }

        double anguloRadianos = (angulo * Math.PI) / (180);

        double aceleracao = 9.81;

        // formulas altura máxima, tempo de trajeto e alcance horizonal
        double alturaMaxima = (Math.pow(velocidadeInicial, 2) * Math.pow(Math.sin(anguloRadianos), 2)) / (2 * aceleracao);
        double tempoTrajeto = (2 * velocidadeInicial * Math.sin(anguloRadianos)) / aceleracao;
        double alcanceHorizontal = (2 * Math.pow(velocidadeInicial, 2)) * ((Math.cos(anguloRadianos) * Math.sin(anguloRadianos)) / aceleracao);

        // distancia do alvo!
        int distanciaAlvo = 0;

        while (distanciaAlvo <= 0) {
            System.out.println("Agora informe a distância em que se encontra o alvo!");
            distanciaAlvo = entrada.nextInt();
            if (distanciaAlvo <= 0) {
                System.out.println("Informe uma distância maior que 0!");
            }
        }

        //tamanho do alvo!
        double tamanhoAlvo = 0;

        while ((tamanhoAlvo < 20 || tamanhoAlvo > 50)) {
            System.out.println("Informe o tamanho do seu alvo, sendo o valor igual ou maior que 20, e igual ou menor que 50!");
            tamanhoAlvo = entrada.nextDouble();
            if ((tamanhoAlvo < 20) || (tamanhoAlvo > 50)) {
                System.out.println("Informe um valor maior que 20 e menor que 50!");
            }
        }

        double alvoFinal = (distanciaAlvo + tamanhoAlvo);

        //respostas
        System.out.println("A altura máxima do projétil foi de: " + alturaMaxima);
        System.out.println("O tempo do trajeto do projétil foi de: " + tempoTrajeto);
        System.out.println("O alcance horizontal do projétil foi de: " + alcanceHorizontal);
        System.out.println("O alvo está à " + distanciaAlvo + " metros do canhão, com tamanho de " + tamanhoAlvo + " metros!");

        if (alcanceHorizontal > alvoFinal) {
            System.out.println("O projétil caiu depois do alvo!");
        }

        if (alcanceHorizontal < distanciaAlvo) {
            System.out.println("O projétil caiu antes do alvo");
        }

        if ((alcanceHorizontal <= alvoFinal) && (alcanceHorizontal >= distanciaAlvo)) {
            System.out.println("O projétil acertou o alvo!");
        }
    }
}
