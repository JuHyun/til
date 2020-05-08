package chap8;

public class OnlineBankingImpl extends OnlineBanking {

    @Override
    void makeCustomerHappy(OnlineBanking.Customer c) {
        System.out.println("abstract class make cutomer happy." + c.getId());
    }
}
