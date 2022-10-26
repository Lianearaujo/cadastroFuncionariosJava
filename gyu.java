import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleJavaServer {

    public static float somar(float x, float y){
        return x+y;
    }
    public static float diminuir(float x, float y){
        return x-y;
    }
    public static float multiplicar(float x, float y){
        return x*y;
    }
    public static float dividir(float x, float y){
        return x/y;
    }

    // public static float[] organizar(float[] x, int indice, float result){
    //     int indicador = 0;
    //     float[] operacao_result = new float[15];
    //     for (int i=0; i< x.length; i++){
    //         if (i == indice){
    //             operacao_result[i]= result;
    //         }else if(i==(indice+1)){
    //             indicador++;
    //         }else {
    //             operacao_result[i-indicador]=x[i];
    //         }
    //     }
    //     return operacao_result;
    // }

    // public static float sintaxe(String str){
    //     int j =0, i =0, k=0,  p=0, incre=2;
    //     char[] funcao=new char[10];
    //     float[] op1_result = new float[15];
    //     float result_final=0, z=0;
    //     String op1="";
    //     Boolean verification = false;
    //     for (j=0; j < str.length(); j++){
    //         if (str.charAt(j) != '-' && str.charAt(j) != '+' &&
    //         str.charAt(j) != '/' && str.charAt(j) != '*'){
    //             op1 = op1+str.charAt(j);
    //             op1_result[j-k] = op1_result[j-k]+z;
    //             if ((j+1) == str.length()){
    //                 op1_result[i] = Float.parseFloat(op1);    
    //             }
    //         } else{
    //             funcao[i] = str.charAt(j);
    //             op1_result[i] = Float.parseFloat(op1);
    //             op1="";
    //             k++;
    //             i++;
    //         }
    //     }

    //     for (j=0; j< i; j++){
    //         float result=0;
    //         if (funcao[j]=='/' || funcao[j]=='*'){
    //             if (funcao[j]=='/'){
    //                result = dividir(op1_result[j], op1_result[j+1]);
    //             }else if (funcao[j]=='*'){
    //                 result = multiplicar(op1_result[j], op1_result[j+1]);   
    //             }
    //             op1_result= organizar(op1_result, j, result);
    //             p++;
    //         }
    //         if (funcao[j]!='-' || funcao[j] != '+'){
    //             verification = true;
    //         }
    //         if ((j+1) == i && verification){
    //             for (int l =0; l<k; l++){
    //                 if (funcao[l+incre]=='*'){
    //                     result_final = result_final + multiplicar(op1_result[l], op1_result[l+1]);    
    //                 }else{
    //                     result_final = result_final + dividir(op1_result[l], op1_result[l+1]); 
    //                 }
    //                 result_final = result_final + op1_result[l+incre];
                    
    //                 if ((j+1)==i && (i+1) % 2!=0){
    //                     if (funcao[j+incre]=='/'){
    //                         result_final = dividir(result_final, op1_result[l+1]);
    //                      }else if (funcao[j]=='*'){
    //                          result_final = multiplicar(result_final, op1_result[l+1]);   
    //                      }
    //                      return result_final; 
    //                 }
    //                 incre= incre+2;
    //             }
    //         return result_final;
    //         }
    //     }
        

    //     for (j=0; j< (i+1); j++){
    //         if (funcao[j]=='+'){
    //             result_final = result_final + somar(op1_result[j], op1_result[j+1]);
    //          }else if (funcao[j]=='-'){
    //             result_final = result_final - diminuir(op1_result[j], op1_result[j+1]);   
    //          }
    //     }


    //     return result_final;
    // }


    public static void main(String[] args) 	{
        try {
            ServerSocket s = new ServerSocket(9999);
            String str;
            float x=0,y=0, result=0;
            while (true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do { 
                    byte[] line = new byte[100];
                    byte[] byteArrray = new byte[100];
                    i.read(line);
                    str = new String(line).trim();
                    System.out.println(str);

                    result = sintaxe(str);
                    o.write(String.valueOf(result).trim().getBytes());
                    
                    // x = Float.parseFloat(operador1);
                    // y = Float.parseFloat(operador3);
                    // if (operador2 == '+'){
                    //     result = somar(x, y);
                    //     o.write(String.valueOf(result).getBytes());
                    // }
                    // else if(operador2 == '-'){ 
                    //     result = (byte) multiplicar(x, y);
                    //     o.write(String.valueOf(result).getBytes());
                    // }else if (operador2 == '/'){
                    //     result = (byte) diminuir(x, y);
                    //     o.write(String.valueOf(result).getBytes());
                    // }else if (operador2 == '*'){
                    //     result = (byte) multiplicar(x, y);
                    //     o.write(String.valueOf(result).getBytes());
                    // }
                    // else {
                    //     o.write("Erro: Sintaxe".getBytes());
                    // }
                    
                } while ( !str.trim().equals("bye") );
                c.close();
            }
        }
        catch (Exception err){
            System.err.println(err);
        }
    }
}    
