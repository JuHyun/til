package javaeight.stream.eight.template.method;

public class OnlineBankingLambda extends OnlineBanking {

    @Override
    protected void makeCustomerHappy(Customer c) {
        System.out.println(c.toString());
    }
}
