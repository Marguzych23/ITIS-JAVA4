package config;

import currency.MyCurrency;
import org.springframework.context.annotation.*;

@Configuration
public class Config {

    @Bean(name = "rub")
    public MyCurrency rubCurrency() {
        return new MyCurrency(2453.94, '\u20BD');
    }

    @Bean(name = "usd")
    public MyCurrency usdCurrency() {
        return new MyCurrency(43.48, '$');
    }

    @Bean(name = "gbp")
    public MyCurrency gbpCurrency() {
        return new MyCurrency(31.00, '£');
    }

    @Bean(name = "eur")
    public MyCurrency eurCurrency() {
        return new MyCurrency(35.05, '€');
    }
}
