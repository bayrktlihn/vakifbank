package io.bayrktlihn.vakifbank.repository;

import io.bayrktlihn.vakifbank.enums.AccountType;
import io.bayrktlihn.vakifbank.enums.Bank;
import io.bayrktlihn.vakifbank.enums.CardSchema;
import io.bayrktlihn.vakifbank.enums.CardType;
import io.bayrktlihn.vakifbank.exception.BinNotFoundException;
import io.bayrktlihn.vakifbank.model.Bin;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BinRepository {
    public static final String FILE = "binlist.txt";
    // Maybe database
    private List<Bin> binList;

    @PostConstruct
    void postConstruct() {
        try (
                InputStream inputStream = new ClassPathResource(FILE).getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))
        ) {


            List<Bin> binList = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("\t");

                String bankCode = parts[0].trim();
                String bankName = parts[1].trim();
                String startOfBin = parts[2].trim();
                String endOfBin = parts[3].trim();
                String cardSchema = parts[4].trim();
                String cardType = parts[5].trim();
                String accountType = parts[6].trim();
                String cardNumberLength = parts[7].trim();

                Bin bin = Bin.builder()
                        .bank(Bank.parse(bankCode))
                        .startOfBin(startOfBin)
                        .endOfBin(endOfBin)
                        .cardSchema(CardSchema.parse(cardSchema))
                        .cardType(CardType.parse(cardType))
                        .accountType(AccountType.parse(accountType))
                        .cardNumberLength(Integer.valueOf(cardNumberLength))
                        .build();

                binList.add(bin);

                line = br.readLine();
            }


            this.binList = Collections.unmodifiableList(binList);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Bin getBinByCardNumber(String cardNumber) {
        return binList.stream().filter(item -> item.matches(cardNumber)).findFirst().orElseThrow(() -> new BinNotFoundException(cardNumber));
    }


}
