package br.edu.ifpr.pesquisa;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.pesquisa.model.Perguntas;

/**
 * Created by cristiano on 26/03/18.
 */

public abstract  class BancoQuestoes {

   public static List<Perguntas> getBancoQuestoes(String disci){
        List<Perguntas> p = new ArrayList<>();
        p.add(new Perguntas("Qual ano do ensino médio você está cursando?",new String[]{"1º Ano","2º Ano","3º Ano"}));

        p.add(new Perguntas("Em que faixa de idade você se encontra?",new String[]{"Entre 14 e 15 anos", " Entre 16 e 17 anos ", "18 anos ou mais"}));

        p.add(new Perguntas("Você é do sexo?",new String[]{"Masculino", "Feminino"}));

        p.add(new Perguntas("Você tem acesso à internet?",new String[]{"Sim", "Não"}));

        p.add(new Perguntas("Você já utilizou a plataforma YouTube para ver vídeos de qualquer natureza?",new String[]{"Sim", "Não", "Desconheço a plataforma YouTube"}));

        p.add(new Perguntas("Você já utilizou o YouTube para tirar dúvidas ou aprender conteúdos escolares?",new String[]{"Sim", "Não", "Desconheço a plataforma YouTube"}));

        p.add(new Perguntas("Qual tipo de aparelho você mais utiliza para acessar vídeos educacionais no YouTube?",new String[]{"Computador", "Celular", "Tablet","Outros"}));

        p.add(new Perguntas("Com que frequência você utiliza o YouTube para fins educacionais?",new String[]{" Sempre que tenho dúvidas ",
                "Somente na véspera de provas ", "Uso para me preparar para vestibulares ou concursos"}));
       p.add(new Perguntas("Na hora de escolher uma videoaula sobre conteúdos escolares o tempo de duração dos vídeos é importante?",new String[]{"5 minutos ou menos",
               " Entre 5 e 10 minutos", "Acima dos 10 minutos"," O tempo de duração não interfere na minha escolha"}));
       p.add(new Perguntas("Qual o principal critério que você utiliza para escolher os canais, educacionais, do YouTube?",new String[]{"Indicação de amigos",
               "Indicação de professor(a)", "Escolha aleatória "}));
       p.add(new Perguntas("Nas videoaulas a sua preferência pelo método de explicação do professor é?",new String[]{"O professor utiliza o quadro de giz ou quadro branco",
               "O professor utiliza uma folha de papel", "O professor utiliza captura de tela do computador"," Não tenho preferência nesse sentido"}));
       if(disci == "matematica"){
           p.add(new Perguntas("Seu professor(a) de matemática já indicou algum canal do YouTube que possa ajudar a complementar seu conhecimento sobre os conteúdos trabalhados em sala de aula?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Com relação ao ano/série que você está cursando, você tem ou recebeu da escola livros ou apostilas de matemática?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Você utiliza o YouTube como ferramenta de ensino aprendizagem para aprender os conteúdos de matemática?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Nos momentos de estudo em que surgem dúvidas sobre os conteúdos de matemática, você prefere estudar usando:",
                   new String[]{"Livros ou apostilas", " Caderno com o conteúdo passado pelo professor","Videoaula no YouTube","Outros"}));
       }else if(disci == "fisica"){

           p.add(new Perguntas("Você utiliza o YouTube como ferramenta de ensino aprendizagem para aprender os conteúdos de Física?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Seu professor(a) de Física já indicou algum canal do YouTube que possa ajudar a complementar seu conhecimento sobre os conteúdos trabalhados em sala de aula?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Com relação ao ano/série que você está cursando, você tem ou recebeu da escola livros ou apostilas de Física? ",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Sobre sua preferência nas videoaulas da disciplina de Física:",
                   new String[]{"Prefiro vídeos com teoria", "Prefiro vídeos com resolução de exercícios","prefiro vídeos com experimentos"}));

           p.add(new Perguntas("Nos momentos de estudo em que surgem dúvidas sobre os conteúdos de Física, você prefere estudar usando:",
                   new String[]{"Livros ou apostilas", " Caderno com o conteúdo passado pelo professor","Videoaula no YouTube","Outros"}));


       }else if(disci == "biologia"){
           p.add(new Perguntas("Você utiliza o YouTube como ferramenta de ensino aprendizagem para aprender os conteúdos de Biologia?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Seu professor(a) de Biologia já indicou algum canal do YouTube que possa ajudar a complementar seu conhecimento sobre os conteúdos trabalhados em sala de aula?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Com relação ao ano/série que você está cursando, você tem ou recebeu da escola livros ou apostilas de Biologia? ",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Sobre sua preferência nas videoaulas da disciplina de Biologia:",
                   new String[]{"Prefiro vídeos com teoria", "Prefiro vídeos com resolução de exercícios","prefiro vídeos com experimentos"}));

           p.add(new Perguntas("Nos momentos de estudo em que surgem dúvidas sobre os conteúdos de Biologia, você prefere estudar usando:",
                   new String[]{"Livros ou apostilas", " Caderno com o conteúdo passado pelo professor","Videoaula no YouTube","Outros"}));
       }
       else  if(disci == "portugues"){
           p.add(new Perguntas("Com relação ao ano/série que você está cursando, você tem ou recebeu da escola livros ou apostilas de língua portuguesa?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas(" Mesmo quando a dúvida sobre gramática ocorre em sala de aula, você ainda prefere buscar solução em videoaulas no YouTube?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas(" Você acessa o YouTube para tirar dúvidas com macetes sobre gramática?",
                   new String[]{"Sim", "Não"}));
           p.add(new Perguntas("Você encontra videoaulas com explicações teóricas sobre gramática, no YouTube?\n",
                   new String[]{"Sim", "Não","Nunca procurei"}));


       }
        return  p;
    }
}
