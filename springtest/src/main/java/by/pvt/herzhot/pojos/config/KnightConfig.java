package by.pvt.herzhot.pojos.config;

import by.pvt.herzhot.pojos.BraveKnight;
import by.pvt.herzhot.pojos.Knight;
import by.pvt.herzhot.pojos.Quest;
import by.pvt.herzhot.pojos.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
