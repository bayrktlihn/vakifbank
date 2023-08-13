package io.bayrktlihn.vakifbank.bootstrap;

import io.bayrktlihn.vakifbank.entity.BankApi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BankApiDataLoader implements CommandLineRunner {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public void run(String... args) throws Exception {
        BankApi bankApi = BankApi.builder()
                .merchantId("123")
                .merchantPassword("asdfqwesadcfxzasc231321321321asdfqwesadcfxzasc231321321321asdfqwesadcfxzasc231321321321asdfqwesadcfxzasc231321321321asdfqwesadcfxzasc231321321321")
                .build();


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        entityManager.persist(bankApi);

        tx.commit();
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();

        tx.begin();
        BankApi savedBankApi = entityManager.find(BankApi.class, 1);
        tx.commit();


        entityManager.close();

    }
}
