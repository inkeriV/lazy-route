## Toteutus

### Main
Main sisältää main-metodin, joka rakentaa syötetyistä argumenteista Grpah-olion, kutsuu sille laskennan aloittavaa metodia ja lopulta tulostaa sen palauttaman Path-olion.

### Graph

Verkkoa käsitellään suorituksen aikana useammassa muodossa. Syötteenä saatava verkko on kokonaisluku lista, josta tehdään m*m kokoisen verkon mittojen mukaan myös 2d-taulukko. Verkkoa ja sen solmuja käsitellään myös Node-olio listana sekä kokonaisluku vieruslistana, jossa luku vastaa solmun indeksiä ohjelmaa kutsuessa annetussa kokonaislukulistassa. 
Vieruslistaa luotaessa alku- ja loppusolmujen koordinaatteja sekä 2d matriisin mittoja käytetään sen tarkistamiseen, mitä naapureita kullakin solmulla on. Vieruslista on myös kokonaislukumatriisi, jonka pituus on solmujen määrä ja leveys maksimi vierussolmujen määrä, eli 4 (ohjelma käyttää Manhattan-etäisyyttä). Tästä syntyy pikkaisen turhaa tilaa, sillä kaikille solmuille on varattu tilaa neljälle vierussolmulle, mutta turhaa tilaa on suhteellisen vähän, sillä isossa verkossa suurimmalla osalla solmuista on kaikki neljä naapuria.
Jos solmulla ei ole kaikkia naapureita, tyhjiin lista-alkioihin laitetaan -1.


### Node

Verkko koostuu node-olioista, jotka pitävät sisällään 3 eri kokonaislukuarvoa; id, weight ja dist. Nämä alustetaan Dijkstralle ja A-starille hieman eri tavalla.
Id-arvo on tosin aina sama kokonaisluku, kuin kyseisen solmun (sen painon) indeksi argumenttina saadussa listassa.
Weight-arvo on alkuperäisessä verkko-listassa ole paino. Dijkstrassa weight-arvo on juurikin tämä arvo. A-starissa se alustetaan olioille "äärettömään". Tänä äärettömänä arvona on ohjelmassa käytetty lukua 1000000000.
Dist-arvo (distance) on Dijkstrassa puolestaan ääretön, ja A-starilla laskettaessa se on solmujen etäisyys lähtösolmusta.
Solmu-oliot järjestetään minimikekoon sen mukaan, mille weight+dist on pienin. Ennen kekoon lisäämistä, alkusolmulle weight tai dist algoritmista riippuen laitetaan nollaksi, jotta se on keossa päälimmäisenä.


### Dijkstra

Pähkinänkuoressa dijkstra toimii seuraavasti: niin kauan, kun loppusolmua ei olla käsitelty.. 
* otetaan minimikeosta päällimmäinen solmu  
* merkitään se käsitellyksi
* käydään jokainen solmun vierussolmu läpi
* jos vierussolmun kohdalla vierussolmun etäisyys on suurempi kuin sen oma paino + käsittelyssä olevan solmun etäisyys (tähän solmuun kuljetun reitin paino)
* niin laitetaan vierussolmun oma paino + käsittelyssä olevan solmun etäisyys kyseisen vierussolmun etäisyydeksi

huom! näin ei voi käytännössä tehdä, koska solmujen arvoja ei voi muuttaa enää sen jälkeen, kun ne on laitettu kekoon. Tämän vuoksi dijkstraa varten tarvitaan uusi kokonaislukutaulukko "dists", jonka jokainen alkio on alustettu äärettömään ja jonka arvoja voidaan muuttaa. Jotta muutettu arvo vaikuttaisi keossa oleviin solmu-olioihin, luodaan uusi solmuolio, jolle asetetaan nämä uuden arvot, mutta solmun id on sama kuin kyseisen vierussolmun id.

* lisätään tämä uusi solmu kekoon ja merkitään lyhimmän reitin säilyttävään taulukkoon, että lyhin tunnettu reitti tähän vierussolmuun, on käsittelyssä olevan solmun kautta
* ja kierros alkaa alusta


### A-star

A-star toimii samalla tavalla kuin Dijkstra, paitsi että siinä solmut ovat järjestetty kekoon äärettömän paino-arvon, ja etäisyysarvon loppusolmusta mukaan. Etäisyysarvo on laskettu solmujen 2d-verkon koordinaattien avulla solmun |vaakasuuntainen etäisyys|+|pystysuuntainen etäisyys| maalisolmusta. A-star tarvitsee myös pari lisätaulukkoa, joissa on dists ja weight arvot.


### Path

Dijkstra ja A-star -metodit ovat molemmat luokassa Path. Path-olioon kuullu kokonaislukulista, johon lyhin reitti tallennetaan, reitillä käytyjen solmujen määrä, sekä niiden yhteispaino.
Path-olio-toString on ohjelman output. Tulosteessa on yksinkertaisesti kuvattu lyhin reitti, kuinka monta solmua reitillä on, mikä on reitin paino ja millä algoritmilla se laskettiin.


### Tietorakenteet

Itse implementoituja tietorakenteita ovat minimikeko ja pino.
Pino-olio pitää sisällään kokonaislukulistaa ja kokonaislukua, joka kertoo listan indeksin, jonne seuraavaksi voidaan laittaa alkio. Kun pinosta "popataan" alkio pois, tulostetaan luku listasta indeksin kertovan muuttujan kohdalta. Jos pino tulee täyteen, luodaan uusi lista, joka tuplasti suurempi kuin edellinen, kopioidaan vanhan sisältö siihen, ja osoitetaan se pino-olion listaksi.

Minimikeko-oliolla on myös kokonaislukulista, johon alkiot laitetaan, listan koon kertova muuttuja, sekä keossa olevien alkioiden lukumäärän kertova muuttuja. Keon kokoa kasvatetaan samalla tavalla kuin pinoa. Uusi alkio lisätään aina keon perälle, josta sitä siirretään keossa ylemmäs niin kauan, kunnes sille löydetään paikka, jossa minimikekorakenne toteutuu. Kun keosta poistetaan minimiarvo, keon alin arvo siirretään ylimmäksi, ja siirretään sitä samalla tavalla alemmas, kunne kekorakenne on jälleen oikein.


### Testauksesta
[täällä](https://github.com/inkeriV/lazy-route/blob/master/docs/testaus.md)
