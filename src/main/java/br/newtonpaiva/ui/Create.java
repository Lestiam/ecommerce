package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Create {
    public static void main(String[] args) {
        EntityManagerFactory factory = //abre a conexão
                Persistence.createEntityManagerFactory("EC-PU");

        EntityManager em = factory.createEntityManager(); //abre a conexão

        em.getTransaction().begin(); //todos os comandos são gerados numa área de stage, e se der um erro, ele dá um rollback e descarta as alterações


        em.getTransaction().commit(); //commita as alterações
        Categoria c = new Categoria();
        c.setId(1);
        c.setNome("Jogos");

        em.persist(c); //faz o insert do objeto no banco de dados

        em.close();
        factory.close(); //fechar as conexões
    }
}
