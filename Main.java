import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MorseTranslator translator = new MorseTranslator();

        System.out.println("Digite o código ou frase:");
        String entrada = sc.nextLine();
        System.out.println(translator.traduzirAuto(entrada));

        String resultado = translator.resultado(entrada);
        System.out.println("Tradução: "+ resultado);

        sc.close();
        }
    }
//Regra simples do Morse: espaço separa letras e / separa palavras