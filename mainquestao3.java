
class mainquestao3{
    public static void main(String[] args)throws Exception	{
        int i = 0;
        float somaSalarioBrutos=0, somaDoDescontosDoImposto= 0, totalLiquidoDafolha= 0, maiorsalarioLiquido =0;
        System.out.println("Informe a quantidade de cadastro de funcionarios");
        questao3 funcionario []= new questao3[JUtil.readInt()];
        for(i =0; i<funcionario.length; i++){
			funcionario[i] = new questao3(); 
            funcionario[i].matricula = i+1;
			System.out.println ("Nome:");
			funcionario[i].nome = JUtil.readString();
			System.out.println ("Horas:");
			funcionario[i].horas = JUtil.readInt();
            System.out.println ("Valor:");
            funcionario[i].valor = JUtil.readInt();
            somaDoDescontosDoImposto = somaDoDescontosDoImposto + funcionario[i].descontoImpostoDeRenda();
            somaSalarioBrutos = somaSalarioBrutos + funcionario[i].salarioBruto();
            totalLiquidoDafolha = totalLiquidoDafolha + funcionario[i].salarioLiquido();
            if (i==0){
                maiorsalarioLiquido = funcionario[i].salarioLiquido();
            }else if(funcionario[i].salarioLiquido()>=maiorsalarioLiquido){
                maiorsalarioLiquido = funcionario[i].salarioLiquido();
            }
        }
        for(i =0; i<funcionario.length; i++){
            funcionario[i].mostrarDados();
        }       
        System.out.println(" Total Liquido da Folha"+totalLiquidoDafolha+" - Soma Descontos Impostos"+somaDoDescontosDoImposto+" -Soma Salario Brutos"+somaSalarioBrutos+" - Maior Liquido"+maiorsalarioLiquido);       
    }
}