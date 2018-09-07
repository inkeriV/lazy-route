### Testausdokumentti

#### Yksikkötestaus

Ohjelman testauksessa on käytetty javan JUnit:ia yksikkötestaukseen ja JaCoCo:a testikattavuuden tarkasteluun. Lopullinen koodikattavuus on 93.10% Suurin osa puuttuvista testeistä koskee luokkan [PerformanceTesting](https://github.com/inkeriV/lazy-route/blob/master/lazy-route/src/main/java/lazyroute/main/PerformanceTesting.java) main metodia. Jätin sen testaamatta, sillä se ei ole olennaista. Metodi tulostaa algoritmien suoritusaikoja.


#### Suorituskykytestaus

Testauskoodi paketissa/luokassa ```lazyroute.main.PerformanceTesting```.
Dijkstralle ja A-Starille molemmille kutsutaan samaa 1000 x 1000 verkkoa, jossa solmujen painot on generoitu satunnaisesti väliltä 1-99. Suorituskykyä voi testata komennolla ```mvn compile exec:java -Dexec.mainClass=lazyroute.main.PerformanceTesting -Dexec.args="1"```. Halutut testauskerrat voi antaa argumenttina (esimerkkikäskyssä kutsutaan kerran). Jokaiselle testauskerralle luodaan uusi verkko.
Tiralabran [ohjeiden](https://github.com/TiraLabra/2018_loppu/wiki/Suorituskykytestauksesta) mukaan nykyhetken aika tallennetaan ennen ohjelman kutsumista ja sen jälkeen ja tulostetaan näiden erotus.
Outputtina on tuloste siitä, kuinka kauan kummallakin algoritmilla kesti millisekunteina.

Testasin suorituskykyä kutsumalla main-metodia kolmeen erilliseen kertaan, joissa kaikissa algoritmeja testattiin 10 kertaa. Alla tuloksia.

##### 1. kerta






