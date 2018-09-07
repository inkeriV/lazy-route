## Manuaali

#### Jar-tiedosto

* lataa lazy-route.jar [täältä](https://github.com/inkeriV/lazy-route/releases)
* aja komentoriviltä haluamillasi argumenteilla, esim:
```
java -jar your_file_path/lazy-route.jar 1,1,1,1,1,1,1,1,1, 1 9 3 3 a
```
* alla tarkemmin argumenteista


#### Projekti gitistä

* kloonaa projekti komennolla:
```
git clone https://github.com/inkeriV/lazy-route.git
``` 
* siirry ohjelman source code kansioon
```
kansio_minne_latasit_repon/lazy-route/lazy-route$
```
* Suorita seuraavalla komennolla ja haluamillasi argumenteilla, esim:
```
mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main -Dexec.args="1,2,1,1,1,2,3,4,2,1,4,2,4,2,4,2, 2 7 4 4 a"
```

#### Mitkä argumentit?

* Ohjelmassa ensiksi alkava, verkon luova metodi saa 6 parametria
* Ensimmäisenä on lista numeroita, jotka ovat verkon solmujen painot
* Seuraavat kaksi parametria ovat alkusolmun ja loppusolmun järjestysnumerot (ensimmäinen solmu = 1, ei 0, jne.)
* Seuraavat kaksi ovat verkon mitat, esimerkissä 4 ja 4, eli verkko on 4x4 => 16 solmua
* Viimeinen parametri on joko kirjain d tai a, sen mukaan halutaanko reitti laske dijkstralla vai a-starilla

* Huom! Välilyönti erottaa argumentit toisistaan.
* Huom! Laita pilkku viimeisenkin luvun jälkeen listassa

#### Output
* Output jäi valitettavasti vähän köppäiseksi, ja reitti on esitetty vain solmujen järjestysnumeroina alkusolmusta loppusolmuun. Mukana myös, millä algoritmilla se laskettiin, montako solmua matkalla oli ja sen kokonaispaino. Kokonaispainoon ei ole huomioitu alkusolmun painoa.
* Näyttää tällaiselta:
``` 
Computed with Dijkstra's algorithm.
Shortest path between given start node: 1 and end node: 35 is:
1 => 2 => 3 => 4 => 5 => 11 => 17 => 23 => 29 => 35
The weight of this path is: 11
The number of nodes in this path is: 10
```

#### Suorituskyvystä
* [täältä](https://github.com/inkeriV/lazy-route/blob/master/docs/testaus.md)
