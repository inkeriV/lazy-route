### Testausdokumentti

#### Yksikkötestaus

Ohjelman testauksessa on käytetty javan JUnit:ia yksikkötestaukseen ja JaCoCo:a testikattavuuden tarkasteluun. Lopullinen koodikattavuus on 93.10% Suurin osa puuttuvista testeistä koskee luokkan [PerformanceTesting](https://github.com/inkeriV/lazy-route/blob/master/lazy-route/src/main/java/lazyroute/main/PerformanceTesting.java) main metodia. Jätin sen testaamatta, sillä se ei ole olennaista. Metodi tulostaa algoritmien suoritusaikoja.


#### Suorituskykytestaus

Testauskoodi paketissa/luokassa ```lazyroute.main.PerformanceTesting```.
Dijkstralle ja A-Starille molemmille kutsutaan samaa 1000 x 1000 verkkoa, jossa solmujen painot on generoitu satunnaisesti väliltä 1-99. Suorituskykyä voi testata komennolla ```mvn compile exec:java -Dexec.mainClass=lazyroute.main.PerformanceTesting -Dexec.args="1"```. Halutut testauskerrat voi antaa argumenttina (esimerkkikäskyssä kutsutaan kerran). Jokaiselle testauskerralle luodaan uusi verkko.
Tiralabran [ohjeiden](https://github.com/TiraLabra/2018_loppu/wiki/Suorituskykytestauksesta) mukaan nykyhetken aika tallennetaan ennen ohjelman kutsumista ja sen jälkeen ja tulostetaan näiden erotus.
Outputtina on tuloste siitä, kuinka kauan kummallakin algoritmilla kesti millisekunteina.

Testasin suorituskykyä kolmeen otteeseen testaavalla metodilla, jolla joka kerralla kumpaakin algoritmia testattiin 10 kertaa. Kuvissa joka suorituskerran kohdalla (1-10) on eri verkko, mutta molemmat algoritmit käyttivät samalla kohtaa samaa verkkoa. A-star on lähes aina nopeampi. Alla tuloksia.

##### 1. kerta

(https://github.com/inkeriV/lazy-route/blob/master/documentation/pictures/suorituskyky1.png)

A-star mediaani: 683.5 ms.
Dijkstra mediaani: 734.5 ms. 

##### 2. kerta

(https://github.com/inkeriV/lazy-route/blob/master/documentation/pictures/suoritus2.png)

A-star mediaani: 682 ms.
Dijkstra mediaani: 727 ms.

##### 3. kerta

(https://github.com/inkeriV/lazy-route/blob/master/documentation/pictures/suoritus3.png)

A-star mediaani: 691.5 ms.
Dijkstra mediaani: 733 ms.





