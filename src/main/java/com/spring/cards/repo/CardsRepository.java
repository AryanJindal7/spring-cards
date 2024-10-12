package com.spring.cards.repo;

import com.spring.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CardsRepository extends JpaRepository<Cards, Long> {

    Optional<Cards> findByMobileNumber(String number);
    Optional<Cards> findByCardNumber(String cardNumber);

}
