package by.herzhot;

import com.ibasco.agql.protocols.valve.dota2.webapi.Dota2WebApiClient;
import com.ibasco.agql.protocols.valve.dota2.webapi.Dota2WebApiInterface;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Econ;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Stats;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2GameItem;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2Heroes;
import com.ibasco.agql.protocols.valve.dota2.webapi.pojos.Dota2RealtimeServerStats;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String token = "dota2-webapi";
        Dota2WebApiClient client = new Dota2WebApiClient(token);
        Dota2Econ dota2Econ = new Dota2Econ(client);
//        CompletableFuture<List<Dota2Heroes>> completableFuture = dota2Econ.getGameHeroes(false, "en");
//        completableFuture.thenAccept(resultList -> resultList.forEach(System.out::println));
//        System.out.println(completableFuture.get());
        List<Dota2Heroes> heroes = dota2Econ.getGameHeroes(false, "en").get();
        heroes.forEach(System.out::println);
    }

}
