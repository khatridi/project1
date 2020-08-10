/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Divyeshkumar Khatri
 */
public class BlackJackDealer {
    ArrayList<Card> dealerCard;
    
    private int dealerPoint = 0;
    private Card[] dealerCards;
    private int ace;
    
    BlackJackDealer(GroupOfCards newCards){
        dealerCard = new ArrayList<>();
        dealerCards = new Card[]{};
        ace = 0;
        
        for(int i = 0; i < 2; i++){
            dealerCard.add(newCards.drawNew());
        }
        
        dealerCards = dealerCard.toArray(dealerCards);
        
        for(int i = 0; i < dealerCards.length; i++){
            dealerPoint = dealerPoint + dealerCards[i].getPoint();
            
            if(dealerCards[i].getPoint() == 11){
                ace++;
            }
            
            while(ace > 0 && dealerPoint > 21){
                dealerPoint = dealerPoint - 10;
                ace--;
            }
        }
        
    }
    
    
    //Show dealers first card
    public void showCard(){
        Card[] show = new Card[]{};
        show = dealerCard.toArray(show);
        System.out.println(show[0]);
    }

    //Dealer wwill get another card increase points accordingly
    public void HitCard(GroupOfCards newCards){
        dealerCard.add(newCards.drawNew());
        dealerCards = dealerCard.toArray(dealerCards);

        dealerPoint = 0;

        for(int i = 0; i < dealerCards.length; i++){
            dealerPoint = dealerPoint + dealerCards[i].getPoint();


            if(dealerCards[i].getPoint() == 11){
             ace++;
            }

            while(ace > 0 && dealerPoint > 21){
                dealerPoint = dealerPoint - 10;
                ace--;
            }
        }
    }


    //Decides whether dealer will hit or not
    public boolean doHit(){
        if(dealerPoint < 17){
            return true;
        }
        return false;
    }

    // Checks whether dealer has blackjack or not
     public boolean blackJack(){
        if(dealerCard.size() == 2 && dealerPoint == 21){
            System.out.println("The dealer got blackjack.");
            return true;
        }
        return false;
    }

     
    // Show dealers card
    public void show(){
        System.out.println(dealerCard);
    }
    
    // Returns total points of dealer
    public int getDealerpoint(){
        return dealerPoint;
    }
    
    // Check whether the dealer is busted or not
    public boolean bust(int dealerPoint){
        if(dealerPoint > 21){
            System.out.println("Dealer bust");
            return true;
        }
        return false;
    }
    
    
    // Dealer takes turn
    public int turn(GroupOfCards newCards){
        while(doHit()){
            System.out.println("Dealer decides to hit");
            HitCard(newCards);
            
            if(bust(dealerPoint)){
            break;
            }
        }
        if(dealerPoint <= 21){
            System.out.println("Dealer Stands");
        }
        return dealerPoint;
    }
}
