import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {

    private Map<String, Character> morse = new HashMap<>();

    public MorseTranslator(){
        morse.put(".-",'A');
        morse.put("-...",'B');
        morse.put("-.-.",'C');
        morse.put("-..",'D');
        morse.put(".",'E');
        morse.put("..-.",'F');
        morse.put("--.",'G');
        morse.put("....",'H');
        morse.put("..",'I');
        morse.put(".---",'J');
        morse.put("-.-",'K');
        morse.put(".-..",'L');
        morse.put("--",'M');
        morse.put("-.",'N');
        morse.put("---",'O');
        morse.put(".--.",'P');
        morse.put("--.-",'Q');
        morse.put(".-.",'R');
        morse.put("...",'S');
        morse.put("-",'T');
        morse.put("..-",'U');
        morse.put("...-",'V');
        morse.put(".--",'W');
        morse.put("-..-",'X');
        morse.put("-.--",'Y');
        morse.put("--..",'Z');


        morse.put(".----",'1');
        morse.put("..----",'2');
        morse.put("...--",'3');
        morse.put("....-",'4');
        morse.put(".....",'5');
        morse.put("-....",'6');
        morse.put("--...",'7');
        morse.put("---..",'8');
        morse.put("----.",'9');
        morse.put("-----",'0');

    }
    //metodo que traduz
    public String resultado(String codigo){

        StringBuilder resultado = new StringBuilder();
        String[] partes = codigo.split(" ");

        for(String c : partes){

            // 👉 NOVO: se for "/", adiciona espaço na frase
            if(c.equals("/")){
                resultado.append(" ");
                continue;
            }

            Character letra = morse.get(c);

            //tratamento backend básico (evita null)
            if(letra != null){
                resultado.append(letra);
            }else{
                resultado.append("?");
            }

        }

        return resultado.toString();
    }

    public String textoParaMorse(String frase){

        StringBuilder resultado = new StringBuilder();

        frase = frase.toUpperCase();

        for(char letra : frase.toCharArray()){

            // espaço vira /
            if(letra == ' '){
                resultado.append("/ ");
                continue;
            }

            // percorre o map procurando a letra
            for(Map.Entry<String, Character> entry : morse.entrySet()){

                if(entry.getValue() == letra){
                    resultado.append(entry.getKey()).append(" ");
                    break;
                }
            }
        }

        return resultado.toString();
    }

    public boolean ehMorse(String entrada){

        for(char c : entrada.toCharArray()){

            if(c != '.' && c != '-' && c != '/' && c != ' '){
                return false; // achou letra normal → não é morse
            }
        }

        return true; // só tem símbolos de morse
    }

    public String traduzirAuto(String entrada){

        if(ehMorse(entrada)){
            return resultado(entrada); // Morse → Texto
        }else{
            return textoParaMorse(entrada); // Texto → Morse
        }
    }

}
