package mk.ukim.finki.carconfiguratorfinal.Tasks.Dealer;

import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Dealer.Dealer;

public interface AsyncResponseDealer {
    /**
     * processFinish is a method that connects the Async task and the MainActivity thread
     * @param dealer - Object from the Dealer class
     */
    void processFinish(Dealer dealer);
}
