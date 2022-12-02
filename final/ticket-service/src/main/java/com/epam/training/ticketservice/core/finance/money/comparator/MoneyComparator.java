/*package com.epam.training.ticketservice.core.finance.money.comparator;

import com.epam.training.ticketservice.core.finance.bank.Bank;
import com.epam.training.ticketservice.core.finance.money.Money;
import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class MoneyComparator implements Comparator<Money> {

    private final Bank bank;

    @Override
    public int compare(Money money1, Money money2) {
        Money convertedMoney = money2.convert(money1.getCurrency(), bank);
        return Double.compare(money1.getAmount(), convertedMoney.getAmount());
    }
}
 */