package com.spring.cards.service.Impl;

import com.spring.cards.constants.CardsConstants;
import com.spring.cards.dto.CardsDto;
import com.spring.cards.entity.Cards;
import com.spring.cards.exception.CardAlreadyExistsException;
import com.spring.cards.exception.ResourceNotFoundException;
import com.spring.cards.mapper.CardsMapper;
import com.spring.cards.repo.CardsRepository;
import com.spring.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CardsService implements ICardsService {

    CardsRepository cardsRepository;
    @Override
    public void createCard(String mobileNumber) {
        if (cardsRepository.findByMobileNumber(mobileNumber).isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards card= cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("card","mobileNumber",mobileNumber));
       return CardsMapper.mapToCardsDto(card,new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards=cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(() -> new ResourceNotFoundException("Card","Card Number", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto,cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("card","mobileNumber",mobileNumber));
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
