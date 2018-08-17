## Manuaali

#### Aloitus
* Kloonaa projekti komennolla:
```
git clone https://github.com/inkeriV/lazy-route.git
``` 
* Siirry ohjelman source code kansioon
```
kansio_minne_latasit_repon/lazy-route/lazy-route$
```
* Suorita seuraavalla komennolla ja haluamillasi argumenteilla, esim:
```
mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko -Dexec.args="1,2,1,1,1,2,3,4,2,1,4,2,4,2,4,2 2 7 2 4 d"
```
* Huom! Välilyönti erottaa argumentit toisistaan.
* Huom! Tällä hetkellä verkko syötetty main-metodissa, eli voidaan suorittaa ilman argumentteja:
```
mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko
```


#### Mitkä parametrit??

* Ohjelmassa ensiksi alkava, verkon luova metodi saa 6 parametria
* Ensimmäisenä on lista numeroita, jotka ovat verkon solmujen painot
* Seuraavat kaksi parametria ovat alkusolmun ja loppusolmun järjestysnumerot (ensimmäinen solmu = 1, ei 0, jne.)
* Seuraavat kaksi ovat verkon mitat, esimerkissä 4 ja 4, eli verkko on 4x4 => 16 solmua
* Viimeinen parametri on joko kirjain d tai a, sen mukaan halutaanko reitti laske dijkstralla vai a-starilla

#### Output
* Tällä hetkellä tuloksena tulostetaan lyhin reitti solmujen järjestysnumeron mukaan muotoa 
