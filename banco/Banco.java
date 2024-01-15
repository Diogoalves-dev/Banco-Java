
package banco;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 *
 * @author diogo
 */
public class Banco { 
    public static void main(String[] args) {
        
        ArrayList<Conta> contas = new ArrayList<Conta>();
        int continuar = 0;
        int i = 0;
        int opcoes;
        String entrada;
        
        do{
            UIManager.put("OptionPane.yesButtonText","Criar conta");
            UIManager.put("OptionPane.noButtonText","Procurar conta");
            UIManager.put("OptionPane.cancelButtonText","Sair");
            opcoes = JOptionPane.showConfirmDialog(null, "Bem vindo","Entrada",1);

            if(opcoes == -1){
                opcoes = 2;
            }
            
                switch (opcoes){
                    case 0:
                        String nome = JOptionPane.showInputDialog(null,"Informe seu nome:","",1);
                        int numero;
                        int senha;
                        
                        if((nome == null) ){
                            break;
                        }
                       
                        boolean existe = true;
                        do{
                            entrada = JOptionPane.showInputDialog(null,"Informe um numero para a conta: ","",1);
                            Conta conta = new Conta();
                            
                            if(entrada == null){
                                break;
                            }else{
                                numero = Integer.parseInt(entrada);
                            }
                            if(contas.size()>0){
                                for(i=0; i<contas.size(); i++){
                                    if(contas.get(i).getNumero() != numero){
                                        entrada = JOptionPane.showInputDialog(null, "Crie uma senha contendo apenas números:\n(minino 4 digitos)", "", 1);
                                        
                                        if(entrada == null){
                                            break;
                                        }else{
                                            senha = Integer.parseInt(entrada);
                                        }                                        
                                        conta.Criarconta(nome, numero, senha);
                                        contas.add(conta);
                                        existe = false;
                                        break;
                                    }
                                    
                                    if(existe == true){
                                        JOptionPane.showMessageDialog(null,"Ja existe uma conta com esse número.\nTente novamente","",1);
                                    }
                                }
                            }else{
                                entrada = JOptionPane.showInputDialog(null,"Crie uma senha contendo apenas números:\n(minino 4 digitos)","",1);                               
                                if(entrada == null){
                                    break;
                                }else{
                                    senha = Integer.parseInt(entrada);
                                }
                                conta.Criarconta(nome, numero, senha);
                                contas.add(conta);
                                existe = false;
                            }
                            
                        }while(existe != false);
                        
                    break;
                    
                    case 1:
                        int posicao = 0;
                        boolean achou = false;
                        do{
                            entrada = JOptionPane.showInputDialog(null,"Informe o numero da conta: ","Login",1);
                            if(entrada == null){
                                break;
                            }else{
                                numero = Integer.parseInt(entrada);
                            }
                            
                            for(i=0; i<contas.size(); i++){
                                if(numero == (contas.get(i).getNumero())){
                                    achou = true;
                                    posicao = i;
                                    break;
                                }
                                
                            }
                            
                            if(achou == true){
                                JOptionPane.showMessageDialog(null, "CONTA ENCONTRADA","Bem vindo " + contas.get(posicao).getDono(),1);
                                boolean correta = false;
                                int tentativas = 0;
                                do{
                                    entrada = JOptionPane.showInputDialog(null,"Bem vindo " + contas.get(posicao).getDono() + "\ninforme sua senha: ","Login",1);
                                    if(entrada == null){
                                        break;
                                    }else{
                                        senha = Integer.parseInt(entrada);
                                    }
                                    
                                    for(i=0; i<contas.size(); i++){
                                        
                                        if(contas.get(posicao).getSenha() == senha){
                                            correta = true;
                                            break;
                                        }
                                    }
                                    
                                    if(correta == true){
                                        contas.get(posicao).opcoes();
                                        if(contas.get(posicao).getStatus() == false){
                                            contas.remove(posicao);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "SENHA INCORRETA\n Tente novamente","ERRO",0);
                                        tentativas++;
                                        if(tentativas == 3){
                                            JOptionPane.showMessageDialog(null, "Voce esgotou o numero de tentativas\ntente novamente mais tarde","ERRO",0);
                                            break;
                                        }
                                    }
                                    
                                }while(correta != true);
                                
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "CONTA INEXISTENTE","ERRO 404",0);
                            }
                        }while(achou != true);
                      
                    break;
                    
                    case 2:
                        JOptionPane.showMessageDialog(null, "Finalizando...");
                        continuar = 3;
                    break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "COMANDO INVALIDO!!!","ERRO",2);
                    break;
                }

        }while(continuar != 3);
    }
    
}
