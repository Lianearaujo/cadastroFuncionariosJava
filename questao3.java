class questao3 {    
    int matricula;
    String nome;
    float horas, valor;

    float salarioBruto(){
        return this.horas*this.valor;
    }

    int percentualImpostoDeRenda(){
        int result=0;
        if (this.salarioBruto() > 1500){
            result = 15;
        }else if (this.salarioBruto()>500 && this.salarioBruto()<=1500){
            result = 8;
        }else if (this.salarioBruto()<=500){
            result = 0;
        }
        return result;
    }


    float descontoImpostoDeRenda(){
        return (this.salarioBruto()*this.percentualImpostoDeRenda())/100;
    }

    float descontoImpostoDeRenda(float salarioBruto, float percentualImpostoDeRenda){
        return (salarioBruto*percentualImpostoDeRenda)/100;
    }

    float salarioLiquido(){
        return this.salarioBruto()-this.descontoImpostoDeRenda();
    }

    void mostrarDados(){
        System.out.println("Matricula:"+ this.matricula + "\n Nome:"+ this.nome + "\n Horas:"+ this.horas
                          +"\n Valor:"+ this.valor +"\n Salario Bruto"+ this.salarioBruto() + 
                          "\n Percentual Imposto de Renda:"+ this.percentualImpostoDeRenda()
                          + "\n Desconto Imposto de Renda:" + this.descontoImpostoDeRenda()
                          + "\n Salario Liquido"+ this.salarioLiquido());
    }

} 